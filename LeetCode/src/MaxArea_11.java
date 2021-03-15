import java.util.Stack;

public class MaxArea_11 {

    public static int maxArea(int[] height) {

        if(height == null || height.length<2){
            return 0;
        }

        return getMax(height, 0, height.length-1);
    }

    public static int getMax(int[] height, int i, int j){
        if(i==j){
            return 0;
        }
        int curArea = Math.min(height[i], height[j])*(j-i);
        int maxArea = Math.max(curArea, Math.max(getMax(height,i+1, j), getMax(height,i,j-1)));
        return maxArea;
    }

    public static int dpWay(int[] height){
        if(height == null || height.length<2){
            return 0;
        }

        int n = height.length;
        int[][] dp = new int[n][n];
        for(int i = n-2; i>=0; i--){
            for(int j=i+1; j<n; j++){
                int curArea = Math.min(height[i], height[j])*(j-i);
                dp[i][j] = Math.max(curArea, Math.max(dp[i+1][j], dp[i][j-1]));
            }
        }
//        for(int j=1; j<n; j++){
//            for(int i=0; i<j;i++){
//                int curArea = Math.min(height[i], height[j])*(j-i);
//                dp[i][j] = Math.max(curArea, Math.max(dp[i+1][j], dp[i][j-1]));
//            }
//        }
        return dp[0][n-1];
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(dpWay(height));

    }
}
