@org.hibernate.annotations.GenericGenerator(
        name = Constants.ID_GENERATOR,
        strategy = "enhanced-sequence",
        parameters = {
                @org.hibernate.annotations.Parameter(
                        name = "sequence_name",
                        value = "SEQUENCE"
                )
        }
)
/**
 * @Date 16/04/2016
 * @Time 15:49
 * @Author Juanma
 */
package com.aljumaro.techtest.domain;

import com.aljumaro.techtest.utilities.Constants;