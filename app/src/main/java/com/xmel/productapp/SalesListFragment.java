package com.xmel.productapp;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by Lesya on 15.09.2015.
 */
public class SalesListFragment extends ListFragment {
    private ArrayList<Sale> mSales;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.sales_list_title);
        mSales = SaleLab.get(getActivity()).getSales();

        ArrayAdapter<Sale> adapter = new ArrayAdapter<Sale>(getActivity(), android.R.layout.simple_list_item_1, mSales);
        setListAdapter(adapter);
    }
}
