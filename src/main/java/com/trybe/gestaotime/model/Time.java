package com.trybe.gestaotime.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
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
  private Long id;

  private String nome;

  @OneToMany(mappedBy = "time", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
  private Set<Jogador> jogadores;

  @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
  @JoinTable(name = "time_torcedor", joinColumns = { @JoinColumn(name = "time_id") },
      inverseJoinColumns = { @JoinColumn(name = "torcedor_id") })
  private Set<Torcedor> torcedores;

  public Time() {
    this.jogadores = new HashSet<>();
    this.torcedores = new HashSet<>();
  }

  public Long getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Set<Jogador> getJogadores() {
    return jogadores;
  }

  public void setJogadores(Jogador jogador) {
    this.jogadores.add(jogador);
  }

  public Set<Torcedor> getTorcedores() {
    return torcedores;
  }

  public void setTorcedores(Torcedor torcedor) {
    this.torcedores.add(torcedor);
  }

}
