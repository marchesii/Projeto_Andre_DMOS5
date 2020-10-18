package com.example.projetolol.activities;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetolol.R;
import com.example.projetolol.constants.Constantes;
import com.example.projetolol.dao.PerfilDAO;
import com.example.projetolol.model.Perfil;

public class Historico_Activity extends AppCompatActivity {

    private RecyclerView partidas;
    private TextView semdados_TextView;
    private PartidasAdapter madapter;
    private Perfil mPerfil;
    private PerfilDAO mPerfilDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico);

        setLayoutElements();
        //TODO Acabar isso aqui
    }

    private void setLayoutElements() {

        Bundle bundle = getIntent().getExtras();
        mPerfilDAO = new PerfilDAO(this);

        if(bundle != null){
            mPerfil = mPerfilDAO.getPerfil(bundle.get(Constantes.KEY_PERFIL).toString());
        }
    }
}