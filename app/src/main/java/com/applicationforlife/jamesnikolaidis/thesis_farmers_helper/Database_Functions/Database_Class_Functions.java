package com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Database_Functions;

import android.content.Context;

import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Objects.Company;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Objects.Distributer;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Objects.Products;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Objects.Stocks;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;

/**
 * Created by James Nikolaidis on 11/6/2016.
 */

public class Database_Class_Functions  {


    /*****************************************************\\
              Class varaible decleration
    //******************************************************/
    private static Database_Class_Functions Class_instance;
    private Firebase mRootVar;
    private FirebaseDatabase mDatabase ;
    private FirebaseStorage mStorage;
    private Firebase mProducts , mStocks , mCompany , mDistributer;
    private DatabaseReference mDatabaseReference;
    private static ArrayList<Products> mProductsMap;
    private static String Distributer;
    private static Company mCompanyObject;
    private static Distributer mDistributerObject;
    private static boolean glag = false;
    private static ArrayList<ArrayList<String>> mDistributerList;
    private static int mycounter = 0;



    /*****************************************************\\
     *
      *         Database_Class Constructor( On Private Mode )
     */
    //******************************************************/
        private  Database_Class_Functions(Context context) {

            Firebase.setAndroidContext(context);
            mRootVar = new Firebase("https://farmers-helper-44f7a.firebaseio.com/");
            mStorage = FirebaseStorage.getInstance();
            mStocks = new Firebase("https://farmers-helper-44f7a.firebaseio.com/Stocks");
            mProducts=new Firebase("https://farmers-helper-44f7a.firebaseio.com/Products");
            mCompany= new Firebase("https://farmers-helper-44f7a.firebaseio.com/Company");
            mDistributer= new Firebase("https://farmers-helper-44f7a.firebaseio.com/Distributers");
            mProductsMap =  new ArrayList<>();
            mCompanyObject = new Company();
            mDistributerObject = new Distributer();
            mDistributerList = new ArrayList<>();

        }




    /*********************************************************************\\
     *
     *   Database_Class Constructor( On Private Mode ) Singleton Function
     */
    //***********************************************************************/

    public static  Database_Class_Functions GetDatabaseInstance(Context context ){
              if(Class_instance==null){
                  Class_instance = new Database_Class_Functions(context);
                  return  Class_instance;
              }
          return Class_instance;
    }



    /*********************************************************************\\
     *
     *   Database_Class Constructor( On Private Mode ) Singleton Function
     */
    //***********************************************************************/


        public  void GetProduct(String Reason ){

      if(glag==false){
          Query getProductByReason = mProducts.orderByChild("Problem_Solving").equalTo(Reason).limitToFirst(100);
            getProductByReason.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                        Products robotProdutct = dataSnapshot.getValue(Products.class);
                    mProductsMap.add(robotProdutct);

                    mycounter++;

                }
                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });

      }
            glag = true;

        }

public ArrayList<Products> getProductsData(){
    return mProductsMap;
}


    public Company getCompanyDetails(String CompanyName){
                Query findCompanyDetails  =  mCompany.orderByChild("Name").limitToFirst(1).equalTo(CompanyName);
                    findCompanyDetails.addChildEventListener(new ChildEventListener() {
                        @Override
                        public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                            mCompanyObject = dataSnapshot.getValue(Company.class);
                        }

                        @Override
                        public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                        }

                        @Override
                        public void onChildRemoved(DataSnapshot dataSnapshot) {

                        }

                        @Override
                        public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {

                        }
                    });
                return mCompanyObject;

        }




        public  void FindAndCollectDistributerDetails(final String ProductName){

            Query findDistributerDetails = mStocks.orderByChild("Problem_Solving").equalTo(ProductName);
                    findDistributerDetails.addChildEventListener(new ChildEventListener() {
                        @Override
                        public void onChildAdded(DataSnapshot dataSnapshot, String s) {


                                    mDistributerList.add(dataSnapshot.getValue(Stocks.class).getmDistributerEmail());
                        }

                        @Override
                        public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                        }

                        @Override
                        public void onChildRemoved(DataSnapshot dataSnapshot) {

                        }

                        @Override
                        public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                        }

                        @Override
                        public void onCancelled(FirebaseError firebaseError) {

                        }
                    });


        }




        public ArrayList<ArrayList<String>> PassDistributersData(){
            return mDistributerList;
        }

         public void ClearDistArrayList(){
                 mDistributerList=new ArrayList<>();
            }

}