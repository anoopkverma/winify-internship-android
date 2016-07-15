package com.example.winify.cvsi.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.winify.cvsi.R;
import com.example.winify.cvsi.controllers.UserController;
import com.example.winify.cvsi.dto.error.ServerResponseStatus;
import com.example.winify.cvsi.dto.templates.request.AuthorizationClientRequest;
import com.example.winify.cvsi.interfaces.IUser;

import java.util.Date;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by diana on 6/21/16.
 */
public class RegisterActivity extends AppCompatActivity {

    private static EditText nameEditText;
    private static EditText surnameEditText;
    private static EditText emailEditText;
    private static EditText passwordEditText;
    private static EditText passwordConfirmEditText;
    private static Button buttonRegister;
    private static EditText msisdnET;
    private static EditText usernameET;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initializeClassComponents();
        Intent activityThatCalled = getIntent();

//        initTest();

        initializeToolbar();
    }


    public void initializeClassComponents() {
        nameEditText = (EditText) findViewById(R.id.name_edit_text);
        surnameEditText = (EditText) findViewById(R.id.surname_edit_text);
        emailEditText = (EditText) findViewById(R.id.email_edit_text);
        passwordEditText = (EditText) findViewById(R.id.password_edit_text);
        passwordConfirmEditText = (EditText) findViewById(R.id.password_repeat_edit_text);
        buttonRegister = (Button) findViewById(R.id.register_button);
        msisdnET = (EditText) findViewById(R.id.msisdn_edit_text);
        usernameET = (EditText) findViewById(R.id.username_edit_text);


        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new UserController().postUser(getData());
            }
        });

    }

    public AuthorizationClientRequest getData() {

        return new AuthorizationClientRequest(
                emailEditText.getText().toString(),
                passwordEditText.getText().toString(),
                msisdnET.getText().toString(),
                usernameET.getText().toString(),
                nameEditText.getText().toString(),
                surnameEditText.getText().toString(),
                new Date().getTime()
        );
    }

    public void initTest() {
        nameEditText.setText("qwfpgjluy");
        surnameEditText.setText("qwfpgjluy");
        emailEditText.setText("aaaaapgjl@mail.ru");
        passwordEditText.setText("qwfpgjluy");
        passwordConfirmEditText.setText(passwordEditText.getText().toString());
        usernameET.setText("qwfpgjluusername");
        msisdnET.setText("123456789");

    }

    public void onRegisterButtonClicked() {
        Toast.makeText(getApplicationContext(), "#totNormal", Toast.LENGTH_SHORT).show();
    }

    public void initializeToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
}
