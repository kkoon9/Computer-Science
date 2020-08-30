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

/**
 * @desc 자연수 A,B가 입력되면 A부터 B까지의 합을 수식과 함께 출력하는 프로그램
 * @param 1<=A<B<=1000
 * @return 수식과 함께 합을 출력(answer)
 */
class SumofNaturalNumber {
  public String solution(int A, int B) {
    String answer = "";
    int sum = 0;
    for (int i = A; i <= B; i++) {
      sum += i;
      answer += String.valueOf(i);
      answer += " + ";
    }
    answer = answer.substring(0, answer.length() - 3);
    answer += " = ";
    answer += String.valueOf(sum);
    return answer;
  }
}

/**
 * @desc 자연수 N이 입력되면 N의 진약수들의 합을 수식과 함께 출력하는 프로그램
 * @param 3<=N<=100
 * @return 수식과 함께 합을 출력(answer)
 */
class ProperDivisor {
  public String solution(int N) {
    String answer = "";
    int sum = 0;
    for (int i = 1; i < N; i++) {
      if (N % i == 0) {
        sum += i;
        answer += String.valueOf(i);
        answer += " + ";
      }
    }
    answer = answer.substring(0, answer.length() - 3);
    answer += " = ";
    answer += String.valueOf(sum);
    return answer;
  }
}