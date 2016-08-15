package com.example.winify.cvsi.activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.winify.cvsi.R;

public class WelcomeActivity extends AppCompatActivity {

    private static Button sloginButton;
    private static Button sItemsListButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        sloginButton = (Button) findViewById(R.id.go_to_login_button);
        sItemsListButton = (Button) findViewById(R.id.go_to_list_view_button);
    }

    public void onSLoginButtonClicked(View view) {
        Intent getLoginIntent = new Intent(this, LoginActivity.class) ;
        final int result = 1;
        getLoginIntent.putExtra("callingActivity", "WelcomeActivity");
        startActivityForResult(getLoginIntent, result);
    }

    public void onSItemsListButtonClicked(View view) {
        Intent getLoginIntent = new Intent(this, ListItemsActivity.class) ;
        final int result = 1;
        getLoginIntent.putExtra("callingActivity", "ListItemsActivity");
        startActivityForResult(getLoginIntent, result);
    }
}
