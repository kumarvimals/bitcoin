package com.coinbase.vo;

import java.util.List;

/**
 * The type Data.
 *
 * @author Vimal Kumar
 * @date 11 /15/2018
 */
public class Data {
    private String base;

    private List<Prices> prices;

    private String currency;

    /**
     * Gets base.
     *
     * @return the base
     */
    public String getBase() {
        return base;
    }

    /**
     * Sets base.
     *
     * @param base the base
     */
    public void setBase(String base) {
        this.base = base;
    }

    /**
     * Gets prices.
     *
     * @return the prices
     */
    public List<Prices> getPrices() {
        return prices;
    }

    /**
     * Sets prices.
     *
     * @param prices the prices
     */
    public void setPrices(List<Prices> prices) {
        this.prices = prices;
    }

    /**
     * Gets currency.
     *
     * @return the currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets currency.
     *
     * @param currency the currency
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "ClassPojo [base = " + base + ", prices = " + prices + ", currency = " + currency + "]";
    }
}

