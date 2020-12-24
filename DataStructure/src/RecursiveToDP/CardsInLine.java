package RecursiveToDP;

//范围尝试
//一副牌，随意排列，两个人轮流选取两端的牌，问最后获胜者的拿到牌的最大值
public class CardsInLine {

    public static int win1(int[] arr){
        if(arr == null || arr.length ==0){
            return 0;
        }
        return Math.max(f(arr, 0, arr.length-1), s(arr, 0, arr.length-1));
    }

    //先手函数
    public static int f(int[] arr, int L, int R){
        if(L == R){
            return arr[L];
        }
        return Math.max(arr[L] + s(arr, L+1, R), arr[R]+s(arr, L, R-1));
    }

    //后手函数
    public static int s(int[] arr, int L, int R){
        if(L==R){
            return 0;
        }                       //先手选取arr[L]     //先手选取了arr[R]
        return Math.min(f(arr, L+1, R), f(arr, L, R-1));//对手会让你选最小的
    }

    public static int win2(int[] arr){
        if(arr == null || arr.length ==0){
            return 0;
        }
        int N = arr.length;
        int[][] f = new int[N][N];
        int[][] s = new int[N][N];

        for (int i = 0; i < N; i++) {
            f[i][i] = arr[i];
        }
        //s[i][i] = 0;
        for(int i =1;i<N;i++){
            int L = 0;
            int R = i;
            while(L<N && R<N){
                f[L][R] = Math.max(
                        arr[L] + s[L+1][R],
                        arr[R] + s[L][R-1]);
                s[L][R] = Math.min(
                        arr[L] + f[L+1][R],
                        arr[R] + f[L][R-1]);
                L++;
                R++;
            }
        }

        return Math.max(f[0][N-1], s[0][N-1]);
    }
}
