package net.yutian.ri;

public class ReverseInteger {
    boolean isNegative=false;
    public   int  reverse(int x) {

        String temp;
        if(x<0){
            isNegative=true;
            if(x==Integer.MIN_VALUE){
                return 0;
            }
            temp=String.valueOf(-x);
        }else{
            temp=String.valueOf(x);
        }

        StringBuffer s=new StringBuffer(temp);
        String result=clear(s.reverse().toString());
        if(isNegative&&!result.equals("0")){
            result="-"+result;
        }
        if(result.equals("")){
            result="0";
        }
        return Integer.valueOf(result);
    }

    //清除反向过后前面的0
    public  String clear(String s){
        String result="";
        int offset=0;
        int length=s.length();
        char[] arr=s.toCharArray();
        for(int i=0;i<length;i++){
            if(arr[i]!='0'){
                break;
            }
            offset++;
        }
        result=s.substring(offset,length);
        if((result.length()==10&&!isNegative&&result.compareTo(String.valueOf(Integer.MAX_VALUE))>0)
                ||(result.length()==10&&isNegative&&result.compareTo(String.valueOf(Integer.MIN_VALUE).replace("-",""))>0)){
            result="0";
        }
        return result;

    }
}