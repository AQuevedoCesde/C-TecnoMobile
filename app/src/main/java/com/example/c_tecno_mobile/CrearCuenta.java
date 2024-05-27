package com.example.c_tecno_mobile;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;//importar
import com.google.firebase.database.FirebaseDatabase;//imprtar

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
public class CrearCuenta extends AppCompatActivity {

EditText rnombre;
EditText rapellidos;
EditText rprograma;
EditText rTelefono;
EditText rcorreo;
EditText rcontrasena;
Button btn_registrar;
FirebaseAuth mAuth;
DatabaseReference refe;

    private  String autnombre;
    private  String autapellidos;
    private  String autprograma;
    private  String auttelefono;
    private  String autcorreo;
    private  String autcontrasena;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_crear_cuenta);

        mAuth=FirebaseAuth.getInstance();
        refe = FirebaseDatabase.getInstance().getReference();

        rnombre = findViewById(R.id.txtNombre);
        rapellidos = findViewById(R.id.txtApellidos);
        rprograma = findViewById(R.id.txtPrograma);
        rTelefono = findViewById(R.id.txtTelefono);
        rcorreo = findViewById(R.id.txtEmail);
        rcontrasena = findViewById(R.id.txtPassOne);
        btn_registrar = findViewById(R.id.btnRegistrar);

        btn_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                autnombre = rnombre.getText().toString().trim();
                autapellidos = rapellidos.getText().toString().trim();
                autprograma = rprograma.getText().toString().trim();
                auttelefono = rTelefono.getText().toString().trim();
                autcorreo = rcorreo.getText().toString().trim();
                autcontrasena = rcontrasena.getText().toString().trim();

                if (!autnombre.isEmpty() && !autapellidos.isEmpty() && !autcorreo.isEmpty() && !autcontrasena.isEmpty() && !autprograma.isEmpty() && !auttelefono.isEmpty()){
                    if (autcontrasena.length()>=6){
                        registaruser();
                    }
                    else{
                        Toast.makeText(CrearCuenta.this, "La contraseña debe tener al menos 6 caracteres", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(CrearCuenta.this, "Debe completar los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private  void registaruser (){
        mAuth.createUserWithEmailAndPassword(autcorreo,autcontrasena).addOnCompleteListener(new OnCompleteListener<AuthResult>() {

            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){
                    Map<String,Object> map = new HashMap<>();
                    map.put("Nombre", autnombre);
                    map.put("Apellidos", autapellidos);
                    map.put("Programa", autprograma);
                    map.put("Telefono", auttelefono);
                    map.put("Correo", autcorreo);
                    map.put("Contraseña", autcontrasena);

                    String id = mAuth.getCurrentUser().getUid();
                    refe.child("Usuarios").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task2) {
                            if(task2.isSuccessful()){
                                Intent intent = new Intent(CrearCuenta.this, Login.class);
                                startActivity(intent);
                                finish();
                                Toast.makeText(CrearCuenta.this,"Registro Exitoso",Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Toast.makeText(CrearCuenta.this, "No se crearon los datos correctamente", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });

                }
                else{
                    Toast.makeText(CrearCuenta.this, "No se puede registar el usurio", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}






