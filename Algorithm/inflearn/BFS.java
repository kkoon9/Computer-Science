/**
 * @desc 1~10000 좌표 속에 숨어있는 송아지를 몇 번만에 찾을 수 있는지 구하는 프로그램
 * @param 현 위치(N), 송아지의 위치(M)
 * @return 송아지를 찾아내는 횟수
 */
class Question71 {
  boolean[] visit = new boolean[10001];
  Queue<Integer> q = new LinkedList<>();
  int count = -1;
  int[] dx = { 1, -1, 5 };

  public int solution(int N, int M) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    q.add(N);
    visit[N] = true;
    while (!q.isEmpty()) {
      int size = q.size();
      count++;
      for (int s = 0; s < size; s++) {
        int num = q.poll();
        if (num == M) {
          q.clear();
          break;
        }
        for (int i = 0; i < 3; i++) {
          int nextX = num + dx[i];
          if (nextX <= 0 || nextX > 10000 || visit[nextX])
            continue;
          q.add(nextX);
          visit[nextX] = true;
        }
      }
    }
    return count;
  }
}