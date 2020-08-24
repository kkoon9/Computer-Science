/**
 * 문제 이름 : 타겟 넘버
 * 작성자 : kkoon9
 * 날짜 : 2020.01.27
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/43165
 * numbers : 사용할 수 있는 숫자가 담긴 배열 (매개변수)
 * target : 타겟 넘버 (매개변수)
 * 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return
 * ********   해결 방법     **************
 * DFS로 풀이하였다.
 * dfs 함수의 매개변수로는 numbers, target, 그리고 numbers의 index인 depth가 있다.
 * depth와 numbers.length와 같아지면 dfs 함수가 끝난다.
 * depth에 해당하는 numbers 값을 매개변수로 재귀함수로 해준다.
 * depth에 해당하는 numbers 값에 -1 곱해준 값을 매개변수로 재귀함수로 해준다.
 * 왜 why? 더하거나 뺀 결과를 얻기 위해!
 * 마지막 numbers.length와 같아지면 numbers의 값을 더해준 sum과 target이 같다면 answer++ 해준다.
 * ********    배운 점      **************
 * stream을 처음 사용해보았다.
 * 출처 : https://jeong-pro.tistory.com/165 
 * */
import java.util.*;

class Solution {
    static int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target);
        return answer;
    }
    public void dfs(int[] numbers, int depth, int target) {
        if(depth == numbers.length) {
            int sum = Arrays.stream(numbers).sum();
            if(sum == target){
                answer++;
            }
        } else {
            dfs(numbers, depth + 1, target);
            numbers[depth] *= -1;
            dfs(numbers, depth + 1, target);
        }
    }
}