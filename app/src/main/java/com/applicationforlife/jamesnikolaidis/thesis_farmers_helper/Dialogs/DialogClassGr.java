package com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Adapters.CustomAdapter;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Dialogs_Help_Classes.ActivateAnotherDialog_Class;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Dialogs_Help_Classes.BugsListOptionActivate_Class;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Dialogs_Help_Classes.FarmingListCerealBugsOptionActivate_Class;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Dialogs_Help_Classes.FarmingListFruitsBugsOptionActivate_Class;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Dialogs_Help_Classes.FarmingListLegumesBugsOptionActivate_Class;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Dialogs_Help_Classes.FarmingListNutsBugsOptionActivate_Class;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Dialogs_Help_Classes.FarmingListOptionActivate_Class;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Dialogs_Help_Classes.FarmingListVegetablesBugsOptionActivate_Class;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Listeners.Dialog_On_Long_Click_Listener;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Network_Wifi.Network_Wifi_Class;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Photos_Fuctions.Photos_Functions;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.R;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Timers.AndroidBackBackSensitivityContol;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Timers.Timers_Class;

import java.util.ArrayList;

/**
 * Created by James Nikolaidis on 11/5/2016.
 */

public class DialogClassGr  {

    private static ArrayList<LinearLayout> LayoutArray;
    private static  ArrayList<Button> ButtonArray;
    private Photos_Functions photos_functions ;
    public static String BeforeOption1 ="",BeforeOption2="",Before3="";
    private static SharedPreferences share ;
    private static SharedPreferences.Editor editor;
    private static ListView listView;
    private  static ArrayList<Integer> list_of_image_id ;
    public static int LongClickFlag = 0;
    public static  int flag = 0, anotherflag=0;
    private Network_Wifi_Class mNetwork_and_Wifi_Object;
    private Timers_Class mTimerClass;
    private Tip_Dialog mTipDialogClass;
    private AlertDialog mTipAlertDialog ;
    private Dialog_On_Long_Click_Listener mDialog_On_Long_Click_Listener;
    public static int LockAndroidBackButtonSensitivity=0;
    private static Button btn;
    private  static int i=0;
    private TextView mSpecifyProblem,mSolutionFor;
    private AndroidBackBackSensitivityContol mBackButonController;
    private ActivateAnotherDialog_Class mHelpClasses;



    private BugsListOptionActivate_Class bugsListOptionActivate_class;
    private FarmingListOptionActivate_Class farmingListOptionActivate_class;
    private FarmingListVegetablesBugsOptionActivate_Class farmingListVegetablesBugsOptionActivate_class;
    private FarmingListLegumesBugsOptionActivate_Class farmingListLegumesBugsOptionActivate_class;
    private FarmingListFruitsBugsOptionActivate_Class farmingListFruitsBugsOptionActivate_class;
    private FarmingListCerealBugsOptionActivate_Class farmingListCerealBugsOptionActivate_class;
    private FarmingListNutsBugsOptionActivate_Class farmingListNutsBugsOptionActivate_class;






    public  DialogClassGr(){}

    public DialogClassGr(Context context) {

        LayoutArray = new ArrayList<>();
        ButtonArray = new ArrayList<>();
        list_of_image_id = new ArrayList<Integer>();


    }


    public void DeclareLayouts(LinearLayout ...layouts){
        LayoutArray.add(layouts[0]);
        LayoutArray.add(layouts[1]);
        LayoutArray.add(layouts[2]);


    }

    public void DeclareButtons(Button ...buttons){
        ButtonArray.add(buttons[0]);
        ButtonArray.add(buttons[1]);
        ButtonArray.add(buttons[2]);

    }

    public void CreateDialogForProblem(final Context context, String texttitle , final ArrayList<Integer> ImagesId, final ListView list,  Button button, final String[] array, final Activity activity) {
        share = activity.getSharedPreferences("Data", Activity.MODE_PRIVATE);
        editor = share.edit();
        listView = list;
        mNetwork_and_Wifi_Object = new Network_Wifi_Class(context, activity);
        mDialog_On_Long_Click_Listener = new Dialog_On_Long_Click_Listener();
        mBackButonController = new AndroidBackBackSensitivityContol();
        photos_functions = new Photos_Functions();
        mTimerClass = new Timers_Class();
        mTipDialogClass = new Tip_Dialog();
        btn = button;
        mHelpClasses = new ActivateAnotherDialog_Class();
        mSpecifyProblem = (TextView)activity.findViewById(R.id.SpecifyProblem);
        mSolutionFor = (TextView)activity.findViewById(R.id.SolutionFor);
        final AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(activity, R.style.AlertDialogCustom));
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ListAdapter adapter = new CustomAdapter(context, array, ImagesId);
        final AlertDialog dialog = builder.create();
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.show();
        dialog.setCancelable(false);

