package com.aljumaro.techtest.persistence.base;

import javax.persistence.LockModeType;
import java.util.List;

/**
 * @Date 09/05/2016
 * @Time 20:54
 * @Author Juanma
 */
public interface GenericDAO<T, ID> {

    T findById(ID id);

    T findById(ID id, LockModeType lock);

    T findReferenceById(ID id);

    List<T> findAll();

    Long getCount();

    T makePersistent(T detached);

    void makeTransient(T entity);

    void checkVersion(T entity, boolean forceUpdate);
}
