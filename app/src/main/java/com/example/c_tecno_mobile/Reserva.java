package com.example.c_tecno_mobile;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Reserva extends AppCompatActivity {

    TextView reservaTexto;
    Reservas pc = new Reservas();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_reserva);


        String computadorReservado = getIntent().getStringExtra("computadorReservado");
        if (computadorReservado != null) {
            reservaTexto.setText(computadorReservado);
        }


    }

}