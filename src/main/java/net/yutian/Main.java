package net.yutian;

import net.yutian.sip.SearchInsertPosition;

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
//        net.yutian.Main main = new net.yutian.Main();
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
//        main.java.IslandPerimeter islandPerimeter = new main.java.IslandPerimeter();
//        int s = islandPerimeter.islandPerimeter(grid);
//        System.out.println(s);

        SearchInsertPosition s = new SearchInsertPosition();
        int[] nums = new int[]{1};
        System.out.println(s.searchInsert(nums,0));
    }
}