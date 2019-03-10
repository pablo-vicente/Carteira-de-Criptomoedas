/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import controladores.ControladorTaxas;
import javax.swing.JOptionPane;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class TelaTaxas extends javax.swing.JFrame {
    private ControladorTaxas controladorTaxas;
    /**
     * Creates new form TelaTaxas
     */
    public TelaTaxas(ControladorTaxas controladorTaxas) {
        this.controladorTaxas = controladorTaxas;
        initComponents();
    }

    public void exibirTaxas(){
        double compra = controladorTaxas.getTaxa("Compra")*100;
        double venda = controladorTaxas.getTaxa("Venda")*100;
        double saque = controladorTaxas.getTaxa("Saque")*100;
        double deposito = controladorTaxas.getTaxa("Deposito")*100;
        
        campoTaxaCompra.setText(Double.toString(compra));
        campoTaxaVenda.setText(Double.toString(venda));
        campoTaxaSaque.setText(Double.toString(saque));
        campoTaxaDeposito.setText(Double.toString(deposito));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        JLogo = new javax.swing.JLabel();
        jCompra = new javax.swing.JLabel();
        JDeposito = new javax.swing.JLabel();
        jVenda = new javax.swing.JLabel();
        Jsaque = new javax.swing.JLabel();
        campoTaxaCompra = new javax.swing.JFormattedTextField();
        campoTaxaSaque = new javax.swing.JFormattedTextField();
        campoTaxaDeposito = new javax.swing.JFormattedTextField();
        campoTaxaVenda = new javax.swing.JFormattedTextField();
        botaoAtualizarTaxa = new javax.swing.JButton();
        botaoVoltar = new javax.swing.JButton();
        jCompra1 = new javax.swing.JLabel();
        jCompra2 = new javax.swing.JLabel();
        jCompra3 = new javax.swing.JLabel();
        jCompra4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Ajuste de Taxas");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        titulo.setBackground(new java.awt.Color(255, 255, 255));
        titulo.setFont(new java.awt.Font("Algerian", 1, 24)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("ajuste de taxa");

        JLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/telas/logos/7logoTaxas.jpg"))); // NOI18N

        jCompra.setBackground(new java.awt.Color(255, 255, 255));
        jCompra.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jCompra.setText("%");

        JDeposito.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        JDeposito.setText("Deposito:");

        jVenda.setBackground(new java.awt.Color(255, 255, 255));
        jVenda.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jVenda.setText("Venda:");

        Jsaque.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        Jsaque.setText("Saque:");

        campoTaxaCompra.setBackground(new java.awt.Color(244, 244, 244));
        campoTaxaCompra.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, java.awt.Color.lightGray, null, null));
        campoTaxaCompra.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        campoTaxaSaque.setBackground(new java.awt.Color(244, 244, 244));
        campoTaxaSaque.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, java.awt.Color.lightGray, null, null));
        campoTaxaSaque.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        campoTaxaDeposito.setBackground(new java.awt.Color(244, 244, 244));
        campoTaxaDeposito.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, java.awt.Color.lightGray, null, null));
        campoTaxaDeposito.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        campoTaxaVenda.setBackground(new java.awt.Color(244, 244, 244));
        campoTaxaVenda.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, java.awt.Color.lightGray, null, null));
        campoTaxaVenda.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        botaoAtualizarTaxa.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        botaoAtualizarTaxa.setText("AtualizarTaxas");
        botaoAtualizarTaxa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAtualizarTaxaActionPerformed(evt);
            }
        });

        botaoVoltar.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        botaoVoltar.setText("Voltar");
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });

        jCompra1.setBackground(new java.awt.Color(255, 255, 255));
        jCompra1.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jCompra1.setText("Compra:");

        jCompra2.setBackground(new java.awt.Color(255, 255, 255));
        jCompra2.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jCompra2.setText("%");

        jCompra3.setBackground(new java.awt.Color(255, 255, 255));
        jCompra3.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jCompra3.setText("%");

        jCompra4.setBackground(new java.awt.Color(255, 255, 255));
        jCompra4.setFont(new java.awt.Font("Perpetua", 0, 18)); // NOI18N
        jCompra4.setText("%");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JLogo)
                            .addComponent(botaoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(botaoAtualizarTaxa, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Jsaque, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(JDeposito, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                    .addComponent(jCompra1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(campoTaxaSaque, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoTaxaVenda, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(campoTaxaCompra, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                                    .addComponent(campoTaxaDeposito))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCompra2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCompra4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCompra3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoTaxaCompra)
                            .addComponent(jCompra)
                            .addComponent(jCompra1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoTaxaVenda)
                            .addComponent(jCompra3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Jsaque, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoTaxaSaque)
                            .addComponent(jCompra2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JDeposito, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoTaxaDeposito)
                            .addComponent(jCompra4)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(JLogo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoAtualizarTaxa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
        controladorTaxas.pedirTelalogin();
    }//GEN-LAST:event_botaoVoltarActionPerformed

    private void botaoAtualizarTaxaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAtualizarTaxaActionPerformed
        
        double taxaCompra = pedirInteiro(campoTaxaCompra.getText())/100;
        double taxaVenda = pedirInteiro(campoTaxaVenda.getText())/100;
        double taxaSaque = pedirInteiro(campoTaxaSaque.getText())/100;
        double taxaDeposito = pedirInteiro(campoTaxaDeposito.getText())/100;
        
        if(!(taxaCompra == -0.01 || taxaVenda ==-0.01 || taxaSaque == -0.01 || taxaDeposito == -0.01)){
            controladorTaxas.updateTaxa("Compra", taxaCompra);
            controladorTaxas.updateTaxa("Venda", taxaVenda);
            controladorTaxas.updateTaxa("Saque", taxaSaque);
            controladorTaxas.updateTaxa("Deposito", taxaDeposito);
            JOptionPane.showMessageDialog(null,"Taxas atualizadas!");
        }
    }//GEN-LAST:event_botaoAtualizarTaxaActionPerformed

    public double pedirInteiro(String campo){
        double number = -1;
        try {
            number = Double.parseDouble(campo);
        } catch (java.lang.NumberFormatException e) {
            JOptionPane.showMessageDialog(null,"Digite somente números!");
        }
        return number;
    }
    
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JDeposito;
    private javax.swing.JLabel JLogo;
    private javax.swing.JLabel Jsaque;
    private javax.swing.JButton botaoAtualizarTaxa;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JFormattedTextField campoTaxaCompra;
    private javax.swing.JFormattedTextField campoTaxaDeposito;
    private javax.swing.JFormattedTextField campoTaxaSaque;
    private javax.swing.JFormattedTextField campoTaxaVenda;
    private javax.swing.JLabel jCompra;
    private javax.swing.JLabel jCompra1;
    private javax.swing.JLabel jCompra2;
    private javax.swing.JLabel jCompra3;
    private javax.swing.JLabel jCompra4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jVenda;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
