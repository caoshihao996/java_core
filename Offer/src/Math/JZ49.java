package Math;

/*
    将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 */
public class JZ49 {

    public int StrToInt(String str) {
        if(str==null||str.length()==0)
            return 0;
        char[] arr  = str.toCharArray();
        boolean isNegative = false;
        if(arr[0]=='-'){
            isNegative=true;
        }
        int ret = 0;
        for (int i = 0; i < arr.length; i++) {
            if(i==0&&(arr[i]=='-'||arr[i]=='+')){
                continue;
            }
            if(arr[i]>'9' || arr[i]<'0')
                return 0;
            ret = ret*10 + (arr[i]-'0');
        }
        return isNegative? -ret : ret;
    }
}
