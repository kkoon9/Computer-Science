/**
 * 문제 이름 : 주식가격
 * 작성자 : kkoon9
 * 날짜 : 2019.12.13
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/42584
 * Stack을 사용한 문제!
 ********    첫 번째 시도      **************
 * index와 price를 갖는 class Stock을 타입으로 갖는 Stack st를 선언한다.
 * Stack이 비어있으면 push
 * Stack의 peek보다 넣으려는 값이 크다면 현재 index 값에서 peek의 idx를 빼준 값이 떨어지지 않은 시간이다.
 * Stack에 남은 Stock 값들은 끝까지 떨어지지 않은 가격이므로 len - Stock.idx - 1을 넣어준다.
 * 잘못된 접근인듯. 모두 틀림
 * ********    문제점      **************
 * st이 비어있는데도 peek()로 뽑아와서 java.util.EmptyStackException 에러가 발생한다.
 * ********    해결방안      **************
 * st에 empty를 확인해주면서 진행했다.
 * 
 *  while(!st.isEmpty() && prices[i] < st.peek().price)
 * (+) while문을 수정함으로써 코드 리펙터링을 실시했다.
 *  * */

import java.util.Stack;

class Stock {
    int idx;
    int price;
    Stock(int idx, int price){
        this.idx = idx;
        this.price = price;
    }
}
class Solution {
    public int[] solution(int[] prices) {
        Stack <Stock> st = new Stack();
        int len = prices.length;
        int[] answer = new int[len];
        for(int i = 0; i < len; i++) {
            if (st.empty()) {
                st.push(new Stock(i, prices[i]));
                continue;
            }
            while(!st.isEmpty() && prices[i] < st.peek().price) {
                Stock buffer = st.pop();
                answer[buffer.idx] = i - buffer.idx;
            }
            st.push(new Stock(i, prices[i]));
        }
        while(!st.isEmpty()){
            Stock buffer = st.pop();
            answer[buffer.idx] = len - buffer.idx - 1;
        }
        return answer;
    }
}