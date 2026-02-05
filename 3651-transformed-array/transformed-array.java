class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
         int i = 0;
         
        while(i<n){
           if(nums[i] > 0){
            int  k = (i+ nums[i])%n;
            arr[i] = nums[k];
           }
            else if(nums[i] < 0){
               int z = (i + nums[i]%n + n)%n;
        
                arr[i] = nums[z];
            }
            else{
                arr[i] = nums[i];
            }
          
            i++;
        }
        return arr;
    }
}