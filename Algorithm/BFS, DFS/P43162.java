/**
 * 문제 이름 : 네트워크
 * 작성자 : kkoon9
 * 날짜 : 2020.01.27
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/43162
 * n : 컴퓨터의 개수 (매개변수)
 * computers : 연결에 대한 정보가 담긴 배열 (매개변수)
 * 간접적으로 연결되어 있다면 정보를 교환할 수 있다.
 * 즉, 같은 네트워크 상에 있다고 할 수 있다.
 * 네트워크의 개수를 구하는 문제
 * ********   해결 방법    **************
 * BFS로 풀이하였다.
 * visit[i]가 false면 answer를 추가해준 뒤, DFS를 사용하여 i와 연결된 다른 컴퓨터의 visit 값을 모두 true로 바꿔주었다.
 * */
class Solution {
    public int solution(int n, int[][] computers) {
        int len = computers.length, answer = 0;
        boolean[] visit = new boolean[len];
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                answer++;
                visit[i] = true;
                dfs(computers, i, visit);
            }
        }
        return answer;
    }

    void dfs(int[][] computers, int idx, boolean[] visit) {
        for (int i = 0; i < computers.length; i++) {
            if(!visit[i] && computers[idx][i] == 1){
                visit[i] = true;
                dfs(computers,i,visit);
            }
        }
    }
}