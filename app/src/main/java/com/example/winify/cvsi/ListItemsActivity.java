package com.example.winify.cvsi;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ListItemsActivity extends AppCompatActivity {
    // Added by Cristi
    TabLayout tabLayout;
    ViewPager viewPager;
    PagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_items);
        init();
    }

    public void init() {
        tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        viewPagerAdapter = new PagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragments(new BuyFragment(),"Buy");
        viewPagerAdapter.addFragments(new SellFragment(),"Sell");
        viewPagerAdapter.addFragments(new XchangeFragment(),"Exchange");
        viewPagerAdapter.addFragments(new LoanFragment(),"Borrow");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
