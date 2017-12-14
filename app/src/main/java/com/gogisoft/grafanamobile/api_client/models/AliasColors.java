
package com.gogisoft.grafanamobile.api_client.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AliasColors {

    @SerializedName("cpu")
    @Expose
    private String cpu;
    @SerializedName("memory")
    @Expose
    private String memory;
    @SerializedName("statsd.fakesite.counters.session_start.desktop.count")
    @Expose
    private String statsdFakesiteCountersSessionStartDesktopCount;
    @SerializedName("logins")
    @Expose
    private String logins;
    @SerializedName("logins (-1 day)")
    @Expose
    private String logins1Day;
    @SerializedName("cpu1")
    @Expose
    private String cpu1;
    @SerializedName("cpu2")
    @Expose
    private String cpu2;
    @SerializedName("upper_25")
    @Expose
    private String upper25;
    @SerializedName("upper_50")
    @Expose
    private String upper50;
    @SerializedName("upper_75")
    @Expose
    private String upper75;
    @SerializedName("upper_90")
    @Expose
    private String upper90;
    @SerializedName("upper_95")
    @Expose
    private String upper95;
    @SerializedName("web_server_01")
    @Expose
    private String webServer01;
    @SerializedName("web_server_02")
    @Expose
    private String webServer02;
    @SerializedName("web_server_03")
    @Expose
    private String webServer03;
    @SerializedName("web_server_04")
    @Expose
    private String webServer04;

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getStatsdFakesiteCountersSessionStartDesktopCount() {
        return statsdFakesiteCountersSessionStartDesktopCount;
    }

    public void setStatsdFakesiteCountersSessionStartDesktopCount(String statsdFakesiteCountersSessionStartDesktopCount) {
        this.statsdFakesiteCountersSessionStartDesktopCount = statsdFakesiteCountersSessionStartDesktopCount;
    }

    public String getLogins() {
        return logins;
    }

    public void setLogins(String logins) {
        this.logins = logins;
    }

    public String getLogins1Day() {
        return logins1Day;
    }

    public void setLogins1Day(String logins1Day) {
        this.logins1Day = logins1Day;
    }

    public String getCpu1() {
        return cpu1;
    }

    public void setCpu1(String cpu1) {
        this.cpu1 = cpu1;
    }

    public String getCpu2() {
        return cpu2;
    }

    public void setCpu2(String cpu2) {
        this.cpu2 = cpu2;
    }

    public String getUpper25() {
        return upper25;
    }

    public void setUpper25(String upper25) {
        this.upper25 = upper25;
    }

    public String getUpper50() {
        return upper50;
    }

    public void setUpper50(String upper50) {
        this.upper50 = upper50;
    }

    public String getUpper75() {
        return upper75;
    }

    public void setUpper75(String upper75) {
        this.upper75 = upper75;
    }

    public String getUpper90() {
        return upper90;
    }

    public void setUpper90(String upper90) {
        this.upper90 = upper90;
    }

    public String getUpper95() {
        return upper95;
    }

    public void setUpper95(String upper95) {
        this.upper95 = upper95;
    }

    public String getWebServer01() {
        return webServer01;
    }

    public void setWebServer01(String webServer01) {
        this.webServer01 = webServer01;
    }

    public String getWebServer02() {
        return webServer02;
    }

    public void setWebServer02(String webServer02) {
        this.webServer02 = webServer02;
    }

    public String getWebServer03() {
        return webServer03;
    }

    public void setWebServer03(String webServer03) {
        this.webServer03 = webServer03;
    }

    public String getWebServer04() {
        return webServer04;
    }

    public void setWebServer04(String webServer04) {
        this.webServer04 = webServer04;
    }

}
