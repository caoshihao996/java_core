import java.util.Stack;

public class Palindrome {

    public static boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }else if(x==0){
            return true;
        }
        int temp = x;
        int res = 0;
        while(x!=0){
            int mod = x%10;
            x /= 10;
            res = res*10 +mod;
        }
        System.out.println(res+" "+temp);
        return res==temp;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(10));
    }
}
