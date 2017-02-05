package com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.R;

/**
 * Created by James Nikolaidis on 1/20/2017.
 */

public class Read_Me_Dialog {
        private Button mBackButton;


        public Read_Me_Dialog(){}

        public void ActivateReadMeDialog(Activity activity , Context context,int Language){
            AlertDialog.Builder mReadMeBuilder = new AlertDialog.Builder(activity);
            final AlertDialog mReadMeDialog =  mReadMeBuilder.create();
            mReadMeDialog.show();
            mReadMeDialog.setContentView(R.layout.read_me_layout);
            mBackButton = (Button)mReadMeDialog.findViewById(R.id.back_buttonOnReadMe);
            TextView mReadMeTextView = (TextView)mReadMeDialog.findViewById(R.id.ReadMeTextView);
            if(Language==0){mReadMeTextView.setText(activity.getResources().getString(R.string.ReadMeGrDialog));}
            else{mReadMeTextView.setText(activity.getResources().getString(R.string.ReadMeEngDialog));}
            mBackButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mReadMeDialog.cancel();
                }
            });

        }




}
