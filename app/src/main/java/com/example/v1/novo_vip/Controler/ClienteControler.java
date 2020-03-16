package com.example.v1.novo_vip.Controler;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.v1.novo_vip.BD.AppDataBase;
import com.example.v1.novo_vip.BD.ClienteModel;
import com.example.v1.novo_vip.model.Cliente;

import java.util.List;

public class ClienteControler extends AppDataBase {


    private static final String TABELA = ClienteModel.TABELA;
    private ContentValues dados;


    public ClienteControler(@Nullable Context context) {
        super(context);

    dados =new ContentValues();

    }


    public  boolean incluir(Cliente obj){

        dados.put(ClienteModel.PRIMEIRO_NOME, obj.getPrimeiroNome());
        dados.put(ClienteModel.SOBRENOME, obj.getSobreNome());
        dados.put(ClienteModel.EMAIL, obj.getSenha());
        dados.put(ClienteModel.SENHA, obj.getSenha());
        dados.put(ClienteModel.PESSOAFISICA, obj.isPessoaFisica());
        return insert(TABELA, dados);
    }

    public  boolean alterar(Cliente obj){

        dados.put(ClienteModel.PRIMEIRO_NOME, obj.getPrimeiroNome());
        dados.put(ClienteModel.ID, obj.getId());
        dados.put(ClienteModel.SOBRENOME, obj.getSobreNome());
        dados.put(ClienteModel.EMAIL, obj.getSenha());
        dados.put(ClienteModel.SENHA, obj.getSenha());
        dados.put(ClienteModel.PESSOAFISICA, obj.isPessoaFisica());

        return update(TABELA, dados);
    }

    public  boolean deletar(Cliente obj){

        dados.put(ClienteModel.ID, obj.getId());


        return delete(TABELA, obj.getId());
    }

    public List<Cliente> listar(){

        return list();
    }
}


