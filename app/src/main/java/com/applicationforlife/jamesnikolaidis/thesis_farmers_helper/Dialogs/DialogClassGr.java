package com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
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

public class DialogClassGr extends Dialog {

    private static ArrayList<LinearLayout> LayoutArray;
    private static  ArrayList<Button> ButtonArray;
    private Photos_Functions photos_functions ;
    public static String BeforeOption1 ="",BeforeOption2="",Before3="";
    private static SharedPreferences share ;
    private static SharedPreferences.Editor editor;
    private static ListView listView;
    private  static ArrayList<Integer> list_of_image_id ;
    public static int LongClickFlag = 0;
    private static  int flag = 0, anotherflag=0;
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


    public DialogClassGr(Context context) {
        super(context);
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
        Button BackButton = (Button) dialog.findViewById(R.id.back_button);
        ListView il = (ListView) dialog.findViewById(R.id.ListView);

        dialog.setOnKeyListener(new OnKeyListener() {
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
                            CreateDialogForProblem(context,activity.getResources().getString(R.string.FirstButtonTextGr), list_of_image_id, (ListView) findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.FirstPanelNamesGr), activity);
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
                                        CreateDialogForProblem(context,activity.getResources().getString(R.string.SecondButtonTextGr), list_of_image_id, (ListView) findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Bugs_ListGr), activity);
                                        editor.putBoolean("Clicked1", true);
                                        editor.commit();
                                        break;
                                    case "Ασθένειες":
                                        dialog.dismiss();
                                        list_of_image_id.clear();
                                        list_of_image_id = photos_functions.getMainDialogPhotos(activity);
                                        CreateDialogForProblem(context,activity.getResources().getString(R.string.SecondButtonTextGr), list_of_image_id, (ListView) findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Bugs_ListGr), activity);
                                        editor.putBoolean("Clicked1", true);
                                        editor.commit();

