package LongestCommonPrefix.src;

/**
 * Created by coolAutumn on 9/27/16.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int length             =    strs.length;
        int minPrefixLength    =    0;
        int minStringLength    =    0;
        String result          =    "";

        //way one
        //从第一个字符开始比较,没比较一个字符需要遍历所有strs里的String,进而判断
        if(length == 1){
            return strs[0];
        }
        for(int i=0;i<length;i++){
            if(minStringLength > strs[i].length()){
                minStringLength = strs[i].length();
            }
        }
        for(int i=0;i<minStringLength;i++){
            char currentCompareChar = strs[0].charAt(i);
            for(int j=i+1;j<length;j++){
                if(currentCompareChar != strs[j].charAt(i)){
                    result = strs[0].substring(0,i);
                }
            }
        }
        return result;
    }
}
