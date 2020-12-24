package RecursiveToDP;

public class NQueens {

    public static int nums(int n){
        if(n<0){
            return 0;
        }
        int[] record = new int[n];//record[i]->i行的皇后，放在了第几列
        return process1(0, record, n);
    }

    //潜台词：record[0..i-1]的皇后，任何两个皇后一定都不共行、不共列、不共斜线
    //目前来到了第i行
    //record[0..i-1]表示之前的行，放了皇后位置
    //n代表整体一共有多少行 0-n-1行
    //返回值，摆完所有皇后，合理的摆法有多少种
    public static int process1(int i, int[] record, int n){
        if(i == n){//终止行
            return 1;
        }
        int res = 0;
        for(int j = 0; j<n; j++){//当前行在i行，尝试i行所有的列->j
            //当前i行的皇后，放在j列，会不会和之前(0..i-1)的皇后，不共行共列或者共斜线
            //如果是，认为有效
            //如果不是，认为无效
            if(isValid(record, i, j)){
                record[i] = j;
                res += process1(i+1, record, n);
            }
        }
        return res;
    }

    private static boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) {//之前的某个k行皇后
            if(j==record[k] || Math.abs(j-record[k])==Math.abs(i-k)){
                return false;
            }
        }
        return true;
    }

    //请不要超过32皇后问题
    public static int num2(int n){
        if(n<1 || n>32){
            return 0;
        }
        //如果你是9皇后问题，limit 最右9个是1，其它都是0
        int limit = n == 32 ? -1 : (1<<n) -1;
        return process2(limit, 0, 0, 0);
    }

    //limit 划定了问题的规模，是固定的
    //colLim 列的限制，1的位置不能放皇后，0的位置可以
    //leftDiaLim 左斜线的限制，1的位置不能放皇后，0的位置可以
    //rightDiaLim 右斜线的限制，1的位置不能放皇后，0的位置可以
    public static int process2(int limit, int colLim, int leftDiaLim, int rightDiaLim){
        if(colLim == limit){//base case
            return 1;
        }
        //所有候选皇后的位置，都在pos
        //colLim | leftDiaLim | rightDigLim -> 总限制
        //~(colLim | leftDiaLim | rightDigLim) -> 左侧的一坨0干扰，右侧每个1可尝试
        //所有可以放皇后都在pos上
        int pos = limit & (~(colLim | leftDiaLim | rightDiaLim));
        int mostRightOne = 0;
        int res = 0;
        while(pos != 0){
            //提取中pos最右侧的1，剩下位置都是0
            mostRightOne = pos & (~pos + 1);
            pos = pos - mostRightOne;
            res += process2(limit, colLim | mostRightOne, (leftDiaLim|mostRightOne)<<1,
                    (rightDiaLim|mostRightOne)>>>1);
        }
        return res;
    }
}
