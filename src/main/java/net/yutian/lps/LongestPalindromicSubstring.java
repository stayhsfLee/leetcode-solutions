package net.yutian.lps;

public class LongestPalindromicSubstring{
    int max=0;
    //从一端开始查找回文字符串
    public String longestPalindrome(String s) {

        int length=s.length();
        //下面这个变量判断是否找到的是哪种回文串
        int type=0;
        int pos=0;
        if(length==1){
            return s;
        }else {
            String result = "";
            for (int i = 1; i <= length - max - 1 ; i++) {

                //限定j的长度(你不能取(-1,i)吧!)
                int minLength = i < length - 1 - i ? i : length - 1 - i;

                //开始查找长度为奇数的回文字符串
                //asd
                for (int j = 1; j <= minLength ;j++) {
                    if (s.charAt(i - j) != s.charAt(i + j)) {
                        break;
                    }
                    if(type==1){
                        if (j >= max) {
                            pos=i;
                            type = 1;
                            max = j;
                        }
                    }else if(type==2){
                        if (j*2+1 >= (1+max)*2) {
                            pos=i;
                            type = 1;
                            max = j;
                        }
                    }else {
                        pos=i;
                        type = 1;
                        max = j;
                    }

                }

                //开始查找长度为偶数的回文字符串
                //aa
                for (int k = 0; k <= minLength ; k++) {
                    if (i-k-1>=0 && i+k<length ) {
                        if(s.charAt(i - k -1) != s.charAt(i + k))
                            break;
                    }else {
                        break;
                    }
                    if(type==1) {
                        if ((k + 1) * 2 > 2 * max + 1) {
                            pos = i;
                            type = 2;
                            max = k;
                        }
                    }else if(type==2){
                        if ((k + 1) * 2 > 2 * max + 2) {
                            pos = i;
                            type = 2;
                            max = k;
                        }
                    }else {
                        pos = i;
                        type = 2;
                        max = k;
                    }
                }
            }
            System.out.println(type);
            //type=0表示没有找到回文,那么回文应该是第一个字符(自己决定)
            if(type==0){
                return ""+s.charAt(0);
            } else if (type == 1) {
                result=s.substring(pos-max,pos+max+1);
            } else if (type == 2) {
                result=s.substring(pos-max-1,pos+max+1);
            }
            return result;
        }
    }
}