package com.example.aleksandrabramovski.webparsingjson;


public class BankRates {
    String bankName;
    String rateBuyUSD;
    String rateSellUSD;
    String rateBuyEURO;
    String rateSellEURO;
    String rateUpdt;


    //Class constructor
    public BankRates(String bankName, String rateBuyUSD, String rateSellUSD,
                    String rateBuyEURO, String rateSellEURO, String rateUpdt){
        this.bankName = bankName;
        this.rateBuyUSD = rateBuyUSD;
        this.rateSellUSD = rateSellUSD;
        this.rateBuyEURO = rateBuyEURO;
        this.rateSellEURO = rateSellEURO;
        this.rateUpdt = rateUpdt;
    }

    //returning values of the Class
    public String getBankName(){
        return bankName;
    }

    public String getRateBuyUSD(){
        return rateBuyUSD;
    }

    public String getRateSellUSD(){
        return rateSellUSD;
    }

    public String getRateBuyEURO(){
        return rateBuyEURO;
    }

    public String getRateSellEURO(){
        return rateSellEURO;
    }

    public String getRateUpdt(){
        return rateUpdt;
    }
}