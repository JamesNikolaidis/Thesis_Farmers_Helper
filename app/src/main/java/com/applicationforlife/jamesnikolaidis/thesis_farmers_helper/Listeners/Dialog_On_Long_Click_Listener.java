package com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Listeners;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Database_Functions.Database_Class_Functions;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Dialogs.View_Distributer_Details_Dialog;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Progress_Bar_Class.SimplyProgressBar;
import com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.R;

/**
 * Created by James Nikolaidis on 1/16/2017.
 */

public class Dialog_On_Long_Click_Listener {
            private SharedPreferences mSharedPreference ;
            private SharedPreferences.Editor mEditor;
            private static int SelectFlag = 0,LongClickFlag=0;
            private SimplyProgressBar simplyProgressBar;
            private static ProgressDialog mWaitForData;


        public Dialog_On_Long_Click_Listener(){

        }


        public void Set_Dialog_On_Long_Click_Listener(final Activity activity , final  Context context , final ListView mListView , final String[] array){
                mSharedPreference= activity.getSharedPreferences("Data", Activity.MODE_PRIVATE);
                mEditor= mSharedPreference.edit();




            mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                    String[] User_Choose = array;
                    mListView.setEnabled(false);
                    LongClickFlag=1;
                    final AlertDialog.Builder builder1 = new AlertDialog.Builder(new ContextThemeWrapper(activity, R.style.AlertDialogCustom));
                    final AlertDialog dialog1 = builder1.create();
                    dialog1.getWindow().getAttributes().windowAnimations = R.style.InformationDialog;
                    dialog1.show();
                    dialog1.setCancelable(false);
                    dialog1.setContentView(R.layout.problem_information);
                    Button CancelButton = (Button)dialog1.findViewById(R.id.cancel);
                    TextView infromation_text_view = (TextView)dialog1.findViewById(R.id.information_text_view);
                    ImageView info_image = (ImageView)dialog1.findViewById(R.id.information_image);



                    switch(User_Choose[i]){
                        case "Burr" :


                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    mListView.setEnabled(true);
                                    LongClickFlag=0;

                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.Burr));

                            info_image.setImageResource(R.drawable.burr_bug);
                            break;


