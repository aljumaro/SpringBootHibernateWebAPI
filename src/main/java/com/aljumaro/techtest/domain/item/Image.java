package com.aljumaro.techtest.domain.item;

import com.aljumaro.techtest.domain.base.BaseEntity;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @Date 16/04/2016
 * @Time 16:44
 * @Author Juanma
 */
@Entity
public class Image extends BaseEntity{

    @NotNull
    @Size(
            min = 5,
            max = 255
    )
    private String title;

    @NotNull
    @Size(
            min = 10,
            max = 255
    )
    private String fileName;

    protected Image(){}

    public Image(String title, String fileName){
        this.title = title;
        this.fileName = fileName;
    }
}
