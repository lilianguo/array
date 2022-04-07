/**
 * 1048. Longest String Chain
 * Medium
 *
 * You are given an array of words where each word consists of lowercase English letters.
 *
 * wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in wordA without changing the order of the other characters to make it equal to wordB.
 *
 *     For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".
 *
 * A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is a predecessor of word2, word2 is a predecessor of word3, and so on. A single word is trivially a word chain with k == 1.
 *
 * Return the length of the longest possible word chain with words chosen from the given list of words.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["a","b","ba","bca","bda","bdca"]
 * Output: 4
 * Explanation: One of the longest word chains is ["a","ba","bda","bdca"].
 *
 * Example 2:
 *
 * Input: words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
 * Output: 5
 * Explanation: All the words can be put in a word chain ["xb", "xbc", "cxbc", "pcxbc", "pcxbcf"].
 *
 * Example 3:
 *
 * Input: words = ["abcd","dbqca"]
 * Output: 1
 * Explanation: The trivial word chain ["abcd"] is one of the longest word chains.
 * ["abcd","dbqca"] is not a valid word chain because the ordering of the letters is changed.
 *
 *
 *
 * Constraints:
 *
 *     1 <= words.length <= 1000
 *     1 <= words[i].length <= 16
 *     words[i] only consists of lowercase English letters.
 */
class Solution {

  /**
   * Let NNN be the number of words in the list and LLL be the maximum possible length of a word.
   *
   *     Time complexity: O(N * (log N + L ^ 2).
   *
   *     Sorting a list of size NNN takes O(Nlog⁡N) time. Next, we use two for loops in which the outer loop runs for O(N)Oiterations and the inner loop runs for O(L ^ 2)iterations in the worst case scenario. The first LLL is for the inner loop and the second LLL is for creating each predecessor. Thus the overall time complexity is O(Nlog⁡N+(N⋅L2))O(N \log N + (N \cdot L ^ 2))O(NlogN+(N⋅L2)) which equals O(N⋅(log⁡N+L2))O(N \cdot (\log N + L ^ 2))O(N⋅(logN+L2)).
   *
   *     Space complexity: O(N).
   *
   *     We use a map to store the length of the longest sequence formed with each of the NNN words as the end word.
   * @param words
   * @return
   */
  public int longestStrChain(String[] words) {
    if (words == null) return 0;
    if (words.length < 2) return words.length;

    Arrays.sort(words,(a, b) -> a.length() - b.length());
    int max = 1;
    HashMap<String, Integer> map = new HashMap<>();
    for (String word : words) {
      int currMax = 1;
      for (int i = 0; i < word.length(); i++) {
        StringBuilder sb = new StringBuilder(word);
        sb.deleteCharAt(i);
        if (map.containsKey(sb.toString())) {
          currMax = Math.max(currMax ,map.get(sb.toString()) + 1);
        } else {
          currMax = Math.max(currMax, 1);
        }
      }
      map.put(word, currMax);
      max = Math.max(max, currMax);
    }

    return max;
  }
}