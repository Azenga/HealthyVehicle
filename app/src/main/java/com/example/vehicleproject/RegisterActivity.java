package com.example.vehicleproject;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vehicleproject.data.DataBaseHelper;
import com.example.vehicleproject.ui.HomeActivity;
import com.example.vehicleproject.utils.Helper;

public class RegisterActivity extends AppCompatActivity {

    private EditText firstNameEt, lastNameEt, usernameEt, passwordEt, confirmPasswordEt;
    private DataBaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DataBaseHelper(this);

        firstNameEt = findViewById(R.id.first_name_et);
        lastNameEt = findViewById(R.id.last_name_et);
        usernameEt = findViewById(R.id.username_et);
        passwordEt = findViewById(R.id.password_et);
        confirmPasswordEt = findViewById(R.id.confirm_password_et);

        Button registerButton = findViewById(R.id.register_button);
        TextView loginTv = findViewById(R.id.login_tv);

        loginTv.setOnClickListener(view -> finish());

        registerButton.setOnClickListener(v -> {

            String firstName = firstNameEt.getText().toString();
            String lastName = lastNameEt.getText().toString();
            String username = usernameEt.getText().toString();
            String password = passwordEt.getText().toString();
            String confirmPassword = confirmPasswordEt.getText().toString();

            if (TextUtils.isEmpty(firstName) || TextUtils.isEmpty(lastName) || TextUtils.isEmpty(username) || TextUtils.isEmpty(password) || TextUtils.isEmpty(confirmPassword)) {
                Helper.toast("All fields are required");
            } else {

                if (password.equals(confirmPassword)) {

                    if (db.checkUsername(username)) {

                        if (db.InsertData(firstName, lastName, username, password)) {

                            Helper.toast("Registration Successfully Complete");

                            Intent homeIntent = new Intent(this, HomeActivity.class);
                            homeIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                            startActivity(homeIntent);
                        }


                    } else {
                        Helper.toast("Username Already Exist");
                    }
                } else {
                    Helper.toast("Passwords Don't Match");
                }
            }
        });

    }
}
