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