package com.aljumaro.techtest.domain.billing;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @Date 23/04/2016
 * @Time 8:58
 * @Author Juanma
 */
@Entity
@DiscriminatorValue("CC")
public class CreditCard extends BillingDetails{

    @NotNull
    @Size(min = 8, max = 4)
    protected String cardNumber;

    @NotNull
    @Size(min = 2, max = 2)
    protected String expMonth;

    @NotNull
    @Size(min = 4, max = 4)
    protected String expYear;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpMonth() {
        return expMonth;
    }

    public void setExpMonth(String expMonth) {
        this.expMonth = expMonth;
    }

    public String getExpYear() {
        return expYear;
    }

    public void setExpYear(String expYear) {
        this.expYear = expYear;
    }
}
