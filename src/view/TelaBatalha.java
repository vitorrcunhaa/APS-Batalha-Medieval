package view;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import rede.AtorJogador;
import rede.EstadoDoJogo;

public class TelaBatalha extends javax.swing.JFrame {

    protected AtorJogador atorJogador;
    DefaultListModel model = new DefaultListModel();
    
    public TelaBatalha(AtorJogador atorJogador) {
        this.atorJogador = atorJogador;
        initComponents();
        inicializarImagensPersonagens();
        this.remove(jLabelImagemMeuPersonagem);
        mostrarMeusItens();
        setResizable(false);
        setVisible(true);
        if(this.atorJogador.comecouJogando()==false){
//            desabilitaBotoes();
        }
        else
            this.atorJogador.enviarEstado();
    }
    
    private void inicializarImagensPersonagens() {
        jLabelMostraMinhaVida.setText(Integer.toString(this.atorJogador.getJogador().getPersonagem().getVida()));
        jLabelMostrarMeuAtaque.setText(Integer.toString(this.atorJogador.getJogador().getPersonagem().getAtaque()));
        jLabelMostrarMinhaDefesa.setText(Integer.toString(this.atorJogador.getJogador().getPersonagem().getDefesa()));

        if(this.atorJogador.getJogador().getPersonagem().getTipo()=="Arqueiro"){
            jLabelImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arqueiro.jpg")));
            jLabelTipoPersonagemLocal.setText("Arqueiro");
        }
        else if(this.atorJogador.getJogador().getPersonagem().getTipo()=="Guerreiro"){
            jLabelImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/guerreiro.jpg")));
            jLabelTipoPersonagemLocal.setText("Guerreiro");
        }
        else if(this.atorJogador.getJogador().getPersonagem().getTipo()=="Mago"){
            jLabelImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mago.jpg")));
            jLabelTipoPersonagemLocal.setText("Mago");
        }
        else
            JOptionPane.showMessageDialog(null, "Tipo de personagem do jogador local não encontrado.");
    }
    
