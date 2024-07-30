package com.PIetapa7e8.atividade1.model;

public class Cliente {
    
    private int id;
    private String nome;
    private String endereco;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;
    private String email;
    private String telefone;
    
    //Metódo Construtor vazio
    public Cliente(){
        
    }
    
    //Metódo Construtor
    public Cliente(int id,String nome, String endereco, String bairro, String cidade, String uf, String cep, String email, String telefone){
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
        this.email = email;
        this.telefone = telefone;
    }
    
    //Getter and Setters
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    public String getEndereco() {return endereco;}
    public void setEndereco(String endereco) { this.endereco = endereco;}
    public String getBairro() {return bairro;}
    public void setBairro(String bairro) {this.bairro = bairro;}
    public String getCidade() {return cidade;}
    public void setCidade(String cidade) {this.cidade = cidade;}
    public String getUf() {return uf;}
    public void setUf(String uf) {this.uf = uf;}
    public String getCep() {return cep;}
    public void setCep(String cep) {this.cep = cep;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getTelefone() {return telefone;}
    public void setTelefone(String telefone) {this.telefone = telefone;}
}
