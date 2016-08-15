package com.example.winify.cvsi.activities;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.winify.cvsi.R;
import com.example.winify.cvsi.controllers.UserController;
import com.example.winify.cvsi.fragments.ForgotPasswordDialogFragment;
import com.example.winify.cvsi.model.User;

/**
 * Created by diana on 6/21/16.
 */
public class LoginActivity extends AppCompatActivity {

    private static EditText mEmail;
    private static EditText sPassword;
    private static Button sLoginButton;
    private static TextView sRegisterLink;
    private static Button sForgotPassButton;
    private UserController userController;

    static final int FORGOT_PASSWORD_DIALOG = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        intitializeClassComponents();
        showForgotPasswordDialog();
        userController = new UserController();
        userController.login();
    }

    public void intitializeClassComponents() {
        mEmail = (EditText) findViewById(R.id.txtLoginEmail) ;
        sPassword = (EditText) findViewById(R.id.txtLoginPassword);
        sLoginButton = (Button) findViewById(R.id.btnLogin);
        sRegisterLink = (TextView) findViewById(R.id.link_to_register);
        sLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLoginButtonClicked();
            }
        });
        sRegisterLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRegisterLinkClicked();
            }
        });
    }

    public void onForgotPasswordTextViewClicked() {
        Intent getLoginIntent = new Intent(this, RegisterActivity.class) ;
        final int result = 1;

        getLoginIntent.putExtra("callingActivity", "LoginActivity");
        startActivityForResult(getLoginIntent, result);
    }

    public void onLoginButtonClicked() {
        String emailString = mEmail.getText().toString();
        String passString = sPassword.getText().toString();

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

    public void  showForgotPasswordDialog() {
        sForgotPassButton = (Button) findViewById(R.id.forgot_password_button);

        sForgotPassButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment forgotPassFrag = new ForgotPasswordDialogFragment();
                forgotPassFrag.show(getFragmentManager(), "missiles");
            }
        });
    }

}
