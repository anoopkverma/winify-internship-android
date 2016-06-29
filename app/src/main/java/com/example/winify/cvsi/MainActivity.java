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


public class MainActivity extends AppCompatActivity {

    private static Button sLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sLoginButton = (Button) findViewById(R.id.button_login_screen);

        initToolBar();
    }


    public void initToolBar() {
        Toolbar topToolBar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(topToolBar);

    }

    public void onOpenLoginActivityButtonClicked(View view) {
        Intent getLoginIntent = new Intent(this, ListItemsActivity.class) ;
        final int result = 1;

        getLoginIntent.putExtra("callingActivity", "MainActivity");
        startActivityForResult(getLoginIntent, result);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu.
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }


}
