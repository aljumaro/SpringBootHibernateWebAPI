package com.aljumaro.techtest.domain.common.embeddable.measures;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @Date 23/04/2016
 * @Time 9:22
 * @Author Juanma
 */
@Embeddable
@AttributeOverrides({
        @AttributeOverride(name = "name",
                column = @Column(name = "WEIGHT_NAME")),
        @AttributeOverride(name = "symbol",
                column = @Column(name = "WEIGHT_SYMBOL"))
})
public class Weight extends Measure {

    @NotNull
    protected BigDecimal weight;

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }
}
