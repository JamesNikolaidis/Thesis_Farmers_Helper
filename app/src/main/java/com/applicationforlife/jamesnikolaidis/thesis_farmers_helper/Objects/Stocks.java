package com.applicationforlife.jamesnikolaidis.thesis_farmers_helper.Objects;

import java.util.ArrayList;

/**
 * Created by James Nikolaidis on 12/25/2016.
 */

public class Stocks {
    public String Product , ProductManufacter  ,Problem_Solving;
    public ArrayList<String> DistributerEmail ;


    public Stocks(){}
    public Stocks(String ...StockArgs){

        Product = StockArgs[0];
        ProductManufacter = StockArgs[1];


    }


    public String getmProduct() {
        return Product;
    }

    public void setmProduct(String mProduct) {
        this.Product = mProduct;
    }

    public String getmProductManufacter() {
        return ProductManufacter;
    }

    public void setmProductManufacter(String mProductManufacter) {
        this.ProductManufacter = mProductManufacter;
    }

    public ArrayList<String> getmDistributerEmail() {
        return DistributerEmail;
    }


}
