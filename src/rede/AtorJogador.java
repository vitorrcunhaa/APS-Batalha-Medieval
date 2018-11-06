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
            // implementar(se necessario)this.telaPrincipal.atualizarNomeJogador1(nomeOutroJogador, false);
            // implementar(se necessario)this.telaPrincipal.atualizarNomeJogador2(this.nome, true);
            // desabiliar botoes

        }
        // o atualizarInterface estado deve atualizar pelo menos o numero de etapas
        // na tela de batalha ou na tela de jornada
    }

    public void desistir() {
        if (atorNetGames.ehMinhaVez()) {
            controlador.desistir();
            this.enviarEstado();
//            this.telaPrincipal.atualizarInterface(controlador.getEstado());
            this.telaPrincipal.showDialog("Você se rendeu. O jogo acabou.");
            //desabilitar botoes
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
        JOptionPane.showMessageDialog(null, "vc recebeu um estado");
        this.controlador.setEstado(estado);
        this.atorNetGames.minhaVez = true;
        if (!controlador.setEstado(estado)) {
            this.getTelaPrincipal().showDialog("nao recebeu estado");
        } else {
            //habilitar botoes
        }
    }
    
    public void receberPosicao(EstadoMapa estadoMapa) {
        JOptionPane.showMessageDialog(null, "Sua vez!");
        this.atorNetGames.minhaVez = true;
        if(this.controlador.getJogador1() != null){
            if(estadoMapa.getMinhaPosicao() == this.controlador.getJogador1().getPosicaoAtual()) {
            JOptionPane.showMessageDialog(null, "Você encontrou um oponente. Hora da batalha!");
            this.telaJornada.fechaTela();
            this.telaBatalha.exibeTela();
            }
        }
        else {
            if(estadoMapa.getMinhaPosicao() == this.controlador.getJogador2().getPosicaoAtual()) {
            JOptionPane.showMessageDialog(null, "Você encontrou um oponente. Hora da batalha!");
            }
        }
        this.controlador.setEstadoMapa(estadoMapa.isMinhaVez(), estadoMapa.getMinhaPosicao());
        this.telaJornada.habilitarBotoes();
    }
}
