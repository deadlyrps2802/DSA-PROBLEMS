class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int right = 0;

        for(int i = 0; i<piles.length; i++){
            if(piles[i] > right){
                right = piles[i];
            }
        }
       
       int res = right;
        int left = 1;
        while(left <= right){

            int k = left + (right - left)/2;

            long hours = 0;

            for(int p : piles){
                hours += (int) Math.ceil((double) p/k);
            }

                if(hours <= h){
                  res = Math.min(res,k);
                  // jb humara answer h se kam aa rha ho
                  right = k-1;

                }
                else{
                    // jb h se bda aayega toh hum khane ke rate ko bdha denge
                    left = k + 1;

                }
            
        }

        return res; 
    }
}