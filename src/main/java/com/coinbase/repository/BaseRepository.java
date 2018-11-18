package com.coinbase.repository;

import com.coinbase.vo.CoinBase;
import org.springframework.web.client.RestTemplate;

/**
 * The type Base repository.
 *
 * @author Vimal Kumar
 * @date 11 /15/2018
 */
public class BaseRepository {

    /**
     * Gets prices.
     *
     * @return the prices
     */
    public CoinBase getPrices() {
        RestTemplate restTemplate = new RestTemplate();
        CoinBase coinBase = restTemplate.getForObject("https://www.coinbase.com/api/v2/prices/BTC-USD/historic?period=all", CoinBase.class);
        System.out.println("coinBase = " + coinBase.toString());
        return coinBase;
    }
}
