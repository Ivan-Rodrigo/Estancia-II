package com.example.vetaestancia30;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class AddClientesActivity extends AppCompatActivity {
    EditText nombre,documento,email,telefono,direccion,fechaNa,fechaAdd;
    Button agregar;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_clientes);
        nombre=(EditText)findViewById(R.id.edtNombrecli);
        documento=(EditText)findViewById(R.id.edtDocumento);
        email=(EditText)findViewById(R.id.edtEmailCli);
        telefono=(EditText)findViewById(R.id.edtTelefono);
        direccion=(EditText)findViewById(R.id.edtDireccion);
        fechaNa=(EditText)findViewById(R.id.edtfechaNa);
        fechaAdd=(EditText)findViewById(R.id.edtFechaAdd);
        agregar=(Button)findViewById(R.id.btnAgregarClient);

        LocalDate fecha =  LocalDate.now();
        LocalTime hora = LocalTime.now();
        String ho= hora.toString();
        String fe= fecha.toString();

        fechaAdd.setText(fe+":"+ho);
        fechaAdd.setEnabled(false);
        fechaNa.setText("AAAA-MM-DD");
        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddClients("http://192.168.8.3/Android/addClientes.php");
            }
        });
    }


    private void AddClients(String URL){
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Cargando....");
        progressDialog.show();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if(!response.isEmpty()){
                    Toast.makeText(AddClientesActivity.this, response, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),PaginaInicioActivity.class);
                    startActivity(intent);
                    finish();
                    progressDialog.dismiss();
                }else {
                    Toast.makeText(AddClientesActivity.this,"Algo Salio mal",Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("--------------------------");
                System.out.println("cai aki");
                System.out.println(error.toString());
                System.out.println("__________________________");
                Toast.makeText(AddClientesActivity.this,error.toString(),Toast.LENGTH_SHORT).show();

            }
        }){
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                String compra="0";
                String ventas="17-11-21";
               // String cate=String.valueOf(spinner.getSelectedItemPosition()+1);
                Map<String,String> parametros = new HashMap<String, String>();
                parametros.put("nombre",nombre.getText().toString());
                parametros.put("documento",documento.getText().toString());
                parametros.put("email",email.getText().toString());
                parametros.put("telefono",telefono.getText().toString());
                parametros.put("direccion",direccion.getText().toString());
                parametros.put("fecha_nacimiento",fechaNa.getText().toString());
                parametros.put("compras",compra);
                parametros.put("ultima_compra",ventas);
                parametros.put("fecha",fechaAdd.getText().toString());
                return parametros;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
}