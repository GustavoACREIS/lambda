package com.example.v1.novo_vip.BD;

public class ClienteModel {

    public   static final String TABELA = "cliente";
    public  static final String ID = "id";
    public   static final String PRIMEIRO_NOME = "primeiroNome";
    public   static final String SOBRENOME = "sobreNome";
    public   static final String EMAIL = "email";
    public  static final String SENHA = "senha";
    public  static final String PESSOAFISICA = "pessoaFisica";
    private  static final String  DATAINC = "dataInc";
    private  static final String DATAALT = "dataAlt";

    private static String query;


    public static String gerarTabela(){


        query = "CREATE TABLE " +TABELA+" ( ";
        query += ID+" INTEGER PRIMARY KEY AUTOINCREMENT, ";
        query += PRIMEIRO_NOME+" TEXT, ";
        query += SOBRENOME+" TEXT, ";
        query += EMAIL+" TEXT, ";
        query += SENHA+" TEXT, ";
        query += PESSOAFISICA+" INTEGER, ";
        query += DATAINC+" datetime default current_timestamp, ";
        query += DATAALT+" datetime default current_timestamp ";




        query += ")";

        return query;
    }

}
