package com.example.vetaestancia30;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class AdaptadorVentas extends ArrayAdapter<Ventas> {

    Context context;
    List<Ventas> listVentas;

    public AdaptadorVentas(@NonNull Context context, List<Ventas>listVentas) {
        super(context,R.layout.my_list_item, listVentas);

        this.context=context;
        this.listVentas=listVentas;

    }

    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_list_item,null,true);
        TextView tvid=view.findViewById(R.id.tvid);
        TextView tvnombre=view.findViewById(R.id.tvnombre);

        tvid.setText(listVentas.get(position).getId());
        tvnombre.setText(listVentas.get(position).getProductos());
        return view;
    }
}
