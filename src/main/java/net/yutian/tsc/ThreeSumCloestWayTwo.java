package net.yutian.tsc;

import java.util.Arrays;

public class ThreeSumCloestWayTwo {
  public int threeSumClosest(int[] nums, int target) {
    // firstly sort the array
    Arrays.sort(nums);

    Integer result = null;
    for (int i = 0; i <= nums.length - 2; i++) {
      int l = i + 1;
      int r = nums.length-1;

      while (l < r) {
        int sum = nums[i] + nums[l] + nums[r];
        if (sum == target){
            return target;
        }else if (sum > target){
            r--;
        }else {
            l++;
        }
        if (result == null){
            result = sum;
        }
        if (Math.abs(target - sum) < Math.abs(target - result)) {
          result = sum;
        }
      }
      while (i <= nums.length - 2 && nums[i + 1] == nums[i]) {
        i++;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    ThreeSumCloestWayTwo threeSumCloestWayTwo = new ThreeSumCloestWayTwo();
    System.out.println(threeSumCloestWayTwo.threeSumClosest(new int[] {-1, 2, 1, -4}, 1));
    System.out.println(threeSumCloestWayTwo.threeSumClosest(new int[] {0,0,0}, 1));
    System.out.println(threeSumCloestWayTwo.threeSumClosest(new int[] {0,1,2}, 0));
    System.out.println(threeSumCloestWayTwo.threeSumClosest(new int[] {0,2,1,-3}, 1));
    System.out.println(threeSumCloestWayTwo.threeSumClosest(new int[] { -3,-2,-5,3,-4}, -1));
    System.out.println(threeSumCloestWayTwo.threeSumClosest(new int[] { -1,0,1,1,55}, 3));

  }
}
