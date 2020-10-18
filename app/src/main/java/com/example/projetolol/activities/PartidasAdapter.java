package com.example.projetolol.activities;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetolol.R;
import com.example.projetolol.model.Partida;

import java.util.List;

public class PartidasAdapter extends RecyclerView.Adapter<PartidasAdapter.ViewHolder> {

    private List<Partida> mPartidaList;

    public PartidasAdapter(List<Partida> mPartidasList) {
    }

    @NonNull
    @Override
    public PartidasAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull PartidasAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView kda_textview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            kda_textview= itemView.findViewById(R.id.textview_nome_kda);

        }
    }

}
