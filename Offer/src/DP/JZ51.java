package DP;

import org.junit.Test;

/*
    给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
    不能使用除法。（注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
    对于A长度为1的情况，B无意义，故而无法构建，因此该情况不会存在。
 */
public class JZ51 {

    public int[] multiply(int[] A) {
        int n = A.length;
        int[] B = new int[n];
        for (int i = 0, product=1; i < n; product*=A[i],i++) {
            B[i]=product;
            System.out.println(B[i]);
        }
        for (int i = n-1, product = 1; i >= 0 ; product*=A[i], i--) {
            B[i] *= product;
            System.out.println(B[i]);
        }
        return B;
    }

    @Test
    public void test(){
        int[] A = {1,2,3,4,5,6};
        int[] B = multiply(A);
        for (int n : B){
            System.out.print(n+" ");
        }
    }
}
