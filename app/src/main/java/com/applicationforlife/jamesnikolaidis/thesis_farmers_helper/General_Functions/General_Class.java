package com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.General_Functions;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.R;


/**
 * Created by James Nikolaidis on 11/5/2016.
 */

public  class General_Class implements AdapterView.OnItemClickListener , View.OnClickListener,View.OnTouchListener{
        private static int counter = 0;
        private static int previousTime =0;

    public General_Class(){}


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }



    @Override
    public void onClick(View view){


    }


    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }


    public void SetSmartTip(TextView textView,Activity activity){
        String[] smartTips = activity.getResources().getStringArray(R.array.SmartTips);
        textView.setText(smartTips[counter]);
        counter++;

    }

}
