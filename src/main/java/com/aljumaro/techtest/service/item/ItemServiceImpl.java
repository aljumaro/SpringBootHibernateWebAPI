package com.aljumaro.techtest.service.item;

import com.aljumaro.techtest.domain.item.Item;
import com.aljumaro.techtest.persistence.item.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Date 16/04/2016
 * @Time 16:55
 * @Author Juanma
 */
@Component
public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;

    @Autowired
    private void setItemRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void save(Item item) {
        itemRepository.save(item);
    }
}
