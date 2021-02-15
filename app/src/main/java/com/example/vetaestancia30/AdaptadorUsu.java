package com.example.vetaestancia30;

import android.content.Context;
import android.widget.ArrayAdapter;

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
}
