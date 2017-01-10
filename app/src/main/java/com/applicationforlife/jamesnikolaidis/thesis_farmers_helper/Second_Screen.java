package com.applicationforlife.jamesnikolaidis.thesis_farmers_helper;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Database_Functions.Database_Class_Functions;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Dialogs.Chat_Dialog;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Dialogs.PaymentDialog;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Objects.Products;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by James Nikolaidis on 11/5/2016.
 */

public class Second_Screen extends FragmentActivity {


    /*****************************************************\\
     Class varaible decleration
     //******************************************************/

    private SharedPreferences Preference ;
    private SharedPreferences.Editor editor;
    private String User_Problem_Choice ;
    private ViewPager viewPager ;
    ArrayList<Products> list;
    private  int counter;
    private static Database_Class_Functions database_class_functions ;
    private  Handler handler = new Handler();
    private ProgressDialog  mProgressDialog;
    private Timer timer;


    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_screen);

        Preference = getSharedPreferences("Data",MODE_PRIVATE);
        editor = Preference.edit();
        viewPager = (ViewPager) findViewById(R.id.viewpager); //init
        list = new ArrayList<>(); //init
        counter=0;
       //***********Execute basic method to fetch the data from database**************************//
        database_class_functions=Database_Class_Functions.GetDatabaseInstance(getApplicationContext()); //init
        database_class_functions.GetProduct(Preference.getString("SpecifyProblem","wrong")); //get's the product's list for the specific problem
        database_class_functions.FindAndCollectDistributerDetails(Preference.getString("SpecifyProblem","wrong")); //get's Distributer's list for specific problem




        //Start Thread to  Load the Data From Firebase Database , we need at least 2sec until the list get filled.
            new Thread(new Runnable() {
                @Override
                public void run() {


                //***********Activate the Progress Dialog and Show it to the Screen*******************//
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            ActivateProgressDialog(); //activate the Dialog using the method ActivateProgressDialog() from the Bottom
                            SetTimer(10); //Set the Timer that Progress Bar will be on the Screen

                        }
                    },0);




                    //***********Call the appropiete method for fetching the data*******************//
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                                list = database_class_functions.getProductsData();
                                editor.putInt("Counter", list.size());
                                editor.commit();
                                viewPager.setAdapter(new MyFragmentAdapter(getSupportFragmentManager(), getApplicationContext(), Second_Screen.this));
                                viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                                    @Override
                                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                                    }

                                    @Override
                                    public void onPageSelected(int position) {
                                        ActivateProgressDialog();
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



        //******************Initialize the Activity's Toolbar ****************************//
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar1);
        toolbar.setTitle("Products");
        setActionBar(toolbar);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu1, menu);
        return true;
    }


    public void MenuClick(MenuItem item) throws IOException {
        //***********Set menu's clicks methods********************/
        if(item.getItemId()==R.id.miCompose){System.exit(0);} //if users click the "Log Out" option
        else if(item.getItemId()==R.id.BiologicalTips){
            PaymentDialog paymentDialog = new PaymentDialog();
            paymentDialog.DisplayPaymentDialog(getApplicationContext(),Second_Screen.this);
        }else if(item.getItemId()==R.id.ProductLabel) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://firebasestorage.googleapis.com/v0/b/farmers-helper-44f7a.appspot.com/o/79999925c_Belt_24WG_50g_Box_Greek_Bonus_Label.pdf?alt=media&token=feecd676-5143-4548-9657-368029312866"));
           startActivity(browserIntent);
        }else if(item.getItemId()==R.id.chat){
            Chat_Dialog.DisplayChat(getApplicationContext(),Second_Screen.this);
        }




    }


            public void HideDialogAndZeroTheTimer(){

                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                                mProgressDialog.hide();
                                counter=0;
                                timer.cancel();

                        }
                    },0);

            }

                public void SetTimer(final int time){

                    timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            mProgressDialog.setProgress(mProgressDialog.getProgress()+100/time);
                            counter++;

                            if(counter==time){
                                HideDialogAndZeroTheTimer();
                            }

                        }
                    },0,1000);



                }




                public void ActivateProgressDialog(){

                    mProgressDialog = new ProgressDialog(getLayoutInflater().getContext());
                    mProgressDialog.setMessage("Please wait while we fetching the Products from Database...");
                    mProgressDialog.setMax(100);
                    mProgressDialog.setCancelable(false);
                    mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                    mProgressDialog.setProgressDrawable(Second_Screen.this.getResources().getDrawable(R.drawable.progress_bar_style));
                    mProgressDialog.setProgress(0);
                    mProgressDialog.show();
                }





}