                        case "Lollium":



                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    LongClickFlag=0;
                                    mListView.setEnabled(true);
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.Lollium));
                            info_image.setImageResource(R.drawable.lolium);
                            break;

                        case "Sorghum halepense":


                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    LongClickFlag=0;
                                    mListView.setEnabled(true);
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.sorghum_halepense));
                            info_image.setImageResource(R.drawable.sorghum_halepense);
                            break;

                        case "Convolvulus arvensis":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    LongClickFlag=0;
                                    mListView.setEnabled(true);
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.Convolvulus_arvensis));
                            info_image.setImageResource(R.drawable.convolvulus_arv);
                            break;

                        case "Bromus":

                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    LongClickFlag=0;
                                    mListView.setEnabled(true);
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.Burr));

                            info_image.setImageResource(R.drawable.burr_bug);
                            break;


                        //****************** Here starts the Disease List
                        case "Verticillium dahliae(Cotton)":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    LongClickFlag=0;
                                    mListView.setEnabled(true);
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.Verticillium_dahliae));

                            info_image.setImageResource(R.drawable.vertic);

                            break;


                        case "Verticillium dahliae(Walnuts-Olive)":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    LongClickFlag=0;
                                    mListView.setEnabled(true);
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.Verticillium_dahliae));

                            info_image.setImageResource(R.drawable.vertic);

                            break;








                        case "Alternaria(Herbs)":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    LongClickFlag=0;
                                    mListView.setEnabled(true);
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.Alternaria));

                            info_image.setImageResource(R.drawable.alteraria);
                            break;


                        case "Potatoe-Tomatoe Alternaria":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    LongClickFlag=0;
                                    mListView.setEnabled(true);
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.Alternaria));

                            info_image.setImageResource(R.drawable.alteraria);
                            break;





                        case "Anthracnose of Cucurbits":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    LongClickFlag=0;
                                    mListView.setEnabled(true);
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.anthracnose_of_cucurbits));

                            info_image.setImageResource(R.drawable.anthracnose_of_cucurbits);
                            break;



                        case "Anthracnose citrus":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    LongClickFlag=0;
                                    mListView.setEnabled(true);
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.anthracnose_citrus));

                            info_image.setImageResource(R.drawable.anthracnose_citrus);
                            break;

                        case "Anthracnose of Cottons":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    LongClickFlag=0;
                                    mListView.setEnabled(true);
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.anthracnose_citrus));

                            info_image.setImageResource(R.drawable.anthracnose_of_cottons);
                            break;

                        case "Anthracnose":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    LongClickFlag=0;
                                    mListView.setEnabled(true);
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.anthracnose_citrus));

                            info_image.setImageResource(R.drawable.anthracnose_citrus);
                            break;

                        case "Bacterial necrosis":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    LongClickFlag=0;
                                    mListView.setEnabled(true);
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.bacterial_necrosis));

                            info_image.setImageResource(R.drawable.bacterial_necrosis);
                            break;



                        case "Bacterial rot of maize strain":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    mListView.setEnabled(true);
                                    LongClickFlag=0;
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.maize));

                            info_image.setImageResource(R.drawable.bacterial_rot_of_maize_strain);
                            break;


                        case "Trialeurode":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    LongClickFlag=0;
                                    mListView.setEnabled(true);
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.trialeurode));

                            info_image.setImageResource(R.drawable.trialeurodes_vaporariorum);
                            break;



                        case "Thrips":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    LongClickFlag=0;
                                    mListView.setEnabled(true);
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.thrips));

                            info_image.setImageResource(R.drawable.thrips);
                            break;


                        case "Phyllonorycter":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    LongClickFlag=0;
                                    mListView.setEnabled(true);
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.phyllonorycter));

                            info_image.setImageResource(R.drawable.phyllonorycter_blancardella);
                            break;


                        case "Lygus hesperuss":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    mListView.setEnabled(true);
                                    LongClickFlag=0;
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.lygus_hesperuss));

                            info_image.setImageResource(R.drawable.lygus_hesperus);
                            break;


                        case "Bremia Lactucae":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    LongClickFlag=0;
                                    mListView.setEnabled(true);
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.bremia_lactucae));

                            info_image.setImageResource(R.drawable.bremia_lactucae);
                            break;





                        case "Ramularia cynarae":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    mListView.setEnabled(true);
                                    LongClickFlag=0;
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.ramularia_cynarae));

                            info_image.setImageResource(R.drawable.ramularia_beticola);
                            break;


                        case "Oidium":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    mListView.setEnabled(true);
                                    LongClickFlag=0;
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.oidium));

                            info_image.setImageResource(R.drawable.oidium);
                            break;


                        case "Aphids":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    mListView.setEnabled(true);
                                    LongClickFlag=0;
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.aphids));

                            info_image.setImageResource(R.drawable.aphis);
                            break;

                        case "Pyrameis atalanta":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    LongClickFlag=0;
                                    mListView.setEnabled(true);
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.pyrameis_atalanta));

                            info_image.setImageResource(R.drawable.pyrameis_atalanta);
                            break;

                        case "Cassida":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    LongClickFlag=0;
                                    mListView.setEnabled(true);
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.cassida));

                            info_image.setImageResource(R.drawable.cassida);
                            break;



                        case "Agriotes lineatus":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    mListView.setEnabled(true);
                                    LongClickFlag=0;
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.agriotes_lineatus));

                            info_image.setImageResource(R.drawable.agriotes_lineatus);
                            break;


                        case "Plasmodiophorabrassicae":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    LongClickFlag=0;
                                    mListView.setEnabled(true);
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.plasmodiophorabrassicae));

                            info_image.setImageResource(R.drawable.plasmodiophorabrassicae);
                            break;




                        case "Sclerotinia sclerotiorum":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    LongClickFlag=0;
                                    mListView.setEnabled(true);
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.sclerotinia_sclerotiorum));

                            info_image.setImageResource(R.drawable.sclerotiniasclerotiorum);
                            break;


                        case "Alternaria brassicae":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    LongClickFlag=0;
                                    mListView.setEnabled(true);
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.Alternaria));

                            info_image.setImageResource(R.drawable.alteraria);
                            break;


                        case "Mildew-Pseudoperonospora cubensis":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    mListView.setEnabled(true);
                                    LongClickFlag=0;
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.mildew_pseudoperonospora_cubensis));

                            info_image.setImageResource(R.drawable.pseudoperonospora_cubensis);
                            break;


                        case "Tylenchulus semipenetrans":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    mListView.setEnabled(true);
                                    LongClickFlag=0;
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.root_tylenchulus_semipenetrans));

                            info_image.setImageResource(R.drawable.citrus_root_nematode);
                            break;






                        case "Pythium ultimum":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    mListView.setEnabled(true);
                                    LongClickFlag=0;
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.pythium_ultimum));

                            info_image.setImageResource(R.drawable.pythium_ultimum);
                            break;




                        case "Botrytis cinerea":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    mListView.setEnabled(true);
                                    LongClickFlag=0;
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.botrytis_cinerea));

                            info_image.setImageResource(R.drawable.botrytis_cinerea);
                            break;

                        case "Puccinia porri":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    LongClickFlag=0;
                                    mListView.setEnabled(true);
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.puccinia_porri));

                            info_image.setImageResource(R.drawable.puccinia_porri);
                            break;


                        case "Tetranychus urticae":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    mListView.setEnabled(true);
                                    LongClickFlag=0;
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.tetranychus_urticae));

                            info_image.setImageResource(R.drawable.tetranychus_urticae);
                            break;


                        case "Tuta absoluta":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    LongClickFlag=0;
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.tuta_absoluta));

                            info_image.setImageResource(R.drawable.tuta_absoluta);
                            break;

                        case "Phytophthora":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    mListView.setEnabled(true);
                                    LongClickFlag=0;
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.phytophthora));

                            info_image.setImageResource(R.drawable.phytophthora);
                            break;




                        case "Fusarium":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    mListView.setEnabled(true);
                                    LongClickFlag=0;
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.fusarium));

                            info_image.setImageResource(R.drawable.vascular_wilt_of_lentil);
                            break;

                        case "Ephydra attica":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    mListView.setEnabled(true);
                                    LongClickFlag=0;
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.ephydra_attica));

                            info_image.setImageResource(R.drawable.ephydra_attica);
                            break;


                        case "Sesamia":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    mListView.setEnabled(true);
                                    LongClickFlag=0;
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.sesamia));

                            info_image.setImageResource(R.drawable.sesamia);
                            break;

                        case "Paspalum distichum":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    mListView.setEnabled(true);
                                    LongClickFlag=0;
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.paspalum_distichum));

                            info_image.setImageResource(R.drawable.paspalum_distichum);
                            break;


                        case "Septoria":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    mListView.setEnabled(true);
                                    LongClickFlag=0;
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.septoria));

                            info_image.setImageResource(R.drawable.septoria_pyricola);
                            break;





                        case "Black loose smut":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    LongClickFlag=0;
                                    mListView.setEnabled(true);
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.black_loose_smut));

                            info_image.setImageResource(R.drawable.black_loose_smut);
                            break;

                        case "Helminthosporium solani":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    LongClickFlag=0;
                                    mListView.setEnabled(true);
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.helminthosporium_solani));

                            info_image.setImageResource(R.drawable.helminthosporium);
                            break;


                        case "Lygus pabulinus":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    LongClickFlag=0;
                                    mListView.setEnabled(true);
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.lygus_pabulinus));

                            info_image.setImageResource(R.drawable.lygus_pabulinus);
                            break;



                        case "Covered smut":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    LongClickFlag=0;
                                    mListView.setEnabled(true);
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.covered_smut));

                            info_image.setImageResource(R.drawable.covered_smut);
                            break;

                        case "Agrotis spp":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    mListView.setEnabled(true);
                                    LongClickFlag=0;
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.agrotis_spp));

                            info_image.setImageResource(R.drawable.agrotis_spp);
                            break;


                        case "Apple mosaic virus":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    mListView.setEnabled(true);
                                    LongClickFlag=0;
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.apple_mosaic_virus));

                            info_image.setImageResource(R.drawable.apple_mosaic_virus);
                            break;



                        case "Apple Fusicladium":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    LongClickFlag=0;
                                    mListView.setEnabled(true);
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.apple_fusicladium));

                            info_image.setImageResource(R.drawable.fusicladium);
                            break;


                        case "Cydia pomonella":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    mListView.setEnabled(true);
                                    LongClickFlag=0;
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.cydia_pomonella));

                            info_image.setImageResource(R.drawable.cydia_pomonella);
                            break;


                        case "Adoxophyes orana":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    mListView.setEnabled(true);
                                    LongClickFlag=0;
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.adoxophyes_orana));

                            info_image.setImageResource(R.drawable.adoxophyes_orana);
                            break;

                        case "Panonychus ulmi":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    mListView.setEnabled(true);
                                    LongClickFlag=0;
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.panonychus_ulmi));

                            info_image.setImageResource(R.drawable.panonychus_ulmi);
                            break;



                        case "Cossus Linnaeus":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    LongClickFlag=0;
                                    mListView.setEnabled(true);
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.cossus_linnaeus));

                            info_image.setImageResource(R.drawable.cossus_linnaeus);
                            break;







                        case "Powdery mildew":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    LongClickFlag=0;
                                    mListView.setEnabled(true);
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.powdery_mildew));

                            info_image.setImageResource(R.drawable.powdery_mildew);
                            break;




                        case "Chaetosiphon fragaefolii Aphid":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    LongClickFlag=0;
                                    mListView.setEnabled(true);
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.chaetosiphon_fragaefolii_aphid));

                            info_image.setImageResource(R.drawable.fragaefolii_aphid);
                            break;


                        case "Thrips tabaci":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    mListView.setEnabled(true);
                                    LongClickFlag=0;
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.thrips));

                            info_image.setImageResource(R.drawable.thrips);
                            break;

                        case "Fusicladium pirinum":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    mListView.setEnabled(true);
                                    LongClickFlag=0;
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.apple_fusicladium));

                            info_image.setImageResource(R.drawable.fusicladium);
                            break;



                        case "Oidium furinosum":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    LongClickFlag=0;
                                    mListView.setEnabled(true);
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.oidium));

                            info_image.setImageResource(R.drawable.oidium);
                            break;

                        case "Brown rot":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    mListView.setEnabled(true);
                                    LongClickFlag=0;
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.brown_rot));

                            info_image.setImageResource(R.drawable.brown_rot);
                            break;


                        case "Erwinia amylovora":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    mListView.setEnabled(true);
                                    LongClickFlag=0;
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.erwinia_amylovora));

                            info_image.setImageResource(R.drawable.erwinia_amylovora);
                            break;


                        case "Cacopsylla pyri":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    mListView.setEnabled(true);
                                    LongClickFlag=0;
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.cacopsylla_pyri));

                            info_image.setImageResource(R.drawable.cacopsylla_pyri);
                            break;


                        case "Taphrina deformans":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    mListView.setEnabled(true);
                                    LongClickFlag=0;
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.taphrina_deformans));

                            info_image.setImageResource(R.drawable.taphrina_deformans);
                            break;


                        case "Coryneum":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    LongClickFlag=0;
                                    mListView.setEnabled(true);
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.coryneum));

                            info_image.setImageResource(R.drawable.coryneum);
                            break;


                        case "Puccinia pruni-spinosae":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    mListView.setEnabled(true);
                                    LongClickFlag=0;
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.puccinia_porri));

                            info_image.setImageResource(R.drawable.puccinia_pruni_spinosae);
                            break;




                        case "Kylindrosporiosi":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    LongClickFlag=0;
                                    mListView.setEnabled(true);

                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.Kylindrosporiosi));

                            info_image.setImageResource(R.drawable.kylindrosporiosi);
                            break;


                        case "Fusicladium":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    LongClickFlag=0;
                                    mListView.setEnabled(true);
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.apple_fusicladium));

                            info_image.setImageResource(R.drawable.fusicladium);
                            break;


                        case "Alternaria cucumerina":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    LongClickFlag=0;
                                    mListView.setEnabled(true);
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.Alternaria));

                            info_image.setImageResource(R.drawable.alteraria);
                            break;


                        case "Cladosporium cucumarinum":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    mListView.setEnabled(true);
                                    LongClickFlag=0;
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.Alternaria));

                            info_image.setImageResource(R.drawable.alteraria);
                            break;

                        case "Rhizoctonia":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    LongClickFlag=0;
                                    mListView.setEnabled(true);
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.Rhizoctonia));

                            info_image.setImageResource(R.drawable.rhizoctonia);
                            break;


                        case "Sclerotinia":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    LongClickFlag=0;
                                    mListView.setEnabled(true);
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.Sclerotinia));

                            info_image.setImageResource(R.drawable.sclerotiniasclerotiorum);
                            break;



                        case "watermelon mosaic virus":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    mListView.setEnabled(true);
                                    LongClickFlag=0;
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.apple_mosaic_virus));

                            info_image.setImageResource(R.drawable.apple_mosaic_virus);
                            break;



                        case "Meloidogyne incognita":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    LongClickFlag=0;
                                    mListView.setEnabled(true);
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.Meloidogyne_incognita));

                            info_image.setImageResource(R.drawable.melodoigyne);
                            break;



                        case "Acalymma trivittatum":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    mListView.setEnabled(true);
                                    LongClickFlag=0;
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.Acalymma_trivittatum));

                            info_image.setImageResource(R.drawable.acalymma_trivittatum);
                            break;


                        case "Heliothrips":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    mListView.setEnabled(true);
                                    LongClickFlag=0;
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.Heliothrips));

                            info_image.setImageResource(R.drawable.heliothrips);
                            break;



                        case "Tetranychus":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    mListView.setEnabled(true);
                                    LongClickFlag=0;
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.tetranychus_urticae));

                            info_image.setImageResource(R.drawable.tetranychus_urticae);
                            break;


                        case "Medfly":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    mListView.setEnabled(true);
                                    LongClickFlag=0;
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.Medfly));

                            info_image.setImageResource(R.drawable.medfly);
                            break;



                        case "Phyllocnistis citrella":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    mListView.setEnabled(true);
                                    LongClickFlag=0;
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.Phyllocnistis_citrella));

                            info_image.setImageResource(R.drawable.phyllocnistis_citrella);
                            break;



                        case "Planococcus citri":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    mListView.setEnabled(true);
                                    LongClickFlag=0;
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.Planococcus_citri));

                            info_image.setImageResource(R.drawable.planococcus);
                            break;


                        case "Red scale":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    mListView.setEnabled(true);
                                    LongClickFlag=0;
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.Red_scale));

                            info_image.setImageResource(R.drawable.red_scale);
                            break;


                        case "Lepidosaphes beckii":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    mListView.setEnabled(true);
                                    LongClickFlag=0;
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.Lepidosaphes_beckii));

                            info_image.setImageResource(R.drawable.lepidosaphes_beckii);
                            break;

                        case "Icerya":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    mListView.setEnabled(true);
                                    LongClickFlag=0;
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.Icerya));

                            info_image.setImageResource(R.drawable.icerya);
                            break;


                        case "Citrus red mite":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    mListView.setEnabled(true);
                                    LongClickFlag=0;
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.Citrus_red_mite));

                            info_image.setImageResource(R.drawable.citrus_red_mite);
                            break;


                        case "Ceroplastes rusci":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    mListView.setEnabled(true);
                                    LongClickFlag=0;
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.Ceroplastes_rusci));

                            info_image.setImageResource(R.drawable.ceroplastes_rusci);
                            break;


                        case "Αceria fici":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    LongClickFlag=0;
                                    mListView.setEnabled(true);
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.Αceria_fici));

                            info_image.setImageResource(R.drawable.aceria_fici);
                            break;



                        case "Phytophthora parasitica":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    LongClickFlag=0;
                                    mListView.setEnabled(true);
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.phytophthora));

                            info_image.setImageResource(R.drawable.phytophthora);
                            break;


                        case "Lonchaea":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    mListView.setEnabled(true);
                                    LongClickFlag=0;
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.Lonchaea));

                            info_image.setImageResource(R.drawable.lonchaea);
                            break;
                        case "Ascochyta":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    LongClickFlag=0;
                                    mListView.setEnabled(true);
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.Ascochyta));

                            info_image.setImageResource(R.drawable.ascochyta);
                            break;

                        case "Botrytis":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    mListView.setEnabled(true);
                                    LongClickFlag=0;
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.Botrytis));

                            info_image.setImageResource(R.drawable.botrytis_cinerea);
                            break;


                        case "Uromyces phaseoli":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    mListView.setEnabled(true);
                                    LongClickFlag=0;
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.Uromyces_phaseoli));

                            info_image.setImageResource(R.drawable.uromycesphaseoli);
                            break;
                        case "Pythium spp":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    mListView.setEnabled(true);
                                    LongClickFlag=0;
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.pythium_ultimum));

                            info_image.setImageResource(R.drawable.pythium_spp2);
                            break;



                        case "Bruchus":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    LongClickFlag=0;
                                    mListView.setEnabled(true);
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.Bruchus));

                            info_image.setImageResource(R.drawable.bruchus);
                            break;


                        case "Liriomyza":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    LongClickFlag=0;
                                    mListView.setEnabled(true);
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.Liriomyza));

                            info_image.setImageResource(R.drawable.liriomyza_trifolii04);
                            break;

                        case "Sitona macularius":
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    LongClickFlag=0;
                                    mListView.setEnabled(true);
                                }
                            });

                            infromation_text_view.setText(activity.getString(R.string.Sitona_macularius));

                            info_image.setImageResource(R.drawable.sitona_macularius);
                            break;


                        default:
                            CancelButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog1.dismiss();
                                    LongClickFlag=0;
                                    mListView.setEnabled(true);
                                }
                            });
                            break;



                    }


                    return false;
                }



            });


        }//End of Bugs List view Long Click




        public void SetListViewOnClickListener(final Activity activity , final Context context , ListView mListView){
            simplyProgressBar = new SimplyProgressBar();

            mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Log.e("DIST",adapterView.getItemAtPosition(i).toString());
                    Database_Class_Functions database_class_functions = Database_Class_Functions.GetDatabaseInstance(context);
                    database_class_functions.GetDistributerData(adapterView.getItemAtPosition(i).toString());
                      mWaitForData = simplyProgressBar.SimplyProgressDialog(mWaitForData,activity,"Please wait , while we fetching distributer data.");
                      Handler mHanger = new Handler();
                    mHanger.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            View_Distributer_Details_Dialog view_distributer_details_dialog = new View_Distributer_Details_Dialog();
                            mWaitForData.cancel();
                            view_distributer_details_dialog.ActivateDistributerDialog(context,activity);
                        }
                    },3000);
                }
            });


        }







}
