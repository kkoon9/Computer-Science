/**
 * 문제 이름 : 예산
 * 작성자 : kkoon9
 * 날짜 : 2020.01.26
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/43237
 * budgets : 각 지방에서 요청하는 예산이 담긴 배열 (매개변수)
 * M : 총 예산 (매개변수)
 * 1. 모든 요청이 배정될 수 있는 경우에는 요청한 금액을 그대로 배정한다.
 * 2. 모든 요청이 배정될 수 없는 경우에는 특정한 정수 상한액을 계산하여 그 이상인 예산요청에는 모두 상한액을 배정한다. 
 * 3. 상한액 이하의 예산요청에 대해서는 요청한 금액을 그대로 배정한다.
 * 위의 조건을 모두 만족하는 상한액을 return하라.
 * ********    해결 방법      **************
 * 이분탐색 알고리즘을 사용하였다.
 * budgets에 1씩 더해가면서 상한액을 찾아보았다.
 * 
 * */
class Solution {
    public int solution(int[] budgets, int M) {
        int answer = 0;
        int left = 0;
        int right = 0; // 최대 budget
        for (int budget : budgets) {
            if (budget > right) {
                right = budget;
// answer의 최대 값은 budgets의 요소의 최대값
            }
        }
        int middle = 0;
        while (left <= right) {
            long sum = 0;
            middle = (left + right) / 2;
            for (int budget : budgets) {
                if (budget >= middle) {
                    sum += middle;
                }
                else {
                    sum += budget;
                }
            }
            if (sum > M) {
                right = middle - 1;
            }
            else {
// answer에 의한 예산의 합은 예산 M보다 작아야 하므로 해당 분기에서 처리
                answer = middle;
                left = middle + 1;
            }
        }
        return answer;
    }
}