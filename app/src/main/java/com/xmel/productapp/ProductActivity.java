package com.xmel.productapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;

public class ProductActivity extends SingleFragmentActivity {

    private int id;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        id = getIntent().getIntExtra(ProductFragment.EXTRA_ID, 0);
        super.onCreate(savedInstanceState);


    }

    @Override
    public Fragment createFragment() {

        return ProductFragment.getInstance(id);
    }
}
