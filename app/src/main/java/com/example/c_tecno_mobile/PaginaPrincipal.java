package com.example.c_tecno_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class PaginaPrincipal extends AppCompatActivity {

    CardView computadores, salones, accesorios, reserva;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pagina_principal);

        computadores = findViewById(R.id.cardComputador);
        salones = findViewById(R.id.cardSalones);
        accesorios = findViewById(R.id.cardAccesorios);
        reserva = findViewById(R.id.cardReserva);

        computadores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Computadores.class);
                v.getContext().startActivity(intent);
            }
        });
        salones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Salones.class);
                v.getContext().startActivity(intent);
            }
        });
        accesorios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Accesorios.class);
                v.getContext().startActivity(intent);
            }
        });
        reserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Reserva.class);
                v.getContext().startActivity(intent);
            }
        });


    }
}