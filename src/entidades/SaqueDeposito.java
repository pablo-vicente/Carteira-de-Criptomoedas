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
public class SaqueDeposito {
    
    private String tipo;
    private String agencia;
    private String conta;
    private double valor;
    private double taxa;
    private double liquido;

    public SaqueDeposito() {
        this("","","",0,0,0);
    }

    public SaqueDeposito(String tipo, String agencia, String conta, double valor, double taxa, double liquido) {
        this.tipo = tipo;
        this.agencia = agencia;
        this.conta = conta;
        this.valor = valor;
        this.taxa = taxa;
        this.liquido = liquido;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
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
