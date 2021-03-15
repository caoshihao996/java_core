public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE && divisor==-1){
            return Integer.MAX_VALUE;
        }
        int sign = 0;
        if((dividend <0 && divisor>0) || (dividend>0 && divisor<0)){
            sign = -1;
        }
        if((dividend>0 && divisor>0) || (dividend<0 && divisor<0)){
            sign = 1;
        }
        dividend = -Math.abs(dividend);
        divisor = -Math.abs(divisor);
        if(dividend>divisor)return 0;
        int res = sign * div(dividend, divisor);
        return res;
    }

    public int div(int a, int b){
        if(a>b) return 0;
        int count = 1;
        int tb = b;
        while(tb+tb>=a && tb + tb <0){
            count += count;
            tb += tb;
        }
        return count + div(a-tb, b);
    }
}
