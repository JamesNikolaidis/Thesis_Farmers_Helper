package com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
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

public class Dialogs_Class {

    private static  ArrayList<LinearLayout> LayoutArray;
    private static  ArrayList<Button> ButtonArray;
    private Photos_Functions photos_functions ;
    public static String BeforeOption1 ="",BeforeOption2="",Before3="";
    private static SharedPreferences share ;
    private static SharedPreferences.Editor editor;
    private static ListView listView;
    private  static ArrayList<Integer> list_of_image_id ;
    public static  int flag = 0, anotherflag=0 ,LongClickFlag = 0;
    private Network_Wifi_Class mNetwork_and_Wifi_Object;
    private Timers_Class mTimerClass;
    private Tip_Dialog mTipDialogClass;
    private AlertDialog mTipAlertDialog ;
    private Dialog_On_Long_Click_Listener mDialog_On_Long_Click_Listener;
    private static Button btn;
    private AndroidBackBackSensitivityContol mBackButonController;
    public static int LockAndroidBackButtonSensitivity=0;



    private ActivateAnotherDialog_Class activateAnotherDialog_class;
    private BugsListOptionActivate_Class bugsListOptionActivate_class;
    private FarmingListOptionActivate_Class farmingListOptionActivate_class;
    private FarmingListVegetablesBugsOptionActivate_Class farmingListVegetablesBugsOptionActivate_class;
    private FarmingListLegumesBugsOptionActivate_Class farmingListLegumesBugsOptionActivate_class;
    private FarmingListFruitsBugsOptionActivate_Class farmingListFruitsBugsOptionActivate_class;
    private FarmingListCerealBugsOptionActivate_Class farmingListCerealBugsOptionActivate_class;
    private FarmingListNutsBugsOptionActivate_Class farmingListNutsBugsOptionActivate_class;





    public Dialogs_Class(){}


    public Dialogs_Class(Context context) {
        LayoutArray = new ArrayList<>();
        ButtonArray = new ArrayList<>();
        list_of_image_id = new ArrayList<Integer>();


    }


    public void DeclareLayouts(LinearLayout ...layouts){
        //Store Layout Id's inside of a Array , to handle then when we need it
        LayoutArray.add(layouts[0]);
        LayoutArray.add(layouts[1]);
        LayoutArray.add(layouts[2]);


    }

