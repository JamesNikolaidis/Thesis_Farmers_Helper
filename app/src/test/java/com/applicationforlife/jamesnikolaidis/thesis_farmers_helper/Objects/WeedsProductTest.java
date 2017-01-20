package com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Objects;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by James Nikolaidis on 1/13/2017.
 */
public class WeedsProductTest {

    private static WeedsProduct mTestingProductObject;
    private static String[] mTestingInformation;

    @Test
        public void InitializeProducts(){
        mTestingProductObject = new WeedsProduct();
    }

    @Test
    public void InitializeProductsVol_1(){
        //Check the Reaction of the method with less data that wanted
        mTestingInformation = new String[3];
        mTestingInformation[0] = "TestingActive";
        mTestingInformation[1] = "TestingManufacter";
        mTestingInformation[2] = "TestingName";
        mTestingProductObject = new WeedsProduct(mTestingInformation);

    }

    @Test
        public void InitializeProductsVol_2(){
        //Check the Reaction of the method with more data that wanted
        mTestingInformation = new String[7];
        mTestingInformation[0] = "TestingActive";
        mTestingInformation[1] = "TestingManufacter";
        mTestingInformation[2] = "TestingName";
        mTestingInformation[3] = "TestingPrice";
        mTestingInformation[4] = "TestingDrug";
        mTestingInformation[5] = "TestingProblemSolving";
        mTestingInformation[6] = "OneMoreVar";
        mTestingProductObject = new WeedsProduct(mTestingInformation);

    }



    @Test
    public void getActiveSubstance() throws Exception {
        setActiveSubstance();
        assertEquals("The Information is not Equal.", "TestingActiveSubstance",mTestingProductObject.getActiveSubstance());
    }

    @Test
    public void getManufacter() throws Exception {
            setManufacter();
            assertEquals("The Information is not Equal.", "TestingManufacter",mTestingProductObject.getManufacter());
    }

    @Test
    public void getName() throws Exception {
             setName();
             assertEquals("The Information is not Equal.", "TestingName",mTestingProductObject.getName());
    }

    @Test
    public void getPrice() throws Exception {
            setPrice();
            assertEquals("The Information is not Equal.", mTestingInformation[3],mTestingProductObject.getPrice());
    }

    @Test
    public void getDrugFor() throws Exception {
        setDrugFor();
        assertEquals("The Information is not Equal.","TestingDrugFor",mTestingProductObject.getDrugFor());
    }

    @Test
    public void getProblem_Solving() throws Exception {
        setProblem_Solving();
        assertEquals("The Information is not Equal.","TestingProblemSolving",mTestingProductObject.getProblem_Solving());
    }



    @Test
    public void setActiveSubstance() throws Exception {
            mTestingProductObject = new WeedsProduct();
            mTestingProductObject.setActiveSubstance("TestingActiveSubstance");
            assertEquals("The information is not equal","TestingActiveSubstance",mTestingProductObject.getActiveSubstance());
    }

    @Test
    public void setManufacter() throws Exception {
        mTestingProductObject = new WeedsProduct();
        mTestingProductObject.setManufacter("TestingManufacter");
        assertEquals("The information is not equal","TestingManufacter",mTestingProductObject.getManufacter());
    }

    @Test
    public void setName() throws Exception {
        mTestingProductObject = new WeedsProduct();
        mTestingProductObject.setName("TestingName");
        assertEquals("The information is not equal","TestingName",mTestingProductObject.getName());
    }

    @Test
    public void setPrice() throws Exception {
        mTestingProductObject.setPrice(mTestingInformation[3]);
        assertEquals("The information is not equal",mTestingInformation[3],mTestingProductObject.getPrice());
    }

    @Test
    public void setDrugFor() throws Exception {
        mTestingProductObject = new WeedsProduct();
        mTestingProductObject.setDrugFor("TestingDrugFor");
        assertEquals("The information is not equal","TestingDrugFor",mTestingProductObject.getDrugFor());
    }


    @Test
    public void setProblem_Solving() throws Exception {
        mTestingProductObject = new WeedsProduct();
        mTestingProductObject.setProblem_Solving("TestingProblemSolving");
        assertEquals("The information is not equal","TestingProblemSolving",mTestingProductObject.getProblem_Solving());
    }

}