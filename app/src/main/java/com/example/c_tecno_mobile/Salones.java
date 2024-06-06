package com.example.c_tecno_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Salones extends AppCompatActivity {
    CardView salon;

    Cartas salones = new Cartas();
    Reservas pcReservado = new Reservas();
    Reservas SalonReservado = new Reservas();
    Reservas accesorioAReservar = new Reservas();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_salones);
    }

    public void cardPc(View v) {
        Intent pc = new Intent(v.getContext(), Computadores.class);
        v.getContext().startActivity(pc);
    }

    public void cardAccesorios(View v) {
        Intent acc = new Intent(v.getContext(), Accesorios.class);
        v.getContext().startActivity(acc);
    }

    public void Borrar(View view) {
        TextView pcReservado = findViewById(R.id.InfResPc);
        pcReservado.setText("");
    }

    public void TerminarReserva(View v) {
        if (SalonReservado.getSalon().isEmpty()) {
            Toast.makeText(Salones.this, "Ingresa el salón que deseas reservar", Toast.LENGTH_LONG).show();
        } else {
            Intent terminarReserva = new Intent(Salones.this, Reserva.class);
            terminarReserva.putExtra("SalonReguistrado", SalonReservado.getSalon());
            startActivity(terminarReserva);
            finish();

        }
    }

    private void setSalonReservado(String dato1, String dato2, String dato3, String dato4) {
        TextView infoReserva = findViewById(R.id.InfReserva);
        salones.cartas(dato1, dato2, dato3, dato4);
        infoReserva.setText(dato1 + "\n" + dato2 + "\n" + dato3 + "\n" + dato4);
        SalonReservado.setSalon(infoReserva.getText().toString());
    }

    public void getSalon1(View view) {
        TextView Dato1 = findViewById(R.id.namesala1);
        TextView Dato2 = findViewById(R.id.dias1);
        TextView Dato3 = findViewById(R.id.equipos1);
        TextView Dato4 = findViewById(R.id.sede1);

        setSalonReservado(Dato1.getText().toString(), Dato2.getText().toString(), Dato3.getText().toString(), Dato4.getText().toString());
    }

    public void getSalon2(View view) {
        TextView Dato1 = findViewById(R.id.namesala2);
        TextView Dato2 = findViewById(R.id.dias2);
        TextView Dato3 = findViewById(R.id.equipos2);
        TextView Dato4 = findViewById(R.id.sede2);

        setSalonReservado(Dato1.getText().toString(), Dato2.getText().toString(), Dato3.getText().toString(), Dato4.getText().toString());
    }

    public void getSalon3(View view) {
        TextView Dato1 = findViewById(R.id.nameSala3);
        TextView Dato2 = findViewById(R.id.dias3);
        TextView Dato3 = findViewById(R.id.equipos3);
        TextView Dato4 = findViewById(R.id.sede3);

        setSalonReservado(Dato1.getText().toString(), Dato2.getText().toString(), Dato3.getText().toString(), Dato4.getText().toString());
    }

    public void getSalon4(View view) {
        TextView Dato1 = findViewById(R.id.nameSala4);
        TextView Dato2 = findViewById(R.id.dias4);
        TextView Dato3 = findViewById(R.id.equipos4);
        TextView Dato4 = findViewById(R.id.sede4);

        setSalonReservado(Dato1.getText().toString(), Dato2.getText().toString(), Dato3.getText().toString(), Dato4.getText().toString());
    }

    public void getSalon5(View view) {
        TextView Dato1 = findViewById(R.id.nameSala5);
        TextView Dato2 = findViewById(R.id.dias5);
        TextView Dato3 = findViewById(R.id.equipos5);
        TextView Dato4 = findViewById(R.id.sede5);

        setSalonReservado(Dato1.getText().toString(), Dato2.getText().toString(), Dato3.getText().toString(), Dato4.getText().toString());
    }

    public void Home(View v) {
        Intent acc = new Intent(v.getContext(), PaginaPrincipal.class);
        v.getContext().startActivity(acc);
    }
}
