package com.example.v1.novo_vip.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.example.v1.novo_vip.R;

public class Splash extends AppCompatActivity {

    private SharedPreferences preferences;
    boolean isLembrarSenha = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        salvarSharedPreferences();
        restaurarSharedPreferences();

        iniciarapp();



        
    }

    private void iniciarapp() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent;

                if(isLembrarSenha){
                    intent = new Intent(Splash.this,MainActivity.class);
                ;}else  {

                     intent = new Intent(Splash.this,LoginActivity.class);

                }

                startActivity(intent);
                finish();
                return;

            }
        },AppUtil.TIME_SPLASH);
    }

        private  void salvarSharedPreferences() {

        preferences = getSharedPreferences(AppUtil.PREF_APP,MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();
        dados.putBoolean("loginAutomatico", false );

        dados.apply();

        }

        private  void restaurarSharedPreferences(){

        preferences  = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        }
}
