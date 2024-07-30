package com.PIetapa7e8.atividade1.model;

public class Fotovoltaico {
    
    private int id;
    private String fabricante;
    private int qtdPlacas;
    private float potPlacas;
    private float potGerador;
    private float potInversor;
    private String tipoTelhado;
    private String concessionaria;

    public Fotovoltaico() {
    }

    public Fotovoltaico(int id, String fabricante, int qtdPlacas, float potPlacas, float potGerador, float potInversor, String tipoTelhado, String concessionaria) {
        this.id = id;
        this.fabricante = fabricante;
        this.qtdPlacas = qtdPlacas;
        this.potPlacas = potPlacas;
        this.potGerador = potGerador;
        this.potInversor = potInversor;
        this.tipoTelhado = tipoTelhado;
        this.concessionaria = concessionaria;
    }
    
    //Getter and Setters
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getFabricante() {return fabricante;}
    public void setFabricante(String fabricante) {this.fabricante = fabricante;}
    public int getQtdPlacas() {return qtdPlacas;}
    public void setQtdPlacas(int qtdPlacas) {this.qtdPlacas = qtdPlacas;}
    public float getPotPlacas() {return potPlacas;}
    public void setPotPlacas(float potPlacas) {this.potPlacas = potPlacas;}
    public float getPotGerador() {return potGerador;}
    public void setPotGerador(float potGerador) {this.potGerador = potGerador;}
    public float getPotInversor() {return potInversor;}
    public void setPotInversor(float potInversor) {this.potInversor = potInversor;}
    public String getTipoTelhado() {return tipoTelhado;}
    public void setTipoTelhado(String telhado) {this.tipoTelhado = telhado;}
    public String getConcessionaria() {return concessionaria;}
    public void setConcessionaria(String concessionaria) {this.concessionaria = concessionaria;}
}
