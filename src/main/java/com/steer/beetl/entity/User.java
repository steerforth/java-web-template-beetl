package com.steer.beetl.entity;

public class User {
    enum Gender{
        MALE,
        FEMALE
    }
    private String name;
    private int age;
    private Gender gender;

    public static String getMoney(){
        return "100元";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
