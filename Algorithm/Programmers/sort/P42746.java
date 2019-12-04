/**
 * 문제 이름 : 가장 큰 수
 * 작성자 : kkoon9
 * 날짜 : 2019.12.04
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/42746
 * 정렬을 사용한 문제!
 ******* 배운 점 ************
 * (+) compareTo
 *      A와 B가 같으면 : 0
 *      A가 B보다 크면 : 양수
 *      A가 B보다 작으면 : 음수
 * (+) Integer.toString(int 변수) : Int to String
 * (+) Integer.parseInt(string 변수) : String to Int;
 * ********** testcase11 **********
 * 모두 0 일 때에는 0이 출력되어야 한다.
 * line 31~ 36
 * */
import java.util.Comparator;
import java.util.Arrays;

class comp implements Comparator<String> {
    public int compare(String o1, String o2) {
        String temp1 = o1+o2;
        String temp2 = o2+o1;
        return temp2.compareTo(temp1);
    }
}
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        int ln = numbers.length;
        String[] str = new String[ln];
        boolean testcase11 = false; // testcase11이 true면 0이 아닌 수가 numbers에 있다.
        for(int i=0;i<ln;i++){
            if(numbers[i]!= 0) testcase11 = true;
            str[i] =  Integer.toString(numbers[i]);
        }
        Arrays.sort(str, new comp());
        for(int i=0;i<ln;i++){
            answer += str[i];
        }
        if(testcase11) answer = "0";
        return answer;
    }
}