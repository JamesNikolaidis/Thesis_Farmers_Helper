package com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Timers;

import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Dialogs.Dialogs_Class;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by James Nikolaidis on 1/23/2017.
 */

public class AndroidBackBackSensitivityContol {
       private Timer mTimer ;
       private int mTimerCounter;
         public AndroidBackBackSensitivityContol(){}

        public void ActivateLockMethodAndGetValueWhenReady(){

            mTimer = new Timer();
             mTimerCounter =0;
            mTimer.schedule(new TimerTask() {
                @Override
                public void run() {

                    mTimerCounter++;
                    if(mTimerCounter==2){mTimer.cancel(); Dialogs_Class.LockAndroidBackButtonSensitivity=0;}


                }
            },0,1000);

        }




}
