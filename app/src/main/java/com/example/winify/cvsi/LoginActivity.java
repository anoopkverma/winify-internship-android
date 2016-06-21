package com.example.winify.cvsi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by diana on 6/21/16.
 */
public class LoginActivity extends AppCompatActivity {

    private EditText mEmail;
    private EditText mPassword;
    private Button mLoginButton;
    private TextView mRegisterLink;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Intent activityThatCalled = getIntent();

        intitializeClassComponents();
        initializeToolBar();
    }

    public void intitializeClassComponents() {
        mEmail = (EditText) findViewById(R.id.txtLoginEmail) ;
        mPassword = (EditText) findViewById(R.id.txtLoginPassword);
        mLoginButton = (Button) findViewById(R.id.btnLogin);
        mRegisterLink = (TextView) findViewById(R.id.link_to_register);

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLoginButtonClicked();
            }
        });
        mRegisterLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRegisterLinkClicked();
            }
        });

    }

    public void onLoginButtonClicked() {
        String emailString = mEmail.getText().toString();
        String passString = mPassword.getText().toString();

        if(emailString.equals("admin") && passString.equals("pass")) {
            Toast.makeText(getApplicationContext(), "#totNormal", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Chtota ne tak", Toast.LENGTH_SHORT).show();
        }
    }

    public void onRegisterLinkClicked() {
        Intent getLoginIntent = new Intent(this, RegisterActivity.class) ;
        final int result = 1;

        getLoginIntent.putExtra("callingActivity", "LoginActivity");
        startActivityForResult(getLoginIntent, result);
    }

    public void initializeToolBar() {
        Toolbar childToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(childToolbar);

        // Get a support action bar corresponding to this toolbar
        ActionBar actionBar = getSupportActionBar();

        //Enable Up Button
        if(actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

}
