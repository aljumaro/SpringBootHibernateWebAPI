package com.aljumaro.techtest.domain.common.embeddable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 * @Date 19/04/2016
 * @Time 19:47
 * @Author Juanma
 */
@Embeddable
public class Address {

    /*
        https://hibernate.atlassian.net/projects/HVAL/issues/HVAL-3?filter=allopenissues
        En los componentes embedables y mappedsuperclass el @NotNull no crea la restricción en BD
        Es necesario poner el @Column(nullable = false)
     */

    @NotNull
    @Column(nullable = false)
    protected String street;

    @NotNull
    @Column(nullable = false, length = 5)
    protected String zip;

    @NotNull
    @Column(nullable = false)
    protected String city;

    protected Address(){}

    public Address(String street, String zip, String city) {
        this.street = street;
        this.zip = zip;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
