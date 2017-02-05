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

public class FarmingListCerealBugsOptionActivate_Class {
    private DialogClassGr dialogClassGr;
    private Dialogs_Class dialogs_class;


    public FarmingListCerealBugsOptionActivate_Class(){}





    public void FarmingListCerealBugsOptionActivate(final Context context, String BeforeOption, final Activity activity , final ArrayList<Button> ButtonArray , final ListView listView, TextView mSolutionFor) {

        final ArrayList<Integer> imageid = new ArrayList<>();
        dialogClassGr =new DialogClassGr();
        AlertDialog mTipAlertDialog ;
        Tip_Dialog mTipDialogClass = new Tip_Dialog();
        Timers_Class mTimerClass = new Timers_Class();


        switch (BeforeOption) {
            case "Ρύζι":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("pyricularia_grisea", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("fusicladium", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("ephydra_attica", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("sesamia", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("paspalum_distichum", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr), imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Rice_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                dialogClassGr.flag=1;
                ButtonArray.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.add(activity.getResources().getIdentifier("rice","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("wheat","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("oats","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("corn","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("barley","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));

                        dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.CerealsGr), activity);
                    }
                });
                dialogClassGr.Before3 = BeforeOption;
                mSolutionFor.setText(activity.getResources().getString(R.string.ThirdButtonTextGr));
                break;
            case "Βρώμη":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("aphis", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("septoria_pyricola", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("black_loose_smut", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("helminthosporium", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("lygus_pabulinus", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("covered_smut", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("thrips", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("agrotis_spp", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr), imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Apricot_Peach_Cherry_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                dialogClassGr.flag=1;
                ButtonArray.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.add(activity.getResources().getIdentifier("rice","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("wheat","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("oats","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("corn","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("barley","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));

                        dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.CerealsGr), activity);
                    }
                });
                dialogClassGr.Before3 = BeforeOption;
                mSolutionFor.setText(activity.getResources().getString(R.string.ThirdButtonTextGr));
                break;

        }

    }







    public void FarmingListCerealBugsOptionActivateEn(final Context context, String BeforeOption, final Activity activity , final ArrayList<Button> ButtonArray , final ListView listView) {

        final ArrayList<Integer> imageid = new ArrayList<>();
        AlertDialog mTipAlertDialog ;
        Tip_Dialog mTipDialogClass = new Tip_Dialog();
        Timers_Class mTimerClass = new Timers_Class();
        dialogs_class = new Dialogs_Class();

        switch (BeforeOption) {
            case "Rice":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("pyricularia_grisea", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("fusicladium", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("ephydra_attica", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("sesamia", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("paspalum_distichum", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogs_class.CreateDialogForProblem(context, "Solutuion For", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Rice_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                dialogs_class.flag=1;
                dialogs_class.Before3 = BeforeOption;
                ButtonArray.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("rice","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("wheat","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("oats","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("corn","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("barley","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        dialogs_class.CreateDialogForProblem(context,"Solution For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Cereals), activity);
                    }
                });
                break;
            case "Oats":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("aphis", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("septoria_pyricola", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("black_loose_smut", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("helminthosporium", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("lygus_pabulinus", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("covered_smut", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("thrips", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("agrotis_spp", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogs_class.CreateDialogForProblem(context, "Solutuion For", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Apricot_Peach_Cherry_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                dialogs_class. flag=1;
                dialogs_class. Before3 = BeforeOption;
                ButtonArray.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("rice","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("wheat","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("oats","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("corn","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("barley","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        dialogs_class.CreateDialogForProblem(context,"Solution For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Cereals), activity);
                    }
                });
                break;

        }

    }





}
