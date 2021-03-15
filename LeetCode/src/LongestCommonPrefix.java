public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        int length = strs[0].length();
        String res = strs[0];
        for(String s : strs){
            if(length>s.length()){
                length = s.length();
                res = s;
            }
        }


        for(int i=1; i<length+1; i++){
            res = strs[0].substring(0,i);
            for(String s : strs){
                if(!s.startsWith(res)){
                    return res.substring(0,i-1);
                }else{
                    continue;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flower","flower","flower"}));
    }
}
