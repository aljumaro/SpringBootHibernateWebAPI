package com.aljumaro.techtest.domain.item;

import com.aljumaro.techtest.domain.base.BaseEntity;
import com.aljumaro.techtest.domain.bid.Bid;
import com.aljumaro.techtest.domain.common.embeddable.Image;
import com.aljumaro.techtest.domain.common.embeddable.measure.Dimensions;
import com.aljumaro.techtest.domain.common.embeddable.measure.Weight;
import com.aljumaro.techtest.domain.common.type.MonetaryAmount;
import com.aljumaro.techtest.domain.user.User;
import com.aljumaro.techtest.utilities.Constants;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.*;

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

    @ElementCollection
    @CollectionTable(name = "IMAGE")
    @org.hibernate.annotations.CollectionId(
            columns = @Column(name = "IMAGE_ID"),
            type = @org.hibernate.annotations.Type(type = "long"),
            generator = Constants.ID_GENERATOR
    )
    protected Collection<Image> images = new ArrayList<Image>();

    @OneToMany(
            mappedBy = "item",
            fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.REMOVE})
    protected Set<Bid> bids = new HashSet<Bid>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(
            name = "ITEM_BUYER",
            joinColumns = @JoinColumn(name = "ITEM_ID"),
            inverseJoinColumns = @JoinColumn(nullable = false))
    protected User buyer;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "CATEGORY_ITEM",
            joinColumns = @JoinColumn(name = "ITEM_ID"),
            inverseJoinColumns = @JoinColumn(name = "CATEGORY_ID"))
    protected Set<Category> categories = new HashSet<Category>();

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

    public Collection<Image> getImages() {
        return images;
    }

    public void setImages(Collection<Image> images) {
        this.images = images;
    }

    public Set<Bid> getBids() {
        return bids;
    }

    public void setBids(Set<Bid> bids) {
        this.bids = bids;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
