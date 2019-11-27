package net.yutian.gc;

import java.util.LinkedList;
import java.util.List;

public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> linkedList = new LinkedList<>();

        int maxNumber = (int) Math.pow(2, n) ;

        if (n == 0) {
            linkedList.add(0);
            return linkedList;
        }
        if (n==1){
            linkedList.add(0);
            linkedList.add(1);
            return linkedList;
        }

        linkedList.add(0);
        linkedList.add(1);
        int currentIndex = 2;
        while(currentIndex <= n) {
            int addedNum = 0;
            int numbersOfNumbersNeededToAdd = (int) Math.pow(2, currentIndex - 1);
            // 当前位数二进制
            int currentIndexNumber = (int) Math.pow(2, currentIndex - 1);
            while (addedNum < numbersOfNumbersNeededToAdd ) {
                linkedList.add(linkedList.get(numbersOfNumbersNeededToAdd - addedNum - 1) + currentIndexNumber);
                addedNum = addedNum + 1;
            }
            currentIndex ++;
        }
        return linkedList;
    }

  public static void main(String[] args) {
    GrayCode grayCode = new GrayCode();

    System.out.println(grayCode.grayCode(2));
    System.out.println(grayCode.grayCode(0));
    System.out.println(grayCode.grayCode(1));
    System.out.println(grayCode.grayCode(3));
    System.out.println(grayCode.grayCode(4));
    System.out.println(grayCode.grayCode(5));
  }
}
