package com.coinbase.service;

import com.coinbase.dto.AveragePrice;
import com.coinbase.dto.Compliance;
import com.coinbase.vo.CoinBase;

import java.util.concurrent.CompletableFuture;

/**
 * The interface Coin base service.
 *
 * @author Vimal Kumar
 * @date 11 /15/2018
 */
public interface CoinBaseService {

    /**
     * Gets prices.
     *
     * @param fromTimestamp the from timestamp
     * @param toTimestamp   the to timestamp
     * @param type          the type
     *
     * @return the prices
     */
    CompletableFuture<CoinBase> getPrices(String fromTimestamp, String toTimestamp, String type);

    /**
     * Gets average.
     *
     * @param fromTimestamp the from timestamp
     * @param toTimestamp   the to timestamp
     *
     * @return the average
     */
    CompletableFuture<AveragePrice> getAverage(String fromTimestamp, String toTimestamp);

    /**
     * Run compliance completable future.
     *
     * @param days   the days
     * @param option the option
     *
     * @return the completable future
     */
    CompletableFuture<Compliance> runCompliance(int days);

}
