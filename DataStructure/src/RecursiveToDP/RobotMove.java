package RecursiveToDP;

public class RobotMove {

    public static int ways1(int N, int M, int K, int P){
        //参数无效直接返回0
        if(N<2 || K<1 || M<1 || M>N || P<1 || P>N){
            return 0;
        }
        //总共N个位置，从M点出发，还剩K步，返回最终能到达P的方法数
        return walk(N, M, K, P);
    }

    //N:位置1~N, 固定参数
    //cur : 当前在cur位置， 可变参数
    //rest : 还剩res步没有走，可变参数
    //P:最终目标位置是P, 固定参数
    //该函数的含义：只能在1~N这些位置上移动，当前在cur位置，走完rest步之后，停在P位置的方法
    private static int walk(int N, int cur, int rest, int P) {
        //如果没有剩余步数了，当前的cur位置就是最后的位置
        //如果最后的位置停在P上，那么之前做的移动是有效的
        //如果最后的位置没在P上，那么之前做的移动式无效的
        if(rest==0){
            return cur == P ? 1 : 0;
        }
        //如果还有rest步要走，而当前的cur位置在1位置上，那么当前这步只能从1走向2
        //后续的过程就是，来到2位置上，还剩rest-1步要走
        if(cur == 1){
            return walk(N, 2, rest -1, P);
        }
        //如果还有rest步要走，而当前的cur位置在N位置上，那么当前这步只能从N走向N-1
        //后续的过程就是，来到N-1位置上，还剩rest-1步要走
        if(cur == N){
            return walk(N, N-1, rest-1, P);
        }

        //如果还有rest步要走，而当前的cur位置在中间位置上，那么当前这步可以想左也可以向右
        //走向左之后，后续的过程就是，来到cur-1位置上，还剩rest-1步要走
        //走向右之后，后续的过程就是，来到cur+1位置上，还剩rest-1步要走
        //走向左右是截然不同的方法，所以总方法数都要算上
        return walk(N, cur+1, rest-1, P) + walk(N, cur -1, rest -1, P);
    }


    public static int waysCache(int N, int M, int K, int P){
        //参数无效直接返回0
        if(N<2 || K<1 || M<1 || M>N || P<1 || P>N){
            return 0;
        }

        int[][] dp = new int[N+1][K+1];
        for(int row=0;row<=N;row++){
            for(int col=0;col<=K;col++){
                dp[row][col] = -1;
            }
        }

        return walkCache(N, M, K, P, dp);
    }

    //吧所有的cur和rest的组合，返回结果，加入到缓存中
    private static int walkCache(int N, int cur, int rest, int P, int[][] dp) {
        if(dp[cur][rest] != -1){
            return dp[cur][rest];
        }

        int ways = 0;

        if(rest==0){
            dp[cur][rest] = cur == P ? 1 : 0;
            return dp[cur][rest];
        }
        if(cur == 1){
            dp[cur][rest] = walkCache(N, 2, rest -1, P, dp);
            return dp[cur][rest];
        }
        if(cur == N){
            dp[cur][rest] = walkCache(N, N-1, rest-1, P, dp);
            return dp[cur][rest];
        }
        return walkCache(N, cur+1, rest-1, P, dp) + walkCache(N, cur -1, rest -1, P, dp);
    }
}
