package com.example.simpilecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class DonationReportActivity extends AppCompatActivity {

    TextView reportText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_report);
        String msg =  getIntent().getStringExtra("donation_report");
        reportText = findViewById(R.id.reporttext);
        reportText.setText(msg);
    }
}