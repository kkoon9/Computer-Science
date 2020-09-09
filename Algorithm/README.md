# 알고리즘

## 1. **Greedy와 Sort는 짝궁!**

- [11399번: ATM](https://www.acmicpc.net/problem/11399)

- Input
  - 줄을 서 있는 사람의 수 N
  - 각 사람이 돈을 인출하는데 걸리는 시간 Pi
- Want
  - 각 사람이 돈을 인출하는데 필요한 시간의 합의 **최솟값**

> **핵심 코드**

```java
import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
				/**
				 * [1]. Input
				*/
        int[] time = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            time[i] = Integer.parseInt(st.nextToken());

				/**
				 * [2]. Sort
				*/
        Arrays.sort(time);

				/**
				 * [3]. implement
				*/
        for (int i = 0; i < n; i++) {
            answer+= time[i] * (n -i);
        }
        System.out.println(answer);
    }
}
```

---

## 2. **Greedy는 class를 이용한 커즈터마이즈 정렬을 좋아해!**

[1931번: 회의실배정](https://www.acmicpc.net/problem/1931)

- Input
  - 회의의 수 N(1 ≤ N ≤ 100,000)
  - 공백을 사이에 두고 회의의 시작시간과 끝나는 시간
- Want
  - **최대 사용**할 수 있는 회의의 **최대 개수**

> **class와 Comparable을 이용한 커즈터마이즈 정렬**

```java
import java.io.*;
import java.util.*;

class Main {
    /**
     * class와 Comparable을 이용한 커즈터마이즈 정렬
     * end로 오름차순 정렬
     * end가 같다면 start로 오름차순 정렬
     */
    static class Conference implements Comparable<Conference>{
        int start; // 회의의 시작 시간
        int end;   // 회의의 끝나는 시간
        Conference(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Conference o) {
            int result = this.end - o.end;
            if(result == 0) {
                result = this.start - o.start;
            }
            return result;
        }
    }
    public static void main(String[] args) throws Exception {
        // 메인 코드
    }
}
```

> **비슷한 문제**

[9576번: 책 나눠주기](https://www.acmicpc.net/problem/9576)

---

## 3. **비교할 값을 변수에 저장해서 시간 초과를 면하자!**

[1946번: 신입 사원](https://www.acmicpc.net/problem/1946)

- Input
  - 테스트 케이스의 개수 T(1 ≤ T ≤ 20)
  - 지원자의 숫자 N(**1 ≤ N ≤ 100,000)**
  - 각각의 지원자의 서류심사 성적, 면접 성적의 순위
    - 두 성적 순위는 모두 1위부터 N위까지 동석차 없이 결정된다고 가정
- Want
  - 선발할 수 있는 신입사원의 **최대 인원수**
- Point
  - **N의 최대가 100,000이므로 O(n)으로 처리**해야 된다는 점을 명심하자!
  - 서류심사 성적을 기준으로 정렬 후, 면접 성적을 비교!

> **[1]. class를 이용한 커즈터마이즈 정렬**

```java
class Main {
    static class Person implements Comparable<Person> {
        int documentScore;
        int interviewScore;

        Person(int documentScore, int interviewScore) {
            this.documentScore = documentScore;
            this.interviewScore = interviewScore;
        }

        @Override
        public int compareTo(Person o) {
            int result = this.documentScore - o.documentScore;
            return result;
        }
    }
```

> **[2]. 이 성적(min)보다 낮으면 합격 못 해!**

```java
public static void main(String[]args)throws Exception{

        **int min=person[0].interviewScore;**
        for(int i=1;i<N; i++){
        if(person[i].interviewScore>min){
        answer--;
        }else
        **min=person[i].interviewScore;**

        }
        System.out.println(answer);
}
```

그리디 문제는 거의 최대 최소 찾는 문제인 듯 하다!
더 많은 문제를 풀어보자!

## 4. **배수 찾기!**

[10610번: 30](https://www.acmicpc.net/problem/10610)

- Input
  - 양수 N (N는 최대 100000개의 숫자)
- Want
  - N에 포함된 숫자들을 섞어 30의 배수가 되는 가장 큰 수
  - 존재하지 않다면 -1을 출력
- Point
  - 30의 배수가 되려면
    1. 0이 한 개 이상 있어야한다. (마지막이 0)
    2. 자릿수를 모두 더하면 3의 배수이다.

> **핵심 코드**

```java
import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(br.readLine());

        /**
         * [1]. Input
         */
        String n = br.readLine();
        StringBuilder sb = new StringBuilder();
        int[] count = new int[10];
        char[] thirty = n.toCharArray();
        int sum = 0; // N의 자릿수를 모두 더한 값
        String answer;

        /**
         * [2]. Sort
         */
        Arrays.sort(thirty);
        sb.append(thirty);
        sb = sb.reverse(); // 출력을 위한 reverse

        /**
         * [3]. implements
         */
        int size = sb.length();
        for (int i = 0; i < size; i++) {
            int val = sb.charAt(i) - '0';
            count[val]++;
            sum += val;
        }
        if (count[0] == 0) answer = "-1";
        else if (sum % 3 == 0) {
            answer = sb.toString();
        } else {
            answer = "-1";
        }
        System.out.println(answer);
    }
}
```

## 5. **줄 세우기!**

[1138번: 한 줄로 서기](https://www.acmicpc.net/problem/1138)

- Input
  - 사람의 수 N (N는 최대 10)
  - 키가 1인 사람부터 차례대로 자기보다 키가 큰 사람이 왼쪽에 몇 명이 있었는지
- Want
  - 첫째 줄에 줄을 선 순서대로 키를 출력
- Point
  - N이 최대 10이라 O(N^2)도 가능하다.
  - 키가 index가 된다.

> **핵심 코드**

```java
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
```

## 6. **순열은 재귀! 어렵다 어려워!**

[소수 찾기](https://programmers.co.kr/learn/courses/30/lessons/42839)

- Input
  - 각 종이 조각에 적힌 숫자 numbers (String)
- Want
  - 종이 조각으로 만들 수 있는 소수의 개수
- Point
  - 종이 조각으로 만들 수 있는 수를 구해야 한다! : **순열!**

> **핵심 코드 : 순열**

```java
import java.io.*;
import java.util.*;

class Solution {
    static HashSet<Integer> hs = new LinkedHashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        permutation("", numbers);
		}
		public void permutation(String s, String number) {
        for (int i = 0; i < number.length(); i++) {
            permutation(s + number.charAt(i), **number.substring(0,i) + number.substring(i+1, number.length()**));
            if(!s.equals(""))
                hs.add(Integer.parseInt(s));
        }
    }

}
```

**number.substring(0,i) + number.substring(i+1, number.length())**

- 이 코드가 순열의 핵심이다.

1. s + number.charAt(i)는 HashSet 변수 hs에 넣어준다.
2. i번째 문자를 제외한 문자열을 새로 만들어준다.

- 1번, 2번에 만들어진 문자열로 재귀를 해준다.

## 7. **경우의 수!**

[위장](https://programmers.co.kr/learn/courses/30/lessons/42578)

- **A(2벌), B(3벌), C(2벌)일 때, 옷을 입을 수 있는 경우의 수**

**(2 + 1) _ (3 + 1) _ (2 + 1) - 1**

- 각 요소별에 +1 해주는 이유? **입지 않는 경우를 추가해준다.**
- 마지막 -1 해주는 이유? **모두 안 입은 경우를 빼준다.**

## 8. **탐색이 끝났으면 원래대로 되돌려놔!**

[6603번: 로또](https://www.acmicpc.net/problem/6603)

- Input
  - 입력은 여러 개의 테스트 케이스로 이루어져 있다.
  - 각 테스트 케이스는 한 줄로 이루어져 있다.
  - 첫 번째 수 : k (6 < k < 13)
  - 다음 k개 수 : 집합 S에 포함되는 수이다. S의 원소는 오름차순으로 주어진다.
  - 입력의 마지막 줄에는 0이 하나 주어진다.
- Want
  - 각 테스트 케이스마다 수를 고르는 모든 방법을 출력한다. (사전 순)
  - 각 테스트 케이스 사이에는 빈 줄을 하나 출력한다.
- Point
  - 탐색이 끝났으면 이전상태로 되돌려야 한다!
    - visit
  - 사전 순으로 출력

> **[1]. 변수설명**

```java
public class Main {
	public static void main(String[] args) throws IOException {
        int[] lotto = new int[N]
				boolean[] visit = new boolean[N];
}
```

- lotto : 입력값
- visit : 탐색을 했는지 체크해주는 boolean 배열

> **[2]. 6개만 출력**

```java
public class Main {
	public static void main(String[] args) throws IOException {
            for (int i = 0; i < N - 5; i++) {
                visit[i] = true;
                int[] arr = new int[6];
                arr[0] = lotto[i];
                dfs(lotto, visit, 1, arr);

            }
}
```

- N - 5까지 한 이유?
  - 로또번호는 6개이므로 6개만 출력할 수 있다.
  - 또한 출력이 사전 순으로 이루어져야 한다.
  - 즉, N이 7이면 앞에서 두 번째 수까지만 1번째 원소가 될 수 있다.

> **[3]. dfs**

```java
public class Main {
	public static void dfs(int[] lotto, boolean[] visit, int count, int[] arr) {
				**// [2]**
        if(count == 6) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ;i<6;i++){
                sb.append(arr[i] + " ");
            }
            System.out.println(sb);
        }else {
						**// [3]**
            for(int i = 0; i < N; i++) {
                if(visit[i])continue;
                if(arr[count - 1] > lotto[i]) continue;
                visit[i] = true;
                arr[count] = lotto[i];
                dfs(lotto,visit,count+1, arr);
                visit[i] = false;
            }
        }
    }
}
```

### 출력 형태

- count가 6, 즉 arr의 크기가 6이 될 때 arr의 원소들을 출력해준다.

### 백트레킹 구현

- visit
  - visit은 arr 원소에 넣은지 안 넣은지를 구분해준다.
  - 즉, **중복을 방지**해준다.
  - 재귀로 dfs를 선언해준 뒤, 재귀에서 빠져나오면 visit을 false로 바꿔준다.

```java
if(arr[count -1] > lotto[i]) continue;
```

- 사전순이므로 원래 있던 원소보다 작은 값은 넣어주지 않는다.

> **전체 코드**

```java
import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            if(N == 0)break;
            int[] lotto = new int[N];
            boolean[] visit = new boolean[N];
            for (int i = 0; i < N; i++) {
                lotto[i] = Integer.parseInt(st.nextToken());
            }
						**// [1]**
            for (int i = 0; i < N - 5; i++) {
                visit[i] = true;
                int[] arr = new int[6];
                arr[0] = lotto[i];
                dfs(lotto, visit, 1, arr);

            }
            System.out.println();
        }
    }

    public static void dfs(int[] lotto, boolean[] visit, int count, int[] arr) {
				**// [2]**
        if(count == 6) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ;i<6;i++){
                sb.append(arr[i] + " ");
            }
            System.out.println(sb);
        }else {
						**// [3]**
            for(int i = 0; i < N; i++) {
                if(visit[i])continue;
                if(arr[count - 1] > lotto[i]) continue;
                visit[i] = true;
                arr[count] = lotto[i];
                dfs(lotto,visit,count+1, arr);
                visit[i] = false;
            }
        }
    }
}
```

## 9. **visit에 상태를 넣어라! - visit의 3차원 배열화**

[2206번: 벽 부수고 이동하기](https://www.acmicpc.net/problem/2206)

## 틀린 코드

```java
import java.util.*;
import java.io.*;

public class Main {
    static class Dot {
        int n;
        int m;
        int count = 0;
        boolean broken = false;
        Dot(int n, int m) {
            this.n = n;
            this.m = m;
        }
        Dot(int n, int m, int count, boolean broken) {
            this.n = n;
            this.m = m;
            this.count = count;
            this.broken = broken;
        }
    }
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int N, M;
    static int[][] board;
    static boolean[][] visit;
    static boolean flag = true;
    static int answer = 1000000000;
    static Queue<Dot> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N+1][M+1];
        visit = new boolean[N+1][M+1];
        for (int i = 1; i <= N; i++) {
            String input = br.readLine();
            for (int j = 1; j <= M; j++) {
                board[i][j] = input.charAt(j-1) - '0';
            }
        }
        queue.add(new Dot(1,1, 1, false));
        visit[1][1] = true;
        BFS();
        if(flag){
            answer = -1;
        }
        System.out.println(answer);
    }

    private static void BFS() {
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0 ;i<size;i++){
                Dot dot = queue.poll();
                int n = dot.n;
                int m = dot.m;
                int count = dot.count;
                boolean broken = dot.broken;
                if(n == N && m == M){
                    if(answer > count){
                        answer = count;
                    }
                    flag = false;
                }
                for(int d = 0 ;d<4;d++){
                    int nextN = n + dx[d];
                    int nextM = m + dy[d];
                    if(isLimit(nextN, nextM)) continue;
                    if(visit[nextN][nextM]) continue;
                    if(board[nextN][nextM] == 0) { // 이동 가능하다면
                        queue.add(new Dot(nextN, nextM,count+1, broken));
                    } else {
                        if(!broken) {
                            queue.add(new Dot(nextN, nextM, count+1, true));
                        }
                    }
                    visit[nextN][nextM] = true;
                }
            }
        }
    }

    private static void printDot(Dot dot) {
        System.out.println("N : " + dot.n + " M : " + dot.m + " count : " + dot.count + " broekn : " + dot.broken);
    }
    private static boolean isLimit(int nextN, int nextM) {
        return nextN<= 0 || nextM <= 0 || nextN > N || nextM > M;
    }

}
```

1. visit은 3차원 배열로 선언했어야 했다.
   - visit에 상태까지 저장하여야 했다.

### 왜 상태까지 저장?

1. **가중치가 없는 최단 경로는** 무조건 **BFS.**
   - DFS가 안되는 이유?
     - 특정 칸에 처음 도달했을 때까지의 경로의 길이가 다른 경로를 통해 도달한 길이보다 짧다는 보장이 전혀 없기 때문입니다.
2. **칸마다 방문 체크 하나씩만 하는 방법으로는 풀 수 없다**.

   - 어떤 칸에 도달했을 때 나는 "아직 벽을 부술 수 있는 상태"일 수도 있고, "더 이상 벽을 부술 수 없는 상태"일 수도 있다. **큐에 그 상태를 넣은 것만으로 되는 것이 아니다**. 당장 이 지점까지 어떻게든 **최단으로 오는 길만 구했다고 해서, 그 이후의 여정도 최적으로 만들 수 있는 건 아니다.** 다음은 **구체적인 반례**이다.

```
     6 3
     000
     110
     000
     011
     111
     000
```

3. 그래서 이 문제에서는 BFS에 대해 새로운 테크닉을 요구한다. 단순히 좌표만을 큐에 넣어 탐색하는 방식을 넘어, "현재 상태" 자체를 큐에 넣어서 문제를 풀어야 한다. 즉, 어떤 좌표에 있는가 뿐만 아니라, "여기까지 오면서 벽을 부순 적이 있는가" 여부를 함께 큐에 저장해서 탐색하고, **각각을 별개로 방문 체크해줘야 하는 문제이다**. visited[y][x]가 아니라, visited[y][x][벽을 부순 적이 있는가?] 가 되어야 한다.

> 정답 코드

```java
import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static boolean[][] graph;
    static boolean[] visit;
    static int component;
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        /**
         * [1]. Init
         */
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new boolean[N + 1][N + 1];
        visit = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            int u, v;
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            graph[u][v] = graph[v][u] = true;
        }
        for (int i = 1; i <= N; i++) {
            if (visit[i]) continue;
            queue.add(i);
            BFS();
            component++;
        }
        System.out.println(component);

    }

    private static void BFS() {
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int idx = 0; idx < size; idx++) {
                int x = queue.poll();
                visit[x] = true;
                for (int y = 1; y <= N; y++) {
                    if (visit[y]) continue;
                    if (graph[x][y]) {
                        queue.add(y);
                        visit[y] = true;
                    }
                }
            }
        }
    }
}
```

## 10. **visit에 상태를 넣어라2! - 비트마스크 활용**

[1194번: 달이 차오른다, 가자.](https://www.acmicpc.net/problem/1194)

- Input
  - N, M : int, 세로, 가로
    - 1≤ N, M ≤ 50
  - N x M 미로를 입력 받는다.
    - . : 빈 곳(이동이 가능)
    - # : 벽(이동이 불가능)
    - a~f : 열쇠
    - A~F : 열쇠에 대응하는 문
    - 0 : 민식이의 위치( 1개)
    - 1 : 출구(여러 개)
- Want
  - 0에서 1로 가는 최소 횟수
  - 탈출할 수 있는 경우가 없을 경우에는 -1을 리턴한다.
- Point
  - 열쇠는 여러 번 사용 가능하다.
  - visit 배열에 상태도 같이 체크해야한다. (**3차원 배열!!**)

> **[1]. 변수설명 및 메인**

```java
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int N, M;
    static char[][] board;
    static boolean[][][] visit;
    static boolean flag = true;
    static int answer = Integer.MAX_VALUE;
    static Queue<Dot> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        Dot start = new Dot(0, 0);
        visit = new boolean[N][M][1 << 6];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = input.charAt(j);
                if (board[i][j] == '0') start = new Dot(i, j);
            }
        }
        int n = start.n;
        int m = start.m;
        queue.add(new Dot(n, m, 0, 0));
        visit[n][m][0] = true;
        System.out.println(BFS());
    }
```

- dx, dy : 상하좌우로 움직일 값
- board : 미로(input 값)
- visit : 3차원 배열 [세로 값][가로 값][현재 가지고 있는 키]
  - **비트 마스크**로 표현할 수 있다. 키의 개수는 6개
- start 값을 구해서 queue에 넣은 후 BFS 함수를 진행해준다.

> **[2]. class Dot**

```java
public class Main {
    static class Dot {
        int n;
        int m;
        int count;
        int key;

        Dot(int n, int m) {
            this.n = n;
            this.m = m;
        }

        Dot(int n, int m, int count, int key) {
            this.n = n;
            this.m = m;
            this.count = count;
            this.key = key;
        }
    }
```

- n, m : 세로, 가로 좌표
- count : 이동 횟수
- key : **비트마스크**를 이용하여 상태를 체크해준다.(a - f)

> **[3]. BFS**

```java
    private static int BFS() {
        while (!queue.isEmpty()) {
            Dot dot = queue.poll();
            int n = dot.n;
            int m = dot.m;
            int count = dot.count;
            int key = dot.key;
            if (board[n][m] == '1') {
                flag = false;
                return count;
            }
            for (int d = 0; d < 4; d++) {
                int nextN = n + dy[d];
                int nextM = m + dx[d];
                int nextkey = key;
                if (isLimit(nextN, nextM)) continue;
                char ch = board[nextN][nextM];
                if (ch == '#') continue;
                **if (ch >= 'a' && ch <= 'f')
                    nextkey |= (1 << ch - 'a');**
                **if (ch >= 'A' && ch <= 'F')
                    if ((nextkey & (1 << (ch - 'A'))) == 0) continue;**
                if (visit[nextN][nextM][nextkey]) continue;
                visit[nextN][nextM][nextkey] = true;
                queue.add(new Dot(nextN, nextM, count + 1, nextkey));
            }

        }
        return -1;
    }

```

- key의 비트마스크가 가장 중요한 부분이다.
- a-f의 키를 찾으면 | 연산을 통해 key에 해당하는 키(a~f)를 OR 연산해준다.
- A-F의 문을 찾으면 & 연산을 통해 문(A-F)에 해당하는 키(a~f)가 있는지 체크한다.

| 연산 : **nextkey |= (1 << ch - 'a');**

& 연산 : **if ((nextkey & (1 << (ch - 'A'))) == 0) continue;**

> **전체 코드**

```java
import java.util.*;
import java.io.*;

public class Main {
    static class Dot {
        int n;
        int m;
        int count;
        int key;

        Dot(int n, int m) {
            this.n = n;
            this.m = m;
        }

        Dot(int n, int m, int count, int key) {
            this.n = n;
            this.m = m;
            this.count = count;
            this.key = key;
        }
    }

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int N, M;
    static char[][] board;
    static boolean[][][] visit;
    static boolean flag = true;
    static int answer = Integer.MAX_VALUE;
    static Queue<Dot> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        Dot start = new Dot(0, 0);
        visit = new boolean[N][M][1 << 6];
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = input.charAt(j);
                if (board[i][j] == '0') start = new Dot(i, j);
            }
        }
        int n = start.n;
        int m = start.m;
        queue.add(new Dot(n, m, 0, 0));
        visit[n][m][0] = true;
        System.out.println(BFS());
    }

    private static int BFS() {
        while (!queue.isEmpty()) {
            Dot dot = queue.poll();
            int n = dot.n;
            int m = dot.m;
            int count = dot.count;
            int key = dot.key;
            if (board[n][m] == '1') {
                flag = false;
                return count;
            }
            for (int d = 0; d < 4; d++) {
                int nextN = n + dy[d];
                int nextM = m + dx[d];
                int nextkey = key;
                if (isLimit(nextN, nextM)) continue;
                char ch = board[nextN][nextM];
                if (ch == '#') continue;
                if (ch >= 'a' && ch <= 'f')
                    nextkey |= (1 << ch - 'a');
                if (ch >= 'A' && ch <= 'F')
                    if ((nextkey & (1 << (ch - 'A'))) == 0) continue;
                if (visit[nextN][nextM][nextkey]) continue;
                visit[nextN][nextM][nextkey] = true;
                queue.add(new Dot(nextN, nextM, count + 1, nextkey));
            }

        }
        return -1;
    }

    private static void printDot(Dot dot) {
        System.out.println("N : " + dot.n + " M : " + dot.m + " count : " + dot.count);
    }

    private static boolean isLimit(int nextN, int nextM) {
        return nextN < 0 || nextM < 0 || nextN >= N || nextM >= M;
    }

}
```

## 11. **Deque에 add는 addLast와 같아!**

[프린터](https://programmers.co.kr/learn/courses/30/lessons/42587)

- 프린트 문제를 풀면서 Deque가 헷갈려서 정리

- Deque
  - Double-Ended Queue의 줄임말
  - 큐의 양쪽 끝에서 삽입과 삭제가 모두 발생할 수 있는 큐
- 추가하기
  - add(=addLast), addFirst(=push)
  - offer(=offerLast), offerFirst(=push)
- 제거하기
  - poll(=pollFirst, pop), pollLast
- 값을 제거하지 않고 확인만 하기
  - peek(=peekFirst), peekLast

## 12. **values()를 이용하면 모든 value를 알 수 있어!**

[위장](https://programmers.co.kr/learn/courses/30/lessons/42578)

위장 문제를 풀면서 HashMap이 헷갈려서 정리

- HashMap
  - Key와 value를 묶어 하나의 entry로 저장한다는 특징을 갖는다.
  - hashing을 사용하기 때문에 많은 양의 데이터를 검색하는데 뛰어난 성능을 보인다.
  - Map 인터페이스의 한 종류로 ( "Key", value) 로 이뤄져 있다.
  - key 값을 중복이 불가능 하고 value는 중복이 가능. value에 null값도 사용 가능하다.
  - 멀티쓰레드에서 동시에 HashMap을 건드려 Key - value값을 사용하면 문제가 될 수 있다. 멀티쓰레드에서는 HashTable을 쓴다.
