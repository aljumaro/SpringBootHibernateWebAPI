package com.aljumaro.techtest.persistence.item;

import com.aljumaro.techtest.domain.item.Item;
import com.aljumaro.techtest.domain.item.dto.ItemBidSummary;
import com.aljumaro.techtest.domain.item.dto.ItemSummary;
import com.aljumaro.techtest.persistence.base.GenericDAO;
import com.aljumaro.techtest.persistence.base.GenericDAOImpl;
import com.aljumaro.techtest.persistence.util.pagination.Page;

import java.util.List;

/**
 * @Date 09/05/2016
 * @Time 21:17
 * @Author Juanma
 */
public interface ItemDAO extends GenericDAO<Item, Long> {

    List<Item> findAll(boolean withBids);

    List<Item> findByName(String name, boolean substring);

    List<ItemBidSummary> findItemBidSummaries();

    List<ItemSummary> findItemSummary();

    List<ItemSummary> getItemBidSummaries(Page page);
}
