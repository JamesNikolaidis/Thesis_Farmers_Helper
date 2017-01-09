package com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Objects;

/**
 * Created by James Nikolaidis on 12/18/2016.
 */

public class Company {
        public String CompanyUrl , Country , Email , Name ;
//
        public Company(){}

            public Company(String ...args){
                this.CompanyUrl = args[0];
                this.Country = args[1];
                this.Email = args[2];
                this.Name = args[3];


            }


    public String getCompanyUrl() {
        return CompanyUrl;
    }

    public String getCountry() {
        return Country;
    }

    public String getEmail() {
        return Email;
    }

    public String getName() {
        return Name;
    }
}
