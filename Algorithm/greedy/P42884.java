/**
 * 문제 이름 : 단속카메라
 * 작성자 : kkoon9
 * 날짜 : 2020.01.21
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/42884
 * routes : 차랑의 이동 경로 (매개변수)
 * 차량의 대수는 1 ~ 10,000 이다.
 * 차량의 진입/진출 지점에 카메라가 설치되어 있어도 카메라를 만난 것으로 간주한다.
 * 차량의 진입 지점, 진출 지점은 -30,000 ~ 30,000 이다.
 * ********    해결 방법      **************
 * 문제 풀이방법을 알았다면 굉장히 간단한 문제였다.
 * (1). 차량들의 진출 시간을 오름차순으로 정렬해준다.
 * (2). 진출 시간이 가장 빠른 차량이 min이 된다.
 * (3). 다른 차량들의 진입 시간과 min을 비교해준다.
 *    (3-1). 어떠한 차량의 진입 시간이 min보다 빠르다면(min < route[0])
 *           min을 그 차량의 진출시간으로 바꿔준 뒤, answer을 추가해준다.
 * */

import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        int min = Integer.MIN_VALUE;
        Arrays.sort(routes, (a,b) -> Integer.compare(a[1], b[1]));
        for(int[] route : routes) {
            if(min < route[0]) {
                min = route[1];
                answer++;
            }
        }
        return answer;
    }
}