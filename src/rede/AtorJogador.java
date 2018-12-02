package rede;

import controller.Controlador;
import javax.swing.JOptionPane;
import model.Jogador;
import view.TelaBatalha;
import view.TelaEscolhaPersonagem;
import view.TelaJornada;
import view.TelaPrincipal;

/**
 *
 * @author Vitor
 */
public class AtorJogador {

    protected String nome;
    protected Controlador controlador;
    protected AtorNetGames atorNetGames;
    protected TelaPrincipal telaPrincipal;
    protected TelaEscolhaPersonagem telaEscolhaPersonagem;
    protected TelaJornada telaJornada;
    protected TelaBatalha telaBatalha;
    protected int defesaAtualOponente;

    public AtorJogador() {
        this.telaPrincipal = new TelaPrincipal(this);
        this.telaEscolhaPersonagem = new TelaEscolhaPersonagem(this);
        this.telaJornada = new TelaJornada(this);
        this.telaBatalha = new TelaBatalha(this);
        atorNetGames = new AtorNetGames(this);
        exibeTela();
    }
    
    private String showNameQuestion() {
        this.nome = this.telaPrincipal.showNameQuestion();
        if (this.nome.isEmpty()) {
            this.nome = "Anônimo";
        }
        return this.nome;
    }

    public void exibeTela() {
        this.telaPrincipal.exibeTela();
    }

    public void exibeTelaBatalha() {
        this.telaBatalha.exibeTela();
    }

    public void exibeTelaPersonagem() {
        this.telaEscolhaPersonagem.exibeTela();
    }

    public void exibeTelaJornada() {
        this.telaJornada.exibeTela();
    }

    public TelaPrincipal getTelaPrincipal() {
        return telaPrincipal;
    }
    
    public boolean comecouJogando(){
        return this.atorNetGames.minhaVez;
    }
    
    public Jogador getJogador() {
        if(this.controlador.getJogador1()==null){
            return this.controlador.getJogador2();
        }
        else
            return this.controlador.getJogador1();
    }

    public void criarPersonagem(String tipo, int ataque, int defesa, int vida) {
        if (this.controlador.verificaJogador1(this.controlador.getJogador1())) {
            this.controlador.getJogador1().setPersonagem(tipo, ataque, defesa, vida);
            JOptionPane.showMessageDialog(telaPrincipal, "Personagem 1 criado com sucesso.");
        } else if (this.controlador.verificaJogador2(this.controlador.getJogador2())) {
            this.controlador.getJogador2().setPersonagem(tipo, ataque, defesa, vida);
            JOptionPane.showMessageDialog(telaPrincipal, "Personagem 2 criado com sucesso.");
        } else {
            JOptionPane.showMessageDialog(telaPrincipal, "Nenhum jogador criado.");
        }
    }
    
    public void iniciarPartidaPedido() {
        atorNetGames.iniciarPartidaRede();
    }

    public void iniciarPartidaResposta(boolean comecoJogando) {
        String nomeOutroJogador = atorNetGames.obterNomeAdversario();
        if(this.controlador.getJogador1()!=null){
            this.controlador.setJogador1(this.controlador.getJogador1());
        }
        if(this.controlador.getJogador2()!=null){
            this.controlador.setJogador2(this.controlador.getJogador2());
        }
        this.telaJornada = new TelaJornada(this);
      
        if (comecoJogando) {
            this.telaPrincipal.showDialog("Jogadores conectados. Você começa jogando.");
            Jogador jogador = this.controlador.getJogador1();
            jogador.setPosicaoAtual(1);
            this.exibeTelaJornada();
        } else {
            this.telaPrincipal.showDialog("Jogadores conectados. Aguarde a jogada do seu adversário.");
            Jogador jogador = this.controlador.getJogador2();
            jogador.setPosicaoAtual(16);
            this.exibeTelaJornada();
        }
    }

    public void desistir() {
        this.controlador.getEstado().setDesistiu(true);
        this.enviarEstado();
    }
    
    public void setVencedor() {
        this.controlador.getEstado().setVencedor(true);
    }

    public void conectar() {
        nome = this.showNameQuestion();
        atorNetGames.conectar(nome, "localhost");
        controlador = new Controlador(this);
        this.controlador.criarJogador(this.nome, atorNetGames.minhaVez);
    }

