package ThreeSum.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by LeeAutumn on 11/7/16.
 * blog: leeautumn.net
 */
public class ThreeSum {

    /**
     * 初步想法是将给出的数进行分类(大于0和小于0),然后把这两个数组进行排序,然后从小到大匹配
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum0(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        int[] ltArray = new int[nums.length];
        int[] gtArray = new int[nums.length];


        int[] partitions = arrangeArray(ltArray,gtArray,nums);

        int zeroNum =   partitions[0];
        int ltMax   =   partitions[1];
        int gtMax   =   partitions[2];
        List<Integer> temp = new ArrayList<Integer>();


        //没有负数或者没有正数
        if(ltMax == 0 || gtMax == 0){
            if(zeroNum >= 3) {
                temp.add(0);
                temp.add(0);
                temp.add(0);
                result.add(temp);
            }
            return result;
        }

        Arrays.sort(ltArray,0,ltMax);
        Arrays.sort(gtArray,0,gtMax);


        //首先判断在结果中有0的情况
        if(zeroNum >= 1){
            if(zeroNum >= 3) {
                temp.add(0);
                temp.add(0);
                temp.add(0);
                result.add(temp);
            }



            //然后根从lt和gt里选两个相加等于0的数
            int j = gtMax - 1;
            int i=0;

            for (; i < ltMax; i++) {
                int tInt =ltArray[i] + gtArray[j];
                if (tInt == 0) {
                    temp = new ArrayList<>();
                    temp.add(ltArray[i]);
                    temp.add(gtArray[j]);
                    temp.add(0);
                    result.add(temp);

                    j--;
                }else if(tInt > 0){
                    j--;
                    i--;
                }

                if(j < 0){
                    break;
                }
            }


        }


        //现在判断threeSum中没有0的情况,那就是2个正数搭配1个负数 || 2个负数搭配1个正数

        //两个负数+一个正数,采用从负数数组左端和正数数组右端向内侧挤压配对
        if(ltMax >= 2){
            int i = 0;
            int j = gtMax-1;

//            for(;i<ltMax && contin;i++){
//                for(;j>=0;j--){
//                    int tempInt = ltArray[i] + gtArray[j];
//                    if(tempInt >= ltArray[i] && tempInt<0){
//                        for(int k = i+1; i<ltMax;i++){
//                            if(tempInt == ltArray[i]){
//                                temp = new ArrayList<>();
//                                temp.add(k);
//                                temp.add(ltArray[i]);
//                                temp.add(gtArray[j]);
//                                result.add(temp);
//                            }
//                        }
//                    }else{
//                        contin = false;
//                        break;
//                    }
//                }
//            }

            for(;i<ltMax ;i++) {
                int tempInt = ltArray[i] + gtArray[j];

                if (-tempInt >= ltArray[i] && tempInt > 0) {
                    for (int k = i+1; k < ltMax; k++) {
                        if (-tempInt == ltArray[k]) {
                            temp = new ArrayList<>();
                            temp.add(-tempInt);
                            temp.add(ltArray[i]);
                            temp.add(gtArray[j]);
                            result.add(temp);

                        }
                    }
                }

                if(-tempInt <= ltArray[i]){
                    j--;
                }

                if(j < 0){
                    break;
                }
            }
        }


        //两个正数+一个负数
        if(gtMax >= 2){
            int i = 0;
            int j = gtMax-1;

//            for(;i<gtMax && contin;i++){
//                for(;j>=0;j--){
//                    int tempInt = ltArray[i] + gtArray[j];
//                    if(tempInt <= gtArray[i] && tempInt > 0){
//                        for(int k = i+1; i<gtMax;i++){
//                            if(tempInt == gtArray[i]){
//                                temp = new ArrayList<>();
//                                temp.add(k);
//                                temp.add(ltArray[i]);
//                                temp.add(gtArray[j]);
//                                result.add(temp);
//                            }
//                        }
//                    }else{
//                        contin = false;
//                        break;
//                    }
//                }
//            }

            for(;j >= 0 ;j--) {
                int tempInt = ltArray[i] + gtArray[j];

                if (-tempInt <= gtArray[j] && tempInt < 0) {
                    for (int k = j - 1; k >= 0; k--) {
                        if (-tempInt == gtArray[k]) {
                            temp = new ArrayList<>();
                            temp.add(-tempInt);
                            temp.add(ltArray[i]);
                            temp.add(gtArray[j]);
                            result.add(temp);

                        }
                    }

                }

                if(-tempInt >= gtArray[j]){
                    i++;
                }

                if(i == ltMax){
                    break;
                }
            }
        }

        return result;


    }

    /**
     * 返回zeroNum
     * @param ltList
     * @param gtList
     * @return
     */
    private int[] arrangeArray(int[] ltArray,int[] gtArray,int[] nums){
        int zeroNum = 0;

        int lt_itor = 0;
        int gt_itor = 0;


        for(int index : nums){
            if(index > 0){
                gtArray[gt_itor++] = index;
            }else if(index == 0){
                zeroNum++;
            }else{
                ltArray[lt_itor++] = index;
            }
        }

        return new int[]{zeroNum,lt_itor,gt_itor};
    }


    /**
     * the second way
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        int length = nums.length;

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp ;

        for(int i=0;i<length -2;i++){

            if(nums[i] > 0){
                break;
            }

            int leftIndex = i+1;
            int rightIndex = length - 1;

            while(leftIndex < rightIndex){
                int sum = nums[i] + nums[leftIndex] + nums[rightIndex];

                if(sum > 0){
                    rightIndex--;
                }else if(sum < 0){
                    leftIndex++;
                }else{
                    temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[leftIndex]);
                    temp.add(nums[rightIndex]);
                    res.add(temp);

                    while(leftIndex+1 < length && nums[leftIndex] == nums[leftIndex+1]){
                        leftIndex++;
                    }
                    leftIndex++;
                    rightIndex--;
                }
            }

            while(i+1 < length && nums[i] == nums[i+1]) {
                i++;
            }

        }

        return res;
    }
}
