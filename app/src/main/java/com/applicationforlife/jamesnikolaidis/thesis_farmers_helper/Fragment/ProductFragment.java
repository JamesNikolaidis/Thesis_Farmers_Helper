package com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Fragment;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Database_Functions.Database_Class_Functions;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.General_Functions.General_Class;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Listeners.Dialog_On_Long_Click_Listener;
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
    private TextView mProductName , mProductPrice , mProductManufacter, mDrugForListView ;
    private TextView mProductNameTextViewDescription , mProductPriceTextViewDescription,mProductManufterTextViewDescription,mDrugForTextViewDescription,
    DistributerForTextViewDescription,ActiveSubstanceForTextViewDescription;
    private ListView mActiveSubanseListView,mDistributerListView;
    private static String DrugFor1 ;
    private static Database_Class_Functions database_class_functions;
    private static Context con;
    private static General_Class general_class;
    private static Dialog_On_Long_Click_Listener listener;
    private SharedPreferences sharedPreferences;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mProduct = new Products();


    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        final View view = inflater.inflate(R.layout.products_layout,container,false);
        final Activity activity  = getActivity();
        sharedPreferences = activity.getSharedPreferences("Data",Context.MODE_PRIVATE);

        mProductName = (TextView)view.findViewById(R.id.productName);
        mProductPrice=  (TextView)view.findViewById(R.id.productPrice);
        mProductManufacter = (TextView)view.findViewById(R.id.productManufacter);
        mDrugForListView=  (TextView) view.findViewById(R.id.DrugFor);
        mProductNameTextViewDescription = (TextView)view.findViewById(R.id.productNameText);
        mProductPriceTextViewDescription=  (TextView)view.findViewById(R.id.productPriceText);
        mProductManufterTextViewDescription = (TextView)view.findViewById(R.id.productManufacterText);
        mDrugForTextViewDescription= (TextView) view.findViewById(R.id.DrugForTextViewDes);
        DistributerForTextViewDescription= (TextView) view.findViewById(R.id.DistributerTextViewDes);
        ActiveSubstanceForTextViewDescription= (TextView) view.findViewById(R.id.ActiveSubstanceTextViewDes);

        mActiveSubanseListView = (ListView)view.findViewById(R.id.ActiveSubstance);
        mDistributerListView= (ListView)view.findViewById(R.id.Distributer);


        listener = new Dialog_On_Long_Click_Listener();
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ArrayList<Products> product = database_class_functions.getProductsData();
                mProduct = product.get((int)getArguments().getSerializable(ID));
                if(sharedPreferences.getInt("Language",0)==0){
                    mProductNameTextViewDescription.setText(activity.getResources().getString(R.string.ProductNameTextViewGr));
                    mProductPriceTextViewDescription.setText(activity.getResources().getString(R.string.ProductPriceTextViewGr));
                    mProductManufterTextViewDescription.setText(activity.getResources().getString(R.string.ProductManufacterTextViewGr));
                    DistributerForTextViewDescription.setText(activity.getResources().getString(R.string.DistributerListViewGr));
                    mDrugForTextViewDescription.setText(activity.getResources().getString(R.string.DrugForTextViewGr));
                    ActiveSubstanceForTextViewDescription.setText(activity.getResources().getString(R.string.ActiveSubstanceListViewGr));



                }else{
                    mProductNameTextViewDescription.setText(activity.getResources().getString(R.string.ProductNameTextViewEng));
                    mProductPriceTextViewDescription.setText(activity.getResources().getString(R.string.ProductPriceTextViewEng));
                    mProductManufterTextViewDescription.setText(activity.getResources().getString(R.string.ProductManufacterTextViewEng));
                    DistributerForTextViewDescription.setText(activity.getResources().getString(R.string.DistributerListViewEng));
                    mDrugForTextViewDescription.setText(activity.getResources().getString(R.string.DrugForTextViewEng));
                    ActiveSubstanceForTextViewDescription.setText(activity.getResources().getString(R.string.ActiveSubstanceListViewEng));


                }





                mProductName.setText(mProduct.getName());
                mProductPrice.setText(mProduct.getPrice());
                mProductManufacter.setText(mProduct.getManufacter());
                ArrayList<String> list = new ArrayList<String>();
               list = database_class_functions.PassDistributersData().get((int)getArguments().getSerializable(ID));

                 ArrayAdapter adapter = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_1,list);
                mDistributerListView.setAdapter(adapter);
                mDistributerListView.setScrollBarSize(20);


                  mDrugForListView.setText(mProduct.DrugFor);
                 ArrayAdapter adapter2 = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_1,new String[]{mProduct.getActiveSubstance()});
                 mActiveSubanseListView.setAdapter(adapter2);

               // database_class_functions.ClearDistArrayList();
            }
        }, 3000);
            listener.SetListViewOnClickListener(getActivity(),con,mDistributerListView);

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
