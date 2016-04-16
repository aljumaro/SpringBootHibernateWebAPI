package com.aljumaro.techtest.domain.item;

import com.aljumaro.techtest.domain.base.BaseEntity;

import javax.persistence.Entity;
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

    protected Item(){}

}
