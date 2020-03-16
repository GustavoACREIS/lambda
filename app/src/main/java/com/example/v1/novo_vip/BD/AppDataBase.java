package com.example.v1.novo_vip.BD;

import android.content.ContentValues;
import android.content.Context;
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

        return true;
    }

    public  boolean delete(String tabela, int id){

        return true;
    }
    public  boolean update(String tabela, ContentValues dados){

        return true;
    }

    public List<Cliente> list(){

        List<Cliente> list = new ArrayList<>();

        return list;
    }



}
