package com.xmel.productapp;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

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

    public void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppDefault);
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);

        mText = (TextView) findViewById(R.id.text);
        initToolBar();
        initNavigationView();

        initTab();


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
    }

    private void initNavigationView() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.navigation);
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                mDrawerLayout.closeDrawer(Gravity.LEFT);
                //openFragment();

                return true;
            }
        });




    }

    private void openFragment() {
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);
        if (fragment == null) {
            fragment = new ProductListFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }
    }
}
