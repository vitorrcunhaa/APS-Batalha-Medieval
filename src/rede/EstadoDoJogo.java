package rede;

import br.ufsc.inf.leobr.cliente.Jogada;
import model.Jogador;

/**
 *
 * @author Vitor
 */
public class EstadoDoJogo implements Jogada{

    protected boolean desistiu;
    protected boolean vencedor;
    protected Jogador jogadorLocal;
    protected Jogador jogadorRemoto;
    
    public EstadoDoJogo(Jogador jogadorLocal, Jogador jogadorRemoto, boolean desistiu, boolean vencedor) {
        super();
        this.desistiu = desistiu;
        this.vencedor = vencedor;
        this.jogadorLocal = jogadorLocal;
        this.jogadorRemoto = jogadorRemoto;
    }
    
    public Jogador getJogadorLocal(){
        return jogadorLocal;
    }
    
    public Jogador getJogadorRemoto(){
        return jogadorRemoto;
    }
    
    public void setJogadorLocal(Jogador jogadorLocal){
        this.jogadorLocal = jogadorLocal;
    }
        
    public void setJogadorRemoto(Jogador jogadorRemoto){
        this.jogadorRemoto = jogadorRemoto;
    }
    
    public boolean desistiu() {
        return desistiu;
    }

    public void desistir(boolean desistir) {
        this.desistiu = desistir;
    }

    public boolean isVencedor() {
        return vencedor;
    }

    public void setVencedor(boolean vencedor) {
        this.vencedor = vencedor;
    }
    
    public EstadoDoJogo getEstadoDoJogo(){
        EstadoDoJogo estado = new EstadoDoJogo(getJogadorLocal(), getJogadorRemoto(), desistiu, vencedor);
    	return estado;
    }

}
