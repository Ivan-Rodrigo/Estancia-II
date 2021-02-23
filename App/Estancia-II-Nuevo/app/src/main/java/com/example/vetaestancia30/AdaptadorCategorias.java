package com.example.vetaestancia30;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class AdaptadorCategorias extends ArrayAdapter<Categoria> {

    Context context;
    List<Categoria> listaCaegorias;

    public AdaptadorCategorias(@NonNull Context context, List<Categoria>listaCaegorias) {
        super(context,R.layout.my_list_item, listaCaegorias);

        this.context=context;
        this.listaCaegorias=listaCaegorias;

    }

    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_list_item,null,true);
        TextView tvid=view.findViewById(R.id.tvid);
        TextView tvnombre=view.findViewById(R.id.tvnombre);

        tvid.setText(listaCaegorias.get(position).getId());
        tvnombre.setText(listaCaegorias.get(position).getCategori());
        return view;
    }
}
