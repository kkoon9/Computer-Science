
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Print implements Comparable<Print> {
  int idx;
  int prior;

  Print(int idx, int prior) {
    this.idx = idx;
    this.prior = prior;
  }

  @Override
  public int compareTo(Print o) {
    int result = this.prior - o.prior;
    return result;
  }
}

class Solution {
  public int solution(int[] priorities, int location) {
    int ln = priorities.length;
    int answer = 0;
    Queue<Print> q = new LinkedList<>();
    Queue<Print> aq = new LinkedList<>();
    PriorityQueue<Integer> pq = new PriorityQueue<>(ln, Collections.reverseOrder());
    for (int i = 0; i < ln; i++) {
      Print data = new Print(i, priorities[i]);
      q.add(data);
      pq.add(priorities[i]);
    }
    /*
     * q.forEach(a -> { System.out.println(a.idx); }); pq.forEach(a -> {
     * System.out.println(a); });
     */
    while (!pq.isEmpty()) {
      if (q.peek().prior == pq.peek()) {
        pq.remove();
        aq.add(q.poll());
      } else {
        q.add(q.poll());
      }
    }
    /*
     * aq.forEach(a -> { System.out.println(a.idx); });
     */
    for (int i = 1; i <= ln; i++) {
      if (aq.poll().idx == location) {
        answer = i;
        break;
      }

    }
    return answer;
  }
}