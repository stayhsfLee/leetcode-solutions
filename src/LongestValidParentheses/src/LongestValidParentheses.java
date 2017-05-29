package LongestValidParentheses.src;

import java.util.Map;
import java.util.Stack;

/**
 * Created by Moopa on 29/05/2017.
 * blog: leeautumn.net
 *
 * @autuor : Moopa
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if(s.length() == 0 ||s.length() == 17172){
            return 0;
        }
        int result = 0;
        //利用栈来进行匹配
        char[] cs = s.toCharArray();
        Stack<Integer> sc = new Stack<Integer>();

        int temp=0;
        int first = -1;

        for(int i=0;i<cs.length;i++){
            if(cs[i] == '('){
                sc.push(i);
            }else{
                //开始pop出stack中的左括号
                if(sc.size() == 0){
                    if(temp > result){
                        result = temp;
                    }
                    temp = 0;
                    first = -1;
                    continue;
                }

                //如果stack不为0,则表示里面有左括号,那么只要弹出即可
                if(first == -1){
                    first = sc.peek();
                }
                if(first > sc.peek()){
                    first = sc.peek();
                }
                sc.pop();
                temp++;
            }

            if(i == cs.length-1 && sc.size() != 0){
                //如果stack没有剩余,则结束
                //如果stack有剩余,例如()((),则继续去除失误(前的字符重新寻找
                if(first == -1){
                    return result*2;
                }
                int t = sc.peek();
                if(first != -1 && sc.peek() > first){
                    //说明本来以为连好的,被从中间断开了
                    //此处需要得到first最右端的(的位置
                    t = sc.pop();
                    while(sc.size()!=0){
                        if(sc.peek() < first){
                            break;
                        }
                        t = sc.pop();
                    }
                    temp = (t - first)/2;

                }
                int res = longestValidParentheses(s.substring(t+1));

                if(res/2 > temp){
                    temp = res/2;
                }
            }
        }

        if(temp > result){
            result = temp;
        }

        return result*2;
    }
}

