package dominioProblema;


public class Tabuleiro {
 
	protected Posicao posicoes[][] = new Posicao[3][3];
	
	protected Jogador jogador1;
	 
	protected Jogador jogador2;
	 
	protected boolean partidaEmAndamento;
	 
	protected boolean partidaComVencedor;
	 	 
	public boolean InformarPartidaEmAndamento() {
		return partidaEmAndamento;
	}
	 
	public void criarJogadorHumano(String nome, boolean simbolo) {
		int umSimbolo = 2;
		if ((jogador1 != null) && (jogador2 != null)) {
			jogador2 = null;
			jogador1 = new JogadorHumano();
			if (simbolo) {umSimbolo = 1;};
			jogador1.iniciar(nome, umSimbolo);
		} else {
			if (jogador1 == null) {
				jogador1 = new JogadorHumano();
				if (simbolo) {umSimbolo = 1;};
				jogador1.iniciar(nome, umSimbolo);
			} else {
				jogador2 = new JogadorHumano();
				if (simbolo) {umSimbolo = 1;};
				jogador2.iniciar(nome, umSimbolo);	
			};
		};
		}
	 
	public void criarJogadorAutomatico(String nome, boolean simbolo) {
		int umSimbolo = 2;
		jogador2 = new JogadorAutomatico();
		if (simbolo) {umSimbolo = 1;};
		jogador2.iniciar(nome, umSimbolo);
	}
	 
	public void definirOPrimeiro(int primeiro) {
		ImagemDeTabuleiro estado;
		Lance j2Lance;
		this.esvaziar();
		partidaEmAndamento = true;
		estado = this.informarEstado();
		jogador1.reiniciar();
		jogador2.reiniciar();
		if (primeiro == 1) {
			jogador1.habilitar(estado);
		} else {
			j2Lance = jogador2.habilitar(estado);
			if (j2Lance.informarLinha() != 0) {
				this.tratarPosicao((j2Lance.informarLinha()), (j2Lance.informarColuna()));		
			};			
		};
	}
	 
	public boolean tratarPosicao(int linha, int coluna) {
		Posicao posicaoSelecionada;
		boolean posicaoOcupada;
		boolean vezJogador1;
		ImagemDeTabuleiro estado;
		Lance j2Lance;
		posicaoSelecionada = this.recuperarPosicao(linha, coluna);
		posicaoOcupada = posicaoSelecionada.ocupada();
		if (posicaoOcupada) {
			return false;		
		} else {
			vezJogador1 = jogador1.informarDaVez();
			if (vezJogador1) {
				posicaoSelecionada.alocarPeao(jogador1);
			} else {
				posicaoSelecionada.alocarPeao(jogador2);
			};
			partidaComVencedor = this.avaliarVencedor(linha, coluna);
			partidaEmAndamento = this.avaliarPartidaEmAndamento();
			estado = this.informarEstado();
			if (partidaEmAndamento) {
				if (vezJogador1) {
					jogador1.desabilitar();
					j2Lance = jogador2.habilitar(estado);
					if (j2Lance.informarLinha() != 0) {
						this.tratarPosicao((j2Lance.informarLinha()), (j2Lance.informarColuna()));		
					};
				} else {
					jogador2.desabilitar();
					jogador1.habilitar(estado);
				};
			};
			return true;
		}	
	}
	
	public void esvaziar() {
		for (int linha=1; linha<4; linha++){
			for (int coluna=1; coluna<4; coluna++){
				posicoes[(linha-1)][(coluna-1)].esvaziar();				
			};
		};
	}
	 
	public int click(int linha, int coluna) {
		boolean lanceOK;
		if (this.InformarPartidaEmAndamento()) {
		  lanceOK = this.tratarPosicao(linha, coluna);
		  if (lanceOK) {
			  return 0;
		  } else {
			  return 1;
		  }			
		} else {
			return 2;	
		}
	}
	
	public ImagemDeTabuleiro informarEstado() {
		ImagemDeTabuleiro estado;
		int valor = 0;
		Jogador vencedor = null;
		estado = new ImagemDeTabuleiro();
		
		// composicao da mensagem
		if (this.InformarPartidaEmAndamento()) {
			if (jogador1.informarDaVez()) {
				estado.assumirMensagem("Jogador: " + jogador1.informarNome());
			} else {
				estado.assumirMensagem("Jogador: " + jogador2.informarNome());			
			};			
		} else {
			vencedor = this.informarVencedor();
			if (vencedor == null) {
				estado.assumirMensagem("Partida encerrada sem vencedor");
			} else {
				estado.assumirMensagem("Vencedor: " + vencedor.informarNome());			
			};			
		};
		
		// composicao do mapa de posicoes	
		for (int linha=1; linha<4; linha++){
			for (int coluna=1; coluna<4; coluna++){
				if ((this.recuperarPosicao(linha, coluna)).ocupada()) {
					valor = ((this.recuperarPosicao(linha, coluna)).informarOcupante()).informarSimbolo();
					estado.assumirValor(linha, coluna, valor);			
				} else {
					valor = 0;
					estado.assumirValor(linha, coluna, valor);
				};				
			};
		};
		return (estado);
	}
	 
