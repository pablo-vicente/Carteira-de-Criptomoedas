/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades;

import java.util.ArrayList;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Carteira {
    private ArrayList<Moeda>moedas;

    public Carteira() {
        this.moedas = new ArrayList<>();
        criarMoedas();

    }

    public void criarMoedas(){
        Moeda bitcoin = new Moeda(1,"Bitcoin",0);
        Moeda litecoin = new Moeda(2,"Litecoin",0);
        Moeda bcash = new Moeda(3,"Bcash",0);
        Moeda monero = new Moeda(4,"Moneoro",0);
        Moeda dogecoin = new Moeda(5,"Dogecoin",0);
        Moeda real = new Moeda(6,"Real",0);
        
        moedas.add(bitcoin);
        moedas.add(litecoin);
        moedas.add(bcash);
        moedas.add(monero);
        moedas.add(dogecoin);
        moedas.add(real);
    }

    public double getQuantidadeMoeda(int codigo){
        double quantidadeMoedas =0;
        for(Moeda moeda :moedas){
            if(moeda.getCodigo()==codigo){
                quantidadeMoedas = moeda.getQuantidade();
                break;
            }
        }
        return quantidadeMoedas;
    }
    
    public void setQuantidadeMoedas(int codigo, double quantiadade){
        for(Moeda moeda :moedas){
            if(moeda.getCodigo()==codigo){
                moeda.setQuantidade(quantiadade);
                break;
            }
        }
    }

    public void setMoedas(ArrayList<Moeda> moedas) {
        this.moedas = moedas;
    }
    
        public String getNomeMoeda(int codigo){
        String nome ="";
        for(Moeda moeda :moedas){
            if(moeda.getCodigo()==codigo){
                nome = moeda.getNome();
                break;
            }
        }
        return nome;
    }

}
