package DoublePtr;

import java.util.ArrayList;

public class JZ42 {

    /*
        输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
     */

    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        if(array==null || array.length<=1){
            return new ArrayList<>();
        }

        ArrayList<Integer> ret = new ArrayList<>();
        int left=0,right=array.length-1;
        while(left<right){
            if(array[left]+array[right]==sum){
                ret.add(array[left]);
                ret.add(array[right]);
                return ret;
            }
            if(array[left]+array[right]<sum){
                left++;
            }else {
                right--;
            }
        }
        return ret;
    }
}
