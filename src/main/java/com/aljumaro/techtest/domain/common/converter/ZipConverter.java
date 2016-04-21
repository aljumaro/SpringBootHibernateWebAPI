package com.aljumaro.techtest.domain.common.converter;

import com.aljumaro.techtest.domain.common.type.zip.GermanZip;
import com.aljumaro.techtest.domain.common.type.zip.SwissZip;
import com.aljumaro.techtest.domain.common.type.zip.Zip;

import javax.persistence.AttributeConverter;

/**
 * @Date 21/04/2016
 * @Time 22:58
 * @Author Juanma
 */
public class ZipConverter implements AttributeConverter<Zip, String> {

    @Override
    public String convertToDatabaseColumn(Zip zip) {
        return zip.getValue();
    }

    @Override
    public Zip convertToEntityAttribute(String s) {
        switch (s.length()){
            case 5: return new GermanZip(s);
            case 4: return new SwissZip(s);
        }

        throw new IllegalArgumentException("Unsupported zip code " + s);
    }
}
