package com.aljumaro.techtest.persistence.item;

import com.aljumaro.techtest.domain.item.Item;
import com.aljumaro.techtest.persistence.base.GenericDAO;
import com.aljumaro.techtest.persistence.base.GenericDAOImpl;

/**
 * @Date 09/05/2016
 * @Time 21:18
 * @Author Juanma
 */
public class ItemDAOImpl extends GenericDAOImpl<Item, Long> implements ItemDAO {

    public ItemDAOImpl(){
        super(Item.class);
    }
}
