package com.coinbase.dto;

import com.coinbase.vo.Prices;

import java.sql.Timestamp;
import java.util.List;

/**
 * The type Compliance.
 *
 * @author kamahalingam
 * @date 11 /15/2018
 */
public class Compliance {

    private String base;

    private String currency;

    private Timestamp fromDate;

    private Timestamp toDate;

    private  int numberOfDays;

    private String security;

    private String option;

    private String description;

    public List<Prices> getPrices() {
        return prices;
    }

    public void setPrices(List<Prices> prices) {
        this.prices = prices;
    }

    private List<Prices> prices;

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
    public Timestamp getFromDate() {
        return fromDate;
    }

    /**
     * Sets from date.
     *
     * @param fromDate the from date
     */
    public void setFromDate(Timestamp fromDate) {
        this.fromDate = fromDate;
    }

    /**
     * Gets to date.
     *
     * @return the to date
     */
    public Timestamp getToDate() {
        return toDate;
    }

    /**
     * Sets to date.
     *
     * @param toDate the to date
     */
    public void setToDate(Timestamp toDate) {
        this.toDate = toDate;
    }

    /**
     * Gets number of days.
     *
     * @return the number of days
     */
    public int getNumberOfDays() {
        return numberOfDays;
    }

    /**
     * Sets number of days.
     *
     * @param numberOfDays the number of days
     */
    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    /**
     * Gets security.
     *
     * @return the security
     */
    public String getSecurity() {
        return security;
    }

    /**
     * Sets security.
     *
     * @param security the security
     */
    public void setSecurity(String security) {
        this.security = security;
    }

    /**
     * Gets option.
     *
     * @return the option
     */
    public String getOption() {
        return option;
    }

    /**
     * Sets option.
     *
     * @param option the option
     */
    public void setOption(String option) {
        this.option = option;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Compliance{" +
                "base='" + base + '\'' +
                ", currency='" + currency + '\'' +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", numberOfDays=" + numberOfDays +
                ", security='" + security + '\'' +
                ", option='" + option + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
