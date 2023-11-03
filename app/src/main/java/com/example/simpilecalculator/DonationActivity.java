package com.example.simpilecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DonationActivity extends AppCompatActivity
        implements View.OnClickListener{

    EditText amountText;
    RadioButton paypal_but;
    RadioButton credit_but;
    Button donation_but;
    int selectedPayment = 0;
    double amount;
    Donation listOfDonations[] ;
    int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation);

        listOfDonations = ((MyApp)getApplication()).allDonations;
        index = ((MyApp)getApplication()).index;
        amountText = findViewById(R.id.donation_amount);
        paypal_but = findViewById(R.id.paypal);
        credit_but = findViewById(R.id.creditCard);
        donation_but = findViewById(R.id.donate_button);
        paypal_but.setOnClickListener(this);
        credit_but.setOnClickListener(this);
        donation_but.setOnClickListener(this);
    }

    boolean validate(){
        boolean flag = false;
        if (!amountText.getText().toString().isEmpty() && selectedPayment != 0){
            amount = Double.parseDouble(amountText.getText().toString());
            flag = true;
        }
        return flag;
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.donate_button:

                if (validate()){
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();
                    Donation newDonation = new Donation(selectedPayment,amount,dtf.format(now));
                    listOfDonations[((MyApp)getApplication()).index++] = newDonation;
                    // toast to thank the user.
                    String msg = "Thanks for your donation number " + (((MyApp)getApplication()).index)  + " The amount is "+ newDonation.getAmount() +"$";
                    Toast.makeText(this, msg,Toast.LENGTH_LONG).show();

                    paypal_but.setChecked(false);
                    credit_but.setChecked(false);
                    amountText.setText("");
                }
                else {
                    // make toast.
                    Toast.makeText(this,R.string.error_msg,Toast.LENGTH_LONG).show();

                }
                break;
            case R.id.creditCard:
                selectedPayment = 1;
                break;

            case R.id.paypal:
                selectedPayment = 2;
                break;


        }
    }
}