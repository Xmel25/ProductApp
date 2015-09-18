package com.xmel.productapp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.xmel.productapp.ProductListFragment;
import com.xmel.productapp.SalesListFragment;

/**
 * Created by Admin on 14.09.2015.
 */
public class TabsPageFragmentAdapter extends FragmentPagerAdapter {

    private String[] tabs;

    public TabsPageFragmentAdapter(FragmentManager fm) {
        super(fm);
        tabs = new String[] {
                "Товары",
                "Продажи",
                "Приходы"
        };
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new ProductListFragment();
            case 1:
                return new SalesListFragment();
            case 2:
                return new ProductListFragment();

        }

        return null;
    }

    @Override
    public int getCount() {
        return tabs.length;
    }
}
