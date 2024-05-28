package com.example.c_tecno_mobile;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
public class CrearCuenta extends AppCompatActivity {

    FirebaseAuth mAuth;
    private static final String NOMBREUSUARIO = "nombre" ;
    private static final String APELLIDOUSUARIO = "apellido" ;
    private static final String PROGRAMAUSUARIO = "programa" ;
    private static final String TELEFONOUSUARIO = "telefono" ;
    private static final String EMAILUSUARIO = "email" ;
    private static final String CONTRAUSUARIO = "contrasena" ;
    private static final String TAG = "Inspirinquote" ;
    String randomId = java.util.UUID.randomUUID().toString();
    private DocumentReference firebaseReferencia = FirebaseFirestore.getInstance().collection("usuarios").document(randomId);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_crear_cuenta);
    }

    public void registrar(View view) {
        EditText viewnombre =  (EditText) findViewById(R.id.txtNombre);
        EditText viewapellido =  (EditText) findViewById(R.id.txtApellidos);
        EditText viewprograma =  (EditText) findViewById(R.id.txtPrograma);
        EditText viewtelefono =  (EditText) findViewById(R.id.txtTelefono);
        EditText viewemail =  (EditText) findViewById(R.id.txtEmail);
        EditText viewcontrasena =  (EditText) findViewById(R.id.txtPassOne);

        String txNombre = viewnombre.getText().toString();
        String txApellido = viewapellido.getText().toString();
        String txPrograma = viewprograma.getText().toString();
        String txTelefono = viewtelefono.getText().toString();
        String txEmail = viewemail.getText().toString();
        String txContrasena = viewcontrasena.getText().toString();

        if (txNombre.isEmpty() || txApellido.isEmpty()||txPrograma.isEmpty()||txTelefono.isEmpty()
                    ||txEmail.isEmpty()||txContrasena.isEmpty()){Toast.makeText(CrearCuenta.this, " Llene los campos vacios",
                Toast.LENGTH_SHORT).show();;}
        if (txContrasena.length()<6){
            Toast.makeText(CrearCuenta.this, "La contraseña debe tener al menos 6 caracteres",
                    Toast.LENGTH_SHORT).show();
        }

        Map<String,Object> datosUsuario = new HashMap<>();
        datosUsuario.put(NOMBREUSUARIO, txNombre);
        datosUsuario.put(APELLIDOUSUARIO,txApellido);
        datosUsuario.put(PROGRAMAUSUARIO,txPrograma);
        datosUsuario.put(TELEFONOUSUARIO,txTelefono);
        datosUsuario.put(EMAILUSUARIO,txEmail);
        datosUsuario.put(CONTRAUSUARIO,txContrasena);

        firebaseReferencia.set(datosUsuario).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                mAuth.createUserWithEmailAndPassword(txEmail,txContrasena);
                Toast.makeText(CrearCuenta.this, "Creado Correctamente",
                        Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(CrearCuenta.this, "Error en la creacion ",
                        Toast.LENGTH_SHORT).show();
            }
        });



    }

}






