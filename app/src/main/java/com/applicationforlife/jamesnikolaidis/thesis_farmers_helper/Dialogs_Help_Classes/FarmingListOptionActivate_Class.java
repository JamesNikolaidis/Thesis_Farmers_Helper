package com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Dialogs_Help_Classes;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Dialogs.DialogClassGr;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Dialogs.Dialogs_Class;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.R;

import java.util.ArrayList;

/**
 * Created by James Nikolaidis on 1/31/2017.
 */

public class FarmingListOptionActivate_Class {

        private DialogClassGr dialogClassGr;
        private Dialogs_Class dialogs_class;
        public FarmingListOptionActivate_Class(){}


    public void FarmingListOptionActivate(final Context context, String BeforeOption, final Activity activity, final SharedPreferences.Editor editor , final ArrayList<Button> ButtonArray , TextView mSolutionFor , final ListView listView) {
        final ArrayList<Integer> imageid = new ArrayList<>();

        dialogClassGr = new DialogClassGr();
        switch (BeforeOption) {
            case "Λαχανικά":
                imageid.clear();
                mSolutionFor.setText(activity.getResources().getString(R.string.ThirdButtonTextGr));
                imageid.add(activity.getResources().getIdentifier("cucumber","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("artichoke","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("cauliflower","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("spinach","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("onion","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("cabbage","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("broccoli","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("tomato","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.VegetablesGr), activity);

                ButtonArray.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("vegetables_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("legumes_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("fruits_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cereal_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("olives_amin_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cereal_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("nuts", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        editor.putBoolean("Clicked1",true);
                        editor.commit();
                        editor.putBoolean("Clicked",false);
                        editor.commit();
                        dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_CultureGr), activity);
                    }
                });
                dialogClassGr.BeforeOption2 =BeforeOption;
                break;
            case "Όσπρια":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("beans","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("lentils","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("chickpeas","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("peas","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.LegumesGr), activity);

                ButtonArray.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("vegetables_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("legumes_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("fruits_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cereal_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("olives_amin_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cereal_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("nuts", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        editor.putBoolean("Clicked1",true);
                        editor.commit();
                        editor.putBoolean("Clicked",false);
                        editor.commit();
                        dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_CultureGr), activity);
                    }
                });
                dialogClassGr.BeforeOption2 =BeforeOption;
                break;
            case "Φρούτα":
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
                ButtonArray.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("vegetables_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("legumes_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("fruits_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cereal_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("olives_amin_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cereal_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("nuts", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        editor.putBoolean("Clicked1",true);
                        editor.commit();
                        editor.putBoolean("Clicked",false);
                        editor.commit();
                        dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView,ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_CultureGr), activity);
                    }
                });
                dialogClassGr.BeforeOption2 =BeforeOption;
                break;
            case "Δημητριακά":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("rice","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("wheat","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("oats","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("corn","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("barley","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));

                dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.CerealsGr), activity);
                ButtonArray.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("vegetables_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("legumes_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("fruits_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cereal_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("olives_amin_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cereal_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("nuts", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        editor.putBoolean("Clicked1",true);
                        editor.commit();
                        editor.putBoolean("Clicked",false);
                        editor.commit();
                        dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_CultureGr), activity);
                    }
                });
                dialogClassGr.BeforeOption2 =BeforeOption;
                break;
            case "Ελιά":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("olives","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));

                dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.olives), activity);
                ButtonArray.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("vegetables_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("legumes_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("fruits_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cereal_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("olives_amin_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cereal_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("nuts", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        editor.putBoolean("Clicked1",true);
                        editor.commit();
                        editor.putBoolean("Clicked",false);
                        editor.commit();
                        dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_CultureGr), activity);
                    }
                });
                dialogClassGr.BeforeOption2 =BeforeOption;
                break;

            default:
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("almond","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("peanut","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("hazel_nuts","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("chestnuts","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("walnuts","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid, listView,ButtonArray.get(2), activity.getResources().getStringArray(R.array.Tree_NutsGr), activity);
                ButtonArray.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("vegetables_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("legumes_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("fruits_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cereal_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("olives_amin_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cereal_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("nuts", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        editor.putBoolean("Clicked1",true);
                        editor.commit();
                        editor.putBoolean("Clicked",false);
                        editor.commit();
                        dialogClassGr.CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_CultureGr), activity);
                    }
                });
                dialogClassGr.BeforeOption2 =BeforeOption;
                break;


        }

    }









    public void FarmingListOptionActivateEn(final Context context, String BeforeOption, final Activity activity, final SharedPreferences.Editor editor , final ArrayList<Button> ButtonArray , final ListView listView) {
        final ArrayList<Integer> imageid = new ArrayList<>();
        dialogs_class = new Dialogs_Class();


        switch (BeforeOption) {
            case "Vegetables":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("cucumber","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("artichoke","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("cauliflower","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("spinach","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("onion","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("cabbage","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("broccoli","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("tomato","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogs_class.CreateDialogForProblem(context,"Solutuion For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Vegetables), activity);
                ButtonArray.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("vegetables_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("legumes_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("fruits_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cereal_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("olives_amin_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cereal_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("nuts", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        editor.putBoolean("Clicked1",true);
                        editor.commit();
                        editor.putBoolean("Clicked",false);
                        editor.commit();
                        dialogs_class.CreateDialogForProblem(context,"Solutuion For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_Culture), activity);
                    }
                });
                dialogs_class.BeforeOption2 =BeforeOption;
                break;
            case "Legumes":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("beans","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("lentils","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("chickpeas","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("peas","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogs_class.CreateDialogForProblem(context,"Solutuion For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Legumes), activity);

                ButtonArray.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("vegetables_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("legumes_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("fruits_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cereal_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("olives_amin_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cereal_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("nuts", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        editor.putBoolean("Clicked1",true);
                        editor.commit();
                        editor.putBoolean("Clicked",false);
                        editor.commit();
                        dialogs_class.CreateDialogForProblem(context,"Solutuion For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_Culture), activity);
                    }
                });
                dialogs_class.BeforeOption2 =BeforeOption;
                break;
            case "Fruits":
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
                dialogs_class.CreateDialogForProblem(context,"Solutuion For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Fruits), activity);
                ButtonArray.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("vegetables_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("legumes_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("fruits_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cereal_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("olives_amin_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cereal_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("nuts", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        editor.putBoolean("Clicked1",true);
                        editor.commit();
                        editor.putBoolean("Clicked",false);
                        editor.commit();
                        dialogs_class.CreateDialogForProblem(context,"Solutuion For",imageid,listView,ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_Culture), activity);
                    }
                });
                dialogs_class.BeforeOption2 =BeforeOption;
                break;
            case "Cereal":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("rice","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("wheat","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("oats","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("corn","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("barley","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogs_class.CreateDialogForProblem(context,"Solutuion For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Cereals), activity);
                ButtonArray.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("vegetables_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("legumes_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("fruits_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cereal_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("olives_amin_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cereal_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("nuts", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        editor.putBoolean("Clicked1",true);
                        editor.commit();
                        editor.putBoolean("Clicked",false);
                        editor.commit();
                        dialogs_class.CreateDialogForProblem(context,"Solutuion For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_Culture), activity);
                    }
                });
                dialogs_class.BeforeOption2 =BeforeOption;
                break;
            case "Olives":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("olives","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogs_class.CreateDialogForProblem(context,"Solutuion For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.olives), activity);
                ButtonArray.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("vegetables_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("legumes_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("fruits_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cereal_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("olives_amin_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cereal_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("nuts", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        editor.putBoolean("Clicked1",true);
                        editor.commit();
                        editor.putBoolean("Clicked",false);
                        editor.commit();
                        dialogs_class.CreateDialogForProblem(context,"Solutuion For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_Culture), activity);
                    }
                });
                dialogs_class.BeforeOption2 =BeforeOption;
                break;

            default:
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("almond","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("peanut","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("hazel_nuts","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("chestnuts","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("walnuts","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                dialogs_class.CreateDialogForProblem(context,"Solutuion For",imageid, listView,ButtonArray.get(2), activity.getResources().getStringArray(R.array.Tree_Nuts), activity);
                ButtonArray.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageid.clear();
                        imageid.add(activity.getResources().getIdentifier("vegetables_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("legumes_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("fruits_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cereal_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("olives_amin_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("cereal_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        imageid.add(activity.getResources().getIdentifier("nuts", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        editor.putBoolean("Clicked1",true);
                        editor.commit();
                        editor.putBoolean("Clicked",false);
                        editor.commit();
                        dialogs_class.CreateDialogForProblem(context,"Solutuion For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_Culture), activity);
                    }
                });
                dialogs_class.BeforeOption2 =BeforeOption;
                break;


        }

    }










}
