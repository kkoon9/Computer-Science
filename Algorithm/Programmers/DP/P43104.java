/**
 * 문제 이름 : 타일 장식물
 * 작성자 : kkoon9
 * 날짜 : 2020.01.29
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/43104
 * DP 문제
 * 타일 장식물을 구성하는 정사각형 타일 한 변의 길이를 안쪽 타일부터 시작하여 차례로 적으면 다음과 같다.
 * [1, 1, 2, 3, 5, 8, .]
 * 타일의 개수 N이 주어질 때, N개의 타일로 구성된 직사각형의 둘레를 return 하도록 solution 함수를 작성하시오.
 * N : 타일의 개수 (매개변수)
 * ********   해결 방법    **************
 * 정사각형의 개수가 늘어날수록 정사각형의 변의 길이가 증가한다.
 * 변의 길이는 피보나치 수열로 늘어난다.
 * 둘레의 길이는 Round[N] = Round[N-1] + 2 * memo[N] 이다.
 * */

class Solution {
    public long solution(int N) {
        long [] memo = new long[81];
        long [] Round = new long[81];
        memo[1] = 1;
        memo[2] = 1;
        Round[1] = 4;
        Round[2] = 6;
        for(int i = 3;i <=N;i++) {
            memo[i] = memo[i-1] + memo[i - 2];
            Round[i] = Round[i-1] + 2 * memo[i];
        }
        return Round[N];
    }
}