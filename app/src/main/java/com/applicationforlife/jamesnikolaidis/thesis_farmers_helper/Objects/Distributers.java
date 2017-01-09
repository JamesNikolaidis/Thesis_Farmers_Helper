package com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Objects;

/**
 * Created by James Nikolaidis on 12/18/2016.
 */

public class Distributers {

    public String Product , ProductManufacter ,DistributerEmail;
//
    public Distributers(){}
    public Distributers(String ...arg){
        this.Product=arg[1];
        this.ProductManufacter = arg[2];
        this.DistributerEmail = arg[0];
    }


    public String getProduct() {
        return Product;
    }

    public String getProductManufacter() {
        return ProductManufacter;
    }

    public String getDistributerEmail() {
        return DistributerEmail;
    }
}
