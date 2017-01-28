package com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Database_Functions;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;

import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Chat_Class.Chat_Class;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Objects.Company;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Objects.Distributer;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Objects.FarmingObjects;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Objects.Stocks;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Objects.WeedsProduct;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Second_Screen;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Second_Screen_For_ShortAction;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

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
    private static FirebaseStorage mStorage;
    private Firebase mProducts , mStocks , mCompany , mDistributer,mChat,mProductsForFarmingShortList;
    private static ArrayList<WeedsProduct> mWeedsProductMap;
    private static Company mCompanyObject;
    private Distributer mDistributerObject;
    public static boolean glag = false;
    private static boolean FirstTime=true;
    private static ArrayList<ArrayList<String>> mDistributerList;
    private static int mycounter = 0;
    private static ArrayList<String> mWeedsMessageList ,mFarmingMessageList,mWeedMessageKeyList,mFarmingMessageKeyList,Messages,MessageKey;
    private static ArrayList<FarmingObjects> mFarmingProductMap;
    private static int MessageMaxCounter1=0;
    private static ArrayList<String> mNewMessages , mNewMesagesKey;
    public static boolean comeanother = false;
    private static String mPdfUrl="";




    /*****************************************************\\
     *
      *         Database_Class Constructor( On Private Mode )
     */
    //******************************************************/
        private  Database_Class_Functions(Context context) {

            Firebase.setAndroidContext(context);
            mRootVar = new Firebase("https://farmers-helper-44f7a.firebaseio.com/");
           // mStorage = FirebaseStorage.getInstance();
            mStocks = new Firebase("https://farmers-helper-44f7a.firebaseio.com/Stocks");
            mProducts=new Firebase("https://farmers-helper-44f7a.firebaseio.com/Products/Weeds");
            mProductsForFarmingShortList=new Firebase("https://farmers-helper-44f7a.firebaseio.com/Products/Farming/");
            mCompany= new Firebase("https://farmers-helper-44f7a.firebaseio.com/Company");
            mChat= new Firebase("https://farmers-helper-44f7a.firebaseio.com/Chat");
            mDistributer= new Firebase("https://farmers-helper-44f7a.firebaseio.com/Distributers");
            mCompanyObject = new Company();
            mDistributerObject = new Distributer();
            mDistributerList = new ArrayList<>();
            MessageMaxCounter1=0;
            mDistributerObject = new Distributer();


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


        public  void GetProduct(String Reason,String isFarming ){
            mWeedsProductMap = new ArrayList<>();
        if(isFarming==null){
            if(glag==false){
          Query getProductByReason = mProducts.orderByChild("Problem_Solving").equalTo(Reason).limitToFirst(100);
            getProductByReason.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                        WeedsProduct robotProdutct = dataSnapshot.getValue(WeedsProduct.class);
                    mWeedsProductMap.add(robotProdutct);

                    mycounter++;
                    if(Second_Screen.FirstTimeLoadFlag==1){
                        Second_Screen.MakeRefreshIfSomethingChanges();
                    }

                }
                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {
                    if(Second_Screen.FirstTimeLoadFlag==1){
                        for(int i=0;  i<=getProductsDataForFarmingShortgCut().size(); i++){

                            if(dataSnapshot.getValue(WeedsProduct.class).getName().equals(getProductsData().get(i).getName())) {
                                getProductsData().remove(i);
                                Second_Screen.MakeRefreshIfSomethingChanges();
                            }
                        }
                    }
                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });

           }
        }else {
            if(glag==false){
                Query getProductByReason = mProductsForFarmingShortList.child(isFarming).orderByChild("Problem_Solving").equalTo(Reason).limitToFirst(100);
                getProductByReason.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                        WeedsProduct robotProdutct = dataSnapshot.getValue(WeedsProduct.class);
                        mWeedsProductMap.add(robotProdutct);
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



        }
            glag = true;

        }





    public  void GetProductForFarmingShortList(final String FarmingOption){
        mFarmingProductMap = new ArrayList<>();


        if(glag==false){
            Query getProductByReason = mProductsForFarmingShortList.child(FarmingOption).limitToFirst(100);
            getProductByReason.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    FarmingObjects robotProdutct = dataSnapshot.getValue(FarmingObjects.class);
                    mFarmingProductMap.add(robotProdutct);
                    FindAndCollectDistributerDetails(robotProdutct.Problem_Solving);
                    mycounter++;
                    if(Second_Screen_For_ShortAction.FirstTimeLoadFlag==1){
                        Second_Screen_For_ShortAction.MakeRefreshIfSomethingChanges();
                    }


                }
                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {
                    if(Second_Screen_For_ShortAction.FirstTimeLoadFlag==1){
                        for(int i=0;  i<=getProductsDataForFarmingShortgCut().size(); i++){

                            if(dataSnapshot.getValue(FarmingObjects.class).getName().equals(getProductsDataForFarmingShortgCut().get(i).getName())) {
                                getProductsDataForFarmingShortgCut().remove(i);
                                Second_Screen_For_ShortAction.MakeRefreshIfSomethingChanges();
                                 }
                            }
                        }

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





public ArrayList<WeedsProduct> getProductsData(){
    return mWeedsProductMap;
}
    public ArrayList<FarmingObjects> getProductsDataForFarmingShortgCut(){
        return mFarmingProductMap;
    }

    public ArrayList<FarmingObjects> getProductsDataForFarming(){
        return mFarmingProductMap;
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

    public  int getMessageMaxCounter1() {
        return MessageMaxCounter1;
    }

    public int MessagesCount(){

            Firebase Root1 = new Firebase("https://farmers-helper-44f7a.firebaseio.com/Chat/Farming_Messages");
            Root1.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                  MessageMaxCounter1++;
                    comeanother = true;
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

                    return MessageMaxCounter1;
        }




        public void InsertMessage(Chat_Class chat_class,String Object){

                if(Object.matches("Weeds")){
                    Firebase mCloneRef = new Firebase("https://farmers-helper-44f7a.firebaseio.com/Chat/Weeds_Messages");
                    mCloneRef.push().setValue(chat_class);

                }else{
                    Firebase mCloneRef = new Firebase("https://farmers-helper-44f7a.firebaseio.com/Chat/Farming_Messages");
                    mCloneRef.push().setValue(chat_class);

                }


        }


    public  ArrayList<String> getMessages() {
        return Messages;
    }

    public  ArrayList<String> getMessageKey() {
        return MessageKey;
    }


    public static boolean isFirstTime() {
        return FirstTime;
    }

    public static void setFirstTime(boolean firstTime) {
        FirstTime = firstTime;
    }





    public void ActivateChat()
    {

        if(comeanother==true){

        Messages = new ArrayList<>();
        MessageKey = new ArrayList<>();
        Firebase Root = new Firebase("https://farmers-helper-44f7a.firebaseio.com/Chat/Weeds_Messages");
        Root.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Chat_Class chat_class = dataSnapshot.getValue(Chat_Class.class);
                int onecounter = 0;
                do {
                    Messages.add(chat_class.mMessageArrayList.get(onecounter));
                    onecounter++;
                    MessageKey.add(chat_class.mMessageArrayList.get(onecounter));
                    onecounter++;

                } while (onecounter < chat_class.mMessageArrayList.size());


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
        Firebase Root1 = new Firebase("https://farmers-helper-44f7a.firebaseio.com/Chat/Farming_Messages");
        Root1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Chat_Class chat_class = dataSnapshot.getValue(Chat_Class.class);
                int onecounter = 0;

                do {
                    Messages.add(chat_class.mMessageArrayList.get(0));
                    onecounter++;
                    MessageKey.add(chat_class.mMessageArrayList.get(1));
                    onecounter++;
                } while (onecounter < chat_class.mMessageArrayList.size());

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




    }



        public void FarmerSearchEngine(String Subject){

                if(Subject.matches("Weeds")){
                    Firebase Root= new Firebase("https://farmers-helper-44f7a.firebaseio.com/Chat/Weeds_Messages");
                    mWeedMessageKeyList  = new ArrayList<String>();
                    mWeedsMessageList = new ArrayList<String>();
                    Root.addChildEventListener(new ChildEventListener() {
                        @Override
                        public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                            Chat_Class chat_class = dataSnapshot.getValue(Chat_Class.class);
                           int i =0;
                            do{
                                mWeedsMessageList.add(chat_class.mMessageArrayList.get(i));
                                i++;
                                mWeedMessageKeyList.add(chat_class.mMessageArrayList.get(i));
                                i++;


                            }while(i<chat_class.mMessageArrayList.size());

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



                }else {
                    Firebase mSearchEngine = new Firebase("https://farmers-helper-44f7a.firebaseio.com/Chat/Farming_Messages");
                    mFarmingMessageKeyList = new ArrayList<String>();
                    mFarmingMessageList = new ArrayList<String>();
                    mSearchEngine.addChildEventListener(new ChildEventListener() {
                        @Override
                        public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                            Chat_Class mChatClassObject= dataSnapshot.getValue(Chat_Class.class);
                            int i =0;

                            do{
                                mFarmingMessageList.add(mChatClassObject.mMessageArrayList.get(i).toString());
                                i++;
                                mFarmingMessageKeyList.add(mChatClassObject.mMessageArrayList.get(i).toString());
                                i++;


                            }while(i<mChatClassObject.mMessageArrayList.size());



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
        }






    public ArrayList<String> ReturnMessageArray(String Subject) {
        if (Subject.matches("Weeds")) {
            return mWeedsMessageList;
        } else {


            return mFarmingMessageList;
        }
    }




    public ArrayList<String> ReturnMessageKeyArray(String Subject) {
        if (Subject.matches("Weeds")) {
            return mWeedMessageKeyList;
        } else {
            return mFarmingMessageKeyList;
        }
    }




    public void GetDistributerData(String DistributerEmail){
        mDistributerObject = new Distributer();
        Query mFindDistributerDetails = mDistributer.limitToFirst(1).orderByChild("Email").equalTo(DistributerEmail);
            mFindDistributerDetails.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                    mDistributerObject = dataSnapshot.getValue(Distributer.class);

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


    public Distributer ReturnDistributerProfil(){
        return mDistributerObject;
    }




    public void FindandCollectProductPdfFileLink(String ProductName, String Manufacter){
         FirebaseStorage mStor = FirebaseStorage.getInstance();
         StorageReference mFindPdfStorageReference =  mStor.getReferenceFromUrl("gs://farmers-helper-44f7a.appspot.com/"+Manufacter+"/"+ProductName+"/"+ProductName+".pdf");
            mFindPdfStorageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
             @Override
             public void onSuccess(Uri uri) {
                 mPdfUrl = String.valueOf(uri);}
         }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    mPdfUrl="";
                }
            });





    }


    public  String GetProductUrl(){
        return mPdfUrl;

    }



}
