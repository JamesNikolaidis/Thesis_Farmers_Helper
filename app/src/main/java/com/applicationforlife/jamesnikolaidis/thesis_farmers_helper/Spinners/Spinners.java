package com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Spinners;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.R;

import java.util.ArrayList;

/**
 * Created by James Nikolaidis on 11/4/2016.
 */

public class Spinners {

    private static Context APPLICATION_CONTEXT;
    private static ArrayList<Spinner> spinners;
    private static boolean selectionControl=true;

    //*************   Class Constructor
        public Spinners(Context app_context){
            this.APPLICATION_CONTEXT = app_context;
            spinners = new ArrayList<>();
        }

    //*************   Spinner Initializer method
    public void Spinner_Initializer(Context context,LinearLayout linearLayout , Spinner ...SpinnerObject){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context, R.array.ProblemCategories,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SpinnerObject[0].setAdapter(adapter);
        SetSpecifySpinnerSelectedListener(SpinnerObject[0],linearLayout);


        spinners.add(SpinnerObject[0]);
        spinners.add(SpinnerObject[1]);
        spinners.add(SpinnerObject[2]);

    }

    //********** Spinner OnItemListener method
    public void SetSpecifySpinnerSelectedListener(final Spinner spinner, final LinearLayout layout) {

        final String[] value = new String[1];


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                        value[0] = String.valueOf(adapterView.getItemAtPosition(i));
                        Toast.makeText(APPLICATION_CONTEXT, value[0],Toast.LENGTH_SHORT).show();
                        ActivateSpecifySpinnerVisabilityByData(value[0],layout);


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


       // ActivateSpinnerVisabilityByData(value[0],viewGroup);
    }

    //************ Create method which make views VISIBLE
        public void MakeObjectVisible(View ...views){

            for(int counter=0; counter!=views.length; counter++){
                views[counter].setVisibility(View.VISIBLE);
            }


        }

    //************ Create method which make views INVISIBLE
        public void MakeObjectInvisible(View ...views){

            for(int counter=0; counter!=views.length; counter++){
                views[counter].setVisibility(View.INVISIBLE);
            }

        }


    public void ActivateSpecifySpinnerVisabilityByData(String data,LinearLayout ...layout){


        if(layout[0].getVisibility()==View.INVISIBLE) {

            switch (data) {
                case "Bugs":
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(APPLICATION_CONTEXT, R.array.Bugs_List,android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinners.get(1).setAdapter(adapter);
                    layout[0].setVisibility(View.VISIBLE);
                    break;
                case "Farming-Culture":

                    ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(APPLICATION_CONTEXT, R.array.Farming_Culture,android.R.layout.simple_spinner_item);
                    adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinners.get(1).setAdapter(adapter1);
                    layout[0].setVisibility(View.VISIBLE);
                    break;
                case "Products":
                    Toast.makeText(APPLICATION_CONTEXT,"Products",Toast.LENGTH_SHORT).show();
                    break;
                default:
                    Toast.makeText(APPLICATION_CONTEXT,"Vehicle",Toast.LENGTH_SHORT).show();
                    break;

            }
        }else


            switch (data) {
                case "Bugs":
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(APPLICATION_CONTEXT, R.array.Bugs_List,android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinners.get(1).setAdapter(adapter);
                    layout[0].setVisibility(View.VISIBLE);
                    break;
                case "Farming-Culture":

                    ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(APPLICATION_CONTEXT, R.array.Farming_Culture,android.R.layout.simple_spinner_item);
                    adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinners.get(1).setAdapter(adapter1);
                    layout[0].setVisibility(View.VISIBLE);
                    break;
                case "Products":
                    Toast.makeText(APPLICATION_CONTEXT,"Products",Toast.LENGTH_SHORT).show();
                    break;
                default:
                    Toast.makeText(APPLICATION_CONTEXT,"Vehicle",Toast.LENGTH_SHORT).show();
                    break;

            }







    }




}
