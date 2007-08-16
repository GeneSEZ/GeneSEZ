package de.genesez.imsys.util;


/* <!-- PROTECTED REGION ID(java.mclassifier.other.import.code_12_5_8a7027a_1185033792134_42833_712) ENABLED START --> */
/* <!-- TODO put your imports here --> */
import java.lang.String;

import java.util.Calendar;
import java.util.Date;

/* <!-- PROTECTED REGION END --> */
/**
 * The date formater class format a Date. For example a year can parsed form a date.
 * @author nicher
 */
public class DateFormatter {

    // ////////////////////////////////////////////////////////////////////////
    // generated variable, constant and association declarations
    // ////////////////////////////////////////////////////////////////////////

    // ////////////////////////////////////////////////////////////////////////
    // generated constructor implementations
    // ////////////////////////////////////////////////////////////////////////

    // ////////////////////////////////////////////////////////////////////////
    // generated attribute derived method implementations
    // ////////////////////////////////////////////////////////////////////////

    // ////////////////////////////////////////////////////////////////////////
    // generated association method implementations
    // ////////////////////////////////////////////////////////////////////////

    // ////////////////////////////////////////////////////////////////////////
    // generated abstract method declaration
    // ////////////////////////////////////////////////////////////////////////

    // ////////////////////////////////////////////////////////////////////////
    // generated normal method implementations
    // ////////////////////////////////////////////////////////////////////////

    /**
     * Format a Date in the following format: year-month-day hour:minute:second,millisecond.
     * @param  date
     * @return
     */
    public static String getUTCFormat(Date date) {
        String returnValue = null;

        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1185033872044_719174_745) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        String year = format(getYear(date), 4);
        String month = format(getMonth(date), 2);
        String day = format(getDay(date), 2);
        String hour = format(getHour(date), 2);
        String minute = format(getMinute(date), 2);
        String second = format(getSecond(date), 2);
        String millisecond = format(getMilliSecond(date), 3);

        returnValue = year + "-" + month + "-" + day + " " + hour + ":" +
            minute + ":" + second + "." + millisecond;

        /* <!-- PROTECTED REGION END --> */
        return returnValue;
    }

    /**
     * Return the year of a date.
     * @param  date
     * @return
     */
    public static int getYear(Date date) {
        int returnValue = 0;

        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1185033914918_371447_752) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        returnValue = c.get(Calendar.YEAR);

        /* <!-- PROTECTED REGION END --> */
        return returnValue;
    }

    /**
     * Returns the month of a date.
     * @param  date
     * @return
     */
    public static int getMonth(Date date) {
        int returnValue = 0;

        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1185033951992_750622_761) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        returnValue = c.get(Calendar.MONTH) + 1;

        /* <!-- PROTECTED REGION END --> */
        return returnValue;
    }

    /**
     * Returns the day of a date.
     * @param  date
     * @return
     */
    public static int getDay(Date date) {
        int returnValue = 0;

        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1185033964477_905149_765) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        returnValue = c.get(Calendar.DAY_OF_MONTH);

        /* <!-- PROTECTED REGION END --> */
        return returnValue;
    }

    /**
     * Returns the hours of a date.
     * @param  date
     * @return
     */
    public static int getHour(Date date) {
        int returnValue = 0;

        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1185033971416_116942_769) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        returnValue = c.get(Calendar.HOUR_OF_DAY);

        /* <!-- PROTECTED REGION END --> */
        return returnValue;
    }

    /**
     * Returns the minutes of a date.
     * @param  date
     * @return
     */
    public static int getMinute(Date date) {
        int returnValue = 0;

        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1185033983884_820873_773) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        returnValue = c.get(Calendar.MINUTE);

        /* <!-- PROTECTED REGION END --> */
        return returnValue;
    }

    /**
     * Returns the seconds of a date.
     * @param  date
     * @return
     */
    public static int getSecond(Date date) {
        int returnValue = 0;

        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1185034001405_172711_777) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        returnValue = c.get(Calendar.SECOND);

        /* <!-- PROTECTED REGION END --> */
        return returnValue;
    }

    /**
     * Returns the milliseconds of a date.
     * @param  date
     * @return
     */
    public static int getMilliSecond(Date date) {
        int returnValue = 0;

        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1185034015225_759106_781) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        returnValue = c.get(Calendar.MILLISECOND);

        /* <!-- PROTECTED REGION END --> */
        return returnValue;
    }

    /**
     * Format a date (e.g. minute) and add leading zeros.
     * @param  dateTime
     * @param  count
     * @return
     */
    private static String format(int dateTime, int count) {
        String returnValue = null;
        /* <!-- PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1185101607461_226070_623) ENABLED START --> */
        /* <!-- TODO put your own implementation code here --> */
        returnValue = "";
        String dateTimeStr = new Integer(dateTime).toString();
        for (int i = dateTimeStr.length(); i < count; i++) {
            returnValue += returnValue + "0";
        }
        returnValue += dateTimeStr;

        /* <!-- PROTECTED REGION END --> */
        return returnValue;
    }

    // ////////////////////////////////////////////////////////////////////////
    // generated getter and setter method implementations
    // ////////////////////////////////////////////////////////////////////////

    // ////////////////////////////////////////////////////////////////////////
    // own implementations
    // ////////////////////////////////////////////////////////////////////////

    /* <!-- PROTECTED REGION ID(java.mclassifier.implementation.owncode.code._12_5_8a7027a_1185033792134_42833_712) ENABLED START --> */
    /* <!-- TODO put your own implementation code here --> */

    /* <!-- PROTECTED REGION END --> */
}
