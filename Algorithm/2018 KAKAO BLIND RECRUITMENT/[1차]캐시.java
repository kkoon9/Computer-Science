
/**
 * 문제 이름 : 캐시
 * 작성자 : kkoon9
 * 날짜 : 2020.08.25
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/17680
 * LinkedList을 사용한 문제!
 * (+) LRU를 구현하는 문제였다.
 * (+) 처음엔 LRU가 최근 사용된 요소를 제거하는 걸로 착각하여 시간이 걸렸었다.
 * (+) map으로 구현하다가 꽤 복잡해져서 코드를 참고하였다.
 * ********
 * 출처 : https://velog.io/@hyeon930/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%BA%90%EC%8B%9C-Java
 * */
import java.util.*;

class Solution {

  static final int CACHE_HIT = 1;
  static final int CACHE_MISS = 5;

  public int solution(int cacheSize, String[] cities) {
    if (cacheSize == 0)
      return 5 * cities.length;

    int answer = 0;

    LinkedList<String> cache = new LinkedList<>();

    for (int i = 0; i < cities.length; ++i) {
      String city = cities[i].toUpperCase(); // 조건 : // 대소문자 구분을 하지 않는다.

      // cache hit
      if (cache.remove(city)) {
        cache.addFirst(city);
        answer += CACHE_HIT;

        // cache miss
      } else {
        int currentSize = cache.size();

        if (currentSize == cacheSize) {
          cache.pollLast();
        }

        cache.addFirst(city);
        answer += CACHE_MISS;
      }
    }
    return answer;
  }
}