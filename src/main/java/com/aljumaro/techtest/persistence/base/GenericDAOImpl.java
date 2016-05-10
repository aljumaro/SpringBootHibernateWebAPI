package com.aljumaro.techtest.persistence.base;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

/**
 * @Date 09/05/2016
 * @Time 20:57
 * @Author Juanma
 */
public abstract class GenericDAOImpl<T, ID extends Serializable> implements GenericDAO<T, ID> {

    protected EntityManager em;
    protected final Class<T> entityClass;

    protected GenericDAOImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Autowired
    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public T findById(ID id) {
        return findById(id, LockModeType.NONE);
    }

    @Override
    public T findById(ID id, LockModeType lock) {
        return em.find(entityClass, id, lock);
    }

    @Override
    public T findReferenceById(ID id) {
        return em.getReference(entityClass, id);
    }

    @Override
    public List<T> findAll() {
        CriteriaQuery<T> cq = em.getCriteriaBuilder().createQuery(entityClass);
        cq.select(cq.from(entityClass));

        return em.createQuery(cq).getResultList();
    }

    @Override
    public Long getCount() {
        CriteriaQuery<Long> cq = em.getCriteriaBuilder().createQuery(Long.class);
        cq.select(em.getCriteriaBuilder().count(cq.from(entityClass)));

        return em.createQuery(cq).getSingleResult();
    }

    @Override
    public T makePersistent(T detached) {
        return em.merge(detached);
    }

    @Override
    public void makeTransient(T entity) {
        em.remove(entity);
    }

    @Override
    public void checkVersion(T entity, boolean forceUpdate) {
        em.lock(entity, forceUpdate ? LockModeType.OPTIMISTIC_FORCE_INCREMENT: LockModeType.OPTIMISTIC);
    }

}
