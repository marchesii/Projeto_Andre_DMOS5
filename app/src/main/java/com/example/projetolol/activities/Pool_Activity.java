package com.example.projetolol.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projetolol.R;
import com.example.projetolol.constants.Constantes;
import com.example.projetolol.dao.PerfilDAO;
import com.example.projetolol.model.Perfil;

public class Pool_Activity extends AppCompatActivity {
    private Perfil mPerfil;
    private PerfilDAO mPerfilDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pool);


        setLayoutElements();
    }

    private void setLayoutElements() {

        Bundle bundle = getIntent().getExtras();
        mPerfilDAO = new PerfilDAO(this);

        if(bundle != null){
            mPerfil = mPerfilDAO.getPerfil(bundle.get(Constantes.KEY_PERFIL).toString());
        }
    }
}