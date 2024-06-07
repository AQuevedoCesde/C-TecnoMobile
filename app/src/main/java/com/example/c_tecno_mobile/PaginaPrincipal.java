package com.example.c_tecno_mobile;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.Objects;

public class PaginaPrincipal extends AppCompatActivity {

    CardView computadores, salones, accesorios, reserva;
    String url = "https://basedatospy-3jxuhmy5hwcbiczjtxpejs.streamlit.app/Computadores";
    String ReservaPc;

    Reservas estadoReserva = new Reservas();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pagina_principal);

        ReservaPc = getIntent().getStringExtra("ComputadorRegistrado");


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
                intent.putExtra("ComputadorRegistrado",ReservaPc);
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
                if (Objects.equals(estadoReserva.Computador, "")
                        && Objects.equals(estadoReserva.Salon, "")
                        && Objects.equals(estadoReserva.accesorio, "")) {
                    Toast.makeText(PaginaPrincipal.this, "NO TIENES NINGUNA RESERVA",
                            Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(v.getContext(), Reserva.class);
                    v.getContext().startActivity(intent);
                }
            }
        });

    }
    public void estadisticaPc(View v) {
        String url = "https://basedatospy-3jxuhmy5hwcbiczjtxpejs.streamlit.app/Computadores";
        Uri link = Uri.parse(url);
        Intent i = new Intent(Intent.ACTION_VIEW,link);
        startActivity(i);
    }

    public void estadisticaSalon(View view) {
        String url = "https://basedatospy-3jxuhmy5hwcbiczjtxpejs.streamlit.app/Salas";
        Uri link = Uri.parse(url);
        Intent i = new Intent(Intent.ACTION_VIEW,link);
        startActivity(i);
    }

    public void estadisticaAcc(View view) {
        String url = "https://basedatospy-3jxuhmy5hwcbiczjtxpejs.streamlit.app/Accesorios";
        Uri link = Uri.parse(url);
        Intent i = new Intent(Intent.ACTION_VIEW,link);
        startActivity(i);
    }
}