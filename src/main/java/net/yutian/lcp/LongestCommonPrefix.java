package net.yutian.lcp;

/**
 * Created by coolAutumn on 9/27/16.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {

        int length             =    strs.length;
        int minStringIndex    =    0;
        int minStringLength    =    Integer.MAX_VALUE;
        String result          =    "";

        //way one
        //从第一个字符开始比较,每比较一个字符需要遍历所有strs里的String,进而判断,当然最后会报TLE
        if(length == 0){
            return "";
        }
        if(length == 1){
            return strs[0];
        }
        for(int i=0;i<length;i++){
            if(minStringLength > strs[i].length()){
                minStringLength = strs[i].length();
                minStringIndex = i;
            }
        }

        for(int i=0;i<minStringLength;i++){
            char currentCompareChar = strs[0].charAt(i);
            for(int j=0;j<length;j++){
                if(currentCompareChar != strs[j].charAt(i)){
                    return result;
                }else if(i == minStringLength -1 && j == length -1){
                    result = strs[minStringIndex];
                    return result;
                }
            }
            result = strs[minStringIndex].substring(0,i+1);

        }

        return result;

        


    }


    /**
     * Another way
     */
    public String longestCommonPrefixAnotherWay(String[] strs) {

        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        String result = strs[0];

        for (int i = 1; i < strs.length; i++) {
            if(!strs[i].startsWith(result)){
                char[] cs = result.toCharArray();

                int end = strs[i].length() > cs.length ? cs.length : strs[i].length();
                int j=0;
                for(; j<end;j++ ){
                    if(cs[j] != strs[i].charAt(j)){
                        break;
                    }
                }

                if(j == 0){
                    return "";
                }
                result = result.substring(0, j);
            }
        }

        return result;
    }

    public String longestCommonPrefix1(String[] strs) {
        String res="";
        for(int i=0;i<strs[0].length();i++){
            res+=strs[0].charAt(i);
            for(int j=1;j<strs.length;j++){
                if(strs[j].startsWith(res)){
                    return  res.substring(0,res.length()-1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();

        String[] ss = new String[]{"flower","flow","flight"};
        System.out.println(longestCommonPrefix.longestCommonPrefix1(ss));
    }
}
