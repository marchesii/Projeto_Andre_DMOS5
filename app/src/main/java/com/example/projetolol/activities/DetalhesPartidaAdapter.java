package com.example.projetolol.activities;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetolol.R;
import com.example.projetolol.model.Participante;

import java.util.List;

public class DetalhesPartidaAdapter extends RecyclerView.Adapter<DetalhesPartidaAdapter.DetalhesPartidaViewHolder>{

    private List<Participante> mParticipanteList;

    DetalhesPartidaAdapter(List<Participante> participantes){
        this.mParticipanteList = participantes;
    }

    @NonNull
    @Override
    public DetalhesPartidaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull DetalhesPartidaViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class DetalhesPartidaViewHolder extends RecyclerView.ViewHolder{
        CardView cv;
        TextView kda_detalhes;
        ImageView champ_imagemView;
        ImageView lane_imagemView;

        DetalhesPartidaViewHolder(View itemView){
            super(itemView);
            cv = itemView.findViewById(R.id.cv);
            kda_detalhes = itemView.findViewById(R.id.detalhe_person_kda);
            champ_imagemView = itemView.findViewById(R.id.detalhe_champ_foto);
            lane_imagemView = itemView.findViewById(R.id.detalhe_lane_icon);

        }

    }



}
