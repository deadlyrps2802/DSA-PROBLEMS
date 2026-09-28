class Solution {
    public int findPeakElement(int[] arr) {
    //     int start =0 ;
    //     int end = nums.length -1;

    //   while(start<end){
    //     int mid = start+(end-start)/2;
    //     if(nums[mid]>nums[mid+1]){
    //         end = mid;

    //     }
    //     else{
    //         start = mid +1;
    //     }
    //   }
    //   return start;

    if(arr.length == 1) return 0;
        int i = 0; 
        int x = 0;
        
        while(i<arr.length){
            
            if(i==0){
                if(arr[i] > arr[i+1]){
                    x = i;
                    break;
                
                }
            }
            else if(i==arr.length-1){
                if(arr[i] > arr[i-1]){
                    x = i;
                    break;
                }
            }
            else{
                if(arr[i] > arr[i+1] && arr[i] > arr[i-1]){
                    x =i;
                    break;
                }
            }
            i++;
        }
        return x;
    }
}