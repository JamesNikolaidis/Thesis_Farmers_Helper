package com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Photos_Fuctions;

import android.app.Activity;

import java.util.ArrayList;

/**
 * Created by James Nikolaidis on 1/6/2017.
 */

public class Photos_Functions {

                public Photos_Functions(){}


public ArrayList<Integer> getFarmingPhotos(Activity activity){
    ArrayList<Integer> list_of_image_id = new ArrayList<>();
    list_of_image_id.add(activity.getResources().getIdentifier("vegetables_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
    list_of_image_id.add(activity.getResources().getIdentifier("legumes_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
    list_of_image_id.add(activity.getResources().getIdentifier("fruits_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
    list_of_image_id.add(activity.getResources().getIdentifier("cereal_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
    list_of_image_id.add(activity.getResources().getIdentifier("olives_amin_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
    list_of_image_id.add(activity.getResources().getIdentifier("cereal_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
    list_of_image_id.add(activity.getResources().getIdentifier("nuts", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));

        return  list_of_image_id;
}


    public ArrayList<Integer> getFruitsPhotos(Activity activity){
        ArrayList<Integer> list_of_image_id = new ArrayList<>();
        list_of_image_id.add(activity.getResources().getIdentifier("apple", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
        list_of_image_id.add(activity.getResources().getIdentifier("strawberry", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
        list_of_image_id.add(activity.getResources().getIdentifier("pear", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
        list_of_image_id.add(activity.getResources().getIdentifier("apriums", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
        list_of_image_id.add(activity.getResources().getIdentifier("watermelon", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
        list_of_image_id.add(activity.getResources().getIdentifier("cherry", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
        list_of_image_id.add(activity.getResources().getIdentifier("lemon", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
        list_of_image_id.add(activity.getResources().getIdentifier("mandarin", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
        list_of_image_id.add(activity.getResources().getIdentifier("peach", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
        list_of_image_id.add(activity.getResources().getIdentifier("fig", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
        list_of_image_id.add(activity.getResources().getIdentifier("orange", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
        return list_of_image_id;
    }




    public ArrayList<Integer> getLentilPhotos(Activity activity){
        ArrayList<Integer> list_of_image_id = new ArrayList<>();
        list_of_image_id.add(activity.getResources().getIdentifier("beans","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
        list_of_image_id.add(activity.getResources().getIdentifier("lentils","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
        list_of_image_id.add(activity.getResources().getIdentifier("chickpeas","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
        list_of_image_id.add(activity.getResources().getIdentifier("peas","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));

        return list_of_image_id;
    }

    public ArrayList<Integer> getCerealPhotos(Activity activity){
        ArrayList<Integer> list_of_image_id = new ArrayList<>();
        list_of_image_id.add(activity.getResources().getIdentifier("rice","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
        list_of_image_id.add(activity.getResources().getIdentifier("wheat","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
        list_of_image_id.add(activity.getResources().getIdentifier("oats","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
        list_of_image_id.add(activity.getResources().getIdentifier("corn","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
        list_of_image_id.add(activity.getResources().getIdentifier("barley","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
        return list_of_image_id;
    }




    public ArrayList<Integer> getVegetablesPhotos(Activity activity){
        ArrayList<Integer> list_of_image_id = new ArrayList<>();
        list_of_image_id.add(activity.getResources().getIdentifier("cucumber","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
        list_of_image_id.add(activity.getResources().getIdentifier("artichoke","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
        list_of_image_id.add(activity.getResources().getIdentifier("cauliflower","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
        list_of_image_id.add(activity.getResources().getIdentifier("spinach","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
        list_of_image_id.add(activity.getResources().getIdentifier("onion","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
        list_of_image_id.add(activity.getResources().getIdentifier("cabbage","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
        list_of_image_id.add(activity.getResources().getIdentifier("broccoli","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
        list_of_image_id.add(activity.getResources().getIdentifier("tomato","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));

        return list_of_image_id;
    }



    public ArrayList<Integer> getNutsPhotos(Activity activity){
        ArrayList<Integer> list_of_image_id = new ArrayList<>();
        list_of_image_id.add(activity.getResources().getIdentifier("almond","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
        list_of_image_id.add(activity.getResources().getIdentifier("peanut","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
        list_of_image_id.add(activity.getResources().getIdentifier("hazel_nuts","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
        list_of_image_id.add(activity.getResources().getIdentifier("chestnuts","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
        list_of_image_id.add(activity.getResources().getIdentifier("walnuts","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));

        return list_of_image_id;
    }



    public ArrayList<Integer> getMainDialogPhotos(Activity activity){

        ArrayList<Integer> list_of_image_id = new ArrayList<>();
        list_of_image_id.add(activity.getResources().getIdentifier("bugs_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
        list_of_image_id.add(activity.getResources().getIdentifier("disease_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
        list_of_image_id.add(activity.getResources().getIdentifier("enemies_pahid_main_photo", "drawable", "com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));

            return list_of_image_id;

    }









}
