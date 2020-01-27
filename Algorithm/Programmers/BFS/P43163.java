/**
 * 문제 이름 : 단어 변환
 * 작성자 : kkoon9
 * 날짜 : 2020.01.27
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/43163
 * begin : 처음 시작하는 단어 (매개변수)
 * target : 변환해야 하는 단어 (매개변수)
 * words : 단어의 집합 (매개변수)
 * 다음과 같은 규칙을 이용하여 begin에서 target으로 바꿔야 한다.
 * 1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다.
 * 2. words에 있는 단어로만 변환할 수 있습니다.
 * 최소 몇 단계의 과정을 거쳐 begin을 target으로 변환할 수 있는지 구해야 한다.
 * ********   첫 번째 시도     **************
 * DFS로 풀이하였다.
 * (1). 다른 알파벳 개수 diff가 2이상이면 dfs(words, begin,depth + 1, target, count); 재귀함수
 * diff가 1 이하이면 (1) 이랑 dfs(words, changeStr, depth + 1, target, count + 1) 재귀함수
 * begin과 target이 같아지면 count 와 answer를 비교하여 answer보다 작으면 answer = count
 * 테스트케이스 #3이 실패한다. 반례를 생각해보자.
 * words의 순서를 생각하면 안된다.
 * 그러므로 BFS로 풀어줘야 한다.
 * ********   해결 방법    **************
 * BFS로 풀이하였다.
 * visit이 가능했던 점 begin에서 한 글자만 바꿀 수 있으므로 visit을 사용할 수 있었다. (헷갈린 부분) 
 * 참고 : https://saltae.tistory.com/13
 * */

 // 첫 번째 시도
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int answer = Integer.MAX_VALUE;

    public int solution(String begin, String target, String[] words) {
        int len = words.length;
        boolean check = false; // words안에 target이 있는지 확인
        for(int i =0;i<len;i++){
            if(words[i].equals(target)) {
                check = true;
                break;
            }
        }
        if(!check) return 0; // words안에 target이 없다면 0을 return 해야 한다.
        dfs(words, begin, 0, target, 0);
        return answer;
    }
    public void dfs(String[] words, String begin, int depth, String target, int count) {
        if(begin.equals(target)) {
            if(count < answer){
                answer = count;
            }
        } else if(depth == words.length) return;
        else {
            String changeStr = words[depth];
            int diff = 0; // 다른 알파벳 개수
            for(int i = 0;i<begin.length();i++) {
                if(diff > 1)
                    break;
                if(begin.charAt(i) != changeStr.charAt(i)){
                    diff++;
                }
            } // 반복문을 빠져나온다면 다른 알파벳 개수가
            if(diff>=2)
                dfs(words, begin,depth + 1, target, count); // 바꾸고 않고 그냥 이동
            else {
                dfs(words, changeStr, depth + 1, target, count + 1); // 바꾸고 이동
                dfs(words, begin,depth + 1, target, count); // 바꾸고 않고 그냥 이동
            }
        }
    }
}

// 최종 코드

class Solution2 {
    static class Node {
        String next;
        int depth;

        public Node(String next, int depth) {
            this.next = next;
            this.depth = depth;
        }
    }
    public int solution(String begin, String target, String[] words) {
        int len = words.length, answer = 0;
        Queue<Node> q = new LinkedList<>();
        boolean[] visit = new boolean[len];
        q.add(new Node(begin, 0));

        while(!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.next.equals(target)) {
                answer = cur.depth;
                break;
            }

            for (int i=0; i<len; i++) {
                if (!visit[i] && isNext(cur.next, words[i])) {
                    visit[i] = true;
                    q.add(new Node(words[i], cur.depth + 1));
                }
            }
        }

        return answer;
    }

    static boolean isNext(String cur, String n) {
        int cnt = 0;
        for (int i=0; i<n.length(); i++) {
            if (cur.charAt(i) != n.charAt(i)) {
                if (++cnt > 1) return false;
            }
        }

        return true;
    }
}