    private void mostrarMeusItens() {
        jListItens.setModel(model);
        String item1 = "poção de "+this.atorJogador.getJogador().getPersonagem().getTipoItem1();
        String item2 = "poção de "+this.atorJogador.getJogador().getPersonagem().getTipoItem2();
        String item3 = "poção de "+this.atorJogador.getJogador().getPersonagem().getTipoItem3();
        model.addElement(String.format(item1));
        model.addElement(String.format(item2));
        model.addElement(String.format(item3));
    }
   
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelEuSouUm = new javax.swing.JLabel();
        jLabelMeuOponenteEhUm = new javax.swing.JLabel();
        jLabelMinhaVida = new javax.swing.JLabel();
        jLabelVidaOponente = new javax.swing.JLabel();
        jLabelDanoCausado = new javax.swing.JLabel();
        jLabelMochila = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListItens = new javax.swing.JList<>();
        jButtonUsarItem = new javax.swing.JButton();
        jButtonDesistir = new javax.swing.JButton();
        jLabelImagemMeuPersonagem = new javax.swing.JLabel();
        jLabelImagemOponente = new javax.swing.JLabel();
        jButtonAtacar = new javax.swing.JButton();
        jLabelTipoPersonagemLocal = new javax.swing.JLabel();
        jLabelMostraMinhaVida = new javax.swing.JLabel();
        jLabelTipoPersonagemOponente = new javax.swing.JLabel();
        jLabelMostraVidaOponente = new javax.swing.JLabel();
        jLabelImagem = new javax.swing.JLabel();
        jLabelMostrarMeuAtaque = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelMostrarMinhaDefesa = new javax.swing.JLabel();
        jButtonRevelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);

        jLabelEuSouUm.setText("Eu sou um:");

        jLabelMeuOponenteEhUm.setText("Meu oponente é um:");

        jLabelMinhaVida.setText("Vida:");

        jLabelVidaOponente.setText("Vida do oponente:");

        jLabelDanoCausado.setText("Dano que causei no oponente");

        jLabelMochila.setText("Mochila");

        jListItens.setAutoscrolls(false);
        jScrollPane1.setViewportView(jListItens);

        jButtonUsarItem.setText("Usar item");
        jButtonUsarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUsarItemActionPerformed(evt);
            }
        });

        jButtonDesistir.setText("Desistir");
        jButtonDesistir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDesistirActionPerformed(evt);
            }
        });

        jLabelImagemOponente.setText("jLabel1");

        jButtonAtacar.setText("Atacar");
        jButtonAtacar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtacarActionPerformed(evt);
            }
        });

        jLabelTipoPersonagemLocal.setText("jLabel1");

        jLabelMostraMinhaVida.setText("jLabel2");

        jLabelTipoPersonagemOponente.setText("jLabel3");

        jLabelMostraVidaOponente.setText("jLabel4");

        jLabelMostrarMeuAtaque.setText("jLabel1");

        jLabel2.setText("Ataque:");

        jLabel3.setText("Defesa:");

        jLabelMostrarMinhaDefesa.setText("jLabel4");

        jButtonRevelar.setText("Revelar");
        jButtonRevelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRevelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelImagem)
                    .addComponent(jLabelImagemMeuPersonagem))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(228, 228, 228)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelEuSouUm)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelTipoPersonagemLocal))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabelMochila)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelMinhaVida)
                                        .addComponent(jLabel2))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabelMostrarMeuAtaque)
                                        .addComponent(jLabelMostraMinhaVida)
                                        .addComponent(jLabelMostrarMinhaDefesa)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDanoCausado)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelVidaOponente)
                                    .addComponent(jLabelMeuOponenteEhUm))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelMostraVidaOponente)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(jLabelTipoPersonagemOponente)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabelImagemOponente)))))
                        .addGap(45, 45, 45))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jButtonUsarItem))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(72, 72, 72)
                        .addComponent(jButtonAtacar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 176, Short.MAX_VALUE)
                        .addComponent(jButtonRevelar)
                        .addGap(40, 40, 40)
                        .addComponent(jButtonDesistir)
                        .addGap(163, 163, 163))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabelImagem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelImagemMeuPersonagem))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelMeuOponenteEhUm)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabelVidaOponente)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelDanoCausado))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabelEuSouUm, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelTipoPersonagemLocal))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabelMinhaVida)
                                            .addComponent(jLabelMostraMinhaVida)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelTipoPersonagemOponente)
                                    .addComponent(jLabelImagemOponente))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelMostraVidaOponente)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButtonDesistir)
                                    .addComponent(jButtonRevelar)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(jButtonAtacar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabelMostrarMeuAtaque))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabelMostrarMinhaDefesa))
                                .addGap(15, 15, 15)
                                .addComponent(jLabelMochila)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonUsarItem)))))
                .addContainerGap(92, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonUsarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUsarItemActionPerformed
        // TODO add your handling code here:
        String item = jListItens.getSelectedValue();
        if(item.equals("poção de vida")){
            int vida = Integer.parseInt(jLabelMostraMinhaVida.getText()) + 10;
            jLabelMostraMinhaVida.setText(Integer.toString(vida));
            this.atorJogador.getJogador().getPersonagem().setVida(vida);
        }
        else if(item.equals("poção de ataque")){
            int ataque = Integer.parseInt(jLabelMostrarMeuAtaque.getText()) + 10;
            jLabelMostrarMeuAtaque.setText(Integer.toString(ataque));
            this.atorJogador.getJogador().getPersonagem().setAtaque(ataque);
        }
        else if(item.equals("poção de defesa")){
            int defesa = Integer.parseInt(jLabelMostrarMinhaDefesa.getText()) + 10;
            jLabelMostrarMinhaDefesa.setText(Integer.toString(defesa));
            this.atorJogador.getJogador().getPersonagem().setDefesa(defesa);
        }
        else
            JOptionPane.showMessageDialog(null, "Nome do item não corresponde.");
        model.remove(jListItens.getSelectedIndex());
        jButtonUsarItem.setEnabled(false);
    }//GEN-LAST:event_jButtonUsarItemActionPerformed

    private void jButtonDesistirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDesistirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonDesistirActionPerformed

    private void jButtonAtacarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtacarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAtacarActionPerformed

    private void jButtonRevelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRevelarActionPerformed
        // TODO add your handling code here:
        this.atorJogador.enviarEstado();
    }//GEN-LAST:event_jButtonRevelarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAtacar;
    private javax.swing.JButton jButtonDesistir;
    private javax.swing.JButton jButtonRevelar;
    private javax.swing.JButton jButtonUsarItem;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelDanoCausado;
    private javax.swing.JLabel jLabelEuSouUm;
    private javax.swing.JLabel jLabelImagem;
    private javax.swing.JLabel jLabelImagemMeuPersonagem;
    private javax.swing.JLabel jLabelImagemOponente;
    private javax.swing.JLabel jLabelMeuOponenteEhUm;
    private javax.swing.JLabel jLabelMinhaVida;
    private javax.swing.JLabel jLabelMochila;
    private javax.swing.JLabel jLabelMostraMinhaVida;
    private javax.swing.JLabel jLabelMostraVidaOponente;
    private javax.swing.JLabel jLabelMostrarMeuAtaque;
    private javax.swing.JLabel jLabelMostrarMinhaDefesa;
    private javax.swing.JLabel jLabelTipoPersonagemLocal;
    private javax.swing.JLabel jLabelTipoPersonagemOponente;
    private javax.swing.JLabel jLabelVidaOponente;
    private javax.swing.JList<String> jListItens;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void desabilitaBotoes() {
        jButtonAtacar.setEnabled(false);
        jButtonUsarItem.setEnabled(false);
        jButtonDesistir.setEnabled(false);
    }
    
    public void atualizarInterface(EstadoDoJogo estado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}