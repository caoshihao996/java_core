package BitOperations;

import java.util.Arrays;

/*
    一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
public class JZ40 {

    public int[] FindNumsAppearOnce (int[] array) {
        // write code here
        int[] result = new int[2];
        int xor = 0;
        for (int i = 0; i < array.length; i++) {
            xor ^= array[i];
        }
        xor = xor ^ -xor;
        for(int num : array){
            if((xor&num)==0)
                result[0] ^= num;
            else
                result[1] ^= num;
        }
        Arrays.sort(result);
        return result;
    }
}
