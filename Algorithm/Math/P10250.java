
/**
 * @desc 걷는 거리가 가장 짧도록 방을 배정하는 프로그램
 * @param T(테스트 케이스), H(호텔의 층 수), W(각 층의 방 수), N(몇 번째 손님)
 * @return  N 번째 손님에게 배정되어야 하는 방 번호
 */
import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int testcase = Integer.parseInt(input[0]);
    for (int i = 0; i < testcase; i++) {
      input = br.readLine().split(" ");
      int H = Integer.parseInt(input[0]);
      int W = Integer.parseInt(input[1]);
      int N = Integer.parseInt(input[2]);
      int floor = N % H, count = 1;
      int answer;
      if (floor == 0) {
        count--;
        floor = H;
      }
      count += N / H;
      answer = floor * 100 + count;
      System.out.println(answer);
    }
  }
}