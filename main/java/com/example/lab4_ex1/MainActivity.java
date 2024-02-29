package com.example.lab4_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText textNr1;
    private EditText textNr2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         textNr1 = findViewById(R.id.editTextNumber1);
         textNr2 = findViewById(R.id.editTextNumber2);
        TextView textRez = findViewById(R.id.textViewRez);

        Button btnPlus = findViewById(R.id.buttonPlus);
        Button btnMinus = findViewById(R.id.buttonMinus);
        Button btnInm = findViewById(R.id.buttonInm);
        Button btnDivide = findViewById(R.id.buttonDiv);

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double nr1 = Double.parseDouble(textNr1.getText().toString());
                double nr2 = Double.parseDouble(textNr2.getText().toString());
                double result;

                result = nr1 + nr2;
                textRez.setText(String.valueOf(result));
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double nr1 = Double.parseDouble(textNr1.getText().toString());
                double nr2 = Double.parseDouble(textNr2.getText().toString());
                double result;

                result = nr1 - nr2;
                textRez.setText(String.valueOf(result));
            }
        });

        btnInm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double nr1 = Double.parseDouble(textNr1.getText().toString());
                double nr2 = Double.parseDouble(textNr2.getText().toString());
                double result;

                result = nr1 * nr2;
                textRez.setText(String.valueOf(result));
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double nr1 = Double.parseDouble(textNr1.getText().toString());
                double nr2 = Double.parseDouble(textNr2.getText().toString());
                double result;

                result = nr1/ nr2;
                textRez.setText(String.valueOf(result));
            }
        });
    }
}