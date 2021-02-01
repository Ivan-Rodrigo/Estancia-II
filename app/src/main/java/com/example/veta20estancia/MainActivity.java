package com.example.veta20estancia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MainActivity extends AppCompatActivity {

    EditText edtnombre,edtCorreo,edtpassword;
    Button btnAgregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtnombre=(EditText)findViewById(R.id.edtNombre);
        edtCorreo=(EditText)findViewById(R.id.edtCorreo);
        edtpassword=(EditText)findViewById(R.id.edtPassword);
        btnAgregar=(Button)findViewById(R.id.btnAgregarUsuario);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //addUsuario();
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
            }
        });
    }

    public Connection conexionBd(){
        Connection conn = null;
        try {
            StrictMode.ThreadPolicy policy= new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            conn= DriverManager.getConnection("jdbc:jtds:sqlserver://192.168.100.14:1433;databaseName=betaAndroid;user=sa;password=101513;");
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();

        }
        return conn;
    }

    public void addUsuario(){
        try {
            System.out.println(conexionBd());
            PreparedStatement pst=conexionBd().prepareStatement("insert into Usuario (Nombre,Correo,Contrasena) values(?,?,?)");
            pst.setString(1,edtnombre.getText().toString());
            pst.setString(2,edtCorreo.getText().toString());
            pst.setString(3,edtpassword.getText().toString());
            pst.executeUpdate();
            Toast.makeText(getApplicationContext(),"Usuario Agregado Exitosamente",Toast.LENGTH_SHORT).show();


        }catch (SQLException e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();

        }
    }
}