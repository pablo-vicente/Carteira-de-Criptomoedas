/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Connecton.ConnectionFactory;
import entidades.Conversao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author pablo
 */
public class ConversaoMoedasDAO {
    
    public ArrayList<Conversao> read(String login) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<Conversao> troca = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM trocaMoedas WHERE login = ? ");
            stmt.setString(1, login);
            rs = stmt.executeQuery();
            

            while (rs.next()) {

                String tipo = (rs.getString("tipo"));
                String moeda = (rs.getString("moeda"));
                double montante = (Double.parseDouble(rs.getString("montante"))); 
                double valor = (Double.parseDouble(rs.getString("valor")));
                double cotacao = (Double.parseDouble(rs.getString("cotacao")));
                double taxa = (Double.parseDouble(rs.getString("taxa")));
                double liquido = (Double.parseDouble(rs.getString("liquido")));
                
                Conversao t = new Conversao(tipo,moeda, montante, valor, cotacao, taxa, liquido); 
                troca.add(t);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConversaoMoedasDAO.class.getName()).log(Level.SEVERE, null, ex);
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
        return troca;

    }
    /*
    public String updateTroca(int id, String tipo, String moeda,double montante,double valor,double cotacao,double taxa, double liquido){
        String mensagemUpdate = "";
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE trocaMoedas SET tipo = ?, moeda = ?, montante = ?, valor = ?, cotacao = ? , taxa = ? , liquido = ? where id_troca = ?");
            
            stmt.setString(1, tipo);
            stmt.setString(2, moeda);
            stmt.setDouble(3, montante);
            stmt.setDouble(4, valor);
            stmt.setDouble(5, cotacao);
            stmt.setDouble(6, taxa);
            stmt.setDouble(7, liquido);
            stmt.setInt(8, id);

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
    }*/
    /*
    public String registarHistoricoTrocasMoedas() {
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
    }/*/
    
    public String inserir(String id_carteira, String tipo, String moeda, double montante, double valor, double cotacao, double taxa, double liquido) {
			String mensageCadastro = "";
			Connection con = null;
			PreparedStatement ps = null;

			try {			

				con = ConnectionFactory.getConnection();		

				Statement stmt = con.createStatement();
				
                                
	
				String sql = "insert into trocaMoedas values (?, ?, ?, ?, ?, ?, ?,?);";

				ps = con.prepareStatement(sql);		
                                ps.setString(1, id_carteira);
				ps.setString(2, tipo);								
				ps.setString(3, moeda);
				ps.setDouble(4, montante);
				ps.setDouble(5, valor);
                                ps.setDouble(6, cotacao);
				ps.setDouble(7, taxa);
				ps.setDouble(8, liquido);

				ps.executeUpdate();
				ps.close();
                                mensageCadastro = "Salvo com sucesso!";
				
			} catch (SQLException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro ao inserir conversão!", "Erro de inserção", JOptionPane.ERROR_MESSAGE);			
			} finally{			
				try{				
					con.close();				
				}catch(Exception e){
					e.printStackTrace();
				}			
			}
                        return mensageCadastro;
		}
    
}
