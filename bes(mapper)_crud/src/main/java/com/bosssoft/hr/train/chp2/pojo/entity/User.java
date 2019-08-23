package com.bosssoft.hr.train.chp2.pojo.entity;

import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author 94327
 */
@Repository
@Table(name = "learn")
public class User implements Serializable {
    @Id
    public Integer id;
    public String name;
    public String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
