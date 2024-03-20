package com.example.lab7_ex2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textViewTimer;
    private boolean isRunning = false;
    private int seconds = 0;
    private final Handler handler = new Handler();

    private final Runnable runnable = new Runnable() {
        @Override
        public void run() {
            seconds++;
            int hours = seconds / 3600;
            int minutes = (seconds % 3600) / 60;
            int secs = seconds % 60;
            textViewTimer.setText(String.format("%02d:%02d:%02d", hours, minutes, secs));
            handler.postDelayed(this, 1000);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewTimer = findViewById(R.id.textView);
        Button btnStartStop = findViewById(R.id.buttonStartStop);
        Button btnReset = findViewById(R.id.buttonReset);

        btnStartStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isRunning) {
                    handler.removeCallbacks(runnable);
                    btnStartStop.setText("Start");
                } else {
                    handler.post(runnable);
                    btnStartStop.setText("Stop");
                }
                isRunning = !isRunning;
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.removeCallbacks(runnable);
                isRunning = false;
                seconds = 0;
                textViewTimer.setText("00:00:00");
                btnStartStop.setText("Start");
            }
        });
    }
}