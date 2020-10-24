
import java.util.HashMap;
import java.util.Map;

class Solution {
  public String solution(String[] participant, String[] completion) {
    String answer = "";
    HashMap<String, Integer> hm = new HashMap();

    for (String part : participant)
      hm.put(part, hm.getOrDefault(part, 0) + 1);
    for (String comp : completion) {
      hm.put(comp, hm.get(comp) - 1);
    }
    for (Map.Entry<String, Integer> entry : hm.entrySet()) {
      String player = entry.getKey();
      int value = entry.getValue();
      if (value == 1) {
        answer = player;
        break;
      }
    }
    return answer;
  }
}