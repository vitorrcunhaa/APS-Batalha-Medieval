package model;

import br.ufsc.inf.leobr.cliente.Jogada;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.util.ArrayList;

/**
 *
 * @author Vitor
 */
public class Personagem implements Jogada{

    protected String tipo;
    protected int ataque;
    protected int defesa;
    protected int vida;
    protected ArrayList<Item> item;

    public Personagem(String tipo, int ataque, int defesa, int vida) {
        this.tipo = tipo;
        this.ataque = ataque;
        this.defesa = defesa;
        this.vida = vida;
        this.item = new ArrayList<Item>();
    }

    public void setItem(String tipo, int valor) {
        item.add(new Item(tipo, valor));
    }
    
    public ArrayList<Item> getItemArrayList() {
        return item;
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
