package com.xmel.productapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Admin on 07.09.2015.
 */
public class ProductListFragment extends ListFragment {


    private ArrayList<Product> mProducts;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.products_list_title);
        mProducts = ProductLab.get(getActivity()).getProducts();

        ArrayAdapter<Product> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, mProducts);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Intent i = new Intent(getActivity(), ProductActivity.class);
        i.putExtra(ProductActivity.EXTRA_ID, mProducts.get(position).getId());
        startActivity(i);
    }
}
