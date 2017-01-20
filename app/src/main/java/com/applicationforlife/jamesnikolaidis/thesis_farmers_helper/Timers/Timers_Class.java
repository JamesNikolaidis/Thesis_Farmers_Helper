package com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Timers;

import android.app.AlertDialog;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by James Nikolaidis on 1/14/2017.
 */

public class Timers_Class {
    private Timer mTipTimer;
    private int Disable_Tip_Dialog_Counter=0;

    public Timers_Class(){}


    public void Count_And_Disable_Tip_Dialog(final AlertDialog mTipDialog){

            mTipTimer = new Timer();
            mTipTimer.schedule(new TimerTask() {
                @Override
                public void run() {
                    if(Disable_Tip_Dialog_Counter==3){
                        mTipDialog.cancel();
                        mTipTimer.cancel();
                    }

                    Disable_Tip_Dialog_Counter++;

                }
            },0,1500);
    }






}
