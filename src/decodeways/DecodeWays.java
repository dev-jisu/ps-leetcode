package decodeways;

import java.util.HashSet;
import java.util.Set;

class Main {
    public static void main(String[] args) {

        String test1 = "11106";
        Solution sol = new Solution();

        System.out.println(sol.numDecodings(test1));
    }
}

class Solution {

    Set<String> set = new HashSet<>();

    public int numDecodings(String s) {
        for (int i = 1; i <= 26; i++) {
            set.add(String.valueOf(i));
        }
        int[] memo = new int[s.length() + 1];
        memo[0] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 1; i < s.length(); i++) {

            if (set.contains(s.substring(i-1, i)) ) {
                memo[i] += memo[i - 1];
            }
            if (i >= 2) {
                if (set.contains(s.substring(i-2, i))) {

                    memo[i] +=  memo[i-2];
                }
            }
        }

        return memo[s.length()-1];
    }

}