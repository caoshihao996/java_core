package DP;

import org.junit.Test;

import java.util.Arrays;

/*
    五张牌，其中大小鬼为癞子，牌面为 0。判断这五张牌是否能组成顺子。
 */
public class JZ45 {

    public boolean isContinuous(int [] numbers) {
        if(numbers.length<5)
            return false;

        Arrays.sort(numbers);
        int cnt = 0;
        for (int num : numbers){
            if(num==0)
                cnt++;
        }

        for (int i = 0; i < numbers.length-1; i++) {
            if(numbers[i]==numbers[i+1])
                return false;
            cnt -= numbers[i+1] - numbers[i] -1;
        }
        return cnt>=0;
    }

    @Test
    public void test(){
        int[] numbers = {0,1,2,3,4};
        System.out.println(isContinuous(numbers));
    }
}
