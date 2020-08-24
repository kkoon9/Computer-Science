/**
 * 문제 이름 : 라면공장
 * 작성자 : kkoon9
 * 날짜 : 2019.12.15
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/42629
 * Priority Queue를 사용한 문제!
 * ********    배운 점      **************
 * Ctrl + Alt + L : 자동정렬
 * */
import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        int len =dates.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(len, Collections.reverseOrder());
        int i = 0;
        while (i < len) {
            if (stock >= k) break;
            pq.add(supplies[i++]);
            if (i < len && stock < dates[i]) {
                stock += pq.poll();
                answer++;
            }
        }
        while(stock < k){
            stock+=pq.poll();
            answer++;
        }
        return answer;
    }
}