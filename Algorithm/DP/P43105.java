/**
 * 문제 이름 : 정수 삼각형
 * 작성자 : kkoon9
 * 날짜 : 2020.01.31
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/43105
 * DP 문제
 * 삼각형의 꼭대기에서 바닥까지 이어지는 경로 중, 거쳐간 숫자의 합이 가장 큰 경우를 찾는다.
 * triangle : 삼각형의 정보가 담긴 배열 (매개변수)
 * ********   해결 방법    **************
 *triangle를 2차원 배열로 해서 풀이하였다.
 * */
class Solution {

    public int solution(int[][] triangle) {
        int answer = 0;
        int len = triangle.length;
        int[][]triangle = new int[len][len];
       triangle[0][0] = triangle[0][0];
        for (int i = 1; i < len; i++) {
           triangle[i][0] =triangle[i - 1][0] + triangle[i][0];
           triangle[i][i] =triangle[i - 1][i - 1] + triangle[i][i];
        }
        for(int i =2 ;i<len;i++) {
            for(int j=1;j<i;j++){
               triangle[i][j] = Math.max(memo[i-1][j-1],triangle[i-1][j]) + triangle[i][j];
            }
        }
        answer =triangle[len-1][0];
        for(int i = 1;i<len;i++) {
            if(answer <triangle[len-1][i])
                answer =triangle[len-1][i];
        }
        return answer;
    }
}
// 리팩터링 코드
class Solution_Refactoring {
    public int solution(int[][] triangle) {
        int answer = 0;
        int len = triangle.length;
        for (int i = 1; i < len; i++) {
            triangle[i][0] += triangle[i - 1][0];
            triangle[i][i] += triangle[i - 1][i - 1];
            for (int j = 1; j < i; j++) {
                triangle[i][j] += Math.max(memo[i - 1][j - 1], triangle[i - 1][j]);
            }
        }
        answer = triangle[len - 1][0];
        for (int i = 1; i < len; i++) {
            if (answer < triangle[len - 1][i])
                answer = triangle[len - 1][i];
        }
        return answer;
    }
}