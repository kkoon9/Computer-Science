
import java.util.PriorityQueue;

class Solution {
  public int solution(int[] scoville, int K) {
    int answer = 0;
    PriorityQueue<Integer> pq = new PriorityQueue();
    for (int val : scoville)
      pq.add(val);
    while (true) {
      int first, second;
      if (pq.peek() >= K) {
        break;
      }
      if (!pq.isEmpty()) {
        first = pq.poll();
      } else {
        answer = -1;
        break;
      }
      if (!pq.isEmpty()) {
        second = pq.poll() * 2;
      } else {
        answer = -1;
        break;
      }
      pq.add(first + second);
      answer++;
    }
    return answer;
  }
}