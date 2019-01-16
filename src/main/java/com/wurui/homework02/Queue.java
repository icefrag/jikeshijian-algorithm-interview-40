package com.wurui.homework02;

import java.util.Stack;

/**
 * @description: 用栈实现队列
 * @author: wurui
 * @create: 2018-10-25 11:23
 **/
public class Queue<E> {
    private Stack<E> input;
    private Stack<E> output;

    public Queue(){
        input = new Stack<>();
        output = new Stack<>();
    }

    public void push(E e){
        input.push(e);
    }

    public E peek(){
        if (output.isEmpty()){
            int size = input.size();
            for(int i = 0; i < size; i ++){
                output.push(input.pop());
            }
        }
        return output.peek();
    }

    public E pop(){
        if (output.isEmpty()){
            int size = input.size();
            for(int i = 0; i < size; i ++){
                output.push(input.pop());
            }
        }
        return output.pop();
    }

}
