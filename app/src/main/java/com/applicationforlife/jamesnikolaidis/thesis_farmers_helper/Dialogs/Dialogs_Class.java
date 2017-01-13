package com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Adapters.CustomAdapter;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Network_Wifi.Network_Wifi_Class;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Photos_Fuctions.Photos_Functions;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.R;

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
        ButtonArray.add(buttons[3]);

    }

    public void CreateDialogForProblem(final Context context, String texttitle , final ArrayList<Integer> ImagesId, final ListView list, final Button button, final String[] array, final Activity activity){
        share = activity.getSharedPreferences("Data",Activity.MODE_PRIVATE);
        editor = share.edit();
        listView=list;
        mNetwork_and_Wifi_Object = new Network_Wifi_Class(context,activity);
        photos_functions=new Photos_Functions();
        final AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(activity, R.style.AlertDialogCustom));
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ListAdapter adapter = new CustomAdapter(context,array,ImagesId);
        final AlertDialog dialog = builder.create();
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.show();
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_layout);
        final TextView title = (TextView)dialog.findViewById(R.id.TitleTextView);
        title.setText(texttitle);
        Button BackButton =(Button)dialog.findViewById(R.id.back_button);
        ListView il = (ListView) dialog.findViewById(R.id.ListView);
        BackButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               anotherflag=0;

               if(share.getBoolean("Clicked",false)==false && share.getBoolean("Clicked1",false)==true){

                   dialog.dismiss();
                   list_of_image_id.clear();
                   list_of_image_id.add(activity.getResources().getIdentifier("weeds","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                   list_of_image_id.add(activity.getResources().getIdentifier("farming1","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                   CreateDialogForProblem(context," Select Problem Category",list_of_image_id,(ListView)findViewById(R.id.ListView),ButtonArray.get(3),activity.getResources().getStringArray(R.array.ProblemCategories),activity);
                   BeforeOption1 ="";
                   BeforeOption2="";
                   editor.putBoolean("Clicked",true);
                   editor.commit();
                   editor.putBoolean("Clicked1",true);
                   editor.commit();


               }else if(share.getBoolean("Clicked",false)==false && share.getBoolean("Clicked1",false)==false) {
                   list_of_image_id.clear();


                   if(flag==0){
                   switch (BeforeOption2) {
                       case "Enemies":
                           dialog.dismiss();
                           list_of_image_id.clear();
                           list_of_image_id = photos_functions.getMainDialogPhotos(activity);
                           CreateDialogForProblem(context, "Select Problem Category", list_of_image_id, (ListView) findViewById(R.id.ListView), ButtonArray.get(3), activity.getResources().getStringArray(R.array.Bugs_List), activity);
                           editor.putBoolean("Clicked1", true);
                           editor.commit();
                           break;
                       case "Disease":
                           dialog.dismiss();
                           list_of_image_id.clear();
                           list_of_image_id = photos_functions.getMainDialogPhotos(activity);
                           CreateDialogForProblem(context, "Select Problem Category", list_of_image_id, (ListView) findViewById(R.id.ListView), ButtonArray.get(3), activity.getResources().getStringArray(R.array.Bugs_List), activity);
                           editor.putBoolean("Clicked1", true);
                           editor.commit();

                           break;
                       case "Bugs":
                           dialog.dismiss();
                           list_of_image_id.clear();
                           list_of_image_id = photos_functions.getMainDialogPhotos(activity);
                           CreateDialogForProblem(context, "Select Problem Category", list_of_image_id, (ListView) findViewById(R.id.ListView), ButtonArray.get(3), activity.getResources().getStringArray(R.array.Bugs_List), activity);
                           editor.putBoolean("Clicked1", true);
                           editor.commit();

                           break;

                       case "Vegetables":
                           dialog.dismiss();
                           list_of_image_id.clear();
                           list_of_image_id = photos_functions.getFarmingPhotos(activity);
                           CreateDialogForProblem(context, "Select Problem Category", list_of_image_id, (ListView) findViewById(R.id.ListView), ButtonArray.get(3), activity.getResources().getStringArray(R.array.Farming_Culture), activity);
                           editor.putBoolean("Clicked1", true);
                           editor.commit();

                           break;
                       case "Legumes":
                           dialog.dismiss();
                           list_of_image_id.clear();
                           list_of_image_id = photos_functions.getFarmingPhotos(activity);
                           CreateDialogForProblem(context, "Select Problem Category", list_of_image_id, (ListView) findViewById(R.id.ListView), ButtonArray.get(3), activity.getResources().getStringArray(R.array.Farming_Culture), activity);
                           editor.putBoolean("Clicked1", true);
                           editor.commit();

                           break;
                       case "Fruits":
                           dialog.dismiss();
                           list_of_image_id.clear();
                           list_of_image_id = photos_functions.getFarmingPhotos(activity);
                           CreateDialogForProblem(context, "Select Problem Category", list_of_image_id, (ListView) findViewById(R.id.ListView), ButtonArray.get(3), activity.getResources().getStringArray(R.array.Farming_Culture), activity);
                           editor.putBoolean("Clicked1", true);
                           editor.commit();

                           break;
                       case "Cereal":
                           dialog.dismiss();
                           list_of_image_id.clear();
                           list_of_image_id = photos_functions.getFarmingPhotos(activity);
                           CreateDialogForProblem(context, "Select Problem Category", list_of_image_id, (ListView) findViewById(R.id.ListView), ButtonArray.get(3), activity.getResources().getStringArray(R.array.Farming_Culture), activity);
                           editor.putBoolean("Clicked1", true);
                           editor.commit();

                           break;
                       case "Olives":
                           dialog.dismiss();
                           list_of_image_id.clear();
                           list_of_image_id = photos_functions.getFarmingPhotos(activity);
                           CreateDialogForProblem(context, "Select Problem Category", list_of_image_id, (ListView) findViewById(R.id.ListView), ButtonArray.get(3), activity.getResources().getStringArray(R.array.Farming_Culture), activity);
                           editor.putBoolean("Clicked1", true);
                           editor.commit();

                           break;
                       case "Tree Nuts":
                           dialog.dismiss();
                           list_of_image_id.clear();
                           list_of_image_id = photos_functions.getFarmingPhotos(activity);
                           CreateDialogForProblem(context, "Select Problem Category", list_of_image_id, (ListView) findViewById(R.id.ListView), ButtonArray.get(3), activity.getResources().getStringArray(R.array.Farming_Culture), activity);
                           editor.putBoolean("Clicked1", true);
                           editor.commit();

                           break;



                   }

                   }else{
                   if (Before3.matches("Orange") || Before3.matches("Apple") || Before3.matches("Strawberry") || Before3.matches("Pear") || Before3.matches("Apricot") || Before3.matches("Watermelon") || Before3.matches("Cherry") || Before3.matches("Mandarin") || Before3.matches("Fig") || Before3.matches("Peach")){
                       dialog.dismiss();
                       list_of_image_id.clear();
                       list_of_image_id=photos_functions.getFruitsPhotos(activity);
                       CreateDialogForProblem(context,"Solutuion For.",list_of_image_id,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Fruits), activity);
                       flag=0;


                   }else if(Before3.matches("Rice") || Before3.matches("Wheat")  || Before3.matches("Oats") ||Before3.matches("Corn") || Before3.matches("Barley")  ){

                       dialog.dismiss();
                       list_of_image_id.clear();
                       list_of_image_id=photos_functions.getCerealPhotos(activity);
                       CreateDialogForProblem(context,"Solutuion For.",list_of_image_id,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Cereals), activity);
                       flag=0;

                   }else if(Before3.matches("Beans") || Before3.matches("Lentil")  || Before3.matches("Chickpeas") ||Before3.matches("Peas")){

                       dialog.dismiss();
                       list_of_image_id.clear();
                       list_of_image_id=photos_functions.getLentilPhotos(activity);
                       CreateDialogForProblem(context,"Solutuion For.",list_of_image_id,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Legumes), activity);
                       flag=0;

                   }else if(Before3.matches("Cucumber") || Before3.matches("Artichoke")  || Before3.matches("Cauliflower") || Before3.matches("Spinach")|| Before3.matches("Onion") || Before3.matches("Cabbage") || Before3.matches("Broccoli") || Before3.matches("Tomato")){

                       dialog.dismiss();
                       list_of_image_id.clear();
                       list_of_image_id=photos_functions.getVegetablesPhotos(activity);
                       CreateDialogForProblem(context,"Solutuion For.",list_of_image_id,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Vegetables), activity);
                       flag=0;
                   }else if(Before3.matches("Almond Tree") || Before3.matches("Peanut tree")  || Before3.matches("Hazel Nuts") || Before3.matches("Chestnut Tree")|| Before3.matches("Walnuts")){

                       dialog.dismiss();
                       list_of_image_id.clear();
                       list_of_image_id=photos_functions.getNutsPhotos(activity);
                       CreateDialogForProblem(context,"Solutuion For.",list_of_image_id, listView,ButtonArray.get(2), activity.getResources().getStringArray(R.array.Tree_Nuts), activity);
                       flag=0;

                   }







               }






               }else if(share.getBoolean("Clicked",false)==true && share.getBoolean("Clicked1",false)==true){
                   dialog.dismiss();
                   editor.putBoolean("Clicked",true);
               }



           }
       });










        il.setAdapter(adapter);
        il.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


               String value = (String)adapterView.getItemAtPosition(i);
               String[] User_Choose = array;

               button.setText((String)adapterView.getItemAtPosition(i));

               if(share.getBoolean("Clicked",false)==false){



                   if(share.getBoolean("Clicked1",false)==false && LongClickFlag==0)
                   {
                       switch (BeforeOption2){

                           case "Enemies":

                               mNetwork_and_Wifi_Object.CheckWifiConnectionAndEnable();
                               editor.putString("SpecifyProblem",User_Choose[i]);
                               editor.commit();
                               dialog.cancel();
                               mNetwork_and_Wifi_Object.CheckWifiConnectionAndEnable();
                               break;
                           case "Disease":
                               editor.putString("SpecifyProblem",User_Choose[i]);
                               editor.commit();
                               mNetwork_and_Wifi_Object.CheckWifiConnectionAndEnable();
                               break;
                           case "Bugs":
                               editor.putString("SpecifyProblem",User_Choose[i]);
                               editor.commit();
                               dialog.cancel();
                               mNetwork_and_Wifi_Object.CheckWifiConnectionAndEnable();

                               break;

                           case "Vegetables":
                               if(!Before3.isEmpty() && anotherflag==1) {
                                   editor.putString("SpecifyProblem",User_Choose[i]);
                                   editor.commit();
                                   dialog.cancel();
                                   mNetwork_and_Wifi_Object.CheckWifiConnectionAndEnable();
                               }else{dialog.dismiss();  FarmingListVegetablesBugsOptionActivate(context, User_Choose[i], activity); anotherflag++;}
                               break;
                           case "Legumes":


                               if(!Before3.isEmpty() && anotherflag==1){
                                    editor.putString("SpecifyProblem",User_Choose[i]);
                                    editor.commit();
                                   dialog.cancel();
                                   mNetwork_and_Wifi_Object.CheckWifiConnectionAndEnable();


                               }else{ dialog.dismiss(); FarmingListLegumesBugsOptionActivate(context,User_Choose[i],activity); anotherflag++;}
                               break;

                           case "Fruits":
                               if(!Before3.isEmpty() && anotherflag==1){
                                   editor.putString("SpecifyProblem",User_Choose[i]);
                                   editor.commit();
                                   dialog.cancel();
                                   mNetwork_and_Wifi_Object.CheckWifiConnectionAndEnable();
                               }else{ dialog.dismiss();FarmingListFruitsBugsOptionActivate(context,User_Choose[i],activity); anotherflag++;}
                               break;

                           case "Tree Nuts":

                               if(!Before3.isEmpty() && anotherflag==1){
                                   editor.putString("SpecifyProblem",User_Choose[i]);
                                   editor.commit();
                                   dialog.cancel();
                                   mNetwork_and_Wifi_Object.CheckWifiConnectionAndEnable();


                               }else{ dialog.dismiss();FarmingListNutsBugsOptionActivate(context,User_Choose[i],activity); anotherflag++;}
                               break;

                           case "Cereal":

                               if(!Before3.isEmpty() && anotherflag==1){
                                   editor.putString("SpecifyProblem",User_Choose[i]);
                                   editor.commit();
                                   dialog.cancel();
                                   mNetwork_and_Wifi_Object.CheckWifiConnectionAndEnable();



                               }else{dialog.dismiss(); FarmingListCerealBugsOptionActivate(context,User_Choose[i],activity);anotherflag++;}
                               break;

                       }




                   }else{

                       if(BeforeOption1.matches("Weeds List"))
                       {
                           dialog.dismiss();
                           list_of_image_id.clear();
                           BugsListOptionActivate(context, User_Choose[i],activity);
                           editor.putBoolean("Clicked1",false);
                           editor.commit();
                       }
                       else if(BeforeOption1.matches("Farming-Culture_List"))
                       {
                           dialog.dismiss();
                           list_of_image_id.clear();
                           FarmingListOptionActivate(context,User_Choose[i],activity);
                           editor.putBoolean("Clicked1",false);
                           editor.commit();
                       }






                   }







               }



               else{


                   if (User_Choose[i].matches("Weeds List") && LongClickFlag==0) {
                       dialog.dismiss();
                       list_of_image_id.clear();
                       list_of_image_id.add(activity.getResources().getIdentifier("bugs_main_photo","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                       list_of_image_id.add(activity.getResources().getIdentifier("disease_main_photo","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                       list_of_image_id.add(activity.getResources().getIdentifier("enemies_pahid_main_photo","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                       ActivateAnotherDialog(context,list_of_image_id, User_Choose[i],activity);
                       editor.putBoolean("Clicked",false);
                       editor.commit();


                   }else if (User_Choose[i].matches("Farming-Culture_List")&& LongClickFlag==0){
                       dialog.dismiss();
                       list_of_image_id.clear();
                       list_of_image_id.add(activity.getResources().getIdentifier("vegetables_main_photo","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                       list_of_image_id.add(activity.getResources().getIdentifier("legumes_main_photo","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                       list_of_image_id.add(activity.getResources().getIdentifier("fruits_main_photo","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                       list_of_image_id.add(activity.getResources().getIdentifier("cereal_main_photo","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                       list_of_image_id.add(activity.getResources().getIdentifier("olives_amin_photo","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                       list_of_image_id.add(activity.getResources().getIdentifier("cereal_main_photo","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                       list_of_image_id.add(activity.getResources().getIdentifier("nuts","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                       ActivateAnotherDialog(context,list_of_image_id, User_Choose[i],activity);
                       editor.putBoolean("Clicked",false);
                       editor.commit();

                   }





               }











           }
       });



       il.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
           @Override
           public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
               String[] User_Choose = array;

               LongClickFlag=1;
               final AlertDialog.Builder builder1 = new AlertDialog.Builder(new ContextThemeWrapper(activity, R.style.AlertDialogCustom));
               final AlertDialog dialog1 = builder1.create();
               final AlertDialog dialog = builder1.create();
               dialog1.getWindow().getAttributes().windowAnimations = R.style.InformationDialog;
               dialog1.show();
               dialog1.setContentView(R.layout.problem_information);
               Button CancelButton = (Button)dialog1.findViewById(R.id.cancel);
               TextView infromation_text_view = (TextView)dialog1.findViewById(R.id.information_text_view);
               ImageView info_image = (ImageView)dialog1.findViewById(R.id.information_image);



               switch(User_Choose[i]){
                   case "Burr" :


                    CancelButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                                dialog1.dismiss();
                            LongClickFlag=0;
                        }
                    });

                   infromation_text_view.setText(activity.getString(R.string.Burr));

                   info_image.setImageResource(R.drawable.burr_bug);
                       break;


                   case "Lollium":



                   CancelButton.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View view) {
                           dialog1.dismiss();
                           LongClickFlag=0;
                       }
                   });

                   infromation_text_view.setText(activity.getString(R.string.Lollium));
                   info_image.setImageResource(R.drawable.lolium);
               break;

                   case "Sorghum halepense":


                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.sorghum_halepense));
                       info_image.setImageResource(R.drawable.sorghum_halepense);
                       break;

                   case "Convolvulus arvensis":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.Convolvulus_arvensis));
                       info_image.setImageResource(R.drawable.convolvulus_arv);
                       break;

                   case "Bromus":

                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.Burr));

                       info_image.setImageResource(R.drawable.burr_bug);
                       break;


            //****************** Here starts the Disease List
                   case "Verticillium dahliae(Cotton)":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.Verticillium_dahliae));

                       info_image.setImageResource(R.drawable.vertic);

                       break;


                   case "Verticillium dahliae(Walnuts-Olive)":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.Verticillium_dahliae));

                       info_image.setImageResource(R.drawable.vertic);

                       break;








                   case "Alternaria(Herbs)":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.Alternaria));

                       info_image.setImageResource(R.drawable.alteraria);
                       break;


                   case "Potatoe-Tomatoe Alternaria":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.Alternaria));

                       info_image.setImageResource(R.drawable.alteraria);
                       break;





                   case "Anthracnose of Cucurbits":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.anthracnose_of_cucurbits));

                       info_image.setImageResource(R.drawable.anthracnose_of_cucurbits);
                       break;



                   case "Anthracnose citrus":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.anthracnose_citrus));

                       info_image.setImageResource(R.drawable.anthracnose_citrus);
                       break;

                   case "Anthracnose of Cottons":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.anthracnose_citrus));

                       info_image.setImageResource(R.drawable.anthracnose_of_cottons);
                       break;

                   case "Anthracnose":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.anthracnose_citrus));

                       info_image.setImageResource(R.drawable.anthracnose_citrus);
                       break;

                   case "Bacterial necrosis":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.bacterial_necrosis));

                       info_image.setImageResource(R.drawable.bacterial_necrosis);
                       break;



                   case "Bacterial rot of maize strain":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.maize));

                       info_image.setImageResource(R.drawable.bacterial_rot_of_maize_strain);
                       break;


                   case "Trialeurode":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.trialeurode));

                       info_image.setImageResource(R.drawable.trialeurodes_vaporariorum);
                       break;



                   case "Thrips":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.thrips));

                       info_image.setImageResource(R.drawable.thrips);
                       break;


                   case "Phyllonorycter":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.phyllonorycter));

                       info_image.setImageResource(R.drawable.phyllonorycter_blancardella);
                       break;


                   case "Lygus hesperuss":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.lygus_hesperuss));

                       info_image.setImageResource(R.drawable.lygus_hesperus);
                       break;


                   case "Bremia Lactucae":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.bremia_lactucae));

                       info_image.setImageResource(R.drawable.bremia_lactucae);
                       break;





                   case "Ramularia cynarae":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.ramularia_cynarae));

                       info_image.setImageResource(R.drawable.ramularia_beticola);
                       break;


                   case "Oidium":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.oidium));

                       info_image.setImageResource(R.drawable.oidium);
                       break;


                   case "Aphids":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.aphids));

                       info_image.setImageResource(R.drawable.aphis);
                       break;

                   case "Pyrameis atalanta":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.pyrameis_atalanta));

                       info_image.setImageResource(R.drawable.pyrameis_atalanta);
                       break;

                   case "Cassida":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.cassida));

                       info_image.setImageResource(R.drawable.cassida);
                       break;



                   case "Agriotes lineatus":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.agriotes_lineatus));

                       info_image.setImageResource(R.drawable.agriotes_lineatus);
                       break;


                   case "Plasmodiophorabrassicae":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.plasmodiophorabrassicae));

                       info_image.setImageResource(R.drawable.plasmodiophorabrassicae);
                       break;




                   case "Sclerotinia sclerotiorum":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.sclerotinia_sclerotiorum));

                       info_image.setImageResource(R.drawable.sclerotiniasclerotiorum);
                       break;


                   case "Alternaria brassicae":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.Alternaria));

                       info_image.setImageResource(R.drawable.alteraria);
                       break;


                   case "Mildew-Pseudoperonospora cubensis":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.mildew_pseudoperonospora_cubensis));

                       info_image.setImageResource(R.drawable.pseudoperonospora_cubensis);
                       break;


                   case "Tylenchulus semipenetrans":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.root_tylenchulus_semipenetrans));

                       info_image.setImageResource(R.drawable.citrus_root_nematode);
                       break;






                   case "Pythium ultimum":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.pythium_ultimum));

                       info_image.setImageResource(R.drawable.pythium_ultimum);
                       break;




                   case "Botrytis cinerea":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.botrytis_cinerea));

                       info_image.setImageResource(R.drawable.botrytis_cinerea);
                       break;

                   case "Puccinia porri":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.puccinia_porri));

                       info_image.setImageResource(R.drawable.puccinia_porri);
                       break;


                   case "Tetranychus urticae":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.tetranychus_urticae));

                       info_image.setImageResource(R.drawable.tetranychus_urticae);
                       break;


                   case "Tuta absoluta":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.tuta_absoluta));

                       info_image.setImageResource(R.drawable.tuta_absoluta);
                       break;

                   case "Phytophthora":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.phytophthora));

                       info_image.setImageResource(R.drawable.phytophthora);
                       break;




                   case "Fusarium":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.fusarium));

                       info_image.setImageResource(R.drawable.vascular_wilt_of_lentil);
                       break;

                   case "Ephydra attica":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.ephydra_attica));

                       info_image.setImageResource(R.drawable.ephydra_attica);
                       break;


                   case "Sesamia":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.sesamia));

                       info_image.setImageResource(R.drawable.sesamia);
                       break;

                   case "Paspalum distichum":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.paspalum_distichum));

                       info_image.setImageResource(R.drawable.paspalum_distichum);
                       break;


                   case "Septoria":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.septoria));

                       info_image.setImageResource(R.drawable.septoria_pyricola);
                       break;





                   case "Black loose smut":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.black_loose_smut));

                       info_image.setImageResource(R.drawable.black_loose_smut);
                       break;

                   case "Helminthosporium solani":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.helminthosporium_solani));

                       info_image.setImageResource(R.drawable.helminthosporium);
                       break;


                   case "Lygus pabulinus":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.lygus_pabulinus));

                       info_image.setImageResource(R.drawable.lygus_pabulinus);
                       break;



                   case "Covered smut":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.covered_smut));

                       info_image.setImageResource(R.drawable.covered_smut);
                       break;

                   case "Agrotis spp":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.agrotis_spp));

                       info_image.setImageResource(R.drawable.agrotis_spp);
                       break;


                   case "Apple mosaic virus":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.apple_mosaic_virus));

                       info_image.setImageResource(R.drawable.apple_mosaic_virus);
                       break;



                   case "Apple Fusicladium":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.apple_fusicladium));

                       info_image.setImageResource(R.drawable.fusicladium);
                       break;


                   case "Cydia pomonella":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.cydia_pomonella));

                       info_image.setImageResource(R.drawable.cydia_pomonella);
                       break;


                   case "Adoxophyes orana":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.adoxophyes_orana));

                       info_image.setImageResource(R.drawable.adoxophyes_orana);
                       break;

                   case "Panonychus ulmi":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.panonychus_ulmi));

                       info_image.setImageResource(R.drawable.panonychus_ulmi);
                       break;



                   case "Cossus Linnaeus":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.cossus_linnaeus));

                       info_image.setImageResource(R.drawable.cossus_linnaeus);
                       break;







                   case "Powdery mildew":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.powdery_mildew));

                       info_image.setImageResource(R.drawable.powdery_mildew);
                       break;




                   case "Chaetosiphon fragaefolii Aphid":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.chaetosiphon_fragaefolii_aphid));

                       info_image.setImageResource(R.drawable.fragaefolii_aphid);
                       break;


                   case "Thrips tabaci":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.thrips));

                       info_image.setImageResource(R.drawable.thrips);
                       break;

                   case "Fusicladium pirinum":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.apple_fusicladium));

                       info_image.setImageResource(R.drawable.fusicladium);
                       break;



                   case "Oidium furinosum":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.oidium));

                       info_image.setImageResource(R.drawable.oidium);
                       break;

                   case "Brown rot":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.brown_rot));

                       info_image.setImageResource(R.drawable.brown_rot);
                       break;


                   case "Erwinia amylovora":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.erwinia_amylovora));

                       info_image.setImageResource(R.drawable.erwinia_amylovora);
                       break;


                   case "Cacopsylla pyri":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.cacopsylla_pyri));

                       info_image.setImageResource(R.drawable.cacopsylla_pyri);
                       break;


                   case "Taphrina deformans":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.taphrina_deformans));

                       info_image.setImageResource(R.drawable.taphrina_deformans);
                       break;


                   case "Coryneum":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.coryneum));

                       info_image.setImageResource(R.drawable.coryneum);
                       break;


                   case "Puccinia pruni-spinosae":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.puccinia_porri));

                       info_image.setImageResource(R.drawable.puccinia_pruni_spinosae);
                       break;




                   case "Kylindrosporiosi":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.Kylindrosporiosi));

                       info_image.setImageResource(R.drawable.kylindrosporiosi);
                       break;


                   case "Fusicladium":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.apple_fusicladium));

                       info_image.setImageResource(R.drawable.fusicladium);
                       break;


                   case "Alternaria cucumerina":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.Alternaria));

                       info_image.setImageResource(R.drawable.alteraria);
                       break;


                   case "Cladosporium cucumarinum":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.Alternaria));

                       info_image.setImageResource(R.drawable.alteraria);
                       break;

                   case "Rhizoctonia":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.Rhizoctonia));

                       info_image.setImageResource(R.drawable.rhizoctonia);
                       break;


                   case "Sclerotinia":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.Sclerotinia));

                       info_image.setImageResource(R.drawable.sclerotiniasclerotiorum);
                       break;



                   case "watermelon mosaic virus":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.apple_mosaic_virus));

                       info_image.setImageResource(R.drawable.apple_mosaic_virus);
                       break;



                   case "Meloidogyne incognita":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.Meloidogyne_incognita));

                       info_image.setImageResource(R.drawable.melodoigyne);
                       break;



                   case "Acalymma trivittatum":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.Acalymma_trivittatum));

                       info_image.setImageResource(R.drawable.acalymma_trivittatum);
                       break;


                   case "Heliothrips":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.Heliothrips));

                       info_image.setImageResource(R.drawable.heliothrips);
                       break;



                   case "Tetranychus":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.tetranychus_urticae));

                       info_image.setImageResource(R.drawable.tetranychus_urticae);
                       break;


                   case "Medfly":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.Medfly));

                       info_image.setImageResource(R.drawable.medfly);
                       break;



                   case "Phyllocnistis citrella":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.Phyllocnistis_citrella));

                       info_image.setImageResource(R.drawable.phyllocnistis_citrella);
                       break;



                   case "Planococcus citri":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.Planococcus_citri));

                       info_image.setImageResource(R.drawable.planococcus);
                       break;


                   case "Red scale":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.Red_scale));

                       info_image.setImageResource(R.drawable.red_scale);
                       break;


                   case "Lepidosaphes beckii":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.Lepidosaphes_beckii));

                       info_image.setImageResource(R.drawable.lepidosaphes_beckii);
                       break;

                   case "Icerya":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.Icerya));

                       info_image.setImageResource(R.drawable.icerya);
                       break;


                   case "Citrus red mite":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.Citrus_red_mite));

                       info_image.setImageResource(R.drawable.citrus_red_mite);
                       break;


                   case "Ceroplastes rusci":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.Ceroplastes_rusci));

                       info_image.setImageResource(R.drawable.ceroplastes_rusci);
                       break;


                   case "Αceria fici":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.Αceria_fici));

                       info_image.setImageResource(R.drawable.aceria_fici);
                       break;



                   case "Phytophthora parasitica":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.phytophthora));

                       info_image.setImageResource(R.drawable.phytophthora);
                       break;


                   case "Lonchaea":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.Lonchaea));

                       info_image.setImageResource(R.drawable.lonchaea);
                       break;
                   case "Ascochyta":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.Ascochyta));

                       info_image.setImageResource(R.drawable.ascochyta);
                       break;

                   case "Botrytis":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.Botrytis));

                       info_image.setImageResource(R.drawable.botrytis_cinerea);
                       break;


                   case "Uromyces phaseoli":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.Uromyces_phaseoli));

                       info_image.setImageResource(R.drawable.uromycesphaseoli);
                       break;
                   case "Pythium spp":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.pythium_ultimum));

                       info_image.setImageResource(R.drawable.pythium_spp2);
                       break;



                   case "Bruchus":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.Bruchus));

                       info_image.setImageResource(R.drawable.bruchus);
                       break;


                   case "Liriomyza":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.Liriomyza));

                       info_image.setImageResource(R.drawable.liriomyza_trifolii04);
                       break;

                   case "Sitona macularius":
                       CancelButton.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {
                               dialog1.dismiss();
                               LongClickFlag=0;
                           }
                       });

                       infromation_text_view.setText(activity.getString(R.string.Sitona_macularius));

                       info_image.setImageResource(R.drawable.sitona_macularius);
                       break;

               }






               return false;
       }



});

    }



    public void ActivateAnotherDialog(final Context context, final ArrayList<Integer> imageid, String BeforeOption, final Activity activity){

        if(LayoutArray.get(0).getVisibility()== View.INVISIBLE)
        {

             switch (BeforeOption)
             {
                 case "Weeds List":

                     LayoutArray.get(0).setVisibility(View.VISIBLE);
                     editor.putBoolean("Clicked1",true);
                     editor.commit();
                     //Here image Code
                     CreateDialogForProblem(context," Specify Problem.",imageid,listView,ButtonArray.get(0),activity.getResources().getStringArray(R.array.Bugs_List),activity);
                     ButtonArray.get(0).setOnClickListener(new View.OnClickListener() {
                         @Override
                         public void onClick(View view) {
                             editor.putBoolean("Clicked1",true);
                             editor.commit();
                             CreateDialogForProblem(context," Specify Problem.",imageid,listView,ButtonArray.get(0),activity.getResources().getStringArray(R.array.Bugs_List),activity);
                         }
                     });
                     BeforeOption1=BeforeOption;
                     break;
                 case "Farming-Culture_List":
                     LayoutArray.get(0).setVisibility(View.VISIBLE);
                     editor.putBoolean("Clicked1",true);
                     editor.commit();
                     CreateDialogForProblem(context," Specify Problem.",imageid,listView,ButtonArray.get(0),activity.getResources().getStringArray(R.array.Farming_Culture),activity);
                     ButtonArray.get(0).setOnClickListener(new View.OnClickListener() {
                         @Override
                         public void onClick(View view) {
                              editor.putBoolean("Clicked1",true);
                             editor.commit();
                             CreateDialogForProblem(context," Specify Problem.",imageid,listView,ButtonArray.get(0),activity.getResources().getStringArray(R.array.Farming_Culture),activity);
                         }
                     });
                     BeforeOption1=BeforeOption;
                     break;
                 case "Products":


                     break;

                 default:
                     break;









             }



        }else{


            switch (BeforeOption)
            {
                case "Weeds List":
                    LayoutArray.get(0).setVisibility(View.VISIBLE);
                    CreateDialogForProblem(context," Specify Problem.",imageid,listView,ButtonArray.get(0),activity.getResources().getStringArray(R.array.Bugs_List),activity);
                    editor.putBoolean("Clicked1",true);
                    editor.commit();
                    ButtonArray.get(0).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            CreateDialogForProblem(context," Specify Problem.",imageid,listView,ButtonArray.get(0),activity.getResources().getStringArray(R.array.Bugs_List),activity);
                            editor.putBoolean("Clicked1",true);
                            editor.commit();
                        }
                    });
                    BeforeOption1=BeforeOption;
                    break;
                case "Farming-Culture_List":
                    LayoutArray.get(0).setVisibility(View.VISIBLE);
                    CreateDialogForProblem(context," Specify Problem.",imageid,listView,ButtonArray.get(0),activity.getResources().getStringArray(R.array.Farming_Culture),activity);
                    editor.putBoolean("Clicked1",true);
                    editor.commit();







                    ButtonArray.get(0).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            CreateDialogForProblem(context," Specify Problem.",imageid,listView,ButtonArray.get(0),activity.getResources().getStringArray(R.array.Farming_Culture),activity);
                            editor.putBoolean("Clicked1",true);
                            editor.commit();
                        }
                    });
                    BeforeOption1=BeforeOption;
                    break;
                case "Products":


                    break;
                default:
                    break;





            }

        }//END OF IF


        }




    public void BugsListOptionActivate(final Context context,  String BeforeOption, final Activity activity)
    {
        final ArrayList<Integer> imageid = new ArrayList<>();

        switch (BeforeOption)
        {
            case "Enemies":
                imageid.clear();
                for(int counter=0; counter!=activity.getResources().getStringArray(R.array.Enemies).length; counter++){
                    imageid.add(activity.getResources().getIdentifier("bugs_icon","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                }


                LayoutArray.get(1).setVisibility(View.VISIBLE);
                CreateDialogForProblem(context,"Solutuion For.",imageid,listView,ButtonArray.get(1),activity.getResources().getStringArray(R.array.Enemies),activity);
                ButtonArray.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        CreateDialogForProblem(context,"Solutuion For.",imageid,listView,ButtonArray.get(1),activity.getResources().getStringArray(R.array.Enemies),activity);
                    }
                });
             BeforeOption2 =BeforeOption;
                break;
            case "Disease":

                LayoutArray.get(1).setVisibility(View.VISIBLE);
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
                CreateDialogForProblem(context,"Solutuion For.",imageid,listView,ButtonArray.get(1),activity.getResources().getStringArray(R.array.Desease_List),activity);
                ButtonArray.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        CreateDialogForProblem(context,"Solutuion For.",imageid,listView,ButtonArray.get(1),activity.getResources().getStringArray(R.array.Desease_List),activity);
                    }
                });
                BeforeOption2 =BeforeOption;
                break;
            default:

                LayoutArray.get(1).setVisibility(View.VISIBLE);
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("burr_bug","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("lolium","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("sorghum_halepense","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("convolvulus_arv","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("burr_bug","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                CreateDialogForProblem(context,"Solutuion For.",imageid,listView,ButtonArray.get(1),activity.getResources().getStringArray(R.array.Bugs_List_Extend),activity);
                ButtonArray.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        CreateDialogForProblem(context,"Solutuion For.",imageid,listView,ButtonArray.get(1),activity.getResources().getStringArray(R.array.Bugs_List_Extend),activity);
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
                CreateDialogForProblem(context,"Solutuion For.",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Vegetables), activity);
                LayoutArray.get(1).setVisibility(View.VISIBLE);
                ButtonArray.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        CreateDialogForProblem(context,"Solutuion For.",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Vegetables), activity);
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

                CreateDialogForProblem(context,"Solutuion For.",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Legumes), activity);
                LayoutArray.get(1).setVisibility(View.VISIBLE);
                ButtonArray.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        CreateDialogForProblem(context,"Solutuion For.",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Legumes), activity);
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
                LayoutArray.get(1).setVisibility(View.VISIBLE);
                CreateDialogForProblem(context,"Solutuion For.",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Fruits), activity);
                ButtonArray.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        CreateDialogForProblem(context,"Solutuion For.",imageid,listView,ButtonArray.get(2), activity.getResources().getStringArray(R.array.Fruits), activity);
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
                LayoutArray.get(1).setVisibility(View.VISIBLE);
                CreateDialogForProblem(context,"Solutuion For.",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Cereals), activity);
                ButtonArray.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        CreateDialogForProblem(context,"Solutuion For.",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Cereals), activity);
                    }
                });
                BeforeOption2 =BeforeOption;
                break;
            case "Olives":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("olives","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                LayoutArray.get(1).setVisibility(View.VISIBLE);
                CreateDialogForProblem(context,"Solutuion For.",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.olives), activity);
                ButtonArray.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        CreateDialogForProblem(context,"Solutuion For.",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.olives), activity);
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
                LayoutArray.get(1).setVisibility(View.VISIBLE);
                CreateDialogForProblem(context,"Solutuion For.",imageid, listView,ButtonArray.get(2), activity.getResources().getStringArray(R.array.Tree_Nuts), activity);
                ButtonArray.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        CreateDialogForProblem(context,"Solutuion For.",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Tree_Nuts), activity);
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
                CreateDialogForProblem(context,"Solutuion For.",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Cucumber), activity);
                LayoutArray.get(1).setVisibility(View.VISIBLE);
                ButtonArray.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        CreateDialogForProblem(context,"Solutuion For.",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Cucumber), activity);
                    }
                });
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
                CreateDialogForProblem(context,"Solutuion For.",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Artichoke_Bugs), activity);
                LayoutArray.get(1).setVisibility(View.VISIBLE);
                ButtonArray.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        CreateDialogForProblem(context,"Solutuion For.",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Artichoke_Bugs), activity);
                    }
                });
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
                CreateDialogForProblem(context,"Solutuion For.",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Cauliflower__Broccoli_Bugs), activity);
                ButtonArray.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        CreateDialogForProblem(context,"Solutuion For.",imageid,listView,ButtonArray.get(2), activity.getResources().getStringArray(R.array.Cauliflower__Broccoli_Bugs), activity);
                    }
                });
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
                CreateDialogForProblem(context,"Solutuion For.",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Spinach_Bugs), activity);
                ButtonArray.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        CreateDialogForProblem(context,"Solutuion For.",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Spinach_Bugs), activity);
                    }
                });
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
                CreateDialogForProblem(context,"Solutuion For.",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Onion_Bugs), activity);
                ButtonArray.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        CreateDialogForProblem(context,"Solutuion For.",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Onion_Bugs), activity);
                    }
                });
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
                CreateDialogForProblem(context,"Solutuion For.",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Cauliflower__Broccoli_Bugs), activity);
                ButtonArray.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        CreateDialogForProblem(context,"Solutuion For.",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Cauliflower__Broccoli_Bugs), activity);
                    }
                });
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
                CreateDialogForProblem(context,"Solutuion For.",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Cauliflower__Broccoli_Bugs), activity);
                ButtonArray.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        CreateDialogForProblem(context,"Solutuion For.",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Cauliflower__Broccoli_Bugs), activity);
                    }
                });
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
                CreateDialogForProblem(context,"Solutuion For.",imageid, listView,ButtonArray.get(2), activity.getResources().getStringArray(R.array.Tomatoe_Bugs), activity);
                ButtonArray.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        CreateDialogForProblem(context,"Solutuion For.",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Tomatoe_Bugs), activity);
                    }
                });
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

                CreateDialogForProblem(context,"Solutuion For.",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Beans_Peas_chickBeans_Bugs), activity);
                LayoutArray.get(1).setVisibility(View.VISIBLE);
                ButtonArray.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        CreateDialogForProblem(context,"Solutuion For.",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Beans_Peas_chickBeans_Bugs), activity);
                    }
                });
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
                CreateDialogForProblem(context,"Solutuion For.",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Lentil_Bugs), activity);
                LayoutArray.get(1).setVisibility(View.VISIBLE);
                ButtonArray.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        CreateDialogForProblem(context,"Solutuion For.",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Lentil_Bugs), activity);
                    }
                });
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

                LayoutArray.get(1).setVisibility(View.VISIBLE);
                CreateDialogForProblem(context,"Solutuion For.",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Beans_Peas_chickBeans_Bugs), activity);
                ButtonArray.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        CreateDialogForProblem(context,"Solutuion For.",imageid,listView,ButtonArray.get(2), activity.getResources().getStringArray(R.array.Beans_Peas_chickBeans_Bugs), activity);
                    }
                });
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
                CreateDialogForProblem(context,"Solutuion For.",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Beans_Peas_chickBeans_Bugs), activity);
                ButtonArray.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        CreateDialogForProblem(context,"Solutuion For.",imageid,listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Beans_Peas_chickBeans_Bugs), activity);
                    }
                });
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
                CreateDialogForProblem(context, "Solutuion For.", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Apple_Bugs), activity);
                LayoutArray.get(1).setVisibility(View.VISIBLE);
                flag=1;
                ButtonArray.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        CreateDialogForProblem(context, "Solutuion For.", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Apple_Bugs), activity);
                    }
                });
                Before3 = BeforeOption;
                break;
            case "Strawberry":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("aphis", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("thrips", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("tetranychus_urticae", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("lygus_hesperus", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                CreateDialogForProblem(context, "Solutuion For.", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Strawberry_Bugs), activity);
                LayoutArray.get(1).setVisibility(View.VISIBLE);
                ButtonArray.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        CreateDialogForProblem(context, "Solutuion For.", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Strawberry_Bugs), activity);
                    }
                });
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
                LayoutArray.get(1).setVisibility(View.VISIBLE);
                flag=1;
                CreateDialogForProblem(context, "Solutuion For.", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Apricot_Peach_Cherry_Bugs), activity);
                ButtonArray.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        CreateDialogForProblem(context, "Solutuion For.", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Apricot_Peach_Cherry_Bugs), activity);
                    }
                });
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
                LayoutArray.get(1).setVisibility(View.VISIBLE);


                CreateDialogForProblem(context, "Solutuion For.", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Apricot_Peach_Cherry_Bugs), activity);
                ButtonArray.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        CreateDialogForProblem(context, "Solutuion For.", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Apricot_Peach_Cherry_Bugs), activity);
                    }
                });
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
                LayoutArray.get(1).setVisibility(View.VISIBLE);


                CreateDialogForProblem(context, "Solutuion For.", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Watermelon_bugs), activity);
                ButtonArray.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        CreateDialogForProblem(context, "Solutuion For.", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Watermelon_bugs), activity);
                    }
                });
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
                LayoutArray.get(1).setVisibility(View.VISIBLE);


                CreateDialogForProblem(context, "Solutuion For.", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Apricot_Peach_Cherry_Bugs), activity);
                ButtonArray.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        CreateDialogForProblem(context, "Solutuion For.", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Apricot_Peach_Cherry_Bugs), activity);
                    }
                });
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
                LayoutArray.get(1).setVisibility(View.VISIBLE);


                CreateDialogForProblem(context, "Solutuion For.", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Lemon_Orange__Mandarine_Bugs), activity);
                ButtonArray.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        CreateDialogForProblem(context, "Solutuion For.", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Lemon_Orange__Mandarine_Bugs), activity);
                    }
                });
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
                LayoutArray.get(1).setVisibility(View.VISIBLE);


                CreateDialogForProblem(context, "Solutuion For.", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Lemon_Orange__Mandarine_Bugs), activity);
                ButtonArray.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        CreateDialogForProblem(context, "Solutuion For.", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Lemon_Orange__Mandarine_Bugs), activity);
                    }
                });
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
                LayoutArray.get(1).setVisibility(View.VISIBLE);


                CreateDialogForProblem(context, "Solutuion For.", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Apricot_Peach_Cherry_Bugs), activity);
                ButtonArray.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        CreateDialogForProblem(context, "Solutuion For.", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Apricot_Peach_Cherry_Bugs), activity);
                    }
                });
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
                LayoutArray.get(1).setVisibility(View.VISIBLE);


                CreateDialogForProblem(context, "Solutuion For.", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Fig_Bugs), activity);
                ButtonArray.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        CreateDialogForProblem(context, "Solutuion For.", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Fig_Bugs), activity);
                    }
                });
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
                LayoutArray.get(1).setVisibility(View.VISIBLE);


                CreateDialogForProblem(context, "Solutuion For.", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Lemon_Orange__Mandarine_Bugs), activity);
                ButtonArray.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        CreateDialogForProblem(context, "Solutuion For.", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Lemon_Orange__Mandarine_Bugs), activity);
                    }
                });
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
                CreateDialogForProblem(context, "Solutuion For.", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Apple_Bugs), activity);
                LayoutArray.get(1).setVisibility(View.VISIBLE);
                ButtonArray.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        CreateDialogForProblem(context, "Solutuion For.", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Apple_Bugs), activity);
                    }
                });
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
                LayoutArray.get(1).setVisibility(View.VISIBLE);
                CreateDialogForProblem(context, "Solutuion For.", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Apricot_Peach_Cherry_Bugs), activity);
                ButtonArray.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        CreateDialogForProblem(context, "Solutuion For.", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Apricot_Peach_Cherry_Bugs), activity);
                    }
                });
                flag=1;
                Before3 = BeforeOption;
                break;

        }








    }








    public void FarmingListNutsBugsOptionActivate(final Context context,String BeforeOption, final Activity activity) {

        final ArrayList<Integer> imageid = new ArrayList<>();
        switch (BeforeOption) {
            case "Almond Tree":
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
                CreateDialogForProblem(context, "Solutuion For.", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Almond_Trees_Bugs), activity);
                LayoutArray.get(1).setVisibility(View.VISIBLE);
                ButtonArray.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        CreateDialogForProblem(context, "Solutuion For.", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Almond_Trees_Bugs), activity);
                    }
                });
                flag=1;
                Before3 = BeforeOption;
                break;
            case "Peanut tree":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("vertic", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("phytophthora", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("musa_armillaria", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("phelinus_rimosus", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("acrantus_vestitus", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("covered_smut", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                LayoutArray.get(1).setVisibility(View.VISIBLE);
                CreateDialogForProblem(context, "Solutuion For.", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Peanut_Tree_Bugs), activity);
                ButtonArray.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        CreateDialogForProblem(context, "Solutuion For.", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Peanut_Tree_Bugs), activity);
                    }
                });
                flag=1;
                Before3 = BeforeOption;
                break;


            case "Chestnut Tree":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("cydia_chest", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("moth_pammene_fasciana", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("balaninus_elephas", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("peritelus_sphaeroides", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("agrobacterium_tumefaciens", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("anthracnose_citrus", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("powdery_mildew", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                LayoutArray.get(1).setVisibility(View.VISIBLE);
                CreateDialogForProblem(context, "Solutuion For.", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Chestnut_Tree_Bugs), activity);
                ButtonArray.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        CreateDialogForProblem(context, "Solutuion For.", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Chestnut_Tree_Bugs), activity);
                    }
                });
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
                LayoutArray.get(1).setVisibility(View.VISIBLE);
                CreateDialogForProblem(context, "Solutuion For.", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Walnuts_Tree_Bugs), activity);
                ButtonArray.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        CreateDialogForProblem(context, "Solutuion For.", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Walnuts_Tree_Bugs), activity);
                    }
                });
                flag=1;
                Before3 = BeforeOption;
                break;

            case "Hazel Nuts":
                imageid.clear();
                imageid.add(activity.getResources().getIdentifier("anthracnose_citrus", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("syringae", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("musa_armillaria", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("oberea_linearis", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                imageid.add(activity.getResources().getIdentifier("cydia_chest", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
                LayoutArray.get(1).setVisibility(View.VISIBLE);
                CreateDialogForProblem(context, "Solutuion For.", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Walnuts_Tree_Bugs), activity);
                ButtonArray.get(1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        CreateDialogForProblem(context, "Solutuion For.", imageid, listView, ButtonArray.get(2), activity.getResources().getStringArray(R.array.Walnuts_Tree_Bugs), activity);
                    }
                });
                flag=1;
                Before3 = BeforeOption;
                break;

        }








    }












}












