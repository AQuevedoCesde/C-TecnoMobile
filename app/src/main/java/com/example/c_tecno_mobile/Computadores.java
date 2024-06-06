package com.example.c_tecno_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Computadores extends AppCompatActivity {
    CardView pc1;

    Cartas pc = new Cartas();
    Reservas pcReservado = new Reservas();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_computadores);
    }

    public void cardSalones(View v) {
        Intent salones = new Intent(v.getContext(), Salones.class);
        v.getContext().startActivity(salones);
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
        if (pcReservado.getComputador().isEmpty()) {
            Toast.makeText(Computadores.this, "Ingresa el computador que deseas reservar", Toast.LENGTH_LONG).show();
        } else {
            Intent terminarReserva = new Intent(Computadores.this, Reserva.class);
            terminarReserva.putExtra("ComputadorRegistrado", pcReservado.getComputador());
            startActivity(terminarReserva);
            finish();
        }
    }

    private void setPcReservado(String dato1, String dato2, String dato3, String dato4) {
        TextView pcReservado = findViewById(R.id.InfResPc);
        pc.cartas(dato1, dato2, dato3, dato4);
        pcReservado.setText(dato1 + "\n" + dato2 + "\n" + dato3 + "\n" + dato4);
        this.pcReservado.setComputador(pcReservado.getText().toString());

    }

    public void getCard1(View view) {
        TextView Dato1 = findViewById(R.id.marca1);
        TextView Dato2 = findViewById(R.id.s_o1);
        TextView Dato3 = findViewById(R.id.memoria1);
        TextView Dato4 = findViewById(R.id.procesador1);

        setPcReservado(Dato1.getText().toString(), Dato2.getText().toString(), Dato3.getText().toString(), Dato4.getText().toString());
    }

    public void getCard2(View view) {
        TextView Dato1 = findViewById(R.id.marca2);
        TextView Dato2 = findViewById(R.id.s_o2);
        TextView Dato3 = findViewById(R.id.memoria2);
        TextView Dato4 = findViewById(R.id.procesador2);

        setPcReservado(Dato1.getText().toString(), Dato2.getText().toString(), Dato3.getText().toString(), Dato4.getText().toString());
    }

    public void getCard3(View view) {
        TextView Dato1 = findViewById(R.id.marca3);
        TextView Dato2 = findViewById(R.id.s_o3);
        TextView Dato3 = findViewById(R.id.memoria3);
        TextView Dato4 = findViewById(R.id.procesador3);

        setPcReservado(Dato1.getText().toString(), Dato2.getText().toString(), Dato3.getText().toString(), Dato4.getText().toString());
    }

    public void getCard4(View view) {
        TextView Dato1 = findViewById(R.id.marca4);
        TextView Dato2 = findViewById(R.id.s_o4);
        TextView Dato3 = findViewById(R.id.memoria4);
        TextView Dato4 = findViewById(R.id.procesador4);

        setPcReservado(Dato1.getText().toString(), Dato2.getText().toString(), Dato3.getText().toString(), Dato4.getText().toString());
    }

    public void getCard5(View view) {
        TextView Dato1 = findViewById(R.id.marca5);
        TextView Dato2 = findViewById(R.id.s_o5);
        TextView Dato3 = findViewById(R.id.memoria5);
        TextView Dato4 = findViewById(R.id.procesador5);

        setPcReservado(Dato1.getText().toString(), Dato2.getText().toString(), Dato3.getText().toString(), Dato4.getText().toString());
    }

    public void Home(View v) {
        Intent acc = new Intent(v.getContext(), PaginaPrincipal.class);
        v.getContext().startActivity(acc);
    }
}
