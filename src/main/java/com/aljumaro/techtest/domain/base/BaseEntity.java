package com.aljumaro.techtest.domain.base;

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
    private UUID id;
    private Date createdOn;
    private String createdBy;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
