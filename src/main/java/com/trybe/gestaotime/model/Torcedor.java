package com.trybe.gestaotime.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * Classe Torcedor.
 **/
@Entity
public class Torcedor {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String nome;

  @ManyToMany(mappedBy = "torcedores")
  private Set<Time> times;

  public Torcedor() {
    this.times = new HashSet<>();
  }

  public Integer getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Set<Time> getTimes() {
    return times;
  }

  public void setTimes(Time time) {
    this.times.add(time);
  }

}
