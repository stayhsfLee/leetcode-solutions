package net.yutian.sti;

/**
 * Created by coolAutumn on 6/27/16.
 */
public class StringToInteger {
    /**
     * 此方法将字符串转换为整数值,以下为可能会遇到的问题
     * 1.
     * @return
     */
    public int atoi(String str){
        //初始化一些辅助变量
        int        result          =       0;
        boolean    isNegative      =       false;      //是否为负数
        int        limit           =       Integer.MAX_VALUE;
        boolean    startWithSymbol =       false;


        //先把字符串中所有的空格给去掉
        str = str.trim();
        if(str.length() == 0){
            return 0;
        }

        //判断这个数是否为负数
        char firstChar = str.charAt(0);
        if(firstChar == '+' || firstChar == '-'){
            startWithSymbol = true;
        }
        if(firstChar == '-'){
            isNegative = true;
            limit      = Integer.MIN_VALUE;
        }

        for(int i= isNegative ? 1 : 0 ; i<str.length() ; i++){
            char c = str.charAt(i);
            if(c >= '0' && c <= '9'){
                if(i < (startWithSymbol ? 10 : 9)){
                    result = result*10 + (c-'0') ;
                }else if(i == (startWithSymbol ? 10 : 9)){
                    if((""+result+c).compareTo((""+limit).replace("-","")) < 0){
                        result = result*10 + (c-'0') ;
                    }else{
                        return limit;
                    }
                }else{
                    return limit;
                }
            }else if(c == '+'){
                if(i != 0){
                    return isNegative ? result * -1 : result;
                }
            }else{
                return isNegative ? result * -1 : result;
            }
        }

        return isNegative ? result * -1 : result;
    }

    public int myAtoi(String str){
        str=str.replaceAll(" ","");
        int length=str.length();
        int i=0;
        int result=0;
        int limit=Integer.MAX_VALUE;
        boolean isNegative=false;

        if(length==0){
            return 0;
        }
        //如果只是一个字符
        if(length==1){
            if(str.charAt(0)>'9'||str.charAt(0)<'0'){
                return 0;
            }
        }

        char first=str.charAt(0);
        if(first<'0'){
            if(first=='-'){
                isNegative=true;
                limit=Integer.MIN_VALUE;
                length--;
            }else if(first=='+'){
                length--;
            }else{
                return 0;
            }
        }

        int j=0;

        if(isNegative){
            if(length>12){
                return 0;
            }
        }else if(length>11){
            return 0;
        }

        str=new StringBuffer(str.replaceFirst("-|\\+","")).reverse().toString();

        while(i<length){
            char c=str.charAt(i);
            if(c<'9'&&c>='0'){
                if(j<9) {
                    result += (c - '0') * Math.pow(10, j);
                    j++;
                    i++;
                }else if(j>=9){
                    if((""+result).compareTo((""+limit).replace("-",""))<0){
                        result+= (c - '0') * Math.pow(10, j);
                        i++;
                    }else{
                        return 0;
                    }
                }
            }
            else{
                return 0;
            }
        }


        return isNegative?-result:result;
    }
}

