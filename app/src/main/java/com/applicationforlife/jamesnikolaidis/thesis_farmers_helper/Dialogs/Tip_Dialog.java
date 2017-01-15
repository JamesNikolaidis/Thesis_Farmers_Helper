package com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.view.WindowManager;

import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.R;

/**
 * Created by James Nikolaidis on 1/14/2017.
 */

public class Tip_Dialog {
    private static  AlertDialog mTipDialog;
    public Tip_Dialog(){}

    public AlertDialog ActivateTipDialog(Activity activity, Context context){
        final AlertDialog.Builder builder2 = new AlertDialog.Builder(activity);
        mTipDialog= builder2.create();
        mTipDialog.getWindow().getAttributes().windowAnimations = R.style.Tip_Animation;
        WindowManager.LayoutParams params = mTipDialog.getWindow().getAttributes();
        params.x = -230;
        params.y = -550;
        mTipDialog.getWindow().setAttributes(params);
        mTipDialog.show();
        mTipDialog.setContentView(R.layout.tip_layout);
        return mTipDialog;
    }

    public void DisableTipDialog(){
        mTipDialog.cancel();
    }




}
