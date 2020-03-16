package com.example.v1.novo_vip.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.v1.novo_vip.ClienteVip2;
import com.example.v1.novo_vip.Controler.ClienteControler;
import com.example.v1.novo_vip.R;
import com.example.v1.novo_vip.RecuperarSenha;
import com.example.v1.novo_vip.TelaDeDados;
import com.example.v1.novo_vip.model.Cliente;
import com.shashank.sony.fancydialoglib.Animation;
import com.shashank.sony.fancydialoglib.FancyAlertDialog;
import com.shashank.sony.fancydialoglib.FancyAlertDialogListener;
import com.shashank.sony.fancydialoglib.Icon;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    Cliente cliente;
    private SharedPreferences preferences;

    EditText editEmail;
    EditText editSenhaA;
    CheckBox ckLembrar;
    Button acessar;
    Button sejavip;
    TextView  recuperar;
    TextView termos;


    boolean isFormularioOk, isLembrarSenha;

    ClienteControler controler;



    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        initFormulario();

        acessar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isFormularioOk = validarFormulario()){
                    if(validarFormulario()){
                        salvarSharedPreferences();
                        Intent intent = new Intent(LoginActivity.this, TelaDeDados.class);
                        startActivity(intent);
                        finish();
                        return;
                    }else { Toast.makeText(getApplicationContext(),"Verifique os dados", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        recuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginActivity.this, RecuperarSenha.class);
                startActivity(intent);
            }
        });


        sejavip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ClienteVip2.class);
                startActivity(intent);
                finish();
                return;
            }
        });

        termos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new FancyAlertDialog.Builder(LoginActivity.this)
                        .setTitle("Política de Privacidade & Termos de Uso")
                        .setBackgroundColor(Color.parseColor("#303F9F"))  //Don't pass R.color.colorvalue
                        .setMessage("Você estará concordando em passar todos seus bens materiais e esperituais para Deus")
                        .setNegativeBtnText("Sai fora")
                        .setPositiveBtnBackground(Color.parseColor("#FF4081"))  //Don't pass R.color.colorvalue
                        .setPositiveBtnText("Temo a Deus ")
                        .setNegativeBtnBackground(Color.parseColor("#FFA9A7A8"))  //Don't pass R.color.colorvalue
                        .setAnimation(Animation.POP)
                        .isCancellable(true)
                        .setIcon(R.drawable.ic_star_border_black_24dp, Icon.Visible)
                        .OnPositiveClicked(new FancyAlertDialogListener() {
                            @Override
                            public void OnClick() {
                                Toast.makeText(getApplicationContext(),"Amém. Fica com Deus",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .OnNegativeClicked(new FancyAlertDialogListener() {
                            @Override
                            public void OnClick() {
                                Toast.makeText(getApplicationContext(),"Falow.. vaza",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .build();
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

        if(TextUtils.isEmpty(editSenhaA.getText().toString())){

            editSenhaA.setError("*");
            editSenhaA.requestFocus();
            retorno = false;

        }

        return retorno;
    }

    private void initFormulario() {


        termos = findViewById(R.id.termos);
        recuperar = findViewById(R.id.recuperar);
        sejavip = findViewById(R.id.sejavip);
        acessar = findViewById(R.id.acessar);
        ckLembrar = findViewById(R.id.ckLembrar);
        editEmail = findViewById(R.id.editEmail);
        editSenhaA = findViewById(R.id.editSenhaA);



        isFormularioOk = false;
        cliente = new Cliente();
        controler = new ClienteControler(getApplicationContext());

        controler.incluir(cliente);
        controler.alterar(cliente);
        controler.deletar(cliente);
        restaurarSharedPreferences();



    }


    public  void lembrarSenha (View view){

         isLembrarSenha = ckLembrar.isChecked();
    }


    private  void salvarSharedPreferences() {

        preferences = getSharedPreferences(AppUtil.PREF_APP,MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();
        dados.putBoolean("loginAutomatico",isLembrarSenha);
        dados.apply();

    }
        public void restaurarSharedPreferences(){

            preferences  = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
            isLembrarSenha = preferences.getBoolean("loginAutomatico",true);
            cliente.setEmail(preferences.getString("email", "null"));
            cliente.setSenha(preferences.getString("senha", "null"));

        }
}

