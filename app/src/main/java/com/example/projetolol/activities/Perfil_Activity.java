package com.example.projetolol.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projetolol.R;
import com.example.projetolol.api.RetrofitService;
import com.example.projetolol.constants.Constantes;
import com.example.projetolol.dao.LigaDAO;
import com.example.projetolol.dao.PerfilDAO;
import com.example.projetolol.model.Liga;
import com.example.projetolol.model.Perfil;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
    private Perfil mPerfil;
    private Liga mLiga;
    private List<Liga> mLigaList;
    private PerfilDAO mPerfilDAO;
    private LigaDAO mLigaDAO;
    private Retrofit mRetrofit;
    private Intent novoHistorico;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        mLigaDAO = new LigaDAO(this);
        mPerfilDAO = new PerfilDAO(this);

        setLayoutElementos();
        buscaLiga();
    }

    private void setValuesElementos() {

        //Procura Liga
        mLiga = mLigaDAO.getLiga(Constantes.KEY_SOLO_DUO, nick_textView.getText().toString());

        //seta level
        level_textView.setText(String.valueOf(mPerfil.getLevel()));
        //seta win
        win_textView.setText(String.valueOf(mLiga.getWins()));
        //seta lose
        lose_textView.setText(String.valueOf(mLiga.getLosses()));
        //seta elo
        elo_textView.setText(mLiga.getTier()+" " + mLiga.getRank());
        //seta elo imagem
        if(mLiga.getTier().equals("IRON")){
            elo_image.setImageResource(R.mipmap.iron_icon);
        } else {
            if(mLiga.getTier().equals("BRONZE")){
                elo_image.setImageResource(R.mipmap.bronze_icon);
            } else {
                if(mLiga.getTier().equals("SILVER")){
                    elo_image.setImageResource(R.mipmap.silver_icon);
                } else {
                    if(mLiga.getTier().equals("GOLD")){
                        elo_image.setImageResource(R.mipmap.gold_icon);
                    } else {
                        if(mLiga.getTier().equals("PLATINIUM")){
                            elo_image.setImageResource(R.mipmap.platinum_icon);
                        } else {
                            if(mLiga.getTier().equals("DIAMOND")){
                                elo_image.setImageResource(R.mipmap.diamante_icon);
                            }
                        }
                    }
                }
            }
        }
        //seta icon image Picasso.get().load(Uri uri).into(icon_image);
        Picasso.get().load(Constantes.KEY_LINK_ICON + mPerfil.getProfileIconId() + ".png").into(icon_image);

    }

    private void setLayoutElementos() {
        level_textView = findViewById(R.id.textView_level);
        win_textView = findViewById(R.id.textView_win_count);
        lose_textView = findViewById(R.id.textView_lose_count);
        nick_textView = findViewById(R.id.perfil_invocador_nome);
        elo_textView = findViewById(R.id.textview_elo);
        historico_button = findViewById(R.id.button_History);
        pool_button = findViewById(R.id.button_Pool);
        att_button = findViewById(R.id.button_att);
        elo_image = findViewById(R.id.elo_icon);
        icon_image = findViewById(R.id.image_summoner_icon);

        historico_button.setOnClickListener(this);
        pool_button.setOnClickListener(this);
        att_button.setOnClickListener(this);

        Bundle bundle = getIntent().getExtras();

        if(bundle != null){
            nick_textView.setText(bundle.get(Constantes.KEY_PERFIL).toString());
            if(nick_textView.getText().toString().length() > 10){
                nick_textView.setTextSize(20);
            }
        }
        mPerfil = mPerfilDAO.getPerfil(nick_textView.getText().toString());

    }

    @Override
    public void onClick(View v) {
        if(v == historico_button){
            //TODO chama histórico
            novoHistorico =  new Intent(this, Historico_Activity.class);
            novoHistorico.putExtra(Constantes.KEY_PERFIL, nick_textView.getText().toString());
            startActivity(novoHistorico);
        }
        if(v == pool_button){
            //TODO chama pool
        }
        if(v == att_button){
            atualizaDb();
            updateUi();
        }
    }

    private void updateUi() {
        //TODO Atualiza Tela
    }

    private void atualizaDb() {
        //TODO chama Db com dados novos
    }

    private void buscaLiga() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(Constantes.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();

        String invocadorString = mPerfil.getEncryptedSummonerId();
        if(invocadorString.isEmpty()){
            Toast.makeText(this, getString(R.string.liga_invalido), Toast.LENGTH_SHORT).show();
        } else {

            RetrofitService mRetrofitService = mRetrofit.create(RetrofitService.class);

            Call<List<Liga>> call = mRetrofitService.getLigaDados(invocadorString);

            call.enqueue(new Callback<List<Liga>>() {
                @Override
                public void onResponse(Call<List<Liga>> call, Response<List<Liga>> response) {
                    if(response.isSuccessful()){
                        mLigaList = response.body();
                        mLigaDAO.add(mLigaList);
                        setValuesElementos();

                    } else {
                        Toast.makeText(Perfil_Activity.this, getString(R.string.erro_user), Toast.LENGTH_SHORT).show();
                        mLigaList = null;
                    }
                }

                @Override
                public void onFailure(Call<List<Liga>> call, Throwable t) {

                    Toast.makeText(Perfil_Activity.this, getString(R.string.erro_api), Toast.LENGTH_SHORT).show();

                }
            });
        }
    }
}