package com.xmel.productapp;

import android.content.Context;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Lesya on 15.09.2015.
 */
public class SaleLab {

    private Context mAppContext;
    private static SaleLab mSaleLab;
    private ArrayList<Sale> mSales;

    private SaleLab(Context context) {
        mAppContext = context;
        mSales = new ArrayList<Sale>();

        ArrayList<Product> list = ProductLab.get(mAppContext).getProducts();
        for (int i = 0; i <100; i++) {
            Sale sale = new Sale(new Date());
            sale.addProduct(list.get(0));
            sale.addProduct(list.get(1));
            sale.addProduct(list.get(2));
            mSales.add(i, sale);
        }
    }

    public static SaleLab get(Context context) {
        if (mSaleLab == null) {
            mSaleLab = new SaleLab(context.getApplicationContext());
        }
        return mSaleLab;
    }

    public ArrayList<Sale> getSales() {
        return mSales;
    }

    public Sale getSale(UUID id) {
        for (Sale p : mSales) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }
}
