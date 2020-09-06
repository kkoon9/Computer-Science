/**
 * @desc 부분집합을 구하는 프로그램(DFS)
 * @param 정수 N
 * @return 부분집합을 출력
 */
class Question59 {
  int depth;
  final int MAX = 11;
  boolean[] arr = new boolean[MAX];

  public void solution(int N) {
    depth = N;
    dfs(1);
  }

  private void dfs(int i) {
    if (i == depth + 1) {
      for (int index = 1; index <= depth; index++) {
        if (arr[index])
          System.out.print(index + " ");
      }
      System.out.println();
      return;
    }
    arr[i] = true;
    dfs(i + 1);
    arr[i] = false;
    dfs(i + 1);
  }
}

/**
 * @desc 합이 같은 부분집합이 있는지 구하는 프로그램(DFS)
 * @param 정수 N, 길이가 N인 배열
 * @return 합이 같은 부분집합이 있으면 YES, 아니면 NO를 출력
 */
class Question60 {
  int depth;
  boolean answer = false;
  int[] arr;
  boolean[] visit;

  public void solution(int N) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    depth = N;
    arr = new int[N];
    visit = new boolean[N];
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(stringTokenizer.nextToken());
    }
    dfs(0);
    System.out.println((answer ? "YES" : "NO"));
  }

  private void dfs(int val) {
    if (answer)
      return;
    int sum1 = 0;
    int sum2 = 0;
    if (val >= depth) {
      for (int i = 0; i < depth; i++) {
        if (visit[i]) {
          sum1 += arr[i];
        } else {
          sum2 += arr[i];
        }
      }
      if (sum1 == sum2) {
        answer = true;
      }
      return;
    }
    visit[val] = true;
    dfs(val + 1);
    visit[val] = false;
    dfs(val + 1);
  }
}

/**
 * @desc 주어진 배열로 특정 수를 만들 수 있는 경우의 수를 구하는 프로그램
 * @param 정수 N, 특정 수 M, 길이가 N인 배열
 * @return 특정수를 만들 수 있는 경우의 수, 만들 수 없다면 -1을 출력
 */
class Question61 {
  int depth;
  int answer = 0;
  int[] arr;
  int[] visit;
  int target;

  public int solution(int N, int M) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    depth = N;
    target = M;
    arr = new int[N];
    visit = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(stringTokenizer.nextToken());
    }
    dfs(0);
    answer = answer == 0 ? -1 : answer;
    return answer;
  }

  private void dfs(int val) {
    if (val >= depth) {
      int sum = 0;
      for (int i = 0; i < depth; i++) {
        sum += visit[i];
      }
      if (sum == target) {
        answer++;
      }
      return;
    }
    visit[val] = arr[val];
    dfs(val + 1);
    visit[val] = -arr[val];
    dfs(val + 1);
    visit[val] = 0;
    dfs(val + 1);
  }
}