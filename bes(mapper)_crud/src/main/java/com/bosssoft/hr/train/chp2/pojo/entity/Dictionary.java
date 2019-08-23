package com.bosssoft.hr.train.chp2.pojo.entity;

import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author ztanker
 * @date 2019-07-24 11:22
 * @Description
 */

@Repository
@Table(name = "t_dictionary")
public class Dictionary implements Serializable {

    @Id
    private Long categoryId;

    private String name;
    private String category;
    private String value;
    private String remark;
    private Byte status;
    private Long orgId;
    private Long createdBy;
    private Date createdTime;
    private Long updatedBy;
    private Date updatedTime;
    private Long version;

    public Dictionary() {
    }

    public Dictionary(Long categoryId, String name, String category, String value, String remark, Byte status, Long orgId, Long createdBy, Date createdTime, Long updatedBy, Date updatedTime, Long version) {
        this.categoryId = categoryId;
        this.name = name;
        this.category = category;
        this.value = value;
        this.remark = remark;
        this.status = status;
        this.orgId = orgId;
        this.createdBy = createdBy;
        this.createdTime = createdTime;
        this.updatedBy = updatedBy;
        this.updatedTime = updatedTime;
        this.version = version;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "TDictionary{" +
                "categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", value='" + value + '\'' +
                ", remark='" + remark + '\'' +
                ", status=" + status +
                ", orgId=" + orgId +
                ", createdBy=" + createdBy +
                ", createdTime=" + createdTime +
                ", updatedBy=" + updatedBy +
                ", updatedTime=" + updatedTime +
                ", version=" + version +
                '}';
    }
}
