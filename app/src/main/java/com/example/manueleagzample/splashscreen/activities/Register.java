package com.example.manueleagzample.splashscreen.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.manueleagzample.splashscreen.R;
import com.example.manueleagzample.splashscreen.utils.PrefsManager;

public class Register extends AppCompatActivity {

    private PrefsManager prefsManager;

    private TextInputEditText firstName;
    private TextInputEditText lastName;
    private TextInputEditText email;
    private TextInputEditText username;
    private TextInputEditText phoneNumber;
    private TextInputEditText password;
    private TextInputEditText conf_password;

    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        prefsManager = new PrefsManager(this);
        initViews();
        initListeners();
    }

    private void initViews() {
        firstName = findViewById(R.id.first_name);
        lastName = findViewById(R.id.last_name);
        email = findViewById(R.id.email);
        username = findViewById(R.id.username);
        phoneNumber = findViewById(R.id.phone);
        password = findViewById(R.id.password);
        conf_password = findViewById(R.id.conf_password);
        registerButton = findViewById(R.id.register_button);
    }

    private void initListeners() {
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });
    }

    private void validate() {
        if(firstName.getText().toString().isEmpty() || lastName.getText().toString().isEmpty() || username.getText().toString().isEmpty()
                || password.getText().toString().isEmpty() || phoneNumber.getText().toString().isEmpty() || email.getText().toString().isEmpty()) {
            new AlertDialog.Builder(this)
                    .setTitle("Warning")
                    .setMessage("Required Fields Are empty")
                    .show();
        }else {
            goToMain();
        }
    }

    private void goToMain() {
        prefsManager.setIsLoggedIn();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Register.this, MainActivity.class));
                finish();
            }
        }, 1000);
    }
}
