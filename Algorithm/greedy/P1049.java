import java.io.*;
import java.util.*;

class Main {
    static class Guitar {
        int setPrice;
        int singlePrice;

        Guitar(int setPrice, int singlePrice) {
            this.setPrice = setPrice;
            this.singlePrice = singlePrice;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N, M, answer;
        Guitar[] Guitar;

        /**
         * [1]. Input
         */
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Guitar = new Guitar[M];
        int [] setRank = new int[M*2]; // 6개로 파는 패키지의 sort된 가격
        int [] modRank = new int[M*2]; // 패키지로 사고 남은 낱개들의 sort된 가격
        int mod = N % 6;
        for(int i = 0 ; i<M;i++){
            st = new StringTokenizer(br.readLine());
            int set = Integer.parseInt(st.nextToken());
            int single = Integer.parseInt(st.nextToken());
            Guitar[i] = new Guitar(set,single);
            setRank[i] = set;
            setRank[i + M] = single * 6;
            modRank[i] = set;
            modRank[i + M] = single * mod;
        }
        Arrays.sort(setRank);
        Arrays.sort(modRank);
        if(N < 6) {
            answer = modRank[0];
        } else {
            answer = setRank[0] * (N / 6) + modRank[0];
        }

        System.out.println(answer);
    }
}