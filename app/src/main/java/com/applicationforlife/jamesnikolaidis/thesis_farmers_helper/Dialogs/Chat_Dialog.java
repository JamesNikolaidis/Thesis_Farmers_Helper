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
import android.widget.ScrollView;

import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Adapters.Chat_Adapter;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Chat_Class.Chat_Class;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Database_Functions.Database_Class_Functions;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Network_Wifi.Network_Wifi_Class;
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
            private static ProgressDialog mWaitProgressDialog,mWaitProgressDialog2;
            private static SimplyProgressBar mSimplyProgressBar;
            private static ArrayList<String> mMessages,mMessagesKey ;
            private static Activity mApplicationActivity;
            private static Context ApplicationContext;
            private static Network_Wifi_Class mNetwork_and_Wifi_Class;
            private static AlertDialog dialog;
            private static ImageView mChangeThemeIcon;
            private static ScrollView mScrollView;
            private static int PhotoChanger = 0;

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
        mChangeThemeIcon = (ImageView)dialog.findViewById(R.id.ChangeThemeicon);
        mScrollView = (ScrollView)dialog.findViewById(R.id.scrollView6);
        mChat_Class=new Chat_Class();
        mApplicationActivity=activity;
        mHandler = new Handler();
        mNetwork_and_Wifi_Class  =new Network_Wifi_Class(context,activity);
        ApplicationContext = dialog.getContext();
        mSimplyProgressBar = new SimplyProgressBar();
        database_class_functions = Database_Class_Functions.GetDatabaseInstance(context);
        mMessagesKey=mMessages = new ArrayList<>();
        if(mNetwork_and_Wifi_Class.CheckInternetConnectivity(context)==true){
            mWaitProgressDialog = mSimplyProgressBar.ActivateProgressDialog1(mWaitProgressDialog,activity);
            database_class_functions.MessagesCount();
            SetTimer(3,dialog.getContext());
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    database_class_functions.ActivateChat();
                    database_class_functions.comeanother = false;
                    mHandler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            RefreshChat();
                            RefreshTime();
                        }

                    },2000);
                }
            },1000);


        }else{
            mNetwork_and_Wifi_Class.ActivateInterner();
            mWaitProgressDialog2 = mSimplyProgressBar.SimplyProgressDialog(mWaitProgressDialog2,activity,"Connection lost, Please Wait...If this Message appear is short time ,please activate your mobile data.");

                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mWaitProgressDialog2.cancel();

                        database_class_functions.MessagesCount();

                        mHandler.postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                database_class_functions.ActivateChat();
                                database_class_functions.comeanother = false;
                                RefreshChat();
                                RefreshTime();
                            }
                        },3000);


                    }
                },4000);




        }








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
                mMessageNameEditText.setClickable(false);
                mMessageEditText.setText("");
                RefreshChat();

            }
        });

    // Click Search Image to show search Edit Text

        mSearchImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if(mSearchEditText.getVisibility()==View.VISIBLE){
                        mSearchEditText.setVisibility(View.INVISIBLE);
                    }else{mSearchEditText.setVisibility(View.VISIBLE);}


            }
        });

    // Set Enter key Listener on Search Edit Text
        mSearchEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {

                if(keyEvent.getKeyCode()==KeyEvent.KEYCODE_ENTER){

                    mWaitProgressDialog = mSimplyProgressBar.ActivateProgressDialog1(mWaitProgressDialog,activity);
                    SetTimer(8,dialog.getContext());
                    database_class_functions.FarmerSearchEngine(mSearchEditText.getText().toString());
                    mHandler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mMessages = database_class_functions.ReturnMessageArray(mSearchEditText.getText().toString());
                            mMessagesKey = database_class_functions.ReturnMessageKeyArray("mSearchEditText.getText().toString()");
                            ArrayAdapter adapter = new Chat_Adapter(dialog.getContext(),mMessages,mMessagesKey,0);
                            mMessageListView.setAdapter(adapter);
                            mSearchEditText.setText("");
                        }
                    },5000);



                }


                return false;
            }
        });


        mChangeThemeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(PhotoChanger==0) {
                    mChangeThemeIcon.setImageDrawable(activity.getDrawable(R.drawable.dark_green_background));
                    mScrollView.setBackground(activity.getDrawable(R.drawable.chat_back));
                    PhotoChanger++;
                }else{
                    mChangeThemeIcon.setImageDrawable(activity.getDrawable(R.drawable.chat_back));
                    mScrollView.setBackground(activity.getDrawable(R.drawable.dark_green_background));
                    PhotoChanger=0;
                }
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
        },0,500);
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


    // Refresh chat , to get the new messages

    public static void RefreshChat(){

        if(database_class_functions.comeanother==false && flag1==0 && mNetwork_and_Wifi_Class.CheckInternetConnectivity(ApplicationContext) ) {
            flag1++;
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mMessages = database_class_functions.getMessages();
                    mMessagesKey = database_class_functions.getMessageKey();
                    ArrayAdapter adapter = new Chat_Adapter(dialog.getContext(), mMessages, mMessagesKey,0);
                    mMessageListView.setAdapter(adapter);
                }
            }, 2000);
        }else if(database_class_functions.comeanother==true && mNetwork_and_Wifi_Class.CheckInternetConnectivity(ApplicationContext))
        {
            database_class_functions.comeanother = false;
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mMessages = database_class_functions.getMessages();
                    mMessagesKey = database_class_functions.getMessageKey();
                    ArrayAdapter adapter = new Chat_Adapter(dialog.getContext(), mMessages, mMessagesKey,1);
                    mMessageListView.setAdapter(adapter);

                }
            }, 2000);
        }else if(database_class_functions.comeanother==false && mNetwork_and_Wifi_Class.CheckInternetConnectivity(ApplicationContext)==false){
            mNetwork_and_Wifi_Class.ActivateInterner();
            mWaitProgressDialog2 = mSimplyProgressBar.SimplyProgressDialog(mWaitProgressDialog2,mApplicationActivity,"Connection lost, Please Wait...");
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mWaitProgressDialog2.cancel();
                    RefreshChat();


                }
            },4000);

        }



    } // end of Refresh Chat Code here...






}
