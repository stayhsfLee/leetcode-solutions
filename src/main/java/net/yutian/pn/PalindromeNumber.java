package net.yutian.pn;

/**
 * Created by coolAutumn on 7/1/16.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        char[] arr = (x+"").toCharArray();
        int length = arr.length;
        int    mid = length/2;
        for(int i=0 ; i<mid; i++){
            if(arr[i] != arr[length-1-i]){
                return false;
            }
        }
        return true;
    }
}
