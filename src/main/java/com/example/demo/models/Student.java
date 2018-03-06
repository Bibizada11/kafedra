package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String studName;
    private int year;

    public Student() {
        this.studName = "" ;
        this.year = 0 ;
    }

    public Student(String bookName, int year) {
        this.studName = studName;
        this.year = year;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getstudName() {
        return studName;
    }

    public void setstudName(String bookName) {
        this.studName = studName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
