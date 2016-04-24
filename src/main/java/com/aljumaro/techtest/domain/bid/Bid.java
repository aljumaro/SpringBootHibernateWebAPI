package com.aljumaro.techtest.domain.bid;

import com.aljumaro.techtest.domain.base.BaseEntity;
import com.aljumaro.techtest.domain.common.type.MonetaryAmount;
import com.aljumaro.techtest.domain.item.Item;
import com.aljumaro.techtest.utilities.Constants;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @Date 16/04/2016
 * @Time 15:38
 * @Author Juanma
 */
@Entity
@org.hibernate.annotations.Immutable
public class Bid extends BaseEntity {

    @NotNull
    @org.hibernate.annotations.Type(
            type = Constants.MONETARY_AMOUNT_EUR_TYPE
    )
    @org.hibernate.annotations.Columns(
            columns = {
                    @Column(name = "BID_AMOUNT"),
                    @Column(name = "BID_CURRENCTY", length = 3)
            }
    )
    protected MonetaryAmount monetaryAmount;

    @NotNull
    protected String bidder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM_ID", nullable = false) //defaults
    protected Item item;

    protected Bid(){}

    public Bid(MonetaryAmount monetaryAmount, String bidder, Item item) {
        this.monetaryAmount = monetaryAmount;
        this.bidder = bidder;
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public MonetaryAmount getMonetaryAmount() {
        return monetaryAmount;
    }

    public void setMonetaryAmount(MonetaryAmount monetaryAmount) {
        this.monetaryAmount = monetaryAmount;
    }

    public String getBidder() {
        return bidder;
    }

    public void setBidder(String bidder) {
        this.bidder = bidder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bid bid = (Bid) o;

        if (!monetaryAmount.equals(bid.monetaryAmount)) return false;
        return bidder.equals(bid.bidder);

    }

    @Override
    public int hashCode() {
        int result = monetaryAmount.hashCode();
        result = 31 * result + bidder.hashCode();
        return result;
    }
}
