/**
 * 문제 이름 : 구명보트
 * 작성자 : kkoon9
 * 날짜 : 2020.01.17
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/42885
 * Greedy Algorithm를 사용한 문제!
 * ********   제한 사항      **************
 * 구명보트는 작아서 한 번에 최대 2명씩 밖에 탈 수 없고, 무게 제한(limit)도 있습니다.
 * 구명보트를 최대한 적게 사용하여 모든 사람을 구출하려고 합니다.
 * people : 사람들의 몸무게를 담은 배열 (매개변수)
 * limit : 구명보트의 무게 제한 (매개변수)
 * 무인도에 갇힌 사람은 1 ~ 50,000 입니다.
 * 각 사람의 몸무게는 40 ~ 240 입니다..
 * 구명보트의 무게 제한은 40 ~ 240 입니다.
 * 사람들을 구출할 수 없는 경우는 없습니다.
 * ********    풀이 방법      **************
 * deque를 사용하였다.
 * people을 정렬하여 deque에 넣어준 뒤, 최대 최소를 더해준다.
 * 최대 최소를 더해서 limit을 넘지 않으면 deque에서 앞 뒤로 빼준다.
 * 최대 최소를 더해서 limit을 넘으면 최대만 빼준다. 
 * */

import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int last, first;
        int len = people.length;
        Deque <Integer> dq = new LinkedList<Integer>();
        Arrays.sort(people);
        for(int i = 0; i < len ;i++) {
            dq.addLast(people[i]);
        }
//        for(int i : dq) {
//            System.out.println(i);
//        }
        while(dq.size() > 1) {
            last = dq.peekLast();
            first = dq.peekFirst();
            if (last + first <= limit) {
                answer++;
                dq.pollFirst();
                dq.pollLast();
            } else {
                answer++;
                dq.pollLast();
            }
//            for(int i : dq) {
//                System.out.println(i);
//            }
        }
        if(!dq.isEmpty()) answer++;
        return answer;
    }
}