/**
 * 문제 이름 : 큰 수 만들기
 * 작성자 : kkoon9
 * 날짜 : 2020.01.16
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/42883
 * Greedy Algorithm를 사용한 문제!
 * ********   제한 사항      **************
 * number는 1자리 이상, 1,000,000자리 이하인 숫자 이다.
 * 
 * ********    첫 번째 시도      **************
 * testcase 10 : 시간 초과.
 * testcase 12 : 실패.
 * 반례를 생각해내자.
 * testcase 12 반례 : "54321" 일 때, 마지막 수를 삭제해줘야 한다.
 * testcase 10 반례 : 내림차순인 엄청 긴 수는 시간초과가 난다.
 * ********    해결 방법      **************
 * (1). index를 반복문마다 초기화를 시켜줬는데 index를 놔두고 늘렸다가 줄였다가하면 시간초과를 벗어날 수 있다.
 * (1)출처 : https://ju-nam2.tistory.com/75
 * (2). stack을 이용
 * (+) stack을 이용하여 stack.peek()보다 큰 값이 들어가면 남아있는 값을 pop()
 * (+) stack을 이용하여 stack.peek()보다 작은 값이 들어가면 아니면 바로 push().
 * */
// 방법 (1)
class Solution {
    public String solution(String number, int k) {
        StringBuffer strBuf = new StringBuffer(number);
        int index = 1;
        while (k != 0) {
            int len = strBuf.length();
            if (len == 1) break;
            //전의 숫자와 비교해야 하므로 index는 1부터 시작한다.
            //전의 숫자보다 더 크면 전의 숫자를 삭제하고 크기가 줄어들었으므로 index를 줄여준다.
            if (index >= 1 && strBuf.charAt(index) > strBuf.charAt(index - 1)) {
                strBuf.deleteCharAt(index - 1);
                index--;
                k--;
            } else {
                //index가 맨 끝으로 가고, 그 전의 숫자와 작거나 같으면 지금의 숫자를 삭제해준다.
                if (index == strBuf.length() - 1 && strBuf.charAt(index) <= strBuf.charAt(index - 1)) {
                    strBuf.deleteCharAt(index);
                    k--;
                    index--;
                } else {
                    //그 외의 경우에는 index를 추가해준다.
                    index++;
                }
            }
        }
        String answer = strBuf.toString();
        return answer;

    }
}
// 방법 (2)

class Solution {
    public String solution(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }
        for (int i=0; i<result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }
}