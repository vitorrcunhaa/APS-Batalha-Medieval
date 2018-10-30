package rede;

import br.ufsc.inf.leobr.cliente.Jogada;

public class Mensagem implements Jogada {
	
	private String mensagem;

	public Mensagem(String mensagem) {
		super();
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}
	
	

}
