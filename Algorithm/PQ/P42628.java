/**
 * 문제 이름 : 이중우선순위큐
 * 작성자 : kkoon9
 * 날짜 : 2019.12.17
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/42628
 * Priority Queue를 사용한 문제!
 * 우선순위큐를 두 개 선언하여 max, min을 찾는다.
 * ********    배운 점      **************
 * 우선순위큐의 메서드인 remove는 idx가 아닌 원소를 찾아서 remove해줄 수 있다.
 * String의 split은 특정 문자열을 기준으로 문자열을 자를 수 있다.
 * (+) split의 반환값은 String 배열이다.
 * */
import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0,0};
        PriorityQueue <Integer> pqMax = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue <Integer> pqMin = new PriorityQueue<>();
        for(String operation : operations) {
            String[] splitOper = operation.split(" ");
            if(splitOper[0].equals("I")){
                pqMax.add(Integer.parseInt(splitOper[1]));
                pqMin.add(Integer.parseInt(splitOper[1]));
            }
            else if(splitOper[0].equals("D")){
                if(!pqMax.isEmpty()) { // 두 pq의 원소는 같으므로 한 개만 조사해주면 된다.
                    if(splitOper[1].equals("1")){
                        int max = pqMax.poll();
                        pqMin.remove(max);
                    }
                    else {
                        int min = pqMin.poll();
                        pqMax.remove(min);
                    }
                }
            }
        }
        if (!pqMax.isEmpty()) {
            answer[0] = pqMax.peek();
            answer[1] = pqMin.peek();
        }
        return answer;
    }
}