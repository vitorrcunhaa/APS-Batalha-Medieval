package dominioProblema;

public class ImagemDeTabuleiro {
 
	protected String mensagem;
	 
	protected int mapa[][] = new int [3][3];
	 
	public String informarMensagem() {
		return mensagem;
	}
	 
	public int informarValor(int linha, int coluna) {
		int retorno;
		retorno = mapa [(linha-1)][(coluna-1)];
		return (retorno);
	}
	 
	public void assumirMensagem(String texto) {
		mensagem = texto;
	}
	 
	public void assumirValor(int linha, int coluna, int valor) {
		mapa [(linha-1)][(coluna-1)] = valor;
	}
	 
	public boolean informarVazio() {
		boolean vazio = true;
		for (int linha=1; linha<4; linha++){
			for (int coluna=1; coluna<4; coluna++){
				if (this.informarPosicaoOcupada(linha, coluna)) {
					vazio = false;
				};
			};
		};
		return vazio;
	}
	 
	public boolean informarCentroVazio() {
		return (this.informarPosicaoVazia(2, 2));
	}
	 
	public boolean informarPosicaoVazia(int linha, int coluna) {
		return ((this.informarValor(linha, coluna)) == 0);
	}
	 
	public boolean informarPosicaoOcupada(int linha, int coluna) {
		return ((this.informarValor(linha, coluna)) != 0);
	}
	 
	public int ocupadasNaLinha(int ordem) {
		int cont = 0;
		for (int coluna=1; coluna<4; coluna++){
			if (this.informarPosicaoOcupada(ordem, coluna)) {
				cont++;
			};
		};
		return cont;
	}
	 
	public int ocupadasNaColuna(int ordem) {
		int cont = 0;
		for (int linha=1; linha<4; linha++){
			if (this.informarPosicaoOcupada(linha, ordem)) {
				cont++;
			};
		};
		return cont;
	}
	 
}
 
