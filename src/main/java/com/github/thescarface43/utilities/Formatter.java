package com.github.thescarface43.utilities;

import org.springframework.stereotype.Component;
import java.math.BigDecimal;

@Component
public class Formatter {

    public String formatBigDecimal(BigDecimal value) {
        if (value.scale() <= 0) {
            return value.setScale(0).toPlainString();
        } else {
            return value.stripTrailingZeros().toPlainString();
        }
    }
}