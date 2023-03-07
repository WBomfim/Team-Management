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
 *
 **/
public abstract class GenericDao<T, I extends Serializable> {
  private Class<T> classType;
  private EntityManagerFactory emf;

  public GenericDao(Class<T> classType) {
    this.classType = classType;
    this.emf = Persistence.createEntityManagerFactory("crudHibernatePU");
  }
  
  /**
   * Método salvar.
   * 
   */
  public void salvar(T entity) {
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    em.persist(entity);
    em.getTransaction().commit();
    em.close();
  }

  /**
   * Método editar.
   */
  public void editar(T entity) {
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    em.merge(entity);
    em.getTransaction().commit();
    em.close();
  }

  /**
   * Método deletar.
   * 
   */
  public void deletar(Integer id) {
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    T entity = em.find(classType, id);
    em.remove(entity);
    em.getTransaction().commit();
    em.close();
  }

  /**
   * Método pegar.
   * 
   */
  public T pegar(Integer id) {
    EntityManager em = emf.createEntityManager();
    T entity = em.find(classType, id);
    em.close();
    return entity;
  }

  /**
   * Método listar.
   * 
   */
  public List<T> listar() {
    EntityManager em = emf.createEntityManager();
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<T> cq = cb.createQuery(classType);
    Root<T> rootEntry = cq.from(classType);
    CriteriaQuery<T> all = cq.select(rootEntry);
    TypedQuery<T> allQuery = em.createQuery(all);
    return allQuery.getResultList();
  }

}
