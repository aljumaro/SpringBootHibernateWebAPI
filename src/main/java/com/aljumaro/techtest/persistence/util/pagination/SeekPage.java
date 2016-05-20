package com.aljumaro.techtest.persistence.util.pagination;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.SingularAttribute;

/**
 * @Date 20/05/2016
 * @Time 18:36
 * @Author Juanma
 */
public class SeekPage extends Page {

    protected SingularAttribute uniqueAttribute;
    protected Comparable lastValue;
    protected Comparable lastUniqueValue;

    public SeekPage(int size,
                    long totalRecords,
                    SingularAttribute defaultAttribute,
                    SortDirection defaultDirection,
                    SingularAttribute uniqueAttribute,
                    SingularAttribute... allowedAttributes) {
        super(size, totalRecords, defaultAttribute, defaultDirection, allowedAttributes);
        this.uniqueAttribute = uniqueAttribute;
    }

    @Override
    public <T> TypedQuery<T> createQuery(EntityManager em, CriteriaQuery<T> criteriaQuery, Path attributePath) {

        throwIfNotApplicableFor(attributePath);

        CriteriaBuilder cb = em.getCriteriaBuilder();

        Path sortPath = attributePath.get(getSortAttribute());
        Path uniqueSortPath = attributePath.get(getUniqueAttribute());

        if (isSortedAscending()) {
            criteriaQuery.orderBy(cb.asc(sortPath), cb.asc(uniqueSortPath));
        }else {
            criteriaQuery.orderBy(cb.desc(sortPath), cb.desc(uniqueSortPath));
        }

        applySeekRestriction(em, criteriaQuery, attributePath);

        TypedQuery<T> query = em.createQuery(criteriaQuery);

        if (getSize() != -1) {
            query.setMaxResults(getSize());
        }

        return query;
    }

    private <T> void applySeekRestriction(EntityManager em, CriteriaQuery<T> criteriaQuery, Path attributePath) {

        if (isFirst()) {
            return;
        }

        applySeekRestriction(
                em,
                criteriaQuery,
                attributePath,
                em.getCriteriaBuilder().literal(getLastValue()),
                em.getCriteriaBuilder().literal(getLastUniqueValue())
        );
    }

    protected void applySeekRestriction(EntityManager em,
                                        AbstractQuery criteriaQuery,
                                        Path attributePath,
                                        Expression lastValueExpression,
                                        Expression lastUniqueValueExpression) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        criteriaQuery.where(
                cb.and(
                        (isSortedAscending()
                                ? cb.greaterThanOrEqualTo( attributePath.get(getSortAttribute()), lastValueExpression)
                                : cb.lessThanOrEqualTo( attributePath.get(getSortAttribute()), lastValueExpression)
                        ),
                        cb.or(
                                cb.notEqual(attributePath.get(getSortAttribute()), lastValueExpression),
                                (isSortedAscending()
                                        ? cb.greaterThan(attributePath.get(getUniqueAttribute()), lastUniqueValueExpression)
                                        : cb.lessThan(attributePath.get(getUniqueAttribute()), lastUniqueValueExpression)
                                )
                        )
                )
        );
    }

    public boolean isFirst() {
        return getLastValue() == null || getLastUniqueValue() == null;
    }

    public SingularAttribute getUniqueAttribute() {
        return uniqueAttribute;
    }

    public void setUniqueAttribute(SingularAttribute uniqueAttribute) {
        this.uniqueAttribute = uniqueAttribute;
    }

    public Comparable getLastValue() {
        return lastValue;
    }

    public void setLastValue(Comparable lastValue) {
        this.lastValue = lastValue;
    }

    public Comparable getLastUniqueValue() {
        return lastUniqueValue;
    }

    public void setLastUniqueValue(Comparable lastUniqueValue) {
        this.lastUniqueValue = lastUniqueValue;
    }
}
