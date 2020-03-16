package com.example.v1.novo_vip;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.v1.novo_vip.View.AppUtil;
import com.example.v1.novo_vip.View.LoginActivity;
import com.example.v1.novo_vip.View.MainActivity;
import com.example.v1.novo_vip.model.Cliente;
import com.example.v1.novo_vip.model.ClientePF;
import com.example.v1.novo_vip.model.ClientePJ;
import com.shashank.sony.fancydialoglib.Animation;
import com.shashank.sony.fancydialoglib.FancyAlertDialog;
import com.shashank.sony.fancydialoglib.FancyAlertDialogListener;
import com.shashank.sony.fancydialoglib.Icon;

public class TelaDeDados extends AppCompatActivity {


    Cliente cliente;
    ClientePF clientePF;
    ClientePJ clientePJ;
    private SharedPreferences preferences;
    TextView textNomeCliente;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_de_dados);

        cliente = new Cliente();
        clientePF = new ClientePF();
        clientePJ = new ClientePJ();


        initFormulario();

    }



    @SuppressLint("SetTextI18n")
    public void initFormulario() {


        textNomeCliente = findViewById(R.id.textNomeCliente);;

        restaurarSharedPreferences();
        textNomeCliente.setText("Bem Vindo  " + cliente.getPrimeiroNome());

    }


    private void salvarSharedPreferences() {

        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        SharedPreferences.Editor dados = preferences.edit();
        dados.putBoolean("loginAutomatico", false);

        dados.apply();

    }

    private void restaurarSharedPreferences() {


        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);
        cliente.setPrimeiroNome(preferences.getString("primeiroNome", "null"));
        cliente.setEmail(preferences.getString("email", "null"));
        cliente.setSenha(preferences.getString("senha", "null"));
        cliente.setPessoaFisica(preferences.getBoolean("PessoaFisica", false));
        cliente.setSobreNome(preferences.getString("Sobrenome", "Null"));
        clientePF.setNomeCompleto(preferences.getString("nomeCompleto", "Null"));
        clientePF.setCPF(preferences.getString("cpf", "Null"));
        clientePJ.setRazaoSocial(preferences.getString("RazaoSocial", "Null"));
        clientePJ.setDataAbertura(preferences.getString("DataAbertura", "Null"));
        clientePJ.setMei(preferences.getBoolean("Mei", false));
        clientePJ.setSimplesNacional(preferences.getBoolean("SimplesNacional", false));

    }


    public void ConsultarClientes(View view) {


    }

    public void ExcluirConta(View view) {

        new FancyAlertDialog.Builder(TelaDeDados.this)
                .setTitle("Excluir Cadastro")
                .setBackgroundColor(Color.parseColor("#303F9F"))  //Don't pass R.color.colorvalue
                .setMessage("Você realmente quer excluir? Pensa bem tiozão")
                .setNegativeBtnText("Uh. Não")
                .setPositiveBtnBackground(Color.parseColor("#FF4081"))  //Don't pass R.color.colorvalue
                .setPositiveBtnText("Sim ")
                .setNegativeBtnBackground(Color.parseColor("#FFA9A7A8"))  //Don't pass R.color.colorvalue
                .setAnimation(Animation.POP)
                .isCancellable(true)
                .setIcon(R.drawable.ic_star_border_black_24dp, Icon.Visible)
                .OnPositiveClicked(new FancyAlertDialogListener() {
                    @Override
                    public void OnClick() {
                        Toast.makeText(getApplicationContext(), cliente.getPrimeiroNome() + ", Fica com Deus", Toast.LENGTH_SHORT).show();
                        cliente = new Cliente();
                        clientePF = new ClientePF();
                        clientePJ = new ClientePJ();
                        salvarSharedPreferences();

                        Intent intent = new Intent(TelaDeDados.this, LoginActivity.class);
                        startActivity(intent);

                        finish();
                        return;
                    }
                })
                .OnNegativeClicked(new FancyAlertDialogListener() {
                    @Override
                    public void OnClick() {
                        Toast.makeText(getApplicationContext(), cliente.getPrimeiroNome() + ", Aí sim!!", Toast.LENGTH_SHORT).show();
                    }
                })
                .build();
    }

    public void AtualizarDados(View view) {

    }




    public void SairApp(View view) {
        Intent intent = new Intent(TelaDeDados.this, LoginActivity.class);
        startActivity(intent);
        finish();
        return;

    }

    public void mostrarDados(View view)
    {

        Intent intent = new Intent(TelaDeDados.this, MostrarDados.class);
        startActivity(intent);

        finish();
        return;

    }
}
