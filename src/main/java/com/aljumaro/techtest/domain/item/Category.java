package com.aljumaro.techtest.domain.item;

import com.aljumaro.techtest.domain.base.BaseEntity;
import com.aljumaro.techtest.utilities.Constants;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * @Date 16/04/2016
 * @Time 16:23
 * @Author Juanma
 */
@Entity
public class Category extends BaseEntity {

    @NotNull
    private String name;

    @ManyToMany(mappedBy = "categories")
    protected Set<Item> items = new HashSet<Item>();

    protected Category(){}

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }
}
