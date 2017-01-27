package com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Translater;

/**
 * Created by James Nikolaidis on 1/27/2017.
 */

public class Translater  {
        private String TranslatedText;



    public Translater(){}




    public String translate(String text) {
     if(text!=null){
        switch (text){
            case "Αγγούρι":
                TranslatedText = "Cucumber";
                break;
            case "Ντοματα":
                TranslatedText = "Tomato";
                break;
            case "Αγγινάρα":
                TranslatedText = "Artichoke";
                break;
            case "Κουνουπίδι":
                TranslatedText = "Cauliflower";
                break;
            case "Μπρόκολο":
                TranslatedText = "Broccoli";
                break;
            case "Κρεμμύδι":
                TranslatedText = "Onion";
                break;
            case "Σπανακί":
                TranslatedText = "Spinach";
                break;
            case "Λάχανο":
                TranslatedText = "Cabbage";
                break;
            case "Φασόλια":
                TranslatedText = "Beans";
                break;
            case "Φακές":
                TranslatedText = "Lentil";
                break;
            case "Ρεβύθια":
                TranslatedText = "Chickpea";
                break;
            case "Μπιζέλια":
                TranslatedText = "Peas";
                break;
            case "Ελιά":
                TranslatedText = "Olive";
                break;
            case "Ρύζι":
                TranslatedText = "Rice";
                break;
            case "Σιτάρι":
                TranslatedText = "Wheat";
                break;
            case "Βρώμη":
                TranslatedText = "Oats";
                break;
            case "Κριθάρι":
                TranslatedText = "Barley";
                break;
            case "Καλαμπόκι":
                TranslatedText = "Corn";
                break;
            case "Πορτοκάλι":
                TranslatedText = "Orange";
                break;
            case "Μήλο":
                TranslatedText = "Apple";
                break;
            case "Λεμόνι":
                TranslatedText = "Lemon";
                break;
            case "Αχλάδι":
                TranslatedText = "Pear";
                break;
            case "Ροδάκινο":
                TranslatedText = "Peach";
                break;
            case "Φράουλα":
                TranslatedText = "Strawberry";
                break;
            case "Σύκο":
                TranslatedText = "Fig";
                break;
            case "Βερύκοκο":
                TranslatedText = "Apricot";
                break;
            case "Κέρασι":
                TranslatedText = "Cherry";
                break;
            case "Μαντάρινη":
                TranslatedText = "Mandarin";
                break;
            case "Καρπούζι":
                TranslatedText = "Watermelon";
                break;
            case "Φυστικιά":
                TranslatedText = "Peanut";
                break;
            case "Αμυγδαλιά":
                TranslatedText = "Almond";
                break;
            case "Φουντουκιά":
                TranslatedText = "Hazel";
                break;
            case "Καστανιά":
                TranslatedText = "Chestnut";
                break;
            case "Καρυδιά":
                TranslatedText = "Walnuts";
                break;
            default:
                TranslatedText =null;
                break;

        }

         return TranslatedText;
     }else{
         return null;

     }



    }






}