	public Posicao recuperarPosicao(int linha, int coluna) {
		return (posicoes[(linha-1)][(coluna-1)]);
	}
	 
	public boolean avaliarVencedor(int linha, int coluna) {
		boolean vencedor = false;
		Posicao p1 = null, p2 = null, selecionada;
		selecionada = this.recuperarPosicao(linha, coluna);
		
		//teste de coluna
		switch (linha) {
			case 1: {
				p1 = this.recuperarPosicao(2, coluna);
				p2 = this.recuperarPosicao(3, coluna);
			};
			break;
			case 2:{
				p1 = this.recuperarPosicao(1, coluna);
				p2 = this.recuperarPosicao(3, coluna);
			};
			break;
			case 3:{
				p1 = this.recuperarPosicao(1, coluna);
				p2 = this.recuperarPosicao(2, coluna);
			};
		};
		vencedor = selecionada.mesmoOcupante(p1, p2);
		if (vencedor){
			selecionada.informarOcupante().tornarSeVencedor();
			return vencedor;
		} else {
			
		//teste de linha
			switch (coluna) {
				case 1: {
					p1 = this.recuperarPosicao(linha, 2);
					p2 = this.recuperarPosicao(linha, 3);
				};
				break;
				case 2:{
					p1 = this.recuperarPosicao(linha, 1);
					p2 = this.recuperarPosicao(linha, 3);
				};
				break;
				case 3:{
					p1 = this.recuperarPosicao(linha, 1);
					p2 = this.recuperarPosicao(linha, 2);
				};
			};
			vencedor = selecionada.mesmoOcupante(p1, p2);
			if (vencedor){
				selecionada.informarOcupante().tornarSeVencedor();
				return vencedor;
			} else {
				
		//teste de diagonal principal
				if ((linha == 1) && (coluna == 1)) {
					p1 = this.recuperarPosicao(2, 2);
					p2 = this.recuperarPosicao(3, 3);
					vencedor = selecionada.mesmoOcupante(p1, p2);
				};
				if ((linha == 2) && (coluna == 2)) {
					p1 = this.recuperarPosicao(1, 1);
					p2 = this.recuperarPosicao(3, 3);
					vencedor = selecionada.mesmoOcupante(p1, p2);
				};
				if ((linha == 3) && (coluna == 3)) {
					p1 = this.recuperarPosicao(1, 1);
					p2 = this.recuperarPosicao(2, 2);
					vencedor = selecionada.mesmoOcupante(p1, p2);
				};				
				if (vencedor){
					selecionada.informarOcupante().tornarSeVencedor();
					return vencedor;
				} else {
					
		//teste de diagonal secundaria
					if ((linha == 3) && (coluna == 1)) {
						p1 = this.recuperarPosicao(2, 2);
						p2 = this.recuperarPosicao(1, 3);
						vencedor = selecionada.mesmoOcupante(p1, p2);
					};
					if ((linha == 2) && (coluna == 2)) {
						p1 = this.recuperarPosicao(1, 3);
						p2 = this.recuperarPosicao(3, 1);
						vencedor = selecionada.mesmoOcupante(p1, p2);
					};
					if ((linha == 1) && (coluna == 3)) {
						p1 = this.recuperarPosicao(2, 2);
						p2 = this.recuperarPosicao(3, 1);
						vencedor = selecionada.mesmoOcupante(p1, p2);
					};	
					if (vencedor){
						selecionada.informarOcupante().tornarSeVencedor();
					}
				};
			};
		};
		return vencedor;
	}
	 
	public boolean avaliarPartidaEmAndamento() {
		boolean cheio = true;
		boolean resultado;
		if (partidaComVencedor) {
			resultado = false;
		} else {
			for (int linha=1; linha<4; linha++){
				for (int coluna=1; coluna<4; coluna++){
					if (!(posicoes[(linha-1)][(coluna-1)].ocupada())) {
						cheio = false;
					};
				};
			};
			resultado = !cheio;
		};
		return resultado;
	}
	 
	public Jogador informarVencedor() {
		if (jogador1.informarVencedor()) {
			return jogador1;
		} else {
			if (jogador2.informarVencedor()) {
				return jogador2;
			} else {
				return null;
			}
		}
	}
	
	public boolean informarExistenciaJogadores() {
		return ((jogador1 != null)&& (jogador1 != null));
	}

	 
	public void iniciar() {
		for (int linha=1; linha<4; linha++){
			for (int coluna=1; coluna<4; coluna++){
				posicoes[(linha-1)][(coluna-1)] = new Posicao();
				posicoes[(linha-1)][(coluna-1)].esvaziar();				
			};
		};
	}

	public Jogador getJogador1() {
		return jogador1;
	}

	public Jogador getJogador2() {
		return jogador2;
	}

	public boolean isPartidaComVencedor() {
		return partidaComVencedor;
	}
	 
}
 
