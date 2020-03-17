package com.example.v1.novo_vip;

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
import android.widget.ImageView;
import android.widget.Toast;

import com.example.v1.novo_vip.View.AppUtil;
import com.example.v1.novo_vip.View.LoginActivity;
import com.example.v1.novo_vip.View.MainActivity;
import com.example.v1.novo_vip.model.ClientePF;
import com.shashank.sony.fancydialoglib.Animation;
import com.shashank.sony.fancydialoglib.FancyAlertDialog;
import com.shashank.sony.fancydialoglib.FancyAlertDialogListener;
import com.shashank.sony.fancydialoglib.Icon;

public class PessoaJuridica extends AppCompatActivity {

    Button btnCancelar;
    Button btnSalved;
    Button btnVolte;
    private SharedPreferences preferences;
    EditText editCNPJ;
    EditText editRazaoSocial;
    EditText inpDate ;
    CheckBox ckSimplesNacional;
    CheckBox ckMei;
    ImageView image1;

    boolean isFormularioOk, isSimplesNacional, isMei;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pessoajuridica2);


        initFormulario();

        btnSalved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFormularioOk = validarFormulario()) {

                    salvarSharedPreferences();

                    Intent intent = new Intent(PessoaJuridica.this, MainActivity.class);
                    startActivity(intent);

                }


            }
        });


        btnVolte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PessoaJuridica.this,LoginActivity.class);
                startActivity(intent);
                finish();
                return;

            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new FancyAlertDialog.Builder(PessoaJuridica.this)
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
                                Intent intent = new Intent(PessoaJuridica.this, LoginActivity.class);
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
      public  void SimplesNacional  (View view){

        isSimplesNacional = ckSimplesNacional.isChecked();
    }

    public  void MEI  (View view){

        isMei = ckMei.isChecked();
    }

    private boolean validarFormulario() {

        boolean retorno = true;

        if(TextUtils.isEmpty(editCNPJ.getText().toString())){

            editCNPJ.setError("*");
            editCNPJ.requestFocus();
            retorno = false;

        }

        if(TextUtils.isEmpty(editRazaoSocial.getText().toString())){

            editRazaoSocial.setError("*");
            editRazaoSocial.requestFocus();
            retorno = false;

        }

        if(TextUtils.isEmpty(inpDate.getText().toString())){

            inpDate.setError("*");
            inpDate.requestFocus();
            retorno = false;

        }


        return  retorno;
    }

    private void initFormulario() {

        editCNPJ = findViewById(R.id.editCNPJ);
        editRazaoSocial = findViewById(R.id.editRazaoSocial);
        inpDate = findViewById(R.id.inpDate);

        btnSalved = findViewById(R.id.btnSalved);
        btnCancelar = findViewById(R.id.btnCancelar);
        btnVolte = findViewById(R.id.btnVolte);

        image1 = findViewById(R.id.image1);

        ckMei = findViewById(R.id.ckMei);
        ckSimplesNacional = findViewById(R.id.ckSimplesNacional);


        isFormularioOk = false;

        restaurarSharedPreferences();
    }


    private  void salvarSharedPreferences() {


        preferences = getSharedPreferences(AppUtil.PREF_APP,MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();
        dados.putString("CNPJ",editCNPJ.getText().toString());
        dados.putString("RazaoSocial",editRazaoSocial.getText().toString());
        dados.putString("DataAbertura", inpDate.getText().toString());
        dados.putBoolean("SimplesNacional", isSimplesNacional);
        dados.putBoolean("Mei", isMei);
        dados.apply();






    }

    private  void restaurarSharedPreferences() {

        preferences  = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);



    }


}