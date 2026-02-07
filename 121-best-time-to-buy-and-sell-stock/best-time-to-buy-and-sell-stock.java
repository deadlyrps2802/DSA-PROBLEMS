class Solution {
    public int maxProfit(int[] prices) {
      
        // Agar prices array khali hai toh 0 profit
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int minPrice = Integer.MAX_VALUE; // Sabse kam daam track karne ke liye
        int maxProfit = 0;               // Maximum profit track karne ke liye

        for (int i = 0; i < prices.length; i++) {
            // Agar aaj ka price purane minPrice se kam hai, toh naya minPrice update karo
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } 
            // Agar aaj bechne par zyada profit ho raha hai, toh maxProfit update karo
            else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }

        return maxProfit;
    }
}
