package com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Network_Wifi;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.view.ContextThemeWrapper;

import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Progress_Bar_Class.SimplyProgressBar;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.R;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Second_Screen;

/**
 * Created by James Nikolaidis on 1/13/2017.
 */

public class Network_Wifi_Class {
        private Context mApplicationContext;
        private WifiManager mWifiManager;
        private ConnectivityManager mConnectivityManager;
        private Activity mApplicationActivity;
        public static boolean option=false;
        public SimplyProgressBar simplyProgressBar;
        public ProgressDialog alertDialog;

    private Handler handler = new Handler();
            public Network_Wifi_Class(Context context,Activity activity){
                this.mApplicationContext = context;
                this.mApplicationActivity = activity;
                simplyProgressBar = new SimplyProgressBar();
                mWifiManager = (WifiManager)context.getSystemService(Context.WIFI_SERVICE);
                mConnectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            }



            public boolean CheckInternetConnectivity(Context context){

             return mConnectivityManager.getActiveNetworkInfo() != null;
              }


             public void CheckWifiConnectionAndEnable(){
                 final android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(new ContextThemeWrapper(mApplicationActivity, R.style.AlertDialogCustom));
                 builder.setTitle("Wifi Connection Details").
                 setPositiveButton("Enable Wifi", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialogInterface, int i) {
                         mWifiManager.setWifiEnabled(true);
                         alertDialog=simplyProgressBar.SimplyProgressDialog(alertDialog,mApplicationActivity);



                         handler.postDelayed(new Runnable() {
                             @Override
                             public void run() {
                                 alertDialog.cancel();
                                 mApplicationActivity.startActivity(new Intent(mApplicationActivity,Second_Screen.class));
                             }
                         },3000);

                     }
                 })
                 .setCancelable(true)
                  .setNegativeButton("Ignore", new DialogInterface.OnClickListener() {
                      @Override
                      public void onClick(DialogInterface dialogInterface, int i) {

                      }
                  }).setMessage("Your Wifi connection is disabled , we will start it immediately").create();

                   if(!mWifiManager.isWifiEnabled()){ builder.show();}
                    else{option=true;}




             }







}
