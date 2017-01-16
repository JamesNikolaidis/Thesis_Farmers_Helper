package com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Database_Functions.Database_Class_Functions;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Objects.Distributer;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.R;

/**
 * Created by James Nikolaidis on 1/16/2017.
 */

public class View_Distributer_Details_Dialog {
            private TextView mDistributorCompanyName,mDistributorCompanyEmail,mDistributorCompanyCountry,mDistributorAddress ,mDistributorCompanyState,mDistributorCompanyPostal;
            private Button mCloseButton;
            private Distributer mDistributerObject;
            public View_Distributer_Details_Dialog(){}
            public Database_Class_Functions database_class_functions;



        public void ActivateDistributerDialog(Context context, Activity activity){
            final AlertDialog mDistributerDialog;
            AlertDialog.Builder mDistributerEditor=  new AlertDialog.Builder(activity);
            mDistributerDialog = mDistributerEditor.create();
            mDistributerDialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
            mDistributerDialog.show();
            mDistributerDialog.setContentView(R.layout.distributer_details_layout);
            mDistributorCompanyName =(TextView)mDistributerDialog.findViewById(R.id.DistributerNameTextView);
            mDistributorCompanyEmail = (TextView)mDistributerDialog.findViewById(R.id.DistributerEmailTextView);
            mDistributorAddress = (TextView) mDistributerDialog.findViewById(R.id.DistributerAddressTextView);
            mDistributorCompanyState = (TextView) mDistributerDialog.findViewById(R.id.DistributerStateTextView);
            mDistributorCompanyCountry = (TextView)mDistributerDialog.findViewById(R.id.DistributerCountryTextView);
            mDistributorCompanyPostal = (TextView)mDistributerDialog.findViewById(R.id.DistributerPostalTextView);
            mCloseButton = (Button)mDistributerDialog.findViewById(R.id.DistClose);
            database_class_functions = Database_Class_Functions.GetDatabaseInstance(context);

            mDistributerObject = database_class_functions.ReturnDistributerProfil();

            if(mDistributerObject==null){
                Log.e("DIST","IN ELSE");
                mDistributorCompanyName.setText("Nothing Found");
                mDistributorCompanyPostal.setText("Nothing Found");
                mDistributorCompanyState.setText("Nothing Found");
                mDistributorCompanyEmail.setText("Nothing Found");
                mDistributorAddress.setText("Nothing Found");
                mDistributorCompanyCountry.setText("Nothing Found");
            }else{
                Log.e("DIST","IN ELSE");
            mDistributorCompanyName.setText(mDistributerObject.Name);
            mDistributorCompanyPostal.setText(mDistributerObject.Postal);
            mDistributorCompanyState.setText(mDistributerObject.State);
            mDistributorCompanyEmail.setText(mDistributerObject.Email);
            mDistributorAddress.setText(mDistributerObject.Address);
            mDistributorCompanyCountry.setText(mDistributerObject.Country);
            }
            mCloseButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mDistributerDialog.cancel();
                    mDistributorCompanyName.setText("Nothing Found");
                    mDistributorCompanyPostal.setText("Nothing Found");
                    mDistributorCompanyState.setText("Nothing Found");
                    mDistributorCompanyEmail.setText("Nothing Found");
                    mDistributorAddress.setText("Nothing Found");
                    mDistributorCompanyCountry.setText("Nothing Found");

                }
            });


        }


}
