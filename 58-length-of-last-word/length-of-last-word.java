class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0;
        int i = s.length() - 1;

        // Step 1: Peeche se jo bhi extra spaces hain unhe skip karein
        // Example: "Hello World   " -> pointer 'd' par le aayega
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // Step 2: Ab actual word ke characters count karein
        // Jab tak space nahi milta ya string khatam nahi hoti
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }
}