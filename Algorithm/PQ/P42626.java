/**
 * 문제 이름 : 더 맵게
 * 작성자 : kkoon9
 * 날짜 : 2019.12.15
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/42626
 * Priority Queue를 사용한 문제!
 * 
 * */

import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue();
        for(int val : scoville)
            pq.add(val);
        while(true) {
            int first, second;
            if(pq.peek() >= K){
                break;
            }
            if(!pq.isEmpty()){
                first = pq.poll();
            } else{
                answer = -1;
                break;
            }
            if(!pq.isEmpty()){
                second = pq.poll() * 2;
            } else{
                answer = -1;
                break;
            }
            pq.add(first + second);
            answer++;
        }
        return answer;
    }
}