/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Connecton.ConnectionFactory;
import entidades.Taxa;
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
public class TaxasDAO {
    
    public ArrayList<Taxa> read() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<Taxa> taxas = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM taxa");
            rs = stmt.executeQuery();

            while (rs.next()) {
                String nome = (rs.getString("tipoTaxa"));
                double taxa = (Double.parseDouble(rs.getString("valorTaxa")));               
                Taxa t = new Taxa(nome, taxa); 
                taxas.add(t);
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
        return taxas;

    }
    
    public String updateTaxa (String tipoTaxa, double valorTaxa){
        String mensagemUpdate = "";
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE taxa SET valorTaxa = ? where tipoTaxa = ?");
            
            stmt.setDouble(1, valorTaxa);
            stmt.setString(2, tipoTaxa);
           

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
