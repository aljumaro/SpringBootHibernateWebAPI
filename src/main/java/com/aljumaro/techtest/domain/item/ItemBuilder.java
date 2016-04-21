package com.aljumaro.techtest.domain.item;

import com.aljumaro.techtest.domain.common.type.MonetaryAmount;
import com.aljumaro.techtest.utilities.Constants;
import com.aljumaro.techtest.utilities.NumberUtils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.Currency;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * @Date 16/04/2016
 * @Time 16:25
 * @Author Juanma
 */
public class ItemBuilder {

    public static final ItemBuilder INSTANCE = new ItemBuilder();

    private String name;
    private Date auctionEnd;
    private MonetaryAmount initialPrice;
    private MonetaryAmount buyNowPrice;
    private AuctionType auctionType;

    private ItemBuilder(){}

    public ItemBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public ItemBuilder withAuctionEnd(Date auctionEnd) {
        this.auctionEnd = auctionEnd;
        return this;
    }

    public ItemBuilder withInitialPrice(MonetaryAmount initialPrice) {
        this.initialPrice = initialPrice;
        return this;
    }

    public ItemBuilder withBuyNowPrice(MonetaryAmount buyNowPrice) {
        this.buyNowPrice = buyNowPrice;
        return this;
    }

    public ItemBuilder withAuctionType(AuctionType auctionType){
        this.auctionType = auctionType;
        return this;
    }

    public Item build() {
        Item res = new Item();
        res.auctionEnd = this.auctionEnd;
        res.initialPrice = this.initialPrice;
        res.buyNowPrice = this.buyNowPrice;
        res.name = this.name;
        res.auctionType = this.auctionType;
        return res;
    }

    public Item mock(){
        Item res = new Item();
        res.auctionEnd = Date.from(LocalDateTime.now().plus(1, ChronoUnit.MONTHS).toInstant(ZoneOffset.UTC));
        res.initialPrice = new MonetaryAmount(
                NumberUtils.getRandomBigDecimal(new Random(), 0, 1000, 2), Currency.getInstance(Constants.USD));
        res.buyNowPrice = new MonetaryAmount(
                NumberUtils.getRandomBigDecimal(new Random(), 0, 1000, 2), Currency.getInstance(Constants.EUR));
        res.name = UUID.randomUUID().toString();
        res.auctionType = AuctionType.HIGHEST_BID;

        return res;
    }
}
