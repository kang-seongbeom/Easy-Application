package com.example.easy_written;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.widget.ProgressBar;
import android.widget.TextView;

public class KeywordTime extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyword_time);

        //밑줄
        SpannableString content1 = new SpannableString("안드로이드");
        content1.setSpan(new UnderlineSpan(), 0, content1.length(), 0);

        TextView Tandroid1=findViewById(R.id.Tandroid1);
        Tandroid1.setText(content1);
        TextView Tandroid2=findViewById(R.id.Tandroid2);
        Tandroid2.setText(content1);
        TextView Tandroid3=findViewById(R.id.Tandroid3);
        Tandroid3.setText(content1);

        int value=30;
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar) ;
        progressBar.setProgress(value) ;
    }
}
