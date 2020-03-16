package com.example.v1.novo_vip.BD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.v1.novo_vip.View.AppUtil;
import com.example.v1.novo_vip.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class AppDataBase extends SQLiteOpenHelper {

    private static final String DB_NAME = "clienteDB.sqlite";
    private static final int DB_VERSION = 1;

    Cursor cursor;

    SQLiteDatabase db;

    public AppDataBase (@Nullable Context context) {
        super(context, DB_NAME, null    , DB_VERSION);

        db = getWritableDatabase();


    }



    @Override
    public void onCreate(SQLiteDatabase db) {

        String sqlTabelaCliente = "query SQL";

        try {



            db.execSQL(ClienteModel.gerarTabela());

            Log.i(AppUtil.LOG_APP, "Erro TB CLIENTE" + ClienteModel.gerarTabela());

        }catch (SQLException e){
            Log.e(AppUtil.LOG_APP, "Erro TB CLIENTE" + e.getMessage());

        }
        try {



            db.execSQL(ClientePFModel.gerarTabela());

            Log.i(AppUtil.LOG_APP, "Erro TB CLIENTE" + ClientePFModel.gerarTabela());

        }catch (SQLException e){
            Log.e(AppUtil.LOG_APP, "Erro TB CLIENTE" + e.getMessage());

        }
        try {



            db.execSQL(ClientePJModel.gerarTabela());

            Log.i(AppUtil.LOG_APP, "Erro TB CLIENTE" + ClientePJModel.gerarTabela());

        }catch (SQLException e){
            Log.e(AppUtil.LOG_APP, "Erro TB CLIENTE" + e.getMessage());

        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public boolean insert(String tabela, ContentValues  dados){

        boolean sucesso = true;

        try {
            Log.i(AppUtil.LOG_APP,  tabela + " insert ok");
            sucesso = db.insert(tabela, null, dados) > 0 ;

        }catch (SQLException e){

            Log.e(AppUtil.LOG_APP,  tabela + " falhou insert"  + e.getMessage());


        }

        return sucesso;
    }

    public  boolean delete(String tabela, int id){

        boolean sucesso = true;

        try {
            Log.i(AppUtil.LOG_APP,  tabela + " delete ok");
            sucesso = db.delete(tabela, "id=?", new String[]{Integer.toString(id)}) > 0;

        }catch (SQLException e){

            Log.e(AppUtil.LOG_APP,  tabela + " falhou delete"  + e.getMessage());


        }

        return sucesso;

    }
    public  boolean update(String tabela, ContentValues dados){

        boolean sucesso = true;

        try {
            int id = dados.getAsInteger("id");
            Log.i(AppUtil.LOG_APP,  tabela + " update ok");
            sucesso = db.delete(tabela, "id=?", new String[]{Integer.toString(id)}) > 0;

        }catch (SQLException e){

            Log.e(AppUtil.LOG_APP,  tabela + " falhou update"  + e.getMessage());


        }

        return sucesso;
    }

    public List<Cliente> list(String tabela){

        List<Cliente> list = new ArrayList<>();


        Cliente cliente;
        String sql = "SELECT * FROM "+tabela;
        cursor = db.rawQuery(sql, null);


        if(cursor.moveToFirst()){

            do{

                cliente = new Cliente();
                cliente.setId(cursor.getColumnIndex(ClienteModel.ID));
                cliente.setPrimeiroNome(cursor.getString(cursor.getColumnIndex(ClienteModel.PRIMEIRO_NOME)));
                cliente.setSobreNome(cursor.getString(cursor.getColumnIndex(ClienteModel.SOBRENOME)));
                cliente.setEmail(cursor.getString(cursor.getColumnIndex(ClienteModel.EMAIL)));
                cliente.setSenha(cursor.getString(cursor.getColumnIndex(ClienteModel.SENHA)));
                cliente.setPessoaFisica(cursor.getInt(cursor.getColumnIndex(ClienteModel.PESSOAFISICA))==1);

                list.add(cliente);


            }while (cursor.moveToNext());
        }

        return list;
    }



}
