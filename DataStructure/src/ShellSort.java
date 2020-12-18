public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {5,4,6,8,2,1};

        int h =1 ;
        while(h<=arr.length/3){
            h = h*3+1;
        }

        for(int gap = h; gap > 0 ; gap =(gap-1)/3){
            for(int i=gap;i<arr.length;i++){
                int j = i;
                while(j-gap>=0 && arr[j]<arr[j-gap]){
                    swap(arr, j,j-gap);
                    j = j - gap;
                }
            }
        }

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    private static void swap(int[] arr, int j, int i) {

//        int temp = arr[j];
//        arr[j] = arr[i];
//        arr[i] = temp;
        arr[j] = arr[j]+arr[i];
        arr[i] = arr[j] - arr[i];
        arr[j] = arr[j] - arr[i];
    }
}
