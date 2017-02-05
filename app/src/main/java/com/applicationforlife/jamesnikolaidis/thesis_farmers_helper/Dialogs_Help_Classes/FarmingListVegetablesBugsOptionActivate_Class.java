package com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Dialogs_Help_Classes;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Dialogs.DialogClassGr;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Dialogs.Dialogs_Class;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Dialogs.Tip_Dialog;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.R;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Timers.Timers_Class;

import java.util.ArrayList;

/**
 * Created by James Nikolaidis on 1/31/2017.
 */

public class FarmingListVegetablesBugsOptionActivate_Class {
    private DialogClassGr dialogClassGr;
    private Dialogs_Class dialogs_class;

    public FarmingListVegetablesBugsOptionActivate_Class(){}




    public void FarmingListVegetablesBugsOptionActivate(final Context context, String BeforeOption, final Activity activity , final ArrayList<Button> ButtonArray , final ListView listView, TextView mSolutionFor) {
        final ArrayList<Integer> imageid = new ArrayList<>();
        dialogClassGr = new DialogClassGr();
        AlertDialog mTipAlertDialog ;
        Tip_Dialog mTipDialogClass = new Tip_Dialog();
        Timers_Class mTimerClass = new Timers_Class();


        switch (BeforeOption) {
            case "Αγγούρι":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("trialeurodes_vaporariorum","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("thrips","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("aphis","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("phyllonorycter_blancardella","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("lygus_pabulinus","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Cucumber), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);

                dialogClassGr.flag=1;
                ButtonArray.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("cucumber","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("artichoke","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cauliflower","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("spinach","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("onion","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cabbage","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("broccoli","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("tomato","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.VegetablesGr), activity);
                    }
                });
                dialogClassGr.Before3 =BeforeOption;
                mSolutionFor.setText(activity.getResources().getString(R.string.ThirdButtonTextGr));
                break;
            case "Αγγινάρα":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("bremia_lactucae","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("ramularia_beticola","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("oidium","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("aphis","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("pyrameis_atalanta","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("cassida","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Artichoke_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                dialogClassGr.flag=1;
                ButtonArray.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("cucumber","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("artichoke","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cauliflower","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("spinach","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("onion","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cabbage","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("broccoli","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("tomato","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.VegetablesGr), activity);
                    }
                });
                dialogClassGr.Before3 =BeforeOption;
                mSolutionFor.setText(activity.getResources().getString(R.string.ThirdButtonTextGr));
                break;
            case "Κουνουπίδι":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("agriotes_lineatus","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("aphis","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("trialeurodes_vaporariorum","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("plasmodiophorabrassicae","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("sclerotiniasclerotiorum","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("altenaria","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("pseudoperonospora_cubensis","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("oidium","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Cauliflower__Broccoli_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                dialogClassGr.flag=1;
                ButtonArray.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("cucumber","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("artichoke","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cauliflower","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("spinach","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("onion","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cabbage","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("broccoli","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("tomato","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.VegetablesGr), activity);
                    }
                });
                dialogClassGr.Before3 =BeforeOption;
                mSolutionFor.setText(activity.getResources().getString(R.string.ThirdButtonTextGr));
                break;
            case "Σπανάκι":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("aphis","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("trialeurodes_vaporariorum","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("thrips","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("citrus_root_nematode","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("pythium_ultimum","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("pseudoperonospora_cubensis","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("oidium","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("sclerotiniasclerotiorum","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogClassGr. CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Spinach_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                dialogClassGr.flag=1;
                ButtonArray.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("cucumber","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("artichoke","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cauliflower","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("spinach","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("onion","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cabbage","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("broccoli","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("tomato","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.VegetablesGr), activity);
                    }
                });
                dialogClassGr.Before3 =BeforeOption;
                mSolutionFor.setText(activity.getResources().getString(R.string.ThirdButtonTextGr));
                break;
            case "Κρεμμύδι":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("botrytis_cinerea","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("puccinia_porri","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("thrips","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("pseudoperonospora_cubensis","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("sclerotiniasclerotiorum","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Onion_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                dialogClassGr.flag=1;
                ButtonArray.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("cucumber","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("artichoke","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cauliflower","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("spinach","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("onion","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cabbage","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("broccoli","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("tomato","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.VegetablesGr), activity);
                    }
                });
                dialogClassGr.Before3 =BeforeOption;
                mSolutionFor.setText(activity.getResources().getString(R.string.ThirdButtonTextGr));
                break;
            case "Λάχανο":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("agriotes_lineatus","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("aphis","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("trialeurodes_vaporariorum","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("plasmodiophorabrassicae","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("sclerotiniasclerotiorum","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("alteraria","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("pseudoperonospora_cubensis","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("oidium","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Cauliflower__Broccoli_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                dialogClassGr.flag=1;
                ButtonArray.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("cucumber","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("artichoke","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cauliflower","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("spinach","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("onion","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cabbage","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("broccoli","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("tomato","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.VegetablesGr), activity);
                    }
                });
                dialogClassGr.Before3 =BeforeOption;
                mSolutionFor.setText(activity.getResources().getString(R.string.ThirdButtonTextGr));
                break;

            case "Μπρόκολο":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("agriotes_lineatus","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("aphis","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("trialeurodes_vaporariorum","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("plasmodiophorabrassicae","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("sclerotiniasclerotiorum","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("alteraria","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("pseudoperonospora_cubensis","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("oidium","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Cauliflower__Broccoli_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                dialogClassGr.flag=1;
                ButtonArray.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("cucumber","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("artichoke","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cauliflower","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("spinach","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("onion","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cabbage","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("broccoli","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("tomato","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.VegetablesGr), activity);
                    }
                });
                dialogClassGr.Before3 =BeforeOption;
                mSolutionFor.setText(activity.getResources().getString(R.string.ThirdButtonTextGr));
                break;
            case "Ντομάτα" :
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("tetranychus_urticae","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("aphis","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("tuta_absoluta","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("thrips","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("trialeurodes_vaporariorum","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("oidium","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("alteraria","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("phytophthora","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("citrus_root_nematode","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid, listView,ButtonArray.get(2), activity.getResources().getStringArray(R.array.Tomatoe_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                dialogClassGr.flag=1;
                ButtonArray.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("cucumber","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("artichoke","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cauliflower","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("spinach","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("onion","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cabbage","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("broccoli","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("tomato","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.VegetablesGr), activity);
                    }
                });
                dialogClassGr.Before3 =BeforeOption;
                mSolutionFor.setText(activity.getResources().getString(R.string.ThirdButtonTextGr));
                break;


        }

    }







    public void FarmingListVegetablesBugsOptionActivateEn(final Context context, String BeforeOption, final Activity activity , final ArrayList<Button> ButtonArray , final ListView listView) {
        final ArrayList<Integer> imageid = new ArrayList<>();
        AlertDialog mTipAlertDialog ;
        Tip_Dialog mTipDialogClass = new Tip_Dialog();
        Timers_Class mTimerClass = new Timers_Class();
        dialogs_class = new Dialogs_Class();

        switch (BeforeOption) {
            case "Cucumber":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("trialeurodes_vaporariorum","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("thrips","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("aphis","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("phyllonorycter_blancardella","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("lygus_pabulinus","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogs_class.CreateDialogForProblem(context,"Solutuion For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Cucumber), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                dialogs_class.flag=1;
                dialogs_class.Before3 =BeforeOption;
                ButtonArray.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("cucumber","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("artichoke","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cauliflower","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("spinach","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("onion","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cabbage","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("broccoli","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("tomato","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        dialogs_class.CreateDialogForProblem(context,"Solution For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Vegetables), activity);
                    }
                });
                break;
            case "Artichoke":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("bremia_lactucae","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("ramularia_beticola","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("oidium","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("aphis","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("pyrameis_atalanta","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("cassida","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogs_class.CreateDialogForProblem(context,"Solutuion For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Artichoke_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                dialogs_class.flag=1;
                dialogs_class.Before3 =BeforeOption;
                ButtonArray.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("cucumber","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("artichoke","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cauliflower","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("spinach","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("onion","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cabbage","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("broccoli","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("tomato","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        dialogs_class.CreateDialogForProblem(context,"Solution For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Vegetables), activity);
                    }
                });
                break;
            case "Cauliflower":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("agriotes_lineatus","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("aphis","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("trialeurodes_vaporariorum","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("plasmodiophorabrassicae","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("sclerotiniasclerotiorum","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("altenaria","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("pseudoperonospora_cubensis","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("oidium","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogs_class.CreateDialogForProblem(context,"Solutuion For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Cauliflower__Broccoli_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                dialogs_class.flag=1;
                dialogs_class.Before3 =BeforeOption;
                ButtonArray.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("cucumber","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("artichoke","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cauliflower","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("spinach","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("onion","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cabbage","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("broccoli","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("tomato","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        dialogs_class.CreateDialogForProblem(context,"Solution For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Vegetables), activity);
                    }
                });
                break;
            case "Spinach":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("aphis","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("trialeurodes_vaporariorum","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("thrips","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("citrus_root_nematode","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("pythium_ultimum","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("pseudoperonospora_cubensis","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("oidium","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("sclerotiniasclerotiorum","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogs_class.CreateDialogForProblem(context,"Solutuion For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Spinach_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                dialogs_class. flag=1;
                dialogs_class. Before3 =BeforeOption;
                ButtonArray.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("cucumber","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("artichoke","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cauliflower","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("spinach","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("onion","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cabbage","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("broccoli","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("tomato","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        dialogs_class.CreateDialogForProblem(context,"Solution For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Vegetables), activity);
                    }
                });
                break;
            case "Onion":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("botrytis_cinerea","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("puccinia_porri","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("thrips","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("pseudoperonospora_cubensis","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("sclerotiniasclerotiorum","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogs_class.CreateDialogForProblem(context,"Solutuion For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Onion_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                dialogs_class.flag=1;
                dialogs_class.Before3 =BeforeOption;
                ButtonArray.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("cucumber","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("artichoke","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cauliflower","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("spinach","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("onion","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cabbage","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("broccoli","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("tomato","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        dialogs_class.CreateDialogForProblem(context,"Solution For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Vegetables), activity);
                    }
                });
                break;
            case "Cabbage":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("agriotes_lineatus","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("aphis","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("trialeurodes_vaporariorum","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("plasmodiophorabrassicae","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("sclerotiniasclerotiorum","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("alteraria","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("pseudoperonospora_cubensis","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("oidium","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogs_class.CreateDialogForProblem(context,"Solutuion For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Cauliflower__Broccoli_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                dialogs_class.flag=1;
                dialogs_class.Before3 =BeforeOption;
                ButtonArray.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("cucumber","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("artichoke","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cauliflower","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("spinach","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("onion","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cabbage","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("broccoli","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("tomato","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        dialogs_class.CreateDialogForProblem(context,"Solution For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Vegetables), activity);
                    }
                });
                break;

            case "Broccoli":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("agriotes_lineatus","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("aphis","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("trialeurodes_vaporariorum","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("plasmodiophorabrassicae","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("sclerotiniasclerotiorum","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("alteraria","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("pseudoperonospora_cubensis","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("oidium","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogs_class.CreateDialogForProblem(context,"Solutuion For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Cauliflower__Broccoli_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                dialogs_class.flag=1;
                dialogs_class.Before3 =BeforeOption;
                ButtonArray.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("cucumber","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("artichoke","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cauliflower","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("spinach","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("onion","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cabbage","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("broccoli","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("tomato","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        dialogs_class.CreateDialogForProblem(context,"Solution For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Vegetables), activity);
                    }
                });
                break;
            case "Tomato" :
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("tetranychus_urticae","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("aphis","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("tuta_absoluta","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("thrips","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("trialeurodes_vaporariorum","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("oidium","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("alteraria","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("phytophthora","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("citrus_root_nematode","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogs_class.CreateDialogForProblem(context,"Solutuion For",imageid, listView,ButtonArray.get(2), activity.getResources().getStringArray(R.array.Tomatoe_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                dialogs_class.flag=1;
                dialogs_class.Before3 =BeforeOption;
                ButtonArray.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("cucumber","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("artichoke","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cauliflower","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("spinach","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("onion","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cabbage","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("broccoli","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("tomato","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        dialogs_class.CreateDialogForProblem(context,"Solution For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Vegetables), activity);
                    }
                });
                break;


        }






    }



}
