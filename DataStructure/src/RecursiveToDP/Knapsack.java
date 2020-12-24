package RecursiveToDP;

//从左往右的尝试模型2
public class Knapsack {

    //不变：w[] v[] bag
    //index... 最大价值
    //0...index-1上做了货物的选择，使得你已经达到的重量是多少alreadyW
    //如果返回-1认为没有方案，如果不返回-1，则认为返回的值是真实的值
    //函数返回值为index之后的最大价值
    public static int process(int[] w, int[] v, int index, int alreadyW, int bag){
        if(alreadyW > bag){
            return -1;
        }
        if(index == w.length){
            return 0;
        }
        int p1 = process(w, v, index+1, alreadyW, bag);//不选择index位置上的货物

        int p2Next = process(w, v, index +1, alreadyW + w[index], bag);//选择当前位置上的货物
        int p2 = -1;
        if(p2Next != -1){
            p2 = v[index] + p2Next;
        }
        return Math.max(p1, p2);
    }

    //只剩下rest空间
    //index...货物自由选择，但是剩余空间不要小于0
    //返回index...货物能够获得的最大价值
    public static int process(int[] w, int[] v, int index, int rest){
        if(rest<0){
            return -1;
        }
        //rest>0
        if(index == w.length){
            return 0;
        }

        int p1 = process(w, v, index+1, rest);//没有选择index位置上的货物

        int p2 = -1;
        int p2next = process(w, v, index+1, rest - w[index]);
        if(p2next != -1){
            p2 = v[index] + p2next;
        }
        return Math.max(p1, p2);
    }

    public static int maxValue(int[] w, int[] v, int bag){
        return process(w, v, 0, bag);
    }


    //动态规划的解法
    //暴力递归的决策就是动态规划的转移
    public static int dpWay(int[] w, int[] v, int bag){
        int N = w.length;
        int[][] dp = new int[N+1][bag+1];//dp[N][...]=0
        for(int index=N-1;index>=0;index--){
            for(int rest = 0;rest<=bag;rest++){//rest<0是无效解

                //dp[index][rest]=?;
                int p1 = dp[index+1][rest];
                int p2 = -1;
                if(rest - w[index]>=0){
                    p2 = v[index] + dp[index+1][rest-w[index]];
                }
                dp[index][rest] = Math.max(p1,p2);

//                int p1 = process(w, v, index+1, rest);//没有选择index位置上的货物
//
//                int p2 = -1;
//                int p2next = process(w, v, index+1, rest - w[index]);
//                if(p2next != -1){
//                    p2 = v[index] + p2next;
//                }
//                return Math.max(p1, p2);
            }
        }
        return dp[0][bag];
    }
}
