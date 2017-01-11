package com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Adapters.Chat_Adapter;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Chat_Class.Chat_Class;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Database_Functions.Database_Class_Functions;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Progress_Bar_Class.SimplyProgressBar;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.R;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

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
            private static Handler mHandler;
            private static Timer mTimer;
            private static int mSecondCounter=0;
            private static ProgressDialog mWaitProgressDialog;
            private static SimplyProgressBar mSimplyProgressBar;
            private static ArrayList<String> mMessages,mMessagesKey ;
            private static Activity mApplicationActivity;
            private static Context ApplicationContext;
            private static AlertDialog dialog;

            private static int flag =0,flag1=0;

    public static void  DisplayChat(final Context context , final Activity activity){

        final AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(activity, R.style.AlertDialogCustom));
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
         dialog = builder.create();
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.show();
        dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE|WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        dialog.setContentView(inflater.inflate(R.layout.chat_layout,null));
        mSendMessageButton=(Button) dialog.findViewById(R.id.Chat_Send_Message_Button);
        mMessageListView = (ListView) dialog.findViewById(R.id.Chat_List_View);
        mCancelButton = (Button) dialog.findViewById(R.id.Chat_Close_Button);
        mMessageEditText = (EditText) dialog.findViewById(R.id.Chat_Message_Edit_Text);
        mSearchEditText = (EditText) dialog.findViewById(R.id.Chat_Search_Edit_Text);
        mSearchImageView = (ImageView) dialog.findViewById(R.id.Chat_Search_ImageView);
        mMessageNameEditText = (EditText)dialog.findViewById(R.id.Chat_Name_Edit_Text);
        mChat_Class=new Chat_Class();
        mApplicationActivity=activity;
        mHandler = new Handler();
        ApplicationContext = dialog.getContext();
        mSimplyProgressBar = new SimplyProgressBar();
        database_class_functions = Database_Class_Functions.GetDatabaseInstance(context);
        mMessagesKey=mMessages = new ArrayList<>();
        RefreshChat();
        RefreshTime();

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
                ArrayList<String> mCompleteMessage  = new ArrayList<String>();
                mCompleteMessage.add(mMessageNameEditText.getText().toString());
                mCompleteMessage.add(mMessageEditText.getText().toString());
                mChat_Class.mMessageArrayList = mCompleteMessage;
                database_class_functions.InsertMessage(mChat_Class,mSearchEditText.getText().toString());
                mMessageNameEditText.setText("");
                mMessageEditText.setText("");
                RefreshChat();

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

                if(keyEvent.getKeyCode()==KeyEvent.KEYCODE_ENTER && flag==0){
                    flag=1;
                    mWaitProgressDialog = mSimplyProgressBar.ActivateProgressDialog1(mWaitProgressDialog,activity);
                    SetTimer(8,dialog.getContext());
                    database_class_functions.FarmerSearchEngine(mSearchEditText.getText().toString());
                    mHandler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mMessages = database_class_functions.ReturnMessageArray(mSearchEditText.getText().toString());
                            mMessagesKey = database_class_functions.ReturnMessageKeyArray("mSearchEditText.getText().toString()");
                            ArrayAdapter adapter = new Chat_Adapter(dialog.getContext(),mMessages,mMessagesKey);
                            mMessageListView.setAdapter(adapter);
                            mSearchEditText.setText("");
                        }
                    },5000);



                }


                return false;
            }
        });

    }




    public static void SetTimer(final int time, final Context context){

        mTimer = new Timer();
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                mWaitProgressDialog.setProgress(mWaitProgressDialog.getProgress()+100/time);
                mSecondCounter++;

                if(mSecondCounter==time){
                    HideDialogAndZeroTheTimer();
                }


            }
        },0,2000);
    }


    public static void RefreshTime(){

       Timer mTimer1 = new Timer();
        mTimer1.schedule(new TimerTask() {
            @Override
            public void run() {
                RefreshChat();

            }
        },0,1000);
    }

    public static void HideDialogAndZeroTheTimer(){

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mWaitProgressDialog.hide();
                mSecondCounter=0;
                mTimer.cancel();
                flag=0;

            }
        },0);

    }



    public static void RefreshChat(){
        if(database_class_functions.isFirstTime()){
        database_class_functions.GetChat();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(flag1==0){
                    database_class_functions.MessagesCount();
                    flag1=1;
                }
                mMessages = database_class_functions.getMessages();
                mMessagesKey = database_class_functions.getMessageKey();
                ArrayAdapter adapter = new Chat_Adapter(dialog.getContext(),mMessages,mMessagesKey);
                mMessageListView.setAdapter(adapter);
            }
        },2000);
        }else{


            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    database_class_functions.GetChat();
                }
            },2000);
        }








    }






}
