package com.aljumaro.techtest.domain.common.type.zip;

/**
 * @Date 21/04/2016
 * @Time 21:06
 * @Author Juanma
 */
public abstract class Zip {

    protected String value;

    public Zip(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Zip zip = (Zip) o;

        return value.equals(zip.value);

    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
