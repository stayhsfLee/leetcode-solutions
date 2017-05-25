package SubstringwithConcatenationofAllWords.src;

import java.util.*;

/**
 * Created by Moopa on 25/05/2017.
 * blog: leeautumn.net
 *
 * @autuor : Moopa
 */
public class SubstringwithConcatenationofAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        if(s.length() ==0 || words.length == 0 || words[0].length() == 0){
            return Arrays.asList(0);
        }
        //滑动固定长度的窗口
        List<Integer> result = new ArrayList<>();

        int words_length = words.length,word_length = words[0].length();
        int com_length = words_length * word_length;

        //计算每个word的出现次数
        HashMap<String, Integer> map = new HashMap<>();
        for(String word : words) map.put(word, map.getOrDefault(word, 0) + 1);

        //然后从头开始进行遍历
        for(int i=0;i+com_length <= s.length() ;i+= word_length){
            for(int j=0;j < words_length;j++){
                String s1 = s.substring(i+word_length*j,i+word_length*j+word_length);
                if(!map.containsKey(s1)){
                    break;
                }else {
                    map.put(s1,map.get(s1)-1);
                }
            }
            boolean b = true;
            for(Map.Entry<String ,Integer> e : map.entrySet()){
                if(e.getValue() != 0){
                    b = false;
                    break;
                }
            }
            if(b){
                result.add(i);
            }
            map.clear();
            for(String word : words) map.put(word, map.getOrDefault(word, 0) + 1);
        }

        return result;
    }

}
