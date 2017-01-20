package com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Timers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.StartAcitvity;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by James Nikolaidis on 1/21/2017.
 */

public class GoToMainPageTimer {
    private static GoToMainPageTimer mTImerGoToMainPage =null;
    public static Timer mTImer;
    private int mTimeCounter;


    private GoToMainPageTimer(){

    }


    public void ActivateTimer(final Activity activity, Context context, final TextView mTimer){
        mTImer =new Timer();
        mTimeCounter=0;
        mTImer.schedule(new TimerTask() {
            @Override
            public void run() {
                mTimeCounter++;
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mTimer.setText(String.valueOf(mTimeCounter));
                    }
                });
                if(mTimeCounter==10){
                    mTImer.cancel();
                    Intent goToMainPage = new Intent(activity, StartAcitvity.class);
                    activity.startActivity(goToMainPage);
                }



            }
        },0,1000);
    }



    public static GoToMainPageTimer getInstance(Activity activity , Context context){
        if(mTImerGoToMainPage ==null){
            mTImerGoToMainPage = new GoToMainPageTimer();
            return mTImerGoToMainPage;
        }else{return mTImerGoToMainPage;}

    }

}
