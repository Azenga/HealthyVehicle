package com.example.vehicleproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Hire_pickup extends AppCompatActivity {
    EditText Passangers,Period,Cost;
    Button Calculate,Payment,Decline;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Passangers=(EditText)findViewById(R.id.nopassager);
        Period=(EditText)findViewById(R.id.period);
        Cost=(EditText)findViewById(R.id.cost);
        Calculate=(Button) findViewById(R.id.calculate);
        Payment=(Button)findViewById(R.id.payment);
        Decline=(Button) findViewById(R.id.decline);

        Calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int p=new Integer(Passangers.getText().toString());
                int mult=p*200;
                Cost.setText("Ksh."+mult);
            }
        });

    }
}

