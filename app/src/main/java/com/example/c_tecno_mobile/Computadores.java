package com.example.c_tecno_mobile;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import org.w3c.dom.Document;

import java.util.Objects;

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
        Intent intent = new Intent(v.getContext(), Salones.class);
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
        if ( pcReservado.getComputador().isEmpty() ) {
            Toast.makeText(Computadores.this, "Ingresa el computador " +
                    "que deseas reservar", Toast.LENGTH_LONG).show();
        } else {
            Intent intent = new Intent(v.getContext(), Reserva.class);
            v.getContext().startActivity(intent);
        }
    }

 /// Funcionalidad de los botones
    public void getCard1(View view) {
        //valores variables
        TextView Dato1 = (TextView) findViewById(R.id.marca1);
        TextView Dato2 = (TextView) findViewById(R.id.s_o1);
        TextView Dato3 = (TextView) findViewById(R.id.memoria1);
        TextView Dato4 = (TextView) findViewById(R.id.procesador1);


        //Funcionalidad estatica
        TextView pcreservado = (TextView) findViewById(R.id.InfResPc);
        pc.cartas(Dato1.getText().toString(),Dato2.getText().toString(),
                Dato3.getText().toString(),Dato4.getText().toString());
        pcreservado.setText(pc.Dato1 + "\n" + pc.Dato2 + "\n" + pc.Dato3
                + "\n" + pc.Dato4 );
    }




    public void getCard2(View view) {
        //valores variables
        TextView Dato1 = (TextView) findViewById(R.id.marca2);
        TextView Dato2 = (TextView) findViewById(R.id.s_o2);
        TextView Dato3 = (TextView) findViewById(R.id.memoria2);
        TextView Dato4 = (TextView) findViewById(R.id.procesador2);

        //Funcionalidad estatica
        TextView pcreservado = (TextView) findViewById(R.id.InfResPc);
        pc.cartas(Dato1.getText().toString(),Dato2.getText().toString(),
                Dato3.getText().toString(),Dato4.getText().toString());
        pcreservado.setText(pc.Dato1 + "\n" + pc.Dato2 + "\n" + pc.Dato3
                + "\n" + pc.Dato4 );
    }

    public void getCard3(View view) {
        //valores variables
        TextView Dato1 = (TextView) findViewById(R.id.marca3);
        TextView Dato2 = (TextView) findViewById(R.id.s_o3);
        TextView Dato3 = (TextView) findViewById(R.id.memoria3);
        TextView Dato4 = (TextView) findViewById(R.id.procesador3);

        //Funcionalidad estatica
        TextView pcreservado = (TextView) findViewById(R.id.InfResPc);
        pc.cartas(Dato1.getText().toString(),Dato2.getText().toString(),
                Dato3.getText().toString(),Dato4.getText().toString());
        pcreservado.setText(pc.Dato1 + "\n" + pc.Dato2 + "\n" + pc.Dato3
                + "\n" + pc.Dato4 );
    }

    public void getCard4(View view) {
        //valores variables
        TextView Dato1 = (TextView) findViewById(R.id.marca4);
        TextView Dato2 = (TextView) findViewById(R.id.s_o4);
        TextView Dato3 = (TextView) findViewById(R.id.memoria4);
        TextView Dato4 = (TextView) findViewById(R.id.procesador4);

        //Funcionalidad estatica
        TextView pcreservado = (TextView) findViewById(R.id.InfResPc);
        pc.cartas(Dato1.getText().toString(),Dato2.getText().toString(),
                Dato3.getText().toString(),Dato4.getText().toString());
        pcreservado.setText(pc.Dato1 + "\n" + pc.Dato2 + "\n" + pc.Dato3
                + "\n" + pc.Dato4 );
    }
    public void getCard5(View view) {
        //valores variables
        TextView Dato1 = (TextView) findViewById(R.id.marca5);
        TextView Dato2 = (TextView) findViewById(R.id.s_o5);
        TextView Dato3 = (TextView) findViewById(R.id.memoria5);
        TextView Dato4 = (TextView) findViewById(R.id.procesador5);

        //Funcionalidad estatica
        TextView pcreservado = (TextView) findViewById(R.id.InfResPc);
        pc.cartas(Dato1.getText().toString(),Dato2.getText().toString(),
                Dato3.getText().toString(),Dato4.getText().toString());
        pcreservado.setText(pc.Dato1 + "\n" + pc.Dato2 + "\n" + pc.Dato3
                + "\n" + pc.Dato4 );
    }


    }




