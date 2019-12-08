/**
 * 문제 이름 : 탑
 * 작성자 : kkoon9
 * 날짜 : 2019.12.08
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/42588
 * Stack을 사용한 문제!
 * 맨 오른쪽 index 탑을 기준으로 잡는다.
 * 스택이 비어있으면 기준 index를 push해준다.
 * 스택이 비어있지않으면 스택에 있는 탑과 비교해준다.
 * 스택에 있는 탑보다 기준 탑이 더 크다면 pop해준 뒤 answer에 탑의 위치를 넣어준다.
 ********    배운점      **************
 * java.lang.ArrayIndexOutOfBoundsException
 * (+) answer 배열의 크기를 명시해줘야 한다는 점을 배웠다.
 * */
import java.util.Stack;

class Top {
    int idx;
    int height;
    Top(int idx, int height){
        this.idx = idx;
        this.height = height;
    }
}
class Solution {
    public int[] solution(int[] heights) {
        Stack <Top> st = new Stack();
        int ln = heights.length;
        int[] answer = new int[ln];
        for(int i=0; i < ln - 1; i++) // 일단 0으로 초기화
            answer[i] = 0;

        for(int i=ln-1; i>=0; i--){
            while(!st.empty() && st.peek().height < heights[i]) { // stack에 data가 있다면
                answer[st.pop().idx] = i + 1;
            }
            st.push(new Top(i,heights[i])); // i에 해당하는 데이터 push
        }
        return answer;
    }
}
