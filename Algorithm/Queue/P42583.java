/**
 * 문제 이름 : 다리를 지나는 트럭
 * 작성자 : kkoon9
 * 날짜 : 2020.01.27
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/42583
 * Stack/Queue 문제
 * */
import java.util.*;

class Solution {
    class Truck {
        int time;
        int weight;

        public Truck(int time, int weight) {
            this.time = time;
            this.weight = weight;
        }
    }
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int tot_weight = 0;
        int time = 1;
        Queue<Truck> q = new LinkedList<>();
        Queue<Truck> q2 = new LinkedList<>();

        Truck[] trucks = new Truck[truck_weights.length];

        for (int i = 0; i < trucks.length; i++) {
            trucks[i] = new Truck(bridge_length, truck_weights[i]);
            q.offer(trucks[i]);
        }
        tot_weight += q.peek().weight;
        q2.offer(q.poll());

        while(!q2.isEmpty()) {
            for(Truck truck : q2) {
                truck.time--;
            }
            if(q2.peek().time <= 0) {
                tot_weight -= q2.poll().weight;
            }

            if(!q.isEmpty() && tot_weight + q.peek().weight <= weight) {
                tot_weight += q.peek().weight;
                q2.offer(q.poll());
            }
            time++;
        }
        return answer = time;
    }
}