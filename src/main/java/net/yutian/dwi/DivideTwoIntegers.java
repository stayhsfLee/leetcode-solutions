package net.yutian.dwi;

/**
 * Created by Moopa on 24/05/2017.
 * blog: leeautumn.net
 *
 * @autuor : Moopa
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {

        if(divisor == 0 || (long)dividend > Integer.MAX_VALUE || ((long)dividend <= Integer.MIN_VALUE && divisor == -1)){
            return Integer.MAX_VALUE;
        }
        if(divisor == 1 || divisor == -1){
            return divisor == 1 ? dividend : -dividend;
        }
        boolean one = false,two = false;
        if(dividend < 0){
            dividend = -dividend;
            one = true;
        }
        if(divisor < 0){
            divisor = -divisor;
            two = true;
        }
        //单独拎出来进行计算
        if(dividend == Integer.MIN_VALUE){
            int result=0;
            while(dividend <= -divisor){
                dividend += divisor;
                result++;
            }

            return two ? result : -result;
        }





        //简单的采用+法即可
        int result=0;
        while(dividend >= divisor){
            dividend -= divisor;
            result++;
        }

        if(result == 0){
            return 0;
        }

        return (one^two) ? -result:result;
    }


}
