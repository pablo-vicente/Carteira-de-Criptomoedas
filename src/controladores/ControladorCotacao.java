/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controladores;

import Dao.CotacaoDAO;
import entidades.Cotacao;
import java.util.Random;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ControladorCotacao {
    private static ControladorCotacao instance;
    private CotacaoDAO cotacaoDao;
    //private ArrayList<Cotacao>cotacoes;
    
    public ControladorCotacao() {
        //this.cotacoes = new ArrayList<>();
        this.cotacaoDao = new CotacaoDAO();
        iniciarCotacoes();
    }
    
    public void iniciarCotacoes(){
        for(Cotacao cotacao :cotacaoDao.read()){
            if(cotacao.getValor()==0){//pega valor se for nulo adciona
                switch(cotacao.getCod()){
                    case 1:
                        cotacaoDao.updateCotacao(1, "Bitcoin", 30000);//Bitcoin
                        break;
                    case 2:
                        cotacaoDao.updateCotacao(2, "Litcoin", 600);//litecoin
                        break;
                    case 3:
                        cotacaoDao.updateCotacao(3, "Bcash", 6000);//bcash
                        break;
                    case 4:
                        cotacaoDao.updateCotacao(4, "Monero", 1000);//Monero
                        break;
                    case 5:
                        cotacaoDao.updateCotacao(5, "Dogecoin", 0.01);//Bitcoin
                        break;
                }
            }    
        }
    }
    
    public void updateCotacao(){
        for(Cotacao cotacao : cotacaoDao.read()){
            Random random = new Random();
            double variacao = Math.random()+0.5;
            double novaoCotacao = (cotacao.getValor()*variacao);
            cotacaoDao.updateCotacao(cotacao.getCod(), cotacao.getNome(), novaoCotacao);
        }
    }

    public double getCotacaoMoeda(int codigo){
        double cotacaoMoeda = 0;
        for(Cotacao cotacao :cotacaoDao.read()){
            if(cotacao.getCod()==codigo){
                cotacaoMoeda = cotacao.getValor();
                break;
            }
        }
        return cotacaoMoeda;
    }
    
    public static ControladorCotacao getInstance(){
        if(instance==null){
            instance = new ControladorCotacao();
        }
        return instance;
    }  

}
