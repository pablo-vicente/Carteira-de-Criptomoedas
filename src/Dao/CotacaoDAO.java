/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Connecton.ConnectionFactory;
import entidades.Cotacao;
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
public class CotacaoDAO {
    
    public ArrayList<Cotacao> read() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<Cotacao> cotacoes = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM cotacao");
           
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idMoeda = (rs.getInt("id_Moeda"));
                String tipo = (rs.getString("tipoMoeda"));
                double cotacao = (Double.parseDouble(rs.getString("cotacao")));               
                Cotacao t = new Cotacao(idMoeda, tipo, cotacao); 
                cotacoes.add(t);
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
        return cotacoes;

    }
    
    public String updateCotacao (int Id, String tipoMoeda, double cotacao){
        String mensagemUpdate = "";
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE cotacao SET tipoMoeda = ?, cotacao = ? where id_Moeda = ?");
            
            stmt.setString(1, tipoMoeda);
            stmt.setDouble(2, cotacao);
            stmt.setInt(3, Id);

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
