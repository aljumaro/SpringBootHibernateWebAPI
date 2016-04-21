package com.aljumaro.techtest.domain.common.type;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Currency;

/**
 * @Date 21/04/2016
 * @Time 20:51
 * @Author Juanma
 */
public class MonetaryAmount implements Serializable {

    private static final String SEPARATOR = " ";
    protected final BigDecimal value;
    protected final Currency currency;

    public MonetaryAmount(BigDecimal value, Currency currency) {
        this.value = value;
        this.currency = currency;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Currency getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MonetaryAmount that = (MonetaryAmount) o;

        if (!value.equals(that.value)) return false;
        return currency.equals(that.currency);

    }

    @Override
    public int hashCode() {
        int result = value.hashCode();
        result = 31 * result + currency.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return new StringBuffer()
                .append(getValue())
                .append(SEPARATOR)
                .append(getCurrency())
                .toString();
    }

    public static MonetaryAmount fromString(String s) {
        String[] split = s.split(SEPARATOR);

        return new MonetaryAmount(
                new BigDecimal(split[0]),
                Currency.getInstance(split[1]));
    }
}
