import java.util.Stack;

public class ValidParentheses_20 {

    public boolean isValid(String s) {
        if (s==null || s.length()==0){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(!stack.isEmpty() && ( (stack.peek()=='(' && s.charAt(i)==')') || (stack.peek()=='{' && s.charAt(i)=='}')
            || (stack.peek()=='[' && s.charAt(i)==']'))){
                stack.pop();
            }else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }
}
