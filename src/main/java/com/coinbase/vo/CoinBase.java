package com.coinbase.vo;

/**
 * The type Coin base.
 *
 * @author Vimal Kumar
 * @date 11 /15/2018
 */
public class CoinBase {

    private Data data;

    /**
     * Gets data.
     *
     * @return the data
     */
    public Data getData() {
        return data;
    }

    /**
     * Sets data.
     *
     * @param data the data
     */
    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ClassPojo [data = " + data + "]";
    }
}
