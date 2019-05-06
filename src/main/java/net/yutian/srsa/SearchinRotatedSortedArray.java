package net.yutian.srsa;

/**
 * Created by Moopa on 29/05/2017.
 * blog: leeautumn.net
 *
 * @autuor : Moopa
 */
public class SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }
        if(nums[0] == target){
            return 0;
        }

        int result = 0;
        //判断是否大于第一个数
        if(target > nums[0]){
            for(int i =1;i<nums.length;i++){
                if(nums[i] == target){
                    return i;
                }
                if(nums[i] > target){
                    return -1;
                }
            }
        }else {
            //表明target位于后一部分
            //所以需要从后往前找到
            for(int i=nums.length-1;i>=0;i--){
                if(nums[i] == target){
                    return i;
                }
                if(nums[i] < target){
                    return -1;
                }
            }
        }

        return -1;

    }
}
