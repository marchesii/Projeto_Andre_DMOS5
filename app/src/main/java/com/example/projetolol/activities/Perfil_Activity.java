package com.example.projetolol.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projetolol.R;

public class Perfil_Activity extends AppCompatActivity implements View.OnClickListener {

    private TextView level_textView;
    private TextView win_textView;
    private TextView lose_textView;
    private TextView nick_textView;
    private TextView elo_textView;
    private Button historico_button;
    private Button pool_button;
    private Button att_button;
    private ImageView elo_image;
    private ImageView icon_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        setLayoutElementos();
    }

    private void setLayoutElementos() {
        level_textView = findViewById(R.id.textView_level);
        win_textView = findViewById(R.id.textView_win_count);
        lose_textView = findViewById(R.id.textView_lose_count);
        nick_textView = findViewById(R.id.nome_invocador_text);
        elo_textView = findViewById(R.id.textview_elo);
        historico_button = findViewById(R.id.button_History);
        pool_button = findViewById(R.id.button_Pool);
        att_button = findViewById(R.id.button_att);
        elo_image = findViewById(R.id.elo_icon);
        icon_image = findViewById(R.id.image_summoner_icon);

        //seta level
        //seta win
        //seta lose
        //seta nick
        //seta elo
        //seta elo imagem
        //seta icon image Picasso.get().load(Uri uri).into(icon_image);


        historico_button.setOnClickListener(this);
        pool_button.setOnClickListener(this);
        att_button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v == historico_button){
            //chama histórico
        }
        if(v == pool_button){
            //chama pool
        }
        if(v == att_button){
            atualizaDb();
            updateUi();
        }
    }

    private void updateUi() {

    }

    private void atualizaDb() {
        //chama Db com dados novos
    }
}