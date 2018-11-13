package rede;

import br.ufsc.inf.leobr.cliente.Jogada;
import model.Jogador;

/**
 *
 * @author Vitor
 */
public class EstadoDoJogo implements Jogada{

    protected boolean desistir;
    protected boolean vencedor;
    protected boolean primeiraJogada;
    protected boolean preparadoPraJogar;

    protected Jogador jogador;
    
    public EstadoDoJogo(Jogador jogador, boolean desistiu, boolean vencedor, boolean primeiraJogada, boolean preparadoPraJogar) {
        super();
        this.desistir = desistiu;
        this.vencedor = vencedor;
        this.jogador = jogador;
        this.primeiraJogada = primeiraJogada;
        this.preparadoPraJogar = preparadoPraJogar;
    }

    public boolean isPreparadoPraJogar() {
        return preparadoPraJogar;
    }

    public void setPreparadoPraJogar(boolean preparadoPraJogar) {
        this.preparadoPraJogar = preparadoPraJogar;
    }

        public boolean isPrimeiraJogada() {
        return primeiraJogada;
    }

    public void setPrimeiraJogada(boolean primeiraJogada) {
        this.primeiraJogada = primeiraJogada;
    }
    
    public boolean isDesistir() {
        return desistir;
    }

    public void setDesistiu(boolean desistiu) {
        this.desistir = desistiu;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }
  
    public boolean isVencedor() {
        return vencedor;
    }

    public void setVencedor(boolean vencedor) {
        this.vencedor = vencedor;
    }
    
    public EstadoDoJogo getEstadoDoJogo(){
        EstadoDoJogo estado = new EstadoDoJogo(getJogador(), desistir, vencedor, primeiraJogada, preparadoPraJogar);
    	return estado;
    }
}
