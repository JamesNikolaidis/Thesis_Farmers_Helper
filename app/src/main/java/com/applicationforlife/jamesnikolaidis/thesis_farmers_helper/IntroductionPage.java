package com.applicationforlife.jamesnikolaidis.thesis_farmers_helper;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Dialogs.ChooseSpecialFarming;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Dialogs.Close_Program_Dialog;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Dialogs.Read_Me_Dialog;

/**
 * Created by James Nikolaidis on 1/19/2017.
 */

public class IntroductionPage extends AppCompatActivity {
    private SharedPreferences mSharePreferrence ;
    private static SharedPreferences.Editor mEditor;
    private TextView mIntroductionTextView,mFirstWelcomeMEssage,GoToHomePageTextView;
    private Button mReadMeButton;
    private CheckBox mSeeListViewCheckBox;
    private ChooseSpecialFarming mChooseSpecialFarmingDialogObject;
    private Read_Me_Dialog mReadMeDialog;
    private Typeface type;





    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.introduction_layout);
        mSharePreferrence =  getSharedPreferences("Data",MODE_PRIVATE);
        mEditor = mSharePreferrence.edit();
        //Initialize Layouts Views
        mIntroductionTextView = (TextView)findViewById(R.id.IntroductionText);
        mFirstWelcomeMEssage = (TextView)findViewById(R.id.FirstWelcomeMessage);
        GoToHomePageTextView = (TextView)findViewById(R.id.GoToHomePageTextView);
        mSeeListViewCheckBox = (CheckBox)findViewById(R.id.ListViewCheckBox) ;
        mReadMeButton=(Button)findViewById(R.id.ReadME);

        //Declare Type of Texts with Type Font
        type = Typeface.createFromAsset(getAssets(),"fonts/Catenary_Stamp.ttf");
        //Set Type on TextViews
        mIntroductionTextView.setTypeface(type);
        GoToHomePageTextView.setTypeface(type);



        mChooseSpecialFarmingDialogObject = new ChooseSpecialFarming();
        mReadMeDialog = new Read_Me_Dialog();
        mEditor.putInt("Language",0);
        mEditor.commit();
    }


    public void onEnglandFlagClick(View view) {



            if(view.getId()==R.id.EnglishFlag){
                    mEditor.putInt("Language",1);
                    mEditor.commit();
                    mIntroductionTextView.setText(this.getResources().getString(R.string.Welcome_MassageEng));
                    mFirstWelcomeMEssage.setText(this.getResources().getString(R.string.WelcomeEng));
                    GoToHomePageTextView.setText(this.getResources().getString(R.string.GoToHomePageEng));
                    mIntroductionTextView.setX(110);
                    mIntroductionTextView.setTypeface(null);GoToHomePageTextView.setTypeface(null);
                    mIntroductionTextView.setTextSize(17);
                    GoToHomePageTextView.setTextSize(17);
                    mReadMeButton.setText(this.getResources().getString(R.string.ReadmeEng));

            }else{
                mEditor.putInt("Language",0);
                mEditor.commit();
                mIntroductionTextView.setText(this.getResources().getString(R.string.Welcome_MassageGreek));
                mFirstWelcomeMEssage.setText(this.getResources().getString(R.string.WelcomeGr));
                type = Typeface.createFromAsset(getAssets(),"fonts/Catenary_Stamp.ttf");
                GoToHomePageTextView.setTypeface(type);
                mIntroductionTextView.setTypeface(type);
                mReadMeButton.setTypeface(type);
                mIntroductionTextView.setTextSize(15);
                GoToHomePageTextView.setTextSize(15);
                mIntroductionTextView.setX(10);
                GoToHomePageTextView.setText(this.getResources().getString(R.string.GoToHomePageGr));
                mReadMeButton.setText(this.getResources().getString(R.string.ReadmeGr));
            }



     }







    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if ((keyCode == KeyEvent.KEYCODE_BACK)) {

            Close_Program_Dialog close_program_dialog = new Close_Program_Dialog();
            close_program_dialog.CloseProgramDialog(IntroductionPage.this,mSharePreferrence.getInt("Language",5));
        }
        return false;
    }


    public void UserDialogChoice(View view) {
            if(view.getId()==R.id.ListViewCheckBox){
                  mChooseSpecialFarmingDialogObject.ActivateSpecialFarming(IntroductionPage.this,getApplicationContext(),mSharePreferrence.getInt("Language",0),mEditor,mSeeListViewCheckBox );

            }else if(view.getId()==R.id.GoToHomePageCheckBox){
                Intent goToHomePage = new Intent(IntroductionPage.this,StartAcitvity.class);
                startActivity(goToHomePage);
            }



    }


    public void ReadMeButton(View view) {
        if(mSharePreferrence.getInt("Language",5)==1){
                mReadMeDialog.ActivateReadMeDialog(IntroductionPage.this,getApplicationContext(),1);
        }else{  mReadMeDialog.ActivateReadMeDialog(IntroductionPage.this,getApplicationContext(),0);}




    }




}
