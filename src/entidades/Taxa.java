/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Taxa {
    private String nome;
    private double porcetagem;

    public Taxa(String nome, double porcetagem) {
        this.nome = nome;
        this.porcetagem = porcetagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPorcetagem() {
        return porcetagem;
    }

    public void setPorcetagem(double porcetagem) {
        this.porcetagem = porcetagem;
    }
    
    
}
