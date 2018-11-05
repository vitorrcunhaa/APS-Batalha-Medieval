/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Random;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.Jogador;
import rede.AtorJogador;
import javax.swing.JOptionPane;

/**
 *
 * @author Vitor
 */
public class TelaJornada extends javax.swing.JFrame {

    protected AtorJogador atorJogador;
    protected DefaultListModel model = new DefaultListModel();
    protected int cliques = 0;
    public Jogador jogador;

    public TelaJornada(AtorJogador ator) {
        this.atorJogador = ator;
        initComponents();
        jListItens.setModel(model);
    }

    public void exibeTela() {
        setResizable(false);
        setVisible(true);
        inicializaJogador();
    }
    
    public void habilitarBotoes() {
        this.jButtonTerminarJogada.setEnabled(true);
        this.jComboBoxCaminho.setEnabled(true);
        this.jButtonIr.setEnabled(true);
    }
    
    public void desabilitarBotoes() {
        this.jButtonTerminarJogada.setEnabled(false);
        this.jComboBoxCaminho.setEnabled(false);
        this.jButtonIr.setEnabled(false);
    }

    private void inicializaJogador() {
        this.jogador = this.atorJogador.getJogador();
        if (this.jogador.getPosicaoAtual() == 1) {
            this.jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaUmNaPosicao.png")));
        } else if (this.jogador.getPosicaoAtual() == 16) {
            this.jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaDezesseisNaPosicao.png")));
            desabilitarBotoes();
        }
    }

