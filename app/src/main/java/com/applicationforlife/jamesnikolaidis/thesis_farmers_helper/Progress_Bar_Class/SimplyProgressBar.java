package com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Progress_Bar_Class;

import android.app.Activity;
import android.app.ProgressDialog;

import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.R;

/**
 * Created by James Nikolaidis on 1/11/2017.
 */

public class SimplyProgressBar {

            public SimplyProgressBar(){


            }

    public ProgressDialog ActivateProgressDialog(ProgressDialog mGUIProgressDialog,Activity activity){

        mGUIProgressDialog = new ProgressDialog(activity.getLayoutInflater().getContext());
        mGUIProgressDialog.setMessage("Please wait while we fetching the Products from Database...");
        mGUIProgressDialog.setMax(100);
        mGUIProgressDialog.setCancelable(false);
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





}
