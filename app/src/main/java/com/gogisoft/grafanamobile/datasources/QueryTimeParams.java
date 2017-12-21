package com.gogisoft.grafanamobile.datasources;

public class QueryTimeParams {
    public long startTime;
    public long endTime;
    public int step;

    public QueryTimeParams(long startTime, long endTime, int step) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.step = step;
    }

    public String getStartTime() {
        return new Long(startTime).toString();
    }

    public String getEndTime() {
        return new Long(endTime).toString();
    }

    public String getStepTime() {
        return step + "s";
    }
}
