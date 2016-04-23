package com.aljumaro.techtest.domain.user;

import com.aljumaro.techtest.domain.base.BaseEntity;
import com.aljumaro.techtest.domain.billing.BillingDetails;
import com.aljumaro.techtest.domain.common.converter.ZipConverter;
import com.aljumaro.techtest.domain.common.embeddable.Address;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

/**
 * @Date 16/04/2016
 * @Time 15:39
 * @Author Juanma
 */
@Entity
public class User extends BaseEntity {

    @NotNull
    @Size(min = 5, max = 10)
    protected String userName;

    @NotNull
    @Size(min = 5, max = 20)
    protected String firstName;

    @NotNull
    @Size(min = 5, max = 20)
    protected String lastName;

    //Address es embbedable no es necesaria ninguna anotación
    @Convert(
            converter = ZipConverter.class,
            attributeName = "zip"
    )
    protected Address homeAddress;

    @AttributeOverrides({
        @AttributeOverride(name = "street",
            column = @Column(name = "BILLING_STREET")),
        @AttributeOverride(name = "zip",
            column = @Column(name = "BILLING_ZIP")),
        @AttributeOverride(name = "city",
            column = @Column(name = "BILLING_CITY"))
    })
    protected Address billingAddress;

    @OneToMany(mappedBy = "user")
    protected Set<BillingDetails> billingDetailsSet = new HashSet<BillingDetails>();

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Set<BillingDetails> getBillingDetailsSet() {
        return billingDetailsSet;
    }

    public void setBillingDetailsSet(Set<BillingDetails> billingDetailsSet) {
        this.billingDetailsSet = billingDetailsSet;
    }
}
