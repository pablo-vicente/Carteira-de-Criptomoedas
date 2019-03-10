/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Connecton.ConnectionFactory;
import entidades.SaqueDeposito;
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
public class SaquesDepositosDAO {
    
    public ArrayList<SaqueDeposito> read(String login) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<SaqueDeposito> operacao = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM saqueDeposito WHERE login = ? ");
            stmt.setString(1, login);
            rs = stmt.executeQuery();

            while (rs.next()) {

                String tipo = (rs.getString("tipo"));
                String agencia = (rs.getString("agencia"));
                String conta = (rs.getString("conta"));
                double valor = (Double.parseDouble(rs.getString("valor")));
                double taxa = (Double.parseDouble(rs.getString("taxa")));
                double liquido = (Double.parseDouble(rs.getString("liquido")));
                
                SaqueDeposito t = new SaqueDeposito(tipo, agencia, conta, valor, taxa, liquido); 
                operacao.add(t);
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
        return operacao;

    }
    
    public String updateTroca(int id, String tipo, String agencia, String conta, double valor, double taxa, double liquido){
        String mensagemUpdate = "";
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE trocaMoedas SET tipo = ?, agencia = ?, conta = ?, valor = ?, taxa = ? , liquido = ? where id_SD = ?");
            
            stmt.setString(1, tipo);
            stmt.setString(2, agencia);
            stmt.setString(3, conta);
            stmt.setDouble(4, valor);
            stmt.setDouble(5, taxa);
            stmt.setDouble(6, liquido);
            stmt.setInt(7, id);

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
    
    public String inserir(String login,String tipo, String agencia, String conta, double valor, double taxa, double liquido) {
			String mensageCadastro = "";
			Connection con = null;
			PreparedStatement ps = null;

			try {			

				con = ConnectionFactory.getConnection();		

				Statement stmt = con.createStatement();
				
				String sql = "insert into saqueDeposito values (?, ?, ?, ?, ?, ?, ?);";

				ps = con.prepareStatement(sql);		
                                ps.setString(1, login);
				ps.setString(2, tipo);								
				ps.setString(3, agencia);
				ps.setString(4, conta);
				ps.setDouble(5, valor);
				ps.setDouble(6, taxa);
				ps.setDouble(7, liquido);

				ps.executeUpdate();
				ps.close();
                                mensageCadastro = "Salvo com sucesso!";
				
			} catch (SQLException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro ao inserir daque/deposito!", "Erro de inserção", JOptionPane.ERROR_MESSAGE);			
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
