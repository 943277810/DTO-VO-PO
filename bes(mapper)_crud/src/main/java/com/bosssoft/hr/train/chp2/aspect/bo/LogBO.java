package com.bosssoft.hr.train.chp2.aspect.bo;

/**
 * @author ztanker
 * @date 2019-07-25 23:50
 * @Description
 */
public class LogBO {
    private String className;
    private String methodName;
    private String params;
    private Long exeuTime;
    private String remark;
    private String createDate;

    public LogBO() {
    }

    public LogBO(String className, String methodName, String params, Long exeuTime, String remark, String createDate) {
        this.className = className;
        this.methodName = methodName;
        this.params = params;
        this.exeuTime = exeuTime;
        this.remark = remark;
        this.createDate = createDate;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public Long getExeuTime() {
        return exeuTime;
    }

    public void setExeuTime(Long exeuTime) {
        this.exeuTime = exeuTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "LogBO{" +
                "className='" + className + '\'' +
                ", methodName='" + methodName + '\'' +
                ", params='" + params + '\'' +
                ", exeuTime=" + exeuTime +
                ", remark='" + remark + '\'' +
                ", createDate='" + createDate + '\'' +
                '}';
    }
}
