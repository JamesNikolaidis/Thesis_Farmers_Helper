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

public class Dialogs_Class extends Dialog {

    private static  ArrayList<LinearLayout> LayoutArray;
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
    private AndroidBackBackSensitivityContol mBackButonController;


    public Dialogs_Class(Context context) {
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
                        CreateDialogForProblem(context, " Select Problem Category", list_of_image_id, (ListView) findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.ProblemCategories), activity);
                        editor.putBoolean("Clicked1", false);
                        editor.putBoolean("Clicked", true);
                        editor.commit();


                    }
                    if (share.getBoolean("Clicked", false) == false && share.getBoolean("Clicked1", false) == false) {
                        list_of_image_id.clear();
                        if (flag == 0) {
                            switch (BeforeOption2) {
                                case "Enemies":
                                    dialog.dismiss();
                                    list_of_image_id.clear();
                                    list_of_image_id = photos_functions.getMainDialogPhotos(activity);
                                    CreateDialogForProblem(context, "Select Problem Category", list_of_image_id, (ListView) findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Bugs_List), activity);
                                    editor.putBoolean("Clicked1", true);
                                    editor.commit();
                                    break;
                                case "Disease":
                                    dialog.dismiss();
                                    list_of_image_id.clear();
                                    list_of_image_id = photos_functions.getMainDialogPhotos(activity);
                                    CreateDialogForProblem(context, "Select Problem Category", list_of_image_id, (ListView) findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Bugs_List), activity);
                                    editor.putBoolean("Clicked1", true);

                                    editor.commit();

                                    break;
                                case "Bugs":
                                    dialog.dismiss();
                                    list_of_image_id.clear();
                                    list_of_image_id = photos_functions.getMainDialogPhotos(activity);
                                    CreateDialogForProblem(context, "Select Problem Category", list_of_image_id, (ListView) findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Bugs_List), activity);
                                    editor.putBoolean("Clicked1", true);
                                    editor.commit();

                                    break;

                                case "Vegetables":
                                    dialog.dismiss();
                                    list_of_image_id.clear();
                                    list_of_image_id = photos_functions.getFarmingPhotos(activity);
                                    CreateDialogForProblem(context, "Select Problem Category", list_of_image_id, (ListView) findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_Culture), activity);
                                    editor.putBoolean("Clicked1", true);
                                    editor.commit();

                                    break;
                                case "Legumes":
                                    dialog.dismiss();
                                    list_of_image_id.clear();
                                    list_of_image_id = photos_functions.getFarmingPhotos(activity);
                                    CreateDialogForProblem(context, "Select Problem Category", list_of_image_id, (ListView) findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_Culture), activity);
                                    editor.putBoolean("Clicked1", true);
                                    editor.commit();

                                    break;
                                case "Fruits":
                                    dialog.dismiss();
                                    list_of_image_id.clear();
                                    list_of_image_id = photos_functions.getFarmingPhotos(activity);
                                    CreateDialogForProblem(context, "Select Problem Category", list_of_image_id, (ListView) findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_Culture), activity);
                                    editor.putBoolean("Clicked1", true);
                                    editor.commit();

                                    break;
                                case "Cereal":
                                    dialog.dismiss();
                                    list_of_image_id.clear();
                                    list_of_image_id = photos_functions.getFarmingPhotos(activity);
                                    CreateDialogForProblem(context, "Select Problem Category", list_of_image_id, (ListView) findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_Culture), activity);
                                    editor.putBoolean("Clicked1", true);
                                    editor.commit();

                                    break;
                                case "Olives":
                                    dialog.dismiss();
                                    list_of_image_id.clear();
                                    list_of_image_id = photos_functions.getFarmingPhotos(activity);
                                    CreateDialogForProblem(context, "Select Problem Category", list_of_image_id, (ListView) findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_Culture), activity);
                                    editor.putBoolean("Clicked1", true);
                                    editor.commit();

                                    break;
                                case "Tree Nuts":
                                    dialog.dismiss();
                                    list_of_image_id.clear();
                                    list_of_image_id = photos_functions.getFarmingPhotos(activity);
                                    CreateDialogForProblem(context, "Select Problem Category", list_of_image_id, (ListView) findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_Culture), activity);
                                    editor.putBoolean("Clicked1", true);
                                    editor.commit();

                                    break;


                            }

                        } else {
                            if (Before3.matches("Orange") || Before3.matches("Apple") || Before3.matches("Strawberry") || Before3.matches("Pear") || Before3.matches("Apricot") || Before3.matches("Watermelon") || Before3.matches("Cherry") || Before3.matches("Mandarin") || Before3.matches("Fig") || Before3.matches("Peach")) {
                                dialog.dismiss();
                                list_of_image_id.clear();
                                list_of_image_id = photos_functions.getFruitsPhotos(activity);
                                CreateDialogForProblem(context, "Solutuion For.", list_of_image_id, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Fruits), activity);
                                flag = 0;


                            } else if (Before3.matches("Rice") || Before3.matches("Wheat") || Before3.matches("Oats") || Before3.matches("Corn") || Before3.matches("Barley")) {

                                dialog.dismiss();
                                list_of_image_id.clear();
                                list_of_image_id = photos_functions.getCerealPhotos(activity);
                                CreateDialogForProblem(context, "Solutuion For.", list_of_image_id, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Cereals), activity);
                                flag = 0;

                            } else if (Before3.matches("Beans") || Before3.matches("Lentil") || Before3.matches("Chickpeas") || Before3.matches("Peas")) {

                                dialog.dismiss();
                                list_of_image_id.clear();
                                list_of_image_id = photos_functions.getLentilPhotos(activity);
                                CreateDialogForProblem(context, "Solutuion For.", list_of_image_id, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Legumes), activity);
                                flag = 0;

                            } else if (Before3.matches("Cucumber") || Before3.matches("Artichoke") || Before3.matches("Cauliflower") || Before3.matches("Spinach") || Before3.matches("Onion") || Before3.matches("Cabbage") || Before3.matches("Broccoli") || Before3.matches("Tomato")) {

                                dialog.dismiss();
                                list_of_image_id.clear();
                                list_of_image_id = photos_functions.getVegetablesPhotos(activity);
                                CreateDialogForProblem(context, "Solutuion For.", list_of_image_id, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Vegetables), activity);
                                flag = 0;
                            } else if (Before3.matches("Almond") || Before3.matches("Peanut") || Before3.matches("Hazel") || Before3.matches("Chestnut") || Before3.matches("Walnuts")) {

                                dialog.dismiss();
                                list_of_image_id.clear();
                                list_of_image_id = photos_functions.getNutsPhotos(activity);
                                CreateDialogForProblem(context, "Solutuion For.", list_of_image_id, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Tree_Nuts), activity);
                                flag = 0;

                            }


                        }


                    }


                        LockAndroidBackButtonSensitivity++;
                        mBackButonController.ActivateLockMethodAndGetValueWhenReady();


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
                    CreateDialogForProblem(context, "Select Problem Category", list_of_image_id, (ListView) findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.ProblemCategories), activity);
                    editor.putBoolean("Clicked1", false);
                    editor.putBoolean("Clicked", true);
                    editor.commit();



                } else if (share.getBoolean("Clicked", false) == false && share.getBoolean("Clicked1", false) == false) {
                    list_of_image_id.clear();
                    if (flag == 0) {
                        switch (BeforeOption2) {
                            case "Enemies":
                                dialog.dismiss();
                                list_of_image_id.clear();
                                list_of_image_id = photos_functions.getMainDialogPhotos(activity);
                                CreateDialogForProblem(context,"Select Problem Category", list_of_image_id, (ListView) findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Bugs_List), activity);
                                editor.putBoolean("Clicked1", true);
                                editor.commit();
                                break;
                            case "Disease":
                                dialog.dismiss();
                                list_of_image_id.clear();
                                list_of_image_id = photos_functions.getMainDialogPhotos(activity);
                                CreateDialogForProblem(context,"Select Problem Category", list_of_image_id, (ListView) findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Bugs_List), activity);
                                editor.putBoolean("Clicked1", true);
                                editor.commit();

                                break;
                            case "Bugs":
                                dialog.dismiss();
                                list_of_image_id.clear();
                                list_of_image_id = photos_functions.getMainDialogPhotos(activity);
                                CreateDialogForProblem(context,"Select Problem Category", list_of_image_id, (ListView) findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Bugs_List), activity);
                                editor.putBoolean("Clicked1", true);
                                editor.commit();

                                break;

                            case "Vegetables":
                                dialog.dismiss();
                                list_of_image_id.clear();
                                list_of_image_id = photos_functions.getFarmingPhotos(activity);
                                CreateDialogForProblem(context,"Select Problem Category", list_of_image_id, (ListView) findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_Culture), activity);
                                editor.putBoolean("Clicked1", true);
                                editor.commit();

                                break;
                            case "Legumes":
                                dialog.dismiss();
                                list_of_image_id.clear();
                                list_of_image_id = photos_functions.getFarmingPhotos(activity);
                                CreateDialogForProblem(context,"Select Problem Category", list_of_image_id, (ListView) findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_Culture), activity);
                                editor.putBoolean("Clicked1", true);
                                editor.commit();

                                break;
                            case "Fruits":
                                dialog.dismiss();
                                list_of_image_id.clear();
                                list_of_image_id = photos_functions.getFarmingPhotos(activity);
                                CreateDialogForProblem(context,"Select Problem Category", list_of_image_id, (ListView) findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_Culture), activity);
                                editor.putBoolean("Clicked1", true);
                                editor.commit();

                                break;
                            case "Cereal":
                                dialog.dismiss();
                                list_of_image_id.clear();
                                list_of_image_id = photos_functions.getFarmingPhotos(activity);
                                CreateDialogForProblem(context,"Select Problem Category", list_of_image_id, (ListView) findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_Culture), activity);
                                editor.putBoolean("Clicked1", true);
                                editor.commit();

                                break;
                            case "Olives":
                                dialog.dismiss();
                                list_of_image_id.clear();
                                list_of_image_id = photos_functions.getFarmingPhotos(activity);
                                CreateDialogForProblem(context,"Select Problem Category", list_of_image_id, (ListView) findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_Culture), activity);
                                editor.putBoolean("Clicked1", true);
                                editor.commit();

                                break;
                            case "Tree Nuts":
                                dialog.dismiss();
                                list_of_image_id.clear();
                                list_of_image_id = photos_functions.getFarmingPhotos(activity);
                                CreateDialogForProblem(context,"Select Problem Category", list_of_image_id, (ListView) findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_Culture), activity);
                                editor.putBoolean("Clicked1", true);
                                editor.commit();

                                break;


                        }

                    } else {
                        if (Before3.matches("Orange") || Before3.matches("Apple") || Before3.matches("Strawberry") || Before3.matches("Pear") || Before3.matches("Apricot") || Before3.matches("Watermelon") || Before3.matches("Cherry") || Before3.matches("Mandarin") || Before3.matches("Fig") || Before3.matches("Peach")) {
                            dialog.dismiss();
                            list_of_image_id.clear();
                            list_of_image_id = photos_functions.getFruitsPhotos(activity);
                            CreateDialogForProblem(context,"Solutuion For", list_of_image_id, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Fruits), activity);
                            flag = 0;


                        } else if (Before3.matches("Rice") || Before3.matches("Wheat") || Before3.matches("Oats") || Before3.matches("Corn") || Before3.matches("Barley")) {

                            dialog.dismiss();
                            list_of_image_id.clear();
                            list_of_image_id = photos_functions.getCerealPhotos(activity);
                            CreateDialogForProblem(context,"Solutuion For", list_of_image_id, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Cereals), activity);
                            flag = 0;

                        } else if (Before3.matches("Beans") || Before3.matches("Lentil") || Before3.matches("Chickpeas") || Before3.matches("Peas")) {

                            dialog.dismiss();
                            list_of_image_id.clear();
                            list_of_image_id = photos_functions.getLentilPhotos(activity);
                            CreateDialogForProblem(context,"Solutuion For", list_of_image_id, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Legumes), activity);
                            flag = 0;

                        } else if (Before3.matches("Cucumber") || Before3.matches("Artichoke") || Before3.matches("Cauliflower") || Before3.matches("Spinach") || Before3.matches("Onion") || Before3.matches("Cabbage") || Before3.matches("Broccoli") || Before3.matches("Tomato")) {

                            dialog.dismiss();
                            list_of_image_id.clear();
                            list_of_image_id = photos_functions.getVegetablesPhotos(activity);
                            CreateDialogForProblem(context,"Solutuion For", list_of_image_id, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Vegetables), activity);
                            flag = 0;
                        } else if (Before3.matches("Almond") || Before3.matches("Peanut") || Before3.matches("Hazel") || Before3.matches("Chestnut") || Before3.matches("Walnuts")) {

                            dialog.dismiss();
                            list_of_image_id.clear();
                            list_of_image_id = photos_functions.getNutsPhotos(activity);
                            CreateDialogForProblem(context,"Solutuion For", list_of_image_id, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Tree_Nuts), activity);
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

                            case "Enemies":
                                mNetwork_and_Wifi_Object.CheckWifiConnectionAndEnable();
                                editor.putString("SpecifyProblem", User_Choose[i]);
                                editor.commit();
                                dialog.cancel();
                                mNetwork_and_Wifi_Object.CheckWifiConnectionAndEnable();
                                break;
                            case "Disease":
                                editor.putString("SpecifyProblem", User_Choose[i]);
                                editor.commit();
                                mNetwork_and_Wifi_Object.CheckWifiConnectionAndEnable();
                                break;
                            case "Bugs":
                                editor.putString("SpecifyProblem", User_Choose[i]);
                                editor.commit();
                                dialog.cancel();
                                mNetwork_and_Wifi_Object.CheckWifiConnectionAndEnable();
                                break;

                            case "Vegetables":
                                if (!Before3.isEmpty() && anotherflag == 1) {
                                    editor.putString("SpecifyProblem", User_Choose[i]);
                                    editor.commit();
                                    dialog.cancel();
                                    mNetwork_and_Wifi_Object.CheckWifiConnectionAndEnable();
                                } else {
                                    dialog.dismiss();
                                    editor.putString("FarmingChoice",  User_Choose[i]);
                                    editor.commit();
                                    LayoutArray.get(1).setVisibility(View.VISIBLE);
                                    FarmingListVegetablesBugsOptionActivate(context, User_Choose[i], activity);
                                    anotherflag++;
                                }
                                break;
                            case "Legumes":
                                if (!Before3.isEmpty() && anotherflag == 1) {
                                    editor.putString("SpecifyProblem", User_Choose[i]);
                                    editor.commit();
                                    dialog.cancel();
                                    mNetwork_and_Wifi_Object.CheckWifiConnectionAndEnable();


                                } else {
                                    dialog.dismiss();
                                    editor.putString("FarmingChoice",  User_Choose[i]);
                                    editor.commit();
                                    LayoutArray.get(1).setVisibility(View.VISIBLE);
                                    FarmingListLegumesBugsOptionActivate(context, User_Choose[i], activity);
                                    anotherflag++;
                                }
                                break;

                            case "Fruits":
                                if (!Before3.isEmpty() && anotherflag == 1) {
                                    editor.putString("SpecifyProblem", User_Choose[i]);
                                    editor.commit();
                                    dialog.cancel();
                                    mNetwork_and_Wifi_Object.CheckWifiConnectionAndEnable();
                                } else {
                                    dialog.dismiss();
                                    editor.putString("FarmingChoice",  User_Choose[i]);
                                    editor.commit();
                                    LayoutArray.get(1).setVisibility(View.VISIBLE);
                                    FarmingListFruitsBugsOptionActivate(context, User_Choose[i], activity);
                                    anotherflag++;
                                }
                                break;

                            case "Tree Nuts":

                                if (!Before3.isEmpty() && anotherflag == 1) {
                                    editor.putString("SpecifyProblem", User_Choose[i]);
                                    editor.commit();
                                    dialog.cancel();
                                    mNetwork_and_Wifi_Object.CheckWifiConnectionAndEnable();


                                } else {
                                    dialog.dismiss();
                                    editor.putString("FarmingChoice",  User_Choose[i]);
                                    editor.commit();
                                    LayoutArray.get(1).setVisibility(View.VISIBLE);
                                    FarmingListNutsBugsOptionActivate(context, User_Choose[i], activity);
                                    anotherflag++;
                                }
                                break;

                            case "Cereal":

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

                        if (BeforeOption1.matches("Weeds List")) {

                            dialog.dismiss();
                            LayoutArray.get(0).setVisibility(View.VISIBLE);
                            list_of_image_id.clear();
                            BugsListOptionActivate(context, User_Choose[i], activity);
                            editor.putBoolean("Clicked1", false);
                            editor.commit();

                        } else if (BeforeOption1.matches("Farming Culture List")) {
                            dialog.dismiss();
                            LayoutArray.get(0).setVisibility(View.VISIBLE);
                            list_of_image_id.clear();
                            FarmingListOptionActivate(context, User_Choose[i], activity);
                            editor.putBoolean("Clicked1", false);
                            editor.commit();

                        }





                    }


                } else {


                    if (User_Choose[i].matches("Weeds List") && LongClickFlag == 0) {
                        dialog.dismiss();
                        list_of_image_id.clear();
                       // LayoutArray.get(0).setVisibility(View.VISIBLE);
                        list_of_image_id.add(activity.getResources().getIdentifier("bugs_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        list_of_image_id.add(activity.getResources().getIdentifier("disease_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        list_of_image_id.add(activity.getResources().getIdentifier("enemies_pahid_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        ActivateAnotherDialog(context, list_of_image_id, User_Choose[i], activity);
                        editor.putBoolean("Clicked", false);
                        editor.commit();


                    } else if (User_Choose[i].matches("Farming Culture List") && LongClickFlag == 0) {
                        dialog.dismiss();
                       // LayoutArray.get(0).setVisibility(View.VISIBLE);
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
                 case "Weeds List":
                     editor.putBoolean("Clicked1",true);
                     editor.commit();
                     //Here image Code
                     CreateDialogForProblem(context,"Specify Problem",imageid,listView,ButtonArray.get(1),activity.getResources().getStringArray(R.array.Bugs_List),activity);
                     ButtonArray.get(0).setOnClickListener(new View.OnClickListener() {
                         @Override
                         public void onClick(View view) {

                              imageid.clear();
                              imageid.add(activity.getResources().getIdentifier("weeds","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                              imageid.add(activity.getResources().getIdentifier("farming1","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                             editor.putBoolean("Clicked1",true);
                              editor.commit();
                              CreateDialogForProblem(context,"Specify Problem",imageid,listView,ButtonArray.get(1),activity.getResources().getStringArray(R.array.ProblemCategories),activity);
                         }
                     });
                     BeforeOption1=BeforeOption;
                     break;
                 case "Farming Culture List":
                     editor.putBoolean("Clicked1",true);
                     editor.commit();
                     CreateDialogForProblem(context," Specify Problem.",imageid,listView,ButtonArray.get(1),activity.getResources().getStringArray(R.array.Farming_Culture),activity);
                     ButtonArray.get(0).setOnClickListener(new View.OnClickListener() {
                         @Override
                         public void onClick(View view) {
                             imageid.clear();
                             imageid.add(activity.getResources().getIdentifier("weeds","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                             imageid.add(activity.getResources().getIdentifier("farming1","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                             editor.putBoolean("Clicked1",true);
                             editor.commit();
                             CreateDialogForProblem(context,"Specify Problem",imageid,listView,ButtonArray.get(1),activity.getResources().getStringArray(R.array.ProblemCategories),activity);
                         }
                     });
                     BeforeOption1=BeforeOption;
                     break;
             }



        }else{


            switch (BeforeOption)
            {
                case "Weeds List":

                    CreateDialogForProblem(context,"Specify Problem",imageid,listView,ButtonArray.get(1),activity.getResources().getStringArray(R.array.Bugs_List),activity);
                    editor.putBoolean("Clicked1",true);
                    editor.commit();
                    ButtonArray.get(0).setText(BeforeOption);
                    ButtonArray.get(0).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            imageid.clear();
                            imageid.add(activity.getResources().getIdentifier("weeds","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                            imageid.add(activity.getResources().getIdentifier("farming1","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                            CreateDialogForProblem(context," Specify Problem.",imageid,listView,ButtonArray.get(1),activity.getResources().getStringArray(R.array.ProblemCategories),activity);
                            editor.putBoolean("Clicked1",true);
                            editor.commit();
                        }
                    });
                    BeforeOption1=BeforeOption;
                    break;
                case "Farming Culture List":

                    CreateDialogForProblem(context,"Specify Problem",imageid,listView,ButtonArray.get(1),activity.getResources().getStringArray(R.array.Farming_Culture),activity);
                    editor.putBoolean("Clicked1",true);
                    editor.commit();
                    ButtonArray.get(0).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            imageid.clear();
                            imageid.add(activity.getResources().getIdentifier("weeds","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                            imageid.add(activity.getResources().getIdentifier("farming1","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                           CreateDialogForProblem(context," Specify Problem.",imageid,listView,ButtonArray.get(1),activity.getResources().getStringArray(R.array.ProblemCategories),activity);
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
        {       case "Enemies":
                imageid.clear();
                for(int counter=0; counter!=activity.getResources().getStringArray(R.array.Enemies).length; counter++){
                    imageid.add(activity.getResources().getIdentifier("bugs_icon","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                }
                CreateDialogForProblem(context,"Solutuion For",imageid,listView,ButtonArray.get(2),activity.getResources().getStringArray(R.array.Enemies),activity);
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
                        CreateDialogForProblem(context,"Solutuion For",imageid,listView,ButtonArray.get(2),activity.getResources().getStringArray(R.array.Bugs_List),activity);
                    }
                });
             BeforeOption2 =BeforeOption;
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
                CreateDialogForProblem(context,"Solutuion For",imageid,listView,ButtonArray.get(2),activity.getResources().getStringArray(R.array.Desease_List),activity);
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
                        CreateDialogForProblem(context,"Solutuion For",imageid,listView,ButtonArray.get(2),activity.getResources().getStringArray(R.array.Bugs_List),activity);
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
                //ButtonArray.get(1).setText(BeforeOption);
                CreateDialogForProblem(context,"Solutuion For",imageid,listView,ButtonArray.get(2),activity.getResources().getStringArray(R.array.Bugs_List_Extend),activity);
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
                        CreateDialogForProblem(context,"Solutuion For",imageid,listView,ButtonArray.get(2),activity.getResources().getStringArray(R.array.Bugs_List),activity);





                    }
                });
                BeforeOption2 =BeforeOption;
                break;

        }


    }


    public void FarmingListOptionActivate(final Context context,String BeforeOption, final Activity activity) {
        final ArrayList<Integer> imageid = new ArrayList<>();

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
                CreateDialogForProblem(context,"Solutuion For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Vegetables), activity);
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
                        CreateDialogForProblem(context,"Solutuion For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_Culture), activity);
                    }
                });
                BeforeOption2 =BeforeOption;
                break;
            case "Legumes":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("beans","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("lentils","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("chickpeas","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("peas","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                CreateDialogForProblem(context,"Solutuion For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Legumes), activity);

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
                        CreateDialogForProblem(context,"Solutuion For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_Culture), activity);
                    }
                });
                BeforeOption2 =BeforeOption;
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
                CreateDialogForProblem(context,"Solutuion For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Fruits), activity);
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
                        CreateDialogForProblem(context,"Solutuion For",imageid,listView,ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_Culture), activity);
                    }
                });
                BeforeOption2 =BeforeOption;
                break;
            case "Cereal":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("rice","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("wheat","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("oats","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("corn","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("barley","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                CreateDialogForProblem(context,"Solutuion For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Cereals), activity);
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
                        CreateDialogForProblem(context,"Solutuion For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_Culture), activity);
                    }
                });
                BeforeOption2 =BeforeOption;
                break;
            case "Olives":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("olives","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                CreateDialogForProblem(context,"Solutuion For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.olives), activity);
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
                        CreateDialogForProblem(context,"Solutuion For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_Culture), activity);
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
                CreateDialogForProblem(context,"Solutuion For",imageid, listView,ButtonArray.get(2), activity.getResources().getStringArray(R.array.Tree_Nuts), activity);
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
                        CreateDialogForProblem(context,"Solutuion For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_Culture), activity);
                    }
                });
                BeforeOption2 =BeforeOption;
                break;


        }

    }





    public void FarmingListVegetablesBugsOptionActivate(final Context context,String BeforeOption, final Activity activity) {
        final ArrayList<Integer> imageid = new ArrayList<>();

        switch (BeforeOption) {
            case "Cucumber":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("trialeurodes_vaporariorum","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("thrips","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("aphis","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("phyllonorycter_blancardella","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("lygus_pabulinus","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                CreateDialogForProblem(context,"Solutuion For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Cucumber), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                LayoutArray.get(1).setVisibility(View.VISIBLE);
                flag=1;
                Before3 =BeforeOption;
                break;
            case "Artichoke":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("bremia_lactucae","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("ramularia_beticola","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("oidium","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("aphis","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("pyrameis_atalanta","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("cassida","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                CreateDialogForProblem(context,"Solutuion For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Artichoke_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                LayoutArray.get(1).setVisibility(View.VISIBLE);
                flag=1;
                Before3 =BeforeOption;
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
                LayoutArray.get(1).setVisibility(View.VISIBLE);
                CreateDialogForProblem(context,"Solutuion For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Cauliflower__Broccoli_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                flag=1;
                Before3 =BeforeOption;
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
                LayoutArray.get(1).setVisibility(View.VISIBLE);
                CreateDialogForProblem(context,"Solutuion For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Spinach_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                flag=1;
                Before3 =BeforeOption;
                break;
            case "Onion":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("botrytis_cinerea","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("puccinia_porri","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("thrips","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("pseudoperonospora_cubensis","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("sclerotiniasclerotiorum","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                LayoutArray.get(1).setVisibility(View.VISIBLE);
                CreateDialogForProblem(context,"Solutuion For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Onion_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                flag=1;
                Before3 =BeforeOption;
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
                LayoutArray.get(1).setVisibility(View.VISIBLE);
                CreateDialogForProblem(context,"Solutuion For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Cauliflower__Broccoli_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                flag=1;
                Before3 =BeforeOption;
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
                LayoutArray.get(1).setVisibility(View.VISIBLE);
                CreateDialogForProblem(context,"Solutuion For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Cauliflower__Broccoli_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                flag=1;
                Before3 =BeforeOption;
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
                LayoutArray.get(1).setVisibility(View.VISIBLE);
                CreateDialogForProblem(context,"Solutuion For",imageid, listView,ButtonArray.get(2), activity.getResources().getStringArray(R.array.Tomatoe_Bugs), activity);
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
                CreateDialogForProblem(context,"Solutuion For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Beans_Peas_chickBeans_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                flag=1;
                Before3 =BeforeOption;
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
                CreateDialogForProblem(context,"Solutuion For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Lentil_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                flag=1;
                Before3 =BeforeOption;
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
                CreateDialogForProblem(context,"Solutuion For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Beans_Peas_chickBeans_Bugs), activity);
                LayoutArray.get(1).setVisibility(View.VISIBLE);
                CreateDialogForProblem(context,"Solutuion For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Beans_Peas_chickBeans_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                flag=1;
                Before3 =BeforeOption;
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
                LayoutArray.get(1).setVisibility(View.VISIBLE);
                CreateDialogForProblem(context,"Solutuion For",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Beans_Peas_chickBeans_Bugs), activity);
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
                CreateDialogForProblem(context, "Solutuion For", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Apple_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                flag=1;
                Before3 = BeforeOption;
                break;
            case "Strawberry":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("aphis", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("thrips", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("tetranychus_urticae", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("lygus_hesperus", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                CreateDialogForProblem(context, "Solutuion For", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Strawberry_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                flag=1;
                Before3 = BeforeOption;
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
                CreateDialogForProblem(context, "Solutuion For", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Pear_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                flag=1;
                Before3 = BeforeOption;
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
                CreateDialogForProblem(context, "Solutuion For", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Apricot_Peach_Cherry_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                flag=1;
                Before3 = BeforeOption;
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
                CreateDialogForProblem(context, "Solutuion For", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Watermelon_bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                flag=1;
                Before3 = BeforeOption;
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
                CreateDialogForProblem(context, "Solutuion For", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Apricot_Peach_Cherry_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                flag=1;
                Before3 = BeforeOption;
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
                CreateDialogForProblem(context, "Solutuion For", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Lemon_Orange__Mandarine_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                flag=1;
                Before3 = BeforeOption;
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
                CreateDialogForProblem(context, "Solutuion For", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Lemon_Orange__Mandarine_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                flag=1;
                Before3 = BeforeOption;
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
                CreateDialogForProblem(context, "Solutuion For", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Apricot_Peach_Cherry_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                flag=1;
                Before3 = BeforeOption;
                break;
            case "Fig":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("medfly", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("ceroplastes_rusci", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("aceria_fici", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("phytophthora", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("lonchaea", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                CreateDialogForProblem(context, "Solutuion For", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Fig_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                flag=1;
                Before3 = BeforeOption;
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
                CreateDialogForProblem(context, "Solutuion For", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Lemon_Orange__Mandarine_Bugs), activity);
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
            case "Rice":
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
                CreateDialogForProblem(context, "Solutuion For", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Apple_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                flag=1;
                Before3 = BeforeOption;
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
                CreateDialogForProblem(context, "Solutuion For", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Apricot_Peach_Cherry_Bugs), activity);
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
                CreateDialogForProblem(context, "Solutuion For", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Almond_Trees_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                flag=1;
                Before3 = BeforeOption;
                break;
            case "Peanut":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("vertic", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("phytophthora", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("musa_armillaria", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("phelinus_rimosus", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("acrantus_vestitus", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("covered_smut", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                CreateDialogForProblem(context, "Solutuion For", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Peanut_Tree_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                flag=1;
                Before3 = BeforeOption;
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
                CreateDialogForProblem(context, "Solutuion For", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Chestnut_Tree_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                flag=1;
                Before3 = BeforeOption;
                break;


            case "Walnuts":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("anthracnose_citrus", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("syringae", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("musa_armillaria", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("oberea_linearis", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("cydia_chest", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                CreateDialogForProblem(context, "Solutuion For", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Walnuts_Tree_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                flag=1;
                Before3 = BeforeOption;
                break;

            case "Hazel":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("anthracnose_citrus", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("syringae", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("musa_armillaria", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("oberea_linearis", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("cydia_chest", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                CreateDialogForProblem(context, "Solutuion For", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Walnuts_Tree_Bugs), activity);
                mTipAlertDialog= mTipDialogClass.ActivateTipDialog(activity,context);
                mTimerClass.Count_And_Disable_Tip_Dialog(mTipAlertDialog);
                flag=1;
                Before3 = BeforeOption;
                break;

        }

     }


}












