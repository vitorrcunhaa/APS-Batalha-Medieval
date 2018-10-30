/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Random;
import javax.swing.JOptionPane;
import rede.AtorJogador;

/**
 *
 * @author Vitor
 */
public class TelaEscolhaPersonagem extends javax.swing.JFrame {
    
    protected AtorJogador atorJogador;
            
    public TelaEscolhaPersonagem(AtorJogador atorJogador) {
        this.atorJogador = atorJogador;
        initComponents();
    }
    
        public void exibeTela() {
        setResizable(false);
        setVisible(true);
        }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBoxTipoPersonagem = new javax.swing.JComboBox<>();
        jLabelSelecioneTipoPersonagem = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabelVinculadoImagem = new javax.swing.JLabel();
        jButtonReceberAtributos = new javax.swing.JButton();
        jLabelAtaque = new javax.swing.JLabel();
        jLabelDefesa = new javax.swing.JLabel();
        jLabelVida = new javax.swing.JLabel();
        jLabelEscondidoAtaque = new javax.swing.JLabel();
        jLabelEscondidoDefesa = new javax.swing.JLabel();
        jLabelEscondidoVida = new javax.swing.JLabel();
        jLabelModificadorAtaque = new javax.swing.JLabel();
        jLabelModificadorDefesa = new javax.swing.JLabel();
        jLabelModificadorVida = new javax.swing.JLabel();
        jButtonFinalizar = new javax.swing.JButton();
        jLabelMeusAtributos = new javax.swing.JLabel();
        jLabelDescricaoPersonagem = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabelNomePersonagem = new javax.swing.JLabel();
        jButtonOk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Escolha seu personagem");
        setResizable(false);

