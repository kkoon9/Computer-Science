/**
 * 문제 이름 : 완주하지 못한 선수
 * 작성자 : kkoon9
 * 날짜 : 2019.12.01
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/42576
 * HashMap을 사용한 문제!
 * (+) getOrDefault를 사용하여 코드 리펙토링을 실시하였다.
 * (+) keySet하고 get하는 방법은 비효율적인 방법이다 : HashMap을 두 번 체크하기 때문!
 * (=>) 그렇기 때문에 entrySet을 이용하여 key와 value를 한 번에 받아왔다.
 * */
import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap();

        for(String part : participant)
            hm.put(part, hm.getOrDefault(part, 0) + 1);           
        for(String comp : completion) {
            hm.put(comp, hm.get(comp) - 1);
        }
        for(Map.Entry<String, Integer> entry : hm.entrySet()) {
            String player = entry.getKey();
            int value = entry.getValue();
            if(value == 1){
                answer = player;
                break;
            }
        }
        return answer;
    }
}