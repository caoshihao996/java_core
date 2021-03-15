import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses_22 {

    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {

        if(n==0){
            return res;
        }
        String str = new String("");
        track(str, n, n);
        return res;
    }

    public void track(String str, int left, int right){
        if(left==0 && right==0){
            res.add(str);
            return;
        }
        if(left==right){
            track(str+"(", left - 1, right);
        }else if(left < right){
            if(left>0){
                track(str+"(", left-1, right);
            }
            track(str+")", left, right -1);
        }
    }

    @Test
    public void test(){
        System.out.println(generateParenthesis(3).toString());
        StringBuilder str = new StringBuilder();
        str.append('c');
        str.append('a');
        System.out.println(str);
    }
}
