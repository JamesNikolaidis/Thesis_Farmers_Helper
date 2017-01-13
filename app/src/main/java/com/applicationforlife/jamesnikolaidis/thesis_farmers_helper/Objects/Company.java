package com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Objects;

/**
 * Created by James Nikolaidis on 12/18/2016.
 */

public class Company {
        public String CompanyUrl , Country , Email , Name ;


        public Company(){}

            public Company(String ...args)throws NullPointerException{

            try {
                if (args != null && args.length == 4) {
                    this.CompanyUrl = args[0];
                    this.Country = args[1];
                    this.Email = args[2];
                    this.Name = args[3];
                }
                if (args.length < 4) {
                    System.out.printf("Farmers Helper ERROR :You gave less information : %d , Wanted 4", args.length);
                }

            }catch (NullPointerException nullpointer){
                //TODO Call again the Propoer and Restart the Method
                System.out.println("Farmers Helper ERROR :The Company must have Informations like Name etc.");
             }

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
