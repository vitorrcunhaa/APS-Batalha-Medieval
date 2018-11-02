/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rede;

import br.ufsc.inf.leobr.cliente.Jogada;

/**
 *
 * @author Vitor
 */
public class EstadoMapa implements Jogada {
    
    protected boolean minhaVez;
    protected int minhaPosicao;

    public EstadoMapa(boolean minhaVez, int minhaPosicao) {
        super();
        this.minhaVez = minhaVez;
        this.minhaPosicao = minhaPosicao;
    }

    public boolean isMinhaVez() {
        return minhaVez;
    }

    public void setMinhaVez(boolean minhaVez) {
        this.minhaVez = minhaVez;
    }

    public int getMinhaPosicao() {
        return minhaPosicao;
    }

    public void setMinhaPosicao(int minhaPosicao) {
        this.minhaPosicao = minhaPosicao;
    }
    
    
}
