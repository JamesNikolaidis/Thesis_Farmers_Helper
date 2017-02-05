package com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Dialogs_Help_Classes;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Dialogs.DialogClassGr;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Dialogs.Dialogs_Class;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.R;

import java.util.ArrayList;

/**
 * Created by James Nikolaidis on 1/31/2017.
 */

public class ActivateAnotherDialog_Class {

        private  static DialogClassGr dialogClassGr;
        private Dialogs_Class dialogs_class;



        public ActivateAnotherDialog_Class(){
        }



    public void ActivateAnotherDialog(final Context context, final ArrayList<Integer> imageid, String BeforeOption, final Activity activity, LinearLayout LayoutArray, final SharedPreferences.Editor editor , final ArrayList<Button> ButtonArray , TextView mSpecifyProblem , final ListView listView){
        dialogClassGr=new DialogClassGr();
        if(LayoutArray.getVisibility()== View.INVISIBLE)
        {

            switch (BeforeOption)
            {
                case "Κατηγορία Ζιζανίων":
                    //
                    editor.putBoolean("Clicked1",true);
                    editor.commit();
                    //Here image Code
                    mSpecifyProblem.setText(activity.getResources().getString(R.string.SecondButtonTextGr));
                    dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.SecondButtonTextGr),imageid,listView,ButtonArray.get(1),activity.getResources().getStringArray(R.array.Bugs_ListGr),activity);
                    ButtonArray.get(0).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            imageid.clear();
                            imageid.add(activity.getResources().getIdentifier("weeds","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                            imageid.add(activity.getResources().getIdentifier("farming1","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                            editor.putBoolean("Clicked1",true);
                            editor.commit();
                            dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.SecondButtonTextGr),imageid,listView,ButtonArray.get(1),activity.getResources().getStringArray(R.array.FirstPanelNamesGr),activity);
                        }
                    });
                    dialogClassGr.BeforeOption1=BeforeOption;
                    break;
                case "Κατηγορία Καλλιεργειών":
                    editor.putBoolean("Clicked1",true);
                    editor.commit();
                    mSpecifyProblem.setText(activity.getResources().getString(R.string.SecondButtonTextGr));
                    dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.SecondButtonTextGr),imageid,listView,ButtonArray.get(1),activity.getResources().getStringArray(R.array.Farming_CultureGr),activity);
                    ButtonArray.get(0).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            imageid.clear();
                            imageid.add(activity.getResources().getIdentifier("weeds","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                            imageid.add(activity.getResources().getIdentifier("farming1","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                            editor.putBoolean("Clicked1",true);
                            editor.commit();
                            dialogClassGr. CreateDialogForProblem(context,activity.getResources().getString(R.string.SecondButtonTextGr),imageid,listView,ButtonArray.get(1),activity.getResources().getStringArray(R.array.FirstPanelNamesGr),activity);
                        }
                    });
                    dialogClassGr.BeforeOption1=BeforeOption;
                    break;
            }



        }else{


            switch (BeforeOption)
            {
                case "Κατηγορία Ζιζανίων":

                    dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.SecondButtonTextGr),imageid,listView,ButtonArray.get(1),activity.getResources().getStringArray(R.array.Bugs_ListGr),activity);
                    editor.putBoolean("Clicked1",true);
                    editor.commit();
                    ButtonArray.get(0).setText(BeforeOption);
                    ButtonArray.get(0).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            imageid.clear();
                            imageid.add(activity.getResources().getIdentifier("weeds","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                            imageid.add(activity.getResources().getIdentifier("farming1","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                            dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.SecondButtonTextGr),imageid,listView,ButtonArray.get(1),activity.getResources().getStringArray(R.array.FirstPanelNamesGr),activity);
                            editor.putBoolean("Clicked1",true);
                            editor.commit();
                        }
                    });
                    dialogClassGr.BeforeOption1=BeforeOption;
                    break;
                case "Κατηγορία Καλλιεργειών":

                    dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.SecondButtonTextGr),imageid,listView,ButtonArray.get(1),activity.getResources().getStringArray(R.array.Farming_CultureGr),activity);
                    editor.putBoolean("Clicked1",true);
                    editor.commit();
                    ButtonArray.get(0).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            imageid.clear();
                            imageid.add(activity.getResources().getIdentifier("weeds","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                            imageid.add(activity.getResources().getIdentifier("farming1","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                            dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.SecondButtonTextGr),imageid,listView,ButtonArray.get(1),activity.getResources().getStringArray(R.array.FirstPanelNamesGr),activity);
                            editor.putBoolean("Clicked1",true);
                            editor.commit();
                        }
                    });
                    dialogClassGr.BeforeOption1=BeforeOption;
                    break;
            }

        }//END OF IF


    }









    public void ActivateAnotherDialogEn(final Context context, final ArrayList<Integer> imageid, String BeforeOption, final Activity activity, LinearLayout LayoutArray, final SharedPreferences.Editor editor , final ArrayList<Button> ButtonArray , final ListView listView){


        dialogs_class =new Dialogs_Class();
        if(LayoutArray.getVisibility()== View.INVISIBLE)
        {

            switch (BeforeOption)
            {
                case "Weeds List":
                    editor.putBoolean("Clicked1",true);
                    editor.commit();
                    //Here image Code
                    dialogs_class.CreateDialogForProblem(context,"Specify Problem",imageid,listView,ButtonArray.get(1),activity.getResources().getStringArray(R.array.Bugs_List),activity);
                    ButtonArray.get(0).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            imageid.clear();
                            imageid.add(activity.getResources().getIdentifier("weeds","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                            imageid.add(activity.getResources().getIdentifier("farming1","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                            editor.putBoolean("Clicked1",true);
                            editor.commit();
                            dialogs_class.CreateDialogForProblem(context,"Specify Problem",imageid,listView,ButtonArray.get(1),activity.getResources().getStringArray(R.array.ProblemCategories),activity);
                        }
                    });
                    dialogs_class.BeforeOption1=BeforeOption;
                    break;
                case "Farming Culture List":
                    editor.putBoolean("Clicked1",true);
                    editor.commit();
                    dialogs_class.CreateDialogForProblem(context," Specify Problem.",imageid,listView,ButtonArray.get(1),activity.getResources().getStringArray(R.array.Farming_Culture),activity);
                    ButtonArray.get(0).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            imageid.clear();
                            imageid.add(activity.getResources().getIdentifier("weeds","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                            imageid.add(activity.getResources().getIdentifier("farming1","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                            editor.putBoolean("Clicked1",true);
                            editor.commit();
                            dialogs_class.CreateDialogForProblem(context,"Specify Problem",imageid,listView,ButtonArray.get(1),activity.getResources().getStringArray(R.array.ProblemCategories),activity);
                        }
                    });
                    dialogs_class.BeforeOption1=BeforeOption;
                    break;
            }



        }else{


            switch (BeforeOption)
            {
                case "Weeds List":

                    dialogs_class.CreateDialogForProblem(context,"Specify Problem",imageid,listView,ButtonArray.get(1),activity.getResources().getStringArray(R.array.Bugs_List),activity);
                    editor.putBoolean("Clicked1",true);
                    editor.commit();
                    ButtonArray.get(0).setText(BeforeOption);
                    ButtonArray.get(0).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            imageid.clear();
                            imageid.add(activity.getResources().getIdentifier("weeds","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                            imageid.add(activity.getResources().getIdentifier("farming1","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                            dialogs_class. CreateDialogForProblem(context," Specify Problem.",imageid,listView,ButtonArray.get(1),activity.getResources().getStringArray(R.array.ProblemCategories),activity);
                            editor.putBoolean("Clicked1",true);
                            editor.commit();
                        }
                    });
                    dialogs_class.BeforeOption1=BeforeOption;
                    break;
                case "Farming Culture List":

                    dialogs_class.CreateDialogForProblem(context,"Specify Problem",imageid,listView,ButtonArray.get(1),activity.getResources().getStringArray(R.array.Farming_Culture),activity);
                    editor.putBoolean("Clicked1",true);
                    editor.commit();
                    ButtonArray.get(0).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            imageid.clear();
                            imageid.add(activity.getResources().getIdentifier("weeds","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                            imageid.add(activity.getResources().getIdentifier("farming1","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                            dialogs_class.CreateDialogForProblem(context," Specify Problem.",imageid,listView,ButtonArray.get(1),activity.getResources().getStringArray(R.array.ProblemCategories),activity);
                            editor.putBoolean("Clicked1",true);
                            editor.commit();
                        }
                    });
                    dialogs_class.BeforeOption1=BeforeOption;
                    break;
            }

        }//END OF IF


    }











}
