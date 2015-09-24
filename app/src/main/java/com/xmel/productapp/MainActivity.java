package com.xmel.productapp;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.xmel.productapp.adapter.TabsPageFragmentAdapter;

/**
 * Created by Admin on 08.09.2015.
 */
public class MainActivity extends AppCompatActivity {

    private static final int LAYOUT = R.layout.activity_main;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private TextView mText;
    private PreferenceActivity.Header mHeader;

    private Toolbar mToolbar;
    private ViewPager mViewPager;
    private FloatingActionButton mFloatButton;

    public void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppDefault);
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);

        mText = (TextView) findViewById(R.id.text);
        initToolBar();
        initNavigationView();
        initTab();

        initFloatButton();


    }

    private void initFloatButton() {
        mFloatButton = (FloatingActionButton) findViewById(R.id.float_button);
        mFloatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (mViewPager.getCurrentItem()) {
                    case Constants.TAB_PRODUCTS:
//                        Toast.makeText(MainActivity.this, "Products", Toast.LENGTH_LONG).show();
                        Product product = ProductLab.get(MainActivity.this).add();
                        Intent i = new Intent(MainActivity.this, ProductActivity.class);
                        i.putExtra(ProductFragment.EXTRA_ID, product.getId());
                        startActivity(i);
                        break;
                    case Constants.TAB_SALES:
                        Toast.makeText(MainActivity.this, "Sales", Toast.LENGTH_LONG).show();
                        break;
                    case Constants.TAB_SUPPLY:
                        Toast.makeText(MainActivity.this, "Supply", Toast.LENGTH_LONG).show();
                        break;

                }
            }
        });
    }

    private void initToolBar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle(R.string.app_name);
        mToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mToolbar.inflateMenu(R.menu.menu);
    }

    private void initTab() {
        mViewPager = (ViewPager)findViewById(R.id.viewPager);
        TabsPageFragmentAdapter adapter = new TabsPageFragmentAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapter);
        TabLayout mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                //Toast.makeText(MainActivity.this, "" + tab, Toast.LENGTH_LONG).show();
                mNavigationView.setCheckedItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void initNavigationView() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.view_navigation_open, R.string.view_navigation_close);
        mDrawerLayout.setDrawerListener(toggle);
        toggle.syncState();
        mNavigationView = (NavigationView) findViewById(R.id.navigation);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                mDrawerLayout.closeDrawer(Gravity.LEFT);
                switch (menuItem.getItemId()) {
                    case R.id.action_products:
                        showTab(Constants.TAB_PRODUCTS);
                        break;
                    case R.id.action_sales:
                        showTab(Constants.TAB_SALES);
                        break;
                    case R.id.action_supply:
                        showTab(Constants.TAB_SUPPLY);
                        break;
                }

                return true;
            }
        });

    }


    private void showTab(int tab) {
        mViewPager.setCurrentItem(tab);
    }


//    private void openFragment() {
//        FragmentManager fm = getSupportFragmentManager();
//        Fragment fragment = fm.findFragmentById(R.id.fragment_container);
//        if (fragment == null) {
//            fragment = new ProductListFragment();
//            fm.beginTransaction()
//                    .add(R.id.fragment_container, fragment)
//                    .commit();
//        }
//    }
}
