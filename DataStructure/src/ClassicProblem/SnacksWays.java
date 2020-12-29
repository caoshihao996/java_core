package ClassicProblem;

public class SnacksWays {

    public static int way1(int[] arr,int w){
        if(arr == null || w <=0 ){
            return 0;
        }
        return process1(arr, 0, w);
    }

    //从左往右的经典模型
    //还剩余容量rest，arr[index..]自由选择
    //返回选择方案
    //index:0~N
    //rest:0~w
    private static int process1(int[] arr, int index, int rest) {
        if(rest<0){
            //-1表示没有方案的意思
            return -1;
        }
        //rest>=0
        if(index == arr.length){//决策路径有效
            return 1;
        }
        // index号零食，要 or 不要
        // index, rest
        // (index+1, rest)
        // (index+1, rest-arr[index])
        int next1 = process1(arr, index+1, rest);//不要
        int next2 = process1(arr, index+1, rest- arr[index]);
        return next1 + (next2 == -1 ? 0 : next2);
    }

    public static int ways2(int[] arr, int w){
        int N = arr.length;
        int[][] dp = new int[N+1][w+1];
        for(int i = 0;i<=w;i++){
            dp[N][i]=1;
        }
        for(int i = N-1;i>=0;i--){
            for (int j = 0; j < w; j++) {
                dp[i][j] = dp[i+1][j] + ((j-arr[i]>=0?dp[i+1][j-arr[i]]:0));
            }
        }
        return dp[0][w];
    }
}
