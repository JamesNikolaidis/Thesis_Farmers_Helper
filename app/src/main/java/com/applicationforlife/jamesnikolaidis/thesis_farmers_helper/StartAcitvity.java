package com.applicationforlife.jamesnikolaidis.thesis_farmers_helper;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Dialogs.DialogClassGr;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Dialogs.Dialogs_Class;

import java.util.ArrayList;

/**
 * Created by James Nikolaidis on 11/3/2016.
 */

public class StartAcitvity  extends AppCompatActivity {
        //************* Declare Activities Varaibles and Constand Varaibles
        private Button Problem_Select_Button;
        private Dialogs_Class dialogs_class_object;
        private DialogClassGr dialogs_class_objectGr;
        private SharedPreferences share ;
        private SharedPreferences.Editor editor;
        private  static ArrayList<Integer> intarray ;
        private TextView mSelectProblem;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity_layout);
        intarray = new ArrayList<Integer>(0);
        share = this.getSharedPreferences("Data",Activity.MODE_PRIVATE);
        editor = share.edit();
        Problem_Select_Button = (Button)findViewById(R.id.Problem_Select_Button);
        editor.putBoolean("Clicked",true);
        editor.putBoolean("Clicked1",false);
        editor.commit();
        mSelectProblem = (TextView)findViewById(R.id.SelectProblemTextView);
        dialogs_class_objectGr = new DialogClassGr(getApplicationContext());

        intarray.add(this.getResources().getIdentifier("weeds","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
        intarray.add(this.getResources().getIdentifier("farming1","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));

        if (share.getInt("Language",5)==1) {
            dialogs_class_object = new Dialogs_Class(getApplicationContext());
            dialogs_class_object.DeclareButtons(Problem_Select_Button,(Button)findViewById(R.id.Specify_Problem_Select_Button),(Button)findViewById(R.id.Last_Select_Button),(Button)findViewById(R.id.LastPick_Select_Button));
            dialogs_class_object.DeclareLayouts((LinearLayout)findViewById(R.id.Specify_Linear),(LinearLayout)findViewById(R.id.BeforeFinal_Linear),(LinearLayout)findViewById(R.id.Final_Linear));
            dialogs_class_object.CreateDialogForProblem(getApplicationContext(),getResources().getString(R.string.FirstButtonTextEng),intarray,(ListView)findViewById(R.id.ListView),Problem_Select_Button,this.getResources().getStringArray(R.array.ProblemCategories),this);
            mSelectProblem.setText(getResources().getString(R.string.FirstButtonTextEng));
        }else{


            dialogs_class_objectGr = new DialogClassGr(getApplicationContext());
            dialogs_class_objectGr.DeclareButtons(Problem_Select_Button,(Button)findViewById(R.id.Specify_Problem_Select_Button),(Button)findViewById(R.id.Last_Select_Button),(Button)findViewById(R.id.LastPick_Select_Button));
            dialogs_class_objectGr.DeclareLayouts((LinearLayout)findViewById(R.id.Specify_Linear),(LinearLayout)findViewById(R.id.BeforeFinal_Linear),(LinearLayout)findViewById(R.id.Final_Linear));
            dialogs_class_objectGr.CreateDialogForProblem(getApplicationContext(),getResources().getString(R.string.FirstButtonTextGr),intarray,(ListView)findViewById(R.id.ListView),Problem_Select_Button,this.getResources().getStringArray(R.array.FirstPanelNamesGr),this);
            mSelectProblem.setText(getResources().getString(R.string.FirstButtonTextGr));
        }


    }

    public void CreateFirstDialog(View view) {

        intarray.add(this.getResources().getIdentifier("weeds","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
        intarray.add(this.getResources().getIdentifier("farming1","drawable","com.applicationforlife.jamesnikolaidis.thesis_farmers_helper"));
        editor.putBoolean("Clicked",true);
        editor.commit();
        if (share.getInt("Language",5)==1) {
            dialogs_class_object.CreateDialogForProblem(getApplicationContext(),getResources().getString(R.string.FirstButtonTextEng),intarray,(ListView)findViewById(R.id.ListView),Problem_Select_Button,this.getResources().getStringArray(R.array.ProblemCategories),this);
        }else{
            dialogs_class_objectGr.CreateDialogForProblem(getApplicationContext(),getResources().getString(R.string.FirstButtonTextGr),intarray,(ListView)findViewById(R.id.ListView),Problem_Select_Button,this.getResources().getStringArray(R.array.FirstPanelNamesGr),this);
        }


    }



    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            Intent goToFistPage = new Intent(StartAcitvity.this,IntroductionPage.class);
            this.startActivity(goToFistPage);
        }
        return false;
    }









}
