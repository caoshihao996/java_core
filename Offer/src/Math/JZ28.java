package Math;

/*
    数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
    由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class JZ28 {

    public int MoreThanHalfNum_Solution(int [] array) {

        int len = array.length;
        if (len==1)
            return array[0];
        int[] h = new int[len];

        for (int i = 0; i < len; i++) {
            h[array[i]]++;
        }
        for (int i = 0; i < len; i++) {
            if(h[i]>=(len/2)+1)
                return i;
        }
        return 0;
    }
}
