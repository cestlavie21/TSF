package com.tsf.tsfcredit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CreditController {

    @Autowired
    AccountService accountService;

    private int CreditNum = 50;

    @ResponseBody
    @GetMapping("/credit/{id}")
    public String getCredit(@PathVariable String id) {
        String accountStr = accountService.getAccount(id);
        if (accountStr.equals("账号不存在")) {
            return accountStr;
        }
        Credit credit = JsonUtils.jsonToClass(accountStr, Credit.class);
        credit.setCredit(CreditNum);
        return JsonUtils.objectToJson(credit);
    }

    @PutMapping("/credit/deduct")
    public boolean deduct(@RequestBody Credit param) {

        String accountStr = accountService.getAccount(param.getAccountId());
        if (accountStr.equals("账号不存在")) {
            return false;
        }

        CreditNum = CreditNum - param.getCredit();

        return true;
    }

    @PutMapping("/credit/recover")
    public boolean recover(@RequestBody Credit param) {

        String accountStr = accountService.getAccount(param.getAccountId());
        if (accountStr.equals("账号不存在")) {
            return false;
        }

        CreditNum = CreditNum + param.getCredit();

        return true;
    }

}
