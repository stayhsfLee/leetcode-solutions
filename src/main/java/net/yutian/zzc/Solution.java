package net.yutian.zzc;

public class Solution {
    public String convert(String s, int numRows) {
        int length=s.length();
        if(length==0||numRows==1){
            return s;
        }
        String result="";

        char[] arr=s.toCharArray();
        for(int i=0;i<numRows;i++){
            if(i==0||i==numRows-1) {
                for (int j = i; j < length; j=j+(numRows-1)*2) {
                    result+=arr[j];
                }
            }else{
                for (int j = i; j < length; j=j+(numRows-1)*2) {
                    result+=arr[j];
                    if(j+(numRows-i-1)*2<length)
                        result+=arr[j+(numRows-i-1)*2];
                }
            }
        }
        return result;
    }
}