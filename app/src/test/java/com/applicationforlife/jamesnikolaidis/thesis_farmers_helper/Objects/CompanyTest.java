package com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Objects;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
/**
 * Created by James Nikolaidis on 1/13/2017.
 */

public class CompanyTest {
    private  Company mCompanyTestClass;
    private static  String[] mCompaniesDetails ;

    @Test
        public void InitializeCompanyVol_1(){
        mCompanyTestClass = new Company(null);

    }

    @Test
        public void InitializeCompanyWithSmallLenght(){
        mCompaniesDetails =new String[3];
        mCompaniesDetails[0] = "TestUrl";
        mCompaniesDetails[1] = "TestCountry";
        mCompaniesDetails[2] = "TestEmail";
        mCompanyTestClass = new Company(mCompaniesDetails);

    }


    @Test
        public void getCompanyEmailTest(){
        mCompaniesDetails =new String[4];
        mCompaniesDetails[0] = "TestUrl";
        mCompaniesDetails[1] = "TestCountry";
        mCompaniesDetails[2] = "TestEmail";
        mCompaniesDetails[3] = "TestName";
        mCompanyTestClass = new Company(mCompaniesDetails);
        assertEquals("The Information is not Equal.",mCompaniesDetails[2],mCompanyTestClass.getEmail());


    }

    @Test
    public void getCompanyNameTest(){
        mCompaniesDetails =new String[4];
        mCompaniesDetails[0] = "TestUrl";
        mCompaniesDetails[1] = "TestCountry";
        mCompaniesDetails[2] = "TestEmail";
        mCompaniesDetails[3] = "TestName";
        mCompanyTestClass = new Company(mCompaniesDetails);
        assertEquals("The Information is not Equal.",mCompaniesDetails[3],mCompanyTestClass.getName());


    }
    @Test
    public void getCompanyUrlTest(){
        mCompaniesDetails =new String[4];
        mCompaniesDetails[0] = "TestUrl";
        mCompaniesDetails[1] = "TestCountry";
        mCompaniesDetails[2] = "TestEmail";
        mCompaniesDetails[3] = "TestName";
        mCompanyTestClass = new Company(mCompaniesDetails);
        assertEquals("The Information is not Equal.",mCompaniesDetails[0],mCompanyTestClass.getCompanyUrl());
    }

    @Test
    public void getCompanyCountryTest(){
        mCompaniesDetails =new String[4];
        mCompaniesDetails[0] = "TestUrl";
        mCompaniesDetails[1] = "TestCountry";
        mCompaniesDetails[2] = "TestEmail";
        mCompaniesDetails[3] = "TestName";
        mCompanyTestClass = new Company(mCompaniesDetails);
        assertEquals("The Information is not Equal.",mCompaniesDetails[1],mCompanyTestClass.getCountry());
    }




}
