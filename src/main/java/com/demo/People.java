package com.demo;

public class People {
    String sex;
    String age;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }


    public void eat (){
        System.out.println("啥都吃!");
    }
    public void sleep (){
        System.out.println("吃饱就睡");
    }
    public void work (){
        System.out.println("睡醒再吃");
    }
}