                                        break;
                                    case "Ζιζάνια":
                                        dialog.dismiss();
                                        list_of_image_id.clear();
                                        list_of_image_id = photos_functions.getMainDialogPhotos(activity);
                                        CreateDialogForProblem(context,activity.getResources().getString(R.string.SecondButtonTextGr), list_of_image_id, (ListView) findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Bugs_ListGr), activity);
                                        editor.putBoolean("Clicked1", true);
                                        editor.commit();

                                        break;

                                    case "Λαχανικά":
                                        dialog.dismiss();
                                        list_of_image_id.clear();
                                        list_of_image_id = photos_functions.getFarmingPhotos(activity);
                                        CreateDialogForProblem(context,activity.getResources().getString(R.string.SecondButtonTextGr), list_of_image_id, (ListView) findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_CultureGr), activity);
                                        editor.putBoolean("Clicked1", true);
                                        editor.commit();

                                        break;
                                    case "Όσπρια":
                                        dialog.dismiss();
                                        list_of_image_id.clear();
                                        list_of_image_id = photos_functions.getFarmingPhotos(activity);
                                        CreateDialogForProblem(context,activity.getResources().getString(R.string.SecondButtonTextGr), list_of_image_id, (ListView) findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_CultureGr), activity);
                                        editor.putBoolean("Clicked1", true);
                                        editor.commit();

                                        break;
                                    case "Φρούτα":
                                        dialog.dismiss();
                                        list_of_image_id.clear();
                                        list_of_image_id = photos_functions.getFarmingPhotos(activity);
                                        CreateDialogForProblem(context,activity.getResources().getString(R.string.SecondButtonTextGr), list_of_image_id, (ListView) findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_CultureGr), activity);
                                        editor.putBoolean("Clicked1", true);
                                        editor.commit();

                                        break;
                                    case "Δημητριακά":
                                        dialog.dismiss();
                                        list_of_image_id.clear();
                                        list_of_image_id = photos_functions.getFarmingPhotos(activity);
                                        CreateDialogForProblem(context,activity.getResources().getString(R.string.SecondButtonTextGr), list_of_image_id, (ListView) findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_CultureGr), activity);
                                        editor.putBoolean("Clicked1", true);
                                        editor.commit();

                                        break;
                                    case "Ελιά":
                                        dialog.dismiss();
                                        list_of_image_id.clear();
                                        list_of_image_id = photos_functions.getFarmingPhotos(activity);
                                        CreateDialogForProblem(context,activity.getResources().getString(R.string.SecondButtonTextGr), list_of_image_id, (ListView) findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_CultureGr), activity);
                                        editor.putBoolean("Clicked1", true);
                                        editor.commit();

                                        break;
                                    case "Ξηροί Καρποί":
                                        dialog.dismiss();
                                        list_of_image_id.clear();
                                        list_of_image_id = photos_functions.getFarmingPhotos(activity);
                                        CreateDialogForProblem(context,activity.getResources().getString(R.string.SecondButtonTextGr), list_of_image_id, (ListView) findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_CultureGr), activity);
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
                    CreateDialogForProblem(context,activity.getResources().getString(R.string.FirstButtonTextGr), list_of_image_id, (ListView) findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.FirstPanelNamesGr), activity);
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
                                CreateDialogForProblem(context,activity.getResources().getString(R.string.SecondButtonTextGr), list_of_image_id, (ListView) findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Bugs_ListGr), activity);
                                editor.putBoolean("Clicked1", true);
                                editor.commit();
                                break;
                            case "Ασθενείες":
                                dialog.dismiss();
                                list_of_image_id.clear();
                                list_of_image_id = photos_functions.getMainDialogPhotos(activity);
                                CreateDialogForProblem(context,activity.getResources().getString(R.string.SecondButtonTextGr), list_of_image_id, (ListView) findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Bugs_ListGr), activity);
                                editor.putBoolean("Clicked1", true);
                                editor.commit();

                                break;
                            case "Ζιζάνια":
                                dialog.dismiss();
                                list_of_image_id.clear();
                                list_of_image_id = photos_functions.getMainDialogPhotos(activity);
                                CreateDialogForProblem(context,activity.getResources().getString(R.string.SecondButtonTextGr), list_of_image_id, (ListView) findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Bugs_ListGr), activity);
                                editor.putBoolean("Clicked1", true);
                                editor.commit();

                                break;

                            case "Λαχανικά":
                                dialog.dismiss();
                                list_of_image_id.clear();
                                list_of_image_id = photos_functions.getFarmingPhotos(activity);
                                CreateDialogForProblem(context,activity.getResources().getString(R.string.SecondButtonTextGr), list_of_image_id, (ListView) findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_CultureGr), activity);
                                editor.putBoolean("Clicked1", true);
                                editor.commit();

                                break;
                            case "Όσπρια":
                                dialog.dismiss();
                                list_of_image_id.clear();
                                list_of_image_id = photos_functions.getFarmingPhotos(activity);
                                CreateDialogForProblem(context,activity.getResources().getString(R.string.SecondButtonTextGr), list_of_image_id, (ListView) findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_CultureGr), activity);
                                editor.putBoolean("Clicked1", true);
                                editor.commit();

                                break;
                            case "Φρούτα":
                                dialog.dismiss();
                                list_of_image_id.clear();
                                list_of_image_id = photos_functions.getFarmingPhotos(activity);
                                CreateDialogForProblem(context,activity.getResources().getString(R.string.SecondButtonTextGr), list_of_image_id, (ListView) findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_CultureGr), activity);
                                editor.putBoolean("Clicked1", true);
                                editor.commit();

                                break;
                            case "Δημητριακά":
                                dialog.dismiss();
                                list_of_image_id.clear();
                                list_of_image_id = photos_functions.getFarmingPhotos(activity);
                                CreateDialogForProblem(context,activity.getResources().getString(R.string.SecondButtonTextGr), list_of_image_id, (ListView) findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_CultureGr), activity);
                                editor.putBoolean("Clicked1", true);
                                editor.commit();

                                break;
                            case "Ελιά":
                                dialog.dismiss();
                                list_of_image_id.clear();
                                list_of_image_id = photos_functions.getFarmingPhotos(activity);
                                CreateDialogForProblem(context,activity.getResources().getString(R.string.SecondButtonTextGr), list_of_image_id, (ListView) findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_CultureGr), activity);
                                editor.putBoolean("Clicked1", true);
                                editor.commit();

                                break;
                            case "Ξηροί Καρποί":
                                dialog.dismiss();
                                list_of_image_id.clear();
                                list_of_image_id = photos_functions.getFarmingPhotos(activity);
                                CreateDialogForProblem(context,activity.getResources().getString(R.string.SecondButtonTextGr), list_of_image_id, (ListView) findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_CultureGr), activity);
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
                                    FarmingListVegetablesBugsOptionActivate(context, User_Choose[i], activity);
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
                                    FarmingListLegumesBugsOptionActivate(context, User_Choose[i], activity);
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
                                    FarmingListFruitsBugsOptionActivate(context, User_Choose[i], activity);
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
                                    FarmingListNutsBugsOptionActivate(context, User_Choose[i], activity);
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
                                    FarmingListCerealBugsOptionActivate(context, User_Choose[i], activity);
                                    anotherflag++;
                                }
                                break;

                        }


                    } else {

                        if (BeforeOption1.matches("Κατηγορία Ζιζανίων")) {

                            dialog.dismiss();
                            LayoutArray.get(0).setVisibility(View.VISIBLE);
                            list_of_image_id.clear();
                            BugsListOptionActivate(context, User_Choose[i], activity);
                            editor.putBoolean("Clicked1", false);
                            editor.commit();

                        } else if (BeforeOption1.matches("Κατηγορία Καλλιεργειών")) {
                            dialog.dismiss();
                            LayoutArray.get(0).setVisibility(View.VISIBLE);
                            list_of_image_id.clear();
                            FarmingListOptionActivate(context, User_Choose[i], activity);
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
                        ActivateAnotherDialog(context, list_of_image_id, User_Choose[i], activity);
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
                        ActivateAnotherDialog(context, list_of_image_id, User_Choose[i], activity);
                        editor.putBoolean("Clicked", false);
                        editor.commit();

                    }


                }


            }
        });



        mDialog_On_Long_Click_Listener.Set_Dialog_On_Long_Click_Listener(activity,context,il,array);



    }




    public void ActivateAnotherDialog(final Context context, final ArrayList<Integer> imageid, String BeforeOption, final Activity activity){

        if(LayoutArray.get(0).getVisibility()== View.INVISIBLE)
        {

            switch (BeforeOption)
            {
                case "Κατηγορία Ζιζανίων":
                   //
                    editor.putBoolean("Clicked1",true);
                    editor.commit();
                    //Here image Code
                    mSpecifyProblem.setText(activity.getResources().getString(R.string.SecondButtonTextGr));
                    CreateDialogForProblem(context,activity.getResources().getString(R.string.SecondButtonTextGr),imageid,listView,ButtonArray.get(1),activity.getResources().getStringArray(R.array.Bugs_ListGr),activity);
                    ButtonArray.get(0).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            imageid.clear();
                            imageid.add(activity.getResources().getIdentifier("weeds","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                            imageid.add(activity.getResources().getIdentifier("farming1","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                            editor.putBoolean("Clicked1",true);
                            editor.commit();
                            CreateDialogForProblem(context,activity.getResources().getString(R.string.SecondButtonTextGr),imageid,listView,ButtonArray.get(1),activity.getResources().getStringArray(R.array.FirstPanelNamesGr),activity);
                        }
                    });
                    BeforeOption1=BeforeOption;
                    break;
                case "Κατηγορία Καλλιεργειών":
                    editor.putBoolean("Clicked1",true);
                    editor.commit();
                    mSpecifyProblem.setText(activity.getResources().getString(R.string.SecondButtonTextGr));
                    CreateDialogForProblem(context,activity.getResources().getString(R.string.SecondButtonTextGr),imageid,listView,ButtonArray.get(1),activity.getResources().getStringArray(R.array.Farming_CultureGr),activity);
                    ButtonArray.get(0).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            imageid.clear();
                            imageid.add(activity.getResources().getIdentifier("weeds","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                            imageid.add(activity.getResources().getIdentifier("farming1","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                            editor.putBoolean("Clicked1",true);
                            editor.commit();
                            CreateDialogForProblem(context,activity.getResources().getString(R.string.SecondButtonTextGr),imageid,listView,ButtonArray.get(1),activity.getResources().getStringArray(R.array.FirstPanelNamesGr),activity);
                        }
                    });
                    BeforeOption1=BeforeOption;
                    break;
            }



        }else{


            switch (BeforeOption)
            {
                case "Κατηγορία Ζιζανίων":

                    CreateDialogForProblem(context,activity.getResources().getString(R.string.SecondButtonTextGr),imageid,listView,ButtonArray.get(1),activity.getResources().getStringArray(R.array.Bugs_ListGr),activity);
                    editor.putBoolean("Clicked1",true);
                    editor.commit();
                    ButtonArray.get(0).setText(BeforeOption);
                    ButtonArray.get(0).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            imageid.clear();
                            imageid.add(activity.getResources().getIdentifier("weeds","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                            imageid.add(activity.getResources().getIdentifier("farming1","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                            CreateDialogForProblem(context,activity.getResources().getString(R.string.SecondButtonTextGr),imageid,listView,ButtonArray.get(1),activity.getResources().getStringArray(R.array.FirstPanelNamesGr),activity);
                            editor.putBoolean("Clicked1",true);
                            editor.commit();
                        }
                    });
                    BeforeOption1=BeforeOption;
                    break;
                case "Κατηγορία Καλλιεργειών":

                    CreateDialogForProblem(context,activity.getResources().getString(R.string.SecondButtonTextGr),imageid,listView,ButtonArray.get(1),activity.getResources().getStringArray(R.array.Farming_CultureGr),activity);
                    editor.putBoolean("Clicked1",true);
                    editor.commit();
                    ButtonArray.get(0).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            imageid.clear();
                            imageid.add(activity.getResources().getIdentifier("weeds","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                            imageid.add(activity.getResources().getIdentifier("farming1","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                            CreateDialogForProblem(context,activity.getResources().getString(R.string.SecondButtonTextGr),imageid,listView,ButtonArray.get(1),activity.getResources().getStringArray(R.array.FirstPanelNamesGr),activity);
                            editor.putBoolean("Clicked1",true);
                            editor.commit();
                        }
                    });
                    BeforeOption1=BeforeOption;
                    break;
            }

        }//END OF IF


    }




    public void BugsListOptionActivate(final Context context,  String BeforeOption, final Activity activity)
    {
        final ArrayList<Integer> imageid = new ArrayList<>();

        switch (BeforeOption)
        {
            case "Εχθροί":
                imageid.clear();
                for(int counter=0; counter!=activity.getResources().getStringArray(R.array.Enemies).length; counter++){
                    imageid.add(activity.getResources().getIdentifier("bugs_icon","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                }
                CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView,ButtonArray.get(2),activity.getResources().getStringArray(R.array.Enemies),activity);
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
                        CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView,ButtonArray.get(2),activity.getResources().getStringArray(R.array.Bugs_List),activity);
                    }
                });
                BeforeOption2 =BeforeOption;
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
                CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView,ButtonArray.get(2),activity.getResources().getStringArray(R.array.Desease_List),activity);
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
                        CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView,ButtonArray.get(2),activity.getResources().getStringArray(R.array.Bugs_List),activity);
                    }
                });
                BeforeOption2 =BeforeOption;
                break;
            default:

                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("burr_bug","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("lolium","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("sorghum_halepense","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("convolvulus_arv","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("burr_bug","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                mSolutionFor.setText(activity.getResources().getString(R.string.ThirdButtonTextGr));
                CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView,ButtonArray.get(2),activity.getResources().getStringArray(R.array.Bugs_List_Extend),activity);
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
                        CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView,ButtonArray.get(2),activity.getResources().getStringArray(R.array.Bugs_List),activity);





                    }
                });
                BeforeOption2 =BeforeOption;
                break;

        }


    }


    public void FarmingListOptionActivate(final Context context,String BeforeOption, final Activity activity) {
        final ArrayList<Integer> imageid = new ArrayList<>();

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
                CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.VegetablesGr), activity);

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
                        CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_Culture), activity);
                    }
                });
                BeforeOption2 =BeforeOption;
                break;
            case "Όσπρια":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("beans","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("lentils","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("chickpeas","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("peas","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.LegumesGr), activity);

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
                        CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_Culture), activity);
                    }
                });
                BeforeOption2 =BeforeOption;
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

                CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.FruitsGr), activity);
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
                        CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView,ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_Culture), activity);
                    }
                });
                BeforeOption2 =BeforeOption;
                break;
            case "Δημητριακά":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("rice","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("wheat","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("oats","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("corn","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("barley","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));

                CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.CerealsGr), activity);
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
                        CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_Culture), activity);
                    }
                });
                BeforeOption2 =BeforeOption;
                break;
            case "Ελιά":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("olives","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));

                CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.olives), activity);
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
                        CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_Culture), activity);
                    }
                });
                BeforeOption2 =BeforeOption;
                break;

            default:
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("almond","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("peanut","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("hazel_nuts","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("chestnuts","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("walnuts","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));

                CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid, listView,ButtonArray.get(2), activity.getResources().getStringArray(R.array.Tree_NutsGr), activity);
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
                        CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr),imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_Culture), activity);
                    }
                });
                BeforeOption2 =BeforeOption;
                break;


        }

    }





    public void FarmingListVegetablesBugsOptionActivate(final Context context,String BeforeOption, final Activity activity) {
        final ArrayList<Integer> imageid = new ArrayList<>();

        switch (BeforeOption) {
            case "Αγγούρι":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("trialeurodes_vaporariorum","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("thrips","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("aphis","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("phyllonorycter_blancardella","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("lygus_pabulinus","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                CreateDialogForProblem(context,"Solutuion For.",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Cucumber), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                LayoutArray.get(1).setVisibility(View.VISIBLE);
                flag=1;
                Before3 =BeforeOption;
                break;
            case "Αγγινάρα":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("bremia_lactucae","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("ramularia_beticola","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("oidium","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("aphis","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("pyrameis_atalanta","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("cassida","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                CreateDialogForProblem(context,"Solutuion For.",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Artichoke_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                LayoutArray.get(1).setVisibility(View.VISIBLE);
                flag=1;
                Before3 =BeforeOption;
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
                LayoutArray.get(1).setVisibility(View.VISIBLE);
                CreateDialogForProblem(context,"Solutuion For.",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Cauliflower__Broccoli_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                flag=1;
                Before3 =BeforeOption;
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
                LayoutArray.get(1).setVisibility(View.VISIBLE);
                CreateDialogForProblem(context,"Solutuion For.",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Spinach_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                flag=1;
                Before3 =BeforeOption;
                break;
            case "Κρεμμύδι":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("botrytis_cinerea","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("puccinia_porri","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("thrips","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("pseudoperonospora_cubensis","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("sclerotiniasclerotiorum","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                LayoutArray.get(1).setVisibility(View.VISIBLE);
                CreateDialogForProblem(context,"Solutuion For.",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Onion_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                flag=1;
                Before3 =BeforeOption;
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
                LayoutArray.get(1).setVisibility(View.VISIBLE);
                CreateDialogForProblem(context,"Solutuion For.",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Cauliflower__Broccoli_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                flag=1;
                Before3 =BeforeOption;
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
                LayoutArray.get(1).setVisibility(View.VISIBLE);
                CreateDialogForProblem(context,"Solutuion For.",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Cauliflower__Broccoli_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                flag=1;
                Before3 =BeforeOption;
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
                LayoutArray.get(1).setVisibility(View.VISIBLE);
                CreateDialogForProblem(context,"Solutuion For.",imageid, listView,ButtonArray.get(2), activity.getResources().getStringArray(R.array.Tomatoe_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                flag=1;
                Before3 =BeforeOption;
                break;


        }






    }



    public void FarmingListLegumesBugsOptionActivate(final Context context,String BeforeOption, final Activity activity) {

        final ArrayList<Integer> imageid = new ArrayList<>();
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
                CreateDialogForProblem(context,"Solutuion For.",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Beans_Peas_chickBeans_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                flag=1;
                Before3 =BeforeOption;
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
                CreateDialogForProblem(context,"Solutuion For.",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Lentil_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                flag=1;
                Before3 =BeforeOption;
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
                CreateDialogForProblem(context,"Solutuion For.",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Beans_Peas_chickBeans_Bugs), activity);
                LayoutArray.get(1).setVisibility(View.VISIBLE);
                CreateDialogForProblem(context,"Solutuion For.",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Beans_Peas_chickBeans_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                flag=1;
                Before3 =BeforeOption;
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
                LayoutArray.get(1).setVisibility(View.VISIBLE);
                CreateDialogForProblem(context,"Solutuion For.",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Beans_Peas_chickBeans_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                flag=1;
                Before3 =BeforeOption;
                break;

        }


    }




    public void FarmingListFruitsBugsOptionActivate(final Context context,String BeforeOption, final Activity activity) {

        final ArrayList<Integer> imageid = new ArrayList<>();

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
                CreateDialogForProblem(context, "Solutuion For.", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Apple_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                flag=1;
                Before3 = BeforeOption;
                break;
            case "Φράουλα":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("aphis", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("thrips", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("tetranychus_urticae", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("lygus_hesperus", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                CreateDialogForProblem(context, "Solutuion For.", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Strawberry_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                flag=1;
                Before3 = BeforeOption;
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
                CreateDialogForProblem(context, "Solutuion For.", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Pear_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                flag=1;
                Before3 = BeforeOption;
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
                CreateDialogForProblem(context, "Solutuion For.", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Apricot_Peach_Cherry_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                flag=1;
                Before3 = BeforeOption;
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
                CreateDialogForProblem(context, "Solutuion For.", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Watermelon_bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                flag=1;
                Before3 = BeforeOption;
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
                CreateDialogForProblem(context, "Solutuion For.", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Apricot_Peach_Cherry_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                flag=1;
                Before3 = BeforeOption;
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
                CreateDialogForProblem(context, "Solutuion For.", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Lemon_Orange__Mandarine_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                flag=1;
                Before3 = BeforeOption;
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
                CreateDialogForProblem(context, "Solutuion For.", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Lemon_Orange__Mandarine_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                flag=1;
                Before3 = BeforeOption;
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
                CreateDialogForProblem(context, "Solutuion For.", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Apricot_Peach_Cherry_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                flag=1;
                Before3 = BeforeOption;
                break;
            case "Σύκο":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("medfly", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("ceroplastes_rusci", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("aceria_fici", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("phytophthora", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("lonchaea", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                CreateDialogForProblem(context, "Solutuion For.", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Fig_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                flag=1;
                Before3 = BeforeOption;
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
                CreateDialogForProblem(context, "Solutuion For.", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Lemon_Orange__Mandarine_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                flag=1;
                Before3 = BeforeOption;
                break;


        }


    }




    public void FarmingListCerealBugsOptionActivate(final Context context,String BeforeOption, final Activity activity) {

        final ArrayList<Integer> imageid = new ArrayList<>();
        switch (BeforeOption) {
            case "Ρύζι":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("pyricularia_grisea", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("vascular_wilt_of_lentil", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("ephydra_attica", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("sesamia", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("paspalum_distichum", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("cydia_pomonella", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("adoxophyes_orana", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("panonychus_ulmi", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("aphis", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("cossus_linnaeus", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                CreateDialogForProblem(context, "Solutuion For.", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Apple_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                flag=1;
                Before3 = BeforeOption;
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
                CreateDialogForProblem(context, "Solutuion For.", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Apricot_Peach_Cherry_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                flag=1;
                Before3 = BeforeOption;
                break;

        }

    }








    public void FarmingListNutsBugsOptionActivate(final Context context,String BeforeOption, final Activity activity) {

        final ArrayList<Integer> imageid = new ArrayList<>();
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
                CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr), imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Almond_Trees_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                flag=1;
                Before3 = BeforeOption;
                break;
            case "Φυστικιά":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("vertic", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("phytophthora", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("musa_armillaria", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("phelinus_rimosus", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("acrantus_vestitus", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("covered_smut", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr), imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Peanut_Tree_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                flag=1;
                Before3 = BeforeOption;
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
                CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr), imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Chestnut_Tree_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                flag=1;
                Before3 = BeforeOption;
                break;


            case "Καρυδιά":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("anthracnose_citrus", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("syringae", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("musa_armillaria", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("oberea_linearis", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("cydia_chest", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr), imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Walnuts_Tree_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                flag=1;
                Before3 = BeforeOption;
                break;

            case "Φουντουκιά":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("anthracnose_citrus", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("syringae", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("musa_armillaria", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("oberea_linearis", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("cydia_chest", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                CreateDialogForProblem(context,activity.getResources().getString(R.string.ThirdButtonTextGr), imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Walnuts_Tree_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                flag=1;
                Before3 = BeforeOption;
                break;

        }

    }


}












