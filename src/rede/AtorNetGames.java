package rede;

import br.ufsc.inf.leobr.cliente.Jogada;
import br.ufsc.inf.leobr.cliente.OuvidorProxy;
import br.ufsc.inf.leobr.cliente.Proxy;
import br.ufsc.inf.leobr.cliente.exception.NaoConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoJogandoException;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

/**
 *
 * @author Vitor
 */
public class AtorNetGames implements OuvidorProxy{

    protected AtorJogador atorJogador;
    protected Proxy proxy;
    protected boolean minhaVez = false;

    public AtorNetGames(AtorJogador atorJogador) {
        super();
        this.atorJogador = atorJogador;
        proxy = Proxy.getInstance();
        proxy.addOuvinte(this);
    }

    public void conectar(String idJogador, String servidor) {
        try {
            proxy.conectar(servidor, idJogador);
            atorJogador.getTelaPrincipal().showDialog("Conexão estabelecida com sucesso!");
            atorJogador.getTelaPrincipal().setEstaConectado(true);
        } catch (Exception msg) {
            atorJogador.getTelaPrincipal().showDialog(msg.getMessage());
            atorJogador.getTelaPrincipal().setEstaConectado(false);
        }
        if(proxy.obterNomeAdversarios().isEmpty())
        {
            atorJogador.atorNetGames.minhaVez = true;
        }
        else
            atorJogador.atorNetGames.minhaVez = false;
    }

    public void desconectar() {
        try {
            proxy.desconectar();
        } catch (NaoConectadoException e) {
            e.printStackTrace();
        }
    }

    public void iniciarPartidaRede() {
        try {
            proxy.iniciarPartida(2);
            if(proxy.obterNomeAdversarios().isEmpty()){
                atorJogador.getTelaPrincipal().setPartidaIniciada(false);
            }
            else
                atorJogador.getTelaPrincipal().setPartidaIniciada(true);
        } catch (NaoConectadoException e) {
            atorJogador.getTelaPrincipal().showDialog(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void iniciarNovaPartida(Integer posicao) {
        //metodo chamado nas duas telas
        minhaVez = posicao == 1 ? true : false;
        atorJogador.iniciarPartidaResposta(minhaVez);
    }

    @Override
    public void finalizarPartidaComErro(String message) {
        atorJogador.getTelaPrincipal().showDialog(message);
    }

    public String obterNomeAdversario() {
        String nome = "";
        if (minhaVez) {
            nome = proxy.obterNomeAdversario(2);
        } else {
            nome = proxy.obterNomeAdversario(1);
        }
        return nome;
    }

    @Override
    public void receberMensagem(String msg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void enviarEstado(EstadoDoJogo mensagem){
        try{
            proxy.enviaJogada(mensagem);
            minhaVez = false;
        }catch (NaoJogandoException e){
            atorJogador.getTelaPrincipal().showDialog(e.getMessage());
        }
    }
    
    @Override
    public void receberJogada(Jogada jogada) {
        EstadoDoJogo estado = (EstadoDoJogo) jogada;
        JOptionPane.showMessageDialog(null, "recebendo jogada");
        atorJogador.receberEstado(estado);
        minhaVez = true;

    }
    
    public boolean ehMinhaVez(){
        return minhaVez;
    }

    @Override
    public void tratarConexaoPerdida() {
        atorJogador.getTelaPrincipal().setPartidaIniciada(false);
        atorJogador.getTelaPrincipal().showDialog("A conexão com o servidor foi perdida!");
    }

    @Override
    public void tratarPartidaNaoIniciada(String message) {
        atorJogador.getTelaPrincipal().setPartidaIniciada(false);
        atorJogador.getTelaPrincipal().showDialog("Não foi possível iniciar a partida. \n Provavelmente não há outro jogador conectado.");
    }

}
