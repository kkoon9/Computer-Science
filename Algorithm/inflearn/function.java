/**
 * @desc 자연수 N이 입력되면 1부터 N까지의 수 중 M의 배수합을 출력하는 프로그램
 * @param 3<=M<N<=1000
 * @return 배수합(answer)
 */
class MultipleSum {
  public int solution(int n, int m) {
    int answer = 0;
    for (int i = m; i <= n; i += m) {
      answer += i;
    }
    return answer;
  }
}