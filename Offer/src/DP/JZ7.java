package DP;

/*
    大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。n≤39
 */
public class JZ7 {

    public int Fibonacci(int n) {
        if(n<=2)return 1;
        return Fibonacci(n-1)+(n-2);
    }

    public int F(int n){
        int[] dp = new int[n+1];
        if(n<=1)
            return 1;

        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    public int F1(int n){
        if(n<=1)
            return n;
        int a = 0,b=1,c=0;
        for(int i=2;i<=n;i++){
            c=a+b;
            a=b;
            b=c;
        }
        return c;
    }
}
