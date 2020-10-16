package com.example.projetolol.activities;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetolol.R;

public class Historico_Activity extends AppCompatActivity {

    private RecyclerView partidas;
    private TextView semdados_TextView;
    private PartidasAdapter madapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico);
    }
}