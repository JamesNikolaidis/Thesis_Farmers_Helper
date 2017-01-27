package com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.R;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.StartAcitvity;

/**
 * Created by James Nikolaidis on 1/15/2017.
 */

public class Close_Program_Dialog {

        public Close_Program_Dialog(){}

        public void CloseProgramDialog(final Activity activity , Context context,int Language){

            final AlertDialog.Builder mCloseAppDialogBuilder = new AlertDialog.Builder(activity);


        if(Language==0){
            mCloseAppDialogBuilder.setMessage(activity.getResources().getString(R.string.ExitMessageGr))
                    .setNegativeButton(activity.getResources().getString(R.string.ExitNoMessageGr), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                                mCloseAppDialogBuilder.setCancelable(true);
                        }
                    })
                    .setPositiveButton(activity.getResources().getString(R.string.ExitYesMessageGr), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                           activity.finishAffinity();
                        }
                    });

        }else{
            mCloseAppDialogBuilder.setMessage(activity.getResources().getString(R.string.ExitMessageEng))
                    .setNegativeButton(activity.getResources().getString(R.string.ExitNoMessageEng), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            mCloseAppDialogBuilder.setCancelable(true);
                        }
                    })
                    .setPositiveButton(activity.getResources().getString(R.string.ExitYesMessageEng), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            activity.finishAffinity();
                        }
                    });
        }


            mCloseAppDialogBuilder
                    .setIcon(activity.getResources().getIdentifier("exclamation","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"))
                    .create();



            AlertDialog dialog = mCloseAppDialogBuilder.create();
            dialog.show();

        }



    public void GoToMainPanelDialog(final Activity activity , Context context ,String Message,String Negative,String Positive){
        final AlertDialog.Builder mCloseAppDialogBuilder = new AlertDialog.Builder(activity);
        mCloseAppDialogBuilder.setMessage(Message)
                .setNegativeButton(Negative, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mCloseAppDialogBuilder.setCancelable(true);
                    }
                })
                .setPositiveButton(Positive, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                       activity.startActivity(new Intent(activity, StartAcitvity.class));
                    }
                })
                .setIcon(activity.getResources().getIdentifier("exclamation","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"))
                .create();
        AlertDialog dialog = mCloseAppDialogBuilder.create();
        dialog.show();



    }




}
