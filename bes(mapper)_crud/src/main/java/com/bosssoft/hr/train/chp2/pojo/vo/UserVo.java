package com.bosssoft.hr.train.chp2.pojo.vo;

import javax.persistence.Id;

/**
 * @author 94327
 */
public class UserVo {
    @Id
    public Integer id;
    public String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
