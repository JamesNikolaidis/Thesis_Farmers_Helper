package com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Dialogs_Help_Classes;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
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

public class BugsListOptionActivate_Class {

        private DialogClassGr dialogClassGr;
        private Dialogs_Class dialogs_class;

    public BugsListOptionActivate_Class(){}







    public void BugsListOptionActivate(final Context context, String BeforeOption, final Activity activity, final SharedPreferences.Editor editor , final ArrayList<Button> ButtonArray , TextView mSolutionFor , final ListView listView)
    {
        dialogClassGr=new DialogClassGr();
        final ArrayList<Integer> imageid = new ArrayList<>();
        AlertDialog mTipAlertDialog ;
        Tip_Dialog mTipDialogClass = new Tip_Dialog();
        Timers_Class mTimerClass = new Timers_Class();

        switch (BeforeOption)
        {
            case "Εχθροί":
                imageid.clear();
                for(int counter = 0; counter!=activity.getResources().getStringArray(R.array.Enemies).length; counter++){
                    imageid.add(activity.getResources().getIdentifier("bugs_icon","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                }
                dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView,ButtonArray.get(2),activity.getResources().getStringArray(R.array.Enemies),activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                mSolutionFor.setText(activity.getResources().getString(R.string.ThirdButtonTextGr));
                ButtonArray.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("bugs_main_photo","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("disease_main_photo","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("enemies_pahid_main_photo","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        editor.putBoolean("Clicked1",true);
                        editor.commit();
                        editor.putBoolean("Clicked",false);
                        editor.commit();
                        dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView,ButtonArray.get(2),activity.getResources().getStringArray(R.array.Bugs_List),activity);
                    }
                });
                dialogClassGr.BeforeOption2 =BeforeOption;
                break;
            case "Ασθένειες":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("vertic","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("vertic","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("alteraria","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("alteraria","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("alternaria_tenus","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("anthracnose_of_cucurbits","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("anthracnose_citrus","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("anthracnose_of_cottons","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("bacterial_necrosis","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("bacterial_rot_of_maize_strain","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                mSolutionFor.setText(activity.getResources().getString(R.string.ThirdButtonTextGr));
                dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView,ButtonArray.get(2),activity.getResources().getStringArray(R.array.Desease_List),activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                ButtonArray.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("bugs_main_photo","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("disease_main_photo","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("enemies_pahid_main_photo","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        editor.putBoolean("Clicked1",true);
                        editor.commit();
                        editor.putBoolean("Clicked",false);
                        editor.commit();
                        dialogClassGr. CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView,ButtonArray.get(2),activity.getResources().getStringArray(R.array.Bugs_List),activity);
                    }
                });
                dialogClassGr.BeforeOption2 =BeforeOption;
                break;
            default:

                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("burr_bug","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("lolium","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("sorghum_halepense","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("convolvulus_arv","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("burr_bug","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                mSolutionFor.setText(activity.getResources().getString(R.string.ThirdButtonTextGr));
                dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView,ButtonArray.get(2),activity.getResources().getStringArray(R.array.Bugs_List_Extend),activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                ButtonArray.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("bugs_main_photo","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("disease_main_photo","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("enemies_pahid_main_photo","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        editor.putBoolean("Clicked1",true);
                        editor.commit();
                        editor.putBoolean("Clicked",false);
                        editor.commit();
                        dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView,ButtonArray.get(2),activity.getResources().getStringArray(R.array.Bugs_List),activity);





                    }
                });
                dialogClassGr. BeforeOption2 =BeforeOption;
                break;

        }


    }





    public void BugsListOptionActivateEn(final Context context, String BeforeOption, final Activity activity, final SharedPreferences.Editor editor , final ArrayList<Button> ButtonArray , final ListView listView)
    {
        final ArrayList<Integer> imageid = new ArrayList<>();
        dialogs_class =new Dialogs_Class();
        AlertDialog mTipAlertDialog ;
        Tip_Dialog mTipDialogClass = new Tip_Dialog();
        Timers_Class mTimerClass = new Timers_Class();


        switch (BeforeOption)
        {       case "Enemies":
            imageid.clear();
            for(int counter=0; counter!=activity.getResources().getStringArray(R.array.Enemies).length; counter++){
                imageid.add(activity.getResources().getIdentifier("bugs_icon","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
            }
            dialogs_class.CreateDialogForProblem(context,"Solutuion For",imageid,listView,ButtonArray.get(2),activity.getResources().getStringArray(R.array.Enemies),activity);
            mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
            mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
            ButtonArray.get(1).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    imageid.clear();
                    imageid.add(activity.getResources().getIdentifier("bugs_main_photo","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                    imageid.add(activity.getResources().getIdentifier("disease_main_photo","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                    imageid.add(activity.getResources().getIdentifier("enemies_pahid_main_photo","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                    editor.putBoolean("Clicked1",true);
                    editor.commit();
                    editor.putBoolean("Clicked",false);
                    editor.commit();
                    dialogs_class.CreateDialogForProblem(context,"Solutuion For",imageid,listView,ButtonArray.get(2),activity.getResources().getStringArray(R.array.Bugs_List),activity);
                }
            });
            dialogs_class.BeforeOption2 =BeforeOption;
            break;
            case "Disease":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("vertic","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("vertic","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("alteraria","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("alteraria","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("alternaria_tenus","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("anthracnose_of_cucurbits","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("anthracnose_citrus","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("anthracnose_of_cottons","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("bacterial_necrosis","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("bacterial_rot_of_maize_strain","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogs_class.CreateDialogForProblem(context,"Solutuion For",imageid,listView,ButtonArray.get(2),activity.getResources().getStringArray(R.array.Desease_List),activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                ButtonArray.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("bugs_main_photo","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("disease_main_photo","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("enemies_pahid_main_photo","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        editor.putBoolean("Clicked1",true);
                        editor.commit();
                        editor.putBoolean("Clicked",false);
                        editor.commit();
                        dialogs_class.CreateDialogForProblem(context,"Solutuion For",imageid,listView,ButtonArray.get(2),activity.getResources().getStringArray(R.array.Bugs_List),activity);
                    }
                });
                dialogs_class.BeforeOption2 =BeforeOption;
                break;
            default:
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("burr_bug","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("lolium","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("sorghum_halepense","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("convolvulus_arv","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("burr_bug","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                //ButtonArray.get(1).setText(BeforeOption);
                dialogs_class.CreateDialogForProblem(context,"Solutuion For",imageid,listView,ButtonArray.get(2),activity.getResources().getStringArray(R.array.Bugs_List_Extend),activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                ButtonArray.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("bugs_main_photo","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("disease_main_photo","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("enemies_pahid_main_photo","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        editor.putBoolean("Clicked1",true);
                        editor.commit();
                        editor.putBoolean("Clicked",false);
                        editor.commit();
                        dialogs_class.CreateDialogForProblem(context,"Solutuion For",imageid,listView,ButtonArray.get(2),activity.getResources().getStringArray(R.array.Bugs_List),activity);





                    }
                });
                dialogs_class.BeforeOption2 =BeforeOption;
                break;

        }


    }










}
