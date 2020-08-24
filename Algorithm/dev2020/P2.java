import java.util.*;
import java.io.*;

class Solution {
    // 북(0), 동(1), 남(2), 서(3) : 괄호 안의 숫자는 배열의 index이다.
    static int [] dc = {0,1,0,-1};
    static int [] dr = {-1,0,1,0};
    static int N;
    public int solution(int[][] office, int r, int c, String[] move) {
        int answer = 0;
        int look = 0; // 초기가 0인 이유는 북쪽을 바라보고 있기 때문
        int commandCount = move.length;
        N = office.length;
        answer+= office[r][c];
        office[r][c] = 0;
        for(int i = 0 ;i<commandCount;i++){
            String command = move[i];
            System.out.println(command + " : r : " + r + " c : " + c);
            if(command.equals("go")){
                int moveC = c + dc[look];
                int moveR = r + dr[look];
                if(isLimit(moveR,moveC)) continue; // 사무실을 벗어나면 못움직임
                if(office[moveR][moveC] == -1) continue; // 물건이 있으면 못움직임
                r = moveR;
                c = moveC;
                answer += office[r][c];
                office[r][c] = 0;
            } else if(command.equals("left")){
                look -= 1;
                if(look < 0){
                    look +=4;
                }
            } else {
                look += 1;
                if(look >= 4){
                    look -=4;
                }
            }

        }
        return answer;
    }
    //제한된 곧이면 그냥 끝
    private boolean isLimit(int moveR, int moveC) {
        return moveR < 0 || moveC < 0 || moveR >= N || moveC >= N;
    }
}


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Solution s = new Solution();
        int[][] office = {{5,-1,4},{6,3,-1},{2,-1,1}};
        String[] move = {"go","go","right","go","right","go","left","go"};
        System.out.println(s.solution(office,1,0,move));
    }

}