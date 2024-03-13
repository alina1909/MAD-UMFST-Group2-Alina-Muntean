package com.example.lab5_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_puppy = findViewById(R.id.buttonPuppy);
        btn_puppy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent3);
            }
        });
    }

    public void Google( View v){
        String URL = "https://google.com";
        Intent intent2 = new Intent(Intent.ACTION_VIEW);
        intent2.setData(Uri.parse(URL));
        startActivity(intent2);
    }

    public void Call(View v){
        Intent intent1 = new Intent(Intent.ACTION_DIAL);
        intent1.setData(Uri.parse("tel:0740123456"));
        startActivity(intent1);
    }
}