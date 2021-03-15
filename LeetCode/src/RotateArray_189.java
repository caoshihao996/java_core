import org.junit.Test;

public class RotateArray_189 {

    public void rotate(int[] nums, int k) {
        if (nums.length<=1){
            return;
        }
        int length  = nums.length;
//        if(length<k){
//            k = k - length;
//        }
        k = k % length;
        int[] arr = new int[length];
        for(int i=0, j=length-k; i<k; i++,j++){
            arr[i] = nums[j];
        }
        for(int i=k, j=0; i<length; i++,j++){
            arr[i] = nums[j];
        }
        for(int i=0;i<length;i++){
            nums[i] = arr[i];
        }
    }

    @Test
    public void test(){
        int[] nums = {1,2,3,4,5,6,7};
        rotate(nums, 3);
        for(int i=0; i< nums.length; i++){
            System.out.print(nums[i]+" ");
        }
    }
}
