import org.junit.Test;

public class LeetCode_38 {

    public String countAndSay(int n){
        if(n==1){
            return "1";
        }
        return process(n);
    }

    public String process(int n){
        if (n==1){
            return "1";
        }
        char[] arr = process(n-1).toCharArray();
        StringBuilder str = new StringBuilder();
        int count = 0;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i]==arr[i+1]){
                count++;
            }
        }

        return str.toString();
    }

    @Test
    public void test(){
        System.out.println(countAndSay(3));
    }
}
