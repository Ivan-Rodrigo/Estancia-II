package com.example.vetaestancia30;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class VerDatosProductosActivity extends AppCompatActivity {
    TextView codigo,desc,stock,precioVen,ventas,fecha;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_datos_productos);

        codigo=(TextView)findViewById(R.id.textViewCodigo);
        desc=(TextView)findViewById(R.id.textViewDescripcion);
        stock=(TextView)findViewById(R.id.textViewStock);
        precioVen=(TextView)findViewById(R.id.textViewPrecioVenta);
        ventas=(TextView)findViewById(R.id.textViewVentas);
        fecha=(TextView)findViewById(R.id.textViewFecha);

        Intent intent = getIntent();
        position= intent.getExtras().getInt("position");
        codigo.setText("CODIGO: "+PaginaInicioActivity.products.get(position).getCodigo());
        desc.setText("DESCRIPCION: "+PaginaInicioActivity.products.get(position).getDescripcion());
        stock.setText("STOCK: "+PaginaInicioActivity.products.get(position).getStock());
        precioVen.setText("PRECIO DE VENTA: "+PaginaInicioActivity.products.get(position).getPrecio_venta());
        ventas.setText("VENTAS: "+PaginaInicioActivity.products.get(position).getVentas());
        fecha.setText("FECHA DE INGRESO: "+PaginaInicioActivity.products.get(position).getFecha());
    }
}