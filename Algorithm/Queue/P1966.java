
/**
 * @ deque를 이용하여 우선순위와 같은 값을 deque에서 제외해주면서 찾아준다.
 */
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    P1966();
  }

  static int T, N, target;

  public static void P1966() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    T = Integer.parseInt(br.readLine());
    for (int test_case = 0; test_case < T; test_case++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int answer = 0;
      N = Integer.parseInt(st.nextToken());
      target = Integer.parseInt(st.nextToken());
      int[] priors = new int[N];
      Deque<Job> deque = new LinkedList<>();
      st = new StringTokenizer(br.readLine());
      for (int index = 0; index < N; index++) {
        priors[index] = Integer.parseInt(st.nextToken());
        deque.add(new Job(index, priors[index]));
      }
      Arrays.sort(priors);
      int index = N - 1;
      while (index >= 0 && !deque.isEmpty()) {
        Job job = deque.pollFirst();
        if (priors[index] == job.prior) {
          answer++;
          index--;
          if (target == job.index) {
            break;
          }
        } else {
          deque.add(job);
        }
      }
      System.out.println(answer);
    }
  }

  private static class Job {
    int index;
    int prior;

    Job(int index, int prior) {
      this.index = index;
      this.prior = prior;
    }
  }
}