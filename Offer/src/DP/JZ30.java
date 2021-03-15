package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*

 */
public class JZ30 {

    public static int FindGreatestSumOfSubArray(int[] array) {

        if (array==null || array.length==0)
            return 0;
        int more = Integer.MIN_VALUE;
        int sum = 0;
        for (int n : array){
            sum = sum<=0 ? n : sum + n;
            more = Math.max(more, sum);
            System.out.println(more);
        }
        return more;
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String str = in.nextLine();
//        String[] s = str.split(" ");
//        int[] array = new int[s.length];
        int[] array = {1,-2,3,10,-4,7,2,-5};
//        for (int i = 0; i < s.length; i++) {
//            array[i] = Integer.parseInt(s[i]);
//        }
        System.out.println(FindGreatestSumOfSubArray(array));
    }
}
