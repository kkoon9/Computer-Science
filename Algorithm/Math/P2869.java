
/**
 * @desc 나무 막대를 모두 올라가려할 때 걸리는 시간을 구하는 프로그램
 * @param V(나무 막대 길이), A(낮에 올라가는 길이), B(밤에 미끄러지는 길이)
 * @return 달팽이가 나무 막대를 모두 올라가는데 며칠이 걸리는지 출력 
 */
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    System.out.println(P2869());
  }

  static long P2869() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long answer = 0;
    String[] str = br.readLine().split(" ");
    long A = Long.parseLong(str[0]);
    long B = Long.parseLong((str[1]));
    long V = Long.parseLong((str[2]));
    V -= B;
    A -= B;
    if (V == 0 || A == 0 || V < A)
      return 1;
    answer = V / A;
    if (V % A != 0)
      answer++;
    return answer;
  }
}