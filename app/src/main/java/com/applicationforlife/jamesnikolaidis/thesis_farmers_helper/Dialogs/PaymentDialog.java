package com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.R;


/**
 * Created by James Nikolaidis on 1/6/2017.
 */

public class PaymentDialog {

    private TextView mNameTextView , mLastNameTextView , mCarNumberTextView;
    private Button mPayButton, mCloseButton;

    public PaymentDialog(){}

    public void DisplayPaymentDialog(final Context context , Activity activity){

        final AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(activity, R.style.AlertDialogCustom));
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final AlertDialog dialog = builder.create();
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;


        dialog.setView(inflater.inflate(R.layout.payment_layout,null));
        dialog.show();
        mNameTextView = (TextView)dialog.findViewById(R.id.NameEditText);
        mLastNameTextView = (TextView)dialog.findViewById(R.id.LastNameEditText);
        mCarNumberTextView = (TextView)dialog.findViewById(R.id.CardPhoneEditText);
        mPayButton = (Button)dialog.findViewById(R.id.PayButton);
        mCloseButton = (Button)dialog.findViewById(R.id.CloseButton);
        mCloseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                        dialog.hide();
            }
        });
        mPayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"Under Construction ....",Toast.LENGTH_SHORT).show();
            }
        });





    }







}
