package DoublePtr;


/*
    汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
    对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环
    左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 */
public class JZ43 {

    public String LeftRotateString(String str,int n) {
        if(n>=str.length()){
            return str;
        }
        char[] chars = str.toCharArray();
        reverse(chars, 0, n-1);
        reverse(chars, n, chars.length-1);
        reverse(chars, 0, chars.length-1);
        return new String(chars);
    }

    public void reverse(char[] c, int i, int j){
        while(i<j){
            swap(c, i++, j--);
        }
    }

    public void swap(char[] c, int i, int j){
        char t = c[i];
        c[i] = c[j];
        c[j] = t;
    }
}
