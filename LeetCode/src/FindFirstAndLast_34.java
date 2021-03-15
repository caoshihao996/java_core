import org.junit.Test;

public class FindFirstAndLast_34 {

    public int[] searchRange(int[] nums, int target) {

        if(nums.length==0){
            return new int[]{-1,-1};
        }
        int leftId = findFirstPosition(nums, target);
        int rightId = findLastPosition(nums, target);
        if(leftId==-1){
            return new int[]{-1,-1};
        }
        return new int[]{leftId, rightId};
    }

    public int findFirstPosition(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while(left<=right){
            int mid = left + (right - left) / 2;
            if(nums[mid]<target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        if(nums[left]==target){
            return left;
        }
        return -1;
    }

    public int findLastPosition(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while(left<=right){
            int mid = left + ((right - left) >> 1);
            if(nums[mid]>target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    @Test
    public void test(){
        System.out.println(findFirstPosition(new int[]{2,3,4,4,4,5,6}, 4));
        System.out.println(findLastPosition(new int[]{2,3,4,4,4,5,6}, 4));
        System.out.println(searchRange(new int[]{2,3,4,4,4,5,6}, 4)[0]+" "+searchRange(new int[]{2,3,4,4,4,5,6}, 4)[1]);
    }
}
