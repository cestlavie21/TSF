package com.tsf.tsfaccount;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDao {

    public List<Account> accountList = new ArrayList<>();

    {
        accountList.add(new Account("account-1", "accountName-1"));
        accountList.add(new Account("account-2", "accountName-2"));
        accountList.add(new Account("account-3", "accountName-3"));
        accountList.add(new Account("account-4", "accountName-4"));
        accountList.add(new Account("account-5", "accountName-5"));
        accountList.add(new Account("account-6", "accountName-6"));
        accountList.add(new Account("account-7", "accountName-7"));
    }

    public Account getAccount(String id) {
        for (Account ac : accountList
        ) {
            if (ac.getAccountId().equals(id)) {
                return ac;
            }
        }
        return null;
    }

    public List<Account> getAccountList() {
        return accountList;
    }
}
