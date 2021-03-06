package com.aljumaro.techtest.service.item;

import com.aljumaro.techtest.domain.item.Item;
import com.aljumaro.techtest.domain.item.ItemBuilder;
import com.aljumaro.techtest.domain.item.dto.ItemBidSummary;
import com.aljumaro.techtest.domain.item.dto.ItemSummary;
import com.aljumaro.techtest.domain.item.Item_;
import com.aljumaro.techtest.persistence.util.pagination.OffsetPage;
import com.aljumaro.techtest.persistence.util.pagination.Page;
import com.aljumaro.techtest.persistence.util.pagination.SeekPage;
import com.aljumaro.techtest.service.base.BaseServiceTest;
import org.hibernate.LazyInitializationException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Date 10/05/2016
 * @Time 19:42
 * @Author Juanma
 */
public class ItemServiceTest extends BaseServiceTest {

    private static final Logger LOG = LoggerFactory.getLogger(ItemServiceTest.class);

    private ItemService itemService;

    @Autowired
    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testFindAllWithNoBids() {
        thrown.expect(LazyInitializationException.class);

        List<Item> items = itemService.findAll(false);

        items.forEach(i -> Assert.assertTrue("Bids must not be present", i.getBids().size() == 0));
    }

    @Test
    public void testFindAllWithBids() {
        List<Item> items = itemService.findAll(true);
        Long count = itemService.count();

        Assert.assertTrue(String.format("List must be %d size instead is %d size", count, items.size()), count.intValue() == items.size());
    }

    @Test
    public void testFindItemBidSummary() {
        List<ItemBidSummary> items = itemService.findItemBidSummaries();
        Long count = itemService.count();

        Assert.assertTrue(String.format("List must be %d size instead is %d size", count, items.size()), count.intValue() == items.size());
        items.forEach(item -> Assert.assertTrue("Result mus be of type ItemBidSummary", ItemBidSummary.class.isAssignableFrom(item.getClass())));
    }

    @Test
    public void testFindItemSummary() {
        List<ItemSummary> items = itemService.findItemSummary();
        Long count = itemService.count();

        Assert.assertTrue(String.format("List must be %d size instead is %d size", count, items.size()), count.intValue() == items.size());
        items.forEach(item -> Assert.assertTrue("Result mus be of type ItemBidSummary", ItemSummary.class.isAssignableFrom(item.getClass())));
    }

    @Test
    public void testFindByName() {
        String name = "Test Name";
        Item mock = createMockItem(name);

        Item saved = itemService.save(mock);

        List<Item> queryResult = itemService.findByName(name, false);

        boolean exists = itemExists(name, false, queryResult);

        Assert.assertTrue("Item must exist", exists);
    }

    @Test
    public void testFindByNameSubString() {
        String name = "Other name";
        String sub = "ther";
        Item mock = createMockItem(name);

        Item saved = itemService.save(mock);

        List<Item> queryResult = itemService.findByName(sub, true);

        boolean exists = itemExists(sub, true, queryResult);

        Assert.assertTrue("Item must exist", exists);
    }

    @Test
    public void testGetItemBidSummariesOffsetPage() {
        int size = 10;
        Long count = itemService.count();
        getItemSummariesOrderByNameAscendant(size, new OffsetPage(size, count, Item_.name, Page.SortDirection.ASC, Item_.name, Item_.auctionEnd));
    }

    @Test
    public void testGetItemBidSummariesSeekPage() {
        int size = 2;
        Long count = itemService.count();
        SeekPage page = new SeekPage(size, count, Item_.name, Page.SortDirection.ASC, Item_.id, Item_.name, Item_.auctionEnd);

        List<ItemSummary> res = getItemSummariesOrderByNameAscendant(size, page);

        ItemSummary lastItemSummary = res.get(res.size() - 1);
        page.setLastValue(lastItemSummary.getName());
        page.setLastUniqueValue(lastItemSummary.getItemId());

        getItemSummariesOrderByNameAscendant(size, page);
    }

    private List<ItemSummary> getItemSummariesOrderByNameAscendant(int size, Page page) {
        Long count = itemService.count();

        List<ItemSummary> res = itemService.getItemBidSummaries(page);

        Assert.assertTrue(String.format("Result list must be %d size", size), size > count.intValue() ? res.size() == count.intValue() : res.size() == size);
        for (int i = 0; i < res.size(); i+=2) {
            String name1 = res.get(i).getName();
            String name2 = res.get(i + 1).getName();

            Assert.assertTrue("The list must be ordered by name ascendant", name1.compareTo(name2) == -1);
        }

        return res;
    }

    private Item createMockItem(String name) {
        Item mock = ItemBuilder.INSTANCE.mock();
        mock.setName(name);
        return mock;
    }

    private boolean itemExists(String name, boolean substring, List<Item> queryResult) {
        boolean exists = false;
        for (Item i : queryResult) {
            if (substring) {
                exists |= i.getName().contains(name);
            } else {
                exists |= i.getName().equalsIgnoreCase(name);
            }
        }
        return exists;
    }

}
