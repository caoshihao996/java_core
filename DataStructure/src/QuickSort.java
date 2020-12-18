public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1,4,6,9,11,2,3,5,8,7};
        sort(arr, 0, arr.length - 1);
        print(arr);
    }

    public static void sort(int[] arr, int left, int right){
        if(left>=right)return;

        int mid = partition(arr, left, right);
        sort(arr,left,mid-1);
        sort(arr,mid+1,right);
    }

    public static int partition(int[] arr, int start, int end){
         int pivot = arr[end];
         int left = start;
         int right = end - 1;
         while(left <= right){
             while(left <= right && arr[left]<=pivot)left++;
             while(left <= right && arr[right]>pivot)right--;

             if(left<right)swap(arr, left, right);
         }
         swap(arr, left, end);


         return left;
    }

    public static void swap(int[] arr, int i, int j){
//        arr[j] = arr[i] + arr[j];
//        arr[i] = arr[j] - arr[i];
//        arr[j] = arr[j] - arr[i];
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void print(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
