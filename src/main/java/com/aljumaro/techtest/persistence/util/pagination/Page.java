package com.aljumaro.techtest.persistence.util.pagination;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.metamodel.Bindable;
import javax.persistence.metamodel.SingularAttribute;

/**
 * @Date 20/05/2016
 * @Time 18:17
 * @Author Juanma
 */
public abstract class Page {

    public static enum SortDirection {
        ASC,
        DESC
    }

    protected int size = -1;
    protected long totalRecords;
    protected SingularAttribute sortAttribute;
    protected SortDirection sortDirection;
    protected SingularAttribute[] allowedAttributes;

    protected Page(int size,
                   long totalRecords,
                   SingularAttribute defaultAttribute,
                   SortDirection defaultDirection,
                   SingularAttribute... allowedAttributes) {
        this.size = size;
        this.totalRecords = totalRecords;
        this.sortDirection = defaultDirection;
        this.allowedAttributes = allowedAttributes;
        setSortAttribute(defaultAttribute);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(long totalRecords) {
        this.totalRecords = totalRecords;
    }

    public SingularAttribute getSortAttribute() {
        return sortAttribute;
    }

    public void setSortAttribute(SingularAttribute sortAttribute) {
        this.sortAttribute = sortAttribute;
    }

    public SortDirection getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(SortDirection sortDirection) {
        this.sortDirection = sortDirection;
    }

    public boolean isSortedAscending() {
        return SortDirection.ASC.equals(getSortDirection());
    }

    public SingularAttribute[] getAllowedAttributes() {
        return allowedAttributes;
    }

    public void setAllowedAttributes(SingularAttribute[] allowedAttributes) {
        this.allowedAttributes = allowedAttributes;
    }

    public boolean isAttributeDeclaredIn(SingularAttribute attribute, Bindable bindable) {
        return attribute != null && attribute.getDeclaringType().equals(bindable);
    }

    public boolean isApplicableFor(Bindable bindable) {
        return isAttributeDeclaredIn(getSortAttribute(), bindable);
    }

    public void throwIfNotApplicableFor(Path attributePath) {
        if (!isApplicableFor(attributePath.getModel())) {
            throw new IllegalArgumentException(
                    "Paging settings/sort attribute are not declared " +
                            "by model of query path: " + attributePath
            );
        }
    }

    abstract public <T> TypedQuery<T> createQuery(EntityManager em, CriteriaQuery<T> criteriaQuery, Path attributePath);
}
