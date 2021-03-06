/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;



import controladores.ControladorUsuarios;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Lucas
 */
public class TelaCadastro extends javax.swing.JFrame {    
    private ControladorUsuarios controladorUsuarios;
    /**
     * Creates new form Usuario
     */
    public TelaCadastro(ControladorUsuarios controladorUsuarios) {
        initComponents();
        //jtUsuario.setModel(userModel);
    }

    public JTable getJtUsuario() {
        return jtUsuario;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtUsuario = new javax.swing.JTable();
        tfNome = new javax.swing.JTextField();
        tfDataN = new javax.swing.JTextField();
        tfTelefone = new javax.swing.JTextField();
        tfSenha = new javax.swing.JTextField();
        tfEmail = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        tfCPF = new javax.swing.JFormattedTextField();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Cadastros");
        setForeground(java.awt.Color.white);
        setType(java.awt.Window.Type.POPUP);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CPF", "Nome", "Data Nascimento", "Telefone", "Senha", "E-mail"
            }
        ));
        jtUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtUsuarioMouseClicked(evt);
            }
        });
        jtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtUsuarioKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jtUsuario);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 193, 714, 163));
        getContentPane().add(tfNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 40, 242, -1));
        getContentPane().add(tfDataN, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 82, 109, -1));
        getContentPane().add(tfTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 82, 131, -1));
        getContentPane().add(tfSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 82, 152, -1));
        getContentPane().add(tfEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 126, 404, -1));

        jLabel1.setText("CPF");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, -1, -1));

        jLabel2.setText("Nome");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(171, 15, -1, -1));

        jLabel3.setText("Data de Nascimento");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 66, -1, -1));

        jLabel4.setText("Telefone");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 66, -1, -1));

        jLabel5.setText("Senha");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 66, -1, -1));

        jLabel6.setText("E-mail");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 106, -1, -1));

        btnSalvar.setText("Incluir");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 164, -1, -1));

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 164, -1, -1));

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 164, -1, -1));

        tfCPF.setBackground(new java.awt.Color(244, 244, 244));
        try {
            tfCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(tfCPF, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 156, -1));

        btnVoltar.setText("voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(btnVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(663, 11, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
        String login = (tfCPF.getText());
        String nome =(tfNome.getText());
        String dataN = (tfDataN.getText());
        String telefone = (tfTelefone.getText());
        String password = (tfSenha.getText());
        String email = (tfEmail.getText());
        
        JOptionPane.showMessageDialog(this, ControladorUsuarios.getInstance().cadastrarUsuarios(login, nome, dataN, telefone, password, email));
        ControladorUsuarios.getInstance().updateTableUsuarios();
       
        limparCampos();
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        if(jtUsuario.getSelectedRow() != -1){
            String login = (tfCPF.getText());
            JOptionPane.showMessageDialog(this, ControladorUsuarios.getInstance().deleteUser(login));
            ControladorUsuarios.getInstance().updateTableUsuarios();
            tfCPF.enable(true);
            
            limparCampos();
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        // TODO add your handling code here:
        if(jtUsuario.getSelectedRow() != -1){
            String login = (tfCPF.getText());
            String nome =(tfNome.getText());
            String dataN = (tfDataN.getText());
            String telefone = (tfTelefone.getText());
            String password = (tfSenha.getText());
            String email = (tfEmail.getText());
            
            JOptionPane.showMessageDialog(this,ControladorUsuarios.getInstance().updateUser(login, nome, dataN, telefone, password, email));
            ControladorUsuarios.getInstance().updateTableUsuarios();
            tfCPF.enable(true);
            
            limparCampos();
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void jtUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtUsuarioMouseClicked
        if(jtUsuario.getSelectedRow() != -1){
           tfCPF.setText(jtUsuario.getValueAt(jtUsuario.getSelectedRow(), 0).toString());
           tfNome.setText(jtUsuario.getValueAt(jtUsuario.getSelectedRow(), 1).toString());
           tfDataN.setText(jtUsuario.getValueAt(jtUsuario.getSelectedRow(), 2).toString());
           tfTelefone.setText(jtUsuario.getValueAt(jtUsuario.getSelectedRow(), 3).toString());
           tfSenha.setText(jtUsuario.getValueAt(jtUsuario.getSelectedRow(), 4).toString());
           tfEmail.setText(jtUsuario.getValueAt(jtUsuario.getSelectedRow(), 5).toString());
           tfCPF.enable(false);
           
        }
    }//GEN-LAST:event_jtUsuarioMouseClicked

    private void jtUsuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtUsuarioKeyReleased
        if(jtUsuario.getSelectedRow() != -1){
           tfCPF.setText(jtUsuario.getValueAt(jtUsuario.getSelectedRow(), 0).toString());
           tfNome.setText(jtUsuario.getValueAt(jtUsuario.getSelectedRow(), 1).toString());
           tfDataN.setText(jtUsuario.getValueAt(jtUsuario.getSelectedRow(), 2).toString());
           tfTelefone.setText(jtUsuario.getValueAt(jtUsuario.getSelectedRow(), 3).toString());
           tfSenha.setText(jtUsuario.getValueAt(jtUsuario.getSelectedRow(), 4).toString());
           tfEmail.setText(jtUsuario.getValueAt(jtUsuario.getSelectedRow(), 5).toString());
        }// TODO add your handling code here:
    }//GEN-LAST:event_jtUsuarioKeyReleased

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed
        
    public void limparCampos(){
        tfCPF.setText("");
        tfNome.setText("");
        tfDataN.setText("");
        tfTelefone.setText("");
        tfSenha.setText("");
        tfEmail.setText("");
    }
    
    /**
     * @param args the command line arguments
     */
    

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtUsuario;
    private javax.swing.JFormattedTextField tfCPF;
    private javax.swing.JTextField tfDataN;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfSenha;
    private javax.swing.JTextField tfTelefone;
    // End of variables declaration//GEN-END:variables
}
