package com.aljumaro.techtest.service.query;

import com.aljumaro.techtest.domain.item.Item;

/**
 * @Date 16/04/2016
 * @Time 16:55
 * @Author Juanma
 */
public interface QueryTestService {

    void save(Item item);

    void saveItemBids(Item item);

    void removeItem(Long id);

    void setCategories();

    void queryTesting();

    void queryHints();
}
