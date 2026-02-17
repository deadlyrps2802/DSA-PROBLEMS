class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> times = new ArrayList<>();
        
        // Iterate through all possible hours (0-11) and minutes (0-59)
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                // Integer.bitCount counts the number of set bits (1s) in binary
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    // Format minutes with a leading zero if less than 10
                    times.add(String.format("%d:%02d", h, m));
                }
            }
        }
        return times;
    }
}