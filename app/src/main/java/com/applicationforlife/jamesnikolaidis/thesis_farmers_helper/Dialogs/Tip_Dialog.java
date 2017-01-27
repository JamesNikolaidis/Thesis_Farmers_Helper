package com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.view.WindowManager;
import android.widget.TextView;

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
        mTipDialog.getWindow().setAttributes(params);
        mTipDialog.show();
        mTipDialog.setContentView(R.layout.tip_layout);
        TextView text = (TextView)mTipDialog.findViewById(R.id.textView3);
        SharedPreferences sharedPreferences = activity.getSharedPreferences("Data",Context.MODE_PRIVATE);
        if(sharedPreferences.getInt("Language",5)==0){
        Typeface   type = Typeface.createFromAsset(activity.getAssets(),"fonts/Catenary_Stamp.ttf");
            text.setText("Πιέστε την επιλογή που θέλετε για μερικά δευτερόλεπτα για να εμφανιστούν περισσότερες πληροφορίες.");
            text.setTypeface(type);
        }
        return mTipDialog;
    }

    public void DisableTipDialog(){
        mTipDialog.cancel();
    }




}
