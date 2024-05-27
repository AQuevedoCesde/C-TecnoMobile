package com.example.c_tecno_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Login extends AppCompatActivity {

    Button btnIngresar;
    EditText txtUser, txtPassword;
    TextView txtReguistrarse;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        txtUser = findViewById(R.id.txtUser);
        txtPassword = findViewById(R.id.txtPass);
        txtReguistrarse = findViewById(R.id.txtReguistrarse);
        btnIngresar = findViewById(R.id.btnIngresar);

        txtReguistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),CrearCuenta.class);
                v.getContext().startActivity(intent);
            }
        });

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = txtUser.getText().toString().trim();
                String password = txtPassword.getText().toString().trim();
                if(email.isEmpty()&& password.isEmpty()){
                    Toast.makeText(Login.this,"Ingresa los datos", Toast.LENGTH_SHORT).show();
                }else {
                    loginUser(email,password);
                }
            }
        });

    }

    private void loginUser(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            finish();
                            startActivity(new Intent(Login.this, PaginaPrincipal.class));
                            Toast.makeText(Login.this,"BIENVENIDO",Toast.LENGTH_SHORT).show();
                        } else {
// Si el inicio de sesión falla, mostrar un mensaje al usuario
                            Toast.makeText(Login.this, "Error al iniciar sesión: " +
                                    task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Login.this,"Error al iniciar sesión",Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void PasswordResert(View view) {

        if (TextUtils.isEmpty(txtUser.getText())){
            Toast.makeText(this,"Introduce un correo",Toast.LENGTH_LONG).show();
        }else{
            String email = txtUser.getText().toString();
            mAuth.sendPasswordResetEmail(email)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(getApplicationContext(),"Te hemos enviado un correo para recuperar tu cuenta",Toast.LENGTH_LONG).show();
                            }
                        }
                    });
        }
    }
}

