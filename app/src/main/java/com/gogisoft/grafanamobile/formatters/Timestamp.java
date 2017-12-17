package com.gogisoft.grafanamobile.formatters;

import java.util.Calendar;

public class Timestamp {
    private Calendar time;
    private int step;
    private long start;
    private long end;

    private final int HOUR = 60 * 60;
    private final int DAY = 60 * 60 * 24;
    private final int MONTH = 60 * 60 * 24 * 31;

    private final static int MODE_HOUR = 1;
    private final static int MODE_DAY = 2;
    private final static int MODE_MONTH = 3;
    private final static int MODE_YEAR = 4;

    public Timestamp(long timestamp, int step, long start, long end) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp * 1000);
        this.time = calendar;
        this.step = step;
        this.start = start;
        this.end = end;
    }

    public float toFloat() {
        if(end - start < HOUR) {
            float mode = 1 * 1000000;
            float hour = time.get(Calendar.HOUR_OF_DAY) * 10000;
            float minute = time.get(Calendar.MINUTE) * 100;
            float second = time.get(Calendar.SECOND);
            return mode + hour + minute + second;
        } else if(end - start < DAY) {
            float mode = 2 * 1000000;
            float day = time.get(Calendar.DAY_OF_MONTH) * 10000;
            float hour = time.get(Calendar.HOUR_OF_DAY) * 100;
            float minute = time.get(Calendar.MINUTE);
            return mode + day + hour + minute;
        } else if(end - start < MONTH) {
            float mode = 3 * 1000000;
            float month = time.get(Calendar.MONTH) * 10000;
            float day = time.get(Calendar.DAY_OF_MONTH) * 100;
            float hour = time.get(Calendar.HOUR_OF_DAY);
            return mode + month + day + hour;
        } else {
            float mode = 4 * 1000000;
            float year = time.get(Calendar.YEAR) * 10000;
            float month = time.get(Calendar.MONTH) * 100;
            float day = time.get(Calendar.DAY_OF_MONTH);
            return mode + year + month + day;
        }
    }

    public static String fromFloat(float timestamp) {
        int time = (int)timestamp;
        int mode = time / 1000000;

        switch (mode) {
            case MODE_HOUR: {
                int hour = (time - (mode * 1000000)) / 10000;
                int minute = (time - (mode * 1000000) - (hour * 10000)) / 100;
                int second = (time - (mode * 1000000) - (hour * 10000) - (minute * 100));

                return numToString(hour) + ":" + numToString(minute) + ":" + numToString(second);
            }
            case MODE_DAY: {
                int day = (time - (mode * 1000000)) / 10000;
                int hour = (time - (mode * 1000000) - (day * 10000)) / 100;
                int minute = (time - (mode * 1000000) - (day * 10000) - (hour * 100));

                return numToString(day) + "T" + numToString(hour) + ":" + numToString(minute);
            }
            case MODE_MONTH: {
                int month = (time - (mode * 1000000)) / 10000;
                int day = (time - (mode * 1000000) - (month * 10000)) / 100;
                int hour = (time - (mode * 1000000) - (month * 10000) - (day * 100));

                return numToString(month) + "/" + numToString(day) + " T" + numToString(hour);
            }
            case MODE_YEAR: {
                int year = (time - (mode * 1000000)) / 10000;
                int month = (time - (mode * 1000000) - (year * 10000)) / 100;
                int day = (time - (mode * 1000000) - (year * 10000) - (month * 100));

                return "20" + numToString(year) + " " + numToString(month)+ "/" + numToString(day);
            }
            default:
                return "";
        }
    }

    private static String numToString(int num) {
        if (num / 10 == 0) {
            return "0" + num;
        } else {
            return "" + num;
        }
    }
}
