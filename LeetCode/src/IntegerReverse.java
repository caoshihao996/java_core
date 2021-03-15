public class IntegerReverse {

//    public static int reverse(int x){
//        if(x==0){
//            return 0;
//        }
//        int[] num = new int[11];
//        boolean isNegative = false;
//        if(x>0){
//            isNegative = false;
//
//        }else{
//            isNegative = true;
//        }
//        x = Math.abs(x);
//        int index = 0;
//        int mod = 0;
//        while(x!=0){
//            mod = x%10;
//            num[index] = mod;
//            x=x/10;
//            index++;
//        }
//
//        int res = 0;
//        for(int i=0; i<index; i++){
//            res = res*10 + num[i];
//            if(res > (Integer.MAX_VALUE)/10){
//                return 0;
//            }
//        }
//        if(isNegative){
//           return -res;
//        }
//        return res;
//    }
    public static int reverse(int x){
        int rev = 0;
        while(x!=0){
            int pop = x%10;
            x /= 10;
            if(rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE/10 && pop > 7))return 0;
            if(rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE/10 && pop < -8))return 0;
            rev = rev*10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }
}
