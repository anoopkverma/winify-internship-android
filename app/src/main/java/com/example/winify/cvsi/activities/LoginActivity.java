package com.example.winify.cvsi.activities;

import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.winify.cvsi.R;
import com.example.winify.cvsi.controllers.SessionManager;
import com.example.winify.cvsi.controllers.UserController;
import com.example.winify.cvsi.fragments.ForgotPasswordDialogFragment;
import com.example.winify.cvsi.model.LoginUserModel;
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

    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sessionManager = new SessionManager(getApplicationContext());
        initViews();
    }


    public void initViews() {
        mEmail = (EditText) findViewById(R.id.txtLoginEmail) ;
        mEmail.setText("cvsiserver@gmail.com");
        sPassword = (EditText) findViewById(R.id.txtLoginPassword);
        sPassword.setText("cvsiserver");
        sLoginButton = (Button) findViewById(R.id.btnLogin);
        sRegisterLink = (TextView) findViewById(R.id.link_to_register);
        sRegisterLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRegisterLinkClicked();
            }
        });
        sLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLoginButtonClick();

                AsyncTaskRunner runner = new AsyncTaskRunner();
                runner.execute("2");

            }
        });

    }

    public void onRegisterLinkClicked() {
        Intent getLoginIntent = new Intent(this, RegisterActivity.class) ;
        final int result = 1;

        getLoginIntent.putExtra("callingActivity", "LoginActivity");
        startActivityForResult(getLoginIntent, result);
    }

    public void onLoginButtonClick() {
        LoginUserModel userModel = new LoginUserModel();
        userModel.setEmail(mEmail.getText().toString());
        userModel.setPassword(sPassword.getText().toString());
        userController = new UserController(this.getApplicationContext());
        userController.login(userModel);
    }

    public void getMainActivity() {
        Intent getListItemsIntent = new Intent(this, ListItemsActivity.class);
        final int result = 1;
        getListItemsIntent.putExtra("callingActivity", "LoginActivity");
        startActivityForResult(getListItemsIntent, result);
    }

    private class AsyncTaskRunner extends AsyncTask<String, String, String> {

        private String resp;
        ProgressDialog progressDialog;

        @Override
        protected String doInBackground(String... params) {
            publishProgress("Sleeping..."); // Calls onProgressUpdate()
            try {
                int time = Integer.parseInt(params[0]) * 1000;

                Thread.sleep(time);
                resp = "Slept for " + params[0] + " seconds";
                if (sessionManager.getToken() != null) {
                    getMainActivity();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                resp = e.getMessage();
            } catch (Exception e) {
                e.printStackTrace();
                resp = e.getMessage();
            }
            Log.w("RESP", resp);
            return resp;
        }

        @Override
        protected void onPostExecute(String result) {
            progressDialog.dismiss();
        }


        @Override
        protected void onPreExecute() {
            progressDialog = ProgressDialog.show(LoginActivity.this,
                    "ProgressDialog",
                    "Loading...");
        }

        @Override
        protected void onProgressUpdate(String... text) {

        }
    }

}
