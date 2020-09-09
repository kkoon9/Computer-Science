/**
 * 문제 이름 : 124 나라의 숫자 작성자 : kkoon9 날짜 : 2020.01.22 링크 :
 * https://programmers.co.kr/learn/courses/30/lessons/12899 n : 자연수 n (매개변수) 124
 * 나라에는 자연수만 존재한다. 124 나라에는 모든 수를 표현할 때 1, 2, 4만 사용한다. n은 500,000,000 이하의 자연수이다.
 * ******** 해결 방법 ************** (1). n % 3 의 결과에 따라 124 나라에서 사용하는 숫자의 뒷자리를 알 수
 * 있다. n % 3 == 0 이면 4 n % 3 == 1 이면 1 n % 3 == 2 이면 2 (2). n을 3으로 나눠준 뒤 (1)을 다시
 * 진행한다. (3). n이 0이 될때까지 진행한다. ******** 틀린 것 ************** n % 3 == 0 이면 n-=1 을
 * 해주어야 한다. ex) n이 21일 때 n-=1을 해주지 않는다면 값이 이상하게 나온다.
 */

class P12899 {
  public String solution(int n) {
    StringBuilder sb = new StringBuilder();
    while (n != 0) {
      switch (n % 3) {
        case 0:
          sb.append(4);
          break;
        case 1:
          sb.append(1);
          break;
        case 2:
          sb.append(2);
          break;
        default:
          break;
      }
      n -= 1;
      n /= 3;
    }
    return sb.reverse().toString();
  }
}

// 더 깔끔한 코드
class Solution {
  public String solution(int n) {
    String[] num = { "4", "1", "2" };
    String answer = "";

    while (n > 0) {
      answer = num[n % 3] + answer;
      n = (n - 1) / 3;
    }
    return answer;
  }
}
