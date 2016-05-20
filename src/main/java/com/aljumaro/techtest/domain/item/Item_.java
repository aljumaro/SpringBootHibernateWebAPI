package com.aljumaro.techtest.domain.item;

import com.aljumaro.techtest.domain.base.BaseEntity_;
import com.aljumaro.techtest.domain.item.Item;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

/**
 * @Date 20/05/2016
 * @Time 19:33
 * @Author Juanma
 */
@StaticMetamodel(Item.class)
public class Item_ extends BaseEntity_{

    public static volatile SingularAttribute<Item, String> name;
    public static volatile SingularAttribute<Item, Date> auctionEnd;
}
