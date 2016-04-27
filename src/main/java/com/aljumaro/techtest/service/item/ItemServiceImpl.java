package com.aljumaro.techtest.service.item;

import com.aljumaro.techtest.domain.bid.Bid;
import com.aljumaro.techtest.domain.common.type.MonetaryAmount;
import com.aljumaro.techtest.domain.item.Category;
import com.aljumaro.techtest.domain.item.Item;
import com.aljumaro.techtest.domain.item.ItemBuilder;
import com.aljumaro.techtest.persistence.item.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

/**
 * @Date 16/04/2016
 * @Time 16:55
 * @Author Juanma
 */
@Component
@Transactional
public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;
    private EntityManager em;

    @Autowired
    private void setItemRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Autowired
    private void setEntityManager(EntityManager entityManager) {
        this.em = entityManager;
    }

    @Override
    public void save(Item item) {
        itemRepository.save(item);
    }

    @Override
    public void saveItemBids(Item item) {
        Long id = item.getId();

        itemRepository.save(item);

        for (int i = 0; i < 100; i++) {
            MonetaryAmount ma = new MonetaryAmount(new BigDecimal(i), Currency.getInstance(Locale.getDefault()));

            Bid bid1 = new Bid(ma, "bidder" + i, item);
            item.getBids().add(bid1);
        }

    }

    @Override
    public void removeItem(Long id) {
        Item item = em.find(Item.class, id);
        em.remove(item);
    }

    @Override
    public void setCategories() {
        Category category1 = new Category("Cat 1");
        Category category2 = new Category("Cat 2");

        Item item1 = ItemBuilder.INSTANCE.mock();
        Item item2 = ItemBuilder.INSTANCE.mock();

        category1.getItems().add(item1);
        item1.getCategories().add(category1);

        category2.getItems().add(item2);
        item2.getCategories().add(category2);

        category1.getItems().add(item2);
        item2.getCategories().add(category1);

        em.persist(item1);
        em.persist(item2);

    }
}
