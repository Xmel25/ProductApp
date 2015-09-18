package com.xmel.productapp;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Admin on 07.09.2015.
 */
public class ProductLab {
    private static ProductLab sProductLab;
    private Context mAppContext;

    private ArrayList<Product> mProducts;

    private ProductLab(Context appContext) {
        mAppContext = appContext;
        mProducts = new ArrayList<Product>();

        for (int i = 0; i <100; i++) {
            Product product = new Product();
            product.setName("Product #" + i);
            product.setPrice((long)i);
            mProducts.add(i, product);
        }
    }

    public static ProductLab get(Context context) {
        if (sProductLab == null) {
            sProductLab = new ProductLab(context.getApplicationContext());
        }
        return sProductLab;
    }

    public ArrayList<Product> getProducts() {
        return mProducts;
    }

    public Product getProduct(int id) {
        for (Product p : mProducts) {
            if (p.getId()== id) {
                return p;
            }
        }
        return null;
    }
}
