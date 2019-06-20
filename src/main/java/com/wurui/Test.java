package com.wurui;

/**
 * @description:
 * @author: wurui
 * @create: 2018-11-28 15:20
 **/
public class Test {
    public static double getTotal(int a, int n) {
        double total = 0;
        for (int i = 1; i <= n; i++) {
            total += a * (1 - Math.pow(10,i))/(1 - 10);
        }

        return total;
    }

    public static void main(String[] args) {
//        System.out.println(Test.getTotal(1,5));
        String s = "0";
        Integer.parseInt(s);
        s = "0.0";
        if (Float.parseFloat(s) == 0){
            System.out.println("xxx");
        }
    }

}
