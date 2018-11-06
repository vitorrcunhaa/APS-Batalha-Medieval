package model;

import br.ufsc.inf.leobr.cliente.Jogada;

public class Item implements Jogada {

    protected String tipo;
    protected int valorModificador;

    public Item(String tipo, int valorModificador) {
        this.tipo = tipo;
        this.valorModificador = valorModificador;
    }

    public String getTipo() {
        return tipo;
    }

    public int getValorModificador() {
        return valorModificador;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setValorModificador(int valorModificador) {
        this.valorModificador = valorModificador;
    }

    @Override
    public String toString() {
        return "Item{" + "tipo=" + tipo + ", valorModificador=" + valorModificador + '}';
    }

}
