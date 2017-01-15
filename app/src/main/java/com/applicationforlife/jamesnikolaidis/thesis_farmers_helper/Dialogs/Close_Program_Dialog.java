package com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.StartAcitvity;

/**
 * Created by James Nikolaidis on 1/15/2017.
 */

public class Close_Program_Dialog {

        public Close_Program_Dialog(){}

        public void CloseProgramDialog(final Activity activity , Context context){
            final AlertDialog.Builder mCloseAppDialogBuilder = new AlertDialog.Builder(activity);
            mCloseAppDialogBuilder.setMessage("Sure do you want to leave?")
                    .setNegativeButton("No,I want to stay.", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                                mCloseAppDialogBuilder.setCancelable(true);
                        }
                    })
                    .setPositiveButton("Yes,Exit.", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                           activity.finishAffinity();
                        }
                    })
                    .setIcon(activity.getResources().getIdentifier("exclamation","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"))
                    .create();
            AlertDialog dialog = mCloseAppDialogBuilder.create();
            dialog.show();



        }



    public void GoToMainPanelDialog(final Activity activity , Context context){
        final AlertDialog.Builder mCloseAppDialogBuilder = new AlertDialog.Builder(activity);
        mCloseAppDialogBuilder.setMessage("Sure do you want to leave?")
                .setNegativeButton("No,I want to stay.", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mCloseAppDialogBuilder.setCancelable(true);
                    }
                })
                .setPositiveButton("Yes.", new DialogInterface.OnClickListener() {
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