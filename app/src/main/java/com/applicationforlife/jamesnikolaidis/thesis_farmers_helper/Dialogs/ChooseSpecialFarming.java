package com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.IntroductionPage;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.R;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Second_Screen_For_ShortAction;

/**
 * Created by James Nikolaidis on 1/19/2017.
 */

public class ChooseSpecialFarming extends IntroductionPage {
        private TextView mChooseOptiomTextView;
        private ListView mChooseOptionListView;
        private Button mGoBack;
        private  AlertDialog mChooseSpecialFarmingChooserDialog;
        private CheckBox mListCheckBox;
        private Typeface type;





        public ChooseSpecialFarming(){}

        public void   ActivateSpecialFarming(final Activity activity , final Context context , int Language, final SharedPreferences.Editor mEditor, final CheckBox mCheckBox) {
            AlertDialog.Builder mChooseSpecialFarmingChooser = new AlertDialog.Builder(activity);
            mChooseSpecialFarmingChooserDialog = mChooseSpecialFarmingChooser.create();
            mListCheckBox = mCheckBox;

            type = Typeface.createFromAsset(activity.getAssets(),"fonts/Catenary_Stamp.ttf");
            mChooseSpecialFarmingChooserDialog.show();
            mChooseSpecialFarmingChooserDialog.setCancelable(false);
            mChooseSpecialFarmingChooserDialog.setContentView(R.layout.choose_special_farming);
            mChooseOptiomTextView = (TextView) mChooseSpecialFarmingChooserDialog.findViewById(R.id.SelectOptionTextView);
            mChooseOptionListView = (ListView) mChooseSpecialFarmingChooserDialog.findViewById(R.id.SelectOptionListView);
            mGoBack = (Button) mChooseSpecialFarmingChooserDialog.findViewById(R.id.back_buttonOnChooseSpecialFarming);
            if (Language == 0) {
                String[] getListViewOptions = activity.getResources().getStringArray(R.array.ChooseSpecialFarmingOptionsGr);
                ListAdapter mChooseOptionAdapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, getListViewOptions);
                mChooseOptionListView.setAdapter(mChooseOptionAdapter);
                mChooseOptiomTextView.setTypeface(type);
                mChooseOptiomTextView.setText(activity.getResources().getString(R.string.PleaseSelectGr));


            } else {

                String[] getListViewOptions = activity.getResources().getStringArray(R.array.ChooseSpecialFarmingOptionsEng);
                ListAdapter mChooseOptionAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, getListViewOptions);
                mChooseOptionListView.setAdapter(mChooseOptionAdapter);
                mChooseOptiomTextView.setText(activity.getResources().getString(R.string.PleaseSelectEng));

            }


            mGoBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mChooseSpecialFarmingChooserDialog.cancel();
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mCheckBox.setChecked(false);
                        }
                    });


                }
            });


            mChooseOptionListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    mEditor.putString("SpecifyProblem", (String) adapterView.getItemAtPosition(i));
                    mEditor.commit();
                    mChooseSpecialFarmingChooserDialog.cancel();
                    Intent goToProductsPage = new Intent(activity, Second_Screen_For_ShortAction.class);
                    activity.startActivity(goToProductsPage);


                }
            });


            mChooseSpecialFarmingChooserDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
                @Override
                public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {

                    if (i == KeyEvent.KEYCODE_BACK) {
                        mChooseSpecialFarmingChooserDialog.dismiss();
                        activity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mCheckBox.setChecked(false);
                            }
                        });
                    }
                    return false;
                }
            });
        }













}
