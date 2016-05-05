package com.aljumaro.techtest.service.item;

import com.aljumaro.techtest.domain.bid.Bid;
import com.aljumaro.techtest.domain.common.type.MonetaryAmount;
import com.aljumaro.techtest.domain.item.Category;
import com.aljumaro.techtest.domain.item.Item;
import com.aljumaro.techtest.domain.item.ItemBuilder;
import com.aljumaro.techtest.domain.item.linkentity.CategorizedItem;
import com.aljumaro.techtest.persistence.item.ItemRepository;
import com.aljumaro.techtest.service.logging.EnvDependentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;
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
    private EnvDependentService logService;

    @Autowired
    private void setItemRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Autowired
    private void setEntityManager(EntityManager entityManager) {
        this.em = entityManager;
    }

    @Autowired
    private void setLogService(EnvDependentService logService) {
        this.logService = logService;
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
        em.persist(category1);
        em.persist(category2);

        Item item1 = ItemBuilder.INSTANCE.mock();
        Item item2 = ItemBuilder.INSTANCE.mock();
        em.persist(item1);
        em.persist(item2);

        CategorizedItem linkOne = new CategorizedItem(
                "test", category1, item1
        );

        em.persist(linkOne);

        CategorizedItem linkTwo = new CategorizedItem(
                "test", category1, item2
        );
        em.persist(linkTwo);

        CategorizedItem linkThree = new CategorizedItem(
                "test", category2, item1
        );
        em.persist(linkThree);

    }

    @Override
    public void queryTesting() {
        //BASIC JPQL-HQL
        Query query = em.createQuery("select i from Item i");
        List<Item> res = query.getResultList();

        res.forEach(item -> logService.log(String.format("Item %s has %d bids", item.getName(), item.getBids().size())));

        Assert.notEmpty(res, "There must be items in the DB");

        //BASIC CRITERIAQUERY
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Item> allItemsCQ = cb.createQuery(Item.class);
        allItemsCQ.select(allItemsCQ.from(Item.class));

        Query allItemsQuery = em.createQuery(allItemsCQ);

        List<Item> res1 = allItemsQuery.getResultList();

        res1.forEach(item -> logService.log(String.format("Item %s has %d bids", item.getName(), item.getBids().size())));

        Assert.notEmpty(res1, "There must be items in the DB also with CriteriaQuery");

        //PAREMETERED CRITERIAQUERY
        CriteriaQuery<Item> oneItemCQ = cb.createQuery(Item.class);
        Root<Item> oneItemCQRoot = oneItemCQ.from(Item.class);
        oneItemCQ
                .select(oneItemCQRoot)
                .where(cb.equal(
                        oneItemCQRoot.get("id"), 103));

        TypedQuery<Item> oneItemQuery = em.createQuery(oneItemCQ);

        Item item103 = oneItemQuery.getSingleResult();

        logService.log("Item103 #id: " + item103.getId());
        Assert.isTrue(item103.getId().equals(103L), "Item 103 must have id = 103");

        //PAGING CRITERIA QUERY
        CriteriaQuery<Item> pagingItemCQ = cb.createQuery(Item.class);
        Query pagingQuery = em.createQuery(pagingItemCQ.select(pagingItemCQ.from(Item.class)));

        List<Item> paginatedItems = pagingQuery.setFirstResult(1).setMaxResults(4).getResultList();
        paginatedItems.forEach(i -> logService.log("Item #id: " + i.getId()));

        Assert.isTrue(paginatedItems.size() == 4, "List must have 4 elements");
        Assert.isTrue(paginatedItems.get(0).getId().equals(2L), "First result must be #id 2");

        //NAMED QUERIES
        Query namedFindItems = em.createNamedQuery("findItems", Item.class);

        List<Item> namedRes = namedFindItems.getResultList();

        namedRes.forEach(item -> logService.log(String.format("Item %s has %d bids", item.getName(), item.getBids().size())));

        Assert.notEmpty(namedRes, "There must be items in the DB also with namedQueries");
    }

    @Override
    public void queryHints(){
        //HIBERNATE PROPIETARY XML HINTS
        Query namedFindItems = em.createNamedQuery("findItemsOrderByAuctionEnd", Item.class);

        List<Item> namedRes = namedFindItems.getResultList();

        namedRes.forEach(item -> logService.log(String.format("Item %s has %d bids", item.getName(), item.getBids().size())));

        Assert.notEmpty(namedRes, "There must be items in the DB also with namedQueries");
    }
}
