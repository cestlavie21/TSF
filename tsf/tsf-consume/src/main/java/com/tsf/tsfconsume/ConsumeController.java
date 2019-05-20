package com.tsf.tsfconsume;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumeController {

    @Autowired
    AccountService accountService;
    @Autowired
    CreditService creditService;
    @Autowired
    PaymentConfig config;



    @PutMapping("/consume/payment")
    public  String Payment(@RequestBody PaymentParam param){

        String accountStr = accountService.getAccount(param.getAccountId());
        if (accountStr.equals("账号不存在")) {
            return "账号不存在";
        }

        String creditStr = creditService.getCredit(param.getAccountId());
        PaymentParam credit = JsonUtils.jsonToClass(creditStr, PaymentParam.class);
        if(credit.getCredit()<0){
            return "信用余额不足";
        }

        if (param.getCredit()> config.getMax()){
            return  "超出单次金额上限";
        }

        creditService.deduct(param);

        return  "转出完成,信用额度减少";
    }

    @PutMapping("/consume/deposit")
    public  String deposit(@RequestBody PaymentParam param){
        String accountStr = accountService.getAccount(param.getAccountId());
        if (accountStr.equals("") || accountStr == null) {
            return "还款失败,账号不存在";
        }

        creditService.recover(param);

        return  "还款完成,信用额度恢复";

    }

}