    public boolean calculaMovimento(int posicao, String caminho) {
        if (posicao == 1) {
            if (caminho == "Norte") {
                JOptionPane.showMessageDialog(null, "Voce nao pode ir para o Norte, escolha um caminho válido.");
                return false;
            } else if (caminho == "Sul") {
                this.jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaUm.png")));
                this.jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaCincoNaPosicao.png")));
                this.jogador.setPosicaoAtual(5);
            } else if (caminho == "Leste") {
                this.jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaUm.png")));
                this.jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaDoisNaPosicao.png")));
                this.jogador.setPosicaoAtual(2);
            } else if (caminho == "Oeste") {
                JOptionPane.showMessageDialog(null, "Voce nao pode ir para o Oeste, escolha um caminho válido.");
                return false;
            }
        } else if (posicao == 2) {
            if (caminho == "Norte") {
                JOptionPane.showMessageDialog(null, "Voce nao pode ir para o Norte, escolha um caminho válido.");
                return false;
            } else if (caminho == "Sul") {
                this.jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaDois.png")));
                this.jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaSeisNaPosicao.png")));
                this.jogador.setPosicaoAtual(6);
            } else if (caminho == "Leste") {
                this.jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaDois.png")));
                this.jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaTresNaPosicao.png")));
                this.jogador.setPosicaoAtual(3);
            } else if (caminho == "Oeste") {
                this.jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaDois.png")));
                this.jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaUmNaPosicao.png")));
                this.jogador.setPosicaoAtual(1);
            }
        } else if (posicao == 3) {
            if (caminho == "Norte") {
                JOptionPane.showMessageDialog(null, "Voce nao pode ir para o Norte, escolha um caminho válido.");
                return false;
            } else if (caminho == "Sul") {
                this.jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaTres.png")));
                this.jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaSeteNaPosicao.png")));
                this.jogador.setPosicaoAtual(7);
            } else if (caminho == "Leste") {
                this.jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaTres.png")));
                this.jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaQuatroNaPosicao.png")));
                this.jogador.setPosicaoAtual(4);
            } else if (caminho == "Oeste") {
                this.jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaTres.png")));
                this.jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaDoisNaPosicao.png")));
                this.jogador.setPosicaoAtual(2);
            }
        } else if (posicao == 4) {
            if (caminho == "Norte") {
                JOptionPane.showMessageDialog(null, "Voce nao pode ir para o Norte, escolha um caminho válido.");
                return false;
            } else if (caminho == "Sul") {
                this.jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaQuatro.png")));
                this.jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaOitoNaPosicao.png")));
                this.jogador.setPosicaoAtual(8);
            } else if (caminho == "Leste") {
                JOptionPane.showMessageDialog(null, "Voce nao pode ir para o Norte, escolha um caminho válido.");
                return false;
            } else if (caminho == "Oeste") {
                this.jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaQuatro.png")));
                this.jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaTres.png")));
                this.jogador.setPosicaoAtual(3);
            }
        } else if (posicao == 5) {
            if (caminho == "Norte") {
                this.jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaCinco.png")));
                this.jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaUmNaPosicao.png")));
                this.jogador.setPosicaoAtual(1);
            } else if (caminho == "Sul") {
                this.jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaCinco.png")));
                this.jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaNoveNaPosicao.png")));
                this.jogador.setPosicaoAtual(9);
            } else if (caminho == "Leste") {
                this.jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaCinco.png")));
                this.jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaSeisNaPosicao.png")));
                this.jogador.setPosicaoAtual(6);
            } else if (caminho == "Oeste") {
                JOptionPane.showMessageDialog(null, "Voce nao pode ir para o Oeste, escolha um caminho válido.");
                return false;
            }
        } else if (posicao == 6) {
            if (caminho == "Norte") {
                this.jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaSeis.png")));
                this.jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaDoisNaPosicao.png")));
                this.jogador.setPosicaoAtual(2);
            } else if (caminho == "Sul") {
                this.jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaSeis.png")));
                this.jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaDezNaPosicao.png")));
                this.jogador.setPosicaoAtual(10);
            } else if (caminho == "Leste") {
                this.jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaSeis.png")));
                this.jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaSeteNaPosicao.png")));
                this.jogador.setPosicaoAtual(7);
            } else if (caminho == "Oeste") {
                this.jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaSeis.png")));
                this.jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaCincoNaPosicao.png")));
                this.jogador.setPosicaoAtual(5);
            }
        } else if (posicao == 7) {
            if (caminho == "Norte") {
                this.jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaSete.png")));
                this.jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaTresNaPosicao.png")));
                this.jogador.setPosicaoAtual(3);
            } else if (caminho == "Sul") {
                this.jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaSete.png")));
                this.jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaOnzeNaPosicao.png")));
                this.jogador.setPosicaoAtual(11);
            } else if (caminho == "Leste") {
                this.jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaSete.png")));
                this.jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaOitoNaPosicao.png")));
                this.jogador.setPosicaoAtual(8);
            } else if (caminho == "Oeste") {
                this.jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaSete.png")));
                this.jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaSeisNaPosicao.png")));
                this.jogador.setPosicaoAtual(6);
            }
        } else if (posicao == 8) {
            if (caminho == "Norte") {
                this.jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaOito.png")));
                this.jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaQuatroNaPosicao.png")));
                this.jogador.setPosicaoAtual(4);
            } else if (caminho == "Sul") {
                this.jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaOito.png")));
                this.jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaDozeNaPosicao.png")));
                this.jogador.setPosicaoAtual(12);
            } else if (caminho == "Leste") {
                JOptionPane.showMessageDialog(null, "Voce nao pode ir para o Oeste, escolha um caminho válido.");
                return false;
            } else if (caminho == "Oeste") {
                this.jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaOito.png")));
                this.jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaSeteNaPosicao.png")));
                this.jogador.setPosicaoAtual(7);
            }
        } else if (posicao == 9) {
            if (caminho == "Norte") {
                this.jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaNove.png")));
                this.jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaCincoNaPosicao.png")));
                this.jogador.setPosicaoAtual(5);
            } else if (caminho == "Sul") {
                this.jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaNove.png")));
                this.jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaTrezeNaPosicao.png")));
                this.jogador.setPosicaoAtual(13);
            } else if (caminho == "Leste") {
                this.jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaNove.png")));
                this.jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaDezNaPosicao.png")));
                this.jogador.setPosicaoAtual(10);
            } else if (caminho == "Oeste") {
                JOptionPane.showMessageDialog(null, "Voce nao pode ir para o Oeste, escolha um caminho válido.");
                return false;
            }
        } else if (posicao == 10) {
            if (caminho == "Norte") {
                this.jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaDez.png")));
                this.jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaSeisNaPosicao.png")));
                this.jogador.setPosicaoAtual(6);
            } else if (caminho == "Sul") {
                this.jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaDez.png")));
                this.jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaCatorzeNaPosicao.png")));
                this.jogador.setPosicaoAtual(14);
            } else if (caminho == "Leste") {
                this.jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaDez.png")));
                this.jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaOnzeNaPosicao.png")));
                this.jogador.setPosicaoAtual(11);
            } else if (caminho == "Oeste") {
                this.jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaDez.png")));
                this.jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaNoveNaPosicao.png")));
                this.jogador.setPosicaoAtual(9);
            }
        } else if (posicao == 11) {
            if (caminho == "Norte") {
                this.jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaOnze.png")));
                this.jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaSeteNaPosicao.png")));
                this.jogador.setPosicaoAtual(7);
            } else if (caminho == "Sul") {
                this.jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaOnze.png")));
                this.jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaQuinzeNaPosicao.png")));
                this.jogador.setPosicaoAtual(15);
            } else if (caminho == "Leste") {
                this.jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaOnze.png")));
                this.jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaDozeNaPosicao.png")));
                this.jogador.setPosicaoAtual(12);
            } else if (caminho == "Oeste") {
                this.jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaOnze.png")));
                this.jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaDezNaPosicao.png")));
                this.jogador.setPosicaoAtual(10);
            }
        } else if (posicao == 12) {
            if (caminho == "Norte") {
                this.jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaDoze.png")));
                this.jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaOitoNaPosicao.png")));
                this.jogador.setPosicaoAtual(8);
            } else if (caminho == "Sul") {
                this.jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaDoze.png")));
                this.jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaDezesseisNaPosicao.png")));
                this.jogador.setPosicaoAtual(16);
            } else if (caminho == "Leste") {
                JOptionPane.showMessageDialog(null, "Voce nao pode ir para o Oeste, escolha um caminho válido.");
                return false;
            } else if (caminho == "Oeste") {
                this.jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaDoze.png")));
                this.jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaOnzeNaPosicao.png")));
                this.jogador.setPosicaoAtual(11);
            }
        } else if (posicao == 13) {
            if (caminho == "Norte") {
                this.jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaTreze.png")));
                this.jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaNoveNaPosicao.png")));
                this.jogador.setPosicaoAtual(9);
            } else if (caminho == "Sul") {
                JOptionPane.showMessageDialog(null, "Voce nao pode ir para o Norte, escolha um caminho válido.");
                return false;
            } else if (caminho == "Leste") {
                this.jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaTreze.png")));
                this.jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaCatorzeNaPosicao.png")));
                this.jogador.setPosicaoAtual(14);
            } else if (caminho == "Oeste") {
                JOptionPane.showMessageDialog(null, "Voce nao pode ir para o Oeste, escolha um caminho válido.");
                return false;
            }
        } else if (posicao == 14) {
            if (caminho == "Norte") {
                this.jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaCatorze.png")));
                this.jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaDezNaPosicao.png")));
                this.jogador.setPosicaoAtual(10);
            } else if (caminho == "Sul") {
                JOptionPane.showMessageDialog(null, "Voce nao pode ir para o Oeste, escolha um caminho válido.");
                return false;
            } else if (caminho == "Leste") {
                this.jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaCatorze.png")));
                this.jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaQuinzeNaPosicao.png")));
                this.jogador.setPosicaoAtual(15);
            } else if (caminho == "Oeste") {
                this.jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaCatorze.png")));
                this.jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaTrezeNaPosicao.png")));
                this.jogador.setPosicaoAtual(13);
            }
        } else if (posicao == 15) {
            if (caminho == "Norte") {
                this.jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaQuinze.png")));
                this.jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaOnzeNaPosicao.png")));
                this.jogador.setPosicaoAtual(11);
            } else if (caminho == "Sul") {
                JOptionPane.showMessageDialog(null, "Voce nao pode ir para o Norte, escolha um caminho válido.");
                return false;
            } else if (caminho == "Leste") {
                this.jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaQuinze.png")));
                this.jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaDezesseisNaPosicao.png")));
                this.jogador.setPosicaoAtual(16);
            } else if (caminho == "Oeste") {
                this.jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaQuinze.png")));
                this.jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaCatorzeNaPosicao.png")));
                this.jogador.setPosicaoAtual(14);
            }
        } else if (posicao == 16) {
            if (caminho == "Norte") {
                this.jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaDezesseis.png")));
                this.jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaDozeNaPosicao.png")));
                this.jogador.setPosicaoAtual(12);
            } else if (caminho == "Sul") {
                JOptionPane.showMessageDialog(null, "Voce nao pode ir para o Norte, escolha um caminho válido.");
                return false;
            } else if (caminho == "Leste") {
                JOptionPane.showMessageDialog(null, "Voce nao pode ir para o Norte, escolha um caminho válido.");
                return false;
            } else if (caminho == "Oeste") {
                this.jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaDezesseis.png")));
                this.jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaQuinzeNaPosicao.png")));
                this.jogador.setPosicaoAtual(15);
            }
        }
        return true;
    }

