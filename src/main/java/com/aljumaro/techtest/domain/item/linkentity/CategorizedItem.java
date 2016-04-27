package com.aljumaro.techtest.domain.item.linkentity;

import com.aljumaro.techtest.domain.item.Category;
import com.aljumaro.techtest.domain.item.Item;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @Date 27/04/2016
 * @Time 19:51
 * @Author Juanma
 */
@Entity
@Table(name = "CATEGORY_ITEM")
@org.hibernate.annotations.Immutable
public class CategorizedItem {

    @Embeddable
    public static class Id implements Serializable {

        @Column(name = "CATEGORY_ID")
        private Long categoryId;

        @Column(name = "ITEM_ID")
        private Long itemId;

        public Id(){}

        public Id(Long categoryId, Long itemId) {
            this.categoryId = categoryId;
            this.itemId = itemId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Id id = (Id) o;

            if (categoryId != null ? !categoryId.equals(id.categoryId) : id.categoryId != null) return false;
            return itemId != null ? itemId.equals(id.itemId) : id.itemId == null;

        }

        @Override
        public int hashCode() {
            int result = categoryId != null ? categoryId.hashCode() : 0;
            result = 31 * result + (itemId != null ? itemId.hashCode() : 0);
            return result;
        }
    }

    @EmbeddedId
    protected Id id = new Id();

    @NotNull
    @Column(updatable = false)
    protected String addedBy;

    @NotNull
    @Column(updatable = false)
    protected Date addedOn = new Date();

    @ManyToOne
    @JoinColumn(
            name = "CATEGORY_ID",
            insertable = false, updatable = false
    )
    protected Category category;

    @ManyToOne
    @JoinColumn(
            name = "ITEM_ID",
            insertable = false, updatable = false
    )
    protected Item item;

    public CategorizedItem(String addedBy, Category category, Item item) {
        this.addedBy = addedBy;
        this.category = category;
        this.item = item;

        this.id.categoryId = category.getId();
        this.id.itemId = item.getId();

        category.getCategorizedItems().add(this);
        item.getCategorizedItems().add(this);
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public String getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(String addedBy) {
        this.addedBy = addedBy;
    }

    public Date getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(Date addedOn) {
        this.addedOn = addedOn;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
