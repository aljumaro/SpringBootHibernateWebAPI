package com.aljumaro.techtest.domain.base;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;
import java.util.UUID;

/**
 * @Date 03/04/2016
 * @Time 9:24
 * @Author Juanma
 */
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
    private Long id;

    public Long getId() {
        return id;
    }
}
