package NextPermutation.src;

import java.util.Arrays;

/**
 * Created by Moopa on 25/05/2017.
 * blog: leeautumn.net
 *
 * @autuor : Moopa
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if(nums.length == 0 || nums.length == 1){
            return;
        }
        //首先判断是不是已经是降序了,或者所有数字都一样
        if (isDescArray(nums)) {
            Arrays.sort(nums);
            return;
        }

        //从后往前分析
        //找寻前一个数小于后一个数的index
        int i=nums.length-1;
        for(;i>=1;i--){
            if(nums[i] > nums[i-1]){
                break;
            }
        }

        int index = i-1;
        //开始对index - length 这一段距离进行改变
        //首先找到index+1 - length-1最小的值: != nums[index]
        int min = -1;

        for(int j = index+1;j<nums.length;j++){
            if(nums[j] > nums[index]){
                if(min == -1){
                    min = j;
                    continue;
                }
                if(nums[min] > nums[j]){
                    min = j;
                }
            }
        }

        if(min == -1){
            return;
        }
        int temp = nums[index];
        nums[index] = nums[min];
        nums[min] = temp;

        //然后进行排序即可
        Arrays.sort(nums,index+1,nums.length);


    }

    public boolean isDescArray(int[] nums){
        for(int i = 1;i<nums.length;i++){
            if(nums[i-1] < nums[i]){
                return false;
            }
        }


        return true;
    }
}
