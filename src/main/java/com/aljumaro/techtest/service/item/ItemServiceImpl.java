package com.aljumaro.techtest.service.item;

import com.aljumaro.techtest.domain.bid.Bid;
import com.aljumaro.techtest.domain.common.type.MonetaryAmount;
import com.aljumaro.techtest.domain.item.Item;
import com.aljumaro.techtest.domain.item.dto.ItemBidSummary;
import com.aljumaro.techtest.domain.item.dto.ItemSummary;
import com.aljumaro.techtest.persistence.item.ItemDAO;
import com.aljumaro.techtest.persistence.util.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.LockModeType;
import java.util.List;

/**
 * @Date 10/05/2016
 * @Time 19:45
 * @Author Juanma
 */
@Component
@Transactional
public class ItemServiceImpl implements ItemService {

    private ItemDAO itemDAO;

    @Autowired
    public void setItemDAO(ItemDAO itemDAO) {
        this.itemDAO = itemDAO;
    }

    @Override
    public List<Item> findAll(boolean withBids) {
        return itemDAO.findAll(withBids);
    }

    @Override
    public Long count() {
        return itemDAO.getCount();
    }

    @Override
    public List<ItemBidSummary> findItemBidSummaries() {
        return itemDAO.findItemBidSummaries();
    }

    @Override
    public List<ItemSummary> findItemSummary() {
        return itemDAO.findItemSummary();
    }

    @Override
    public Item save(Item item) {
        return itemDAO.makePersistent(item);
    }

    @Override
    public List<Item> findByName(String name, boolean substring) {
        return itemDAO.findByName(name, substring);
    }

    @Override
    public List<ItemSummary> getItemBidSummaries(Page page) {
        return itemDAO.getItemBidSummaries(page);
    }

    @Override
    public Item findById(Long id) {
        return itemDAO.findById(id);
    }

    @Override
    public Bid placeBid(Long itemId, String bidder, MonetaryAmount monetaryAmount) {
        Item item = itemDAO.findReferenceById(itemId);
        Bid bid = new Bid(monetaryAmount, bidder, item);
        item.getBids().add(bid);
        return bid;
    }
}
