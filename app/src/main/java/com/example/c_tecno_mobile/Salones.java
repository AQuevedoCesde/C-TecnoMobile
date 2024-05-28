package com.example.c_tecno_mobile;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Salones extends AppCompatActivity {
    CardView salon;

    Cartas salones = new Cartas();
    Reservas SalonReservado = new Reservas();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_salones);

    }
    public void cardPc (View v) {
        Intent intent = new Intent(v.getContext(), Computadores.class);
        v.getContext().startActivity(intent);
    }

    public void cardAccesorios(View v) {
        Intent intent = new Intent(v.getContext(), Accesorios.class);
        v.getContext().startActivity(intent);
    }

    public void Borar(View view) {
        TextView pcreservado = (TextView) findViewById(R.id.InfResPc);
        pcreservado.setText("");
    }

    public void TerminarReserva(View v) {
        if ( SalonReservado.getComputador().isEmpty() ) {
            Toast.makeText(Salones.this, "Ingresa el Salon " +
                    "que deseas reservar", Toast.LENGTH_LONG).show();
        } else {
            Intent intent = new Intent(v.getContext(), Reserva.class);
            v.getContext().startActivity(intent);
        }
    }

    /// Funcionalidad de los botones

   public void getsalon1(View view) {
        //valores variables
        TextView Dato1 = (TextView) findViewById(R.id.namesala1);
        TextView Dato2 = (TextView) findViewById(R.id.dias1);
        TextView Dato3 = (TextView) findViewById(R.id.equipos1);
        TextView Dato4 = (TextView) findViewById(R.id.sede1);

        //Funcionalidad estatica
        TextView pcreservado = (TextView) findViewById(R.id.InfResPc);
        salones.cartas(Dato1.getText().toString(),Dato2.getText().toString(),
                Dato3.getText().toString(),Dato4.getText().toString());
        pcreservado.setText(salones.Dato1 + "\n" + salones.Dato2 + "\n" + salones.Dato3 + salones.Dato4);
    }

    public void getSalon2(View view) {
        //valores variables
        TextView Dato1 = (TextView) findViewById(R.id.namesala2);
        TextView Dato2 = (TextView) findViewById(R.id.dias2);
        TextView Dato3 = (TextView) findViewById(R.id.equipos2);
        TextView Dato4 = (TextView) findViewById(R.id.sede2);

        //Funcionalidad estatica
        TextView pcreservado = (TextView) findViewById(R.id.InfResPc);
        salones.cartas(Dato1.getText().toString(),Dato2.getText().toString(),
                Dato3.getText().toString(),Dato4.getText().toString());
        pcreservado.setText(salones.Dato1 + "\n" + salones.Dato2 + "\n" + salones.Dato3 + salones.Dato4);
    }
    public void getSalon3(View view) {
        //valores variables
        TextView Dato1 = (TextView) findViewById(R.id.nameSala3);
        TextView Dato2 = (TextView) findViewById(R.id.dias3);
        TextView Dato3 = (TextView) findViewById(R.id.equipos3);
        TextView Dato4 = (TextView) findViewById(R.id.sede3);

        //Funcionalidad estatica
        TextView pcreservado = (TextView) findViewById(R.id.InfResPc);
        salones.cartas(Dato1.getText().toString(),Dato2.getText().toString(),
                Dato3.getText().toString(),Dato4.getText().toString());
        pcreservado.setText(salones.Dato1 + "\n" + salones.Dato2 + "\n" + salones.Dato3 + salones.Dato4);
    }

    public void getSalon4(View view) {
        //valores variables
        TextView Dato1 = (TextView) findViewById(R.id.nameSala4);
        TextView Dato2 = (TextView) findViewById(R.id.dias4);
        TextView Dato3 = (TextView) findViewById(R.id.equipos4);
        TextView Dato4 = (TextView) findViewById(R.id.sede4);

        //Funcionalidad estatica
        TextView pcreservado = (TextView) findViewById(R.id.InfResPc);
        salones.cartas(Dato1.getText().toString(),Dato2.getText().toString(),
                Dato3.getText().toString(),Dato4.getText().toString());
        pcreservado.setText(salones.Dato1 + "\n" + salones.Dato2 + "\n" + salones.Dato3 + salones.Dato4);
    }
    public void getSalon5(View view) {
        //valores variables
        TextView Dato1 = (TextView) findViewById(R.id.nameSala5);
        TextView Dato2 = (TextView) findViewById(R.id.dias5);
        TextView Dato3 = (TextView) findViewById(R.id.equipos5);
        TextView Dato4 = (TextView) findViewById(R.id.sede5);

        //Funcionalidad estatica
        TextView pcreservado = (TextView) findViewById(R.id.InfResPc);
        salones.cartas(Dato1.getText().toString(),Dato2.getText().toString(),
                Dato3.getText().toString(),Dato4.getText().toString());
        pcreservado.setText(salones.Dato1 + "\n" + salones.Dato2 + "\n" + salones.Dato3 + salones.Dato4);
    }

}