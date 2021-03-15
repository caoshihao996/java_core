package BinarySearch;

import org.junit.Test;

/*
    给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
    保证base和exponent不同时为0
 */
public class JZ12 {


    public double Power(double x, int n){
        boolean isNegative = false;
        if(n<0){
            n=-n;
            isNegative=true;
        }
        double res = pow(x,n);
        return isNegative?1/res:res;
    }

    private double pow(double x, int n){
        if(n==0)return 1;
        if(n==1)return x;
        double res = pow(x, n/2);
        res = res*res;
        if(n%2!=0)res*=x;
        return res;
    }

    @Test
    public void test(){
        System.out.println(Power(2,-3));
    }
}
