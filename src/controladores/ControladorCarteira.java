/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controladores;

import Dao.CarteiraDAO;
import Dao.ConversaoMoedasDAO;
import Dao.SaquesDepositosDAO;
import entidades.Conversao;
import entidades.Moeda;
import entidades.SaqueDeposito;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import telas.TelaCarteira;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ControladorCarteira {
    private TelaCarteira telaCarteira;
    private static ControladorCarteira instance;
    private ControladorPrincipal controladorPrincipal;
    private CarteiraDAO carteiraDao;
    private String login;
    private ConversaoMoedasDAO conversaoMoedasDAO;
    private SaquesDepositosDAO saquesDepositoDAO;
    private boolean trocaMoedaCampoMontante;
    /*quando usario digitar a quantidade de moedas no campo montante as conversão é feita cotacao * quantidade digitada
    quando usuario digitar valor em reais que deseja compra a conversão será feita valordigitado / cotacao da moeda 
    */                                        
    //private Carteira carteira;
    
    public ControladorCarteira(){
        this.telaCarteira = new TelaCarteira(this);
        this.carteiraDao = new CarteiraDAO();
        this.trocaMoedaCampoMontante = true;
        this.conversaoMoedasDAO = new ConversaoMoedasDAO();
        this.saquesDepositoDAO = new SaquesDepositosDAO();
    }
    public void exibirTelaCarteira(String login){
        this.login = login;
        telaCarteira.setVisible(true);
        telaCarteira.setResizable(false);
        telaCarteira.setLocationRelativeTo(null);
        exibirDadosCarteira();
        updateTableTrocaMoedas();
    }
     
    public String cadastrarCarteiraUsuarios(String login) {
       return carteiraDao.registrarCarteiraUsuario(login);
    }
    
    public String deletarCarteiraUsuarios(String login) {
       return carteiraDao.delete(login);
    }
     
     //Atualiza a tela de carteira com informações da carteira do usuario
    public void exibirDadosCarteira(){
        /*
        1 Bitcoin
        2 litcoin
        3 Bcash
        4 Monero
        5 Dogcoin
        */
        
        
        double qntBitcoin  = 0;
        double qntLitecoin = 0;//Pega a quantidade de litcoin
        double qntBcach    = 0;//Pega a quantidade de bcash
        double qntMonero   = 0;//Pega a quantidade de monero
        double qntDogecoin = 0;//Pega a quantidade de dogcoin
        double qntReal     = 0;//Pega a quantidade de reais
        
        qntBitcoin  = getQuantidadeMoeda(1);//Pega a quantidade de bitcoin
        qntLitecoin = getQuantidadeMoeda(2);//Pega a quantidade de litcoin
        qntBcach    = getQuantidadeMoeda(3);//Pega a quantidade de bcash
        qntMonero   = getQuantidadeMoeda(4);//Pega a quantidade de monero
        qntDogecoin = getQuantidadeMoeda(5);//Pega a quantidade de dogcoin
        qntReal     = getQuantidadeMoeda(6);//Pega a quantidade de reais
                /*
        1 Bitcoin
        2 litcoin
        3 Bcash
        4 Monero
        5 Dogcoin
        */

        double cotacaoMoeda1 = ControladorPrincipal.getInstance().getCotacao(1);//Pega a contacao do bitcoin
        double cotacaoMoeda2 = ControladorPrincipal.getInstance().getCotacao(2);//Pega a contacao do litcoin
        double cotacaoMoeda3 = ControladorPrincipal.getInstance().getCotacao(3);//Pega a contacao do bcash
        double cotacaoMoeda4 = ControladorPrincipal.getInstance().getCotacao(4);//Pega a contacao do monero
        double cotacaoMoeda5 = ControladorPrincipal.getInstance().getCotacao(5);//Pega a contacao do dogecoin
        
        double bitcoinEmReais = qntBitcoin* cotacaoMoeda1;//Faz a conversão de acordo com a cotacao
        double litcoinEmReais = qntLitecoin* cotacaoMoeda2;//Faz a conversão de acordo com a cotacao
        double bcashEmReais = qntBcach* cotacaoMoeda3;//Faz a conversão de acordo com a cotacao
        double moneroEmReais = qntMonero* cotacaoMoeda4;//Faz a conversão de acordo com a cotacao
        double dogecoinEmReais = qntDogecoin* cotacaoMoeda5;//Faz a conversão de acordo com a cotacao
        
        double[] qntMoedas = new double[] {qntBitcoin,qntLitecoin,qntBcach,qntMonero,qntDogecoin,qntReal};//Passa um arrays com todas as quantiadades a moeda 6 corresponde ao saldo em reais da carteira
        double[] cotacaoMoedas = new double[] {cotacaoMoeda1,cotacaoMoeda2,cotacaoMoeda3,cotacaoMoeda4,cotacaoMoeda5};//Passa a cotacao de todas as moedas
        double[] moedasConvertidasReais = new double[] {bitcoinEmReais,litcoinEmReais,bcashEmReais,moneroEmReais,dogecoinEmReais};//Passa as saldo da carteira de cada moeda
        
        telaCarteira.exibirDadosCarteira(qntMoedas, cotacaoMoedas, moedasConvertidasReais);//update tela de carteira com inforamções
     } 
     
    //Atualiza as JTable na tela de carteira
    public void updateTableTrocaMoedas(){
        DefaultTableModel modelo2 = (DefaultTableModel) telaCarteira.getJtabelaTrocaMoedas().getModel();
        modelo2.setNumRows(0);
     
        for(Conversao conversao: conversaoMoedasDAO.read(login)){
            
            String tipo = conversao.getTipo();
            String moeda  =conversao.getMoeda();
            String brutoMoeda = telaCarteira.formatarParaExibir(conversao.getMontante());
            String valor = telaCarteira.formatarParaExibir(conversao.getValor());
            String cotacao = telaCarteira.formatarParaExibir(conversao.getCotacao());
            String taxa = telaCarteira.formatarParaExibir(conversao.getTaxa());
            String liquidoMoeda = telaCarteira.formatarParaExibir(conversao.getLiquido());
            modelo2.addRow(new Object[] {tipo,moeda,brutoMoeda,valor,cotacao,taxa,liquidoMoeda});
        }
        
        DefaultTableModel modelo3 = (DefaultTableModel) telaCarteira.gettabelaSaquesDepositos().getModel();
        modelo3.setNumRows(0);
        
        for(SaqueDeposito saqueDeposito:saquesDepositoDAO.read(login)){
            String tipo = saqueDeposito.getTipo();
            String agencia = saqueDeposito.getAgencia();
            String conta = saqueDeposito.getConta();
            String valorDeposito = telaCarteira.formatarParaExibir(saqueDeposito.getValor());
            String taxa = telaCarteira.formatarParaExibir(saqueDeposito.getTaxa());
            String valorLiquido = telaCarteira.formatarParaExibir(saqueDeposito.getLiquido());
            modelo3.addRow(new Object[] {tipo,agencia,conta,valorDeposito,taxa,valorLiquido});
        }
    }
     
     //Registra a compra de moedas
     public String compraMoedas(int moeda, double qntBrutoMoeda, double valorCompra){
        String mensagemCompra = "Não foi possivel realizar troca verifique seus dados!";
        double [] dadosConversao = null;
        double cotacao = 0;
        double qntTaxa = 0;
        double qntLiquida = 0;
        double quantidadesMoedas;
        
        //Cod 6 corresponde a carteira de reais
        double saldoCarteiraReais = getQuantidadeMoeda(6);
        if(valorCompra<=0){
            mensagemCompra = "Não foi possivel realizar troca de valores negativos ou nulos!";
            //Cod corresponde a carteira de reais
        }else if(saldoCarteiraReais<valorCompra){
             mensagemCompra = "Saldo insuficiente!";
        }else{
            if(trocaMoedaCampoMontante){
                dadosConversao = conversorCompraVendaMoeda(moeda, qntBrutoMoeda, 0, "Compra");
                valorCompra = dadosConversao[0];//valor Compra
                cotacao = dadosConversao[1];
                qntTaxa = dadosConversao[2];
                qntLiquida = dadosConversao[3];
                //double quantidadesMoedas = dadosConversao[4];///e o mantante fia 
            }else{
               dadosConversao=  conversorCompraVendaMoeda(moeda, 0, valorCompra, "Compra");
               //valorCompra = dadosConversao[0];// passado 
               cotacao = dadosConversao[1];
               qntTaxa = dadosConversao[2];
               qntLiquida = dadosConversao[3];
               quantidadesMoedas = dadosConversao[4];///e o mantante fia 
            }
            
            saldoCarteiraReais = saldoCarteiraReais- valorCompra;//Pega carteira em reais e subrtrai a compra
            double saldoMoedasComprada = getQuantidadeMoeda(moeda) + qntLiquida;//pega a quantiada de moeda da carteira e adiciona a quantidade comprada
            
            //Cod 6 corresponde a carteira de reais
            updateCarteira(6, saldoCarteiraReais, moeda, saldoMoedasComprada);//atualiza a carteira com as moedas compradas
            //conversaoMoedasDAO aqui vai metodo para salvar na carteira
            exibirDadosCarteira();//Atualiza a tela de cartira exibindo os novos saldos
            mensagemCompra = "Compra realizada com sucesso!";
            
            String nomeMoeda = getNomeMoeda(moeda);//Pega o nome da moeda para registro
            conversaoMoedasDAO.inserir(login,"Compra",nomeMoeda,qntBrutoMoeda,valorCompra,cotacao,qntTaxa,qntLiquida);//salva no banco de dados a transação
            
            ControladorPrincipal.getInstance().updateCotacao();//solicita atualização da cotação
        }
        exibirDadosCarteira();//Atualiza a tela de carteira exibindo os novos saldos
        updateTableTrocaMoedas();//atualiza as duas JTable na carteira
        return mensagemCompra;
     }
     
     //|Registra a venda de moedas
     public String vendaMoedas(int moeda,double quantidadeMoedaVendida, double valorVendaMoeda){
        String mensagemVenda = "Não foi possivel realizar troca verifique seus dados!";
        double [] dadosConversao = null;
        double cotacao = ControladorPrincipal.getInstance().getCotacao(moeda);
        double valorTaxa = 0;
        double valorLiquido =0;
        double quantidadesMoedas;
        double qntMoeda = getQuantidadeMoeda(moeda); // armazena a quantidade de moedas que será vendida
        double saldoCarteiraReais = getQuantidadeMoeda(6);//Codigo 6 corresponde a moeda REAIS
        if(quantidadeMoedaVendida<=0){
            mensagemVenda = "Não foi possivel realizar troca de valores negativos ou nulos!";
        }else if(quantidadeMoedaVendida>qntMoeda || valorVendaMoeda > qntMoeda*cotacao){
                    mensagemVenda = "Saldo insuficiente";
                }else {
                    if(trocaMoedaCampoMontante){          
                        dadosConversao = conversorCompraVendaMoeda(moeda, quantidadeMoedaVendida, 0, "Venda");
                        valorVendaMoeda = dadosConversao[0];
                        cotacao = dadosConversao[1];
                        valorTaxa = dadosConversao[2]*cotacao;
                        valorLiquido = dadosConversao[3]*cotacao;
                        //quantidadesMoedas = dadosConversao[4];///Corresponde ao montante
                    }else if(!(trocaMoedaCampoMontante)){
                        dadosConversao = conversorCompraVendaMoeda(moeda, 0, valorVendaMoeda, "Venda");
                        //valorVendaMoeda = dadosConversao[0];
                        cotacao = dadosConversao[1];
                        valorTaxa = dadosConversao[2]*cotacao;
                        valorLiquido = dadosConversao[3]*cotacao;
                        quantidadesMoedas = dadosConversao[4];///Corresponde ao montante
                    }
                    qntMoeda = qntMoeda - quantidadeMoedaVendida;//Altarar o valor  moeda subrtraidn a quantidade anteriir pela quantidade vendida
                    saldoCarteiraReais = saldoCarteiraReais+valorLiquido;//Pega valor da carteira em REAIS e adiciona o valor corresponde a venda das moedas
                    updateCarteira(6, saldoCarteiraReais, moeda, qntMoeda);
                    mensagemVenda = "Venda realizada com sucesso!";
                    String nomeMoeda = getNomeMoeda(moeda);
                    conversaoMoedasDAO.inserir(login,"Venda", nomeMoeda, quantidadeMoedaVendida, valorVendaMoeda, cotacao, valorTaxa, valorLiquido);//Registar a venda na tabela
        }
        ControladorPrincipal.getInstance().updateCotacao();
        updateTableTrocaMoedas();//atualiza as duas JTable na carteira
        exibirDadosCarteira();//Atualiza a tela de cartira exibindo os novos saldos
        return mensagemVenda;
     }
     
     //faz a conversão do keyRelease no painel de compras
    public double[] conversorCompraVendaMoeda(int moeda,double montante,double valorCompra,String operacao){
        double cotacao = ControladorPrincipal.getInstance().getCotacao(moeda);
        double valorMoeda = 0;
        double qntTaxa =0 ;
        double qntLiquida = 0;
        double quantidadesMoedas = 0;
        
        double[] dadosCoversao = null;
        if(valorCompra == 0){//O que passa o moantante para converter
            double[] dadosOperacao = calcularTaxas(operacao,montante);//Passa o montante bruto e retorna a quantidade liquida e a quantidade taxada
            qntTaxa = dadosOperacao[0];//quanitadae taxada
            qntLiquida = dadosOperacao[1];//valor liquido
            valorMoeda = cotacao*montante; // calcula valor comprado da moeda
        }else{//quando o montante passado e zero
            quantidadesMoedas = valorCompra/cotacao;//calcula a quantidade de moedas de acordo com valor da compra
            double[] dadosOperacao = calcularTaxas(operacao,quantidadesMoedas);//Passa o montante bruto e retorna a quantidade liquida e a quantidade taxada
            qntTaxa = dadosOperacao[0];//quanitadae taxada
            qntLiquida = dadosOperacao[1];//valor liquido
        }
        dadosCoversao = new double[]{valorMoeda,cotacao,qntTaxa,qntLiquida,quantidadesMoedas};//passa para tela os dados que serao exibidos
        return dadosCoversao;
     }
     
     //Realiza deposito de moedas na carteira
     public String depositar(String agencia, String conta,double valorDeposito, double taxa, double valorLiquido){
        double qntCarteiraReais = getQuantidadeMoeda(6);//Código 6 corresponde a moeda REAIS - pega a quantidade de reais na carteire
        String mensagemDeposito = "Não foi possivel realizar depósito verifique seus dados!";
        if((agencia.equals("    - ") || conta.equals("    - "))){
            mensagemDeposito = "Agência ou Conta estão em brancos";
        } else if(valorLiquido<=0){
                mensagemDeposito = "Não foi possivel realizar depósito de valores negativos ou nulos!";
            }else if(valorLiquido>0){
                    //Codigo 6 corresponde a carteira de reais
                    qntCarteiraReais = (qntCarteiraReais+valorLiquido);//alerar o saldo de reais da conta
                    updateCarteira(6, qntCarteiraReais, 6, qntCarteiraReais);
                    
                    mensagemDeposito = "Deposito realizado com sucesso!";
                    saquesDepositoDAO.inserir(login,"Deposito", agencia, conta, valorDeposito, taxa, valorLiquido);
                    ControladorPrincipal.getInstance().updateCotacao();
                }
        exibirDadosCarteira();//realiza updateTableSaquesDepositos do dados exibidos na tela
        updateTableTrocaMoedas();//atualiza as duas JTable na carteira
            
        return mensagemDeposito;
     }
     
     //Realiza saque de moedas carteira
     public String sacar(String saqueAgencia, String saqueConta,double valorBrutoSaque, double taxaSaque, double valorLiquidoSaque){
        String mensgemSaque = "Não foi possivel realizar saque verifique seus dados!";
        double qntCarteiraReais = getQuantidadeMoeda(6);
        if((saqueAgencia.equals("    - ") || saqueConta.equals("    - "))){
            mensgemSaque = "Agência ou Conta estão em brancos";
        }else if(valorLiquidoSaque<=0){
                    mensgemSaque= "Não foi possivel realizar depósito de valores negativos ou nulos!";
                }else if(qntCarteiraReais<valorLiquidoSaque){
                    mensgemSaque = "Saldo insuficiente!";
                }else{
                    //codigo 6 corresponde a carteira de REAIS
                    qntCarteiraReais = (qntCarteiraReais-valorLiquidoSaque);//retirar da carteira o valor scado
                    updateCarteira(6, qntCarteiraReais, 6, qntCarteiraReais);
                    mensgemSaque = "Saque realizado com sucesso!";
                    saquesDepositoDAO.inserir(login,"Saque", saqueAgencia, saqueConta, valorBrutoSaque, taxaSaque, valorLiquidoSaque);
                    ControladorPrincipal.getInstance().updateCotacao();
                }
        updateTableTrocaMoedas();//atualiza as duas JTable na carteira
        exibirDadosCarteira();//Atualiza as informaaçoes na tela de carteira
        return mensgemSaque;
     }
     
     //Calcula e retorna o valor liquido e valor de taxa
     public double[] calcularTaxas(String operacao, double valorBruto){
        double taxa = ControladorPrincipal.getInstance().getTaxa(operacao);
        double valorTaxa = (valorBruto*taxa);
        double valorLiquido = (valorBruto-valorTaxa);
        
        double[] dadosOperacao = new double[]{valorTaxa,valorLiquido};
        return dadosOperacao;
     }
    
     public double getQuantidadeMoeda(int codMoeda){
        double quantidadeMoeda = 0;
        for(Moeda moeda:carteiraDao.read(login)){
            if(moeda.getCodigo()==codMoeda){
                quantidadeMoeda = moeda.getQuantidade();
                break;
            }
        }
        return quantidadeMoeda;
     }
     
     public String getNomeMoeda(int codigo){
         return carteiraDao.read(login).get(codigo-1).getNome();
     }
     
     public void pedirTelaLogin(){
         ControladorPrincipal.getInstance().pedirTelaLogin();
         telaCarteira.setVisible(false);
     }

     public void updateCarteira(int codMoeda1, double qntMoedas1,int codMoeda2, double qntMoeda2){
        ArrayList<Moeda>moedas = carteiraDao.read(login);
        for(Moeda moeda:moedas){
            if(moeda.getCodigo()==codMoeda1){
                moeda.setQuantidade(qntMoedas1);
            }else if(moeda.getCodigo()==codMoeda2){
                moeda.setQuantidade(qntMoeda2);
            }
        }
        
        double qntBitcoin = moedas.get(0).getQuantidade();
        double qntLitecoin = moedas.get(1).getQuantidade();
        double qntBcash = moedas.get(2).getQuantidade();
        double qntMonero = moedas.get(3).getQuantidade();
        double qntDogecoin = moedas.get(4).getQuantidade();
        double qntReas = moedas.get(5).getQuantidade();
        
        carteiraDao.updateCarteiraUser(login,qntBitcoin, qntLitecoin, qntBcash, qntMonero, qntDogecoin, qntReas);
     }
     
    public void setTrocaMoedaCampoMontante(boolean trocaMoedaCampoMontante) {
        this.trocaMoedaCampoMontante = trocaMoedaCampoMontante;
    }
     
    public static ControladorCarteira getIinstance(){
        if(instance==null){
            instance = new ControladorCarteira();
        }
        return instance;
    }
}
