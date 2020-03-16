package com.example.v1.novo_vip.model;


public class ClientePF extends Cliente {



    private int fk;
    private String CPF;
    private  String nomeCompleto;


    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }
}
