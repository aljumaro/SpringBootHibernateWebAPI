package com.aljumaro.techtest.configuration.database;

/**
 * @Date 16/04/2016
 * @Time 15:19
 * @Author Juanma
 */
public interface HibernateProperties {

    String PHYSICAL_NAMING_STRATEGY = "hibernate.physical_naming_strategy";
    String PHYSICAL_NAMING_STRATEGY_VALUE = "com.aljumaro.techtest.configuration.database.CENamingStrategy";

    String HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";
    String HBM2DDL_AUTO_VALUE = "update";

}
