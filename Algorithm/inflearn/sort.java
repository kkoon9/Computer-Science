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

/**
 * @desc 3등의 성적을 구하는 프로그램
 * @param 정수(N), N의 길이를 가지는 배열(arr)
 * @return 3등의 성적
 */
class GetThirdScore {
  public int solution(int N, int[] arr) {
    int answer = 0;
    arr = selectionSort(N, arr);
    for (int num : arr) {
      System.out.print(num + " ");
    }
    System.out.println();
    int rank = 1;
    for (int i = 1; i < N; i++) {
      if (arr[i - 1] != arr[i]) {
        rank++;
      }
      if (rank == 3) {
        answer = arr[i];
        break;
      }
    }
    return answer;
  }

  int[] selectionSort(int N, int[] arr) {
    for (int i = 0; i < N; i++) {
      int idx = i; // 가장 작은 값의 index
      for (int j = i + 1; j < N; j++)
        if (arr[idx] < arr[j])
          idx = j;
      int temp = arr[idx];
      arr[idx] = arr[i];
      arr[i] = temp;
    }
    return arr;
  }
}

/**
 * @desc 버블정렬
 * @param 정수(N), N의 길이를 가지는 배열(arr)
 * @return 정렬된 배열(arr)
 */
class BubbleSort {
  public int[] solution(int N, int[] arr) {
    for (int i = N - 1; i > 0; i--) {
      for (int j = 0; j < i; j++)
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j + 1];
          arr[j + 1] = arr[j];
          arr[j] = temp;
        }
    }
    return arr;
  }
}