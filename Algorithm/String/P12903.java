/**
 * 문제 이름 : 가운데 글자 가져오기
 * 작성자 : kkoon9
 * 날짜 : 2020.01.26
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/12903
 * s : 문자열 (매개변수)
 * s의 가운데 글자를 반환하는 solution 만들기
 * s는 길이가 1 ~ 100이다.
 * ********   나의 코드      **************
 * s의 길이가 짝수인지 홀수인지 알아낸다.
 * s의 길이가 짝수이면 mid - 1, mid + 1 index를 substring해준다.
 * s의 길이가 홀수라면 mid, mid + 1 index를 substring해준다.
 * ********   더 나은 코드      **************
 * (len-1) / 2, (len/2) + 1 index를 substring 해주면 홀짝을 구분해주지 않아도 된다.
 * */
class Solution {
    public String solution(String s) {
        String answer = "";
        int len = s.length();
        int mid = len/2;
        if(len % 2 == 0) {
            answer = s.substring(mid - 1, mid + 1);
        }
        else{
            answer = s.substring(mid, mid + 1);
        }
        return answer;
    }
}
// 더 나은 코드
class Solution2 {
    public String solution(String s) {
        return word.substring((word.length()-1) / 2, word.length()/2 + 1);    

    }
}