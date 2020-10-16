package com.example.projetolol.activities;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetolol.R;
import com.example.projetolol.model.Campeao;

import java.util.List;

public class PoolAdapter extends RecyclerView.Adapter<PoolAdapter.ViewHolder>{

    private List<Campeao> mCampeaoList;

    public PoolAdapter (List<Campeao> repositorio) {
        this.mCampeaoList = repositorio;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView nomeCampeaoTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nomeCampeaoTextView = itemView.findViewById(R.id.textview_nome_campeao);
        }
    }
}
