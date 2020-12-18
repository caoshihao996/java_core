public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {1,4,7,8,3,6,9};
        sort(arr, 0, arr.length-1);
        print(arr);
    }

    private static void sort(int[] arr, int left, int right){
        if(left==right)return;
        //分成两半
        int mid = left + (right-left)/2;
        //左边排序
        sort(arr,left,mid);
        //右边排序
        sort(arr,mid+1,right);
        merge(arr, left, mid+1, right);
    }

    private static void merge(int[] arr, int left, int right, int rightBound) {
        int mid = right - 1;
        int[] temp = new int[rightBound - left +1];

        int i = left;
        int j = right;
        int k =0;
        while(i<=mid && j <= rightBound){
            if(arr[i]<=arr[j]){
                temp[k++] = arr[i++];
//                i++;
//                k++;
            }else {
                temp[k++] = arr[j++];
//                j++;
//                k++;
            }
        }
        while(i<=mid)temp[k++]=arr[i++];
        while(j<=rightBound)temp[k++]=arr[j++];

        for(int m=0;m<temp.length;m++)arr[left+m]=temp[m];
        //print(temp);
    }

    private void swap(int[] arr, int i, int j){
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }

    private static void print(int[] arr){
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
