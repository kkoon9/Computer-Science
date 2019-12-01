import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap();

        int val=0;
        for(String part : participant) {
            if(hm.get(part) == null)
                hm.put(part,1);
            else{
                val = hm.get(part);
                hm.put(part, ++val);
            }                
        }
        for(String comp : completion) {
            val = hm.get(comp) - 1;
            hm.put(comp , val);
        }
        for(String key : hm.keySet()) {
            if(hm.get(key) == 1) answer = key;
        }
        return answer;
    }
}