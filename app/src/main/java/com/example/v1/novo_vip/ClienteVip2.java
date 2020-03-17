package com.example.v1.novo_vip;

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
import android.widget.TextView;
import android.widget.Toast;
import com.example.v1.novo_vip.View.AppUtil;
import com.example.v1.novo_vip.View.LoginActivity;
import com.shashank.sony.fancydialoglib.Animation;
import com.shashank.sony.fancydialoglib.FancyAlertDialog;
import com.shashank.sony.fancydialoglib.FancyAlertDialogListener;
import com.shashank.sony.fancydialoglib.Icon;

public class ClienteVip2 extends AppCompatActivity {


    private SharedPreferences preferences;
    EditText editprimeiroNome, editSobrenome;
    Button btnSalvarContinuar, btnCancelar;
    CheckBox ckPessoaFisica;
    ImageView image1;
    TextView image2, image3;

    boolean isFormularioOk, isPessoaFisica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cliente_vip_3);

        initForms();

        btnSalvarContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isFormularioOk = validarFormulario()){




                    salvarSharedPreferences();
                    if(isPessoaFisica){
                        Intent intent =new Intent(ClienteVip2.this, PessoaFisica.class);
                        startActivity(intent);

                    }else {
                        Intent intent =new Intent(ClienteVip2.this, PessoaFisica.class);
                        startActivity(intent);
                    }

                }



            }


        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new FancyAlertDialog.Builder(ClienteVip2.this)
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
                                Intent intent = new Intent(ClienteVip2.this, LoginActivity.class);
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

    @SuppressLint("WrongViewCast")
    private void initForms() {

        editprimeiroNome = findViewById(R.id.editPrimeiroNome);
        editSobrenome = findViewById(R.id.editSenhaA);
        ckPessoaFisica = findViewById(R.id.ckPessoaFisica);
        btnSalvarContinuar = findViewById(R.id.btnSalvarContinua);
        btnCancelar = findViewById(R.id.btnCancelar);
        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.app);
        image3 = findViewById(R.id.txtNovoVip);





        isFormularioOk = false;


        restaurarSharedPreferences();
    }

    public void pessoaFisica (View view){

        isPessoaFisica = ckPessoaFisica.isChecked();

    }

    private boolean validarFormulario() {

        boolean retorno = true;

        if(TextUtils.isEmpty(editprimeiroNome.getText().toString())){

            editprimeiroNome.setError("*");
            editprimeiroNome.requestFocus();
            retorno = false;

        }

        if(TextUtils.isEmpty(editSobrenome.getText().toString())){

            editSobrenome.setError("*");
            editSobrenome.requestFocus();
            retorno = false;

        }

        return  retorno;
    }

    private  void salvarSharedPreferences() {

        preferences = getSharedPreferences(AppUtil.PREF_APP,MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();
        dados.putString("primeiroNome",editprimeiroNome.getText().toString());
        dados.putString("Sobrenome",editSobrenome.getText().toString());
        dados.putBoolean("PessoaFisica",isPessoaFisica);

        dados.apply();


    }

    private  void restaurarSharedPreferences(){

        preferences  = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);

    }
}
