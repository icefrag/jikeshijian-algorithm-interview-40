package com.wurui.homework02;

/**
 * @description:
 * @author: wurui
 * @create: 2018-10-25 12:09
 **/
public class Main {
    public static void main(String[] args){
        Queue<Integer> queue = new Queue<>();
        
        for (int i = 0;i< 100; i++){
            queue.push(i);
        }

        for (int i = 0;i< 10; i++){
            System.out.println(queue.pop());
        }

        for (int i = 100;i< 100; i++){
            queue.push(i);
        }

        for (int i = 0;i< 1000; i++){
            System.out.println(queue.pop());
        }
    }
}
