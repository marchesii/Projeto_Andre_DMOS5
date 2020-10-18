package com.example.projetolol.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetolol.R;
import com.example.projetolol.constants.Constantes;
import com.example.projetolol.dao.PartidaDAO;
import com.example.projetolol.dao.PerfilDAO;
import com.example.projetolol.model.Partida;
import com.example.projetolol.model.Perfil;

import java.util.List;

public class Historico_Activity extends AppCompatActivity {

    private RecyclerView partidas;
    private TextView semdados_TextView;
    private PartidasAdapter madapter;
    private Perfil mPerfil;
    private PerfilDAO mPerfilDAO;
    private PartidaDAO mPartidaDAO;
    private List<Partida> mPartidasList;
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico);

        setLayoutElements();
        getValuesElements();
        updateUI();
    }

    private void getValuesElements() {
        Bundle bundle = getIntent().getExtras();
        id = bundle.get(Constantes.KEY_PERFIL).toString();
        mPartidasList = mPartidaDAO.allBySumonner(id);
    }

    private void setLayoutElements() {
        partidas = findViewById(R.id.recycler_view_historico_partidas);
        semdados_TextView = findViewById(R.id.text_semdados);

        Bundle bundle = getIntent().getExtras();
        mPerfilDAO = new PerfilDAO(this);
        mPartidaDAO = new PartidaDAO(this);

        if(bundle != null){
            mPerfil = mPerfilDAO.getPerfil(bundle.get(Constantes.KEY_PERFIL).toString());
        }
    }

    private void updateUI(){
        if(mPartidasList != null){
            if(semdados_TextView.getVisibility() == View.VISIBLE){
                semdados_TextView.setVisibility(View.INVISIBLE);
            }
            madapter = new PartidasAdapter(mPartidasList);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
            partidas.setLayoutManager(layoutManager);
            partidas.setAdapter(madapter);

        } else {
            semdados_TextView.setVisibility(View.VISIBLE);
            if(partidas.getVisibility() == View.VISIBLE){
                partidas.setVisibility(View.INVISIBLE);
            }
        }
    }
}