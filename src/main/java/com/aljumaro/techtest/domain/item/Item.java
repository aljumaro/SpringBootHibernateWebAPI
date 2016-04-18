package com.aljumaro.techtest.domain.item;

import com.aljumaro.techtest.domain.base.BaseEntity;
import com.aljumaro.techtest.utilities.Constants;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    @DecimalMin("0.00")
    @Digits(
            integer = 10,
            fraction = 2
    )
    protected BigDecimal initialPrice;

    @NotNull
    @Enumerated(EnumType.STRING)
    protected AuctionType auctionType = AuctionType.HIGHEST_BID;

    protected Item(){}

    public void setName(String name) {
        this.name = !name.startsWith(Constants.ITEM_NAME)? Constants.ITEM_NAME + name: name;
    }

    public String getName() {
        return name;
    }

    public Date getAuctionEnd() {
        return auctionEnd;
    }

    public void setAuctionEnd(Date auctionEnd) {
        this.auctionEnd = auctionEnd;
    }

    public BigDecimal getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(BigDecimal initialPrice) {
        this.initialPrice = initialPrice;
    }

    public AuctionType getAuctionType() {
        return auctionType;
    }

    public void setAuctionType(AuctionType auctionType) {
        this.auctionType = auctionType;
    }
}
