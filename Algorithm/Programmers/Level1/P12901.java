/**
 * 문제 이름 : 2016년
 * 작성자 : kkoon9
 * 날짜 : 2020.01.26
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/12901
 * a : 해당 월 (매개변수)
 * b : 해당 일 (매개변수)
 * 2016 a월 b일의 요일을 return하는 문제
 * 2016년은 윤년이다.
 * 2016년 a월 b일은 실제로 있는 날이다.
 * 즉, 이상한 날짜(13월 26일)가 입력으로 주어지지 않는다.
 * ********    해결 방법      **************
 * a월 b일까지의 총 일수를 더한 뒤 7로 나눈 나머지를 통해 요일을 구해낸다.
 * 
 * */
class Solution {
    public String solution(int a, int b) {
        String answer = "";
        String [] dayOfTheWeek = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        int [] month = {31,29,31,30,31,30,31,31,30,31,30,31};
        int day = 0;
        for(int i = 1;i<a;i++){
            day += month[i - 1];
        }
        day += b;
        answer = dayOfTheWeek[day % 7];
        return answer;
    }
}