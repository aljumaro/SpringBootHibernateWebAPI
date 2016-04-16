package com.aljumaro.techtest.domain.item;

import com.aljumaro.techtest.utilities.NumberUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
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
    private BigDecimal initialPrice;
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

    public ItemBuilder withInitialPrice(BigDecimal initialPrice) {
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
        res.initialPrice = NumberUtils.getRandomDouble(new Random(), 0, 1000, 2);
        res.name = UUID.randomUUID().toString();
        //res.category = new Category();

        return res;
    }
}
