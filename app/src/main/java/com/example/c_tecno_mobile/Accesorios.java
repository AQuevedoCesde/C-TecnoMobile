package com.example.c_tecno_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Accesorios extends AppCompatActivity {

    CardView salon;

    Cartas Accesorio = new Cartas();
    Reservas accesorioAReservar = new Reservas();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_accesorios);
    }

    public void cardPc(View v) {
        Intent intent = new Intent(v.getContext(), Computadores.class);
        v.getContext().startActivity(intent);
    }

    public void cardSalones(View v) {
        Intent intent = new Intent(v.getContext(), Salones.class);
        v.getContext().startActivity(intent);
    }

    public void Borrar(View v) {
        TextView pcReservado = findViewById(R.id.InfResPc);
        pcReservado.setText("");
    }

    public void TerminarReserva(View v) {
        if (accesorioAReservar.getAccesorio().isEmpty()) {
            Toast.makeText(Accesorios.this, "Ingresa el accesorio que deseas reservar", Toast.LENGTH_LONG).show();
        } else {
            Intent terminarReserva = new Intent(Accesorios.this, Reserva.class);
            terminarReserva.putExtra("AccesorioReguistrado", accesorioAReservar.getAccesorio());
            startActivity(terminarReserva);
            finish();
        }
    }

    private void setAccesorioReservado(String dato1, String dato2, String dato3, String dato4) {
        TextView accReservado = findViewById(R.id.InfResPc);
        Accesorio.cartas(dato1, dato2, dato3, dato4);
        accReservado.setText(dato1 + "\n" + dato2 + "\n" + dato3 + "\n" + dato4);
        accesorioAReservar.setAccesorio(accReservado.getText().toString());
    }

    public void getAcce1(View view) {
        TextView Dato1 = findViewById(R.id.accName1);
        TextView Dato2 = findViewById(R.id.cone1);
        TextView Dato3 = findViewById(R.id.mark1);
        TextView Dato4 = findViewById(R.id.color1);

        setAccesorioReservado(Dato1.getText().toString(), Dato2.getText().toString(), Dato3.getText().toString(), Dato4.getText().toString());
    }

    public void getAcce2(View view) {
        TextView Dato1 = findViewById(R.id.accName2);
        TextView Dato2 = findViewById(R.id.cone2);
        TextView Dato3 = findViewById(R.id.mark2);
        TextView Dato4 = findViewById(R.id.color2);

        setAccesorioReservado(Dato1.getText().toString(), Dato2.getText().toString(), Dato3.getText().toString(), Dato4.getText().toString());
    }

    public void getAcce3(View view) {
        TextView Dato1 = findViewById(R.id.accName3);
        TextView Dato2 = findViewById(R.id.cone3);
        TextView Dato3 = findViewById(R.id.mark3);
        TextView Dato4 = findViewById(R.id.color3);

        setAccesorioReservado(Dato1.getText().toString(), Dato2.getText().toString(), Dato3.getText().toString(), Dato4.getText().toString());
    }

    public void getAcce4(View view) {
        TextView Dato1 = findViewById(R.id.accName4);
        TextView Dato2 = findViewById(R.id.cone4);
        TextView Dato3 = findViewById(R.id.mark4);
        TextView Dato4 = findViewById(R.id.color4);

        setAccesorioReservado(Dato1.getText().toString(), Dato2.getText().toString(), Dato3.getText().toString(), Dato4.getText().toString());
    }

    public void getAcce5(View view) {
        TextView Dato1 = findViewById(R.id.accName5);
        TextView Dato2 = findViewById(R.id.cone5);
        TextView Dato3 = findViewById(R.id.mark5);
        TextView Dato4 = findViewById(R.id.color5);

        setAccesorioReservado(Dato1.getText().toString(), Dato2.getText().toString(), Dato3.getText().toString(), Dato4.getText().toString());
    }

    public void Home(View v) {
        Intent acc = new Intent(v.getContext(), PaginaPrincipal.class);
        v.getContext().startActivity(acc);
    }
}