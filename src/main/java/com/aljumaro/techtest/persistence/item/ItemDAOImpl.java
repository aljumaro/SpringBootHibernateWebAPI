package com.aljumaro.techtest.persistence.item;

import com.aljumaro.techtest.domain.item.Item;
import com.aljumaro.techtest.domain.item.dto.ItemBidSummary;
import com.aljumaro.techtest.domain.item.dto.ItemSummary;
import com.aljumaro.techtest.persistence.base.GenericDAO;
import com.aljumaro.techtest.persistence.base.GenericDAOImpl;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @Date 09/05/2016
 * @Time 21:18
 * @Author Juanma
 */
@Component
public class ItemDAOImpl extends GenericDAOImpl<Item, Long> implements ItemDAO {

    public ItemDAOImpl(){
        super(Item.class);
    }

    @Override
    public List<Item> findAll(boolean withBids) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Item> cq = cb.createQuery(entityClass);
        Root<Item> i = cq.from(entityClass);
        cq.select(i).distinct(true).orderBy(cb.asc(i.get("auctionEnd")));

        if (withBids) {
            i.fetch("bids", JoinType.LEFT);
        }

        return em.createQuery(cq).getResultList();
    }

    @Override
    public List<Item> findByName(String name, boolean substring) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Item> cq = cb.createQuery(entityClass);
        Root<Item> i = cq.from(entityClass);

        if (substring) {
            cq.select(i).where(cb.like(i.<String>get("name"), String.format(GenericDAO.LIKE, name)));
        } else {
            cq.select(i).where(cb.equal(i.<String>get("name"), name));
        }

        return em.createQuery(cq).getResultList();
    }

    @Override
    public List<ItemBidSummary> findItemBidSummaries() {
        CriteriaQuery<ItemBidSummary> cq = em.getCriteriaBuilder().createQuery(ItemBidSummary.class);
        Root<ItemBidSummary> i = cq.from(ItemBidSummary.class);
        cq.select(i);

        return em.createQuery(cq).getResultList();
    }

    @Override
    public List<ItemSummary> findItemSummary() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<ItemSummary> cq = cb.createQuery(ItemSummary.class);
        Root<Item> i = cq.from(entityClass);
        cq.select(
                cb.construct(
                        ItemSummary.class,
                        i.get("id"), i.get("name"), i.get("auctionEnd")
                )
        );

        return em.createQuery(cq).getResultList();
    }
}
