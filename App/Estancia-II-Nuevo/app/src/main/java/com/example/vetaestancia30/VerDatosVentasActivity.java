package com.example.vetaestancia30;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class VerDatosVentasActivity extends AppCompatActivity {
    TextView codigo,productos,impuesto,total,metoPago,fechaV;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_datos_ventas);
        codigo=(TextView)findViewById(R.id.textViewCodigoVen);
        productos=(TextView)findViewById(R.id.textViewProductos);
        impuesto=(TextView)findViewById(R.id.textViewImpuesto);
        total=(TextView)findViewById(R.id.textViewTotal);
        metoPago=(TextView)findViewById(R.id.textViewMetododePago);
        fechaV=(TextView)findViewById(R.id.textViewFechaVe);

        Intent intent = getIntent();
        position= intent.getExtras().getInt("position");

        codigo.setText("CODIGO: "+PaginaInicioActivity.Ventas.get(position).getCodigo());
        productos.setText("PRODUCTOS: "+PaginaInicioActivity.Ventas.get(position).getProductos());
        impuesto.setText("IMPUESTO: "+PaginaInicioActivity.Ventas.get(position).getImpuestos());
        total.setText("TOTAL: "+PaginaInicioActivity.Ventas.get(position).getTotal());
        metoPago.setText("METODO DE PAGO: "+PaginaInicioActivity.Ventas.get(position).getMetodo_pago());
        fechaV.setText("FECHA DE LA VENTA: "+PaginaInicioActivity.Ventas.get(position).getCodigo());
    }
}