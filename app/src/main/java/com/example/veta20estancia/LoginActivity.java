package com.example.veta20estancia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    Button btnRegistro,btniniciaSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnRegistro=(Button)findViewById(R.id.buttonRegistrarse);
        btniniciaSesion=(Button)findViewById(R.id.buttonIngresar);

        btniniciaSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //validaUsuario();
                startActivity(new Intent(LoginActivity.this,InicioReporte.class));
            }
        });


        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //addUsuario();
                startActivity(new Intent(LoginActivity.this,MainActivity.class));
            }
        });
    }


    public void validaUsuario(){
        MainActivity main = new MainActivity();
        main.conexionBd();
    }
}