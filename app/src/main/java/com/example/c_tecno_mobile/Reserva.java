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
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Reserva extends AppCompatActivity {

    private static final String RESERVADOPC = "Computador" ;
    private static final String RESERVADOSALON = "Salon";
    private static final String RESERVADOACC = "Accesorio";
    private static final String RESERVAFECHA = "Fecha";
    private static final String RESERVAHORA = "Hora";
    TextView accReservadoView , SalaReservadaView, pcReservadoView;
    String ReservaAcc;
    String ReservaSalon;
    String ReservaPc;


    EditText fechareserva,horareserva ;
    String randomId = java.util.UUID.randomUUID().toString();
    private DocumentReference firebaseReferencia = FirebaseFirestore.getInstance().collection("reservas").document(randomId);


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

        ReservaAcc = getIntent().getStringExtra("AccesorioRegistrado");
        ReservaSalon = getIntent().getStringExtra("SalonRegistrado");
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
        String ReservaPcFb = pcReservadoView.getText().toString();
        String ReservaslFb = SalaReservadaView.getText().toString();
        String ReservaaccFb = accReservadoView.getText().toString();
        String Fecha = fechareserva.getText().toString() ;
        String Hora = horareserva.getText().toString();


        Map<String,Object> datosReserva = new HashMap<>();
        datosReserva.put(RESERVADOPC, ReservaPcFb);
        datosReserva.put(RESERVADOSALON, ReservaslFb);
        datosReserva.put(RESERVADOACC, ReservaaccFb);
        datosReserva.put(RESERVAFECHA, Fecha);
        datosReserva.put(RESERVAHORA, Hora);

        firebaseReferencia.set(datosReserva).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(Reserva.this, "Reserva Guardada",
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Reserva.this, PaginaPrincipal.class);
                startActivity(intent);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Reserva.this, "Error en la reserva ",
                        Toast.LENGTH_SHORT).show();
            }
        });


    }
}