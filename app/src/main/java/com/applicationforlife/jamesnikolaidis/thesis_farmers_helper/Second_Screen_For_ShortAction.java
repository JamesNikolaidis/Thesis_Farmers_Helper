package com.applicationforlife.jamesnikolaidis.thesis_farmers_helper;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Adapters.MyFragmentAdapter2;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Database_Functions.Database_Class_Functions;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Dialogs.Chat_Dialog;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Dialogs.Close_Program_Dialog;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Dialogs.PaymentDialog;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Listeners.Dialog_On_Long_Click_Listener;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Network_Wifi.Network_Wifi_Class;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Objects.FarmingObjects;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Progress_Bar_Class.SimplyProgressBar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by James Nikolaidis on 1/22/2017.
 */

public class Second_Screen_For_ShortAction extends FragmentActivity {






    /*****************************************************
     * \\
     * Class varaible decleration
     * //
     ******************************************************/

    private SharedPreferences Preference;
    private SharedPreferences.Editor editor;
    private String User_Problem_Choice;
    private ViewPager viewPager;
    ArrayList<FarmingObjects> list;
    private int counter;
    private static Database_Class_Functions database_class_functions;
    private Handler handler = new Handler();
    private SimplyProgressBar mSimplyProgressBar;
    private ProgressDialog mProgressDialog,mProgressDialog2;
    private Timer timer;
    private Network_Wifi_Class mNetwork_and_Wifi_Class;
    private static Dialog_On_Long_Click_Listener listener;

    private int flag = 0;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_screen);

        Preference = getSharedPreferences("Data", MODE_PRIVATE);
        editor = Preference.edit();
        viewPager = (ViewPager) findViewById(R.id.viewpager); //init
        list = new ArrayList<>(); //init
        counter = 0;
        //***********Execute basic method to fetch the data from database**************************//
        database_class_functions = Database_Class_Functions.GetDatabaseInstance(getApplicationContext()); //init
        database_class_functions.GetProductForFarmingShortList("Cucumber"); //get's the product's list for the specific problem
        database_class_functions.FindAndCollectDistributerDetails("Burr"); //get's Distributer's list for specific problem
        mSimplyProgressBar = new SimplyProgressBar();
        listener = new Dialog_On_Long_Click_Listener();
        mNetwork_and_Wifi_Class = new Network_Wifi_Class(getApplicationContext(),Second_Screen_For_ShortAction.this);
        //Start Thread to  Load the Data From Firebase Database , we need at least 2sec until the list get filled.
        if(mNetwork_and_Wifi_Class.CheckInternetConnectivity(getApplicationContext())==true){

            ActivateProductThread();
        }else{Reconnect_and_Load_Data(); }
        //******************Initialize the Activity's Toolbar ****************************//
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);
        toolbar.setTitleTextColor(Color.BLACK);

        if(Preference.getInt("Language",4)==0){
            toolbar.setTitle("Προιόντα");
        }else{ toolbar.setTitle("Products");}

        setActionBar(toolbar);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu1, menu);
        return true;
    }


    // On menu click listener below
    public void MenuClick(MenuItem item) throws IOException {
        //***********Set menu's clicks methods********************/
        if (item.getItemId() == R.id.miCompose) {
            Close_Program_Dialog close_program_dialog = new Close_Program_Dialog();
            close_program_dialog.CloseProgramDialog(Second_Screen_For_ShortAction.this,getApplicationContext(),Preference.getInt("Language",5));
        } //if users click the "Log Out" option
        else if (item.getItemId() == R.id.BiologicalTips) {
            PaymentDialog paymentDialog = new PaymentDialog();
            paymentDialog.DisplayPaymentDialog(getApplicationContext(), Second_Screen_For_ShortAction.this);
        }else if (item.getItemId() == R.id.chat) {
            Chat_Dialog.DisplayChat(getApplicationContext(),Second_Screen_For_ShortAction.this);
        }

    }

    //Hide the progress bar after finish below
    public void HideDialogAndZeroTheTimer() {

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                mProgressDialog.hide();
                counter = 0;
                timer.cancel();

            }
        }, 0);

    }

    //GoToMainPageTimer code below
    public void SetTimer(final int time) {

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                mProgressDialog.setProgress(mProgressDialog.getProgress() + 100 / time);
                counter++;

                if (counter == time) {
                    HideDialogAndZeroTheTimer();
                }

            }
        }, 0, 1000);
    }
//End of timer class code



    public void ActivateProductThread() {
        //   mProgressDialog = mSimplyProgressBar.ActivateProgressDialog(mProgressDialog, Second_Screen.this);
        //Start Thread to  Load the Data From Firebase Database , we need at least 2sec until the list get filled.


        if(mNetwork_and_Wifi_Class.CheckInternetConnectivity(getApplicationContext())){
            new Thread(new Runnable() {
                @Override
                public void run() {


                    //***********Activate the Progress Dialog and Show it to the Screen*******************//
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            if(Preference.getInt("Language",4)==0){
                                mProgressDialog = mSimplyProgressBar.ActivateProgressDialog(mProgressDialog,Second_Screen_For_ShortAction.this,R.string.WaitToLoadDatabaseDataDialogGr);//activate the Dialog using the method ActivateProgressDialog() from the Bottom
                            }else{
                                mProgressDialog = mSimplyProgressBar.ActivateProgressDialog(mProgressDialog,Second_Screen_For_ShortAction.this,R.string.WaitToLoadDatabaseDataDialogEng);//activate the Dialog using the method ActivateProgressDialog() from the Bottom
                            }

                            SetTimer(10); //Set the GoToMainPageTimer that Progress Bar will be on the Screen

                        }
                    },0);
                    //***********Call the appropiete method for fetching the data*******************//
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            list = database_class_functions.getProductsDataForFarmingShortgCut();
                            editor.putInt("Counter", list.size());
                            editor.commit();
                            viewPager.setAdapter(new MyFragmentAdapter2(getSupportFragmentManager(), getApplicationContext(), Second_Screen_For_ShortAction.this));
                            viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                                @Override
                                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                                }

                                @Override
                                public void onPageSelected(int position) {

                                    if(Preference.getInt("Language",4)==0){
                                        mProgressDialog = mSimplyProgressBar.ActivateProgressDialog(mProgressDialog,Second_Screen_For_ShortAction.this,R.string.WaitToLoadDatabaseDataDialogGr);//activate the Dialog using the method ActivateProgressDialog() from the Bottom
                                    }else{
                                        mProgressDialog = mSimplyProgressBar.ActivateProgressDialog(mProgressDialog,Second_Screen_For_ShortAction.this,R.string.WaitToLoadDatabaseDataDialogEng);//activate the Dialog using the method ActivateProgressDialog() from the Bottom
                                    }
                                    SetTimer(3);
                                }

                                @Override
                                public void onPageScrollStateChanged(int state) {

                                }
                            });



                        }
                    }, 5000);
                }
            }).start();

        }else{Reconnect_and_Load_Data();}


    }



    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            Close_Program_Dialog close_program_dialog = new Close_Program_Dialog();
            close_program_dialog.GoToMainPanelDialog(Second_Screen_For_ShortAction.this,getApplicationContext());
            database_class_functions.glag=false;
        }
        return false;
    }




    public void Reconnect_and_Load_Data(){
        mProgressDialog2 = mSimplyProgressBar.SimplyProgressDialog(mProgressDialog2,Second_Screen_For_ShortAction.this,"Internet Connection Lost. Please Wait");
        mNetwork_and_Wifi_Class.ActivateInterner();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ActivateProductThread();
                mProgressDialog2.cancel();

            }
        },5500);
    }
























}
