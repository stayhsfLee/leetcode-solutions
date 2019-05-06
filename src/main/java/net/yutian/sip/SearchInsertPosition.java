package net.yutian.sip;

/**
 * Created by Moopa on 30/05/2017.
 * blog: leeautumn.net
 *
 * @autuor : Moopa
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {

        //用二分法来查找
        int length = nums.length;

        int res = binarySearch(nums,0,length-1,target);

        if(res == Integer.MIN_VALUE){
            return 0;
        }

        if(res < 0){
            return -res;
        }else {
            return res;
        }
    }

    public int binarySearch(int[] nums,int start,int end,int target){
        if(end == start){
            if(nums[start] == target){
                return start;
            }
            if(nums[start] > target){
                if(start == 0){
                    return Integer.MIN_VALUE;
                }
                return -start;
            }else if(nums[start] < target){
                return -start-1;
            }
        }
        if(end - start == 1){
            if(nums[start] == target){
                return start;
            }
            if(nums[end]== target){
                return end;
            }
            if(nums[start] > target){
                if(start == 0){
                    return Integer.MIN_VALUE;
                }
                return -start;
            }else if(nums[start] < target && nums[end] > target){
                return -end;
            }else{
                return -end-1;
            }
        }


        int mid = (start+end)/2;
        if(nums[mid] == target){
            return mid;
        }

        if(target > nums[mid]){
            return binarySearch(nums,mid+1,end,target);
        }else {
            return binarySearch(nums,start,mid-1,target);
        }
    }
}
