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

public class FarmingListNutsBugsOptionActivate_Class {
    private DialogClassGr dialogClassGr;
    private Dialogs_Class dialogs_class;


    public FarmingListNutsBugsOptionActivate_Class(){}



    public void FarmingListNutsBugsOptionActivate(final Context context, String BeforeOption, final Activity activity , final ArrayList<Button> ButtonArray , final ListView listView, TextView mSolutionFor) {

        final ArrayList<Integer> imageid = new ArrayList<>();
        dialogClassGr = new DialogClassGr();
        AlertDialog mTipAlertDialog ;
        Tip_Dialog mTipDialogClass = new Tip_Dialog();
        Timers_Class mTimerClass = new Timers_Class();

        switch (BeforeOption) {
            case "Αμυγδαλιά":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("planococcus", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("monilia_cenerea", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("syringae", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("vertic", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("powdery_mildew", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("musa_armillaria", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("anthonomus", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("green_phids", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("leaf_eaters_caterpillars", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr), imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Almond_Trees_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                dialogClassGr.flag=1;
                ButtonArray.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("almond","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("peanut","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("hazel_nuts","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("chestnuts","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("walnuts","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));

                        dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid, listView,ButtonArray.get(2), activity.getResources().getStringArray(R.array.Tree_NutsGr), activity);
                    }
                });
                dialogClassGr.Before3 = BeforeOption;
                mSolutionFor.setText(activity.getResources().getString(R.string.ThirdButtonTextGr));
                break;
            case "Φυστικιά":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("vertic", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("phytophthora", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("musa_armillaria", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("phelinus_rimosus", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("acrantus_vestitus", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("covered_smut", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr), imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Peanut_Tree_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                dialogClassGr.flag=1;
                ButtonArray.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("almond","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("peanut","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("hazel_nuts","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("chestnuts","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("walnuts","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));

                        dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid, listView,ButtonArray.get(2), activity.getResources().getStringArray(R.array.Tree_NutsGr), activity);
                    }
                });
                dialogClassGr.Before3 = BeforeOption;
                mSolutionFor.setText(activity.getResources().getString(R.string.ThirdButtonTextGr));
                break;


            case "Καστανιά":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("cydia_chest", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("moth_pammene_fasciana", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("balaninus_elephas", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("peritelus_sphaeroides", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("agrobacterium_tumefaciens", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("anthracnose_citrus", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("powdery_mildew", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr), imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Chestnut_Tree_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                dialogClassGr.flag=1;
                ButtonArray.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("almond","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("peanut","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("hazel_nuts","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("chestnuts","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("walnuts","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));

                        dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid, listView,ButtonArray.get(2), activity.getResources().getStringArray(R.array.Tree_NutsGr), activity);
                    }
                });
                dialogClassGr.Before3 = BeforeOption;
                mSolutionFor.setText(activity.getResources().getString(R.string.ThirdButtonTextGr));
                break;


            case "Καρυδιά":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("anthracnose_citrus", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("syringae", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("musa_armillaria", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("oberea_linearis", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("cydia_chest", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr), imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Walnuts_Tree_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                dialogClassGr.flag=1;
                ButtonArray.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("almond","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("peanut","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("hazel_nuts","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("chestnuts","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("walnuts","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));

                        dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid, listView,ButtonArray.get(2), activity.getResources().getStringArray(R.array.Tree_NutsGr), activity);
                    }
                });
                dialogClassGr.Before3 = BeforeOption;
                mSolutionFor.setText(activity.getResources().getString(R.string.ThirdButtonTextGr));
                break;

            case "Φουντουκιά":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("anthracnose_citrus", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("syringae", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("musa_armillaria", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("oberea_linearis", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("cydia_chest", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr), imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Walnuts_Tree_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                dialogClassGr.flag=1;
                ButtonArray.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("almond","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("peanut","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("hazel_nuts","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("chestnuts","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("walnuts","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));

                        dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid, listView,ButtonArray.get(2), activity.getResources().getStringArray(R.array.Tree_NutsGr), activity);
                    }
                });
                dialogClassGr.Before3 = BeforeOption;
                mSolutionFor.setText(activity.getResources().getString(R.string.ThirdButtonTextGr));
                break;

        }

    }





    public void FarmingListNutsBugsOptionActivateEn(final Context context, String BeforeOption, final Activity activity , final ArrayList<Button> ButtonArray , final ListView listView) {

        final ArrayList<Integer> imageid = new ArrayList<>();
        AlertDialog mTipAlertDialog ;
        Tip_Dialog mTipDialogClass = new Tip_Dialog();
        Timers_Class mTimerClass = new Timers_Class();
        dialogs_class = new Dialogs_Class();
        switch (BeforeOption) {
            case "Almond":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("planococcus", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("monilia_cenerea", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("syringae", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("vertic", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("powdery_mildew", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("musa_armillaria", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("anthonomus", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("green_phids", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("leaf_eaters_caterpillars", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogs_class.CreateDialogForProblem(context, "Solutuion For", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Almond_Trees_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                dialogs_class.flag=1;
                dialogs_class.Before3 = BeforeOption;
                ButtonArray.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("almond","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("peanut","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("hazel_nuts","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("chestnuts","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("walnuts","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        dialogs_class.CreateDialogForProblem(context,"Solution For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Tree_Nuts), activity);
                    }
                });
                break;
            case "Peanut":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("vertic", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("phytophthora", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("musa_armillaria", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("phelinus_rimosus", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("acrantus_vestitus", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("covered_smut", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogs_class.CreateDialogForProblem(context, "Solutuion For", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Peanut_Tree_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                dialogs_class.flag=1;
                dialogs_class.Before3 = BeforeOption;
                ButtonArray.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("almond","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("peanut","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("hazel_nuts","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("chestnuts","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("walnuts","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        dialogs_class.CreateDialogForProblem(context,"Solution For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Tree_Nuts), activity);
                    }
                });
                break;


            case "Chestnut":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("cydia_chest", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("moth_pammene_fasciana", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("balaninus_elephas", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("peritelus_sphaeroides", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("agrobacterium_tumefaciens", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("anthracnose_citrus", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("powdery_mildew", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogs_class.CreateDialogForProblem(context, "Solutuion For", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Chestnut_Tree_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                dialogs_class. flag=1;
                dialogs_class.Before3 = BeforeOption;
                ButtonArray.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("almond","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("peanut","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("hazel_nuts","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("chestnuts","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("walnuts","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        dialogs_class.CreateDialogForProblem(context,"Solution For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Tree_Nuts), activity);
                    }
                });
                break;


            case "Walnuts":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("anthracnose_citrus", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("syringae", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("musa_armillaria", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("oberea_linearis", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("cydia_chest", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogs_class.CreateDialogForProblem(context, "Solutuion For", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Walnuts_Tree_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                dialogs_class.flag=1;
                dialogs_class.Before3 = BeforeOption;
                ButtonArray.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("almond","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("peanut","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("hazel_nuts","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("chestnuts","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("walnuts","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        dialogs_class.CreateDialogForProblem(context,"Solution For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Tree_Nuts), activity);
                    }
                });
                break;

            case "Hazel":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("anthracnose_citrus", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("syringae", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("musa_armillaria", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("oberea_linearis", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("cydia_chest", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogs_class.CreateDialogForProblem(context, "Solutuion For", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Walnuts_Tree_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                dialogs_class.flag=1;
                dialogs_class.Before3 = BeforeOption;
                ButtonArray.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("almond","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("peanut","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("hazel_nuts","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("chestnuts","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("walnuts","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        dialogs_class.CreateDialogForProblem(context,"Solution For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Tree_Nuts), activity);
                    }
                });
                break;

        }

    }



}
