package com.aljumaro.techtest.domain.common.converter;

import com.aljumaro.techtest.domain.common.type.MonetaryAmount;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @Date 21/04/2016
 * @Time 20:59
 * @Author Juanma
 */
@Converter(autoApply = true)
public class MonetaryAmountConverter implements AttributeConverter<MonetaryAmount, String> {

    @Override
    public String convertToDatabaseColumn(MonetaryAmount monetaryAmount) {
        return monetaryAmount.toString();
    }

    @Override
    public MonetaryAmount convertToEntityAttribute(String string) {
        return MonetaryAmount.fromString(string);
    }
}
