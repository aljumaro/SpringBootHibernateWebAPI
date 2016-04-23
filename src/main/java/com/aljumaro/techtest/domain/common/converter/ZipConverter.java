package com.aljumaro.techtest.domain.common.converter;

import com.aljumaro.techtest.domain.common.type.zip.GermanZip;
import com.aljumaro.techtest.domain.common.type.zip.SwissZip;
import com.aljumaro.techtest.domain.common.type.zip.Zip;

import javax.persistence.AttributeConverter;

/**
 * Zip converter class.
 *
 * @date 21/04/2016
 * @author  Juanma
 * @since   1.0
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
