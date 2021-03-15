package BinarySearch;

/*
    把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
    输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
    NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class JZ6 {

    public int minNumberInRotateArray(int[] array){

        int left = 0, right = array.length-1;

        while (left<right){
            int mid = left + (right-left)/2;
            if(array[left]==array[mid] && array[mid]==array[right])
                return minNumber(array, left, right);
            else if(array[mid]<=array[right])
                right = mid;
            else
                left = mid + 1;
        }
        return array[left];
    }

    private int minNumber(int[] nums, int l, int r){
        for (int i = l; i < r; i++) {
            if(nums[i]>nums[i+1])
                return nums[i+1];
        }
        return nums[l];
    }
}
