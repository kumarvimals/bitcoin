package com.coinbase.vo;

import java.sql.Timestamp;

/**
 * The type Prices.
 *
 * @author Vimal Kumar
 * @date 11 /15/2018
 */
public class Prices {
    private Timestamp time;

    private double price;

    /**
     * Gets time.
     *
     * @return the time
     */
    public Timestamp getTime() {
        return time;
    }

    /**
     * Sets time.
     *
     * @param time the time
     */
    public void setTime(Timestamp time) {
        this.time = time;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets price.
     *
     * @param price the price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ClassPojo [time = " + time + ", price = " + price + "]";
    }
}
