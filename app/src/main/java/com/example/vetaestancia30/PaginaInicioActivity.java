package com.example.vetaestancia30;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PaginaInicioActivity extends AppCompatActivity {

    Spinner spinner;
    String select;
    Button btnBusca;
    private ListView list;
    AdaptadorUsu adaptadorUsu;
    Users usu;
    public static ArrayList<Users>users=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_inicio);
        spinner = (Spinner)findViewById(R.id.spinner2);
        btnBusca = (Button)findViewById(R.id.btnBuscar);

        list=findViewById(R.id.ListView);
        adaptadorUsu=new AdaptadorUsu(this,users);
        list.setAdapter(adaptadorUsu);



        String [] opc = {"Clientes","Productos","Usuarios","Ventas","Categorias","Nada"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,opc);
        spinner.setAdapter(adapter);

        btnBusca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                select = spinner.getSelectedItem().toString();
                if(select.equals("Clientes")){
                    buscar("http://192.168.100.14/Android/tipoReporte.php");

                }else if(select.equals("Productos")){
                    buscar("http://192.168.100.14/Android/tipoReporte.php");

                } else if(select.equals("Usuarios")){
                    buscar("http://192.168.100.14/Android/tipoReporte.php");
                }else if(select.equals("Ventas")){
                    buscar("http://192.168.100.14/Android/tipoReporte.php");
                }else if(select.equals("Categorias")){
                    buscar("http://192.168.100.14/Android/tipoReporte.php");
                }


            }
        });


    }


    private void buscar(String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                users.clear();
                try {
                    JSONObject jsonObject= new JSONObject(response);
                    String succes=jsonObject.getString("succes");

                    JSONArray jsonArray=jsonObject.getJSONArray("datos");
                    if (succes.equals("1")){
                        for (int i=0;i<jsonArray.length();i++){
                            JSONObject object=jsonArray.getJSONObject(i);
                            String id =object.getString("id");
                            String nombre =object.getString("nombre");
                            String usuario =object.getString("usuario");
                            String password =object.getString("password");
                            String perfil =object.getString("perfil");
                            String foto =object.getString("foto");
                            String estado =object.getString("estado");
                            String uLogin =object.getString("ultimo_login");
                            String fecha =object.getString("fecha");

                            usu= new Users(id,nombre,usuario,password,perfil,foto,estado,uLogin,fecha);

                            users.add(usu);
                            adaptadorUsu.notifyDataSetChanged();


                        }
                    }
                }catch (JSONException e){
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("--------------------------");
                System.out.println("cai aki");
                System.out.println(error.toString());
                System.out.println("__________________________");
                Toast.makeText(PaginaInicioActivity.this,error.toString(),Toast.LENGTH_SHORT).show();

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                String sele;
                sele=spinner.getSelectedItem().toString();
                Map<String,String> parametros = new HashMap<String, String>();
                parametros.put("tabla",spinner.getSelectedItem().toString());
                //parametros.put("password",edtPassword.getText().toString());
                return parametros;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }
}