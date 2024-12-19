package com.neoteric.dec_dbconnection.jpainheritance;

import java.util.Date;

public class StockTest {
    public static void main(String[] args) {
        StockService dao = new StockService();

        RestrictedStockEntity restrictedStock = new RestrictedStockEntity();
        restrictedStock.setPrice(100.5);
        restrictedStock.setDuration(24);
        restrictedStock.setLockInPeriod(12);

        OptionalStockEntity optionalStock = new OptionalStockEntity();
        optionalStock.setPrice(200.75);
        optionalStock.setDuration(36);
        optionalStock.setStrikePrice(190.5);

        FutureStocksEntity futureStock = new FutureStocksEntity();
        futureStock.setPrice(150.25);
        futureStock.setDuration(18);
        futureStock.setDeliveryDate(new Date());

        dao.saveStock(restrictedStock);
        dao.saveStock(optionalStock);
        dao.saveStock(futureStock);
    }
}



