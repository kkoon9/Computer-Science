/**
 * 문제 이름 : 디스크 컨트롤러
 * 작성자 : kkoon9
 * 날짜 : 2019.12.16
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/42627
 * Priority Queue를 사용한 문제!
 *  ********* 첫 번째 시도 **************
 * 실행큐와 대기큐를 만들어서 처리하였다.
 * 실행큐가 사이즈 1일 때까지 빼줘야 한다.
 * 정답률 10%
 *  ********* 첫 번째 시도 **************
 * 포커스를 남은 작업에서 시간(time)으로 옮겼다.
 * class Job을 작업시간이 짧은 순으로 정렬하고 작업시간이 같다면 도착시간이 빠른 순으로 정렬해줬다.
 * ********    배운 점      **************
 * Ctrl + Alt + L : 자동정렬
 * */
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
        if (this.jobTime < o.jobTime) return -1;
        else if (this.jobTime == o.jobTime) {
            if (this.arriveTime < o.arriveTime) return -1;
            else return 1;
        } else return 1;
    }
}

class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<Job> pq = new PriorityQueue<>();
        List<Job> list = new ArrayList<>();

        //PriorityQueue를 활용한 Job 정렬
        for (int i = 0; i < jobs.length; i++) {
            pq.add(new Job(jobs[i][0], jobs[i][1]));
        }

        //list에 우선순위 순으로 정렬된 Job 순차적으로 삽입
        for (int i = 0; i < jobs.length; i++) {
            list.add(pq.poll());
        }

        int time = 0;
        int sum = 0;
        while (list.size()>0) {
            for (int i = 0; i < list.size(); i++) {
                //시작시간이 현재 시간을 지나야(커야) 시작 가능
                if (time >= list.get(i).arriveTime) {
                    time += list.get(i).jobTime;
                    sum += time-list.get(i).arriveTime;
                    list.remove(i);
                    break;
                }
                if (i == list.size()-1) time++;
            }
        }

        int answer = (sum/jobs.length);
        return answer;
    }
}