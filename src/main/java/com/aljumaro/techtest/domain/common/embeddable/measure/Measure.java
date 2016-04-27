package com.aljumaro.techtest.domain.common.embeddable.measure;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

/**
 * @Date 23/04/2016
 * @Time 9:19
 * @Author Juanma
 */
@MappedSuperclass
public abstract class Measure {

    @NotNull
    protected String name;

    @NotNull
    protected String symbol;
}
