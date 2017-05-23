package RemoveDuplicatesfromSortedArray.src;

/**
 * Created by Moopa on 23/05/2017.
 * blog: leeautumn.net
 *
 * @autuor : Moopa
 */
public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {

        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return 1;
        }

        //首先了解一下到底有多少个不同的数字
        //int diffnum = differentNumberInSortedArray(nums);

        int now = nums[0];

        int k=1;
        for(int i:nums){
            if( i != now){
                nums[k] = i;
                k++;
                now = i;
            }
        }


        return k;
    }

    public int differentNumberInSortedArray(int[] array){
        int now = array[0];
        int num = 1;
        for(int i : array){
            if(i != now){
                num++;
                now = i;
            }
        }
        return num;
    }
}
