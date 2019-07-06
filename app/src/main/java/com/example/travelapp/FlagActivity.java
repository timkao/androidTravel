package com.example.travelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FlagActivity extends AppCompatActivity {

    private static final String[] COUNTRIES = {
            "USA",
            "Japan",
            "Taiwan",
            "Spain"
    };

    private void addFlag(String countryName, GridLayout layout) {
        View flag = getLayoutInflater().inflate(R.layout.flag, layout);
        System.out.println(countryName);


        // IMPORTANT!! should be flag.findViewById (inside flag.xml) not just findViewById (whole activity)
        TextView tv = flag.findViewById(R.id.flagTxt);
        tv.setText(countryName);

        ImageView imgv = flag.findViewById(R.id.flagImg);
        int flagImgId = getResources().getIdentifier(countryName.toLowerCase(),"drawable", getPackageName());
        imgv.setImageResource(flagImgId);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flag);

        GridLayout layout = findViewById(R.id.flagLayout);

        for (String country : COUNTRIES) {
            addFlag(country, layout);
        }

    }
}
