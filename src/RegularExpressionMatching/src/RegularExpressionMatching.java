package RegularExpressionMatching.src;

/**
 * Created by coolAutumn on 7/6/16.
 */
public class RegularExpressionMatching {
    /**
     * 根据正规式匹配字符串是否合法
     * @param s     需要被匹配的字符串
     * @param p     正规式
     * @return
     */
    public boolean isMatch(String s,String p){
        if (p.length() == 0) {
            if (s.length() == 0) {
                return true;
            } else {
                return false;
            }
        }

        if(s.length() == 0){
            if(p.length() > 1 && p.charAt(1) == '*'){
                return isMatch(s, p.substring(2));
            }else{
                return false;
            }
        }

        // 接下来就是无限递归解法，遇到*号就分成当前舍弃或者当前保留
        if (p.length() == 1) {
            if (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0)) {
                return isMatch(s.substring(1), p.substring(1));
            }else {
                return false;
            }
        } else {
            if (p.charAt(1) != '*') {
                if (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.') {
                    return isMatch(s.substring(1), p.substring(1));
                } else {
                    return false;
                }
            } else {
                if (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.') {
                    return isMatch(s, p.substring(2)) || isMatch(s.substring(1), p);
                }
                return isMatch(s, p.substring(2));
            }
        }
    }
}
