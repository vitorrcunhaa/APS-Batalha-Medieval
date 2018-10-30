package rede;

import interfaceGrafica.AtorJogador;

import java.awt.Rectangle;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import br.ufsc.inf.leobr.cliente.Jogada;
import br.ufsc.inf.leobr.cliente.OuvidorProxy;
import br.ufsc.inf.leobr.cliente.Proxy;
import br.ufsc.inf.leobr.cliente.exception.ArquivoMultiplayerException;
import br.ufsc.inf.leobr.cliente.exception.JahConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoJogandoException;
import br.ufsc.inf.leobr.cliente.exception.NaoPossivelConectarException;
import dominioProblema.JogadaVelha;

public class AtorRede implements OuvidorProxy {

	public AtorJogador atorJogador;

	public Proxy proxy;

	private JMenu menuRede = null;
	
	private boolean ehJogoRede = false;
	
	private boolean ehMinhaVez = false;

	private JMenuItem jMenuItemConectar = null,
			jMenuItemIniciarPartidaRede = null,
			jMenuItemReiniciarPartidaRede = null, jMenuItemDesconectar = null;

	public AtorRede(AtorJogador atorJogador) {
		super();
		this.atorJogador = atorJogador;
		proxy = Proxy.getInstance();
	}

	// Interface gr�fica para menus de rede 
	public JMenu getMenuRede() {
		if (menuRede == null) {
			menuRede = new JMenu();
			menuRede.setText("Jogar Online");
			menuRede.setBounds(new Rectangle(1, 0, 57, 21));
			menuRede.add(getJMenuItemConectar());
			menuRede.add(getJMenuItemIniciarPartidaRede());
			menuRede.add(getJMenuReiniciarParitdaRede());
			menuRede.add(getJMenuItemDesconectar());
		}
		return menuRede;
	}

	 
	private JMenuItem getJMenuItemConectar() {
		if (jMenuItemConectar == null) {
			jMenuItemConectar = new JMenuItem();
			jMenuItemConectar.setText("Conectar");
			jMenuItemConectar
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							conectar();
						}

					});
		}
		return jMenuItemConectar;
	}

	

	 
	private JMenuItem getJMenuItemIniciarPartidaRede() {
		if (jMenuItemIniciarPartidaRede == null) {
			jMenuItemIniciarPartidaRede = new JMenuItem();
			jMenuItemIniciarPartidaRede.setText("Iniciar Partida de Rede");
			jMenuItemIniciarPartidaRede
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							iniciarPartidaRede();
						}

					});
		}
		return jMenuItemIniciarPartidaRede;
	}

	 
	private JMenuItem getJMenuItemDesconectar() {
		if (jMenuItemDesconectar == null) {
			jMenuItemDesconectar = new JMenuItem();
			jMenuItemDesconectar.setText("Desconectar");
			jMenuItemDesconectar
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							desconectar();
						}
					});
		}
		return jMenuItemDesconectar;
	}

	 
	private JMenuItem getJMenuReiniciarParitdaRede() {
		if (jMenuItemReiniciarPartidaRede == null) {
			jMenuItemReiniciarPartidaRede = new JMenuItem();
			jMenuItemReiniciarPartidaRede.setText("Reiniciar partida");
			jMenuItemReiniciarPartidaRede
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							reiniciar();
						}

					});
		}
		return jMenuItemReiniciarPartidaRede;
	}
	
	/**
	 * M�todo que abre a gui para o usu�rio digitar o nome e ip do servidor.
	 */
	protected void conectar() {
		GuiRede ic = new GuiRede(this);
		ic.createFront();
	}

	// M�todos que realizam a l�gica de rede
	

	 
	/**
	 * Conecta o jogo em rede.
	 * @param nome
	 * @param ipServidor
	 */
	protected void conectarRede(String nome, String ipServidor) {
		try {
			Proxy.getInstance().conectar(ipServidor, nome);
			//Adiciona o ator como um dos ouvintes do Proxy.
			Proxy.getInstance().addOuvinte(this);
		} catch (JahConectadoException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(atorJogador, e.getMessage());
		} catch (NaoPossivelConectarException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(atorJogador, "Erro: "
					+ e.getMessage());
		} catch (ArquivoMultiplayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(atorJogador, "Erro: "
					+ e.getMessage());
		}
	}

	 
	/**
	 * Inicia uma partida de rede.
	 * Esse m�todo � chamado por um jogador que est� conectado e deseja jogar.
	 * No servidor, um outro jogador, tamb�m conectado e que ainda n�o est� jogando ser� sorteado para inciar uma partida.
	 * O usu�rio quando chama esse m�todo ainda n�o iniciou uma partida, mas solicitou seu inicio.
	 */
	protected void iniciarPartidaRede() {
		try {
			Proxy.getInstance().iniciarPartida(2);
		} catch (NaoConectadoException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(atorJogador, e.getMessage());
		}
	}

	 
	/* 
	 * Esse m�todo efetivamente inicia a partida.
	 * Ele � chamado pelo servidor em todos os jogadores que fizerem parte da partida,
	 * inclusive pelo usu�rio que fez a solicita��o do in�cio da partida.
	 * (non-Javadoc)
	 * @see br.ufsc.inf.leobr.cliente.OuvidorProxy#iniciarNovaPartida(java.lang.Integer)
	 */
	@Override
	public void iniciarNovaPartida(Integer posicao) {
		if (posicao == 1) {
			JOptionPane.showMessageDialog(atorJogador,
			"Partida Iniciada, voc� come�a jogando!");
			ehMinhaVez = true;
			atorJogador.iniciarPartidaRede(ehMinhaVez);
			ehJogoRede = true;
		} else {
			JOptionPane.showMessageDialog(atorJogador,
			"Partida Iniciada, aguarde uma jogada");
			ehMinhaVez = false;
			atorJogador.iniciarPartidaRede(ehMinhaVez);
			ehJogoRede = true;
		}
	}
	
	/**
	 * Se o jogo estiver sendo realizado em rede, envia a jogada para os outros
	 * jogadores
	 * 
	 * @param linha
	 * @param coluna
	 */
	 
	public void enviarJogadaRede(int linha, int coluna) {
		if (ehJogoRede) {
			Jogada jg = new JogadaVelha(linha, coluna);
			try {
				Proxy.getInstance().enviaJogada(jg);
				ehMinhaVez = false;
			} catch (NaoJogandoException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(atorJogador, e.getMessage());
			}
		}
	}
	
	/* M�todo chamado pelo servidor para enviar a jogada do jogo da velha
	 * para os participantes de uma partida.
	 * O �nico jogador no qual o m�todo n�o � invocado � aquele que enviou a jogada.
	 * (non-Javadoc)
	 * @see br.ufsc.inf.leobr.cliente.OuvidorProxy#receberJogada(br.ufsc.inf.leobr.cliente.Jogada)
	 */
	@Override
	public void receberJogada(Jogada jogada) {
		// Recebe uma jogada do outro lado
		dominioProblema.JogadaVelha jg = (dominioProblema.JogadaVelha) jogada;
		atorJogador.efetuarJogadaRede(jg.getLinha(), jg.getColuna());
		ehMinhaVez = true;

	}
	
	/**
	 * Desconecta o jogo da rede.
	 */
	protected void desconectar() {
		try {
			ehJogoRede = false;
			Proxy.getInstance().desconectar();
		} catch (NaoConectadoException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(atorJogador, "Erro: "
					+ e.getMessage());
		}
		
	}

	
	
	//M�todos complementares
	/**
	 * Reinicia uma partida com todos os iniciantes j� selecionados.
	 */
	protected void reiniciar() {
		try {
			Proxy.getInstance().reiniciarPartida();
		} catch (NaoConectadoException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(atorJogador, "Erro: "
					+ e.getMessage());
		} catch (NaoJogandoException e) {
			JOptionPane.showMessageDialog(atorJogador, "Erro: "
					+ e.getMessage());
		}

	}

	 

	public void finalizarPartidaComErro(String message) {
		JOptionPane.showMessageDialog(atorJogador, message);
		ehJogoRede = false;
	}

	 

	public void receberMensagem(String msg) {
		JOptionPane.showMessageDialog(atorJogador,
				"Mensagem recebida do servidor:" + msg);

	}

	public void tratarConexaoPerdida() {
		JOptionPane
				.showMessageDialog(atorJogador,
						"A conex�o com o servidor foi perdida, por favor tente novamente mais tarde.");
		ehJogoRede = false;
	}

	public void tratarPartidaNaoIniciada(String message) {
		JOptionPane.showMessageDialog(atorJogador,
				"A partida n�o pode ser iniciada devido ao seguinte erro: "
						+ message);

	}
	
	public boolean ehJogoRede(){
		return ehJogoRede;
	}
	
	public boolean ehMinhaVez(){
		return ehMinhaVez;
	}
	
	
	/**
	 * Obt�m o nome do outro jogador de rede.
	 * @return
	 */
	public String obtemNomeAdversario(){
		return Proxy.getInstance().obterNomeAdversarios().get(0);
	}
	
}
