/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Connecton.ConnectionFactory;
import entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas
 */
public class UsuarioDao {
    
    Connection con;
    
    public String registrarUsuario(String login, String nome, String DataN, String telefone, String password, String email) {
        String mensageCadastro = "";
        Connection con = ConnectionFactory.getConnection();	
            
        String sql = "INSERT INTO usuario (CPf,Nome,DataN,Telefone,Senha,Email)VALUES(?,?,?,?,?,?)";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, login);
            stmt.setString(2, nome);
            stmt.setString(3, DataN);
            stmt.setString(4, telefone);
            stmt.setString(5, password);
            stmt.setString(6, email);
            stmt.executeUpdate();

            mensageCadastro = "Salvo com sucesso!";
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
    
    public static boolean isUsuario(String login, String senha){		

        // Variáveis locais
        Connection con = null;		
        String sql = "";

        // Cria um objeto do tipo Administrativo para receber o resultado da busca (select)
        boolean  autenticacao = false;

        try {
                // Faz a conexão com o Banco
                con = ConnectionFactory.getConnection();
                // Cria um objeto do tipo Statement				
                Statement stmt = con.createStatement();
                // Define a string de SQL que deve ser executada
                sql = "select * from usuario where CPf = '" + login + "' and Senha = '" + senha + "'";	
                // Executa a string SQL e atribui os dados resultantes em um ResultSet
                ResultSet rs = stmt.executeQuery(sql);
                // Tenta posicionar o ponteiro no próximo registro do rs
                // Se conseguir (o select retornou um resultado) retorna true, senão (se o rs estiver vazio) ocorrerá uma exception
                if(rs.next()){
                        // Recupera o código e o nome do registro encontrado no banco e armazena no objeto admLogado
                        autenticacao= true;
                }			
                // Fecha o ResultSet			
                rs.close();

        } catch (SQLException erro) {  // Captura erros referente a instruções SQL
                erro.printStackTrace();

        } catch (Exception erro) { // Captura erros imprevistos
                erro.printStackTrace();

        } finally{ // Será executado ocorrendo ou não um erro no bloco try			
                try{
                        // Fecha a conexão
                        con.close();				
                }catch(Exception e){
                        e.printStackTrace();
                }
        }
        // Retorna o objeto admProcurado
        return autenticacao;
    }

    public List<Usuario> read() {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Usuario> usuarios = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM usuario");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Usuario user = new Usuario();

                user.setLogin(rs.getString("CPf"));
                user.setNome(rs.getString("Nome"));
                user.setDataN(rs.getString("DataN"));
                user.setTelefone(rs.getString("Telefone"));
                user.setPassword(rs.getString("Senha"));
                user.setEmail(rs.getString("Email"));
                usuarios.add(user);
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

        return usuarios;

    }
   
    public String updateUser (String login, String nome, String dataN, String telefone, String password, String email){
        String mensagemUpdate = "";
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE usuario SET Nome = ?,DataN = ?,Telefone = ?,Senha = ?,Email = ? where cpf = ?");
            
            stmt.setString(1, nome);
            stmt.setString(2, dataN);
            stmt.setString(3, telefone);
            stmt.setString(4, password);
            stmt.setString(5, email);
            stmt.setString(6, login);

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
    
    public String delete(String login) {
        String mensagemDelete = "";
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM usuario WHERE CPf = ?");
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
}
