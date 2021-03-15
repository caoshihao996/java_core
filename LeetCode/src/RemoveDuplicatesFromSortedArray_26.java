import org.junit.Test;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray_26 {

    public int removeDuplicates(int[] nums) {
       if(nums.length==0){
           return 0;
       }
        int i = 0;
        for(int j = 1; j < nums.length; j++){
            if(nums[i]!=nums[j]){
                i++;
                nums[i]=nums[j];
            }
        }
        return i+1;
    }



    @Test
    public void test(){
        int[] nums = {1,2};
        int len = removeDuplicates(nums);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i]+" ");
        }
    }
}
