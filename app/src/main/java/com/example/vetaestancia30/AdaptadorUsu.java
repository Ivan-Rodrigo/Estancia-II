package com.example.vetaestancia30;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class AdaptadorUsu extends ArrayAdapter<Users> {

    Context context;
    List<Users>listaUsers;

    public AdaptadorUsu(@NonNull Context context, List<Users>listaUsers) {
        super(context,R.layout.my_list_item, listaUsers);

        this.context=context;
        this.listaUsers=listaUsers;

    }

    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_list_item,null,true);
        TextView tvid=view.findViewById(R.id.tvid);
        TextView tvnombre=view.findViewById(R.id.tvnombre);

        tvid.setText(listaUsers.get(position).getId());
        tvnombre.setText(listaUsers.get(position).getNombre());
        return view;
    }

}
