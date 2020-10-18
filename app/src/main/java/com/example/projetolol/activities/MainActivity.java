package com.example.projetolol.activities;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.projetolol.R;
import com.example.projetolol.api.RetrofitService;
import com.example.projetolol.constants.Constantes;
import com.example.projetolol.dao.PerfilDAO;
import com.example.projetolol.model.Perfil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int REQUEST_PERMISSION = 64;


    private Retrofit mRetrofit;

    private CheckBox lembrar_checkbox;
    private EditText invocador_EditText;
    private Button procurar_button;
    private String status;
    private PerfilDAO mPerfilDAO;
    private Perfil mPerfil;
    private Intent novoPerfil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        setLayoutElementos();
        setElementos();
    }

    private void setElementos() {
        mPerfilDAO = new PerfilDAO(this);
    }

    private void setLayoutElementos() {
        lembrar_checkbox = findViewById(R.id.check_lembrar);
        invocador_EditText = findViewById(R.id.editText_invocador);
        procurar_button = findViewById(R.id.button_procurar);

        procurar_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == procurar_button){
            if(temPermissao()) {
                if (lembrar_checkbox.isChecked()) {
                    //TODO shared armazena
                }

                mPerfil = mPerfilDAO.getPerfil(invocador_EditText.getText().toString());
                novoPerfil = new Intent(this, Perfil_Activity.class);
                if(mPerfil == null){
                    buscaPerfil();
                } else {
                    novoPerfil.putExtra(Constantes.KEY_PERFIL, invocador_EditText.getText().toString());
                    startActivity(novoPerfil);
                }
            } else {
                solicitaPermissao();
            }
        }
    }

    private boolean temPermissao() {
        return ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET) == PackageManager.PERMISSION_GRANTED;
    }

    private void solicitaPermissao() {
        if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.INTERNET)){
            final Activity activity = this;
            new AlertDialog.Builder(this)
                    .setMessage(R.string.explicacao_permissao)
                    .setPositiveButton(R.string.botao_fornecer, new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i){
                            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.INTERNET}, REQUEST_PERMISSION);
                        }
                    })
                    .setNegativeButton(R.string.botao_nao_fornecer, new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i){
                            dialogInterface.dismiss();
                        }
                    })
                    .show();
        } else {
            ActivityCompat.requestPermissions(
                    this,
                    new String[]{
                            Manifest.permission.INTERNET
                    },
                    REQUEST_PERMISSION);
        }
    }

    private void buscaPerfil() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(Constantes.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();

        String invocadorString = invocador_EditText.getText().toString();
        if(invocadorString.isEmpty()){
            Toast.makeText(this, getString(R.string.user_invalido), Toast.LENGTH_SHORT).show();
        } else {

            RetrofitService mRetrofitService = mRetrofit.create(RetrofitService.class);

            Call<Perfil> call = mRetrofitService.getPerfilDadosBasicos(invocadorString);

            call.enqueue(new Callback<Perfil>() {
                @Override
                public void onResponse(Call<Perfil> call, Response<Perfil> response) {
                    if(response.isSuccessful()){
                        mPerfil = response.body();
                        mPerfilDAO.add(mPerfil);

                        novoPerfil.putExtra(Constantes.KEY_PERFIL, invocador_EditText.getText().toString());
                        startActivity(novoPerfil);

                    } else {
                        Toast.makeText(MainActivity.this, getString(R.string.erro_user), Toast.LENGTH_SHORT).show();
                        mPerfil = null;
                    }
                }

                @Override
                public void onFailure(Call<Perfil> call, Throwable t) {

                    Toast.makeText(MainActivity.this, getString(R.string.erro_api), Toast.LENGTH_SHORT).show();

                }
            });


        }
    }

}