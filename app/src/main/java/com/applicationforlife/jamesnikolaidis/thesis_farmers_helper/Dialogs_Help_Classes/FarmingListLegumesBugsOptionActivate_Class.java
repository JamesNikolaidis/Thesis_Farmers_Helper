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

import static com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Dialogs.DialogClassGr.flag;

/**
 * Created by James Nikolaidis on 1/31/2017.
 */

public class FarmingListLegumesBugsOptionActivate_Class {

    private DialogClassGr dialogClassGr;
    private Dialogs_Class dialogs_class;

    public FarmingListLegumesBugsOptionActivate_Class(){}




    public void FarmingListLegumesBugsOptionActivate(final Context context, String BeforeOption, final Activity activity , final ArrayList<Button> ButtonArray , final ListView listView, TextView mSolutionFor) {

        final ArrayList<Integer> imageid = new ArrayList<>();
        dialogClassGr =new DialogClassGr();
        AlertDialog mTipAlertDialog ;
        Tip_Dialog mTipDialogClass = new Tip_Dialog();
        Timers_Class mTimerClass = new Timers_Class();

        switch (BeforeOption) {
            case "Φασόλια":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("ascochyta","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("botrytis_cinerea","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("sclerotiniasclerotiorum","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("anthracnose_of_cottons","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("uromycesphaseoli","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("altenaria","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("oidium","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("pythium_spp2","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("bruchus","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("liriomyza_trifolii04","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("thrips","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("aphis","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Beans_Peas_chickBeans_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                flag=1;
                ButtonArray.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("beans","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("lentils","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("chickpeas","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("peas","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.LegumesGr), activity);

                    }
                });
                dialogClassGr.Before3 =BeforeOption;
                mSolutionFor.setText(activity.getResources().getString(R.string.ThirdButtonTextGr));
                break;
            case "Φακές":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("bruchus","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("sitona_macularius","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("aphis","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("anthracnose_of_cottons","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("ascochyta","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("botrytis_cinerea","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("oidium","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("vascular_wilt_of_lentil","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Lentil_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                flag=1;
                ButtonArray.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("beans","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("lentils","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("chickpeas","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("peas","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.LegumesGr), activity);

                    }
                });
                dialogClassGr.Before3 =BeforeOption;
                mSolutionFor.setText(activity.getResources().getString(R.string.ThirdButtonTextGr));
                break;
            case "Ρεβύθια":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("ascochyta","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("botrytis_cinerea","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("sclerotiniasclerotiorum","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("anthracnose_of_cottons","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("uromycesphaseoli","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("altenaria","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("oidium","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("pythium_spp2","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("bruchus","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("liriomyza_trifolii04","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("thrips","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("aphis","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Beans_Peas_chickBeans_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                flag=1;
                ButtonArray.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("beans","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("lentils","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("chickpeas","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("peas","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.LegumesGr), activity);

                    }
                });
                dialogClassGr.Before3 =BeforeOption;
                mSolutionFor.setText(activity.getResources().getString(R.string.ThirdButtonTextGr));
                break;
            case "Μπιζέλια":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("ascochyta","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("botrytis_cinerea","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("sclerotiniasclerotiorum","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("anthracnose_of_cottons","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("uromycesphaseoli","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("altenaria","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("oidium","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("pythium_spp2","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("bruchus","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("liriomyza_trifolii04","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("thrips","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("aphis","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Beans_Peas_chickBeans_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                flag=1;
                ButtonArray.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("beans","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("lentils","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("chickpeas","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("peas","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.LegumesGr), activity);

                    }
                });
                dialogClassGr.Before3 =BeforeOption;
                mSolutionFor.setText(activity.getResources().getString(R.string.ThirdButtonTextGr));
                break;

        }


    }








    public void FarmingListLegumesBugsOptionActivateEn(final Context context, String BeforeOption, final Activity activity , final ArrayList<Button> ButtonArray , final ListView listView) {

        final ArrayList<Integer> imageid = new ArrayList<>();
        AlertDialog mTipAlertDialog ;
        Tip_Dialog mTipDialogClass = new Tip_Dialog();
        Timers_Class mTimerClass = new Timers_Class();
        dialogs_class = new Dialogs_Class();


        switch (BeforeOption) {
            case "Beans":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("ascochyta","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("botrytis_cinerea","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("sclerotiniasclerotiorum","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("anthracnose_of_cottons","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("uromycesphaseoli","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("altenaria","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("oidium","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("pythium_spp2","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("bruchus","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("liriomyza_trifolii04","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("thrips","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("aphis","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogs_class.CreateDialogForProblem(context,"Solutuion For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Beans_Peas_chickBeans_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                flag=1;
                dialogs_class.Before3 =BeforeOption;
                ButtonArray.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("beans","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("lentils","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("chickpeas","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("peas","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        dialogs_class.CreateDialogForProblem(context,"Solution For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Legumes), activity);
                    }
                });
                break;
            case "Lentil":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("bruchus","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("sitona_macularius","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("aphis","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("anthracnose_of_cottons","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("ascochyta","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("botrytis_cinerea","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("oidium","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("vascular_wilt_of_lentil","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogs_class.CreateDialogForProblem(context,"Solutuion For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Lentil_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                flag=1;
                dialogs_class.Before3 =BeforeOption;
                ButtonArray.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("beans","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("lentils","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("chickpeas","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("peas","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        dialogs_class.CreateDialogForProblem(context,"Solution For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Legumes), activity);
                    }
                });
                break;
            case "Chickpeas":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("ascochyta","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("botrytis_cinerea","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("sclerotiniasclerotiorum","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("anthracnose_of_cottons","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("uromycesphaseoli","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("altenaria","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("oidium","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("pythium_spp2","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("bruchus","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("liriomyza_trifolii04","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("thrips","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("aphis","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogs_class.CreateDialogForProblem(context,"Solutuion For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Beans_Peas_chickBeans_Bugs), activity);
                dialogs_class.CreateDialogForProblem(context,"Solutuion For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Beans_Peas_chickBeans_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                flag=1;
                dialogs_class.Before3 =BeforeOption;
                ButtonArray.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("beans","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("lentils","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("chickpeas","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("peas","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        dialogs_class.CreateDialogForProblem(context,"Solution For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Legumes), activity);
                    }
                });
                break;
            case "Peas":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("ascochyta","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("botrytis_cinerea","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("sclerotiniasclerotiorum","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("anthracnose_of_cottons","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("uromycesphaseoli","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("altenaria","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("oidium","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("pythium_spp2","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("bruchus","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("liriomyza_trifolii04","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("thrips","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("aphis","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogs_class.CreateDialogForProblem(context,"Solutuion For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Beans_Peas_chickBeans_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                flag=1;
                dialogs_class.Before3 =BeforeOption;
                ButtonArray.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("beans","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("lentils","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("chickpeas","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("peas","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        dialogs_class.CreateDialogForProblem(context,"Solution For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Legumes), activity);
                    }
                });
                break;

        }


    }




}
