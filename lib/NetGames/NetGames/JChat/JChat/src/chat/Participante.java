package chat;

public class Participante {
	
	private String nome;
	
	private boolean vez;

	public String getNome() {
		return nome;
	}

	public Participante(String nome) {
		super();
		this.nome = nome;
		vez = false;
	}
	
	public void tomarVez(){
		vez = true;
	}
	
	public void passarVez(){
		vez = false;
	}
	
	public boolean ehVez(){
		return vez;
	}

}
