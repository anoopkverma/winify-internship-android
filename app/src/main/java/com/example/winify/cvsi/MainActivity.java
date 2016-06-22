package com.example.winify.cvsi;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;


public class MainActivity extends AppCompatActivity {

    private static Button sLoginButton;

    // Added by Cristi
    TabLayout tabLayout;
    ViewPager viewPager;
    PagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sLoginButton = (Button) findViewById(R.id.button_login_screen);
        initToolBar();

    }

    public void init() {
        tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        viewPager = (ViewPager)findViewById(R.id.viewPager);
        viewPagerAdapter = new PagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragments(new BuyFragment(),"Bay");
        viewPagerAdapter.addFragments(new SellFragment(),"Sell");
        viewPagerAdapter.addFragments(new XchangeFragment(),"Exch");
        viewPagerAdapter.addFragments(new LoanFragment(),"Loan");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    public void initToolBar() {
        Toolbar topToolBar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(topToolBar);

    }

    public void onOpenLoginActivityButtonClicked(View view) {
        Intent getLoginIntent = new Intent(this, LoginActivity.class) ;
        final int result = 1;

        getLoginIntent.putExtra("callingActivity", "MainActivity");
        startActivityForResult(getLoginIntent, result);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_favorite:
                return true;

            case R.id.action_settings:
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
