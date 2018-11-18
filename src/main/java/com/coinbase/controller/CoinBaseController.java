package com.coinbase.controller;

import com.coinbase.dto.AveragePrice;
import com.coinbase.dto.Compliance;
import com.coinbase.service.CoinBaseService;
import com.coinbase.vo.CoinBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

/**
 * The type Coin base controller.
 *
 * @author Vimal Kumar
 * @date 11 /15/2018
 */
@RestController
public class CoinBaseController {

    /**
     * The constant logger.
     */
    public static final Logger logger = LoggerFactory.getLogger(CoinBaseController.class);

    /**
     * The Coin base service.
     */
    @Autowired
    CoinBaseService coinBaseService;

    /**
     * Gets prices.
     *
     * @param fromDate the from date
     * @param toDate   the to date
     * @param type     the type
     *
     * @return the prices
     */
    @RequestMapping(value = "/prices", method = RequestMethod.GET)
    public CompletableFuture<CoinBase> getPrices(@RequestParam(required = false) String fromDate, @RequestParam(required = false) String toDate, @RequestParam String type) {
        logger.info("getPrices fromDate {}, toDate {}, type {} ", fromDate, toDate, type);
        return coinBaseService.getPrices(fromDate, toDate, type);
    }

    /**
     * Gets average.
     *
     * @param fromDate the from date
     * @param toDate   the to date
     *
     * @return the average
     */
    @RequestMapping(value = "/average", method = RequestMethod.GET)
    public CompletableFuture<AveragePrice> getAverage(@RequestParam String fromDate, @RequestParam String toDate) {
        logger.info("getAverage fromDate {}, toDate {} ", fromDate, toDate);
        return coinBaseService.getAverage(fromDate, toDate);
    }

    /**
     * Run compliance completable future.
     *
     * @param days   the days
     *
     * @return the completable future
     */
    @RequestMapping(value = "/runCompliance", method = RequestMethod.GET)
    public CompletableFuture<Compliance> runCompliance(@RequestParam int days) {
        logger.info("getAverage, days {} , option {}  ", days);
        return coinBaseService.runCompliance(days);
    }
}

