package com.trybe.gestaotime.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 * Classe Time.
 **/
@Entity
public class Time {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String nome;

  @OneToMany
  private List<Jogador> jogadores;

  @ManyToMany
  @JoinTable(name = "time_torcedor", joinColumns = { @JoinColumn(name = "time_id") },
      inverseJoinColumns = { @JoinColumn(name = "torcedor_id") })
  private List<Torcedor> torcedores;

  public Integer getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public List<Jogador> getJogadores() {
    return jogadores;
  }

  public void setJogadores(List<Jogador> jogadores) {
    this.jogadores = jogadores;
  }

  public List<Torcedor> getTorcedores() {
    return torcedores;
  }

  public void setTorcedores(List<Torcedor> torcedores) {
    this.torcedores = torcedores;
  }

}
