package com.aljumaro.techtest.service.item;

import com.aljumaro.techtest.domain.item.Item;
import com.aljumaro.techtest.domain.item.dto.ItemBidSummary;
import com.aljumaro.techtest.domain.item.dto.ItemSummary;

import java.util.List;

/**
 * @Date 10/05/2016
 * @Time 19:44
 * @Author Juanma
 */
public interface ItemService {

    List<Item> findAll(boolean withBids);

    Long count();

    List<ItemBidSummary> findItemBidSummaries();

    List<ItemSummary> findItemSummary();

    Item save(Item mock);

    List<Item> findByName(String name, boolean substring);
}
