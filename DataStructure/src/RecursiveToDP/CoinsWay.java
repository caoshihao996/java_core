package RecursiveToDP;

//使用一组无重复面值的货币凑成目标值的方法
public class CoinsWay {

    //arr中都是正数且无重复值，返回组成aim的方法数
    public static int ways1(int[] arr, int aim){
        if(arr == null || arr.length == 0 || aim<0){
            return 0;
        }
        return process1(arr, 0, aim);
    }

    //可以自由使用arr[index...]所有的面值，每一种面值都可以使用任意张
    //组成rest,有多少中方法
    private static int process1(int[] arr, int index, int rest) {
        if(rest < 0){
            return 0;
        }
        //rest>=0
        if(index == arr.length){//没有货币可以选择了
            return rest == 0 ? 1 : 0;
        }
        //当前有货币，arr[index]
        int ways = 0;
        for (int zhang = 0; zhang * arr[index] <= rest; zhang++){
            ways += process1(arr, index+1, rest-(zhang*arr[index]));
        }
        return ways;
    }

    public static int ways2(int[] arr, int aim){
        if(arr == null || arr.length == 0 || aim<0){
            return 0;
        }
        int[][] dp = new int[arr.length+1][aim+1];
        //一开始所有的过程，都没有计算
        //dp[..][..]=-1
        for(int i=0;i<dp.length;i++){
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return process2(arr, 0, aim, dp);
    }

    //如果index和rest的参数组合,是没算过的，dp[index][rest] = -1
    //如果index和rest的参数组合，算过的，dp[index][rest] > -1
    private static int process2(int[] arr, int index, int rest, int[][] dp) {
        if(dp[index][rest] != -1){
            return dp[index][rest];
        }

        //rest>=0
        if(index == arr.length){//没有货币可以选择了
            dp[index][rest] = rest == 0 ? 1 : 0;
            return dp[index][rest];
        }
        //当前有货币，arr[index]
        int ways = 0;
        for (int zhang=0;zhang*arr[index]<=rest;zhang++){
            ways += process2(arr, index+1, rest-(zhang*arr[index]), dp);
        }
        dp[index][rest] = ways;
        return ways;
    }

    public static int ways3(int[] arr, int aim){
        if(arr == null || arr.length == 0 || aim<0){
            return 0;
        }
        int N = arr.length;
        int[][] dp = new int[N+1][aim+1];

        dp[N][0] = 1;//dp[N][1..aim]=0

        for(int index=N-1;index>=0;index--){
            for(int rest = 0; rest<=aim; rest++){
                int ways = 0;
                for (int zhang=0;zhang*arr[index]<=rest;zhang++){
                    ways += dp[index+1][rest-(zhang*arr[index])];
                }
                dp[index][rest] = ways;
            }
        }
        return dp[0][aim];
    }

    public static int ways4(int[] arr, int aim){
        if(arr == null || arr.length == 0 || aim < 0){
            return 0;
        }
        int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];
        dp[N][0] = 1;//dp[N][1..aim]=0
        for(int index = N-1; index >= 0; index--){
            for(int rest=0;rest<=aim;rest++){
                dp[index][rest] = dp[index+1][rest];
                if(rest - arr[index]>=0){
                    dp[index][rest] += dp[index][rest-arr[index]];
                }
            }
        }
        return dp[0][aim];
    }
}
