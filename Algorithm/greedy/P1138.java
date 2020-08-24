import java.io.*;
import java.util.*;

class Main {
    static class Person implements Comparable<Person> {
        int height;
        int position;
        Person(int height, int position){
            this.height = height;
            this.position = position;
        }
        @Override
        public int compareTo(Person o) {
            int result = this.position - o.position;
            return result;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N;
        /**
         * [1]. Init
         */
        N = Integer.parseInt(br.readLine());
        int [] position = new int[N];
        Person [] person = new Person[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i< N;i++)
            position[i] = Integer.parseInt(st.nextToken());

        for(int i = N - 1; i>=0;i--){
            for(int j = i+1; j<N;j++){
                if(position[i]<=position[j]){
                    position[j]+=1;
                }
            }
        }
        for(int i = 0 ;i<N;i++)
            person[i] = new Person(i+1,position[i]);
        Arrays.sort(person);

        for(int i = 0;i<N;i++)
            System.out.print(person[i].height + " ");
    }

}