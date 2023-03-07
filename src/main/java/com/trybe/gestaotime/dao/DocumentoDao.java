package com.trybe.gestaotime.dao;

import java.util.List;

import com.trybe.gestaotime.model.Documento;

public class DocumentoDao extends GenericDao<Documento, Integer> {

  public void deletar(Integer id) {
    super.deletar(id, Documento.class);
  }

  public Documento pegar(Integer id) {
    return super.pegar(id, Documento.class);
  }

  public List<Documento> listar() {
    return super.listar(Documento.class);
  }
}
