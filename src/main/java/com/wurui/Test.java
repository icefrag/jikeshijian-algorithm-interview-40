package com.wurui;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: wurui
 * @create: 2018-11-28 15:20
 **/
public class Test {
    public static void main(String[] args) {
        List<Student> stuends = new ArrayList<>();

        Student student = null;
        for (int i = 0; i < 3; i++) {
            student = new Student();
            student.setName("小白:" + i);
            stuends.add(student);
        }

        System.out.println(stuends);
    }
}

class Student {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
