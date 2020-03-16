package com.example.v1.novo_vip.BD;

public class ClientePJModel {

//  private int fk;
//    private String CNPJ;
//    private  String razaoSocial;
//    private  String dataAbertura;
//    private  boolean simplesNacional;
//    private boolean mei;


    private  static final String TABELA = "clientePF";
    private  static final String ID = "id";
    private  static final String FK = "clientePFID";
    private  static final String CNPJ = "CNPJ";
    private  static final String  RAZAOSOCIAL = "razaoSocial";
    private  static final String  SIMPLESNACIONAL = "simplesNacional";
    private  static final String  MEI = "mei";
    private  static final String  DATAINC = "dataInc";
    private  static final String DATAALT = "dataAlt";

    private static String query;


    public static String gerarTabela(){


        query = "CREATE TABLE " +TABELA+" ( ";
        query += ID+" INTEGER PRIMARY KEY AUTOINCREMENT, ";
        query += CNPJ+" TEXT, ";
        query += RAZAOSOCIAL+" TEXT, ";
        query += SIMPLESNACIONAL+" INTEGER, ";
        query += MEI+" INTEGER, ";
        query += FK+" INTEGER, ";
        query += DATAINC+" TEXT, ";
        query += DATAALT+" TEXT ";
        query += "FOREIGN KEY("+FK+") REFERENCES clientePF(id)";




        query += ")";

        return query;
    }

}
