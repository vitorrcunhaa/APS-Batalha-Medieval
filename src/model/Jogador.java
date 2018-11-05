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
    protected int posicaoAtual;
    
    public Jogador(String nome, boolean jogadorLocal){
        // implementar algo como this.personagem = new Personagem();
    	this.nome = nome;
        this.jogadorLocal = jogadorLocal;
    }
   
    public int getPosicaoAtual() {
        return posicaoAtual;
    }

    public void setPosicaoAtual(int posicaoAtual) {
        this.posicaoAtual = posicaoAtual;
    }
    
    public String getNome() {
        return nome;
    }

    public int getIdJogador() {
        return idJogador;
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
