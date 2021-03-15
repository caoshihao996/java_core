import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_1018 {

    public List<Boolean> prefixesDivBy5(int[] A) {

        List<Boolean> res = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum = ((sum<<1) + A[i])%5;
            res.add(sum==0);
        }
        return res;
    }

    @Test
    public void test(){
        int[] A = new int[]{0, 1, 1};
        System.out.println(prefixesDivBy5(A).toString());
    }
}
