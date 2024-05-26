package com.example.c_tecno_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timer = new CountDownTimer(3000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
            }
        };

    }
    @Override
    protected void onResume() {
        super.onResume();
        timer.start();
    }
    @Override
    protected void onPause() {
        super.onPause();
        timer.cancel();
    }
}