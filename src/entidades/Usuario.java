/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entidades;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Usuario {
    String CPf;
    Carteira Carteira;
    String Nome;
    String DataN;
    String Telefone;
    String Senha;
    String Email;

    public Usuario( String cpf, String nome, String dataN, String telefone, String senha, String email) {
        this.CPf = cpf;
        this.Nome = nome;
        this.DataN = dataN;
        this.Telefone= telefone;
        this.Senha = senha;
        this.Email = email;
        this.Carteira = new Carteira();
    }
    
    public Usuario(){
        this("", "", "", "", "", "");    
    }

    public Carteira getCarteira() {
        return Carteira;
    }

    public void setCarteira(Carteira Carteira) {
        this.Carteira = Carteira;
    }

    public String getLogin() {
        return CPf;
    }

    public void setLogin(String CPf) {
        this.CPf = CPf;
    }
    
     public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }
    
    public String getDataN() {
        return DataN;
    }

    public void setDataN(String dataN) {
        this.DataN = dataN;
    }
    
    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        this.Telefone = telefone;
    }
    
    public String getEmail() {
        return Email;
    }
    
    public void setEmail(String email) {
        this.Email = email;
    }

    public String getPassword() {
        return Senha;
    }

    public void setPassword(String password) {
        this.Senha = password;
    }
    
    

}
