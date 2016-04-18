package com.aljumaro.techtest.configuration.database;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

/**
 * @Date 16/04/2016
 * @Time 14:04
 * @Author Juanma
 */
public class CENamingStrategy extends PhysicalNamingStrategyStandardImpl{

    private static final String TABLE_NAME = "CE_%s";

    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
        return (name != null) ? new Identifier(String.format(TABLE_NAME, name), name.isQuoted()): null;
    }
}
