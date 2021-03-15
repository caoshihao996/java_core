package DP;

import org.junit.Test;

/*
    我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？

    比如n=3时，2*3的矩形块有3种覆盖方法：
 */
public class JZ10 {

    public int RectCover(int target) {
        if(target<=3)
            return target;
        int a=2, b=3, c=0;
        for (int i = 4; i <= target; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    @Test
    public void test(){
        System.out.println(RectCover(4));
    }
}
