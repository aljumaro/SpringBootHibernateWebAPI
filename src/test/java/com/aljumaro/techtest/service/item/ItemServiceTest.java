package com.aljumaro.techtest.service.item;

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
public class ItemServiceTest extends BaseServiceTest {

    private ItemService itemService;
    private EntityManager em;

    @Autowired
    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }

    @Autowired
    public void setEm(EntityManager entityManager){ this.em = entityManager; }

    @Test
    public void testSaveItem() {
        Item item = ItemBuilder.INSTANCE.mock();

        itemService.save(item);
    }

    @Test
    public void testSaveItemBids() {
        Item item = ItemBuilder.INSTANCE.mock();

        itemService.saveItemBids(item);
    }

    @Test
    public void testRemoveItem(){
        itemService.removeItem(4L);
    }

    @Test
    public void testCategoryItem(){
        itemService.setCategories();
    }
}
