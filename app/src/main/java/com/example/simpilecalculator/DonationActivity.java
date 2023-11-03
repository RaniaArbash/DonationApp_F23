package com.example.simpilecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class DonationActivity extends AppCompatActivity
        implements View.OnClickListener{

    EditText amountText;
    RadioButton paypal_but;
    RadioButton credit_but;
    Button donation_but;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation);
        amountText = findViewById(R.id.donation_amount);
        paypal_but = findViewById(R.id.paypal);
        credit_but = findViewById(R.id.creditCard);
        donation_but = findViewById(R.id.donate_button);

        paypal_but.setOnClickListener(this);
        credit_but.setOnClickListener(this);
        donation_but.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.donate_button:
                Log.d("donation", "donation button clicked");
                break;
            case R.id.creditCard:
                Log.d("donation", "credit card button clicked");
                break;

            case R.id.paypal:
                Log.d("donation", "paypal card button clicked");

                break;


        }
    }
}