package com.example.kantor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText ZL = findViewById(R.id.ZlPrice);
        EditText show = findViewById(R.id.Sum);
        Button USD = findViewById(R.id.USD);
        Button YEN = findViewById(R.id.YEN);
        Button GBP = findViewById(R.id.GBP);
        Button Change = findViewById(R.id.Change);
        Double ZltoUSD = 0.2487;
        Double USDtoZL = 4.02;
        Double ZltoYEN = 37.037;
        Double YEntoZL = 0.025;
        Double ZltoGBP = 0.1980;
        Double GBPtoZl = 5.05;
        show.setEnabled(false);
        final boolean[] isitchanged = {true};


        Change.setOnClickListener((View view) ->{
            if(isitchanged[0]){
                Change.setText("<-");
                ZL.setEnabled(false);
                show.setEnabled(true);
                isitchanged[0] = false;
            }
            else {
                Change.setText("->");
                show.setEnabled(false);
                ZL.setEnabled(true);
                isitchanged[0] = true;
            }

        });

        USD.setOnClickListener((View view) ->{
            double Sum = 0;
            String st = "";
            if(isitchanged[0]){
                double ZLPrice = Double.parseDouble(ZL.getText().toString());
                Sum = ZltoUSD*ZLPrice;
                st = String.format("%1$,.2f", Sum);
                show.setText(st);
            }
            else{
                double USDPrice = Double.parseDouble(show.getText().toString());
                Sum = USDtoZL*USDPrice;
                st = String.format("%1$,.2f", Sum);
                ZL.setText(st);
            }
        });
        YEN.setOnClickListener((View view) ->{
            double Sum = 0;
            String st = "";
            if(isitchanged[0]){
                double ZLPrice = Double.parseDouble(ZL.getText().toString());
                Sum = ZltoYEN*ZLPrice;
                st = String.format("%1$,.2f", Sum);
                show.setText(st);
            }
            else{
                double YENPrice = Double.parseDouble(show.getText().toString());
                Sum = YEntoZL*YENPrice;
                st = String.format("%1$,.2f", Sum);
                ZL.setText(st);
            }
        });
        GBP.setOnClickListener((View view) ->{
            double Sum = 0;
            String st = "";
            if(isitchanged[0]){
                double ZLPrice = Double.parseDouble(ZL.getText().toString());
                Sum = ZltoGBP*ZLPrice;
                st = String.format("%1$,.2f", Sum);
                show.setText(st);
            }
            else{
                double GBPPrice = Double.parseDouble(show.getText().toString());
                Sum = GBPtoZl*GBPPrice;
                st = String.format("%1$,.2f", Sum);
                ZL.setText(st);
            }
        });

    }
}