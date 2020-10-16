package com.example.projetolol.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.projetolol.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CheckBox lembrar_checkbox;
    private EditText invocador_EditText;
    private Button procurar_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        setLayoutElementos();
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
            if(lembrar_checkbox.isChecked()){
                //shared armazena
            }
            //Chama tela Achou com invocador_EditText
        }
    }
}