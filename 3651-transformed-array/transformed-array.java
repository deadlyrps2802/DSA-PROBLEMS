class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
         int i = 0;
         
        while(i<n){
           if(nums[i]==0){
            arr[i] = nums[i];
           }
           
            else {
               int z = (i + nums[i]%n + n)%n;
        
                arr[i] = nums[z];
            }
        
          
            i++;
        }
        return arr;
    }
}