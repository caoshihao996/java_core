package arrayTest;

public class ArrayTest2 {
    public static void main(String[] args){
        String[] arr = new String[]{"AA","BB","CC","DD","EE"};
        for(int i=0;i<arr.length/2;i++){
            String temp = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = temp;
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
        }

        for(int i=0,j=arr.length-1;i<j;i++,j--){
            String temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
        }
        System.out.println();
        String desStr = "BB";
        boolean iFound = false;
        for(int i=0;i<arr.length;i++){
            if(desStr.equals(arr[i])) {
                System.out.println(i);
                iFound = true;
                break;
            }
        }
        if(!iFound){
            System.out.println("not found");
        }

        //二分法查找必须有序
        int[] arr1 = new int[]{0,1,2,3,4,5,6,7,8};
        int dest1 = 9;
        int start = 0;
        int end = arr1.length-1;

        while(start<=end){
            int middle = (start+end)/2;
            if(dest1==arr1[middle]){
                System.out.println(middle);
                break;
            }else if(arr1[middle]>dest1){
                end = middle-1;
            }else {
                start = middle+1;
            }
        }
    }
}
