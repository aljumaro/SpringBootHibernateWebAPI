package com.aljumaro.techtest.domain.item;

import com.aljumaro.techtest.domain.base.BaseEntity;
import com.aljumaro.techtest.utilities.Constants;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * @Date 16/04/2016
 * @Time 16:23
 * @Author Juanma
 */
@Entity
public class Category {

    @Id
    @GeneratedValue(generator = Constants.ID_GENERATOR)
    private Long id;

    @NotNull
    private String name;
}
