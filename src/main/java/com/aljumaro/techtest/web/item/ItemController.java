package com.aljumaro.techtest.web.item;

import com.aljumaro.techtest.domain.bid.Bid;
import com.aljumaro.techtest.domain.common.type.MonetaryAmount;
import com.aljumaro.techtest.domain.item.Item;
import com.aljumaro.techtest.domain.item.dto.ItemBidSummary;
import com.aljumaro.techtest.domain.item.dto.ItemSummary;
import com.aljumaro.techtest.service.item.ItemService;
import com.aljumaro.techtest.web.exception.WebAPIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Date 21/05/2016
 * @Time 10:38
 * @Author Juanma
 */
@RestController
@RequestMapping("/item")
public class ItemController {

    private ItemService itemService;

    @Autowired
    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }

    @RequestMapping
    public List<ItemSummary> find(){
        return itemService.findItemSummary();
    }

    @RequestMapping("/{id}")
    public Item get(@PathVariable("id") Long id){
        Item item = itemService.findById(id);
        if (item == null) {
            throw new WebAPIException(HttpStatus.NOT_FOUND);
        }
        return item;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void save(@RequestBody Item item) {
        if (item == null) {
            throw new WebAPIException(HttpStatus.BAD_REQUEST);
        }
        itemService.save(item);
    }

    @RequestMapping(value = "/{id}/bid", method = RequestMethod.POST)
    public Bid save(@PathVariable("id") Long id, @RequestBody MonetaryAmount monetaryAmount) {
        if (monetaryAmount == null) {
            throw new WebAPIException(HttpStatus.BAD_REQUEST);
        }
        Bid bid = itemService.placeBid(id, "requestUser", monetaryAmount);
        return bid;
    }

}
