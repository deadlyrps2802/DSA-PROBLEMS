class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
    if(nums== null || k == 0) return new int[0];
    int n = nums.length;
    int result[] = new int[n-k+1];

    Deque<Integer> dq = new ArrayDeque<>();
   
   for(int i = 0; i<n; i++){

        while(!dq.isEmpty() && dq.peekFirst() <= i - k){
            dq.pollFirst();
        }

        while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
            dq.pollLast();
        }
        dq.offerLast(i);
         
         if(i>= k-1){
            result[i-k+1] = nums[dq.peekFirst()];
         }
     }


   return result;
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //TLE ---> O(n*k)----->
      //  Map<Integer> map = new HashMap<>();
    //     ArrayList<Integer> arr = new ArrayList<>();
    //     int max = Integer.MIN_VALUE;
    //     int n = nums.length;

    //     int i = 0;
    //     int j = k-1;
       
    //    while(j<n){
    //     max = Integer.MIN_VALUE;
    //     for(int l = i; l<=j ; l++){
    //         if(nums[l] > max){
    //             max = nums[l];
    //         }
    //     }
        
    //     arr.add(max);
    //     i++;
    //     j++;

    //    }

    //       int result[] = new int[arr.size()];

    //       for(int m = 0; m<result.length; m++){
    //            result[m] = arr.get(m);
    //       }

    //       return result;
    }
}