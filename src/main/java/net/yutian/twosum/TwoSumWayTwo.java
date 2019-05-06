package net.yutian.twosum;

public class TwoSumWayTwo {
    public int[] twoSum(int[] nums, int target) {
        //the formula is x1 + x2 = target
        //the way_one can't perform well in a large array so here is the way two 
        //this way is inspaired by net friend@eugenefn in leetcode

        //x1 is nums,x2 is arr
        //firstly we hava to find the min and max of the array
        int max=nums[0],min=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]<min){
                min=nums[i];
            }
            if(nums[i]>max){
                max=nums[i];
            }
        }

        //get the range of validata number relative to target
        //if num gt sMax or num lt sMin,this num isn't validata
        int sMin=Math.max(min,target-max);
        int sMax=Math.min(max,target-min);

        //the size indicate the number of effective x2 
        //initializ with -1
        int size=sMax-sMin+1;
        int[] arr=new int[size];
        for(int i=0;i<size;i++)
            arr[i]=-1;

        //get the arr
        for(int i=0;i<nums.length;i++){
            if(nums[i]<sMin||nums[i]>sMax)
                continue;
            if(arr[target-nums[i]-sMin]==-1)
                arr[nums[i]-sMin]=i;
            else
                return new int[]{arr[target-nums[i]-sMin],i};
        }
        return new int[]{0,0};
    }
}