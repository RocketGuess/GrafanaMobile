package com.gogisoft.grafanamobile.datasources;

public class QueryTimeParams {
    public long startTime;
    public long endTime;

    public QueryTimeParams(long startTime, long endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getStartTime() {
        return new Long(startTime / 1000).toString();
    }

    public String getEndTime() {
        return new Long(endTime / 1000).toString();
    }

    public int getRange() {
        return (int)((endTime - startTime) / 1000);
    }
}
