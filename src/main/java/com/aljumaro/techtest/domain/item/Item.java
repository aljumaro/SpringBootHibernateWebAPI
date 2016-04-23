package com.aljumaro.techtest.domain.item;

import com.aljumaro.techtest.domain.base.BaseEntity;
import com.aljumaro.techtest.domain.common.embeddable.measures.Dimensions;
import com.aljumaro.techtest.domain.common.embeddable.measures.Weight;
import com.aljumaro.techtest.domain.common.type.MonetaryAmount;
import com.aljumaro.techtest.utilities.Constants;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

/**
 * @Date 16/04/2016
 * @Time 15:38
 * @Author Juanma
 */
@Entity
public class Item extends BaseEntity {

    @NotNull
    @Size(
            min = 2,
            max = 255,
            message = "validation.error.item.name"
    )
    @Access(AccessType.PROPERTY)
    protected String name;

    @NotNull
    @Future
    protected Date auctionEnd;

    @NotNull
    @Enumerated(EnumType.STRING)
    protected AuctionType auctionType = AuctionType.HIGHEST_BID;

    @NotNull
    @org.hibernate.annotations.Type(
            type = Constants.MONETARY_AMOUNT_USD_TYPE
    )
    @org.hibernate.annotations.Columns(
            columns = {
                    @Column(name = "BUYNOWPRICE_AMOUNT"),
                    @Column(name = "BUYNOWPRICE_CURRENCTY", length = 3)
            }
    )
    protected MonetaryAmount buyNowPrice;

    @NotNull
    @org.hibernate.annotations.Type(
            type = Constants.MONETARY_AMOUNT_EUR_TYPE
    )
    @org.hibernate.annotations.Columns(
            columns = {
                    @Column(name = "INITIALPRICE_AMOUNT"),
                    @Column(name = "INITIALPRICE_CURRENCTY", length = 3)
            }
    )
    protected MonetaryAmount initialPrice;

    protected Dimensions dimensions;

    protected Weight weight;

    protected Item(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getAuctionEnd() {
        return auctionEnd;
    }

    public void setAuctionEnd(Date auctionEnd) {
        this.auctionEnd = auctionEnd;
    }

    public AuctionType getAuctionType() {
        return auctionType;
    }

    public void setAuctionType(AuctionType auctionType) {
        this.auctionType = auctionType;
    }

    public MonetaryAmount getBuyNowPrice() {
        return buyNowPrice;
    }

    public void setBuyNowPrice(MonetaryAmount buyNowPrice) {
        this.buyNowPrice = buyNowPrice;
    }

    public MonetaryAmount getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(MonetaryAmount initialPrice) {
        this.initialPrice = initialPrice;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    public Weight getWeight() {
        return weight;
    }

    public void setWeight(Weight weight) {
        this.weight = weight;
    }
}
