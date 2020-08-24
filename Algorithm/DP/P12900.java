/**
 * 문제 이름 : 2 x n 타일링
 * 작성자 : kkoon9
 * 날짜 : 2020.01.27
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/12900
 * DP 문제
 * */
class Solution {
    int [] memo = new int[60001];
    
    public int solution(int n) {
        int answer = 0;
        memo[0] = 1;
        memo[1] = 1;
        for(int i = 2 ;i <=n;i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
            memo[i] %= 1000000007;
        }
        return answer = memo[n];
    }
}