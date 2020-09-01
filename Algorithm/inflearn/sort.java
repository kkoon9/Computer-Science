/**
 * @desc 선택정렬
 * @param 정수(N), N의 길이를 가지는 배열(arr)
 * @return 정렬된 배열(arr)
 */
class SelectionSort {
  public int[] solution(int N, int[] arr) {
    for (int i = 0; i < N; i++) {
      int idx = i; // 가장 작은 값의 index
      for (int j = i + 1; j < N; j++)
        if (arr[idx] > arr[j])
          idx = j;
      int temp = arr[idx];
      arr[idx] = arr[i];
      arr[i] = temp;
    }
    return arr;
  }
}