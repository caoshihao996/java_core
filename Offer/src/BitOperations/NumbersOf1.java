package BitOperations;

public class NumbersOf1 {

    public int numberOf1(int n){
        int cnt = 0;
        while(n!=0){
            cnt++;
            n &= (n-1);
        }
        return cnt;
    }
}
