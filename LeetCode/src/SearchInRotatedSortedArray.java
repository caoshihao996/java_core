public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int n = nums.length;
        if(n==0)return -1;
        else if(n==1){
            return target==nums[0] ? 0 :-1;
        }
        int l = 0;
        int r = n - 1;
        while(l<r){
            int mid = l + (r - l)/2;
            if(nums[mid]==target)return mid;

            if(nums[0]<=nums[mid]){
                if(nums[0]<=target && nums[mid]>target){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }else{
                if(nums[mid]<target && target<=nums[n-1]){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
