
/**
 * @desc 손익분기점을 구하는 프로그램
 * @param A(고정 비용), B(가변 비용) C(노트북 가격)
 * @return 손익분기점 즉 최초로 이익이 발생하는 판매량을 출력
 */
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    System.out.println(P1712());
  }

  static long P1712() throws IOException {
    long answer = 0;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    long A = Integer.parseInt(input[0]);
    long B = Integer.parseInt(input[1]);
    long C = Integer.parseInt(input[2]);
    if (B >= C)
      return -1;
    C -= B;
    answer = A / C + 1;
    return answer;
  }
}