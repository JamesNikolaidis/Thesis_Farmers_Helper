package com.applicationforlife.jamesnikolaidis.thesis_farmers_helper;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
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
    private TextView mIntroductionTextView;
    private Button mYesButton , mNoButton,mReadMeButton;
    private ChooseSpecialFarming mChooseSpecialFarmingDialogObject;
    private Read_Me_Dialog mReadMeDialog;





    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.introduction_layout);
        mSharePreferrence =  getSharedPreferences("Data",MODE_PRIVATE);
        mEditor = mSharePreferrence.edit();
        mIntroductionTextView = (TextView)findViewById(R.id.IntroductionText);
        mYesButton = (Button)findViewById(R.id.YesButton);
        mNoButton = (Button) findViewById(R.id.NoButton);
        mReadMeButton=(Button)findViewById(R.id.ReadME);
        mChooseSpecialFarmingDialogObject = new ChooseSpecialFarming();
        mReadMeDialog = new Read_Me_Dialog();
        mEditor.putInt("Language",1);
        mEditor.commit();
    }


    public void onEnglandFlagClick(View view) {



            if(view.getId()==R.id.EnglishFlag){
                    mEditor.putInt("Language",1);
                    mEditor.commit();
                    mIntroductionTextView.setText(this.getResources().getString(R.string.Welcome_MassageEng));
                    mYesButton.setText(this.getResources().getString(R.string.Yes_ButtonEng));
                    mNoButton.setText(this.getResources().getString(R.string.NoButtonEng));
                    mReadMeButton.setText(this.getResources().getString(R.string.ReadmeEng));

            }else{
                mEditor.putInt("Language",0);
                mEditor.commit();
                mIntroductionTextView.setText(this.getResources().getString(R.string.Welcome_MassageGreek));
                mYesButton.setText(this.getResources().getString(R.string.Yes_ButtonGr));
                mNoButton.setText(this.getResources().getString(R.string.No_ButtonGr));
                mReadMeButton.setText(this.getResources().getString(R.string.ReadmeGr));
            }



     }











    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            Close_Program_Dialog close_program_dialog = new Close_Program_Dialog();
            close_program_dialog.CloseProgramDialog(IntroductionPage.this,getApplicationContext(),mSharePreferrence.getInt("Language",5));
        }
        return false;
    }


    public void UserDialogChoice(View view) {
            if(view.getId()==R.id.YesButton){
                mChooseSpecialFarmingDialogObject.ActivateSpecialFarming(IntroductionPage.this,getApplicationContext(),mSharePreferrence.getInt("Language",0),mEditor);

            }else if(view.getId()==R.id.NoButton){
                  Intent goToSecondMainPage = new Intent(IntroductionPage.this,StartAcitvity.class);
                  startActivity(goToSecondMainPage);

            }



    }


    public void ReadMeButton(View view) {
        if(mSharePreferrence.getInt("Language",5)==1){
                mReadMeDialog.ActivateReadMeDialog(IntroductionPage.this,getApplicationContext(),1);
        }else{  mReadMeDialog.ActivateReadMeDialog(IntroductionPage.this,getApplicationContext(),0);}



    }



}
