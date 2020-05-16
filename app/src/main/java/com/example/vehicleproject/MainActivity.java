package com.example.vehicleproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vehicleproject.data.DataBaseHelper;
import com.example.vehicleproject.utils.Helper;

public class MainActivity extends AppCompatActivity {

    private EditText usernameEt, passwordEt;

    private DataBaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Login");

        db = new DataBaseHelper(this);

        usernameEt = findViewById(R.id.Username);
        passwordEt = findViewById(R.id.password);
        Button loginButton = findViewById(R.id.login_button);
        Button registerButton = findViewById(R.id.register_button);
        TextView forgot = findViewById(R.id.forgot_password_quiz);

        loginButton.setOnClickListener(v -> {

            String username = usernameEt.getText().toString();
            String password = passwordEt.getText().toString();

            if (username.equals("") || password.equals("")) {

                Toast.makeText(MainActivity.this, "Fields are Empty", Toast.LENGTH_SHORT).show();

            } else {

                if (db.login(username, password)) {

                    Intent Hire = new Intent(this, Services.class);

                    startActivity(Hire);

                    Helper.toast("You have logged in successfully");

                } else {

                    Helper.toast("Wrong credentials");
                }
            }
        });
        registerButton.setOnClickListener(v -> {

            Intent Register = new Intent(getApplicationContext(), Register.class);
            startActivity(Register);

        });
        forgot.setOnClickListener(v -> {

            Intent Register = new Intent(getApplicationContext(), Register.class);
            startActivity(Register);

        });
    }
}