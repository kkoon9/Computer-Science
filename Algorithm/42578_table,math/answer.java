
import java.util.HashMap;
import java.util.Map;

class Solution {
  public int solution(String[][] clothes) {
    int answer = 0;
    int size = clothes.length;
    HashMap<String, Integer> hm = new HashMap();
    for (int i = 0; i < size; i++) {
      hm.put(clothes[i][1], hm.getOrDefault(clothes[i][1], 0) + 1);
    }
    answer = 1;
    for (int value : hm.values()) {
      answer *= (value + 1);
    }
    answer--;
    return answer;
  }
}