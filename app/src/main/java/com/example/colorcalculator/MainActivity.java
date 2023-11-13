package com.example.colorcalculator;

import static com.example.colorcalculator.R.id.editText1;
import static com.example.colorcalculator.R.id.radio1;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText widthT;
    private EditText hightT;
    private EditText rateT;
    private EditText countT;
    private EditText volumeT;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        widthT = findViewById(R.id.editText1);
        hightT = findViewById(R.id.editText2);
        rateT = findViewById(R.id.editText3);
        countT = findViewById(R.id.editText4);
        volumeT = findViewById(R.id.editText5);
        radioGroup = findViewById(R.id.radios);

        Button calculateButton = findViewById(R.id.buttonCalc);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator();
            }
        });
    }

    public void calculator(){

        double result = 0;

        String widthText = widthT.getText().toString();
        String hightText = hightT.getText().toString();
        String rateText = rateT.getText().toString();
        String countText = countT.getText().toString();
        String volumeText = volumeT.getText().toString();

        if (widthText.isEmpty() || hightText.isEmpty() || rateText.isEmpty() || countText.isEmpty() || volumeText.isEmpty())
        {
            Toast.makeText(this, "Пожалуйста, заполните все поля", Toast.LENGTH_SHORT).show();
            return;
        }

        double width = Double.parseDouble(widthText);
        double hight = Double.parseDouble(hightText);
        double rate = Double.parseDouble(rateText);
        double count = Double.parseDouble(countText);
        double volume = Double.parseDouble(volumeText);

        RadioGroup radioGroup = findViewById(R.id.radios);

        int checkIndex = radioGroup.getCheckedRadioButtonId();

        double stockFactor = 0;

        if(checkIndex == R.id.radio1)
        {
            stockFactor = 1.15;
        }
        else if (checkIndex == R.id.radio2)
        {
            stockFactor = 1.15;
        }
        else if(checkIndex == R.id.radio3) {
            stockFactor = 1;
        }

        result = (width * hight * rate * count * stockFactor) / volume;

        String resultMessage = "Необходимо " + result + " банок красок";
        Toast.makeText(this, resultMessage, Toast.LENGTH_LONG).show();

    }
}