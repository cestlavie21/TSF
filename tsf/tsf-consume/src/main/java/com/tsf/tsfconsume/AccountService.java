package com.tsf.tsfconsume;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "tsf-account")
public interface AccountService {
    @GetMapping("/account/{id}")
    String getAccount(@PathVariable String id);
    @GetMapping("/account/list")
    String getAccountList();

}
