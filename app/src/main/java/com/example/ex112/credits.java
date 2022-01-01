package com.example.ex112;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class credits extends AppCompatActivity {
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
        tv = findViewById(R.id.TEXT);
        tv.setText("Author : Harel Navon\n" +
                "\n" +
                "Description: This is a small application designed to try out Activity Lifecycle Methods!!");

    }

    public void go(View view) {
        /**
         *  Closes the Activity.
         */
        finish();
    }
}