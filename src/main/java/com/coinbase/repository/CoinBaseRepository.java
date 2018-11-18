package com.coinbase.repository;

import com.coinbase.dto.AveragePrice;
import com.coinbase.dto.Compliance;
import com.coinbase.vo.CoinBase;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

import static com.coinbase.constant.Constant.CUSTOM;
import static com.coinbase.constant.Constant.GREEN;
import static com.coinbase.constant.Constant.MONTH;
import static com.coinbase.constant.Constant.RED;
import static com.coinbase.constant.Constant.WEEK;
import static com.coinbase.constant.Constant.YEAR;
import static com.coinbase.constant.Constant.YELLOW;
import java.util.Calendar;
import java.util.Date;

/**
 * The interface Coin base repository.
 *
 * @author Vimal Kumar
 * @date 11 /15/2018
 */
public interface CoinBaseRepository {

    /**
     * Gets prices.
     *
     * @param fromDate the from date
     * @param toDate   the to date
     * @param type     the type
     *
     * @return the prices
     */
    CompletableFuture<CoinBase> getPrices(String fromDate, String toDate, String type);

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

    /**
     * Gets dates.
     *
     * @param fromDate the from date
     * @param toDate   the to date
     * @param type     the type
     *
     * @return the dates
     */
    default Map<String, Timestamp> getDates(String fromDate, String toDate, String type) {
        Map<String, Timestamp> map = new HashMap<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        String strHHMMSS=" 00:00:00";
        if (CUSTOM.equalsIgnoreCase(type)) {
            Timestamp fromTimestamp = Timestamp.valueOf(fromDate+strHHMMSS);
            Timestamp toTimestamp = Timestamp.valueOf(toDate+strHHMMSS);
            map.put("fromDate", fromTimestamp);
            map.put("toDate", toTimestamp);
        }else if (WEEK.equalsIgnoreCase(type)) {
            Timestamp fromTimestamp = firstDayOfLastWeek(calendar);
            Timestamp toTimestamp = lastDayOfLastWeek(calendar);
            map.put("fromDate", fromTimestamp);
            map.put("toDate", toTimestamp);
        }else if (MONTH.equalsIgnoreCase(type)) {
            Timestamp fromTimestamp = firstDateOfPreviousMonth();
            Timestamp toTimestamp = lastDateOfPreviousMonth();
            map.put("fromDate", fromTimestamp);
            map.put("toDate", toTimestamp);
        }else if (YEAR.equalsIgnoreCase(type)) {
            Timestamp fromTimestamp = Timestamp.valueOf(fromDate);
            Timestamp toTimestamp = Timestamp.valueOf(toDate);
            map.put("fromDate", fromTimestamp);
            map.put("toDate", toTimestamp);
        }
        else{
            throw new RuntimeException("Invalid Date Type");
        }

        return map;
    }

    /**
     * Gets number of days.
     *
     * @param days the days
     *
     * @return the number of days
     */
    default Map<String, Timestamp> getNumberOfDays(int days) {
        Map<String, Timestamp> map = new HashMap<>();
        Calendar aCalendar1 = Calendar.getInstance();
        Timestamp CurrentDay = new Timestamp(aCalendar1.getTimeInMillis());

        Calendar aCalendar2 = Calendar.getInstance();
        aCalendar2.add(Calendar.DATE, -days);
        Timestamp previousday = new Timestamp(aCalendar2.getTimeInMillis());

        map.put("fromDate", previousday);
        map.put("toDate", CurrentDay);
        return map;
    }

/*
    default String getTheDescription(String security, String option) {
        String description = null;
        if (GREEN.equalsIgnoreCase(security)) {
             description = "Allow to " + option;
        }else if (YELLOW.equalsIgnoreCase(security)) {
              description = "Hold to " + option;
        }else if (RED.equalsIgnoreCase(security)) {
              description = "Not Allowed  " + option;
        }
        return description;
    }
*/


    default Timestamp firstDayOfLastWeek(Calendar c)
    {
        c = (Calendar) c.clone();
        // last week
        c.add(Calendar.WEEK_OF_YEAR, -1);
        // first day
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek());

        Timestamp firstDayOfLastWeek= new Timestamp(c.getTimeInMillis());

        return firstDayOfLastWeek;
    }

    default Timestamp  lastDayOfLastWeek(Calendar c)
    {
        c = (Calendar) c.clone();
        // first day of this week
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek());
        // last day of previous week
        c.add(Calendar.DAY_OF_MONTH, -1);
        Timestamp lastDayOfLastWeek= new Timestamp(c.getTimeInMillis());
        return lastDayOfLastWeek;
    }

    default Timestamp  firstDateOfPreviousMonth(){
        Calendar aCalendar1 = Calendar.getInstance();
        aCalendar1.set(Calendar.DATE, 1);
        aCalendar1.add(Calendar.DAY_OF_MONTH, -1);
        aCalendar1.set(Calendar.DATE, 1);
        Timestamp firstDateOfPreviousMonth= new Timestamp(aCalendar1.getTimeInMillis());
        return firstDateOfPreviousMonth;
    }

    default Timestamp  lastDateOfPreviousMonth(){
        Calendar aCalendar = Calendar.getInstance();
        aCalendar.set(Calendar.DATE, 1);
        aCalendar.add(Calendar.DAY_OF_MONTH, -1);
        Timestamp lastDateOfPreviousMonth= new Timestamp(aCalendar.getTimeInMillis());
        return lastDateOfPreviousMonth;
    }





}
