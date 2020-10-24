
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        P11279();
    }
    static int N, M;
    static void P11279() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int command = Integer.parseInt(br.readLine());
            if (command == 0) {
                if (pq.size() == 0) {
                    sb.append("0\n");
                } else {
                    sb.append(pq.poll()+"\n");
                }
            } else {
                pq.add(command);
            }
        }
        System.out.println(sb.toString());
    }
}