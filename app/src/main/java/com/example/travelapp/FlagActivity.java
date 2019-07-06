package com.example.travelapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Layout;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class FlagActivity extends AppCompatActivity {

    private static final String[] COUNTRIES = {
            "USA",
            "Japan",
            "Taiwan",
            "Spain"
    };

    private void addFlag(final String countryName, GridLayout layout) {
        View flag = getLayoutInflater().inflate(R.layout.flag, null); // solution: put null, since we are not in hurry to insert into the layout
        System.out.println(countryName);


        // solution: waiting until all the settings are cooked
        // IMPORTANT!! should be flag.findViewById (inside flag.xml) not just findViewById (whole activity)
        TextView tv = flag.findViewById(R.id.flagTxt);
        tv.setText(countryName);

        ImageButton imgv = flag.findViewById(R.id.flagImg);
        int flagImgId = getResources().getIdentifier(countryName.toLowerCase(),"drawable", getPackageName());
        imgv.setImageResource(flagImgId);

        imgv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(FlagActivity.this);
                builder.setMessage("You clicked " + countryName);
                builder.setTitle("My Dialog");

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        // solution: add the flag to the layout after everything is cooked
        layout.addView(flag);

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
