
import java.io.*;
import java.util.*;

class Solution {
    static class DB implements Comparable<DB> {
        String name;
        int cash;
        DB(String name, int cash){
            this.name = name;
            this.cash = cash;
        }
        @Override
        public int compareTo(DB o) {
            int result = this.name.compareTo(o.name);
            return result;
        }
    }
    public String[][] solution(String[][] snapshots, String[][] transactions) {
        String[][] answer = {};
        boolean [] isUsedId = new boolean [100001]; // 트랜잭션의 중복을 피하기 위한 boolean 배열(100,000은 ID 최대값)
        HashMap<String, Integer> hm = new LinkedHashMap<>();
        /**
         * [1]. snapshot 등록
         */
        for(String[] snapshot : snapshots){
            hm.put(snapshot[0], hm.getOrDefault(snapshot[0], 0) + Integer.parseInt(snapshot[1]));
        }
        for(String[] transaction : transactions){
            if(isUsedId[Integer.parseInt(transaction[0])]){
                continue;
            }
            isUsedId[Integer.parseInt(transaction[0])] = true;
            String kind = transaction[1];
            String name = transaction[2];
            int cost = Integer.parseInt(transaction[3]);
            if(kind.equals("SAVE"))
                hm.put(name, hm.getOrDefault(name, 0) + cost);
            else
                hm.put(name, hm.getOrDefault(name, 0) - cost);
        }
        int size = hm.size();
        DB [] db = new DB[size];
        int i = 0;
        for(Map.Entry<String, Integer> elem : hm.entrySet()){

            String key = elem.getKey();
            int value = elem.getValue();

            db[i++] = new DB(key, value);
        }
        Arrays.sort(db);
        answer = new String[size][2];
        for(i=0;i<size;i++){
            answer[i][0] = db[i].name;
            answer[i][1] = String.valueOf(db[i].cash);
        }
        return answer;
    }
}

class Main {

    public static void main(String[] args) throws Exception {
       /* BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());*/
        /**
         * [1]. Init
         */
        Solution s = new Solution();
        String[][] ss = {{"ACCOUNT1", "100"}, {"ACCOUNT2", "150"}};
        String[][] tr = {{"1", "SAVE", "ACCOUNT2", "100"}, {"2", "WITHDRAW", "ACCOUNT1", "50"}, {"1", "SAVE", "ACCOUNT2", "100"},{"4", "SAVE", "ACCOUNT3", "500"}, {"3", "WITHDRAW", "ACCOUNT2", "30"} };
        System.out.println(s.solution(ss,tr));
    }
}