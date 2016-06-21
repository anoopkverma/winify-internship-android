package com.example.winify.cvsi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static Button sLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sLoginButton = (Button) findViewById(R.id.button_login_screen);
    }

    public void onOpenLoginActivityButtonClicked(View view) {
        Intent getLoginIntent = new Intent(this, LoginActivity.class) ;
        final int result = 1;

        getLoginIntent.putExtra("callingActivity", "MainActivity");
        startActivityForResult(getLoginIntent, result);
    }
}
