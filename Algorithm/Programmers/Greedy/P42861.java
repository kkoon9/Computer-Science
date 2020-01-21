/**
 * 문제 이름 : 섬 연결하기
 * 작성자 : kkoon9
 * 날짜 : 2020.01.17
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/42861
 * Greedy Algorithm를 사용한 문제!
 * ********   제한 사항      **************
 * n : 섬의 개수 (매개변수)
 * costs : n 개의 섬 사이에 다리를 건설하는 비용 (매개변수)
 * 최소의 비용으로 모든 섬이 서로 통행 가능하도록 만들어야 할 때 필요한 최소 비용
 * 섬의 개수 n은 1 이상 100 이하입니다.
 * costs의 길이는 ((n-1) * n) / 2이하입니다.
 * 임의의 i에 대해, costs[i][0] 와 costs[i] [1]에는 다리가 연결되는 두 섬의 번호가 들어있고, costs[i] [2]에는 이 두 섬을 연결하는 다리를 건설할 때 드는 비용입니다.
 * 같은 연결은 두 번 주어지지 않습니다. 
 * 또한 순서가 바뀌더라도 같은 연결로 봅니다.
 * 즉 0과 1 사이를 연결하는 비용이 주어졌을 때, 1과 0의 비용이 주어지지 않습니다.
 * 모든 섬 사이의 다리 건설 비용이 주어지지 않습니다. 
 * 이 경우, 두 섬 사이의 건설이 불가능한 것으로 봅니다.
 * 연결할 수 없는 섬은 주어지지 않습니다.
 * ********    풀이 방법      **************
 * 그래프문젠데 그리디에 있네
 * 
 * * */

import java.util.*;
class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int len = costs.length;
        int [][] graph = new int[n][n];
        boolean [] visit = new boolean[n];
        for(int i = 0; i< len ; i++ )
            graph[costs[i][0]][costs[i][1]] = graph[costs[i][1]][costs[i][0]] = costs[i][2];
        List<Integer> list = new ArrayList<>(n+1);
        list.add(0);
        visit[0] = true;
        while(list.size() < n) {
            int min = Integer.MAX_VALUE;
            int minIdx = -1;
            for(int island = 0; island < list.size(); island++) {
                int i = list.get(island);
                for(int j = 0; j < n; j++) {
                    if(!visit[j] && i != j && graph[i][j] > 0 && graph[i][j] < min) {
                        min = graph[i][j];
                        minIdx = j;
                    }
                }
            }
            visit[minIdx] = true;
            list.add(minIdx);
            answer += min;
        }
        return answer;
    }
}

}