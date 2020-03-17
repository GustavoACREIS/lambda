package com.example.v1.novo_vip.View;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import com.example.v1.novo_vip.R;
import com.example.v1.novo_vip.model.ClientePF;

import com.shashank.sony.fancydialoglib.FancyAlertDialog;
import com.shashank.sony.fancydialoglib.FancyAlertDialogListener;
import com.shashank.sony.fancydialoglib.Icon;


public class MainActivity extends AppCompatActivity {

    ClientePF clientePF;
    EditText editNome, editEmail, SenhaA, SenhaB;
    Button btnCadastro, btnVoltar;
    CheckBox ckCheck;
    ImageView image1;


    private SharedPreferences preferences;
    Boolean isFormularioOk, isPessoaFisica;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        setContentView(R.layout.main2);
        super.onCreate(savedInstanceState);

        clientePF = new ClientePF();
        initFormulario();


        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                isFormularioOk = true;
                validarsenha();

                if (isFormularioOk = validarFormulario()) {
                    if (!validarsenha()) {
                        SenhaA.setError("*");
                        SenhaB.setError("*");
                        SenhaA.requestFocus();

                        new FancyAlertDialog.Builder(MainActivity.this)
                                .setTitle("SENHAS")
                                .setBackgroundColor(Color.parseColor("#303F9F"))  //Don't pass R.color.colorvalue
                                .setMessage("As senhas não estão iguais, seu burro!! Presta atenção!!!")
                                .setPositiveBtnText("Entendi")
                                .isCancellable(true)
                                .setIcon(R.drawable.ic_star_border_black_24dp, Icon.Visible)
                                .OnPositiveClicked(new FancyAlertDialogListener() {
                                    @Override
                                    public void OnClick() {
                                        Toast.makeText(getApplicationContext(), "Escreve Certo", Toast.LENGTH_SHORT).show();
                                    }
                                })

                                .build();
                    } else {
                        salvarSharedPreferences();
                        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                        return;
                    }
                }
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });


    }
    private boolean validarsenha() {

        boolean retorno = (Integer.parseInt(SenhaA.getText().toString()) == Integer.parseInt(SenhaB.getText().toString()));

        return retorno;
    }


    private void restaurarSharedPreferences() {

        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        isPessoaFisica = preferences.getBoolean("PessoaFisica", true);
        clientePF.setNomeCompleto(preferences.getString("nomeCompleto", "Null"));


    }


    private boolean validarFormulario() {

        boolean retorno = true;

        if (TextUtils.isEmpty(editNome.getText().toString())) {

            editNome.setError("*");
            editNome.requestFocus();
            retorno = false;

        }

        if (TextUtils.isEmpty(editEmail.getText().toString())) {

            editEmail.setError("*");
            editEmail.requestFocus();
            retorno = false;

        }

        if (TextUtils.isEmpty(SenhaA.getText().toString())) {

            SenhaA.setError("*");
            SenhaA.requestFocus();
            retorno = false;

        }

        if (TextUtils.isEmpty(SenhaB.getText().toString())) {

            SenhaB.setError("*");
            SenhaB.requestFocus();
            retorno = false;

        }

        if (!ckCheck.isChecked()) {
            retorno = false;
            Toast.makeText(getApplicationContext(), "É necessário LER os termos", Toast.LENGTH_LONG).show();
        }

        return retorno;
    }


    public void validartermo (View view) {

        if (!ckCheck.isChecked()) {

            Toast.makeText(getApplicationContext(), "É necessário LER os termos", Toast.LENGTH_LONG).show();
        }
    }

    private  void salvarSharedPreferences() {

        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();
        dados.putString("email",editEmail.getText().toString());
        dados.putString("nomeCompleto", editNome.getText().toString());
        dados.putString("senha",SenhaA.getText().toString());
        dados.apply();
    }

    @SuppressLint("SetTextI18n")

    public void initFormulario() {


        editNome = findViewById(R.id.digitNome);
        editEmail = findViewById(R.id.digitEmail);
        SenhaA = findViewById(R.id.digitPass);
        SenhaB = findViewById(R.id.digitPass2);
        btnCadastro = findViewById(R.id.btncadast);
        ckCheck = findViewById(R.id.ckCheck);
        btnVoltar = findViewById(R.id.btnVoltar);
        image1 = findViewById(R.id.image12);

        isFormularioOk = false;


        restaurarSharedPreferences();
        editNome.setText(preferences.getString("nomeCompleto","Null"));

    }



}













