import java.util.ArrayList;
import java.util.List;

public class StringToInteger_08 {

    public static int myAtoi(String s){
        if(s==null){
            return 0;
        }
        boolean isNegaive = false;
        String str = s.trim();
        if(str.length()==0){
            return 0;
        }
        char[] arr = str.toCharArray();
        List<Character> list = new ArrayList<>();
        int res = 0;
        if((arr[0]>='0' && arr[0]<='9')){
            for(char c : arr){
                if(c > '9' || c<'0'){
                    break;
                }
                if(res>Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && c-'0'>7)){
                    return Integer.MAX_VALUE;
                }
                res = res*10 + (c - '0');
            }
            return res;
        }else if(arr[0]=='-' || arr[0]=='+'){
            for (int i = 1; i < arr.length; i++) {
                if(arr[i] > '9' || arr[i]<'0'){
                    break;
                }
                if(arr[0]=='+' && (res>Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && arr[i]-'0'>7))){
                    return Integer.MAX_VALUE;
                }
                if(arr[0]=='-' && (res>Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && arr[i]-'0'>8))){
                    return Integer.MIN_VALUE;
                }
                res = res*10 + (arr[i] - '0');
            }
            return arr[0] == '-' ? -res : res;
        }else{
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("2147483648"));
    }
}
