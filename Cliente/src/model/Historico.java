package model;

import java.io.Serializable;

public class Historico implements Serializable{
    private String usuario;
    private String moedaInicial;
    private double valorInicial;
    private String moedaFinal;
    private double valorFinal;

    public Historico(String usuario, double valorInicial, String moedaFinal, double valorFinal) {
        this.usuario = usuario;
        this.moedaInicial = "BRL";
        this.valorInicial = valorInicial;
        this.moedaFinal = moedaFinal;
        this.valorFinal = valorFinal;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getMoedaInicial() {
        return moedaInicial;
    }

    public void setMoedaInicial(String moedaInicial) {
        this.moedaInicial = moedaInicial;
    }

    public double getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(double valorInicial) {
        this.valorInicial = valorInicial;
    }

    public String getMoedaFinal() {
        return moedaFinal;
    }

    public void setMoedaFinal(String moedaFinal) {
        this.moedaFinal = moedaFinal;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    } 

}
