/**
 * @desc 이진 탐색
 * @param 정수(N), 찾으려는 값(find), N의 길이를 가지는 배열(arr)
 * @return 찾으려는 값의 index
 */
class BinarySearch {
  public int solution(int N, int find, int[] arr) {
    int answer = 0;
    Arrays.sort(arr);
    int start = 0;
    int end = N - 1;
    int middle = N / 2 + 1;
    while (true) {
      System.out.println(start + " " + middle + " " + end);
      if (arr[middle] == find) {
        answer = middle;
        break;
      } else if (arr[middle] < find) {
        start = middle;
        middle = (end + start) / 2 + 1;
      } else {
        end = middle;
        middle = (end + start) / 2 + 1;
      }
    }
    return answer;
  }
}