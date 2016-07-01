package MedianOfTwoSortedArrays.src;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int i=0,j=0;
        double result=0;
        if(m!=0&&n!=0){
            if((m+n)%2!=0){
                for(int k=0;k<=(m+n)/2;k++){
                    if(i<m&&j<n){
                        if(nums1[i]<nums2[j]){
                            result=nums1[i];
                            i++;
                        }else{
                            result=nums2[j];
                            j++;
                        }
                    }else if(i<m){
                        return (double)nums1[(m+n)/2-n];
                    }else{
                        return (double)nums2[(m+n)/2-m];
                    }
                }
            }
            else{
                for(int k=0;k<(m+n)/2;k++){
                    if(i<m&&j<n){
                        if(nums1[i]<nums2[j]){
                            result=nums1[i];
                            i++;
                        }else{
                            result=nums2[j];
                            j++;
                        }
                    }else if(i<m){
                        i++;
                        result=(double)nums1[(m+n)/2-n-1];
                    }else{
                        j++;
                        result=(double)nums2[(m+n)/2-m-1];
                    }
                }
                if(i<m&&j<n){
                    if(nums1[i]<nums2[j]){
                        return (nums1[i]+result)/2.0;
                    }else{
                        return (result+nums2[j])/2.0;
                    }
                }else if(i<m){
                    return (result+nums1[(m+n)/2-n])/2.0;
                }else{
                    return (result+nums2[(m+n)/2-m])/2.0;
                }
            }
        }else if(m==0){
            if(n%2==0){
                return (nums2[n/2]+nums2[n/2-1])/2.0;
            }else{
                return (nums2[(int)n/2])/1.0;
            }
        }else{
            if(m%2==0){
                return (nums1[m/2]+nums1[m/2-1])/2.0;
            }else{
                return (nums1[(int)m/2])/1.0;
            }
        }
        return result;
    }

}