        jComboBoxTipoPersonagem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Arqueiro", "Guerreiro", "Mago" }));
        jComboBoxTipoPersonagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipoPersonagemActionPerformed(evt);
            }
        });

        jLabelSelecioneTipoPersonagem.setText("Selecione o tipo de personagem:");

        jLabelVinculadoImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arqueiro.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jLabelVinculadoImagem)
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelVinculadoImagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButtonReceberAtributos.setText("Receber Atributos");
        jButtonReceberAtributos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReceberAtributosActionPerformed(evt);
            }
        });

        jLabelAtaque.setText("Ataque:");

        jLabelDefesa.setText("Defesa:");

        jLabelVida.setText("Vida:");

        jLabelModificadorAtaque.setText("+");

        jLabelModificadorDefesa.setText("+");

        jLabelModificadorVida.setText("+");

        jButtonFinalizar.setText("Finalizar");
        jButtonFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFinalizarActionPerformed(evt);
            }
        });

        jLabelMeusAtributos.setText("Meus atributos:");

        jLabelDescricaoPersonagem.setText("A vantagem de ser um arqueiro é que se tem muito poder de ataque!");

        jLabel7.setText("Dê um nome a ele:");

        jTextFieldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeActionPerformed(evt);
            }
        });

        jButtonOk.setText("Ok");
        jButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonReceberAtributos)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jButtonFinalizar)))
                        .addGap(109, 109, 109))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelDescricaoPersonagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelMeusAtributos)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonOk)
                                .addGap(47, 47, 47))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelAtaque)
                                    .addComponent(jLabelDefesa)
                                    .addComponent(jLabelVida))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelEscondidoVida)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelModificadorVida))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelEscondidoDefesa)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelModificadorDefesa))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelEscondidoAtaque)
                                        .addGap(58, 58, 58)
                                        .addComponent(jLabelModificadorAtaque))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(133, 133, 133)
                                .addComponent(jLabelNomePersonagem))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jLabelSelecioneTipoPersonagem)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxTipoPersonagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelSelecioneTipoPersonagem)
                            .addComponent(jComboBoxTipoPersonagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelDescricaoPersonagem, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonOk))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelNomePersonagem)
                        .addGap(10, 10, 10)
                        .addComponent(jLabelMeusAtributos)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelAtaque)
                            .addComponent(jLabelEscondidoAtaque)
                            .addComponent(jLabelModificadorAtaque))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelDefesa)
                            .addComponent(jLabelEscondidoDefesa)
                            .addComponent(jLabelModificadorDefesa))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelVida)
                            .addComponent(jLabelEscondidoVida)
                            .addComponent(jLabelModificadorVida))
                        .addGap(39, 39, 39)
                        .addComponent(jButtonReceberAtributos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonFinalizar)
                        .addGap(12, 12, 12))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxTipoPersonagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipoPersonagemActionPerformed
        // TODO add your handling code here:
        if(jComboBoxTipoPersonagem.getSelectedItem().toString()=="Arqueiro")
        {
            jLabelVinculadoImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arqueiro.jpg")));
            jLabelDescricaoPersonagem.setText("A vantagem de ser um arqueiro é que se tem muito poder de ataque!");
        }
        else if(jComboBoxTipoPersonagem.getSelectedItem().toString()=="Guerreiro")
        {
            jLabelVinculadoImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/guerreiro.jpg")));
            jLabelDescricaoPersonagem.setText("A vantagem de ser um guerreiro é que se tem muita vida!");
        }
        else if(jComboBoxTipoPersonagem.getSelectedItem().toString()=="Mago")
        {
            jLabelVinculadoImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mago.jpg")));
            jLabelDescricaoPersonagem.setText("A vantagem de ser um mago é que se tem muito poder de defesa!");
        }
        else
        {
            jLabelVinculadoImagem.setText("Imagem não encontrada");
        }
    }//GEN-LAST:event_jComboBoxTipoPersonagemActionPerformed

    private void jButtonReceberAtributosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReceberAtributosActionPerformed
        // TODO add your handling code here:
        Random r = new Random();
        int maximo = 12;
        int minimo = 1;
        int modificadorAtaque = r.nextInt(maximo-minimo) + minimo;
        int modificadorDefesa = r.nextInt(maximo-minimo) + minimo;
        int modificadorVida = r.nextInt(maximo-minimo) + minimo;

        
       int ataqueGuerreiro = 100;
       int defesaGuerreiro = 100;
       int vidaGuerreiro = 110;
       
       int ataqueArqueiro = 110;
       int defesaArqueiro = 100;
       int vidaArqueiro = 100;

       int ataqueMago = 100;
       int defesaMago = 110;
       int vidaMago = 100;

        if(jButtonOk.isEnabled()==false)
        {
            if(jComboBoxTipoPersonagem.getSelectedItem().toString()=="Guerreiro"){
                jLabelEscondidoAtaque.setText(Integer.toString(ataqueGuerreiro+modificadorAtaque));
                jLabelEscondidoDefesa.setText(Integer.toString(defesaGuerreiro+modificadorDefesa));
                jLabelEscondidoVida.setText(Integer.toString(vidaArqueiro+modificadorVida));
                jLabelModificadorAtaque.setText("+"+Integer.toString(modificadorAtaque));
                jLabelModificadorDefesa.setText("+"+Integer.toString(modificadorDefesa));
                jLabelModificadorVida.setText("+"+Integer.toString(modificadorVida));


            }
            else if(jComboBoxTipoPersonagem.getSelectedItem().toString()=="Arqueiro"){
                jLabelEscondidoAtaque.setText(Integer.toString(ataqueArqueiro+modificadorAtaque));
                jLabelEscondidoDefesa.setText(Integer.toString(defesaArqueiro+modificadorDefesa));
                jLabelEscondidoVida.setText(Integer.toString(vidaArqueiro+modificadorVida));
                jLabelModificadorAtaque.setText("+"+Integer.toString(modificadorAtaque));
                jLabelModificadorDefesa.setText("+"+Integer.toString(modificadorDefesa));
                jLabelModificadorVida.setText("+"+Integer.toString(modificadorVida));
            }
            else if(jComboBoxTipoPersonagem.getSelectedItem().toString()=="Mago"){
                jLabelEscondidoAtaque.setText(Integer.toString(ataqueMago+modificadorAtaque));
                jLabelEscondidoDefesa.setText(Integer.toString(defesaMago+modificadorDefesa));
                jLabelEscondidoVida.setText(Integer.toString(vidaMago+modificadorVida));
                jLabelModificadorAtaque.setText("+"+Integer.toString(modificadorAtaque));
                jLabelModificadorDefesa.setText("+"+Integer.toString(modificadorDefesa));
                jLabelModificadorVida.setText("+"+Integer.toString(modificadorVida));
            }
            else
            {
                JOptionPane.showMessageDialog(jPanel1, "Tipo de personagem não encontrado");
            }
            jButtonReceberAtributos.setEnabled(false);
            jComboBoxTipoPersonagem.setEnabled(false);
        }
        else
            JOptionPane.showMessageDialog(jPanel1, "Escolha o nome do personagem");
    }//GEN-LAST:event_jButtonReceberAtributosActionPerformed

    private void jTextFieldNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeActionPerformed

    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOkActionPerformed
        // TODO add your handling code here:
        if (jTextFieldNome.getText().length()>0){
            jLabelNomePersonagem.setText("Eu sou o (a) "+ jTextFieldNome.getText()+"!");
            jTextFieldNome.setEnabled(false);
            jButtonOk.setEnabled(false);
        }
        else{
            JOptionPane.showMessageDialog(jPanel1, "escolha um nome para o personagem!");
        }
    }//GEN-LAST:event_jButtonOkActionPerformed

    private void jButtonFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFinalizarActionPerformed
        // TODO add your handling code here:
        if(jButtonReceberAtributos.isEnabled()==false){
            this.dispose();
        }
        else
            JOptionPane.showMessageDialog(jPanel1, "Para finalizar você deve receber os atributos!");
        this.atorJogador.criarPersonagem(jComboBoxTipoPersonagem.getSelectedItem().toString(), 
                                         Integer.parseInt(jLabelEscondidoAtaque.getText()), 
                                         Integer.parseInt(jLabelEscondidoDefesa.getText()), 
                                         Integer.parseInt(jLabelEscondidoVida.getText()));
    }//GEN-LAST:event_jButtonFinalizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonFinalizar;
    private javax.swing.JButton jButtonOk;
    private javax.swing.JButton jButtonReceberAtributos;
    private javax.swing.JComboBox<String> jComboBoxTipoPersonagem;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelAtaque;
    private javax.swing.JLabel jLabelDefesa;
    private javax.swing.JLabel jLabelDescricaoPersonagem;
    private javax.swing.JLabel jLabelEscondidoAtaque;
    private javax.swing.JLabel jLabelEscondidoDefesa;
    private javax.swing.JLabel jLabelEscondidoVida;
    private javax.swing.JLabel jLabelMeusAtributos;
    private javax.swing.JLabel jLabelModificadorAtaque;
    private javax.swing.JLabel jLabelModificadorDefesa;
    private javax.swing.JLabel jLabelModificadorVida;
    private javax.swing.JLabel jLabelNomePersonagem;
    private javax.swing.JLabel jLabelSelecioneTipoPersonagem;
    private javax.swing.JLabel jLabelVida;
    private javax.swing.JLabel jLabelVinculadoImagem;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldNome;
    // End of variables declaration//GEN-END:variables

}
