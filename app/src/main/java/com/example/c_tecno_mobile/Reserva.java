package com.example.c_tecno_mobile;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Reserva extends AppCompatActivity {

    TextView accReservadoView , SalaReservadaView, pcReservadoView;
    String ReservaAcc;
    String ReservaSalon;
    String ReservaPc;

    EditText fechareserva,horareserva ;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_reserva);

        fechareserva = findViewById(R.id.fechareserva);
        horareserva = findViewById(R.id.horareserva);
        ImageView btnfechareserva = findViewById(R.id.btnfechareserva);
        ImageView btnhorareserva = findViewById(R.id.btnhorareserva);
        accReservadoView = findViewById(R.id.accReservado);
        SalaReservadaView = findViewById(R.id.SalonReservado);
        pcReservadoView = findViewById(R.id.pcReservado);

        ReservaAcc = getIntent().getStringExtra("AccesorioReguistrado");
        ReservaSalon = getIntent().getStringExtra("SalonReguistrado");
        ReservaPc = getIntent().getStringExtra("ComputadorRegistrado");

        accReservadoView.setText(ReservaAcc);
        SalaReservadaView.setText(ReservaSalon);
        pcReservadoView.setText(ReservaPc);

        btnfechareserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog f = new DatePickerDialog(Reserva.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        fechareserva.setText(year + "/" + (month+1) + "/" + dayOfMonth);

                    }
                },2024,0,1);
                f.show();
            }

        });
        //fin dialogo fecha
        // inicio dialogo hora
        btnhorareserva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog h = new TimePickerDialog(Reserva.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        horareserva.setText (hourOfDay + ":" + minute);

                    }
                },12,0,true);
                h.show();

            }
        });
    }

    public void Cancelar(View v) {
        Toast.makeText(this, "Reserva Cancelada", Toast.LENGTH_LONG).show();
        Intent acc = new Intent(v.getContext(), PaginaPrincipal.class);
        v.getContext().startActivity(acc);
    }

    public void reservado(View v) {
        Toast.makeText(this, "Reserva Guardada", Toast.LENGTH_LONG).show();
        Intent acc = new Intent(v.getContext(), PaginaPrincipal.class);
        v.getContext().startActivity(acc);
    }

    public void accesorios(View v) {
        Intent acc = new Intent(v.getContext(), Accesorios.class);
        v.getContext().startActivity(acc);
    }

    public void pc(View v) {
        Intent acc = new Intent(v.getContext(), Computadores.class);
        v.getContext().startActivity(acc);
    }

    public void salas(View v) {
        Intent acc = new Intent(v.getContext(), Salones.class);
        v.getContext().startActivity(acc);
    }
}