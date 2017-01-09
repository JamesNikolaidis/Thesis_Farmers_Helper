package com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Database_Functions.Database_Class_Functions;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Objects.Products;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.R;

import java.util.ArrayList;

import static android.os.Build.ID;

/**
 * Created by James Nikolaidis on 12/18/2016.
 */
//
public class ProductFragment extends Fragment {
    private static Products mProduct;
    private  int position;
    private TextView mProductName , mProductPrice , mProductManufacter ;
    private Spinner mActiveSubanseSpinner , mDrugForSpainner ,mDistributerSpinner;
    private static String DrugFor1 ;
    private static Database_Class_Functions database_class_functions;
    private static Context con;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mProduct = new Products();


    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        final View view = inflater.inflate(R.layout.products_layout,container,false);

        mProductName = (TextView)view.findViewById(R.id.productName);
        mProductPrice=(TextView)view.findViewById(R.id.productPrice);
        mProductManufacter = (TextView)view.findViewById(R.id.productManufacter);
        mActiveSubanseSpinner = (Spinner)view.findViewById(R.id.ActiveSubstance);
        mDrugForSpainner = (Spinner)view.findViewById(R.id.DrugFor);
        mDistributerSpinner = (Spinner)view.findViewById(R.id.Distributer);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ArrayList<Products> product = database_class_functions.getProductsData();
                mProduct = product.get((int)getArguments().getSerializable(ID));
                mProductName.setText(mProduct.getName());
                mProductPrice.setText(mProduct.getPrice());
                mProductManufacter.setText(mProduct.getManufacter());
                  ArrayList<String> list = new ArrayList<String>();
                 list = database_class_functions.PassDistributersData().get((int)getArguments().getSerializable(ID));

                 ArrayAdapter adapter = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_1,list);
                 mDistributerSpinner.setAdapter(adapter);

                 ArrayAdapter adapter1 = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_1,new String[]{mProduct.getDrugFor()});
                  mDrugForSpainner.setAdapter(adapter1);
                 ArrayAdapter adapter2 = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_1,new String[]{mProduct.getActiveSubstance()});
                 mActiveSubanseSpinner.setAdapter(adapter2);

               // database_class_functions.ClearDistArrayList();
            }
        }, 3000);



        return view;
    }



    public static ProductFragment newInstance(int ProductPosition,Context context ,Database_Class_Functions class_functions) {
        Bundle args = new Bundle();
        args.putSerializable(ID, ProductPosition);
        con = context;
        database_class_functions=class_functions;
        ProductFragment fragment = new ProductFragment();
        fragment.setArguments(args);
        return fragment;
    }


}
