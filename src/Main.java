import LongestCommonPrefix.src.LongestCommonPrefix;
import PalindromeNumber.src.PalindromeNumber;
import RegularExpressionMatching.src.RegularExpressionMatching;
import StringToInteger.src.*;
import ThreeSum.src.ThreeSum;

public class Main{
    public static void main(String[] args) {
        int[] nums = new int[]{-2,0,0,2,2};
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSum(nums));
    }
}