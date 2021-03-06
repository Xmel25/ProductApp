package com.xmel.productapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.UUID;

/**
 * Created by Admin on 07.09.2015.
 */
public class ProductFragment extends Fragment {


    private Product mProduct;

    public static final String EXTRA_ID = "id";

    private int id;
    private EditText mName;
    private EditText mPrice;
    private EditText mCode;

    public static ProductFragment getInstance(int id) {
        ProductFragment productFragment = new ProductFragment();
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_ID, id);
        productFragment.setArguments(args);

        return productFragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mProduct = new Product();
        id = getArguments().getInt(EXTRA_ID);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_product, container, false);

        mName = (EditText) v.findViewById(R.id.product_name);
        mPrice = (EditText) v.findViewById(R.id.product_price);
        mCode = (EditText) v.findViewById(R.id.product_code);
        mName.setText(ProductLab.get(getActivity()).getProduct(id).getName());
        mPrice.setText(ProductLab.get(getActivity()).getProduct(id).getPrice()+"");
        mCode.setText(ProductLab.get(getActivity()).getProduct(id).getCode()+"");


        mName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mProduct.setName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        mPrice.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mProduct.setPrice(Long.parseLong(s.toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        return v;
    }
}
