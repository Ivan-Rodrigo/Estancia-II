package com.example.vetaestancia30;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class AdaptadorClien extends ArrayAdapter<Clientes> {

    Context context;
    List<Clientes> listaClientes;

    public AdaptadorClien(@NonNull Context context, List<Clientes>listaClientes) {
        super(context,R.layout.my_list_item, listaClientes);

        this.context=context;
        this.listaClientes=listaClientes;

    }

    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_list_item,null,true);
        TextView tvid=view.findViewById(R.id.tvid);
        TextView tvnombre=view.findViewById(R.id.tvnombre);

        tvid.setText(listaClientes.get(position).getId());
        tvnombre.setText(listaClientes.get(position).getNombre());
        return view;
    }
}
