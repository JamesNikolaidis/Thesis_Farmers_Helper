package com.applicationforlife.jamesnikolaidis.thesis_farmers_helper;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;

public class FarmerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_photo);
        Display display = getWindowManager().getDefaultDisplay();
        Point point = new Point();
        display.getSize(point);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {

                Intent passenger = new Intent(FarmerActivity.this,StartAcitvity.class);
                startActivity(passenger);
            }
        }, 500);

    }
}
