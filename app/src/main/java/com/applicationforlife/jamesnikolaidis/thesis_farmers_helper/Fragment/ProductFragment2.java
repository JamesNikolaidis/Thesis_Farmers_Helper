package com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Database_Functions.Database_Class_Functions;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Listeners.Dialog_On_Long_Click_Listener;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Objects.FarmingObjects;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.R;

import java.util.ArrayList;

import static android.os.Build.ID;

/**
 * Created by James Nikolaidis on 1/22/2017.
 */

public class ProductFragment2 extends Fragment {
    private static FarmingObjects mProduct;

    private TextView mProductNameTextViewDescription, mProductPriceTextViewDescription, mProductManufterTextViewDescription, mDrugForTextViewDescription,
            DistributerForTextViewDescription, ActiveSubstanceForTextViewDescription,mProductName, mProductPrice, mProductManufacter, mDrugForListView;
    private ListView mActiveSubanseListView, mDistributerListView;
    private static Database_Class_Functions database_class_functions;
    private static Context con;
    private static Dialog_On_Long_Click_Listener listener;
    private SharedPreferences sharedPreferences;
    private static ImageView mPdfImage, mBackButton;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mProduct = new FarmingObjects();


    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.products_layout, container, false);
        final Activity activity = getActivity();

        //Initialize the Share Preference Object
        sharedPreferences = activity.getSharedPreferences("Data", Context.MODE_PRIVATE);

        //Initialize the Layouts components
        mProductName = (TextView) view.findViewById(R.id.productName);
        mProductPrice = (TextView) view.findViewById(R.id.productPrice);
        mProductManufacter = (TextView) view.findViewById(R.id.productManufacter);
        mDrugForListView = (TextView) view.findViewById(R.id.DrugFor);
        mProductNameTextViewDescription = (TextView) view.findViewById(R.id.productNameText);
        mProductPriceTextViewDescription = (TextView) view.findViewById(R.id.productPriceText);
        mProductManufterTextViewDescription = (TextView) view.findViewById(R.id.productManufacterText);
        mDrugForTextViewDescription = (TextView) view.findViewById(R.id.DrugForTextViewDes);
        DistributerForTextViewDescription = (TextView) view.findViewById(R.id.DistributerTextViewDes);
        ActiveSubstanceForTextViewDescription = (TextView) view.findViewById(R.id.ActiveSubstanceTextViewDes);
        mActiveSubanseListView = (ListView) view.findViewById(R.id.ActiveSubstance);
        mDistributerListView = (ListView) view.findViewById(R.id.Distributer);
        mPdfImage = (ImageView) view.findViewById(R.id.PdfProduct);
        mBackButton = (ImageView) view.findViewById(R.id.BackButtonOnProducts);


        // Check the input number to hide the back button on Layout
        if ((int) getArguments().getSerializable(ID) == 0) {
            mBackButton.setVisibility(View.INVISIBLE);
        }



        listener = new Dialog_On_Long_Click_Listener();
        final Handler handler = new Handler();
        //Display Products Data on Layout Components
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                //Get's the product object from database
                ArrayList<FarmingObjects> product = database_class_functions.getProductsDataForFarmingShortgCut();

                //Check the number of the product
                mProduct = product.get((int) getArguments().getSerializable(ID));


                //If Language is on Greek , make some language changes on Layout
                if (sharedPreferences.getInt("Language", 0) == 0) {
                    mProductNameTextViewDescription.setText(activity.getResources().getString(R.string.ProductNameTextViewGr));
                    mProductPriceTextViewDescription.setText(activity.getResources().getString(R.string.ProductPriceTextViewGr));
                    mProductManufterTextViewDescription.setText(activity.getResources().getString(R.string.ProductManufacterTextViewGr));
                    DistributerForTextViewDescription.setText(activity.getResources().getString(R.string.DistributerListViewGr));
                    mDrugForTextViewDescription.setText(activity.getResources().getString(R.string.DrugForTextViewGr));
                    ActiveSubstanceForTextViewDescription.setText(activity.getResources().getString(R.string.ActiveSubstanceListViewGr));


                } else {
                    //If Language is on English , make some language changes on Layout
                    mProductNameTextViewDescription.setText(activity.getResources().getString(R.string.ProductNameTextViewEng));
                    mProductPriceTextViewDescription.setText(activity.getResources().getString(R.string.ProductPriceTextViewEng));
                    mProductManufterTextViewDescription.setText(activity.getResources().getString(R.string.ProductManufacterTextViewEng));
                    DistributerForTextViewDescription.setText(activity.getResources().getString(R.string.DistributerListViewEng));
                    mDrugForTextViewDescription.setText(activity.getResources().getString(R.string.DrugForTextViewEng));
                    ActiveSubstanceForTextViewDescription.setText(activity.getResources().getString(R.string.ActiveSubstanceListViewEng));


                }


                //Gets the pdf file url from the Firebase Storage Platform
                database_class_functions.FindandCollectProductPdfFileLink(mProduct.getName(), mProduct.getManufacter());


                 /*------------------- Set products data on Layouts Components , Starts Here ----------------*/
                mProductName.setText(mProduct.getName());
                mProductPrice.setText(mProduct.getPrice());
                mProductManufacter.setText(mProduct.getManufacter());
                ArrayList<String> list = new ArrayList<String>();
                list = database_class_functions.PassDistributersData().get((int) getArguments().getSerializable(ID));

                ArrayAdapter adapter = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_gallery_item, list);
                mDistributerListView.setAdapter(adapter);
                mDistributerListView.setScrollBarSize(20);


                mDrugForListView.setText(mProduct.Problem_Solving);
                ArrayAdapter adapter2 = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_1, new String[]{mProduct.getActiveSubstance()});
                mActiveSubanseListView.setAdapter(adapter2);


                 /*------------------- Set products data on Layouts Components , Ends Here ----------------*/

            }
        }, 3000);
        listener.SetListViewOnClickListener(getActivity(), con, mDistributerListView);


        mPdfImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!database_class_functions.GetProductUrl().equals("")) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(database_class_functions.GetProductUrl()));
                    startActivity(browserIntent);
                } else {
                    if(sharedPreferences.getInt("Language",5)==0){
                        Toast.makeText(getContext(), "Συγνώμη δεν έχουμε το pdf αρχείο αυτού του προιόντος.", Toast.LENGTH_SHORT).show();
                    }else{ Toast.makeText(getContext(), "Sorry we dont have pdf file for this product yes.", Toast.LENGTH_SHORT).show();}
                }

            }
        });


        return view;
    }


    public static ProductFragment2 newInstance(int ProductPosition, Context context, Database_Class_Functions class_functions) {
        Bundle args = new Bundle();
        args.putSerializable(ID, ProductPosition);
        con = context;
        database_class_functions = class_functions;
        ProductFragment2 fragment = new ProductFragment2();
        fragment.setArguments(args);
        return fragment;
    }

}