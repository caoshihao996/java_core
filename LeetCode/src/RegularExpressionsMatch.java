public class RegularExpressionsMatch {

    public static boolean isMatch(String s, String p){

        if(s==null || p==null){
            return false;
        }
        char[] str = s.toCharArray();
        char[] pattern = p.toCharArray();

        return match(str, 0, pattern, 0);
    }

    public static boolean match(char[] str, int i, char[] pattern, int j){
            if(i==str.length && j==pattern.length){
                return true;
            }else if(j==pattern.length){
                return false;
            }

            boolean next = (j+1<pattern.length && pattern[j+1]=='*');
            if(next){
                if(i<str.length && (str[i]==pattern[j] || pattern[j]=='.')){
                    return match(str, i+1, pattern, j) || match(str, i, pattern, j+2);
                }else{
                    return match(str, i, pattern, j+2);
                }
            }else{
                if(i<str.length && (str[i]==pattern[j] || pattern[j]=='.')){
                    return match(str, i+1, pattern, j+1);
                }else{
                    return false;
                }
            }
    }

    public static void main(String[] args) {
        String s = "aa";
        String p = "a*";
        System.out.println(isMatch(s,p));
    }
}
