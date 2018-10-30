package model;

import br.ufsc.inf.leobr.cliente.Jogada;

/**
 *
 * @author Vitor
 */
public class Personagem implements Jogada{

    protected String tipo;
    protected int ataque;
    protected int defesa;
    protected int vida;
    protected Item item1;
    protected Item item2;
    protected Item item3;

    public Personagem() {
    }

    public Personagem(String tipo, int ataque, int defesa, int vida) {
        this.tipo = tipo;
        this.ataque = ataque;
        this.defesa = defesa;
        this.vida = vida;
        this.item1 = new Item();
        this.item2 = new Item();
        this.item3 = new Item();

    }

    public void setItem1(String tipo, int valor) {
        this.item1.setTipo(tipo);
        this.item1.setValorModificador(valor);
    }
    public void setItem2(String tipo, int valor) {
        this.item2.setTipo(tipo);
        this.item2.setValorModificador(valor);
    }
    public void setItem3(String tipo, int valor) {
        this.item3.setTipo(tipo);
        this.item3.setValorModificador(valor);
    }

    public String getTipoItem1() {
        return this.item1.tipo;
    }

    public String getTipoItem2() {
        return this.item2.tipo;
    }

    public String getTipoItem3() {
        return this.item3.tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

}