    public void DeclareButtons(Button ...buttons){
        //Store Layout Button inside of a Array , to handle then when we need it
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


        activateAnotherDialog_class = new ActivateAnotherDialog_Class();
        farmingListOptionActivate_class = new FarmingListOptionActivate_Class();
        bugsListOptionActivate_class =new BugsListOptionActivate_Class();
        farmingListVegetablesBugsOptionActivate_class = new FarmingListVegetablesBugsOptionActivate_Class();
        farmingListLegumesBugsOptionActivate_class = new FarmingListLegumesBugsOptionActivate_Class();
        farmingListFruitsBugsOptionActivate_class =new FarmingListFruitsBugsOptionActivate_Class();
        farmingListCerealBugsOptionActivate_class = new FarmingListCerealBugsOptionActivate_Class();
        farmingListNutsBugsOptionActivate_class =new FarmingListNutsBugsOptionActivate_Class();





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
                        CreateDialogForProblem(context, " Select Problem Category", list_of_image_id, (ListView) dialog.findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.ProblemCategories), activity);
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
                                    CreateDialogForProblem(context, "Select Problem Category", list_of_image_id, (ListView) dialog.findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Bugs_List), activity);
                                    editor.putBoolean("Clicked1", true);
                                    editor.commit();
                                    break;
                                case "Disease":
                                    dialog.dismiss();
                                    list_of_image_id.clear();
                                    list_of_image_id = photos_functions.getMainDialogPhotos(activity);
                                    CreateDialogForProblem(context, "Select Problem Category", list_of_image_id, (ListView) dialog.findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Bugs_List), activity);
                                    editor.putBoolean("Clicked1", true);
                                    editor.commit();

                                    break;
                                case "Bugs":
                                    dialog.dismiss();
                                    list_of_image_id.clear();
                                    list_of_image_id = photos_functions.getMainDialogPhotos(activity);
                                    CreateDialogForProblem(context, "Select Problem Category", list_of_image_id, (ListView) dialog.findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Bugs_List), activity);
                                    editor.putBoolean("Clicked1", true);
                                    editor.commit();

                                    break;

                                case "Vegetables":
                                    dialog.dismiss();
                                    list_of_image_id.clear();
                                    list_of_image_id = photos_functions.getFarmingPhotos(activity);
                                    CreateDialogForProblem(context, "Select Problem Category", list_of_image_id, (ListView) dialog.findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_Culture), activity);
                                    editor.putBoolean("Clicked1", true);
                                    editor.commit();

                                    break;
                                case "Legumes":
                                    dialog.dismiss();
                                    list_of_image_id.clear();
                                    list_of_image_id = photos_functions.getFarmingPhotos(activity);
                                    CreateDialogForProblem(context, "Select Problem Category", list_of_image_id, (ListView) dialog.findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_Culture), activity);
                                    editor.putBoolean("Clicked1", true);
                                    editor.commit();

                                    break;
                                case "Fruits":
                                    dialog.dismiss();
                                    list_of_image_id.clear();
                                    list_of_image_id = photos_functions.getFarmingPhotos(activity);
                                    CreateDialogForProblem(context, "Select Problem Category", list_of_image_id, (ListView) dialog.findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_Culture), activity);
                                    editor.putBoolean("Clicked1", true);
                                    editor.commit();

                                    break;
                                case "Cereal":
                                    dialog.dismiss();
                                    list_of_image_id.clear();
                                    list_of_image_id = photos_functions.getFarmingPhotos(activity);
                                    CreateDialogForProblem(context, "Select Problem Category", list_of_image_id, (ListView) dialog.findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_Culture), activity);
                                    editor.putBoolean("Clicked1", true);
                                    editor.commit();

                                    break;
                                case "Olives":
                                    dialog.dismiss();
                                    list_of_image_id.clear();
                                    list_of_image_id = photos_functions.getFarmingPhotos(activity);
                                    CreateDialogForProblem(context, "Select Problem Category", list_of_image_id, (ListView) dialog.findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_Culture), activity);
                                    editor.putBoolean("Clicked1", true);
                                    editor.commit();

                                    break;
                                case "Tree Nuts":
                                    dialog.dismiss();
                                    list_of_image_id.clear();
                                    list_of_image_id = photos_functions.getFarmingPhotos(activity);
                                    CreateDialogForProblem(context, "Select Problem Category", list_of_image_id, (ListView) dialog.findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_Culture), activity);
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
                    CreateDialogForProblem(context, "Select Problem Category", list_of_image_id, (ListView) dialog.findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.ProblemCategories), activity);
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
                                CreateDialogForProblem(context,"Select Problem Category", list_of_image_id, (ListView) dialog.findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Bugs_List), activity);
                                editor.putBoolean("Clicked1", true);
                                editor.commit();
                                break;
                            case "Disease":
                                dialog.dismiss();
                                list_of_image_id.clear();
                                list_of_image_id = photos_functions.getMainDialogPhotos(activity);
                                CreateDialogForProblem(context,"Select Problem Category", list_of_image_id, (ListView) dialog.findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Bugs_List), activity);
                                editor.putBoolean("Clicked1", true);
                                editor.commit();
                                break;
                            case "Bugs":
                                dialog.dismiss();
                                list_of_image_id.clear();
                                list_of_image_id = photos_functions.getMainDialogPhotos(activity);
                                CreateDialogForProblem(context,"Select Problem Category", list_of_image_id, (ListView) dialog.findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Bugs_List), activity);
                                editor.putBoolean("Clicked1", true);
                                editor.commit();

                                break;

                            case "Vegetables":
                                dialog.dismiss();
                                list_of_image_id.clear();
                                list_of_image_id = photos_functions.getFarmingPhotos(activity);
                                CreateDialogForProblem(context,"Select Problem Category", list_of_image_id, (ListView) dialog.findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_Culture), activity);
                                editor.putBoolean("Clicked1", true);
                                editor.commit();

                                break;
                            case "Legumes":
                                dialog.dismiss();
                                list_of_image_id.clear();
                                list_of_image_id = photos_functions.getFarmingPhotos(activity);
                                CreateDialogForProblem(context,"Select Problem Category", list_of_image_id, (ListView) dialog.findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_Culture), activity);
                                editor.putBoolean("Clicked1", true);
                                editor.commit();

                                break;
                            case "Fruits":
                                dialog.dismiss();
                                list_of_image_id.clear();
                                list_of_image_id = photos_functions.getFarmingPhotos(activity);
                                CreateDialogForProblem(context,"Select Problem Category", list_of_image_id, (ListView) dialog.findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_Culture), activity);
                                editor.putBoolean("Clicked1", true);
                                editor.commit();

                                break;
                            case "Cereal":
                                dialog.dismiss();
                                list_of_image_id.clear();
                                list_of_image_id = photos_functions.getFarmingPhotos(activity);
                                CreateDialogForProblem(context,"Select Problem Category", list_of_image_id, (ListView) dialog.findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_Culture), activity);
                                editor.putBoolean("Clicked1", true);
                                editor.commit();

                                break;
                            case "Olives":
                                dialog.dismiss();
                                list_of_image_id.clear();
                                list_of_image_id = photos_functions.getFarmingPhotos(activity);
                                CreateDialogForProblem(context,"Select Problem Category", list_of_image_id, (ListView) dialog.findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_Culture), activity);
                                editor.putBoolean("Clicked1", true);
                                editor.commit();

                                break;
                            case "Tree Nuts":
                                dialog.dismiss();
                                list_of_image_id.clear();
                                list_of_image_id = photos_functions.getFarmingPhotos(activity);
                                CreateDialogForProblem(context,"Select Problem Category", list_of_image_id, (ListView) dialog.findViewById(R.id.ListView), ButtonArray.get(2), activity.getResources().getStringArray(R.array.Farming_Culture), activity);
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
                                    farmingListVegetablesBugsOptionActivate_class.FarmingListVegetablesBugsOptionActivateEn(context, User_Choose[i], activity,ButtonArray,listView);
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
                                    farmingListLegumesBugsOptionActivate_class.FarmingListLegumesBugsOptionActivateEn(context, User_Choose[i], activity,ButtonArray,listView);
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
                                    farmingListFruitsBugsOptionActivate_class.FarmingListFruitsBugsOptionActivateEn(context, User_Choose[i], activity,ButtonArray,listView);
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
                                    farmingListNutsBugsOptionActivate_class.FarmingListNutsBugsOptionActivateEn(context, User_Choose[i], activity,ButtonArray,listView);
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
                                    farmingListCerealBugsOptionActivate_class.FarmingListCerealBugsOptionActivateEn(context, User_Choose[i], activity,ButtonArray,listView);
                                    anotherflag++;
                                }
                                break;

                        }


                    } else {

                        if (BeforeOption1.matches("Weeds List")) {

                            dialog.dismiss();
                            LayoutArray.get(0).setVisibility(View.VISIBLE);
                            list_of_image_id.clear();
                            bugsListOptionActivate_class.BugsListOptionActivateEn(context, User_Choose[i], activity,editor,ButtonArray,listView);
                            editor.putBoolean("Clicked1", false);
                            editor.commit();

                        } else if (BeforeOption1.matches("Farming Culture List")) {
                            dialog.dismiss();
                            LayoutArray.get(0).setVisibility(View.VISIBLE);
                            list_of_image_id.clear();
                            farmingListOptionActivate_class.FarmingListOptionActivateEn(context, User_Choose[i], activity,editor,ButtonArray,listView);
                            editor.putBoolean("Clicked1", false);
                            editor.commit();

                        }





                    }


                } else {


                    if (User_Choose[i].matches("Weeds List") && LongClickFlag == 0) {
                        dialog.dismiss();
                        list_of_image_id.clear();
                        list_of_image_id.add(activity.getResources().getIdentifier("bugs_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        list_of_image_id.add(activity.getResources().getIdentifier("disease_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        list_of_image_id.add(activity.getResources().getIdentifier("enemies_pahid_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        activateAnotherDialog_class.ActivateAnotherDialogEn(context, list_of_image_id, User_Choose[i],activity,LayoutArray.get(0),editor,ButtonArray,listView);
                        editor.putBoolean("Clicked", false);
                        editor.commit();


                    } else if (User_Choose[i].matches("Farming Culture List") && LongClickFlag == 0) {
                        dialog.dismiss();
                        list_of_image_id.clear();
                        list_of_image_id.add(activity.getResources().getIdentifier("vegetables_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        list_of_image_id.add(activity.getResources().getIdentifier("legumes_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        list_of_image_id.add(activity.getResources().getIdentifier("fruits_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        list_of_image_id.add(activity.getResources().getIdentifier("cereal_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        list_of_image_id.add(activity.getResources().getIdentifier("olives_amin_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        list_of_image_id.add(activity.getResources().getIdentifier("cereal_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        list_of_image_id.add(activity.getResources().getIdentifier("nuts", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                        activateAnotherDialog_class.ActivateAnotherDialogEn(context, list_of_image_id, User_Choose[i],activity,LayoutArray.get(0),editor,ButtonArray,listView);
                        editor.putBoolean("Clicked", false);
                        editor.commit();

                    }


                }


            }
        });



        mDialog_On_Long_Click_Listener.Set_Dialog_On_Long_Click_Listener(activity,context,il,array);



    }






}












