package com.example.v1.novo_vip.BD;

public class ClientePFModel {

    // private int fk;
    //    private String CPF;
    //    private  String nomeCompleto;

    private  static final String TABELA = "clientePF";
    private  static final String ID = "id";
    private  static final String FK = "clienteID";
    private  static final String NOME_COMPLETO = "nomeCompleto";
    private  static final String CPF = "cpf";
    private  static final String  DATAINC = "dataInc";
    private  static final String DATAALT = "dataAlt";

    private static String query;


    public static String gerarTabela(){


        query = "CREATE TABLE " +TABELA+" ( ";
        query += ID+" INTEGER PRIMARY KEY AUTOINCREMENT, ";
        query += NOME_COMPLETO+" TEXT, ";
        query += CPF+" TEXT, ";
        query += FK+" INTEGER, ";
        query += DATAINC+" TEXT, ";
        query += DATAALT+" TEXT ";
        query += "FOREIGN KEY("+FK+") REFERENCES cliente(id)";




        query += ")";

        return query;
    }

}
