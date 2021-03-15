package StackQueueHeap;

import java.util.Stack;

/*
    定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））
 */
public class JZ20 {


    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int node){
        dataStack.push(node);
        if(minStack.isEmpty()){
            minStack.push(node);
        }else {
            minStack.push(Math.min(minStack.peek(),node));
        }
    }

    public void pop(){
        dataStack.pop();
        minStack.pop();
    }

    public int top(){
        return dataStack.peek();
    }

    public int min(){
        return minStack.peek();
    }
}
