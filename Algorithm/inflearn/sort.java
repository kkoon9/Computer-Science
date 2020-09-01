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

/**
 * @desc 부호가 다르다면 오름차순
 * @desc 부호가 같다면 절대값을 기준으로 오름차순
 * @param 정수(N), N의 길이를 가지는 배열(arr)
 * @return 정렬된 배열(arr)
 */
class SpecialSort {
  class SpecialArray implements Comparable<SpecialArray> {
    int num;
    int isPositive;

    SpecialArray(int num, int isPositive) {
      this.num = num;
      this.isPositive = isPositive;
    }

    @Override
    public int compareTo(SpecialArray o) {
      int result = this.isPositive - o.isPositive;
      if (result == 0) {
        result = Math.abs(this.num) - Math.abs(o.num);
      }
      return result;
    }
  }

  public int[] solution(int N, int[] arr) {
    SpecialArray[] sa = new SpecialArray[arr.length];
    for (int i = 0; i < N; i++) {
      sa[i] = new SpecialArray(arr[i], arr[i] > 0 ? 1 : 0);
    }
    Arrays.sort(sa);
    for (int i = 0; i < N; i++) {
      arr[i] = sa[i].num;
    }
    return arr;
  }
}

/**
 * @desc 삽입정렬
 * @param 정수(N), N의 길이를 가지는 배열(arr)
 * @return 정렬된 배열(arr)
 */
class InsertionSort {
  public int[] solution(int N, int[] arr) {
    for (int i = 1; i < N; i++) {
      int temp = arr[i];
      int j = i - 1;
      for (; j >= 0; j--) {
        if (arr[j] > temp) {
          arr[j + 1] = arr[j];
        } else
          break;
      }
      arr[j + 1] = temp;
    }
    return arr;
  }
}

/**
 * @desc LRU(카카오)
 * @param 캐시 크기(cacheSize), 정수(N), N의 길이를 가지는 배열(arr)
 * @return 캐시 안에 있는 요소
 */
class LRU {
  public int[] solution(int cacheSize, int N, int[] arr) {
    LinkedList<String> cache = new LinkedList<>();
    for (int num : arr) {
      String obj = String.valueOf(num);
      // HIT
      if (cache.remove(obj)) {
        cache.addFirst(obj);
      }
      // MISS
      else {
        // cache가 꽉 차 있다면
        if (cache.size() == cacheSize) {
          cache.pollLast();
        }
        cache.addFirst(obj);
      }
    }
    int currentCacheSize = cache.size();
    int[] answer = new int[currentCacheSize];
    for (int i = 0; i < currentCacheSize; i++) {
      answer[i] = Integer.parseInt(cache.pollFirst());
    }
    return answer;
  }
}

/**
 * @desc Inversion Sequnece
 * @param 정수 N, 길이 N인 Inversion Sequence 정보를 담은 배열
 * @return Inversion Sequence를 통해 얻어낸 배열
 */
class InversionSequence {
  public int[] solution(int N, int[] is) {
    int[] answer = new int[N + 1];
    for (int i = N; i >= 1; i--) {
      int seq = i;
      for (int j = 1; j <= is[i]; j++) {
        answer[seq] = answer[seq + 1];
        seq++;
      }
      answer[seq] = i;
    }
    return answer;
  }
}