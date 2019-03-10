/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Connecton.ConnectionFactory;
import entidades.Moeda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pablo
 */
public class CarteiraDAO {
    
     public String registrarCarteiraUsuario(String login) {
        String mensageCadastro = "";
        Connection con = ConnectionFactory.getConnection();	
        String sql2 = "INSERT INTO carteira (CPF_carteira,bitcoin,litecoin,bcash,monero,dogecoin,reais) VALUES (?,0.0,0.0,0.0,0.0,0.0,0.0);" ;
        PreparedStatement stmt2 = null;
        try {
 
            stmt2 = con.prepareStatement(sql2);           
            stmt2.setString(1, login);

            stmt2.executeUpdate();

            mensageCadastro = "carteira Criada!";
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            try{
                // Fecha a conexão
                con.close();				
            }catch(Exception e){
                    e.printStackTrace();
            }
        }
        return mensageCadastro;
    }
     
    public ArrayList<Moeda> read(String login) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        ArrayList<Moeda> moedas = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM carteira WHERE CPF_carteira = ?");
            stmt.setString(1, login);
            rs = stmt.executeQuery();

            while (rs.next()) {
                
                double quantBitcoin = Double.parseDouble(rs.getString("bitcoin"));
                double quantliteCoin = Double.parseDouble(rs.getString("litecoin"));
                double quantbcash = Double.parseDouble(rs.getString("bcash"));
                double quantmonero = Double.parseDouble(rs.getString("monero"));
                double quantdogeCoin = Double.parseDouble(rs.getString("dogecoin"));
                double quantreal = Double.parseDouble(rs.getString("reais"));
                
                Moeda bitcoin = new Moeda(1, "Bitcoin", quantBitcoin);
                Moeda litCoin = new Moeda(2, "litecoin", quantliteCoin);
                Moeda bcash = new Moeda(3, "bcash", quantbcash);
                Moeda monero = new Moeda(4, "monero", quantmonero);
                Moeda dogeCoin = new Moeda(5, "dogecoin", quantdogeCoin);
                Moeda real = new Moeda(6, "Real", quantreal);
                moedas.add(bitcoin);
                moedas.add(litCoin);
                moedas.add(bcash);
                moedas.add(monero);
                moedas.add(dogeCoin);
                moedas.add(real);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try{
                // Fecha a conexão
                con.close();
                rs.close();
                stmt.close();
                
            }catch(Exception e){
                    e.printStackTrace();
            }
        }
        return moedas;

    }
     
     public String delete(String login) {
        String mensagemDelete = "";
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM carteira WHERE CPF_carteira = ?");
            stmt.setString(1, login);

            stmt.executeUpdate();

            mensagemDelete="Excluido com sucesso!";
        } catch (SQLException ex) {
            mensagemDelete = "Erro ao excluir: " + ex;
        } finally {
            try{
                // Fecha a conexão
                con.close();				
            }catch(Exception e){
                    e.printStackTrace();
            }
        }
        return  mensagemDelete;
    }
     
    public String updateCarteiraUser (String login, double qntBitcoin, double qntLitecoin, double qntBcash, double qntMonero, double qntDogecoin, double qntReais){
        String mensagemUpdate = "";
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE carteira SET bitcoin = ?,litecoin =  ?,bcash =  ?,monero =  ?,dogecoin =  ?, reais =  ? where CPF_carteira = ?;");
            
            stmt.setDouble(1, qntBitcoin);
            stmt.setDouble(2, qntLitecoin);
            stmt.setDouble(3, qntBcash);
            stmt.setDouble(4, qntMonero);
            stmt.setDouble(5, qntDogecoin);
            stmt.setDouble(6, qntReais);
            stmt.setString(7, login);

            stmt.executeUpdate();

            mensagemUpdate = "Atualizado com sucesso!";
        } catch (SQLException ex) {
            mensagemUpdate =  "Erro ao atualizar: " + ex;
        } finally {
            try{
                // Fecha a conexão
                con.close();				
            }catch(Exception e){
                    e.printStackTrace();
            }
        }
        return mensagemUpdate;
    }
     
}
