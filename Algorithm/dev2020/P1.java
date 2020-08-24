import java.util.*;
import java.io.*;

class Solution {

    public int solution(String p, String s) {
        int answer = 0; // 다이얼 돌린 횟수
        StringBuilder pSb = new StringBuilder(); // p를 가지는 StringBuilder 변수
        StringBuilder sSb = new StringBuilder(); // s를 가지는 StringBuilder 변수
        int pCharAt; // p의 자릿값
        int sCharAt; // s의 자릿값
        int min,max; // pCharAt과 sCharAt 
        pSb.append(p);
        sSb.append(s);
        int passwordLength = p.length();
        for(int i = 0;  i<passwordLength;i++){
            pCharAt = pSb.charAt(i) - '0';
            sCharAt = sSb.charAt(i) - '0';
            if(pCharAt > sCharAt){
                max = pCharAt;
                min = sCharAt;
            } else {
                max = sCharAt;
                min = pCharAt;
            }
            if(max - min > (min + 10) - max){
                answer += ((min + 10) - max);
            } else
                answer += (max - min);
        }
        return answer;
    }
}