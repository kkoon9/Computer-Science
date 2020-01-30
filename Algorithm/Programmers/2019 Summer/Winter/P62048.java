/**
 * 문제 이름 : 멀쩡한 사각형
 * 작성자 : kkoon9
 * 날짜 : 2020.01.27
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/62048
 * gcd(최대공약수) 문제
 * 최대공약수임을 알기 위해 7까지 알아봤다.
 * 규칙 찾는 문제는 찾을 때까지 케이스를 늘려나가는게 좋다.
 * */
class Solution {
    public long solution(int w,int h) {
        if(w == 1 || h == 1) return 0;
        long mul = (long)w * (long)h;
        long line = w + h - gcd(w,h);

        return mul - line;
    }
    int gcd(int w, int h) {
        return w % h == 0 ? h : gcd(h, w % h); 
    }
}