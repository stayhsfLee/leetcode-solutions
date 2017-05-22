package ValidParentheses.src;


import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        boolean result = false;

        //use stack to check its correct
        Stack<Character> stack = new Stack<>();

        //1.如果stack为空,则肯定要push进char
        //2.如果碰到了非终结符,则push进
        //3.如果遇到了终结符,则匹配pop出
        char[] chars = s.toCharArray();

        for(int i=0;i<chars.length;i++){
            char c = chars[i];
            if(stack.empty()){
                stack.push(c);
                continue;
            }

            if(needParenthese(c)){
                while (true){
                    if(!stack.pop().equals(parentheseChar(c))){
                        return false;
                    }
                    break;
                }
            }else {
                stack.push(c);
            }
        }

        return stack.empty();

    }

    private char parentheseChar(char c){
        switch (c){
            case '(':
                return ')';
            case ')':
                return '(';
            case '[':
                return ']';
            case ']':
                return '[';
            case '{':
                return '}';
            case '}':
                return '{';
            default: return ' ';
        }
    }

    private boolean needParenthese(char c){
        if(c == ')' || c == ']' | c == '}'){
            return true;
        }
        return false;
    }
}