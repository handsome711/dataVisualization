package com.example.lecture.dataAnalyze;
public class NumChange {
    private String year;
    private String department;
    private String totalNum;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(String totalNum) {
        this.totalNum = totalNum;
    }

    public NumChange(String year, String department, String totalNum) {
        this.year = year;
        this.department = department;
        this.totalNum = totalNum;
    }
}
