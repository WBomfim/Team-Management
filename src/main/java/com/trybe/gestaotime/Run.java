package com.trybe.gestaotime;

import com.trybe.gestaotime.dao.AplicacaoBd;
import com.trybe.gestaotime.model.Documento;
import com.trybe.gestaotime.model.Jogador;
import com.trybe.gestaotime.model.Time;
import com.trybe.gestaotime.model.Torcedor;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe Run.
 * 
 */
public class Run {
  private static AplicacaoBd aplicacaoBd = new AplicacaoBd();
  private static List<Jogador> jogadores = new ArrayList<Jogador>();
  private static List<Torcedor> torcedores = new ArrayList<Torcedor>();

  /**
   * Método Principal.
   */
  public static void main(String[] args) {
    Time time = new Time();
    time.setNome("Palmeiras");

    Documento documento1 = new Documento();
    documento1.setCpf("12345678910");
    documento1.setNumeroCarteiraTrabalho("12345678910-1");
    documento1.setNumeroCbf("12345");

    Documento documento2 = new Documento();
    documento2.setCpf("12345678911");
    documento2.setNumeroCarteiraTrabalho("12345678911-1");
    documento2.setNumeroCbf("12346");
    
    Jogador jogador1 = new Jogador();
    jogador1.setNome("Ronaldo");
    jogador1.setPosicao("Atacante");
    jogador1.setDocumento(documento1);
    jogador1.setTime(time);
    jogadores.add(jogador1);

    Jogador jogador2 = new Jogador();
    jogador2.setNome("Rivaldo");
    jogador2.setPosicao("Atacante");
    jogador2.setDocumento(documento2);
    jogador2.setTime(time);
    jogadores.add(jogador2);
    
    time.setJogadores(jogadores);

    Torcedor torcedor = new Torcedor();
    torcedor.setNome("João");
    torcedor.setTimes(time);
    torcedores.add(torcedor);

    time.setTorcedores(torcedores);

    aplicacaoBd.documentoDao().salvar(documento1);
    aplicacaoBd.documentoDao().salvar(documento2);
    aplicacaoBd.jogadorDao().salvar(jogador1);
    aplicacaoBd.jogadorDao().salvar(jogador2);
    aplicacaoBd.torcedorDao().salvar(torcedor);
    aplicacaoBd.timeDao().salvar(time);
  }
}
