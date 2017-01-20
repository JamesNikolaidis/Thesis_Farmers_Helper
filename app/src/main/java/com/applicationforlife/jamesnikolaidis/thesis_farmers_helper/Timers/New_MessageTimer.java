package com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Timers;

import android.view.View;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by James Nikolaidis on 1/18/2017.
 */

public class New_MessageTimer {
    private static int secondCounter =0;


    public New_MessageTimer(){}


    public void Activate_New_Message_Timer(final ImageView newImage_View){
            final Timer  mNewMessageTimer = new Timer();

            mNewMessageTimer.schedule(new TimerTask() {
                @Override
                public void run() {
                    secondCounter++;
                        if(secondCounter==1){
                            newImage_View.setVisibility(View.INVISIBLE);
                            mNewMessageTimer.cancel();
                        }



                }
            },0,1000);






    }



}
