package SearchforaRange.src;

import java.util.Arrays;

/**
 * Created by Moopa on 30/05/2017.
 * blog: leeautumn.net
 *
 * @autuor : Moopa
 */
public class SearchforaRange {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0){
            return new int[]{-1,-1};
        }

        int index = Arrays.binarySearch(nums,target);

        if(index < 0){
            return new int[]{-1,-1};
        }

        int[] result = new int[2];
        result[0] = index;
        result[1] = index;

        //开始从index向前向后寻找
        int i= index;
        for(;;){
            if(i>=0 && nums[i] == target){
                result[0] = i;
                i--;
            }else {
                break;
            }
        }

        i = index;
        for(;;){
            if(i<nums.length && nums[i] == target){
                result[1] = i;
                i++;
            }else {
                break;
            }
        }

        return result;

    }
}
