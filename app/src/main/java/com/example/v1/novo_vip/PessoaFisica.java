package com.example.v1.novo_vip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.v1.novo_vip.View.AppUtil;
import com.example.v1.novo_vip.View.LoginActivity;
import com.example.v1.novo_vip.View.MainActivity;
import com.example.v1.novo_vip.model.ClientePF;
import com.shashank.sony.fancydialoglib.Animation;
import com.shashank.sony.fancydialoglib.FancyAlertDialog;
import com.shashank.sony.fancydialoglib.FancyAlertDialogListener;
import com.shashank.sony.fancydialoglib.Icon;

public class PessoaFisica extends AppCompatActivity {

    ClientePF clientePF;
    Button btnVoltar1;
    Button btnSalvar;
    Button btnCancel;
    private SharedPreferences preferences;
    EditText editCPF;
    EditText editNomeCompleto;

    boolean isFormularioOk, isPessoaFisica;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pessoa_fisica);

        initFormulario();

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isFormularioOk = validarFormulario()){


                    salvarSharedPreferences();
                    if(isPessoaFisica) {
                        Intent intent = new Intent(PessoaFisica.this, MainActivity.class);
                        startActivity(intent);
                    }else {

                        Intent intent = new Intent(PessoaFisica.this, PessoaJuridica.class);
                        startActivity(intent);
                    }

                }

            }
        });

           btnVoltar1.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {

                   Intent intent = new Intent(PessoaFisica.this, LoginActivity.class);
                   startActivity(intent);
                   finish();
                   return;
               }

               });


        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new FancyAlertDialog.Builder(PessoaFisica.this)
                        .setTitle("Confirma o cancelamento?")
                        .setBackgroundColor(Color.parseColor("#303F9F"))  //Don't pass R.color.colorvalue
                        .setMessage("Você realmente irá cancelar? Seus dados serão apagados fiiiii!")
                        .setNegativeBtnText("Nossa, não")
                        .setPositiveBtnBackground(Color.parseColor("#FF4081"))  //Don't pass R.color.colorvalue
                        .setPositiveBtnText("Sim")
                        .setNegativeBtnBackground(Color.parseColor("#FFA9A7A8"))  //Don't pass R.color.colorvalue
                        .setAnimation(Animation.POP)
                        .isCancellable(true)
                        .setIcon(R.drawable.ic_star_border_black_24dp, Icon.Visible)
                        .OnPositiveClicked(new FancyAlertDialogListener() {
                            @Override
                            public void OnClick() {
                                Toast.makeText(getApplicationContext(),"Amém. Fica com Deus",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(PessoaFisica.this, LoginActivity.class);
                                startActivity(intent);
                                finish();
                                return;

                            }
                        })
                        .OnNegativeClicked(new FancyAlertDialogListener() {
                            @Override
                            public void OnClick() {
                                Toast.makeText(getApplicationContext(),"Opa. beleza!",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .build();
            }
        });


    }

    private boolean validarFormulario() {

        boolean retorno = true;

        if(TextUtils.isEmpty(editCPF.getText().toString())){

            editCPF.setError("*");
            editCPF.requestFocus();
            retorno = false;

        }

        if(TextUtils.isEmpty(editNomeCompleto.getText().toString())){

            editNomeCompleto.setError("*");
            editNomeCompleto.requestFocus();
            retorno = false;

        }

        return  retorno;
    }

    private void initFormulario() {

        editCPF = findViewById(R.id.editCPF);
        editNomeCompleto = findViewById(R.id.editNomeCompleto);

        btnSalvar = findViewById(R.id.btnSalvar);
        btnCancel = findViewById(R.id.btnCancel);
        btnVoltar1 = findViewById(R.id.btnVoltar1);

        isFormularioOk = false;

        clientePF = new ClientePF();
        restaurarSharedPreferences();



    }

    private  void salvarSharedPreferences() {

        preferences = getSharedPreferences(AppUtil.PREF_APP,MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();
        dados.putString("nomeCompleto",editNomeCompleto.getText().toString());
        dados.putString("cpf",editCPF.getText().toString());
        dados.apply();




    }

    private  void restaurarSharedPreferences(){

        preferences  = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        isPessoaFisica = preferences.getBoolean("PessoaFisica", false);




    }
}

