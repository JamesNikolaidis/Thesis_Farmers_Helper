package com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.R;

import java.util.ArrayList;

/**
 * Created by James Nikolaidis on 1/11/2017.
 */

public class Chat_Adapter extends ArrayAdapter<String> {

    private static ArrayList<String> mMessage,mMessageKey;
    private static ArrayList<String> mm;
    public static int mCounter=0;



    Context context;
    public Chat_Adapter(Context context, ArrayList<String> message,ArrayList<String> key) throws  NullPointerException {
        super(context, R.layout.chat_adapter_layout,message);
                this.mMessage = message;
                this.mMessageKey =key;


    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The LayoutInflator puts a layout into the right View
        LayoutInflater theInflater = LayoutInflater.from(getContext());
        View theView = theInflater.inflate(R.layout.chat_adapter_layout, parent, false);
        TextView mMessengerNameTextView = (TextView) theView.findViewById(R.id.MessengerName);
        TextView mMessageTextView = (TextView) theView.findViewById(R.id.Message);

        mMessengerNameTextView.setText(mMessage.get(position));
        mMessageTextView.setText(mMessageKey.get(position));






        return theView;
    }
}
