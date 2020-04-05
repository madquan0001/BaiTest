package com.example.baitest;

public class Number {

    private int number;


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n name:" + this.number);
        return sb.toString();
    }

}
