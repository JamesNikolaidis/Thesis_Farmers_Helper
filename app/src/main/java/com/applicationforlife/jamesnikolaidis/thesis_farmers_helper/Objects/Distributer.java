package com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Objects;

/**
 * Created by James Nikolaidis on 12/18/2016.
 */

public class Distributer {

    public String Address,Country,Email,Name,Postal,State;
//
    public Distributer(){}


    public Distributer(String ...args)throws NullPointerException{


        if (args != null && args.length == 6) {
            this.Address = args[0];
            this.Country = args[1];
            this.Email = args[2];
            this.Name = args[3];
            this.Postal = args[4];
            this.State = args[5];
        }


    }


    public String getAddress() {
        return Address;
    }

    public String getCountry() {
        return Country;
    }

    public String getEmail() {
        return Email;
    }

    public String getPostal() {
        return Postal;
    }

    public String getState() {
        return State;
    }

    public String getName() {
        return Name;
    }
}
