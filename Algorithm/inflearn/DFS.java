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

/**
 * @desc 경로 탐색
 * @param 정수 N, 경로의 개수 M, 경로를 담은 길이가 M인 배열
 * @return 경로탐색
 */
class Question64 {
  boolean[][] matrix;
  boolean[] visit;
  int answer = 0;
  int depth;

  public int solution(int N, int M) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer;
    matrix = new boolean[N + 1][N + 1];
    visit = new boolean[N + 1];
    depth = N;
    for (int i = 1; i <= M; i++) {
      stringTokenizer = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(stringTokenizer.nextToken());
      int b = Integer.parseInt(stringTokenizer.nextToken());
      matrix[a][b] = true;
    }
    visit[1] = true;
    DFS(1, 1);
    return answer;
  }

  void DFS(int val, int count) {
    if (val == depth || count == depth) {
      answer++;
      return;
    }
    for (int i = 1; i <= depth; i++) {
      if (!matrix[val][i] || visit[i])
        continue;
      visit[i] = true;
      DFS(i, count + 1);
      visit[i] = false;
    }
  }
}

/**
 * @desc 미로 탐색
 * @param 정수 N, 경로의 개수 M, 경로를 담은 길이가 M인 배열
 * @return 미로 탐색
 */
class Question65 {
  final int SIZE = 7;
  int[][] matrix = new int[SIZE + 1][SIZE + 1];
  boolean[][] visit = new boolean[SIZE + 1][SIZE + 1];
  int[] dx = { 0, 0, 1, -1 };
  int[] dy = { 1, -1, 0, 0 };
  int answer = 0;

  public int solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer;
    for (int i = 1; i <= SIZE; i++) {
      stringTokenizer = new StringTokenizer(br.readLine());
      for (int j = 1; j <= SIZE; j++) {
        matrix[i][j] = Integer.parseInt(stringTokenizer.nextToken()) == 1 ? 0 : 1;
      }
    }
    visit[1][1] = true;
    DFS(1, 1);
    return answer;
  }

  void DFS(int x, int y) {
    if (x == SIZE && y == SIZE) {
      answer++;
      return;
    }
    for (int i = 0; i < 4; i++) {
      int nextX = dx[i] + x;
      int nextY = dy[i] + y;
      if (nextX <= 0 || nextX > SIZE || nextY <= 0 || nextY > SIZE)
        continue;
      if (matrix[nextX][nextY] == 0 || visit[nextX][nextY])
        continue;
      visit[nextX][nextY] = true;
      DFS(nextX, nextY);
      visit[nextX][nextY] = false;
    }
  }
}

/**
 * @desc 가중치 최소 비용 경로를 구하는 프로그램
 * @param 정수 N, 경로의 개수 M, 경로를 담은 길이가 M인 배열
 * @return 최소 비용
 */
class Question67 {
  int[][] matrix;
  boolean[] visit;
  int answer = Integer.MAX_VALUE;
  int depth;

  public int solution(int N, int M) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer;
    matrix = new int[N + 1][N + 1];
    visit = new boolean[N + 1];
    depth = N;
    for (int i = 1; i <= M; i++) {
      stringTokenizer = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(stringTokenizer.nextToken());
      int b = Integer.parseInt(stringTokenizer.nextToken());
      int c = Integer.parseInt(stringTokenizer.nextToken());
      matrix[a][b] = c;
    }
    DFS(1, 1, 0);
    return answer;
  }

  void DFS(int val, int count, int sum) {
    if (val == depth || count == depth) {
      if (sum < answer) {
        answer = sum;
      }
      return;
    }
    for (int i = 1; i <= depth; i++) {
      if (matrix[val][i] == 0 || visit[i])
        continue;
      visit[i] = true;
      DFS(i, count + 1, sum + matrix[val][i]);
      visit[i] = false;
    }
  }
}
