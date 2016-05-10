package com.aljumaro.techtest.domain.item.dto;

import java.util.Date;

/**
 * @Date 09/05/2016
 * @Time 21:59
 * @Author Juanma
 */
public class ItemSummary {

    private Long itemId;
    private String name;
    private Date auctionEnd;

    public ItemSummary(Long itemId, String name, Date auctionEnd) {
        this.itemId = itemId;
        this.name = name;
        this.auctionEnd = auctionEnd;
    }

    public Long getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public Date getAuctionEnd() {
        return auctionEnd;
    }
}
