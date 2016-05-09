package com.aljumaro.techtest.service.query;

import com.aljumaro.techtest.domain.item.Item;
import com.aljumaro.techtest.domain.item.ItemBuilder;
import com.aljumaro.techtest.service.base.BaseServiceTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

/**
 * @Date 16/04/2016
 * @Time 16:56
 * @Author Juanma
 */
public class QueryTestServiceTest extends BaseServiceTest {

    private QueryTestService queryTestService;
    private EntityManager em;

    @Autowired
    public void setQueryTestService(QueryTestService queryTestService) {
        this.queryTestService = queryTestService;
    }

    @Autowired
    public void setEm(EntityManager entityManager){ this.em = entityManager; }

    @Test
    public void testSaveItem() {
        Item item = ItemBuilder.INSTANCE.mock();

        queryTestService.save(item);
    }

    @Test
    public void testSaveItemBids() {
        Item item = ItemBuilder.INSTANCE.mock();

        queryTestService.saveItemBids(item);
    }

    @Test
    public void testRemoveItem(){
        queryTestService.removeItem(4L);
    }

    @Test
    public void testCategoryItem(){
        queryTestService.setCategories();
    }

    @Test
    public void queryTest() {
        queryTestService.queryTesting();
    }

    @Test
    public void queryHintsTest() { queryTestService.queryHints(); }
}
