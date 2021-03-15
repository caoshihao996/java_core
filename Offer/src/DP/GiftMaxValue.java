package DP;

import org.junit.Test;

/*
    给定一个6*6的矩阵board，其中每个元素为对应格子的礼物价值,左上角为[0,0],请返回能获得的最大价值，
    保证每个礼物价值大于100小于1000。
 */
public class GiftMaxValue {

    public int getMost(int[][] board) {
        // write code here
        if(board==null || board.length==0 || board[0].length==0)
            return 0;
        int rows = board.length;
        int cols = board[0].length;
        int[][] dp = new int[rows][cols];
        dp[0][0] = board[0][0];
        for (int i = 1; i < rows; i++) {
            dp[i][0] = board[i][0]+dp[i-1][0];
        }
        for(int j=1;j<cols;j++){
            dp[0][j] = board[0][j]+dp[0][j-1];
        }
        for(int i=1;i<rows;i++){
            for (int j = 1; j < cols; j++) {
                dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j])+board[i][j];
            }
        }
        return dp[rows-1][cols-1];
    }

    @Test
    public void test(){
        int[][] board = {{1,20,3,8},{12,2,9,6},{5,7,4,11},{3,7,16,5}};
        System.out.println(getMost(board));
    }
}
