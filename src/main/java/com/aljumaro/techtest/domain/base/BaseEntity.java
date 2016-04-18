package com.aljumaro.techtest.domain.base;

import com.aljumaro.techtest.utilities.Constants;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
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
    @GeneratedValue(generator = Constants.ID_GENERATOR)
    private Long id;

    @NotNull
    @Column(updatable = false)
    @org.hibernate.annotations.CreationTimestamp
    protected Date createdOn;

    @org.hibernate.annotations.UpdateTimestamp
    protected Date modifiedOn;

    public Long getId() {
        return id;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }
}
