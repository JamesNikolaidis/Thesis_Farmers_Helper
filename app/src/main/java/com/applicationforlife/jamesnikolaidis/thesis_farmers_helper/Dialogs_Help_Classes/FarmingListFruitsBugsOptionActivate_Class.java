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

public class FarmingListFruitsBugsOptionActivate_Class {

        private DialogClassGr dialogClassGr;
        private Dialogs_Class dialogs_class;

        public FarmingListFruitsBugsOptionActivate_Class(){}



    public void FarmingListFruitsBugsOptionActivate(final Context context, String BeforeOption, final Activity activity , final ArrayList<Button> ButtonArray , final ListView listView, TextView mSolutionFor) {

        final ArrayList<Integer> imageid = new ArrayList<>();
        dialogClassGr =new DialogClassGr();
        AlertDialog mTipAlertDialog ;
        Tip_Dialog mTipDialogClass = new Tip_Dialog();
        Timers_Class mTimerClass = new Timers_Class();



        switch (BeforeOption) {
            case "Μήλο":
                imageid.clear();

                imageid.add(activity.getResources().getIdentifier("apple_mosaic_virus", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("fusicladium", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("powdery_mildew", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("parasitic", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("phytophthora", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("cydia_pomonella", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("adoxophyes_orana", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("panonychus_ulmi", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("aphis", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("cossus_linnaeus", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogClassGr.CreateDialogForProblem(context, activity.getResources().getString(R.string.ThirdButtonTextGr), imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Apple_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                dialogClassGr.flag=1;
                mSolutionFor.setText(activity.getResources().getString(R.string.ThirdButtonTextGr));
                ButtonArray.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("apple","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("strawberry","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("pear","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("apriums","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("watermelon","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cherry","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("lemon","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("mandarin","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("peach","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("fig","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("orange","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.FruitsGr), activity);
                    }
                });

                dialogClassGr.Before3 = BeforeOption;
                break;
            case "Φράουλα":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("aphis", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("thrips", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("tetranychus_urticae", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("lygus_hesperus", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr), imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Strawberry_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                dialogClassGr.flag=1;
                ButtonArray.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("apple","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("strawberry","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("pear","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("apriums","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("watermelon","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cherry","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("lemon","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("mandarin","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("peach","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("fig","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("orange","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.FruitsGr), activity);
                    }
                });

                dialogClassGr.Before3 = BeforeOption; mSolutionFor.setText(activity.getResources().getString(R.string.ThirdButtonTextGr));
                break;
            case "Αχλάδι":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("fusicladium_pirinum", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("septoria_pyricola", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("oidium", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("brown_rot", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("parasitic", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("erwinia_amylovora", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("cacopsylla_pyri", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr), imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Pear_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                dialogClassGr.flag=1;
                ButtonArray.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("apple","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("strawberry","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("pear","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("apriums","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("watermelon","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cherry","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("lemon","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("mandarin","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("peach","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("fig","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("orange","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.FruitsGr), activity);
                    }
                });

                dialogClassGr.Before3 = BeforeOption; mSolutionFor.setText(activity.getResources().getString(R.string.ThirdButtonTextGr));
                break;
            case "Βερύκοκο":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("monilia_cenerea", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("taphrina_deformans", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("coryneum", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("oidium", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("vertic", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("puccinia_pruni_spinosae", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("anthracnose_of_cucurbits", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("kylindrosporiosi", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("fusicladium_pirinum", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr), imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Apricot_Peach_Cherry_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                dialogClassGr.flag=1;
                ButtonArray.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("apple","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("strawberry","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("pear","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("apriums","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("watermelon","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cherry","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("lemon","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("mandarin","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("peach","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("fig","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("orange","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.FruitsGr), activity);
                    }
                });
                dialogClassGr.Before3 = BeforeOption; mSolutionFor.setText(activity.getResources().getString(R.string.ThirdButtonTextGr));
                break;


            case "Καρπούζι":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("pseudoperonospora_cubensis", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("oidium", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("altenaria", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("anthracnose_of_cucurbits", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("cladosporium_cucumarinum", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("rhizoctonia", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("sclerotiniasclerotiorum", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("phytophthora", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("apple_mosaic_virus", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("melodoigyne", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("acalymma_trivittatum", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("heliothrips", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("tetranychus_urticae", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr), imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Watermelon_bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                dialogClassGr. flag=1;
                dialogClassGr. Before3 = BeforeOption; mSolutionFor.setText(activity.getResources().getString(R.string.ThirdButtonTextGr));
                ButtonArray.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("apple","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("strawberry","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("pear","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("apriums","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("watermelon","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cherry","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("lemon","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("mandarin","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("peach","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("fig","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("orange","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.FruitsGr), activity);
                    }
                });




                break;



            case "Κεράσι":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("monilia_cenerea", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("taphrina_deformans", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("coryneum", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("oidium", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("vertic", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("puccinia_pruni_spinosae", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("anthracnose_of_cucurbits", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("kylindrosporiosi", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("fusicladium_pirinum", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr), imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Apricot_Peach_Cherry_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog); mSolutionFor.setText(activity.getResources().getString(R.string.ThirdButtonTextGr));
                dialogClassGr.flag=1;
                ButtonArray.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("apple","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("strawberry","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("pear","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("apriums","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("watermelon","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cherry","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("lemon","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("mandarin","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("peach","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("fig","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("orange","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.FruitsGr), activity);
                    }
                });

                dialogClassGr.Before3 = BeforeOption;
                break;


            case "Λεμόνι":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("medfly", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("aphis", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("phyllocnistis_citrella", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("thrips", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("planococcus", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("red_scale", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("lepidosaphes_beckii", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("icerya", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("citrus_red_mite", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr), imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Lemon_Orange__Mandarine_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog); mSolutionFor.setText(activity.getResources().getString(R.string.ThirdButtonTextGr));
                dialogClassGr.flag=1;
                ButtonArray.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("apple","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("strawberry","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("pear","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("apriums","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("watermelon","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cherry","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("lemon","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("mandarin","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("peach","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("fig","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("orange","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.FruitsGr), activity);
                    }
                });

                dialogClassGr.Before3 = BeforeOption;
                break;

            case "Μανταρίνι":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("medfly", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("aphis", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("phyllocnistis_citrella", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("thrips", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("planococcus", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("red_scale", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("lepidosaphes_beckii", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("icerya", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("citrus_red_mite", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr), imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Lemon_Orange__Mandarine_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                dialogClassGr.flag=1; mSolutionFor.setText(activity.getResources().getString(R.string.ThirdButtonTextGr));
                ButtonArray.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("apple","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("strawberry","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("pear","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("apriums","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("watermelon","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cherry","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("lemon","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("mandarin","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("peach","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("fig","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("orange","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.FruitsGr), activity);
                    }
                });


                dialogClassGr.Before3 = BeforeOption;
                break;

            case "Ροδάκινο":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("monilia_cenerea", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("taphrina_deformans", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("coryneum", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("oidium", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("vertic", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("puccinia_pruni_spinosae", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("anthracnose_of_cucurbits", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("kylindrosporiosi", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("fusicladium_pirinum", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr), imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Apricot_Peach_Cherry_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog); mSolutionFor.setText(activity.getResources().getString(R.string.ThirdButtonTextGr));
                dialogClassGr.flag=1;
                ButtonArray.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("apple","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("strawberry","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("pear","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("apriums","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("watermelon","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cherry","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("lemon","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("mandarin","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("peach","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("fig","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("orange","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.FruitsGr), activity);
                    }
                });

                dialogClassGr.Before3 = BeforeOption;
                break;
            case "Σύκο":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("medfly", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("ceroplastes_rusci", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("aceria_fici", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("phytophthora", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("lonchaea", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr), imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Fig_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog); mSolutionFor.setText(activity.getResources().getString(R.string.ThirdButtonTextGr));
                dialogClassGr.flag=1;
                ButtonArray.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("apple","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("strawberry","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("pear","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("apriums","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("watermelon","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cherry","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("lemon","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("mandarin","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("peach","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("fig","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("orange","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.FruitsGr), activity);
                    }
                });

                dialogClassGr.Before3 = BeforeOption;
                break;

            case "Πορτοκάλι":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("medfly", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("aphis", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("phyllocnistis_citrella", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("thrips", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("planococcus", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("red_scale", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("lepidosaphes_beckii", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("icerya", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("citrus_red_mite", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr), imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Lemon_Orange__Mandarine_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog); mSolutionFor.setText(activity.getResources().getString(R.string.ThirdButtonTextGr));
                dialogClassGr.flag=1;
                ButtonArray.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("apple","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("strawberry","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("pear","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("apriums","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("watermelon","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cherry","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("lemon","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("mandarin","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("peach","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("fig","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("orange","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.FruitsGr), activity);
                    }
                });


                dialogClassGr.Before3 = BeforeOption;
                break;


        }


    }








    public void FarmingListFruitsBugsOptionActivateEn(final Context context, String BeforeOption, final Activity activity , final ArrayList<Button> ButtonArray , final ListView listView) {

        final ArrayList<Integer> imageid = new ArrayList<>();
        AlertDialog mTipAlertDialog ;
        Tip_Dialog mTipDialogClass = new Tip_Dialog();
        Timers_Class mTimerClass = new Timers_Class();
        dialogs_class =new Dialogs_Class();
        switch (BeforeOption) {
            case "Apple":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("apple_mosaic_virus", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("fusicladium", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("powdery_mildew", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("parasitic", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("phytophthora", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("cydia_pomonella", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("adoxophyes_orana", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("panonychus_ulmi", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("aphis", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("cossus_linnaeus", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogs_class.CreateDialogForProblem(context, "Solutuion For", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Apple_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                dialogs_class.flag=1;
                dialogs_class.Before3 = BeforeOption;
                ButtonArray.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("apple","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("strawberry","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("pear","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("apriums","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("watermelon","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cherry","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("lemon","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("mandarin","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("peach","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("fig","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("orange","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        dialogs_class.CreateDialogForProblem(context,"Solution For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Fruits), activity);
                    }
                });
                break;
            case "Strawberry":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("aphis", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("thrips", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("tetranychus_urticae", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("lygus_hesperus", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogs_class. CreateDialogForProblem(context, "Solutuion For", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Strawberry_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                dialogs_class.flag=1;
                dialogs_class.Before3 = BeforeOption;
                ButtonArray.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("apple","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("strawberry","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("pear","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("apriums","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("watermelon","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cherry","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("lemon","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("mandarin","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("peach","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("fig","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("orange","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        dialogs_class.CreateDialogForProblem(context,"Solution For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Fruits), activity);
                    }
                });
                break;
            case "Pear":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("fusicladium_pirinum", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("septoria_pyricola", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("oidium", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("brown_rot", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("parasitic", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("erwinia_amylovora", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("cacopsylla_pyri", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogs_class.CreateDialogForProblem(context, "Solutuion For", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Pear_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                dialogs_class.flag=1;
                dialogs_class.Before3 = BeforeOption;
                ButtonArray.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("apple","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("strawberry","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("pear","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("apriums","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("watermelon","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cherry","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("lemon","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("mandarin","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("peach","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("fig","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("orange","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        dialogs_class.CreateDialogForProblem(context,"Solution For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Fruits), activity);
                    }
                });
                break;
            case "Apricot":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("monilia_cenerea", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("taphrina_deformans", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("coryneum", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("oidium", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("vertic", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("puccinia_pruni_spinosae", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("anthracnose_of_cucurbits", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("kylindrosporiosi", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("fusicladium_pirinum", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogs_class.CreateDialogForProblem(context, "Solutuion For", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Apricot_Peach_Cherry_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                dialogs_class.flag=1;
                dialogs_class.Before3 = BeforeOption;
                ButtonArray.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("apple","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("strawberry","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("pear","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("apriums","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("watermelon","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cherry","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("lemon","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("mandarin","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("peach","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("fig","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("orange","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        dialogs_class.CreateDialogForProblem(context,"Solution For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Fruits), activity);
                    }
                });
                break;


            case "Watermelon":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("pseudoperonospora_cubensis", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("oidium", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("altenaria", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("anthracnose_of_cucurbits", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("cladosporium_cucumarinum", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("rhizoctonia", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("sclerotiniasclerotiorum", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("phytophthora", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("apple_mosaic_virus", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("melodoigyne", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("acalymma_trivittatum", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("heliothrips", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("tetranychus_urticae", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogs_class. CreateDialogForProblem(context, "Solutuion For", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Watermelon_bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                dialogs_class.flag=1;
                dialogs_class.Before3 = BeforeOption;
                ButtonArray.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("apple","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("strawberry","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("pear","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("apriums","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("watermelon","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cherry","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("lemon","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("mandarin","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("peach","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("fig","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("orange","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        dialogs_class.CreateDialogForProblem(context,"Solution For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Fruits), activity);
                    }
                });
                break;



            case "Cherry":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("monilia_cenerea", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("taphrina_deformans", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("coryneum", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("oidium", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("vertic", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("puccinia_pruni_spinosae", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("anthracnose_of_cucurbits", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("kylindrosporiosi", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("fusicladium_pirinum", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogs_class.CreateDialogForProblem(context, "Solutuion For", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Apricot_Peach_Cherry_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                dialogs_class.flag=1;
                dialogs_class.Before3 = BeforeOption;
                ButtonArray.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("apple","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("strawberry","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("pear","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("apriums","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("watermelon","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cherry","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("lemon","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("mandarin","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("peach","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("fig","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("orange","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        dialogs_class.CreateDialogForProblem(context,"Solution For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Fruits), activity);
                    }
                });
                break;


            case "Lemon":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("medfly", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("aphis", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("phyllocnistis_citrella", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("thrips", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("planococcus", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("red_scale", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("lepidosaphes_beckii", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("icerya", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("citrus_red_mite", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogs_class.CreateDialogForProblem(context, "Solutuion For", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Lemon_Orange__Mandarine_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                dialogs_class.flag=1;
                dialogs_class.Before3 = BeforeOption;
                ButtonArray.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("apple","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("strawberry","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("pear","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("apriums","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("watermelon","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cherry","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("lemon","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("mandarin","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("peach","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("fig","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("orange","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        dialogs_class.CreateDialogForProblem(context,"Solution For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Fruits), activity);
                    }
                });
                break;

            case "Mandarin":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("medfly", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("aphis", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("phyllocnistis_citrella", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("thrips", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("planococcus", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("red_scale", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("lepidosaphes_beckii", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("icerya", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("citrus_red_mite", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogs_class.CreateDialogForProblem(context, "Solutuion For", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Lemon_Orange__Mandarine_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                dialogs_class.flag=1;
                dialogs_class.Before3 = BeforeOption;
                ButtonArray.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("apple","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("strawberry","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("pear","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("apriums","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("watermelon","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cherry","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("lemon","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("mandarin","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("peach","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("fig","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("orange","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        dialogs_class.CreateDialogForProblem(context,"Solution For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Fruits), activity);
                    }
                });
                break;

            case "Peach":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("monilia_cenerea", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("taphrina_deformans", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("coryneum", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("oidium", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("vertic", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("puccinia_pruni_spinosae", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("anthracnose_of_cucurbits", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("kylindrosporiosi", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("fusicladium_pirinum", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogs_class.CreateDialogForProblem(context, "Solutuion For", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Apricot_Peach_Cherry_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                dialogs_class.flag=1;
                dialogs_class.Before3 = BeforeOption;
                ButtonArray.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("apple","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("strawberry","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("pear","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("apriums","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("watermelon","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cherry","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("lemon","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("mandarin","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("peach","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("fig","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("orange","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        dialogs_class.CreateDialogForProblem(context,"Solution For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Fruits), activity);
                    }
                });
                break;
            case "Fig":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("medfly", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("ceroplastes_rusci", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("aceria_fici", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("phytophthora", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("lonchaea", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogs_class.CreateDialogForProblem(context, "Solutuion For", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Fig_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                dialogs_class.flag=1;
                dialogs_class.Before3 = BeforeOption;
                ButtonArray.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("apple","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("strawberry","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("pear","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("apriums","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("watermelon","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cherry","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("lemon","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("mandarin","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("peach","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("fig","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("orange","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        dialogs_class.CreateDialogForProblem(context,"Solution For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Fruits), activity);
                    }
                });
                break;

            case "Orange":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("medfly", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("aphis", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("phyllocnistis_citrella", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("thrips", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("planococcus", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("red_scale", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("lepidosaphes_beckii", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("icerya", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("citrus_red_mite", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogs_class.CreateDialogForProblem(context, "Solutuion For", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Lemon_Orange__Mandarine_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                dialogs_class.flag=1;
                dialogs_class. Before3 = BeforeOption;
                ButtonArray.get(2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("apple","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("strawberry","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("pear","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("apriums","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("watermelon","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cherry","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("lemon","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("mandarin","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("peach","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("fig","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("orange","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        dialogs_class.CreateDialogForProblem(context,"Solution For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Fruits), activity);
                    }
                });
                break;


        }


    }





}
