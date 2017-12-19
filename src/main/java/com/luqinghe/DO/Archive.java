package com.luqinghe.DO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by qinghe on 2017/12/17.
 */
@Entity
public class Archive implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    /**
     * 档案转递地址
     */
    private String address;
    /**
     * 档案转递地址
     */
    private String stuName;
    /**
     * 号码（学号）
     */
    private String stuNum;
    /**
     * 机要编号
     */
    private String confidentialNum;
    /**
     * 年份
     */
    private Integer year;

    public Archive() {
    }

    public Archive(Integer id, String address, String stuName, String stuNum, String confidentialNum, Integer year) {
        super();
        this.id = id;
        this.address = address;
        this.stuName = stuName;
        this.stuNum = stuNum;
        this.confidentialNum = confidentialNum;
        this.year = year;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public String getConfidentialNum() {
        return confidentialNum;
    }

    public void setConfidentialNum(String confidentialNum) {
        this.confidentialNum = confidentialNum;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Archive{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuNum='" + stuNum + '\'' +
                ", confidentialNum='" + confidentialNum + '\'' +
                ", year=" + year +
                '}';
    }
}
