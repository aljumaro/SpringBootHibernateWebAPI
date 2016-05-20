package com.aljumaro.techtest.persistence.util.pagination;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.metamodel.SingularAttribute;
import java.math.BigDecimal;

/**
 * @Date 20/05/2016
 * @Time 18:27
 * @Author Juanma
 */
public class OffsetPage extends Page {

    protected int current = 1;

    public OffsetPage(int size,
                      long totalRecords,
                      SingularAttribute defaultAttribute,
                      SortDirection defaultDirection,
                      SingularAttribute... allowedAttributes) {
        super(size, totalRecords, defaultAttribute, defaultDirection, allowedAttributes);
    }

    @Override
    public <T> TypedQuery<T> createQuery(EntityManager em, CriteriaQuery<T> criteriaQuery, Path attributePath) {

        throwIfNotApplicableFor(attributePath);

        CriteriaBuilder cb = em.getCriteriaBuilder();
        Path sortPath = attributePath.get(getSortAttribute());
        criteriaQuery.orderBy(isSortedAscending() ? cb.asc(sortPath) : cb.desc(sortPath));

        TypedQuery<T> query = em.createQuery(criteriaQuery);
        query.setFirstResult(getRangeStartInteger());

        if (getSize() != -1){
            query.setMaxResults(getSize());
        }

        return query;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public long getRangeStart() {
        return (getCurrent() - 1) * getSize();
    }

    public int getRangeStartInteger() throws ArithmeticException {
        return new BigDecimal(getRangeStart()).intValueExact();
    }
}
