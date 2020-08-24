/**
 * 문제 이름 : 여행경로
 * 작성자 : kkoon9
 * 날짜 : 2020.01.29
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/43164
 * 실패한 문제
 * ********    배운 점      **************
 * */
import java.util.*;

class Solution {
    static boolean flag = false;
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        int len = tickets.length;
        HashMap<String, String> hm = new HashMap<String, String>();
        HashMap<String, Integer> check = new HashMap<String, Integer>();
        Stack<String> st = new Stack<String>();
        String ans = "";
        st.push("ICN");
        for(int i = 0;i<len;i++) {
            String departure = tickets[i][0];
            String destination = tickets[i][1];
            hm.put(departure,hm.getOrDefault(departure, "")+destination+",");
            check.put(departure,check.getOrDefault(departure, 0) + 1);
        }

        return answer;
    }
    void dfs(HashMap<String, String> hm, HashMap<String, Integer> check, String departure, int answer) {
        if(check.get(departure) == 0) return;
        if(answer == 6) {
            flag = true;
            return;}
        check.put(departure, check.get(departure) - 1);
        System.out.print(departure + ",");
        String destination = hm.get(departure);
        String [] des = destination.split(",");
        List<String> list = new LinkedList<String>();
        for(String str : des)
            list.add(str);
        Collections.sort(list, Collections.reverseOrder());
        for(String str : list) {
            dfs(hm, check, str, answer++);
        }
    }

}

class Solution2 {

    static boolean visit[];
    static List<String> list = new ArrayList<>();
    static String route = "";

    public String[] solution(String[][] tickets) {
        visit = new boolean[tickets.length];

        for(int i = 0 ; i < tickets.length; i++) {

            String departure = tickets[i][0];
            String destination = tickets[i][1];

            if(departure.equals("김포")) {
                visit[i] = true;
                route = departure + ",";
                dfs(tickets, destination, 1);
                visit[i] = false;
            }
        }

        Collections.sort(list);
        String[] answer = list.get(0).split(",");
        return answer;
    }

    public static void dfs(String[][] tickets, String end, int count) {

        route += end + ",";

        if(count==tickets.length) {
            list.add(route);
            return;
        }

        for(int i = 0 ; i < tickets.length ; i++) {
            String depart = tickets[i][0];
            String desti = tickets[i][1];

            if(end.equals(depart) && !visit[i]) {
                visit[i] = true;
                dfs(tickets, desti, count+1);
                visit[i] = false;
                route = route.substring(0, route.length()-4);
            }
        }
    }
}
