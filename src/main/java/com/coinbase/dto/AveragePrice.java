package com.coinbase.dto;

import com.coinbase.vo.Prices;

import java.util.List;

/**
 * The type Average price.
 *
 * @author Kumar Vimal
 * @date 11 /15/2018
 */
public class AveragePrice {

    private String base;

    private String currency;

    private String fromDate;

    private String toDate;

    private double averagePrice;

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

    /**
     * Gets from date.
     *
     * @return the from date
     */
    public String getFromDate() {
        return fromDate;
    }

    /**
     * Sets from date.
     *
     * @param fromDate the from date
     */
    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    /**
     * Gets to date.
     *
     * @return the to date
     */
    public String getToDate() {
        return toDate;
    }

    /**
     * Sets to date.
     *
     * @param toDate the to date
     */
    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    /**
     * Gets average price.
     *
     * @return the average price
     */
    public double getAveragePrice() {
        return averagePrice;
    }

    /**
     * Sets average price.
     *
     * @param averagePrice the average price
     */
    public void setAveragePrice(double averagePrice) {
        this.averagePrice = averagePrice;
    }

    @Override
    public String toString() {
        return "AveragePrice{" +
                "base='" + base + '\'' +
                ", currency='" + currency + '\'' +
                ", fromDate='" + fromDate + '\'' +
                ", toDate='" + toDate + '\'' +
                ", averagePrice=" + averagePrice +
                '}';
    }
}
