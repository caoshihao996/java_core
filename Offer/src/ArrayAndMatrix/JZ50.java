package ArrayAndMatrix;

import org.junit.Test;

/*
在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
也不知道每个数字重复几次。请找出数组中第一个重复的数字。 例如，如果输入长度为7的数组[2,3,1,0,2,5,3]，
那么对应的输出是第一个重复的数字2。没有重复的数字返回-1。
 */
public class JZ50 {

    public int duplicate (int[] numbers) {
        // write code here
        int length = numbers.length;
        if(numbers==null || length<=1){
            return -1;
        }

        for(int i=0;i<length;i++){
            while(numbers[i]!=i){
                if(numbers[i]==numbers[numbers[i]]){
                    return numbers[i];
                }
                swap1(numbers, i, numbers[i]);
            }
        }
        return -1;
    }

    public void swap1(int[] numbers, int i, int j){
        int t = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = t;
    }

    @Test
    public void test(){
        int[] arr = {6,3,2,0,2,5,0};
        System.out.println(duplicate(arr));
    }
}
