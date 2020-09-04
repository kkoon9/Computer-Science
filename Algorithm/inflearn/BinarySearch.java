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

/**
 * @desc M개의 DVD에 모든 동영상을 녹화하기 위한 DVD의 최소 용량 크기를 구하는 프로그램
 * @param 정수(N), 길이가 N인 배열, DVD 개수
 * @return DVD 최소 용량
 */
class Question43 {
  public int solution(int N, int M, int[] arr) {
    int answer = 0;
    int left = 0;
    int right = 0;
    int mid;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < N; i++) {
      right += arr[i];
      if (max < arr[i]) {
        max = arr[i];
      }
    }
    mid = right / 2;
    while (left <= right) {
      // 가능하니까 더 줄여보자.
      if (mid >= max && counting(arr, mid) <= M) {
        right = mid - 1;
        answer = mid;
      } else {
        left = mid + 1;
      }
      mid = (left + right) / 2;
    }
    return answer;
  }

  int counting(int[] arr, int mid) {
    int sum = 0;
    int cnt = 1;
    for (int i = 0; i < arr.length; i++) {
      if (sum + arr[i] > mid) {
        cnt++;
        sum = arr[i];
      } else
        sum = sum + arr[i];
    }
    return cnt;
  }
}