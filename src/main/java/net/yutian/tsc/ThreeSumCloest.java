package net.yutian.tsc;

import java.util.Arrays;

/**
 * Created by LeeAutumn on 11/8/16.
 * blog: leeautumn.net
 */
public class ThreeSumCloest {

    /**
     * 势必要把一个一个的数和算出来
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length < 3)
            return 0;

        Arrays.sort(nums);

        int length = nums.length;

        int res = nums[0] + nums[1] + nums[2];

        for(int i=0;i<length -2;i++){

//            if(nums[i] > target){
//                break;
//            }

            int leftIndex = i+1;
            int rightIndex = length - 1;


            int sum = 0;
            while(leftIndex < rightIndex){
                sum = nums[i] + nums[leftIndex] + nums[rightIndex];

                if(sum == target){
                    return target;
                }else if(sum < target){
                    leftIndex++;
                }else{
                    rightIndex--;
                }

                if(Math.abs(sum-target) < Math.abs(res-target)){
                    res = sum;
                }
            }

            while(i+1 < length && nums[i] == nums[i+1]) {
                i++;
            }

        }


        return res;
    }
}
