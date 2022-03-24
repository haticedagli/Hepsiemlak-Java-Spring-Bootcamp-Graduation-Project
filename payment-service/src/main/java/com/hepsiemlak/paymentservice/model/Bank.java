package com.hepsiemlak.paymentservice.model;

public enum Bank {
    ZİRAAT("Ziraat Bankası"),
    YAPI_KREDİ("Yapı Kredi Bankası"),
    İŞ_BANKASI("İş Bankası"),
    GARANTİ("Garanti Bankası"),
    AKBANK("Akbank"),
    ;

    public final String bankName;

    Bank(String name) {
        this.bankName = name;
    }
}
