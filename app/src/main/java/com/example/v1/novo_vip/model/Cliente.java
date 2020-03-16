package com.example.v1.novo_vip.model;

public class Cliente  {

    private  int Id;
    private  String primeiroNome;
    private  String sobreNome;
    private  String email;
    private  String senha;
    private  boolean pessoaFisica;





    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public boolean isPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(boolean pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    public String getPrimeiroNome() {

        return primeiroNome;
    }

    public void setPrimeiroNome(String PrimeiroNome) {
        this.primeiroNome = PrimeiroNome;
    }
}
