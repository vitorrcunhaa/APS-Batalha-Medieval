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
        if (atorNetGames.ehMinhaVez()) {
            controlador.desistir();
            this.enviarEstado();
            this.telaPrincipal.showDialog("Você se rendeu. O jogo acabou.");
        } else {
            this.telaPrincipal.showDialog("Não é a sua vez.");
        }
    }

    public void conectar() {
        nome = this.showNameQuestion();
        atorNetGames.conectar(nome, "localhost");
        controlador = new Controlador(this);
        this.controlador.criarJogador(this.nome, atorNetGames.minhaVez);
    }

    public void informarPerdedor() {
        //criar botao desistir
        // this.telaJornada.desabilitarBotaoDesistir
        // this.telaBatalha.desabilitarBotaoDesistir
        this.telaPrincipal.showDialog("Você foi derrotado! O jogo acabou.");
    }

    public void informarVencedor() {
        //criar botao desistir
        // this.telaJornada.desabilitarBotaoDesistir
        // this.telaBatalha.desabilitarBotaoDesistir
        this.telaPrincipal.showDialog("Você aniquilou o oponente e venceu a batalha! O jogo acabou.");
    }

    public void informarDesistencia() {
        //criar botao desistir
        // this.telaJornada.desabilitarBotaoDesistir
        // this.telaBatalha.desabilitarBotaoDesistir
        this.telaPrincipal.showDialog("O outro jogador desistiu. Parabéns, você é o vencedor! O jogo acabou.");
    }

    public void enviarEstado() {
        //desabilitar botoes
        atorNetGames.enviarEstado(controlador.getEstado());
    }
    
    public void enviarPosicao(int posicao, boolean minhaVez)
    {
        this.controlador.setEstadoMapa(minhaVez, posicao);
        atorNetGames.enviarPosicao(controlador.getEstadoMapa());
    }

    public void receberEstado(EstadoDoJogo estado) {
        if(estado.getEstadoDoJogo().isPrimeiraJogada()) {
//           esta É a primeira vez que este metodo é chamado
//           neste momento apenas uma tela de batalha consegue as informacoes do adversario
//           por isso uma variavel auxiliar(preparadoParaJogar) é setada como true
//           para devolver a jogada para o jogador que tinha a vez, e que ele tambem
//           receba as informacoes do oponente
            this.telaJornada.fechaTela();
            this.telaBatalha.exibeTela();
            this.telaBatalha.preencheInformacoesOponente(estado.getJogador());
            estado.getEstadoDoJogo().setPrimeiraJogada(false);
            estado.getEstadoDoJogo().setPreparadoPraJogar(true);
            //desabilita meus botoes
            estado.setJogador(this.controlador.getJogador2()); //verificar se é jogador 2 ou se pode ser jogador 1 também
            this.controlador.setEstado(estado);
            this.enviarEstado();
        }
        if(estado.getEstadoDoJogo().isPreparadoPraJogar()) {
            //aqui começará de fato a primeira 
            this.telaBatalha.preencheInformacoesOponente(estado.getJogador());
        }
        //habilitar botoes
        // criar variavel de auxilio boolean ehAtaque
    }
    
    public void receberPosicao(EstadoMapa estadoMapa) {
        JOptionPane.showMessageDialog(null, "Sua vez!");
        if(this.controlador.getJogador1() != null){
            if(estadoMapa.getMinhaPosicao() == this.controlador.getJogador1().getPosicaoAtual()) {
            JOptionPane.showMessageDialog(null, "Você encontrou um oponente. Hora da batalha!");
            this.controlador.setEstado(new EstadoDoJogo(this.controlador.getJogador1(), false, false, true, false));
            this.enviarEstado();
            this.telaJornada.fechaTela();
            this.telaBatalha.exibeTela();
            }
        }
        else {
            if(estadoMapa.getMinhaPosicao() == this.controlador.getJogador2().getPosicaoAtual()) {
            JOptionPane.showMessageDialog(null, "Você encontrou um oponente. Hora da batalha!");
            this.controlador.setEstado(new EstadoDoJogo(this.controlador.getJogador2(), false, false, true, false));
            this.enviarEstado();
            this.telaJornada.fechaTela();
            this.telaBatalha.exibeTela();
            }
        }
        this.controlador.setEstadoMapa(estadoMapa.isMinhaVez(), estadoMapa.getMinhaPosicao());
        this.telaJornada.habilitarBotoes();
    }
}
