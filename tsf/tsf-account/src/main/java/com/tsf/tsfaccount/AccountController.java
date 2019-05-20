package com.tsf.tsfaccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    AccountDao accountDao;

    @ResponseBody
    @GetMapping("/account/{id}")
    public  String  getAccount(@PathVariable String id){

        Account account = accountDao.getAccount(id);
        if (account==null){
            return  "账号不存在";
        }
        String json = JsonUtils.objectToJson(account);
        return json;
    }


    @ResponseBody
    @GetMapping("/account/list")
    public List<Account> getAccountList(){

        return  accountDao.getAccountList();
    }
}
