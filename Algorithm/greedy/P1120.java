import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        /**
         * [1]. Input
         */
        String A = st.nextToken();
        String B = st.nextToken();
        int answer = 51;
        int aLength = A.length();
        int bLength = B.length();
        int diff = bLength - aLength;
        for(int i = 0 ;i<=diff;i++){
            String BofAsize = B.substring(i,i+aLength);
            int diffAfromB = Diff(A,BofAsize);
            if(answer > diffAfromB){
                answer = diffAfromB;
            }
        }
        System.out.println(answer);
    }
    private static int Diff(String a, String b) {
        int diff = 0;
        int size = a.length();
        char [] chA = a.toCharArray();
        char [] chB = b.toCharArray();
        for(int i = 0 ;i<size;i++){
            if(chA[i] != chB[i])diff++;
        }
        return diff;
    }
}