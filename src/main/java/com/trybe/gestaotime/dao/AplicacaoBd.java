package com.trybe.gestaotime.dao;

/**
 * Classe AplicacaoBd.
 * 
 **/
public class AplicacaoBd {
  private TimeDao timeDao;
  private JogadorDao jogadorDao;
  private TorcedorDao torcedorDao;
  private DocumentoDao documentoDao;

  /**
   * Construtor da classe AplicacaoBd.
   */
  public AplicacaoBd() {
    this.timeDao = new TimeDao();
    this.jogadorDao = new JogadorDao();
    this.torcedorDao = new TorcedorDao();
    this.documentoDao = new DocumentoDao();
  }

  public TimeDao timeDao() {
    return timeDao;
  }

  public JogadorDao jogadorDao() {
    return jogadorDao;
  }

  public TorcedorDao torcedorDao() {
    return torcedorDao;
  }

  public DocumentoDao documentoDao() {
    return documentoDao;
  }

}
