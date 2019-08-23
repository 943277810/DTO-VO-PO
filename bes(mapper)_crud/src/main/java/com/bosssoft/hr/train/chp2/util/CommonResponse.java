package com.bosssoft.hr.train.chp2.util;

/**
 * @author 94327
 */
public class CommonResponse {
    //head
    private String version;
    private String code;
    private String message;
    private String remark;
    //body
    private String body;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
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
        return "CommonResponse{" +
                "version='" + version + '\'' +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", remark='" + remark + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
