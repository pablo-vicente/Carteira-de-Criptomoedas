/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controladores;


/**
 * Release 3.1
 * @author Pablo Vicente 
 */
public class ControladorPrincipal {
    private static ControladorPrincipal instance;
    private ControladorUsuarios controladorUsuarios;
    private ControladorCarteira controladorCarteira;
    private ControladorCotacao controladorCotacao;
    private ControladorTaxas controladorTaxas;
    
    
    
    public ControladorPrincipal(){
        this.controladorCarteira = ControladorCarteira.getIinstance();
        this.controladorUsuarios = ControladorUsuarios.getInstance();
        this.controladorCotacao = ControladorCotacao.getInstance();
        this.controladorTaxas = ControladorTaxas.getInstance();
    }
    
    public double getCotacao(int codMoeda){
        return controladorCotacao.getCotacaoMoeda(codMoeda);
    }

    public void pedirTelaLogin(){
        controladorUsuarios.getInstance().exibirTelaLogin();
    }
    
    public void pedirTelaCarteira(String login){
        //controladorCarteira.setCateira(controladorUsuarios.getCarteira(login));
        controladorCarteira.exibirTelaCarteira(login);
    }
    
    public void perdirTelaDeAjusteTaxas(){
        controladorTaxas.exibirTelaTaxas();
    }
    
    public void updateCotacao(){
        controladorCotacao.updateCotacao();
    }
    
    public double getTaxa(String operacao){
        return controladorTaxas.getTaxa(operacao);
    }
    
    public static ControladorPrincipal getInstance(){
        if(instance==null){
            instance = new ControladorPrincipal();
        }
        return instance;
    }
    
    public void cadastrarCarteira(String Login){
        ControladorCarteira.getIinstance().cadastrarCarteiraUsuarios(Login);
    }
    
    public void deletarCarteira(String Login){
        ControladorCarteira.getIinstance().deletarCarteiraUsuarios(Login);
    }
           
}
