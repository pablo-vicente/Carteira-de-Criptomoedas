/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controladores;


import Dao.UsuarioDao;
import entidades.Carteira;
import entidades.Usuario;
import javax.swing.table.DefaultTableModel;
import telas.TelaCadastro;
import telas.TelaLogin;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ControladorUsuarios {
    private static ControladorUsuarios instance;
    private ControladorPrincipal controladorPrincipal;
    private TelaLogin telaLogin;
    private TelaCadastro telaCadastro;
    private UsuarioDao usuarioDao;
    //private ArrayList<Usuario> usuarios;

    public ControladorUsuarios() {
        this.telaLogin = new TelaLogin(this);
        this.telaCadastro = new TelaCadastro(null);
        this.usuarioDao= new UsuarioDao();
        //this.usuarios= new ArrayList<>();
    }
    
    public String cadastrarUsuarios(String login, String nome, String DataN, String telefone, String password, String email) {
        
        String cadastro = usuarioDao.registrarUsuario(login, nome, DataN, telefone, password, email);
        ControladorPrincipal.getInstance().cadastrarCarteira(login);
        return cadastro;
        
    }

    
    public boolean autenticarUsuario(String login, String senha){
        return usuarioDao.isUsuario(login, senha);
    }
    
    public String updateUser(String login, String nome, String dataN, String telefone, String password, String email){
        return  usuarioDao.updateUser(login, nome, dataN, telefone, password, email);
    }
    
    public String deleteUser(String login){
        String cadDelete =  usuarioDao.delete(login);
        ControladorPrincipal.getInstance().deletarCarteira(login);
        return cadDelete;
    }
    
    public void exibirTelaLogin(){
       telaLogin.setVisible(true);
       telaLogin.setResizable(false);
       telaLogin.setLocationRelativeTo(null);
    }
    
    public void pedirTelaCarteira(String login){
        telaLogin.setVisible(false);
        ControladorPrincipal.getInstance().pedirTelaCarteira(login);
    }
    
    public void exibirTelaCadastro(){
        telaCadastro.setVisible(true);
        telaCadastro.setResizable(false);
        telaCadastro.setLocationRelativeTo(null);
        updateTableUsuarios();
    }
    
    public void pedirTelaTaxas(){
        telaLogin.setVisible(false);
        ControladorPrincipal.getInstance().perdirTelaDeAjusteTaxas();
    }
   
    public void updateTableUsuarios(){
        DefaultTableModel modelo = (DefaultTableModel) telaCadastro.getJtUsuario().getModel();
        modelo.setNumRows(0);
        for(Usuario usuario: usuarioDao.read()){
            String login = usuario.getLogin();
            String nome =usuario.getNome();
            String dataN = usuario.getDataN();
            String telefone = usuario.getTelefone();
            String password = usuario.getTelefone();
            String email = usuario.getEmail();
            modelo.addRow(new Object[]{login,nome,dataN,telefone,password,email});
            //telaCadastro.updateTableUsuarios(login, nome, dataN, telefone, password, email);
        }
    }
    
    public static ControladorUsuarios getInstance(){
        if(instance==null){
            instance = new ControladorUsuarios();
        }
        return instance;
    }   
}
