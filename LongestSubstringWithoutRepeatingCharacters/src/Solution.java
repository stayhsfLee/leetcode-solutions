public class Solution {
    //95 integer vars to show if current char had been showed
    //each integet stores the location of the last same char in the arr 
    int[] repeat_char=new int[95];
    //the length of longest substring
    int longest_len=0;
    int temp_len=0;
    int i=0;
    public int lengthOfLongestSubstring(String s) {
        //firstly change string to char array
        char[] arr=s.toCharArray();
        //initialize with false
        for(int i=0;i<95;i++)
            repeat_char[i]=-1;
            
        //iter all char to make sure 
        for(;i<arr.length;i++)
            checkIfShowed(arr[i]);
            
        if(temp_len>longest_len)
            longest_len=temp_len;
        return longest_len;
    }
    
    public void checkIfShowed(char ch)
    {
        int num=(int)(ch-'!')+1;
        if(repeat_char[num]==-1){
            repeat_char[num]=i;
            temp_len++;
        }
        else{
            //let i be the location of last same char
            //and again scan all chars
            i=repeat_char[num];
            for(int j=0;j<95;j++)
                repeat_char[j]=-1;
            if(temp_len>longest_len)
                longest_len=temp_len;
            temp_len=0;
        }
    }
}