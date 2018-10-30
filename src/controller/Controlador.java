
package controller;

/**
 *
 * @author Vitor
 */
import model.Jogador;
import rede.AtorJogador;
import rede.EstadoDoJogo;

public class Controlador {
    
    protected Jogador jogador1;
    protected Jogador jogador2;
    protected AtorJogador atorJogador;
    protected boolean jogadorDaVezVenceu;
    protected boolean jogadorDaVezDesistiu;
    protected EstadoDoJogo estadoJogo;
    protected boolean partidaEmAndamento;

    public Controlador(AtorJogador atorJogador) {
        this.atorJogador = atorJogador;
    }

    public void desistir(){
        this.jogadorDaVezDesistiu = true;
    }
    
    public boolean verificarVencedor(){
    	//implementar vencedor
        return false;
    }		
    public boolean verificaJogador1(Jogador jogador)
    {
        if(jogador1 != null)
            return true;
        else
            return false;
    }
    
    public boolean verificaJogador2(Jogador jogador)
    {
        if(jogador2 != null)
            return true;
        else
            return false;
    }

    
    public Jogador getJogador1() {
    	return jogador1;
    }
    
    public void setJogador1(Jogador jogador1) {
    	this.jogador1 = jogador1;
    }
    
    public Jogador getJogador2() {
    	return jogador2;
    }
    
    public void setJogador2(Jogador jogador2) {
    	this.jogador2 = jogador2;
    }
    
    public void criarJogador(String nome, boolean jogadorQueComecou) {
        if(jogadorQueComecou){
            this.jogador1 = new Jogador(nome, jogadorQueComecou);
    	} else {
    		jogador2 = new Jogador(nome, jogadorQueComecou);
    	}
    }
    
    public Jogador getJogadorLocal(){
    	return jogador1.isJogadorLocal() ? jogador1 : jogador2;
    }
    
    public Jogador getJogadorRemoto(){
    	return jogador1.isJogadorLocal() ? jogador2 : jogador1;
    }

    public EstadoDoJogo getEstado(){
        return this.estadoJogo;
    }
    
    public boolean setEstado(EstadoDoJogo estado){
    	this.estadoJogo = estado;
    	if(estado.isVencedor()){
    		atorJogador.informarPerdedor();
    		return false;
    	}
    	
    	if(estado.desistiu()){
    		atorJogador.informarDesistencia();
    		return false;
    	}
    	
    	return true;
    }

    
}
