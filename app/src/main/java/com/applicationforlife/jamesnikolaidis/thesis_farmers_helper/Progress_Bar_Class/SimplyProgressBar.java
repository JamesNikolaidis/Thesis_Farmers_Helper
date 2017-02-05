package com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Progress_Bar_Class;

import android.app.Activity;
import android.app.ProgressDialog;

import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.R;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Timers.Timers_Class;

/**
 * Created by James Nikolaidis on 1/11/2017.
 */

public class SimplyProgressBar {

            public SimplyProgressBar(){


            }

    public ProgressDialog ActivateProgressDialog(ProgressDialog mGUIProgressDialog,Activity activity,int StringMessageId){

        mGUIProgressDialog = new ProgressDialog(activity.getLayoutInflater().getContext());
        mGUIProgressDialog.setMessage(activity.getResources().getString(StringMessageId));
        mGUIProgressDialog.setMax(100);
        mGUIProgressDialog.setCancelable(true);
        mGUIProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        mGUIProgressDialog.setProgressDrawable(activity.getResources().getDrawable(R.drawable.progress_bar_style));
        mGUIProgressDialog.setProgress(0);
        mGUIProgressDialog.show();
        return mGUIProgressDialog;
    }



    public ProgressDialog ActivateProgressDialog1(ProgressDialog mGUIProgressDialog,Activity activity){

        mGUIProgressDialog = new ProgressDialog(activity.getLayoutInflater().getContext());
        mGUIProgressDialog.setMessage("Please Wait");
        mGUIProgressDialog.setMax(100);
        mGUIProgressDialog.setCancelable(false);
        mGUIProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        mGUIProgressDialog.setProgressDrawable(activity.getResources().getDrawable(R.drawable.progress_bar_style));
        mGUIProgressDialog.setProgress(0);
        mGUIProgressDialog.show();
        return mGUIProgressDialog;
    }


    public ProgressDialog SimplyProgressDialog(ProgressDialog mGUIProgressDialog,Activity activity,String Message){

        mGUIProgressDialog = new ProgressDialog(activity.getLayoutInflater().getContext());
        mGUIProgressDialog.setCancelable(false);
        mGUIProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mGUIProgressDialog.setMessage(Message);
        mGUIProgressDialog.show();
        return mGUIProgressDialog;
    }

    public ProgressDialog NewProductProgress(ProgressDialog mGUIProgressDialog,Activity activity,String Message){

        mGUIProgressDialog = new ProgressDialog(activity.getLayoutInflater().getContext());
        mGUIProgressDialog.setCancelable(false);
        mGUIProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mGUIProgressDialog.setMessage(Message);
        mGUIProgressDialog.show();
        Timers_Class timers_class = new Timers_Class();
        timers_class.Count_And_Disable_Tip_Dialog1(mGUIProgressDialog);
        return mGUIProgressDialog;
    }








}
