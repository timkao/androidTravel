package com.example.travelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

public class FlagActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flag);

        // add a new button
        Button butt =  new Button(this);
        butt.setText("my button");
        LinearLayout layout = findViewById(R.id.flagLayout);
        layout.addView(butt);

    }
}