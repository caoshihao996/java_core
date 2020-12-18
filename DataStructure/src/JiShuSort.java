import java.lang.reflect.Array;
import java.util.Arrays;

public class JiShuSort {

    public static void main(String[] args) {
        int[] arr = {2,4,2,3,7,1,1,0,0,5,6,9,8,5,7,4,0,9};
        int[] result = sort(arr);
        System.out.println(Arrays.toString(result));
    }
    static int[] sort(int[] arr){
        int[] result = new int[arr.length];
        int[] count = new int[10];//0-9

        for(int i =0;i<arr.length;i++){
            count[arr[i]]++;
        }
        System.out.println(Arrays.toString(count));

//        for(int i=0, j=0;i<count.length;i++){
//            while(count[i]-->0)result[j++]=i;
//        }

        for(int i=1;i<count.length;i++){
            count[i] = count[i] + count[i-1];
        }
        System.out.println(Arrays.toString(count));
        for(int i=arr.length-1;i>=0;i--){
            result[--count[arr[i]]]=arr[i];
        }
        return result;
    }

    static void finfMax(int[] a, int n){
        for(int j=0;j<n;j++){
            if(a[j]>a[j+1])swap(a,j,j+1);
        }
    }
    static void swap(int[] a ,int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
