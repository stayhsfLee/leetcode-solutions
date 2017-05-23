package RemoveElement.src;

/**
 * Created by Moopa on 23/05/2017.
 * blog: leeautumn.net
 *
 * @autuor : Moopa
 */
public class RemoveElement {
    //从后往前找寻空的位置
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0] == val ? 0:1;
        }

        int head = 0;
        int tail = nums.length-1;
        boolean changed = false;

        while(head <= tail){
            //找寻第一个val
            head= findValFromFirst(nums,head,tail,val);
            tail = findValFromLast(nums,head,tail,val);

            if(!changed && head == nums.length){
                return nums.length;
            }
            if(!changed && tail == -1){
                return 0;
            }

            if(head >= tail){
                break;
            }

            //交换两者位置
            int temp = nums[head];
            nums[head] = nums[tail];
            nums[tail] = temp;
            changed = true;
        }

        return head;
    }

    public int findValFromFirst(int[] array,int start,int last,int val){
        int i =start;
        for(;i<=last;i++){
            if(array[i] == val){
                break;
            }
        }

        return i;
    }

    public int findValFromLast(int[] array,int start,int last,int val){
        int i =last;
        for(;i>=start;i--){
            if(array[i] != val){
                break;
            }
        }

        return i;
    }
}
