package com.example.v1.novo_vip;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.v1.novo_vip.View.AppUtil;
import com.example.v1.novo_vip.View.LoginActivity;
import com.example.v1.novo_vip.model.Cliente;
import com.example.v1.novo_vip.model.ClientePF;
import com.example.v1.novo_vip.model.ClientePJ;

public class MostrarDados extends AppCompatActivity {
    Cliente cliente;
    ClientePF clientePF;
    ClientePJ clientePJ;

    TextView txt1, txt2, txt3,txt4,txt5,txt6,txt7,txt8,txt9;
    private SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_dados);

        cliente = new Cliente();
        clientePF = new ClientePF();
        clientePJ = new ClientePJ();

        initFormulario();





    }
    private void salvarSharedPreferences() {

        preferences = getSharedPreferences(AppUtil.PREF_APP, MODE_PRIVATE);


    }

    @SuppressLint("SetTextI18n")
    public void initFormulario() {

        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);
        txt4 = findViewById(R.id.txt4);
        txt5 = findViewById(R.id.txt5);
        txt6 = findViewById(R.id.txt6);
        txt7 = findViewById(R.id.txt7);
        txt8 = findViewById(R.id.txt8);
        txt9 = findViewById(R.id.txt9);


        restaurarSharedPreferences();


        txt1.setText("Primeiro Nome:  " + cliente.getPrimeiroNome());
        txt2.setText("Sobrenome:  " + cliente.getSobreNome());
        txt3.setText("Email:  " + cliente.getEmail());
        txt4.setText("Senha:  " + cliente.getSenha());
        txt5.setText("Nome Completo:  " + clientePF.getNomeCompleto());
        txt6.setText("CPF:  " + clientePF.getCPF());
        txt7.setText("Razao Social:  " + clientePJ.getRazaoSocial());
        txt8.setText("Data Abertura" + clientePJ.getDataAbertura());
        txt9.setText("CNPJ:  " + clientePJ.getCNPJ());
        salvarSharedPreferences();

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
        clientePJ.setCNPJ(preferences.getString("CNPJ","Null"));
        clientePJ.setSimplesNacional(preferences.getBoolean("SimplesNacional", false));

    }

    public void voltar(View view) {

        Intent intent = new Intent(MostrarDados.this, TelaDeDados.class);
        startActivity(intent);

        finish();
        return;
    }
}
