package arrayTest;

import java.util.Arrays;

public class ArraysTest {
    public static void main(String[] args){
        int[] arr1 = new int[]{1,2,3,4};
        int[] arr2 = new int[]{1,3,2,4};
        boolean isEquals = Arrays.equals(arr1,arr2);
        System.out.println(isEquals);

        System.out.println(Arrays.toString(arr1));

        Arrays.fill(arr1,10);
        System.out.println(Arrays.toString(arr1));

        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = new int[]{23,43,454,76,987,3,453,0,2};//无序返回维负数
        System.out.println(Arrays.toString(arr3));
        int index = Arrays.binarySearch(arr2,2);
        System.out.println(index);

        int[] arr = new int[]{1,2,3};
        arr = null;
        //System.out.println(arr[1]);

        int[][] arr4 = new int[4][];
        //System.out.println(arr4[0]);
    }
}
