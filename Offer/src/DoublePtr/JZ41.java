package DoublePtr;

import java.util.ArrayList;


/*
    小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
    但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久
    他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快
    的找出所有和为S的连续正数序列? Good Luck!
 */
public class JZ41 {


    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {

        if(sum<3){
            return new ArrayList<>();
        }

        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        int start = 1, end = 2;
        int curSum = 3;
        while(end<sum){
            if(curSum > sum){
                curSum -= start;
                start++;
            }else if (curSum<sum){
                end++;
                curSum += end;
            }else {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = start; i <= end; i++) {
                    list.add(i);
                }
                ret.add(list);
                curSum -= start;
                start++;
                end++;
                curSum += end;
            }
        }
        return ret;
    }
}
