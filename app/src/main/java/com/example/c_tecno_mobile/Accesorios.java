package com.example.c_tecno_mobile;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Accesorios extends AppCompatActivity {

    CardView salon;

    Cartas Accesorio = new Cartas();
    Reservas accesorioReservado = new Reservas();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_accesorios);

    }
    public void cardPc (View v) {
        Intent intent = new Intent(v.getContext(), Computadores.class);
        v.getContext().startActivity(intent);
    }

    public void cardSalones(View v) {
        Intent intent = new Intent(v.getContext(), Salones.class);
        v.getContext().startActivity(intent);
    }

    public void Borar(View v) {
        TextView pcreservado = (TextView) findViewById(R.id.InfResPc);
        pcreservado.setText("");
    }

    public void TerminarReserva(View v) {
        if ( accesorioReservado.getComputador().isEmpty() ) {
            Toast.makeText(Accesorios.this, "Ingresa el accesorio " +
                    "que deseas reservar", Toast.LENGTH_LONG).show();
        } else {
            Intent intent = new Intent(v.getContext(), Reserva.class);
            v.getContext().startActivity(intent);
        }
    }

    public void getAcce1(View view) {
        //valores variables
        TextView Dato1 = (TextView) findViewById(R.id.accName1);
        TextView Dato2 = (TextView) findViewById(R.id.cone1);
        TextView Dato3 = (TextView) findViewById(R.id.mark1);
        TextView Dato4 = (TextView) findViewById(R.id.color1);

        //Funcionalidad estatica
        TextView accReservado = (TextView) findViewById(R.id.InfResPc);
        Accesorio.cartas(Dato1.getText().toString(), Dato2.getText().toString(),
                Dato3.getText().toString(),Dato4.getText().toString());
        accReservado.setText(Accesorio.Dato1 + "\n" + Accesorio.Dato2 + "\n" +
                Accesorio.Dato3 + "\n" + Accesorio.Dato4);
    }

    public void getAcce2(View view) {
        //valores variables
        TextView Dato1 = (TextView) findViewById(R.id.accName2);
        TextView Dato2 = (TextView) findViewById(R.id.cone2);
        TextView Dato3 = (TextView) findViewById(R.id.mark2);
        TextView Dato4 = (TextView) findViewById(R.id.color2);

        //Funcionalidad estatica
        TextView accReservado = (TextView) findViewById(R.id.InfResPc);
        Accesorio.cartas(Dato1.getText().toString(), Dato2.getText().toString(),
                Dato3.getText().toString(),Dato4.getText().toString());
        accReservado.setText(Accesorio.Dato1 + "\n" + Accesorio.Dato2 + "\n" +
                Accesorio.Dato3 + "\n" + Accesorio.Dato4);
    }

    public void getAcce3(View view) {
        //valores variables
        TextView Dato1 = (TextView) findViewById(R.id.accName3);
        TextView Dato2 = (TextView) findViewById(R.id.cone3);
        TextView Dato3 = (TextView) findViewById(R.id.mark3);
        TextView Dato4 = (TextView) findViewById(R.id.color3);

        //Funcionalidad estatica
        TextView accReservado = (TextView) findViewById(R.id.InfResPc);
        Accesorio.cartas(Dato1.getText().toString(), Dato2.getText().toString(),
                Dato3.getText().toString(),Dato4.getText().toString());
        accReservado.setText(Accesorio.Dato1 + "\n" + Accesorio.Dato2 + "\n" +
                Accesorio.Dato3 + "\n" + Accesorio.Dato4);
    }

    public void getAcce4(View view) {
        //valores variables
        TextView Dato1 = (TextView) findViewById(R.id.accName4);
        TextView Dato2 = (TextView) findViewById(R.id.cone4);
        TextView Dato3 = (TextView) findViewById(R.id.mark4);
        TextView Dato4 = (TextView) findViewById(R.id.color4);

        //Funcionalidad estatica
        TextView accReservado = (TextView) findViewById(R.id.InfResPc);
        Accesorio.cartas(Dato1.getText().toString(), Dato2.getText().toString(),
                Dato3.getText().toString(),Dato4.getText().toString());
        accReservado.setText(Accesorio.Dato1 + "\n" + Accesorio.Dato2 + "\n" +
                Accesorio.Dato3 + "\n" + Accesorio.Dato4);
    }

    public void getAcce5(View view) {
        //valores variables
        TextView Dato1 = (TextView) findViewById(R.id.accName5);
        TextView Dato2 = (TextView) findViewById(R.id.cone5);
        TextView Dato3 = (TextView) findViewById(R.id.mark5);
        TextView Dato4 = (TextView) findViewById(R.id.color5);

        //Funcionalidad estatica
        TextView accReservado = (TextView) findViewById(R.id.InfResPc);
        Accesorio.cartas(Dato1.getText().toString(), Dato2.getText().toString(),
                Dato3.getText().toString(),Dato4.getText().toString());
        accReservado.setText(Accesorio.Dato1 + "\n" + Accesorio.Dato2 + "\n" +
                Accesorio.Dato3 + "\n" + Accesorio.Dato4);
    }


}