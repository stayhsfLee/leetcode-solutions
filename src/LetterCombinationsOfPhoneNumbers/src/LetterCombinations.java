package LetterCombinationsOfPhoneNumbers.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by LeeAutumn on 11/9/16.
 * blog: leeautumn.net
 */
public class LetterCombinations {

    String[] maps = new String[]{" ","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if(digits.length() == 0){
            return res;
        }
        //ignore number 1
        digits = digits.replaceAll("1","");

        char[] digitChars = digits.toCharArray();
        int length = digits.length();
        Arrays.sort(digitChars);


        //divide and conquer
        res = getConbined(digitChars,0,length-1);


        return res;
    }

    private List<String> getConbined(char[] digitChars,int start,int end){
        List<String> res = new ArrayList<>();

        if(end == start){
            String temp = maps[digitChars[start] - '0'];
            for(char s : temp.toCharArray()){
                res.add(String.valueOf(s));
            }
            return res;
        }

        int mid = (end+start)/2;
        List<String> res1 = getConbined(digitChars,start,mid);
        List<String> res2 = getConbined(digitChars,mid+1,end);

        for(String s1 : res1){
            for(String s2 : res2){
                res.add(s1+s2);
            }
        }
        return res;
    }
}
