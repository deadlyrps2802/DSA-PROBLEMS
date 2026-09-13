class Solution {
    public int findMaxLength(int[] nums) {
      

//         int max_len = Integer.MIN_VALUE;
        

//         for(int i = 0;i<nums.length; i++){
//               int count0 = 0;
//         int count1 = 0;
//           for(int j = i; j<nums.length; j++){
//              if(nums[j] == 0) count0++;
//              else count1++;
//            if(count0 == count1){
//             max_len = Math.max(max_len,j-i+1);

//            }
            
// }        }

//       return max_len;

       Map<Integer,Integer> map = new HashMap<>();
       map.put(0,-1);

       int prefix = 0;
       int max_len = 0;

       for(int i = 0; i<nums.length; i++){
        if(nums[i] == 0){
            prefix += -1;
        }
        else{
            prefix += +1;
        }

        if(map.containsKey(prefix)){
            int len = i - map.get(prefix);
            if(len > max_len){
                max_len  = len;
            }
        }
      else map.put(prefix,i);
        
       }

     return max_len;

    }
}