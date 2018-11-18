package com.coinbase.repository.impl;

import com.coinbase.dto.AveragePrice;
import com.coinbase.dto.Compliance;
import com.coinbase.repository.BaseRepository;
import com.coinbase.vo.CoinBase;
import com.coinbase.repository.CoinBaseRepository;
import com.coinbase.vo.Prices;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;

/**
 * The type Coin base repository.
 *
 * @author Vimal Kumar
 * @date 11 /15/2018
 */
@Repository
public class CoinBaseRepositoryImpl extends BaseRepository implements CoinBaseRepository {

    /**
     * Gets prices.
     *
     * @param fromDate the from date
     * @param toDate   the to date
     * @param type     the type
     *
     * @return the prices
     */
    @Override
    public CompletableFuture<CoinBase> getPrices(String fromDate, String toDate, String type) {
        return CompletableFuture.supplyAsync(() -> {
            CoinBase coinBase = getPrices();
            Map<String, Timestamp> dateTime = getDates(fromDate, toDate, type);
            Timestamp fromTimestamp = dateTime.get("fromDate");
            Timestamp toTimestamp = dateTime.get("toDate");
            System.out.println(" fromTimestamp =================>>>>>>>>>>>>"+fromTimestamp);
            System.out.println("   toTimestamp =================>>>>>>>>>>>>"+toTimestamp);
            List<Prices> list = coinBase.getData().getPrices().stream().filter(a -> (a.getTime().after(fromTimestamp)) && a.getTime().before(toTimestamp)).collect(Collectors.toList());
            coinBase.getData().setPrices(list);
            return coinBase;
        });
    }

    /**
     * Gets average.
     *
     * @param fromDate the from timestamp
     * @param toDate   the to timestamp
     *
     * @return the average
     */
    @Override
    public CompletableFuture<AveragePrice> getAverage(String fromDate, String toDate) {
        return CompletableFuture.supplyAsync(() -> {
            CoinBase coinBase = getPrices();
            Map<String, Timestamp> dateTime = getDates(fromDate, toDate, "CUSTOM");
            Timestamp toTimestamp = dateTime.get("toDate");
            Timestamp fromTimestamp = dateTime.get("fromDate");
            List<Prices> list = coinBase.getData().getPrices().stream().filter(a -> (a.getTime().after(fromTimestamp)) && a.getTime().before(toTimestamp)).collect(Collectors.toList());
            OptionalDouble avg = list.stream().mapToDouble(i -> i.getPrice()).average();
            AveragePrice averagePrice = new AveragePrice();
            averagePrice.setAveragePrice(avg.getAsDouble());
            averagePrice.setBase(coinBase.getData().getBase());
            averagePrice.setCurrency(coinBase.getData().getCurrency());
            averagePrice.setFromDate(fromDate);
            averagePrice.setToDate(toDate);
            return averagePrice;
        });
    }

    /**
     * Run compliance completable future.
     *
     * @param days   the days
     *
     * @return the completable future
     */
    @Override
    public CompletableFuture<Compliance> runCompliance(int days) {
        return CompletableFuture.supplyAsync(() -> {
            CoinBase coinBase = getPrices();
            Map<String, Timestamp> dateTime = getNumberOfDays(days);
            Compliance compliance = new Compliance();

            Timestamp toTimestamp = dateTime.get("toDate");
            Timestamp fromTimestamp = dateTime.get("fromDate");
            compliance.setFromDate(fromTimestamp);
            compliance.setToDate(toTimestamp);
            compliance.setCurrency(coinBase.getData().getCurrency());
            compliance.setBase(coinBase.getData().getBase());
            compliance.setNumberOfDays(days);
            List<Prices> list = coinBase.getData().getPrices().stream().filter(a -> (a.getTime().after(fromTimestamp)) && a.getTime().before(toTimestamp)).collect(Collectors.toList());
            compliance.setPrices(list);
            String description = getTheDescription(list);
            compliance.setDescription(description);

            return compliance;
        });
    }


    public String getTheDescription(List<Prices> list) {
        double rate=0d;
        int iSell=0;
        int iBuy=0;
        int iHold=0;
        String security = "GREEN";

        for (Prices pr:list) {

            if(rate ==0){
                rate=pr.getPrice();
            }else{
                    if(rate > pr.getPrice() ){
                        iSell=iSell+1;
                    }else if(rate < pr.getPrice() ){
                        iBuy=iBuy+1;
                    }else if(rate == pr.getPrice() ){
                        iHold=iHold+1;
                    }
                rate=pr.getPrice();
            }
        }

        System.out.println("iSell =========>>>"+iSell);
        System.out.println("iBuy =========>>>"+iBuy);
        System.out.println("iHold =========>>>"+iHold);


        if(iSell > iBuy && iSell > iHold){
            security="SELL";
        }else if(iBuy > iSell && iBuy > iHold){
            security="BUY";
        }else if(iHold > iSell && iHold > iBuy){
            security="HOLD";
        }else if(iSell == iBuy ){
            security="BUY or SELL";
        }else if(iSell == iBuy ){
            security="BUY or SELL";
        }
        return security;
    }

}
