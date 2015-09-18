package com.xmel.productapp;

import java.util.UUID;

/**
 * Created by Admin on 07.09.2015.
 */
public class Product {
    private int mId;
    private static int lastID=0;
    private String mName;
    private float mPrice;
    private long mCode;

    public Product() {
        mId = lastID++;
    }

    public int getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public float getPrice() {
        return mPrice;
    }

    public void setPrice(float price) {
        mPrice = price;
    }

    public long getCode() {
        return mCode;
    }

    public void setCode(long code) {
        mCode = code;
    }

    @Override
    public String toString() {
        return getName();
    }
}
