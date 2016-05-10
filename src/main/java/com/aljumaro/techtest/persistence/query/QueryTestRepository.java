package com.aljumaro.techtest.persistence.query;

import com.aljumaro.techtest.domain.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Date 16/04/2016
 * @Time 16:54
 * @Author Juanma
 */
public interface QueryTestRepository extends JpaRepository<Item, Long> {
}
