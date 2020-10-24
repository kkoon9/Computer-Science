
import java.util.*;

class Job implements Comparable<Job> {
  public int arriveTime;
  public int jobTime;

  public Job(int arriveTime, int jobTime) {
    this.arriveTime = arriveTime;
    this.jobTime = jobTime;
  }

  @Override
  public int compareTo(Job o) {
    int result = this.jobTime < o.jobTime;
    if (result == 0) {
      result = this.arriveTime < o.arriveTime;
    }
    return result;
  }
}

class Solution {
  public int solution(int[][] jobs) {
    PriorityQueue<Job> pq = new PriorityQueue<>();
    List<Job> list = new ArrayList<>();

    // PriorityQueue를 활용한 Job 정렬
    for (int i = 0; i < jobs.length; i++) {
      pq.add(new Job(jobs[i][0], jobs[i][1]));
    }

    // list에 우선순위 순으로 정렬된 Job 순차적으로 삽입
    for (int i = 0; i < jobs.length; i++) {
      list.add(pq.poll());
    }

    int time = 0;
    int sum = 0;
    while (list.size() > 0) {
      for (int i = 0; i < list.size(); i++) {
        // 시작시간이 현재 시간을 지나야(커야) 시작 가능
        if (time >= list.get(i).arriveTime) {
          time += list.get(i).jobTime;
          sum += time - list.get(i).arriveTime;
          list.remove(i);
          break;
        }
        if (i == list.size() - 1)
          time++;
      }
    }

    int answer = (sum / jobs.length);
    return answer;
  }
}