/**
 * 문제 이름 : 다리를 지나는 트럭
 * 작성자 : kkoon9
 * 날짜 : 2019.12.11
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/42583
 * Queue를 사용한 문제!
 ********    첫 번째 시도   **************
 * truck_weight를 큐에 넣어주어 peek()값과 weight 값을 넣어준 limit과 비교해준다.
 * 다리를 지날 수 있으면 limit에 큐의 poll()값을 빼준 뒤, 다음 peek() 값을 비교해준다.
 * testcase 3,7 빼고 다 틀림
 * 접근이 잘못된 것 같다.
 * 반례 : bridge_length : 2, weight : 10, truck_weight = {3,5,2,5,7};
 * return : 9, 기댓값 : 8
 ********    두 번째 시도   **************
 * 다리를 건너는 시간, time에 초점을 맞춰서 풀어봤으나 풀기 힘들었다.
 * */
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue <Integer> arriveQ = new LinkedList<>();
        Queue <Integer> reachQ = new LinkedList<>();
        int answer = 1;
        int limit = weight;
        int buffer;
        int time = bridge_length - 1;
        for(int a : truck_weights){
            arriveQ.add(a);
        }
        buffer = arriveQ.poll();
        limit -= buffer;
        reachQ.add(buffer);
        while(!arriveQ.isEmpty()){
            time--;
            answer++;
            if(time == 0){
                limit += reachQ.poll();
                time = bridge_length;
            }
            if(limit >= arriveQ.peek()){
                buffer = arriveQ.poll();
                limit -= buffer;
                reachQ.add(buffer);
            } else {
                limit += reachQ.poll();
                answer += time;
                time = bridge_length;
            }
        }
        return answer;
    }
}
