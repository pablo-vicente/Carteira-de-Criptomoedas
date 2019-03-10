/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Lucas
 */
public class Conversao {
    
    private String tipo;
    private String moeda;
    private double montante;
    private double valor;
    private double cotacao;
    private double taxa;
    private double liquido;

    public Conversao() {
        this("","",0,0,0,0,0);
    }

    public Conversao(String tipo, String moeda, double montante, double valor, double cotacao, double taxa, double liquido) {
        this.tipo = tipo;
        this.moeda = moeda;
        this.montante = montante;
        this.valor = valor;
        this.cotacao = cotacao;
        this.taxa = taxa;
        this.liquido = liquido;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMoeda() {
        return moeda;
    }

    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }

    public double getMontante() {
        return montante;
    }

    public void setMontante(double montante) {
        this.montante = montante;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getCotacao() {
        return cotacao;
    }

    public void setCotacao(double cotacao) {
        this.cotacao = cotacao;
    }

    public double getTaxa() {
        return taxa;
    }

    public void setTaxa(double taxa) {
        this.taxa = taxa;
    }

    public double getLiquido() {
        return liquido;
    }

    public void setLiquido(double liquido) {
        this.liquido = liquido;
    }
    
}
