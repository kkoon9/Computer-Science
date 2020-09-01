/**
 * @desc 두 배열의 교집합을 구하는 프로그램
 * @param 정수 aSize, bSize, 길이가 aSize, bSize인 배열
 * @return 교집합
 */
class Intersection {
  public int[] solution(int aSize, int[] A, int bSize, int[] B) {
    int[] answer;
    List<Integer> list = new LinkedList<>();
    HashSet<Integer> hs = new HashSet<>();
    for (int i = 0; i < aSize; i++) {
      if (!hs.add(A[i])) {
        list.add(A[i]);
      }
    }
    for (int i = 0; i < bSize; i++) {
      if (!hs.add(B[i])) {
        list.add(B[i]);
      }
    }
    answer = new int[list.size()];
    int i = 0;
    for (int num : list) {
      answer[i++] = num;
    }
    Arrays.sort(answer);
    return answer;
  }
}