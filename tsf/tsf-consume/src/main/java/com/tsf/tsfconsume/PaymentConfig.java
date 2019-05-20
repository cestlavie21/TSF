package com.tsf.tsfconsume;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "payment.config")
@RefreshScope
public class PaymentConfig {

    int max = 50;

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}
