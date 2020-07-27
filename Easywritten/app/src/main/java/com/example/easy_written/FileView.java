package com.example.easy_written;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Dictionary;


//참고 사이트 : https://webnautes.tistory.com/1300

public class FileView extends AppCompatActivity {
    private ArrayList<File_Data> mArrayList;
    private CustomAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_view);
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_list);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);


        mArrayList = new ArrayList<>();

        mAdapter = new CustomAdapter( mArrayList);
        mRecyclerView.setAdapter(mAdapter);


        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(),
                mLinearLayoutManager.getOrientation());
        mRecyclerView.addItemDecoration(dividerItemDecoration);

        mRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), mRecyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {//recycler list 하나씩 위치에 따라 다른 화면 띄우기, 지금은 파일 하나만 했음

                Intent intent = new Intent(getBaseContext(), KeywordTime.class);

                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {
            }
        }));


        File_Data data1=new File_Data("날짜:20.06.01","파일이름 : 파일1");
        File_Data data2=new File_Data("날짜:20.06.02","파일이름 : 파일2");
        File_Data data3=new File_Data("날짜:20.06.03","파일이름 : 파일3");
        File_Data data4=new File_Data("날짜:20.06.04","파일이름 : 파일4");
        File_Data data5=new File_Data("날짜:20.06.05","파일이름 : 파일5");
        File_Data data6=new File_Data("날짜:20.06.06","파일이름 : 파일6");
        File_Data data7=new File_Data("날짜:20.06.07","파일이름 : 파일7");
        File_Data data8=new File_Data("날짜:20.06.07","파일이름 : 파일8");
        File_Data data9=new File_Data("날짜:20.06.07","파일이름 : 파일9");
        mArrayList.add(data1);
        mArrayList.add(data2);
        mArrayList.add(data3);
        mArrayList.add(data4);
        mArrayList.add(data5);
        mArrayList.add(data6);
        mArrayList.add(data7);
        mArrayList.add(data8);
        mArrayList.add(data9);
        mAdapter.notifyDataSetChanged();

    }
    public interface ClickListener {
        void onClick(View view, int position);

        void onLongClick(View view, int position);
    }

    public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private FileView.ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final FileView.ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildAdapterPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildAdapterPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        }
    }

}
