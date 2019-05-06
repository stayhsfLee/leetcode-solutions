package net.yutian.ts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumWayTwo {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // firstly sort the array
        Arrays.sort(nums);
        if (nums.length == 0 || nums.length < 3){
            return result;
        }
        if ( nums[0] > 0 ) {
            return result;
        }

        // narrow the possible range
        int left=0;
        for (int i = 0; i < nums.length; i++) {
            if (-nums[i] <= nums[nums.length - 1] + nums[nums.length - 2]) {
                left=i;
                break;
            }
        }
        int right=nums.length - 1;
        for (int i = nums.length - 1; i > left ; i--) {
            if (-nums[i] >= nums[left] + nums[left + 1]) {
                right = i;
                break;
            }
        }

        for(int i=left; i<=right-2; i++){
            int l = i+1;
            int r = right;

            while ( l< r){
                if (nums[i] + nums[l] + nums[r] < 0){
                    l++;
                }else if(nums[i] + nums[l] + nums[r] > 0){
                    r--;
                }else {
                    List<Integer> integers = new ArrayList<>();
                    integers.add(nums[i]);
                    integers.add(nums[l]);
                    integers.add(nums[r]);
                    result.add(integers);
                    while (l <= right-1 && nums[l+1] == nums[l]){
                        l++;
                    }
                    l++;
                    r--;
                }
            }
            while (i <= right-1 && nums[i+1] == nums[i]){
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSumWayTwo threeSumWayTwo = new ThreeSumWayTwo();
        System.out.println(threeSumWayTwo.threeSum(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(threeSumWayTwo.threeSum(new int[]{0,0,0,0}));
        System.out.println(threeSumWayTwo.threeSum(new int[]{-1,0,1,0}));
        System.out.println(threeSumWayTwo.threeSum(new int[]{-2,0,1,1,2}));
        System.out.println(threeSumWayTwo.threeSum(new int[]{-2,0,0,2,2}));
    }

}
