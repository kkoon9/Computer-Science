/**
 * 문제 이름 : 전화번호 목록
 * 작성자 : kkoon9
 * 날짜 : 2019.12.01
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/42577
 * startsWith를 사용한 문제
 * 접두문자를 사용하는지 확인하는 String 메서드
 * */
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        int size = phone_book.length;
        for(int i=0;i<size-1;i++){
            for(int j=i+1;j<size;j++){
                if(phone_book[i].startsWith(phone_book[j])) return false;
                if(phone_book[j].startsWith(phone_book[i])) return false;
            }
        }
        return answer;
    }
}