    public boolean setRandomItem(int numeroRandom, int cliques) {
        if (cliques == 1) {
            if (numeroRandom == 1) {
                this.jogador.getPersonagem().setItem1("ataque", 10);
            }
            if (numeroRandom == 2) {
                this.jogador.getPersonagem().setItem1("defesa", 10);
            }
            if (numeroRandom == 3) {
                this.jogador.getPersonagem().setItem1("vida", 10);
            }
        }
        if (cliques == 2) {
            if (numeroRandom == 1) {
                this.jogador.getPersonagem().setItem2("ataque", 10);
            }
            if (numeroRandom == 2) {
                this.jogador.getPersonagem().setItem2("defesa", 10);
            }
            if (numeroRandom == 3) {
                this.jogador.getPersonagem().setItem2("vida", 10);
            }
        }
        if (cliques == 3) {
            if (numeroRandom == 1) {
                this.jogador.getPersonagem().setItem3("ataque", 10);
            }
            if (numeroRandom == 2) {
                this.jogador.getPersonagem().setItem3("defesa", 10);
            }
            if (numeroRandom == 3) {
                this.jogador.getPersonagem().setItem3("vida", 10);
            }
        }
        return true;
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
        jComboBoxCaminho = new javax.swing.JComboBox<>();
        jLabelEscolhaUmCaminho = new javax.swing.JLabel();
        Mochila = new javax.swing.JLabel();
        jButtonIr = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListItens = new javax.swing.JList<>();
        jButtonTerminarJogada = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Jornada");

        jComboBoxCaminho.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Norte", "Sul", "Leste", "Oeste" }));

        jLabelEscolhaUmCaminho.setText("Escolha um caminho:");

        Mochila.setText("Mochila");

        jButtonIr.setText("Ir");
        jButtonIr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIrActionPerformed(evt);
            }
        });

        jListItens.setModel(new DefaultListModel());
        jScrollPane1.setViewportView(jListItens);

        jButtonTerminarJogada.setText("Terminar Jogada");
        jButtonTerminarJogada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTerminarJogadaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jComboBoxCaminho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonIr))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(Mochila))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(jButtonTerminarJogada, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabelEscolhaUmCaminho)))
                        .addGap(0, 3, Short.MAX_VALUE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabelEscolhaUmCaminho)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonIr)
                    .addComponent(jComboBoxCaminho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(Mochila)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonTerminarJogada)
                .addGap(18, 18, 18))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaUm.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaDois.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaTres.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaQuatro.png"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaCinco.png"))); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaSeis.png"))); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaSete.png"))); // NOI18N

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaOito.png"))); // NOI18N

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaNove.png"))); // NOI18N

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaDez.png"))); // NOI18N

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaOnze.png"))); // NOI18N

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaDoze.png"))); // NOI18N

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaTreze.png"))); // NOI18N

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaCatorze.png"))); // NOI18N

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaQuinze.png"))); // NOI18N

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mapaDezesseis.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1))
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIrActionPerformed
        // TODO add your handling code here:
        if (calculaMovimento(this.jogador.getPosicaoAtual(), jComboBoxCaminho.getSelectedItem().toString()) == true) {
            this.jComboBoxCaminho.setEnabled(false);
            this.jButtonIr.setEnabled(false);
            cliques++;
            if (cliques > 3) {
                JOptionPane.showMessageDialog(null, "Você atingiu o número máximo de itens.");
            } else {
                Random r = new Random();
                int numeroRandom = r.nextInt(3) + 1;
                setRandomItem(numeroRandom, cliques);
                if (numeroRandom == 1) {
                    ImageIcon pocaoAtaque = new ImageIcon(TelaJornada.class.getResource("/images/pocao_ataque.png"));
                    JOptionPane.showMessageDialog(null, "", "Você encontrou uma poção de ataque!", JOptionPane.INFORMATION_MESSAGE, pocaoAtaque);
                    model.addElement(String.format("poção de ataque"));
                }
                if (numeroRandom == 2) {
                    ImageIcon pocaoDefesa = new ImageIcon(TelaJornada.class.getResource("/images/pocao_defesa.png"));
                    JOptionPane.showMessageDialog(null, "", "Você encontrou uma poção de defesa!", JOptionPane.INFORMATION_MESSAGE, pocaoDefesa);
                    model.addElement(String.format("poção de defesa"));
                }
                if (numeroRandom == 3) {
                    ImageIcon pocaoVida = new ImageIcon(TelaJornada.class.getResource("/images/pocao_vida.png"));
                    JOptionPane.showMessageDialog(null, "", "Você encontrou uma poção de vida!", JOptionPane.INFORMATION_MESSAGE, pocaoVida);
                    model.addElement(String.format("poção de vida"));
                }
            }
        }
    }//GEN-LAST:event_jButtonIrActionPerformed

    private void jButtonTerminarJogadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTerminarJogadaActionPerformed
        // TODO add your handling code here:
        this.atorJogador.enviarPosicao(this.jogador.getPosicaoAtual(), true);
        this.jButtonTerminarJogada.setEnabled(false);
        JOptionPane.showMessageDialog(null, "Você terminou sua jogada. Aguarde a jogada do adversário.");
    }//GEN-LAST:event_jButtonTerminarJogadaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Mochila;
    private javax.swing.JButton jButtonIr;
    private javax.swing.JButton jButtonTerminarJogada;
    private javax.swing.JComboBox<String> jComboBoxCaminho;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelEscolhaUmCaminho;
    private javax.swing.JList<String> jListItens;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
