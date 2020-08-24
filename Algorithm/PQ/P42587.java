/**
 * 문제 이름 : 프린터
 * 작성자 : kkoon9
 * 날짜 : 2019.12.08
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/42587
 * Queue와 Priority Queue를 사용한 문제!
 * q와 pq에 prirorities에 있는 원소들을 넣어주었다.
 * pq는 Collections.reverseOrder()를 통해 내림차순으로 설정해주었다.
 * pq가 빌 때까지 q와 맞는 prior를 찾아주어 정답 큐인 aq에 넣어주었다.
 * aq의 idx와 location이 같은 수를 카운팅하면서 찾아내어 카운팅한 값을 return 해준다.
 ********    배운점      **************
 * Queue는 Stack과 다르게 LinkedList를 사용해야 한다.
 * (+) Queue<Print> q = new LinkedList<>();
 * */
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Print implements Comparable<Print> {
    int idx;
    int prior;

    Print(int idx, int prior){
        this.idx = idx;
        this.prior = prior;
    }

    @Override
    public int compareTo(Print o) {
        if(this.prior > o.prior)
            return 1;
        else
            return -1;
    }
}
class Solution {
    public int solution(int[] priorities, int location) {
        int ln = priorities.length;
        int answer = 0;
        Queue<Print> q = new LinkedList<>();
        Queue<Print> aq = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(ln, Collections.reverseOrder());
        for(int i=0;i<ln;i++) {
            Print data = new Print(i, priorities[i]);
            q.add(data);
            pq.add(priorities[i]);
        }
/*        q.forEach(a -> {
            System.out.println(a.idx);
        });
        pq.forEach(a -> {
            System.out.println(a);
        });*/
        while(!pq.isEmpty()){
            if(q.peek().prior ==pq.peek()) {
                pq.remove();
                Print buffer = q.poll();
                aq.add(buffer);
            }
            else {
                Print buffer = q.poll();
                q.add(buffer);
            }
        }
/*        aq.forEach(a -> {
            System.out.println(a.idx);
        });*/
        for(int i=1;i<=ln;i++){
            if(aq.poll().idx == location){
                answer = i;
                break;
            }

        }
        return answer;
    }
}