package com.aljumaro.techtest.domain.billing;

import com.aljumaro.techtest.domain.user.User;
import com.aljumaro.techtest.utilities.Constants;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @Date 23/04/2016
 * @Time 8:57
 * @Author Juanma
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BillingDetails {

    @Id
    @GeneratedValue(generator = Constants.ID_GENERATOR)
    private Long id;

    @NotNull
    protected String owner;

    @ManyToOne(fetch = FetchType.LAZY)
    protected User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
