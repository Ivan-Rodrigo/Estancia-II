package com.example.vetaestancia30;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class AdaptadorProdu extends ArrayAdapter<Products> {

    Context context;
    List<Products> listaProduc;

    public AdaptadorProdu(@NonNull Context context, List<Products>listaProduc) {
        super(context,R.layout.my_list_item, listaProduc);

        this.context=context;
        this.listaProduc=listaProduc;

    }

    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_list_item,null,true);
        TextView tvid=view.findViewById(R.id.tvid);
        TextView tvnombre=view.findViewById(R.id.tvnombre);

        tvid.setText(listaProduc.get(position).getId());
        tvnombre.setText(listaProduc.get(position).getDescripcion());
        return view;
    }
}
