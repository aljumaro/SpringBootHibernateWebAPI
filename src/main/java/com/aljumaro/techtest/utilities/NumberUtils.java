package com.aljumaro.techtest.utilities;

import java.math.BigDecimal;
import java.util.Random;

/**
 * @Date 16/04/2016
 * @Time 17:04
 * @Author Juanma
 */
public class NumberUtils {

    public static BigDecimal getRandomBigDecimal(final Random random,
                                                 final int lowerBound,
                                                 final int upperBound,
                                                 final int decimalPlaces){

        if(lowerBound < 0 || upperBound <= lowerBound || decimalPlaces < 0){
            throw new IllegalArgumentException("parameter must be: lB >= 0; uB > lB; dP > 0");
        }

        final double dbl =
                ((random == null ? new Random() : random).nextDouble() //
                        * (upperBound - lowerBound))
                        + lowerBound;
        return new BigDecimal(dbl).setScale(decimalPlaces, BigDecimal.ROUND_HALF_EVEN);
    }
}