        dialog.setContentView(R.layout.dialog_layout);
        final TextView title = (TextView) dialog.findViewById(R.id.TitleTextView);
        title.setText(texttitle);

        farmingListOptionActivate_class = new FarmingListOptionActivate_Class();
        bugsListOptionActivate_class =new BugsListOptionActivate_Class();
        farmingListVegetablesBugsOptionActivate_class = new FarmingListVegetablesBugsOptionActivate_Class();
        farmingListLegumesBugsOptionActivate_class = new FarmingListLegumesBugsOptionActivate_Class();
        farmingListFruitsBugsOptionActivate_class =new FarmingListFruitsBugsOptionActivate_Class();
        farmingListCerealBugsOptionActivate_class = new FarmingListCerealBugsOptionActivate_Class();
        farmingListNutsBugsOptionActivate_class =new FarmingListNutsBugsOptionActivate_Class();



        Button BackButton = (Button) dialog.findViewById(R.id.back_button);
        ListView il = (ListView) dialog.findViewById(R.id.ListView);

        dialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i == KeyEvent.KEYCODE_BACK) {
                    anotherflag = 0;
                    if(LockAndroidBackButtonSensitivity==0){
                        i++;

                        if (share.getBoolean("Clicked", false) == true) {
                            dialog.dismiss();


                        }

                        if (share.getBoolean("Clicked", false) == false && share.getBoolean("Clicked1", false) == true) {

                            dialog.dismiss();
                            list_of_image_id.clear();
                            list_of_image_id.add(activity.getResources().getIdentifier("weeds", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                            list_of_image_id.add(activity.getResources().getIdentifier("farming1", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                            CreateDialogForProblem(context,activity.getResources().getString(R.string.FirstButtonTextGr), list_of_image_id, (ListView) dialog.findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.FirstPanelNamesGr), activity);
                            editor.putBoolean("Clicked1", false);
                            editor.putBoolean("Clicked", true);
                            editor.commit();


                        }
                        if (share.getBoolean("Clicked", false) == false && share.getBoolean("Clicked1", false) == false) {
                            list_of_image_id.clear();
                            if (flag == 0) {
                                switch (BeforeOption2) {
                                    case "Εχθροί":
                                        dialog.dismiss();
                                        list_of_image_id.clear();
                                        list_of_image_id = photos_functions.getMainDialogPhotos(activity);
                                        CreateDialogForProblem(context,activity.getResources().getString(R.string.SecondButtonTextGr), list_of_image_id, (ListView) dialog.findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Bugs_ListGr), activity);
                                        editor.putBoolean("Clicked1", true);
                                        editor.commit();
                                        break;
                                    case "Ασθένειες":
                                        dialog.dismiss();
                                        list_of_image_id.clear();
                                        list_of_image_id = photos_functions.getMainDialogPhotos(activity);
                                        CreateDialogForProblem(context,activity.getResources().getString(R.string.SecondButtonTextGr), list_of_image_id, (ListView) dialog.findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Bugs_ListGr), activity);
                                        editor.putBoolean("Clicked1", true);
                                        editor.commit();

                                        break;
                                    case "Ζιζάνια":
                                        dialog.dismiss();
                                        list_of_image_id.clear();
                                        list_of_image_id = photos_functions.getMainDialogPhotos(activity);
                                        CreateDialogForProblem(context,activity.getResources().getString(R.string.SecondButtonTextGr), list_of_image_id, (ListView) dialog.findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Bugs_ListGr), activity);
                                        editor.putBoolean("Clicked1", true);
                                        editor.commit();

                                        break;

                                    case "Λαχανικά":
                                        dialog.dismiss();
                                        list_of_image_id.clear();
                                        list_of_image_id = photos_functions.getFarmingPhotos(activity);
                                        CreateDialogForProblem(context,activity.getResources().getString(R.string.SecondButtonTextGr), list_of_image_id, (ListView) dialog.findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_CultureGr), activity);
                                        editor.putBoolean("Clicked1", true);
                                        editor.commit();

                                        break;
                                    case "Όσπρια":
                                        dialog.dismiss();
                                        list_of_image_id.clear();
                                        list_of_image_id = photos_functions.getFarmingPhotos(activity);
                                        CreateDialogForProblem(context,activity.getResources().getString(R.string.SecondButtonTextGr), list_of_image_id, (ListView) dialog.findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_CultureGr), activity);
                                        editor.putBoolean("Clicked1", true);
                                        editor.commit();

                                        break;
                                    case "Φρούτα":
                                        dialog.dismiss();
                                        list_of_image_id.clear();
                                        list_of_image_id = photos_functions.getFarmingPhotos(activity);
                                        CreateDialogForProblem(context,activity.getResources().getString(R.string.SecondButtonTextGr), list_of_image_id, (ListView) dialog.findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_CultureGr), activity);
                                        editor.putBoolean("Clicked1", true);
                                        editor.commit();

                                        break;
                                    case "Δημητριακά":
                                        dialog.dismiss();
                                        list_of_image_id.clear();
                                        list_of_image_id = photos_functions.getFarmingPhotos(activity);
                                        CreateDialogForProblem(context,activity.getResources().getString(R.string.SecondButtonTextGr), list_of_image_id, (ListView) dialog.findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_CultureGr), activity);
                                        editor.putBoolean("Clicked1", true);
                                        editor.commit();

                                        break;
                                    case "Ελιά":
                                        dialog.dismiss();
                                        list_of_image_id.clear();
                                        list_of_image_id = photos_functions.getFarmingPhotos(activity);
                                        CreateDialogForProblem(context,activity.getResources().getString(R.string.SecondButtonTextGr), list_of_image_id, (ListView) dialog.findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_CultureGr), activity);
                                        editor.putBoolean("Clicked1", true);
                                        editor.commit();

                                        break;
                                    case "Ξηροί Καρποί":
                                        dialog.dismiss();
                                        list_of_image_id.clear();
                                        list_of_image_id = photos_functions.getFarmingPhotos(activity);
                                        CreateDialogForProblem(context,activity.getResources().getString(R.string.SecondButtonTextGr), list_of_image_id, (ListView) dialog.findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_CultureGr), activity);
                                        editor.putBoolean("Clicked1", true);
                                        editor.commit();

                                        break;


                                }

                            } else {
                                if (Before3.matches("Πορτοκάλι") || Before3.matches("Μήλο") || Before3.matches("Φράουλα") || Before3.matches("Αχλάδι") || Before3.matches("Βερυκόκο") || Before3.matches("Καρπούζι") || Before3.matches("Κεράσι") || Before3.matches("Μανταρίνη") || Before3.matches("Σύκο") || Before3.matches("Ροδάκινο")) {
                                    dialog.dismiss();
                                    list_of_image_id.clear();
                                    list_of_image_id = photos_functions.getFruitsPhotos(activity);
                                    CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr), list_of_image_id, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.FruitsGr), activity);
                                    flag = 0;


                                } else if (Before3.matches("Ρύζι") || Before3.matches("Σιτάρι") || Before3.matches("Βρώμη") || Before3.matches("Καλαμπόκι") || Before3.matches("Κριθάρι")) {

                                    dialog.dismiss();
                                    list_of_image_id.clear();
                                    list_of_image_id = photos_functions.getCerealPhotos(activity);
                                    CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr), list_of_image_id, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.CerealsGr), activity);
                                    flag = 0;

                                } else if (Before3.matches("Φασόλια") || Before3.matches("Φακές") || Before3.matches("Ρεβύθια") || Before3.matches("Μπίζελια")) {

                                    dialog.dismiss();
                                    list_of_image_id.clear();
                                    list_of_image_id = photos_functions.getLentilPhotos(activity);
                                    CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr), list_of_image_id, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.LegumesGr), activity);
                                    flag = 0;

                                } else if (Before3.matches("Αγγούρι") || Before3.matches("Αγγινάρα") || Before3.matches("Κουνούπιδι") || Before3.matches("Σπανάκι") || Before3.matches("Κρεμμύδι") || Before3.matches("Λάχανο") || Before3.matches("Μπρόκολο") || Before3.matches("Ντομάτα")) {

                                    dialog.dismiss();
                                    list_of_image_id.clear();
                                    list_of_image_id = photos_functions.getVegetablesPhotos(activity);
                                    CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr), list_of_image_id, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.VegetablesGr), activity);
                                    flag = 0;
                                } else if (Before3.matches("Αμυγδαλιά") || Before3.matches("Φυστικιά") || Before3.matches("Φουντουκιά") || Before3.matches("Καστανιά") || Before3.matches("Καρυδιά")) {

                                    dialog.dismiss();
                                    list_of_image_id.clear();
                                    list_of_image_id = photos_functions.getNutsPhotos(activity);
                                    CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr), list_of_image_id, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Tree_NutsGr), activity);
                                    flag = 0;

                                }


                            }


                        }


                        LockAndroidBackButtonSensitivity++;
                        mBackButonController.ActivateLockMethodAndGetValueWhenReadyGr();


                    }


                }
                return false;
            }



        });





        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                anotherflag = 0;

                if (share.getBoolean("Clicked", false) == true) {
                    dialog.dismiss();


                } else if (share.getBoolean("Clicked", false) == false && share.getBoolean("Clicked1", false) == true) {
                    dialog.dismiss();

                    list_of_image_id.clear();
                    list_of_image_id.add(activity.getResources().getIdentifier("weeds", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                    list_of_image_id.add(activity.getResources().getIdentifier("farming1", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                    CreateDialogForProblem(context,activity.getResources().getString(R.string.FirstButtonTextGr), list_of_image_id, (ListView) dialog.findViewById(R.id.ListView), ButtonArray.get(1), activity.getResources().getStringArray(R.array.FirstPanelNamesGr), activity);
                    editor.putBoolean("Clicked1", false);
                    editor.putBoolean("Clicked", true);
                    editor.commit();



                } else if (share.getBoolean("Clicked", false) == false && share.getBoolean("Clicked1", false) == false) {
                    list_of_image_id.clear();
                    if (flag == 0) {
                        switch (BeforeOption2) {
                            case "Εχθροί":
                                dialog.dismiss();
                                list_of_image_id.clear();
                                list_of_image_id = photos_functions.getMainDialogPhotos(activity);
                                CreateDialogForProblem(context,activity.getResources().getString(R.string.SecondButtonTextGr), list_of_image_id, (ListView) dialog.findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Bugs_ListGr), activity);
                                editor.putBoolean("Clicked1", true);
                                editor.commit();
                                break;
                            case "Ασθένειες":
                                dialog.dismiss();
                                list_of_image_id.clear();
                                list_of_image_id = photos_functions.getMainDialogPhotos(activity);
                                CreateDialogForProblem(context,activity.getResources().getString(R.string.SecondButtonTextGr), list_of_image_id, (ListView) dialog.findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Bugs_ListGr), activity);
                                editor.putBoolean("Clicked1", true);
                                editor.commit();
                                break;
                            case "Ζιζάνια":
                                dialog.dismiss();
                                list_of_image_id.clear();
                                list_of_image_id = photos_functions.getMainDialogPhotos(activity);
                                CreateDialogForProblem(context,activity.getResources().getString(R.string.SecondButtonTextGr), list_of_image_id, (ListView) dialog.findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Bugs_ListGr), activity);
                                editor.putBoolean("Clicked1", true);
                                editor.commit();

                                break;

                            case "Λαχανικά":
                                dialog.dismiss();
                                list_of_image_id.clear();
                                list_of_image_id = photos_functions.getFarmingPhotos(activity);
                                CreateDialogForProblem(context,activity.getResources().getString(R.string.SecondButtonTextGr), list_of_image_id, (ListView)dialog. findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_CultureGr), activity);
                                editor.putBoolean("Clicked1", true);
                                editor.commit();

                                break;
                            case "Όσπρια":
                                dialog.dismiss();
                                list_of_image_id.clear();
                                list_of_image_id = photos_functions.getFarmingPhotos(activity);
                                CreateDialogForProblem(context,activity.getResources().getString(R.string.SecondButtonTextGr), list_of_image_id, (ListView) dialog.findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_CultureGr), activity);
                                editor.putBoolean("Clicked1", true);
                                editor.commit();

                                break;
                            case "Φρούτα":
                                dialog.dismiss();
                                list_of_image_id.clear();
                                list_of_image_id = photos_functions.getFarmingPhotos(activity);
                                CreateDialogForProblem(context,activity.getResources().getString(R.string.SecondButtonTextGr), list_of_image_id, (ListView) dialog.findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_CultureGr), activity);
                                editor.putBoolean("Clicked1", true);
                                editor.commit();

                                break;
                            case "Δημητριακά":
                                dialog.dismiss();
                                list_of_image_id.clear();
                                list_of_image_id = photos_functions.getFarmingPhotos(activity);
                                CreateDialogForProblem(context,activity.getResources().getString(R.string.SecondButtonTextGr), list_of_image_id, (ListView) dialog.findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_CultureGr), activity);
                                editor.putBoolean("Clicked1", true);
                                editor.commit();

                                break;
                            case "Ελιά":
                                dialog.dismiss();
                                list_of_image_id.clear();
                                list_of_image_id = photos_functions.getFarmingPhotos(activity);
                                CreateDialogForProblem(context,activity.getResources().getString(R.string.SecondButtonTextGr), list_of_image_id, (ListView) dialog.findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_CultureGr), activity);
                                editor.putBoolean("Clicked1", true);
                                editor.commit();

                                break;
                            case "Ξηροί Καρποί":
                                dialog.dismiss();
                                list_of_image_id.clear();
                                list_of_image_id = photos_functions.getFarmingPhotos(activity);
                                CreateDialogForProblem(context,activity.getResources().getString(R.string.SecondButtonTextGr), list_of_image_id, (ListView) dialog.findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_CultureGr), activity);
                                editor.putBoolean("Clicked1", true);
                                editor.commit();

                                break;


                        }

                    } else {
                        if (Before3.matches("Πορτοκάλι") || Before3.matches("Μήλο") || Before3.matches("Φράουλα") || Before3.matches("Αχλάδι") || Before3.matches("Βερύκοκο") || Before3.matches("Καρπούζι") || Before3.matches("Κεράσι") || Before3.matches("Μανταρίνι") || Before3.matches("Σύκο") || Before3.matches("Ροδάκινο")) {
                            dialog.dismiss();
                            list_of_image_id.clear();
                            list_of_image_id = photos_functions.getFruitsPhotos(activity);
                            CreateDialogForProblem(context, activity.getResources().getString(R.string.ThirdButtonTextGr), list_of_image_id, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.FruitsGr), activity);
                            flag = 0;


                        } else if (Before3.matches("Ρύζι") || Before3.matches("Σιτάρι") || Before3.matches("Βρώμη") || Before3.matches("Καλαμπόκι") || Before3.matches("Barley")) {

                            dialog.dismiss();
                            list_of_image_id.clear();
                            list_of_image_id = photos_functions.getCerealPhotos(activity);
                            CreateDialogForProblem(context, activity.getResources().getString(R.string.ThirdButtonTextGr), list_of_image_id, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.CerealsGr), activity);
                            flag = 0;

                        } else if (Before3.matches("Φασόλια") || Before3.matches("Φακές") || Before3.matches("Ρεβύθια") || Before3.matches("Μπιζέλια")) {

                            dialog.dismiss();
                            list_of_image_id.clear();
                            list_of_image_id = photos_functions.getLentilPhotos(activity);
                            CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr), list_of_image_id, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.LegumesGr), activity);
                            flag = 0;

                        } else if (Before3.matches("Αγγούρι") || Before3.matches("Αγγινάρα") || Before3.matches("Κουνουπίδι") || Before3.matches("Σπανάκι") || Before3.matches("Κρεμμύδι") || Before3.matches("Λάχανο") || Before3.matches("Μπρόκολο") || Before3.matches("Ντομάτα")) {

                            dialog.dismiss();
                            list_of_image_id.clear();
                            list_of_image_id = photos_functions.getVegetablesPhotos(activity);
                            CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr), list_of_image_id, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.VegetablesGr), activity);
                            flag = 0;
                        } else if (Before3.matches("Αμυγδαλιά") || Before3.matches("Φυστικιά") || Before3.matches("Φουντουκιά") || Before3.matches("Καστανιά") || Before3.matches("Καρυδιά")) {

                            dialog.dismiss();
                            list_of_image_id.clear();
                            list_of_image_id = photos_functions.getNutsPhotos(activity);
                            CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr), list_of_image_id, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Tree_NutsGr), activity);
                            flag = 0;

                        }


                    }


                }

            }
        });


        il.setAdapter(adapter);
        il.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                String value = (String) adapterView.getItemAtPosition(i);
                String[] User_Choose = array;

                btn.setText((String) adapterView.getItemAtPosition(i));

                if (share.getBoolean("Clicked", false) == false) {


                    if (share.getBoolean("Clicked1", false) == false && LongClickFlag == 0) {
                        switch (BeforeOption2) {

                            case "Εχθροί":
                                mNetwork_and_Wifi_Object.CheckWifiConnectionAndEnable();
                                editor.putString("SpecifyProblem", User_Choose[i]);
                                editor.commit();
                                dialog.cancel();
                                mNetwork_and_Wifi_Object.CheckWifiConnectionAndEnable();
                                break;
                            case "Ασθένειες":
                                editor.putString("SpecifyProblem", User_Choose[i]);
                                editor.commit();
                                mNetwork_and_Wifi_Object.CheckWifiConnectionAndEnable();
                                break;
                            case "Ζιζάνια":
                                editor.putString("SpecifyProblem", User_Choose[i]);
                                editor.commit();
                                dialog.cancel();
                                mNetwork_and_Wifi_Object.CheckWifiConnectionAndEnable();
                                break;

                            case "Λαχανικά":
                                if (!Before3.isEmpty() && anotherflag == 1) {
                                    editor.putString("SpecifyProblem", User_Choose[i]);
                                    editor.commit();
                                    dialog.cancel();
                                    mNetwork_and_Wifi_Object.CheckWifiConnectionAndEnable();
                                } else {
                                    dialog.dismiss();
                                    LayoutArray.get(1).setVisibility(View.VISIBLE);
                                    editor.putString("FarmingChoice",  User_Choose[i]);
                                    editor.commit();
                                    farmingListVegetablesBugsOptionActivate_class.FarmingListVegetablesBugsOptionActivate(context, User_Choose[i], activity,ButtonArray,listView,mSolutionFor);
                                    anotherflag++;
                                }
                                break;
                            case "Όσπρια":
                                if (!Before3.isEmpty() && anotherflag == 1) {
                                    editor.putString("SpecifyProblem", User_Choose[i]);
                                    editor.commit();
                                    dialog.cancel();
                                    mNetwork_and_Wifi_Object.CheckWifiConnectionAndEnable();


                                } else {
                                    dialog.dismiss();
                                    LayoutArray.get(1).setVisibility(View.VISIBLE);
                                    editor.putString("FarmingChoice",  User_Choose[i]);
                                    editor.commit();
                                    farmingListLegumesBugsOptionActivate_class.FarmingListLegumesBugsOptionActivate(context, User_Choose[i], activity,ButtonArray,listView,mSolutionFor);
                                    anotherflag++;
                                }
                                break;

                            case "Φρούτα":
                                if (!Before3.isEmpty() && anotherflag == 1) {
                                    editor.putString("SpecifyProblem", User_Choose[i]);
                                    editor.commit();
                                    dialog.cancel();
                                    mNetwork_and_Wifi_Object.CheckWifiConnectionAndEnable();
                                } else {
                                    dialog.dismiss();
                                    LayoutArray.get(1).setVisibility(View.VISIBLE);
                                    editor.putString("FarmingChoice",  User_Choose[i]);
                                    editor.commit();
                                    farmingListFruitsBugsOptionActivate_class.FarmingListFruitsBugsOptionActivate(context, User_Choose[i], activity,ButtonArray,listView,mSolutionFor);
                                    anotherflag++;
                                }
                                break;

                            case "Ξηροί Καρποί":

                                if (!Before3.isEmpty() && anotherflag == 1) {
                                    editor.putString("SpecifyProblem", User_Choose[i]);
                                    editor.commit();
                                    dialog.cancel();
                                    mNetwork_and_Wifi_Object.CheckWifiConnectionAndEnable();


                                } else {
                                    dialog.dismiss();
                                    LayoutArray.get(1).setVisibility(View.VISIBLE);
                                    editor.putString("FarmingChoice",  User_Choose[i]);
                                    editor.commit();
                                    farmingListNutsBugsOptionActivate_class.FarmingListNutsBugsOptionActivate(context, User_Choose[i], activity,ButtonArray,listView,mSolutionFor);
                                    anotherflag++;
                                }
                                break;

                            case "Δημητριακά":

                                if (!Before3.isEmpty() && anotherflag == 1) {
                                    editor.putString("SpecifyProblem", User_Choose[i]);
                                    editor.commit();
                                    dialog.cancel();
                                    mNetwork_and_Wifi_Object.CheckWifiConnectionAndEnable();


                                } else {
                                    dialog.dismiss();
                                    LayoutArray.get(1).setVisibility(View.VISIBLE);
                                    editor.putString("FarmingChoice",  User_Choose[i]);
                                    editor.commit();
                                    farmingListCerealBugsOptionActivate_class.FarmingListCerealBugsOptionActivate(context, User_Choose[i], activity,ButtonArray,listView,mSolutionFor);
                                    anotherflag++;
                                }
                                break;

                        }


                    } else {

                        if (BeforeOption1.matches("Κατηγορία Ζιζανίων")) {

                            dialog.dismiss();
                            LayoutArray.get(0).setVisibility(View.VISIBLE);
                            list_of_image_id.clear();
                            bugsListOptionActivate_class.BugsListOptionActivate(context, User_Choose[i], activity,editor,ButtonArray,mSolutionFor,listView);
                            editor.putBoolean("Clicked1", false);
                            editor.commit();

                        } else if (BeforeOption1.matches("Κατηγορία Καλλιεργειών")) {
                            dialog.dismiss();
                            LayoutArray.get(0).setVisibility(View.VISIBLE);
                            list_of_image_id.clear();
                            farmingListOptionActivate_class.FarmingListOptionActivate(context, User_Choose[i], activity,editor,ButtonArray,mSolutionFor,listView);
                            editor.putBoolean("Clicked1", false);
                            editor.commit();

                        }





                    }


                } else {


                    if (User_Choose[i].matches("Κατηγορία Ζιζανίων") && LongClickFlag == 0) {
                        dialog.dismiss();

                        list_of_image_id.clear();
                        list_of_image_id.add(activity.getResources().getIdentifier("bugs_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        list_of_image_id.add(activity.getResources().getIdentifier("disease_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        list_of_image_id.add(activity.getResources().getIdentifier("enemies_pahid_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        mHelpClasses.ActivateAnotherDialog(context, list_of_image_id, User_Choose[i],activity,LayoutArray.get(0),editor,ButtonArray,mSpecifyProblem,listView);
                        editor.putBoolean("Clicked", false);
                        editor.commit();


                    } else if (User_Choose[i].matches("Κατηγορία Καλλιεργειών") && LongClickFlag == 0) {
                        dialog.dismiss();
                        list_of_image_id.clear();
                        list_of_image_id.add(activity.getResources().getIdentifier("vegetables_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        list_of_image_id.add(activity.getResources().getIdentifier("legumes_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        list_of_image_id.add(activity.getResources().getIdentifier("fruits_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        list_of_image_id.add(activity.getResources().getIdentifier("cereal_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        list_of_image_id.add(activity.getResources().getIdentifier("olives_amin_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        list_of_image_id.add(activity.getResources().getIdentifier("cereal_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        list_of_image_id.add(activity.getResources().getIdentifier("nuts", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                         mHelpClasses.ActivateAnotherDialog(context, list_of_image_id, User_Choose[i],activity,LayoutArray.get(0),editor,ButtonArray,mSpecifyProblem,listView);
                        editor.putBoolean("Clicked", false);
                        editor.commit();

                    }


                }


            }
        });



        mDialog_On_Long_Click_Listener.Set_Dialog_On_Long_Click_Listener(activity,context,il,array);



    }


}












