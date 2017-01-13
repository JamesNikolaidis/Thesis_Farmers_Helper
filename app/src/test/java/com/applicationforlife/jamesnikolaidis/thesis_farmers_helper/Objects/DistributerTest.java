package com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Objects;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by James Nikolaidis on 1/13/2017.
 */
public class DistributerTest {
    private Distributer mDistributerTestClass ;
    private String[] mDistributerInformation;

    @Test
        public void InitializeDistributer(){
        mDistributerTestClass =new Distributer(null);
    }

    @Test
    public void InitializeDistributerVol_1(){

        mDistributerTestClass =new Distributer();
    }

    @Test
    public void InitializeDistributerVol_2(){
        mDistributerInformation = new String[2];
        mDistributerInformation[0]="TestAddress";
        mDistributerInformation[1]="TestCountry";
        //First Try with 2 argumnets
        mDistributerTestClass =new Distributer(mDistributerInformation);
        mDistributerInformation = new String[5];
        mDistributerInformation[0]="TestAddress";
        mDistributerInformation[1]="TestCountry";
        mDistributerInformation[2]= "TestEmail";
        mDistributerInformation[3]= "TestName";
        mDistributerInformation[4]= "TestPostal";
        //Second Try with 5 argument less than 6
        mDistributerTestClass =new Distributer(mDistributerInformation);
        mDistributerInformation = new String[6];
        mDistributerInformation[0]="TestAddress";
        mDistributerInformation[1]="TestCountry";
        mDistributerInformation[2]= "TestEmail";
        mDistributerInformation[3]= "TestName";
        mDistributerInformation[4]= "TestPostal";
        mDistributerInformation[5]= "TestState";
        //Final correct  Try with 6 argument
        mDistributerTestClass =new Distributer(mDistributerInformation);




    }
    @Test
    public void getAddress() throws Exception {
        mDistributerInformation = new String[6];
        mDistributerInformation[0]="TestAddress";
        mDistributerInformation[1]="TestCountry";
        mDistributerInformation[2]= "TestEmail";
        mDistributerInformation[3]= "TestName";
        mDistributerInformation[4]= "TestPostal";
        mDistributerInformation[5]= "TestState";
        //Final correct  Try with 6 argument
        mDistributerTestClass =new Distributer(mDistributerInformation);
    }

    @Test
    public void getCountry() throws Exception {
        mDistributerInformation = new String[6];
        mDistributerInformation[0]="";
        mDistributerInformation[1]="TestCountry";
        mDistributerInformation[2]= "";
        mDistributerInformation[3]= "";
        mDistributerInformation[4]= "";
        mDistributerInformation[5]= "";
        //Final correct  Try with 6 argument
        mDistributerTestClass =new Distributer(mDistributerInformation);
        assertEquals("The Information is not Equal.",mDistributerInformation[1],mDistributerTestClass.getCountry());
    }

    @Test
    public void getEmail() throws Exception {
        mDistributerInformation = new String[6];
        mDistributerInformation[0]="TestAddress";
        mDistributerInformation[1]="TestCountry";
        mDistributerInformation[2]= "TestEmail";
        mDistributerInformation[3]= "TestName";
        mDistributerInformation[4]= "TestPostal";
        mDistributerInformation[5]= "TestState";
        //Final correct  Try with 6 argument
        mDistributerTestClass =new Distributer(mDistributerInformation);
        assertEquals("The Information is not Equal.",mDistributerInformation[2],mDistributerTestClass.getEmail());
    }

    @Test
    public void getPostal() throws Exception {
        mDistributerInformation = new String[6];
        mDistributerInformation[0]="TestAddress";
        mDistributerInformation[1]="TestCountry";
        mDistributerInformation[2]= "TestEmail";
        mDistributerInformation[3]= "TestName";
        mDistributerInformation[4]= "TestPostal";
        mDistributerInformation[5]= "TestState";
        //Final correct  Try with 6 argument
        mDistributerTestClass =new Distributer(mDistributerInformation);
        assertEquals("The Information is not Equal.",mDistributerInformation[4],mDistributerTestClass.getPostal());
    }

    @Test
    public void getState() throws Exception {
        mDistributerInformation = new String[6];
        mDistributerInformation[0]="TestAddress";
        mDistributerInformation[1]="TestCountry";
        mDistributerInformation[2]= "TestEmail";
        mDistributerInformation[3]= "TestName";
        mDistributerInformation[4]= "TestPostal";
        mDistributerInformation[5]= "TestState";
        //Final correct  Try with 6 argument
        mDistributerTestClass =new Distributer(mDistributerInformation);
        assertEquals("The Information is not Equal.",mDistributerInformation[5],mDistributerTestClass.getState());
    }

    @Test
    public void getName() throws Exception {
        mDistributerInformation = new String[6];
        mDistributerInformation[0]="TestAddress";
        mDistributerInformation[1]="TestCountry";
        mDistributerInformation[2]= "TestEmail";
        mDistributerInformation[3]= "TestName";
        mDistributerInformation[4]= "TestPostal";
        mDistributerInformation[5]= "TestState";
        //Final correct  Try with 6 argument
        mDistributerTestClass =new Distributer(mDistributerInformation);
        assertEquals("The Information is not Equal.",mDistributerInformation[3],mDistributerTestClass.getName());
    }

}