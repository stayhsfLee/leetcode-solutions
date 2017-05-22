import IslandPerimeter.src.IslandPerimeter;
import LetterCombinationsOfPhoneNumbers.src.LetterCombinations;
import LongestCommonPrefix.src.LongestCommonPrefix;
import LongestSubstringWithoutRepeatingCharacters.src.LongestSubstringWithoutRepeatingCharacters_WayTwo;
import PalindromeNumber.src.PalindromeNumber;
import RegularExpressionMatching.src.RegularExpressionMatching;
import RemoveNthNodeFromEndofList.src.ListNode;
import RemoveNthNodeFromEndofList.src.RemoveNthNodeFromEndList;
import StringToInteger.src.*;
import ThreeSum.src.ThreeSum;

public class Main{

    public static volatile int i = 0;

    public int getI() {
        return i;
    }

    public static void setI() {
        i++;
    }

    public static void main(String[] args) {
//        String digit = "23";
//        LetterCombinations letterCombinations = new LetterCombinations();
//        System.out.println(letterCombinations.letterCombinations(digit));
//        Main main = new Main();
//
//        Thread[] threads = new Thread[200];
//
//        for(int i=0;i<200;i++){
//            threads[i] = new Thread(){
//                @Override
//                public void run() {
//                    for(int j=0;j<1000;j++){
//                        setI();
//                    }
//                }
//            };
//
//
//            threads[i].start();
//
////            try {
////                Thread.currentThread().sleep(1000);
////            } catch (InterruptedException e) {
////                e.printStackTrace();
////            }
//
//
//        }
//        while(Thread.activeCount() > 2){
//            Thread.yield();
//        }
//        System.out.println(i);

//        int grid[][] = {
//                {0,1,0,0},
//                {1,1,1,0},
//                {0,1,0,0},
//                {1,1,0,0}
//        };
//        IslandPerimeter islandPerimeter = new IslandPerimeter();
//        int s = islandPerimeter.islandPerimeter(grid);
//        System.out.println(s);

        LongestSubstringWithoutRepeatingCharacters_WayTwo l = new LongestSubstringWithoutRepeatingCharacters_WayTwo();
        System.out.println(l.lengthOfLongestSubstring("aaaa"));
    }
}