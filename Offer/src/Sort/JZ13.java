package Sort;

/*
    输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，
    偶数和偶数之间的相对位置不变。
 */
public class JZ13 {

    public int[] reOrderArray (int[] array) {
        // write code here
        int oddCnt = 0;
        for(int x : array)
            if(!isEven(x))
                oddCnt++;
        int[] copy = new int[array.length];
        int i=0,j=oddCnt;
        for (int num:array){
            if(num%2==1)
                copy[i++]=num;
            else
                copy[j++]=num;
        }
        return copy;
    }

    private boolean isEven(int x){
        return x%2==0;
    }
}
