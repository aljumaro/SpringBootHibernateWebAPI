@org.hibernate.annotations.TypeDefs({
        @org.hibernate.annotations.TypeDef(
                name = Constants.MONETARY_AMOUNT_USD_TYPE,
                typeClass = MonetaryAmountUserType.class,
                parameters = {@Parameter(name = Constants.CONVERT_TO_PARAMETER, value = Constants.USD)}
        ),

        @org.hibernate.annotations.TypeDef(
                name = Constants.MONETARY_AMOUNT_EUR_TYPE,
                typeClass = MonetaryAmountUserType.class,
                parameters = {@Parameter(name = Constants.CONVERT_TO_PARAMETER, value = Constants.EUR)}
        )
})
/**
 * @Date 21/04/2016
 * @Time 23:34
 * @Author Juanma
 */
package com.aljumaro.techtest.domain.common.converter;

import com.aljumaro.techtest.domain.common.type.MonetaryAmountUserType;
import com.aljumaro.techtest.utilities.Constants;
import org.hibernate.annotations.Parameter;