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
    private Category category;

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

    public ItemBuilder withCategory(Category category) {
        this.category = category;
        return this;
    }

    public Item build() {
        Item res = new Item();
        res.auctionEnd = this.auctionEnd;
        res.initialPrice = this.initialPrice;
        res.name = this.name;
        //res.category = this.category;

        return res;
    }

    public Item mock(){
        Item res = new Item();
        res.auctionEnd = Date.from(LocalDateTime.now().plus(1, ChronoUnit.MONTHS).toInstant(ZoneOffset.UTC));
        res.initialPrice = new MonetaryAmount(
                NumberUtils.getRandomBigDecimal(new Random(), 0, 1000, 2), Currency.getInstance(Constants.USD));
        res.name = UUID.randomUUID().toString();
        //res.category = new Category();

        return res;
    }
}
