package net.yutian.lswrc;

public class LongestSubstringWithoutRepeatingCharactersWayTwo {
    //95 integer vars to show if current char had been showed
    //each integet stores the location of the last same char in the arr 
    int[] repeat_char=new int[95];
    //the length of longest substring
    int longest_len=0;
    int i=0;
    int m=-1,n=0;
    public int lengthOfLongestSubstring(String s) {
        //firstly change string to char array
        char[] arr=s.toCharArray();
        //initialize with false
        for(int i=0;i<95;i++)
            repeat_char[i]=-1;
            
        //iter all char to make sure 
        for(;i<arr.length;i++)
            checkIfShowed(arr,i);

        if(m == -1){
            longest_len = i;
        }else {
            longest_len = i - 1 - m  > longest_len ? i - 1 - m  : longest_len;
        }
        return longest_len;
    }

    //原先的想法是让i移到上一次出现的后面一位,然后重新开始,
    //但是这样反而浪费了一次遍历好的结果,不如让相应repeat_char[num]上的值 = 最新一次的检测到的重复char的位置,这样可以避免浪费一次遍历
    public void checkIfShowed(char[] arr,int k)
    {
        int num=(int)(arr[k]-'!')+1;
        if(repeat_char[num] == -1 || repeat_char[num] < m){
            repeat_char[num]=i;
        }
        else{
            //let i be the location of last same char
            //and again scan all chars
            if(m == -1){
                longest_len = i;
            }else {
                longest_len = i - 1 - m > longest_len ? i - 1 - m : longest_len;
            }
            m = repeat_char[num];
            repeat_char[num] = i;
        }
    }
}