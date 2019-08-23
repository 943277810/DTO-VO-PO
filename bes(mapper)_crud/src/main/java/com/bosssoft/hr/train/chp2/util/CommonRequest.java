package com.bosssoft.hr.train.chp2.util;

/**
 * @author 94327
 */
public class CommonRequest {

    //head
    private String version;
    private String token;
    private String servicetype;
    private String deviceid;
    private Integer devicetype;
    private Integer remark;
    //body
    private String body;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getServicetype() {
        return servicetype;
    }

    public void setServicetype(String servicetype) {
        this.servicetype = servicetype;
    }

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }

    public Integer getDevicetype() {
        return devicetype;
    }

    public void setDevicetype(Integer devicetype) {
        this.devicetype = devicetype;
    }

    public Integer getRemark() {
        return remark;
    }

    public void setRemark(Integer remark) {
        this.remark = remark;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "CommonRequest{" +
                "version='" + version + '\'' +
                ", token='" + token + '\'' +
                ", servicetype='" + servicetype + '\'' +
                ", deviceid='" + deviceid + '\'' +
                ", devicetype=" + devicetype +
                ", remark=" + remark +
                ", body='" + body + '\'' +
                '}';
    }
}
