package com.example.winify.cvsi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
    }

    public void intitializeClassComponents() {
        mEmail = (EditText) findViewById(R.id.txtLoginEmail) ;
        mPassword = (EditText) findViewById(R.id.txtLoginPassword);
        mLoginButton = (Button) findViewById(R.id.btnLogin);

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLoginButtonClicked();
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

}
