package com.example.vehicleproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vehicleproject.data.DataBaseHelper;
import com.example.vehicleproject.ui.HomeActivity;
import com.example.vehicleproject.utils.Helper;

public class LoginActivity extends AppCompatActivity {

    private EditText usernameEt, passwordEt;

    private DataBaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DataBaseHelper(this);

        usernameEt = findViewById(R.id.username_et);
        passwordEt = findViewById(R.id.password_et);

        Button loginButton = findViewById(R.id.login_button);
        Button registerButton = findViewById(R.id.register_button);
        TextView forgot = findViewById(R.id.forgot_password_quiz);

        loginButton.setOnClickListener(v -> {

            String username = usernameEt.getText().toString();
            String password = passwordEt.getText().toString();

            if (username.equals("") || password.equals("")) {

                Helper.toast("All fields are required");

            } else {

                if (db.login(username, password)) {

                    Intent homeIntent = new Intent(this, HomeActivity.class);

                    homeIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                    startActivity(homeIntent);

                    Helper.toast("You have logged in successfully");

                } else {

                    Helper.toast("Wrong credentials");
                }
            }
        });

        registerButton.setOnClickListener(v -> {

            Intent registerIntent = new Intent(this, RegisterActivity.class);

            startActivity(registerIntent);

        });

        forgot.setOnClickListener(v -> {

            Intent registerIntent = new Intent(this, RegisterActivity.class);

            startActivity(registerIntent);

        });
    }
}