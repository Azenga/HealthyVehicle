package com.example.vehicleproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Services extends AppCompatActivity {
Button Hire,Transport,Advice;
Button Repair;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.services);
        Hire=findViewById(R.id.hire);
        Repair=findViewById(R.id.repair);
        Transport=findViewById(R.id.transport);
        Advice=findViewById(R.id.advice);}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.activity_hire_drawer,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.Bus:
                Toast.makeText(getApplicationContext(),"Bus selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.motorcycle:
                Toast.makeText(getApplicationContext(),"motorcycle selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.materials:
                Toast.makeText(getApplicationContext(),"materials selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.Car:
                Toast.makeText(getApplicationContext(),"car selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.Pickup:
                Toast.makeText(getApplicationContext(),"Pick-up selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.luggage:
                Toast.makeText(getApplicationContext(),"luggage selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.van:
                Toast.makeText(getApplicationContext(),"Van selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.Others:
                Toast.makeText(getApplicationContext(),"others selected", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void onButtonClick(View view){
        Intent myintent=new Intent(getBaseContext(), Cleaning_repair.class);
        startActivity(myintent);
    }

}

