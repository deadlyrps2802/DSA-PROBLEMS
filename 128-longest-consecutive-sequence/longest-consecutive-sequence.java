class Solution {
    public int longestConsecutive(int[] nums) {
    //     Arrays.sort(nums);
    //     int cnt = 0;
    //     int Last = Integer.MIN_VALUE;
    //     int longest = 1;


    //     for(int i = 0; i<nums.length; i++){
    //         if(nums[i] - 1 == Last){
    //             cnt += 1;
    //             Last = nums[i];
    //         }
    //         else if(nums[i] != Last){
    //             cnt = 1;
    //             Last = nums[i];
    //         }
    //          longest = Math.max(longest,cnt);
    //     }
       
     
    //  return longest;

    if(nums.length == 0) return  0;
    Set<Integer> set = new HashSet<>();
    for(int a : nums){
        set.add(a);
    }

    int longest = 1;

       for(int x : set){
        if(!set.contains(x-1)){
            int curr_num = x;
            int cnt = 1;
        

        while(set.contains(curr_num+1)){
            curr_num++;
            cnt++;
        }

        longest = Math.max(longest,cnt);
       }
       }
       return longest;
    }
}