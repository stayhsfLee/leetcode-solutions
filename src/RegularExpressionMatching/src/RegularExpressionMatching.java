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
        int s_offset = 0;     //当前s字符串偏移量
        int p_offset = 0;     //当前p字符串偏移量
        int length   = p.length();    //待比较字符串的长度


//        //根据正规式来进行匹配
//        while(p_offset < length){
//            char p_c1 = p.charAt(p_offset);
//            char p_c2;
//            if(p_offset+1 < length) {
//                p_c2 = p.charAt(p_offset + 1);
//            }else{
//                p_c2 = '.';
//            }
//
//            if(p_c2 == '*'){
//                if(p_c1 != '.') {
//                    for (; s_offset < s.length(); s_offset++) {
//                        if(s.charAt(s_offset) != p_c1){
//                            break;
//                        }
//                    }
//                    p_offset += 2;
//                }else{
//                    char temp;
//                    if(p_offset+2 < p.length()){
//                        temp = p.charAt(p_offset+2);
//                    }else{
//                        return true;
//                    }
//
//                    for (; s_offset < s.length(); s_offset++) {
//                        if(s.charAt(s_offset) == temp){
//                            break;
//                        }
//                    }
//                    p_offset += 2;
//                }
//            }else{
//                if(p_c1 != '.'){
//                    if(s_offset < s.length()) {
//                        if (s.charAt(s_offset++) != p_c1) {
//                            return false;
//                        }
//                    }else{
//                        return false;
//                    }
//                }else{
//                    s_offset++;
//                }
//                p_offset++;
//            }
//            s.matches();
//        }
//
//
//        return s_offset==s.length() ? true :false;
        return false;
    }
}
