package com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.R;

import java.util.ArrayList;

/**
 * Created by James Nikolaidis on 11/11/2016.
 */

public class CustomAdapter extends ArrayAdapter<String> {
        private static  ArrayList<Integer> imageid;



        Context context;
    public CustomAdapter(Context context, String[] objects,ArrayList<Integer> imageId) throws  NullPointerException {
        super(context,R.layout.custom_adapter_medium_screens, objects);



                     this.imageid = new ArrayList<>(); this.imageid = imageId;  this.context = context;











    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The LayoutInflator puts a layout into the right View
        LayoutInflater theInflater = LayoutInflater.from(getContext());
        View theView = theInflater.inflate(R.layout.custom_adapter_medium_screens, parent, false);
        String tvShow = getItem(position);
        TextView theTextView = (TextView) theView.findViewById(R.id.TextView);
        ImageView imageView = (ImageView)theView.findViewById(R.id.ImageView);
        imageView.setImageResource(imageid.get(position));
        theTextView.setText(tvShow);

        return theView;
    }
}
