public class LongestPalindromicSubString {

    public static String longestPalindrome(String s) {

        int n = s.length();
        if(n<2){
            return s;
        }
        boolean[][] dp = new boolean[n][n];

        for(int i = 0;i<n;i++){
            dp[i][i] = true;
        }

        int begin = 0;
        int maxLen = 1;
        char[] str = s.toCharArray();
        for(int j = 1; j<n; j++){
            for(int i = 0; i<j; i++){
                if(str[i]!=str[j]){
                    dp[i][j] = false;
                }else{
                    if(j-1-(i+1)<1){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if(dp[i][j] && j-i+1>maxLen){
                    maxLen = j-i+1;
                    begin = i;
                }
            }
        }

        return s.substring(begin, begin+maxLen);
    }

    public static void main(String[] args) {
        String str = "aacabdkacaa";
        System.out.println(longestPalindrome(str));
    }
}
