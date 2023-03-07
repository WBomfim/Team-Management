package com.trybe.gestaotime.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Classe abstrata GenericDao.
 **/

public abstract class GenericDao<T, I extends Serializable> {
  private EntityManagerFactory emf;

  public GenericDao() {
    this.emf = Persistence.createEntityManagerFactory("crudHibernatePU");
  }
  
  public void salvar(T entity) {
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    em.persist(entity);
    em.getTransaction().commit();
    em.close();
  }

  public void editar(T entity) {
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    em.merge(entity);
    em.getTransaction().commit();
    em.close();
  }

  public void deletar(Long id, Class<T> classe) {
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    T entity = em.find(classe, id);
    em.remove(entity);
    em.getTransaction().commit();
    em.close();
  }

  public T pegar(Long id, Class<T> classe) {
    EntityManager em = emf.createEntityManager();
    T entity = em.find(classe, id);
    em.close();
    return entity;
  }

  public List<T> listar(Class<T> classe) {
    EntityManager em = emf.createEntityManager();
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<T> cq = cb.createQuery(classe);
    Root<T> rootEntry = cq.from(classe);
    CriteriaQuery<T> all = cq.select(rootEntry);
    TypedQuery<T> allQuery = em.createQuery(all);
    return allQuery.getResultList();
  }

}
