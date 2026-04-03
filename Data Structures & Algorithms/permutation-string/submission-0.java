class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] freq = new int[26];
        for (char c : s1.toCharArray()) freq[c - 'a']++;

        int left = 0, right = 0, count = s1.length();

        while (right < s2.length()) {
            if (freq[s2.charAt(right) - 'a']-- > 0) count--;
            right++;

            if (count == 0) return true;

            if (right - left == s1.length()) {
                if (freq[s2.charAt(left) - 'a']++ >= 0) count++;
                left++;
            }
        }

        return false;
    }
}