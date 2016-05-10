package com.aljumaro.techtest.domain.item.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Date 09/05/2016
 * @Time 21:30
 * @Author Juanma
 */
@Entity
@org.hibernate.annotations.Immutable
@org.hibernate.annotations.Subselect(
        value = "select i.ID as ITEMID, i.NAME as NAME, count(b.ID) as NUMBEROFBIDS " +
                "from ce_ITEM i left outer join ce_BID b on i.id = b.item_id " +
                "group by i.ID, i.NAME"
)
@org.hibernate.annotations.Synchronize({"CE_ITEM", "CE_BID"})
public class ItemBidSummary {

    @Id
    protected Long itemId;

    protected String name;

    protected long numberOfBids;

    public ItemBidSummary(){}

    public ItemBidSummary(Long itemId, String name, long numberOfBids) {
        this.itemId = itemId;
        this.name = name;
        this.numberOfBids = numberOfBids;
    }

    public Long getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public long getNumberOfBids() {
        return numberOfBids;
    }
}
