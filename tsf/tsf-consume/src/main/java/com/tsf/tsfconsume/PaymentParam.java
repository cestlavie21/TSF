package com.tsf.tsfconsume;

public class PaymentParam {

    private  String accountId;
    private  String accountName;
    private  int credit;

    public String getAccountId() {
        return accountId;
    }

    public  PaymentParam(){
    }

    public PaymentParam(String accountId, String accountName, int credit) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.credit = credit;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }
}
