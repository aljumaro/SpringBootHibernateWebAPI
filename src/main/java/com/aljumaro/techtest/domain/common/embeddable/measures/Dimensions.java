package com.aljumaro.techtest.domain.common.embeddable.measures;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @Date 23/04/2016
 * @Time 9:19
 * @Author Juanma
 */
@Embeddable
@AttributeOverrides({
        @AttributeOverride(name = "name",
                column = @Column(name = "DIMENSIONS_NAME")),
        @AttributeOverride(name = "symbol",
                column = @Column(name = "DIMENSIONS_SYMBOL"))
})
public class Dimensions extends Measure {

    @NotNull
    protected BigDecimal depth;

    @NotNull
    protected BigDecimal height;

    @NotNull
    protected BigDecimal width;

    public BigDecimal getDepth() {
        return depth;
    }

    public void setDepth(BigDecimal depth) {
        this.depth = depth;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        this.width = width;
    }
}
