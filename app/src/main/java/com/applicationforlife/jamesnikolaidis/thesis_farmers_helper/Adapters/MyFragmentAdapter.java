package com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Database_Functions.Database_Class_Functions;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Fragment.ProductFragment;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Objects.WeedsProduct;

import java.util.ArrayList;

/**
 * Created by James Nikolaidis on 8/11/2016.
 */
public class MyFragmentAdapter extends FragmentPagerAdapter {
    Context context;
    Activity myActivity;
    private SharedPreferences share ;
    private SharedPreferences.Editor editor;
    ArrayList<WeedsProduct> list;
    private static Database_Class_Functions database_class_functions ;

    public MyFragmentAdapter(FragmentManager fm, Context con, Activity activity) {
        super(fm);
        this.context = con;
        myActivity = activity;
        list = new ArrayList<>();
        database_class_functions=Database_Class_Functions.GetDatabaseInstance(context);
        share = myActivity.getSharedPreferences("Data",Activity.MODE_PRIVATE);
    }



    @Override
    public Fragment getItem(int position) {

            return ProductFragment.newInstance(position,context,database_class_functions);

    }

    @Override
    public int getCount() {
        share = myActivity.getSharedPreferences("Data",Activity.MODE_PRIVATE);
        return share.getInt("Counter",100);

    }


}
