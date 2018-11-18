package com.coinbase.service.impl;

import com.coinbase.dto.AveragePrice;
import com.coinbase.dto.Compliance;
import com.coinbase.service.CoinBaseService;
import com.coinbase.vo.CoinBase;
import com.coinbase.repository.CoinBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

/**
 * The type Coin base service.
 *
 * @author Vimal Kumar
 * @date 11 /15/2018
 */
@Service
public class CoinBaseServiceImpl implements CoinBaseService {

    /**
     * The Coin base repository.
     */
    @Autowired
    CoinBaseRepository coinBaseRepository;

    /**
     * Gets prices.
     *
     * @param fromTimestamp the from timestamp
     * @param toTimestamp   the to timestamp
     * @param type          the type
     *
     * @return the prices
     */

    @Override
    public CompletableFuture<CoinBase> getPrices(String fromTimestamp, String toTimestamp, String type) {
        return coinBaseRepository.getPrices(fromTimestamp, toTimestamp, type);
    }

    /**
     * Gets average.
     *
     * @param fromTimestamp the from timestamp
     * @param toTimestamp   the to timestamp
     *
     * @return the average
     */
    @Override
    public CompletableFuture<AveragePrice> getAverage(String fromTimestamp, String toTimestamp) {
        return coinBaseRepository.getAverage(fromTimestamp, toTimestamp);
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
        return coinBaseRepository.runCompliance(days);
    }
}
