package com.aljumaro.techtest.domain.base;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 * @Date 20/05/2016
 * @Time 20:28
 * @Author Juanma
 */
@StaticMetamodel(BaseEntity.class)
public class BaseEntity_ {

    public static volatile SingularAttribute<BaseEntity, Long> id;
}
