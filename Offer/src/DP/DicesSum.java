package DP;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
    把 n 个骰子扔在地上，求点数和为 s 的概率.
 */
public class DicesSum {

    public List<Map.Entry<Integer, Double>> dicesSum(int n){
        final int face = 6;
        final int pointSum = face * n;
        long[][] dp = new long[n+1][pointSum+1];

        for (int i = 1; i <= face; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= pointSum; j++) {//使用i个骰子最小点数为i
                for (int k = 0; k <= face; k++) {
                    dp[i][j] += dp[i-1][j-k];
                }
            }
        }

        final double totalNum = Math.pow(6,n);
        List<Map.Entry<Integer, Double>> ret = new ArrayList<>();
        for (int i = 0; i <= pointSum ; i++) {
            ret.add(new AbstractMap.SimpleEntry<>(i, dp[n][i]/totalNum));
        }
        return ret;
    }

}
