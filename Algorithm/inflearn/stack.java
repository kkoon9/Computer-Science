/**
 * @desc 무작위로 출발한 기차들을 1~N 순서로 도착할 수 있게 교차로에서 대기하게 하는 프로그램
 * @param 정수(N), 출발한 순서대로 기차들의 번호
 * @return 교차로에 방문한 기차를 P, O로 나타내는 문자열 or impossible
 */
class Question55 {
  public String solution(int N) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String answer = "";
    int[] arr = new int[N];
    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(stringTokenizer.nextToken());
    }
    Stack<Integer> st = new Stack<>();
    int i = 0;
    int arriveSeq = 1;
    while (i < N) {
      if (!st.isEmpty() && st.peek() == arriveSeq) {
        st.pop();
        answer += "O";
        arriveSeq++;
      } else {
        st.push(arr[i++]);
        answer += "P";
      }
    }
    while (!st.isEmpty()) {
      if (arriveSeq++ != st.peek()) {
        answer = "impossible";
        break;
      }
      st.pop();
      answer += "O";
    }
    return answer;
  }
}
