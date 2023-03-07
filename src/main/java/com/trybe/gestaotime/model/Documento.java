package com.trybe.gestaotime.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Classe Documento.
 */
@Entity
public class Documento {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String cpf;

  private String numeroDaCdt;

  private String numeroCbf;

  public Long getId() {
    return id;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getNumeroDaCdt() {
    return numeroDaCdt;
  }

  public void setNumeroDaCdt(String numeroDaCdt) {
    this.numeroDaCdt = numeroDaCdt;
  }

  public String getNumeroCbf() {
    return numeroCbf;
  }

  public void setNumeroCbf(String numeroCbf) {
    this.numeroCbf = numeroCbf;
  }

}
