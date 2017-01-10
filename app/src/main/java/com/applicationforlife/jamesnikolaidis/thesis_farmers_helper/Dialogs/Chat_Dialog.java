package com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Chat_Class.Chat_Class;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Database_Functions.Database_Class_Functions;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.R;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by James Nikolaidis on 1/10/2017.
 */

public class Chat_Dialog {
            private static Button mCancelButton,mSendMessageButton;
            private static ListView mMessageListView;
            private static EditText mMessageEditText , mSearchEditText,mMessageNameEditText;
            private static ImageView mSearchImageView;
            private static Chat_Class mChat_Class;
            private static Database_Class_Functions database_class_functions;


    public static void  DisplayChat(final Context context , Activity activity){

        final AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(activity, R.style.AlertDialogCustom));
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final AlertDialog dialog = builder.create();
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;

        dialog.setView(inflater.inflate(R.layout.chat_layout,null));
        dialog.show();
        mSendMessageButton=(Button) dialog.findViewById(R.id.Chat_Send_Message_Button);
        mMessageListView = (ListView) dialog.findViewById(R.id.ListView);
        mCancelButton = (Button) dialog.findViewById(R.id.Chat_Close_Button);
        mMessageEditText = (EditText) dialog.findViewById(R.id.Chat_Message_Edit_Text);
        mSearchEditText = (EditText) dialog.findViewById(R.id.Chat_Search_Edit_Text);
        mSearchImageView = (ImageView) dialog.findViewById(R.id.Chat_Search_ImageView);
        mMessageNameEditText = (EditText)dialog.findViewById(R.id.Chat_Name_Edit_Text);
        mChat_Class=new Chat_Class();
        database_class_functions = Database_Class_Functions.GetDatabaseInstance(context);


//Cancel Button code below
        mCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                        dialog.hide();
            }
        });

  // Send Message code below
        mSendMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String,String> mCompleteMessage  = new HashMap<String, String>();
                mCompleteMessage.put(mMessageNameEditText.getText().toString(),mMessageEditText.getText().toString());
                mChat_Class.setmMessageArrayList(mCompleteMessage);
                database_class_functions.InsertMessage(mChat_Class);
            }
        });

    // Click Search Image to show search Edit Text

        mSearchImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    mSearchEditText.setVisibility(View.VISIBLE);
            }
        });

    // Set Enter key Listener on Search Edit Text




        mSearchEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(keyEvent.getKeyCode()==KeyEvent.KEYCODE_ENTER){
                            Log.e("Tedting","You press enter");
                        }


                return false;
            }
        });




    }

}
