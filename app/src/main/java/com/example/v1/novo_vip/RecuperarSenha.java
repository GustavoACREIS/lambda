package com.example.v1.novo_vip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.v1.novo_vip.View.AppUtil;
import com.example.v1.novo_vip.View.LoginActivity;

public class RecuperarSenha extends AppCompatActivity {

    Button btnVoltar;
    Button btnRecuperar;
    EditText editEmail;
    ImageView image1;
    private SharedPreferences preferences;
    boolean isFormularioOk;



    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recuperar_senha2);

        initFormulario();


        btnRecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isFormularioOk = validarFormulario()) {
                    Toast.makeText(getApplicationContext(),"Sua senha foi enviada...",Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(RecuperarSenha.this, LoginActivity.class);
                    startActivity(intent);

                }

            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecuperarSenha.this  , LoginActivity.class);
                startActivity(intent);
                finish();
                return;

            }
        });

    }

    private boolean validarFormulario() {

        boolean retorno = true;

        if(TextUtils.isEmpty(editEmail.getText().toString())){

            editEmail.setError("*");
            editEmail.requestFocus();
            retorno = false;

        }

        return  retorno;
    }


    private void initFormulario(){

        editEmail = findViewById(R.id.editEmailA);
        btnRecuperar = findViewById(R.id.btnRecuperar);
        btnVoltar = findViewById(R.id.btnVoltar);
        image1 = findViewById(R.id.logo1);

        restaurarSharedPreferences();
    }

    private  void salvarSharedPreferences() {

        preferences = getSharedPreferences(AppUtil.PREF_APP,MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();



    }

    private  void restaurarSharedPreferences() {

        preferences  = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
    }


}
