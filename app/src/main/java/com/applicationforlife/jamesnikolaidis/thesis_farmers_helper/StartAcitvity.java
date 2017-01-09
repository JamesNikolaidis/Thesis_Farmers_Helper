package com.applicationforlife.jamesnikolaidis.thesis_farmers_helper;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;

import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Database_Functions.Database_Class_Functions;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Dialogs.Dialogs_Class;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Objects.Products;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Spinners.Spinners;

import java.util.ArrayList;

/**
 * Created by James Nikolaidis on 11/3/2016.
 */

public class StartAcitvity  extends AppCompatActivity {

    //************* Declare Activities Varaibles and Constand Varaibles
        private Spinner Problem_Categories_Spinner1,Specify_Option_Spinner2,Final_Pick_Spinner3;
        private Spinners spinners_object;
        private Button Problem_Select_Button;
        private Dialogs_Class dialogs_class_object;
        private Activity activity;
        private SharedPreferences share ;
        private SharedPreferences.Editor editor;
        private  static ArrayList<Integer> intarray ;
         private Products products;
       private  static ArrayList<Products> list;
        private Database_Class_Functions database_class_functions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity_layout);
        activity=this;
        intarray = new ArrayList<Integer>();
        share = activity.getSharedPreferences("Data",Activity.MODE_PRIVATE);
        editor = share.edit();


        Problem_Select_Button = (Button)findViewById(R.id.Problem_Select_Button);
        dialogs_class_object = new Dialogs_Class(getApplicationContext());
        dialogs_class_object.DeclareButtons((Button)findViewById(R.id.Specify_Problem_Select_Button),(Button)findViewById(R.id.Last_Select_Button),(Button)findViewById(R.id.LastPick_Select_Button),Problem_Select_Button);
        dialogs_class_object.DeclareLayouts((LinearLayout)findViewById(R.id.Specify_Linear),(LinearLayout)findViewById(R.id.BeforeFinal_Linear),(LinearLayout)findViewById(R.id.Final_Linear));
        editor.putBoolean("Clicked",true);
        editor.commit();


        intarray.add(activity.getResources().getIdentifier("weeds","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
        intarray.add(activity.getResources().getIdentifier("farming1","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
        dialogs_class_object.CreateDialogForProblem(getApplicationContext(),"Select Problem Category",intarray,(ListView)findViewById(R.id.ListView),Problem_Select_Button,activity.getResources().getStringArray(R.array.ProblemCategories),activity);



    }

    public void Hey(View view) {

        intarray.add(activity.getResources().getIdentifier("weeds","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
        intarray.add(activity.getResources().getIdentifier("farming1","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
        editor.putBoolean("Clicked",true);
        editor.commit();
        dialogs_class_object.CreateDialogForProblem(getApplicationContext(),"Select Problem Category",intarray,(ListView)findViewById(R.id.ListView),Problem_Select_Button,activity.getResources().getStringArray(R.array.ProblemCategories),activity);






    }





}
