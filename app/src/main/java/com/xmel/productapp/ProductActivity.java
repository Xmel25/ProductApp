package com.xmel.productapp;

import android.support.v4.app.Fragment;

public class ProductActivity extends SingleFragmentActivity {

    public static final String EXTRA_ID = "id";

    @Override
    public Fragment createFragment() {
        return new ProductFragment();
    }
}
