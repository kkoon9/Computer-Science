/**
 * 문제 이름 : 기능개발
 * 작성자 : kkoon9
 * 날짜 : 2019.12.11
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/42586
 * Queue와 Vector를 사용한 문제!
 * progresses와 speeds의 원소를 각각 큐에 넣는다.(proQ, speedQ)
 * 첫 번째 원소부터 기능 개발이 완료되는데 걸리는 days를 구한다.
 * 다음 원소부터 기능 개발이 완료된 개수를 complete에 더해준다.
 * 기능 개발이 미완료될 때까지 complete를 더해준 뒤, complete 값을 vector answer에 넣는다.
 * */
import java.util.Queue;
import java.util.LinkedList;
import java.util.Vector;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> proQ = new LinkedList();
        Queue<Integer> speedQ = new LinkedList();
        Vector<Integer> answer = new Vector<>();

        int complete = 1;
        int len = progresses.length;
        for (int i = 0; i < len; i++) {
            proQ.add(progresses[i]);
            speedQ.add(speeds[i]);
        }
        int progress = proQ.poll();
        int speed = speedQ.poll();
        int days = (100 - progress) / speed;
        days += ((100 - progress) % speed == 0)?0:1;
        while (!proQ.isEmpty()) {
            progress = proQ.poll();
            speed = speedQ.poll();
            progress += speed * days;
            if (progress >= 100) {
                complete++;
            } else {
                answer.add(complete);
                complete = 1;
                days += (100 - progress) / speed;
                days += ((100 - progress) % speed == 0)?0:1;
            }
        }
        answer.add(complete);
        int[] output = new int[answer.size()];
        int i = 0;
        for(int a : answer){
            output[i++] = a;
        }
        return output;
    }
}