    public void enviarEstado() {
        atorNetGames.enviarEstado(controlador.getEstado());
    }
    
    public void enviarPosicao(int posicao, boolean minhaVez)
    {
        this.controlador.setEstadoMapa(minhaVez, posicao);
        atorNetGames.enviarPosicao(controlador.getEstadoMapa());
    }

    public void receberEstado(EstadoDoJogo estado) {
        this.defesaAtualOponente = estado.getJogador().getPersonagem().getDefesa();
        if (estado.isDesistir()) {
            JOptionPane.showMessageDialog(null, "Seu oponente desistiu. Sendo assim, você venceu a batalha, parabéns!");
            this.telaBatalha.dispose();
        }
        else if(estado.isVencedor()) {
            JOptionPane.showMessageDialog(null, "Você recebeu um dano de: "+estado.getDano()+".");
            JOptionPane.showMessageDialog(null, "Meus pêsames. Você perdeu a batalha.");
            this.telaBatalha.dispose();
        }
        
        else if(estado.isPrimeiraJogada()) {
            this.controlador.setEstado(estado);
            this.controlador.getEstado().setPrimeiraJogada(false);
            this.controlador.getEstado().setPreparadoPraJogar(true);
            this.telaBatalha.preencheInformacoesOponente(estado.getJogador());
            this.telaBatalha.desabilitarBotoes();
            this.controlador.getEstado().setJogador(this.getJogador());
            this.controlador.setEstado(this.controlador.getEstado());
            this.telaJornada.fechaTela();
            this.telaBatalha.exibeTela();
            this.enviarEstado();
        }
        else if(estado.isPreparadoPraJogar()) {
            this.controlador.getEstado().setPreparadoPraJogar(false);
            this.controlador.getEstado().setPrimeiraJogada(false);
            this.telaBatalha.preencheInformacoesOponente(estado.getJogador());
        }
        else if(estado.getDano() > 0) {
            this.controlador.getEstado().setPreparadoPraJogar(false);
            this.telaBatalha.atualizaVidaLabelOponente(estado.getJogador().getPersonagem().getVida());
            estado.getJogador().getPersonagem().getVida();
            int dano = estado.getDano();
            int vidaAtual = this.getJogador().getPersonagem().getVida();
            this.getJogador().getPersonagem().setVida(vidaAtual - dano);
            JOptionPane.showMessageDialog(null, "Você recebeu um dano de: "+dano+". Vida atual: "+this.getJogador().getPersonagem().getVida());
            this.telaBatalha.atualizaVidaLabel(this.getJogador().getPersonagem().getVida());
            this.telaBatalha.habilitarBotoes();
        }
    }
    
    public void receberPosicao(EstadoMapa estadoMapa) {
        JOptionPane.showMessageDialog(null, "Sua vez!");
        if(estadoMapa.getMinhaPosicao() == this.getJogador().getPosicaoAtual()) {
            JOptionPane.showMessageDialog(null, "Você encontrou um oponente. Hora da batalha!");
            this.controlador.setEstado(new EstadoDoJogo(this.getJogador(), false, false, true, false, 0));
            this.telaJornada.fechaTela();
            this.telaBatalha.exibeTela();
            this.enviarEstado();
        }
        this.controlador.setEstadoMapa(estadoMapa.isMinhaVez(), estadoMapa.getMinhaPosicao());
        this.telaJornada.habilitarBotoes();
    }

    public int getDefesaOponente(){
        return this.defesaAtualOponente;
    }
    
    public int calculaAtaque(int modificadorAtaque) {   
        int dano = (int) ((this.getJogador().getPersonagem().getAtaque()*0.6) + (modificadorAtaque*0.7) - (getDefesaOponente()*0.55));
        if (dano <= 0) { 
            dano = 1;
        }
        this.controlador.getEstado().setDano(dano);
        this.controlador.getEstado().setJogador(this.getJogador());
        return dano;
    }

    public int calculaAtaqueArriscado(int modificadorAtaque) {
       int dano = (int) ((this.getJogador().getPersonagem().getAtaque()*0.55) + (modificadorAtaque*1.2) - (getDefesaOponente()*0.6));
       if (dano <= 0) { 
            dano = 1;
        }
       this.controlador.getEstado().setDano(dano);
       this.controlador.getEstado().setJogador(this.getJogador());
       return dano;
    }
}
