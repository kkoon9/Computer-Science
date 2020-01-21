/**
 * 문제 이름 : 저울
 * 작성자 : kkoon9
 * 날짜 : 2020.01.21
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/42886
 * weight : 저울추가 담긴 배열 (매개변수)
 * 이 추들로 측정할 수 없는 양의 정수 무게 중 최솟값을 찾는 문제
 *  * ********    해결 방법      **************
 * 문제 풀이방법을 알았다면 굉장히 간단한 문제였다.
 * (1). weight를 정렬해준다.
 * (2). answer의 초기값을 1로 준 뒤, weight과 차례로 비교해준다.
 * (3). 만약 weight이 answer보다 크다면 종료해준 뒤, answer를 return해준다.
 * (4). 만약 weight이 answer보다 작다면 answer+=weight를 해준다.
 * */
import java.util.*;
class Solution {
    public int solution(int[] weight) {
        int answer = 1;
        int len = weight.length;
        Arrays.sort(weight);
        for(int i =0; i < len; i++){
            if(answer < weight[i]) break;
            answer += weight[i];
        }
        return answer;
    }
}