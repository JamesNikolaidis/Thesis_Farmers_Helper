package com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.R;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Timers.New_MessageTimer;

import java.util.ArrayList;

/**
 * Created by James Nikolaidis on 1/11/2017.
 */

public class Chat_Adapter extends ArrayAdapter<String> {

    private static ArrayList<String> mMessage,mMessageKey;
    private static ArrayList<String> mm;
    public static int mCounter=0;
    public static int mMessageSituation = 0;
    public New_MessageTimer mNewMessageTimer;




    Context context;
    public Chat_Adapter(Context context, ArrayList<String> message,ArrayList<String> key,int Situation) throws  NullPointerException {
        super(context, R.layout.chat_adapter_layout,message);
                this.mMessage = message;
                this.mMessageKey =key;
                mNewMessageTimer = new New_MessageTimer();
                this.mMessageSituation=Situation;


    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The LayoutInflator puts a layout into the right View
        LayoutInflater theInflater = LayoutInflater.from(getContext());
        View theView = theInflater.inflate(R.layout.chat_adapter_layout, parent, false);
        TextView mMessengerNameTextView = (TextView) theView.findViewById(R.id.MessengerName);
        TextView mMessageTextView = (TextView) theView.findViewById(R.id.Message);

        if(mMessageSituation==0){
        mMessengerNameTextView.setText(mMessage.get(position));
        mMessageTextView.setText(mMessageKey.get(position));
        }else {
            mMessengerNameTextView.setText(mMessage.get(position));
            mMessageTextView.setText(mMessageKey.get(position));
           // mNew_MessageView.setVisibility(View.VISIBLE);
           // mNewMessageTimer.Activate_New_Message_Timer(mNew_MessageView);
        }





        return theView;
    }
}
