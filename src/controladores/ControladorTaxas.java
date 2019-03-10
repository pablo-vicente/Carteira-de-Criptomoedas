/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controladores;

import Dao.TaxasDAO;
import entidades.Cotacao;
import entidades.Taxa;
import telas.TelaTaxas;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ControladorTaxas {
    private static ControladorTaxas instance;
    private TelaTaxas telaTaxas;
    private TaxasDAO taxaDAO;
    //private ArrayList<Taxa>taxas;
    

    public ControladorTaxas() {
      //  this.taxas = new ArrayList<>();
      this.taxaDAO = new TaxasDAO();
        this.telaTaxas = new TelaTaxas(this);
        iniciarTaxas();
    }
    
    public void iniciarTaxas(){
        for(Taxa taxa :taxaDAO.read()){
            if(taxa.getPorcetagem()==0){//pega valor se for nulo adciona
                taxaDAO.updateTaxa(taxa.getNome(), 0.09);//
                }
            }    
        }
    

    public double getTaxa(String operacao) {
        double valorTaxa = 0;
        for(Taxa taxa : taxaDAO.read()){
            if(taxa.getNome().equals(operacao)){
                System.out.println("");
                valorTaxa = taxa.getPorcetagem();
                break;
            }
        }
        return valorTaxa;
    }
    
    public void updateTaxa(String operacao, double newTaxa) {
        for(Taxa taxa : taxaDAO.read()){
            if(taxa.getNome().equals(operacao)){
                taxaDAO.updateTaxa(operacao, newTaxa);
            }
        }
    }
    public void exibirTelaTaxas(){
        telaTaxas.setVisible(true);
        telaTaxas.setResizable(false);
        telaTaxas.setLocationRelativeTo(null);
        telaTaxas.exibirTaxas();
    }
    
    public void pedirTelalogin(){
        telaTaxas.setVisible(false);
        ControladorPrincipal.getInstance().pedirTelaLogin();
    }
  
    public static ControladorTaxas getInstance(){
        if(instance==null){
            instance = new ControladorTaxas();
        }
        return instance;
    }   
    
}
