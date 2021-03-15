import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges_228 {

    public List<String> summaryRanges(int[] nums) {

        List<String> res = new ArrayList<>();
        int i = 0;
        int n = nums.length;
        while(i<n){
            int low = i;
            i++;
            while(i<n && nums[i]==nums[i-1]+1){
                i++;
            }
            int high = i - 1;
            StringBuffer temp = new StringBuffer(Integer.toString(nums[low]));
            if(low<high){
                temp.append("->");
                temp.append(Integer.toString(nums[high]));
            }
            res.add(temp.toString());
        }
        return res;
    }

    @Test
    public void test(){
        int[] nums = {0,2,3,4,6,8,9};
        List<String> res = summaryRanges(nums);
        for(String s : res){
            System.out.print(s+" ");
        }
    }
}
