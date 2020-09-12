import java.util.*;

class Solution {
  public int solution(int[] d, int budget) {
    int answer = 0;
    Arrays.sort(d);
    for (int val : d) {
      if (budget - val < 0) {
        break;
      }
      budget -= val;
      answer++;
    }
    return answer;
  }
}