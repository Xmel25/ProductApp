package com.xmel.productapp;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Lesya on 15.09.2015.
 */
public class Sale {
    private UUID mId;
    private Date mDate;
    private ArrayList<Product> mProductList;

    public Sale(Date date) {
        mId = UUID.randomUUID();
        mDate = date;
        mProductList = new ArrayList<Product>();
    }

    public UUID getId() {
        return mId;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date mDate) {
        this.mDate = mDate;
    }

    public ArrayList<Product> getProductList() {
        return mProductList;
    }

    public void addProduct(Product product) {
        this.mProductList.add(product);
    }

    @Override
    public String toString() {
        return mDate.toString();
    }
}
