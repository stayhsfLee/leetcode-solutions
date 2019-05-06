package net.yutian.ir;

/**
 * Created by coolAutumn on 9/26/16.
 */
public class IntegertoRoman {

    /**
     *  由于罗马数字各个符号之间是相加的形式
     *  所以采用10进制数一样的思想,把10进制数各个位的各个数字匹配成相应的罗马数字,然后再去组合
    */
    public String intToRoman(int num) {
        String[][] intToRoman = new String[][]{
                {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                {"", "M", "MM", "MMM"}
        };

//        StringBuffer sb  =  new StringBuffer("");
//        sb.append(intToRoman[3][num/1000]);
//        sb.append(intToRoman[2][num%1000/100]);
//        sb.append(intToRoman[1][num%100/10]);
//        sb.append(intToRoman[0][num%10]);
//
//        return sb.toString();

        //直接返回字符串效率会更高
        return intToRoman[3][num / 1000] + intToRoman[2][(num % 1000) / 100] + intToRoman[1][(num % 100) / 10] + intToRoman[0][num % 10];
    }

    /**
     *

     另一种解决办法

     private static final int[] vals =
     new int[] { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

     private static final String[] strs =
     new String[] { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

     public String intToRoman(int num) {
     StringBuilder sb = new StringBuilder();
     int i = 0;
     while (num > 0) {
     while (num >= vals[i]) {
     sb.append(strs[i]);
     num -= vals[i];
     }
     i++;
     }
     return sb.toString();
     }
     */
}
