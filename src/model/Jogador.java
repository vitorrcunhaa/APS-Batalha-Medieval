/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import br.ufsc.inf.leobr.cliente.Jogada;

/**
 *
 * @author Vitor
 */
public class Jogador implements Jogada{
    protected String nome;
    protected int idJogador;
    protected boolean jogadorLocal;
    protected Personagem personagem;
    protected boolean posicao1;
    protected boolean posicao2;
    protected boolean posicao3;
    protected boolean posicao4;
    protected boolean posicao5;
    protected boolean posicao6;
    protected boolean posicao7;
    protected boolean posicao8;
    protected boolean posicao9;
    protected boolean posicao10;
    protected boolean posicao11;
    protected boolean posicao12;
    protected boolean posicao13;
    protected boolean posicao14;
    protected boolean posicao15;
    protected boolean posicao16;

    public Jogador(String nome, boolean jogadorLocal){
        // implementar algo como this.personagem = new Personagem();
        this.posicao1 = false;
        this.posicao2 = false;
        this.posicao3 = false;
        this.posicao4 = false;
        this.posicao5 = false;
        this.posicao6 = false;
        this.posicao7 = false;
        this.posicao8 = false;
        this.posicao9 = false;
        this.posicao10 = false;
        this.posicao11 = false;
        this.posicao12 = false;
        this.posicao13 = false;
        this.posicao14 = false;
        this.posicao15 = false;
        this.posicao16 = false;
    	this.nome = nome;
        this.jogadorLocal = jogadorLocal;
    }
    
    public Personagem getPersonagem(){
        return this.personagem;
    }
    
    public void setPersonagem(String tipo, int ataque, int defesa, int vida){
        this.personagem = new Personagem(tipo, ataque, defesa, vida);
    }
    
    public boolean isJogadorLocal() {
		return jogadorLocal;
	}
    
    public boolean isVencedor(){
        return false;
    }
    
    
}
