package com.example.vetaestancia30;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class VerDatosUsersActivity extends AppCompatActivity {
    TextView id,nom,usu,estado,ultLog,perfil;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_datos_users);

        id=(TextView)findViewById(R.id.textViewId);
        nom=(TextView)findViewById(R.id.textViewNombre);
        usu=(TextView)findViewById(R.id.textViewUsuario);
        ultLog=(TextView)findViewById(R.id.textViewUltLo);
        estado=(TextView)findViewById(R.id.textViewEstado);
        perfil=(TextView)findViewById(R.id.textViewPerfil);

        Intent intent = getIntent();
        position= intent.getExtras().getInt("position");

        id.setText("ID: "+PaginaInicioActivity.users.get(position).getId());
        nom.setText("NOMBRE: "+PaginaInicioActivity.users.get(position).getNombre());
        usu.setText("USUARIO: "+PaginaInicioActivity.users.get(position).getUsuario());
        estado.setText("ESTADO: "+PaginaInicioActivity.users.get(position).getEstado());
        perfil.setText("PERFIL: "+PaginaInicioActivity.users.get(position).getPerfil());
        ultLog.setText("ULTIMO LOGIN: "+PaginaInicioActivity.users.get(position).getuLogin());

    }
}