package com.tsf.tsfconsume;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "tsf-credit")
public interface CreditService {
    @GetMapping("/credit/{id}")
    String getCredit(@PathVariable String id);
    @PutMapping("/credit/deduct")
    Boolean deduct(@RequestBody PaymentParam param);
    @PutMapping("/credit/recover")
    Boolean recover(@RequestBody PaymentParam param);
}
