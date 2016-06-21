package com.example.winify.cvsi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Intent activityThatCalled = getIntent();

        initialize();
    }


    public void initialize() {
        nameEditText = (EditText) findViewById(R.id.name_edit_text);
        surnameEditText = (EditText) findViewById(R.id.surname_edit_text);
        emailEditText = (EditText) findViewById(R.id.email_edit_text);
        passwordConfirmEditText = (EditText) findViewById(R.id.password_edit_text);
        passwordConfirmEditText = (EditText) findViewById(R.id.password_repeat_edit_text);
        buttonRegister = (Button) findViewById(R.id.register_button);

    }

    public void onRegisterButtonClicked() {
        Toast.makeText(getApplicationContext(), "#totNormal", Toast.LENGTH_SHORT).show();
    }
}
