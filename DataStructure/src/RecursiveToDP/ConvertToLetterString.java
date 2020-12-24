package RecursiveToDP;

//将数字转化为字母共有多少种方法
//从左往右的尝试模型1
public class ConvertToLetterString {


    public static int number(String str){
        if(str == null || str.length() == 0){
            return 0;
        }
        return process(str.toCharArray(), 0);
    }

    //str[0...i-1]已经转化完了，固定了
    //i之前的位置，如何转化已经做过决定了，不用再关心
    //i.. 有多少种转化的结果
    public static int process(char[] str, int i){
        if(i == str.length){
            return 1;
        }
        if(str[i] == '0'){
            return 0;
        }

        //i没有到终止位置
        //str[i]字符不是‘0’
        if(str[i] == '1'){
            int res = process(str, i + 1);//i自己作为单独的部分，后续有多少种方法
            if(i+1<str.length){
                res += process(str, i+2);//（i-i+1）作为一个的部分，后续有多少种方法
            }
            return res;
        }

        if(str[i] == '2'){
            int res = process(str, i + 1);//i自己作为单独的部分，后续有多少种方法
            if(i+1<str.length && str[i+1]<='6' && str[i+1]>='0'){
                res += process(str, i+2);//（i - i+1）作为一个单独的部分
            }
            return res;
        }
        //str[i] == '3' ~ '9'
        return process(str, i+1);//此时i位置必须单独转化
    }

    public static int dpWays(String s){
        if(s == null || s.length() == 0){
            return 0;
        }
        char[] str = s.toCharArray();
        int N = str.length;
        int[] dp = new int[N+1];
        dp[N] = 1;

        for(int i = N-1;i>=0;i--){
            //dp[i] = ?;
            if(str[i] == '0'){
                dp[i] = 0;
            }else if(str[i]=='1'){
                dp[i]=dp[i+1];
                if(i+1<str.length){
                    dp[i] += dp[i+2];
                }
            }else if(str[i]=='2'){
                dp[i] = dp[i+1];
                if(i+1<str.length && (str[i+1]>='0' && str[i+1]<='6')){
                    dp[i] += dp[i+2];
                }
            }else{
                dp[i] = dp[i+1];
            }
        }
        //dp怎么生成
        return dp[0];
    }
}
