package com.example.vetaestancia30;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class EditarProductosActivity extends AppCompatActivity {
    EditText  codigo,descripcion,stock,precioV,precioCo;
    Button editar;
    Spinner idCateEd;
    int position;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_productos);

        codigo=(EditText)findViewById(R.id.edtcodigo);
        descripcion=(EditText)findViewById(R.id.edtdescripcion);
        stock=(EditText)findViewById(R.id.edtstock);
        precioV=(EditText)findViewById(R.id.edtprecioventa);
        precioCo=(EditText)findViewById(R.id.edtprecioCompra);
        editar=(Button)findViewById(R.id.btnEditarProd);
        idCateEd=(Spinner)findViewById(R.id.spicategoria);

        String [] opc = {"Kit de Videovigilancia","ACCESORIOS VIDEOVIGILANCIA",
                "Cables","Activos Redes","Pasivo Redes","Telefonia","SERVICIO","CAMARAS ANALOGAS Y DIGITALES","ENERGIA SEGURIDAD"
                ,"INTERFONOS Y VIDEOPORTEROS","SOFTWARE","ACCESORIOS DE COMPUTO","CAMARAS IP"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,opc);
        idCateEd.setAdapter(adapter);
        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");

        codigo.setText(PaginaInicioActivity.products.get(position).getCodigo());
        descripcion.setText(PaginaInicioActivity.products.get(position).getDescripcion());
        stock.setText(PaginaInicioActivity.products.get(position).getStock());
        precioV.setText(PaginaInicioActivity.products.get(position).getPrecio_venta());
        precioCo.setText(PaginaInicioActivity.products.get(position).getPrecio_compa());
        id=PaginaInicioActivity.products.get(position).getId();

        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditProducto("http://192.168.8.3/Android/updateProdcts.php");
            }
        });



    }



    private void EditProducto(String URL){

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Cargando....");
        progressDialog.show();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println(response);

                if(!response.isEmpty()){
                    Toast.makeText(EditarProductosActivity.this, response, Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),PaginaInicioActivity.class));
                    finish();
                    progressDialog.dismiss();
                }else {
                    Toast.makeText(EditarProductosActivity.this,"Algo Salio mal",Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("--------------------------");
                System.out.println("cai aki");
                System.out.println(error.toString());
                System.out.println("__________________________");
                Toast.makeText(EditarProductosActivity.this,error.toString(),Toast.LENGTH_SHORT).show();

            }
        }){
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                String ima="Hola";
                String ventas="0";
                String cate=String.valueOf(idCateEd.getSelectedItemPosition()+1);
                Map<String,String> parametros = new HashMap<String, String>();
                parametros.put("id_categoria",cate);
                parametros.put("codigo",codigo.getText().toString());
                parametros.put("descripcion",descripcion.getText().toString());

                parametros.put("stock",stock.getText().toString());
                parametros.put("precio_compra",precioCo.getText().toString());
                parametros.put("precio_venta",precioV.getText().toString());
                parametros.put("id",id);

                //parametros.put("fecha",edtfecha.getText().toString());
                return parametros;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }


}