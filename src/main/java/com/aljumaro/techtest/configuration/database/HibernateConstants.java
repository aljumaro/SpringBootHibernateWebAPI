package com.aljumaro.techtest.configuration.database;

/**
 * @Date 16/04/2016
 * @Time 15:19
 * @Author Juanma
 */
public interface HibernateConstants {

    //Database
    String DATABASE_PLATFORM = "org.hibernate.dialect.MySQL57InnoDBDialect";

    //Annotation and xml configuration
    String PACKAGE_TO_SCAN = "com.aljumaro.techtest";
    String ITEM_ENTITY_MAPPINGS = "/queries/ItemEntityMappings.xml";
    String ITEM_HIBERNATE_MAPPINGS = "/queries/ItemHibernateMappings.hbm.xml";
}
