package com.aljumaro.techtest.domain.base;

import com.aljumaro.techtest.utilities.Constants;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

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
    protected Date createdOn;

    protected Date modifiedOn;

    @PrePersist
    protected void onCreate() {
        createdOn = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        modifiedOn = new Date();
    }

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
