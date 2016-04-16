package com.aljumaro.techtest.domain.item;

import com.aljumaro.techtest.domain.base.BaseEntity;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * @Date 16/04/2016
 * @Time 16:23
 * @Author Juanma
 */
@Entity
public class Category extends BaseEntity {

    @NotNull
    private String name;
}
