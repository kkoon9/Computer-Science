/**
 * @desc 자연수 N이 입력되면 1부터 N까지의 수 중 M의 배수합을 출력하는 프로그램
 * @param 3<=M<N<=1000
 * @return 배수합(answer)
 */
class MultipleSum {
  public int solution(int n, int m) {
    int answer = 0;
    for (int i = m; i <= n; i += m) {
      answer += i;
    }
    return answer;
  }
}

/**
 * @desc 자연수 A,B가 입력되면 A부터 B까지의 합을 수식과 함께 출력하는 프로그램
 * @param 1<=A<B<=1000
 * @return 수식과 함께 합을 출력(answer)
 */
class SumofNaturalNumber {
  public String solution(int A, int B) {
    String answer = "";
    int sum = 0;
    for (int i = A; i <= B; i++) {
      sum += i;
      answer += String.valueOf(i);
      answer += " + ";
    }
    answer = answer.substring(0, answer.length() - 3);
    answer += " = ";
    answer += String.valueOf(sum);
    return answer;
  }
}

/**
 * @desc 자연수 N이 입력되면 N의 진약수들의 합을 수식과 함께 출력하는 프로그램
 * @param 3<=N<=100
 * @return 수식과 함께 합을 출력(answer)
 */
class ProperDivisor {
  public String solution(int N) {
    String answer = "";
    int sum = 0;
    for (int i = 1; i < N; i++) {
      if (N % i == 0) {
        sum += i;
        answer += String.valueOf(i);
        answer += " + ";
      }
    }
    answer = answer.substring(0, answer.length() - 3);
    answer += " = ";
    answer += String.valueOf(sum);
    return answer;
  }
}

/**
 * @desc 자연수 N명의 나이가 입력되면 최대 나이 차이를 출력하는 프로그램
 * @param 2<=N<=100
 * @return 최대 나이 차이를 출력
 */
class MostAgeGap {
  public int solution(int N, int[] arr) {
    int answer = 0;
    Arrays.sort(arr);
    answer = arr[arr.length - 1] - arr[0];
    return answer;
  }
}

/**
 * @desc 주민등록번호가 주어지면 나이와 성별을 출력하는 프로그램
 * @param 주민등록번호
 * @return 나이와 성별을 공백을 구분으로 출력
 */
class GetAgeAndGender {
  public String solution(String identificationNumber) {
    String answer = "";
    int years = Integer.parseInt(identificationNumber.substring(0, 2));
    String gender = "";
    switch (identificationNumber.charAt(7)) {
      case '1':
        years += 1900;
        gender = "M";
        break;
      case '3':
        years += 2000;
        gender = "M";
        break;
      case '2':
        years += 1900;
        gender = "W";
        break;
      case '4':
        years += 2000;
        gender = "W";
        break;
      default:
        break;
    }
    answer = String.valueOf(2020 - years) + " " + gender;
    return answer;
  }
}

/**
 * @desc 문자열을 입력받아 숫자만 추출한 후 숫자의 약수의 개수와 함께 출력하는
 * @param 문자열
 * @return 숫자와 약수의 개수를 출력
 */
class GetOnlyNumber {
  public void solution(String str) {
    int number = Integer.parseInt(getNumber(str));
    int divisorCount = getDivisorCount(number);
    System.out.println(number);
    System.out.println(divisorCount);
  }

  int getDivisorCount(int number) {
    int result = 0;
    for (int i = 1; i <= number; i++) {
      if (number % i == 0) {
        result++;
      }
    }
    return result;
  }

  String getNumber(String str) {
    List<Integer> list = new LinkedList<>();
    Pattern p = Pattern.compile("\\d+");
    Matcher m = p.matcher(str);
    while (m.find()) {
      list.add(Integer.parseInt(m.group()));
    }
    String result = "";
    for (int number : list) {
      result += String.valueOf(number);
    }
    return result;
  }
}

/**
 * @desc 문자열을 입력받아 소문자로 변환 및 공백을 제거하는 프로그램
 * @param 문자열
 * @return 문자열
 */
class RestoreStirng {
  public String solution(String str) {
    String answer = RemoveBlank(str);
    answer = ConvertToLowercase(answer);
    return answer;
  }

  String RemoveBlank(String str) {
    return str.replaceAll(" ", "");
  }

  String ConvertToLowercase(String str) {
    return str.toLowerCase();
  }
}

/**
 * @desc 괄호 문자열을 입력받아 올바른 괄호인지 출력하는 프로그램
 * @param 괄호 문자열
 * @return Yes or No
 */

class IsRightBracket {
  public String solution(String bracket) {
    String answer = "YES";
    int bracketSize = bracket.length();
    int leftCount = 0;

    for (int i = 0; i < bracketSize; i++) {
      if (bracket.charAt(i) == '(') {
        leftCount++;
      } else {
        if (leftCount == 0) {
          answer = "NO";
          break;
        } else {
          leftCount--;
        }
      }
    }
    if (leftCount != 0) {
      answer = "NO";
    }
    return answer;
  }
}

/**
 * @desc 자연수 N을 입력받아 1부터 N까지의 약수의 개수를 출력하는 프로그램
 * @param 정수
 * @return 약수의 개수(Integer형 배열)
 */
class GetDivisorCountAll {
  public int[] solution(int number) {
    int[] answer = new int[number];
    for (int i = 1; i <= number; i++) {
      answer[i - 1] = getDivisorCount(i);
    }
    return answer;
  }

  int getDivisorCount(int number) {
    int result = 0;
    for (int i = 1; i <= number; i++) {
      if (number % i == 0) {
        result++;
      }
    }
    return result;
  }
}

/**
 * @desc N개의 자연수를 입력받아 각 자연수의 자릿수의 합을 구하고 그 합이 최대인 자연수 출력
 * @desc 자릿수의 합이 최대인 자연수가 여러개인 경우 그 중 값이 가장 큰 값을 출력
 * @param 정수
 * @return 약수의 개수(Integer형 배열)
 */
class SumOfDigits {
  class Number implements Comparable<Number> {
    int num;
    int sumofdigit;

    Number(int num, int sumofdigit) {
      this.num = num;
      this.sumofdigit = sumofdigit;
    }

    @Override
    public int compareTo(Number o) {
      int result = o.sumofdigit - this.sumofdigit;
      if (result == 0) {
        result = o.num - this.num;
      }
      return result;
    }
  }

  public int solution(int N, int[] numbers) {
    Number[] NumArr = new Number[numbers.length];
    int i = 0;
    for (int number : numbers) {
      NumArr[i++] = new Number(number, sumOfDigit(String.valueOf(number)));
    }
    Arrays.sort(NumArr);
    return NumArr[0].num;
  }

  int sumOfDigit(String number) {
    int result = 0;
    for (int i = 0; i < number.length(); i++) {
      result += number.charAt(i) - '0';
    }
    return result;
  }
}

/**
 * @desc N을 입력받아 1부터 N까지의 자연수는 몇 개가 사용되었는지 출력하는 프로그램
 * @param 정수
 * @return 숫자의 개수
 */
class CountofNumber {
  public int solution(int N) {
    String str = "";
    for (int i = 1; i <= N; i++) {
      str += String.valueOf(i);
    }
    return str.length();
  }
}

/**
 * @desc N자리의 자연수가 입력되면 자연수의 자릿수 중 가장 많이 사용된 숫자를 출력
 * @param 정수
 * @return 가장 많이 사용된 숫자
 */
class MostUsedNumber {
  public int solution(String N) {
    int[] numbers = new int[10];
    int num = 0;
    int mostusednumber = 0;
    for (int i = 0; i < 10; i++) {
      numbers[i] = 0;
    }
    for (int i = 0; i < N.length(); i++) {
      numbers[N.charAt(i) - '0']++;
    }
    for (int i = 0; i < 10; i++) {
      if (num <= numbers[i]) {
        num = numbers[i];
        mostusednumber = i;
      }
    }
    return mostusednumber;
  }
}

/**
 * @desc N개의 정수를 입력받아 각 숫자의 뒤집은 숫자가 소수인지 판별하는 프로그램
 * @param N개의 정수
 * @return 소수인 숫자들 출력
 */
class IsReversePrimeNumber {
  final int MAX = 100000;
  boolean[] prime = new boolean[MAX];

  public int[] solution(int N, int[] numbers) {
    List<Integer> list = new LinkedList<>();
    Prime();
    for (int number : numbers) {
      int reverseNumber = reverse(number);
      if (isPrime(reverseNumber)) {
        list.add(reverseNumber);
      }
    }
    int[] answer = new int[list.size()];
    int i = 0;
    for (int number : list) {
      answer[i++] = number;
    }
    return answer;
  }

  void Prime() {
    for (int i = 2; i < Math.sqrt(MAX); i++) {
      if (!prime[i]) {
        for (int j = i + i; j < MAX; j += i) {
          prime[j] = true;
        }
      }
    }
  }

  boolean isPrime(int x) {
    return prime[x] ? false : true;
  }

  int reverse(int x) {
    StringBuilder sb = new StringBuilder();
    String result = sb.append(x).reverse().toString();
    return Integer.parseInt(result);
  }
}

/**
 * @desc N을 입력받아 1부터 N까지의 소수의 개수를 출력하는 프로그램
 * @param 정수
 * @return 소수의 개수를 출력
 */
class GetCountOfPrimeNumber {
  final int MAX = 100000;
  boolean[] prime = new boolean[MAX];

  public int solution(int N) {
    Prime();
    int answer = 0;
    for (int i = 2; i <= N; i++) {
      if (isPrime(i)) {
        answer++;
      }
    }
    return answer;
  }

  void Prime() {
    for (int i = 2; i < Math.sqrt(MAX); i++) {
      if (!prime[i]) {
        for (int j = i + i; j < MAX; j += i) {
          prime[j] = true;
        }
      }
    }
  }

  boolean isPrime(int x) {
    return prime[x] ? false : true;
  }
}

/**
 * @desc 두 개의 문자열을 입력받아 두 문자열이 아나그램인지 판별하는 프로그램
 * @param 두 문자열
 * @return YES or NO
 */
class IsAnagram {
  final int SIZE = 53;

  public String solution(String str1, String str2) {
    String answer = "YES";
    int[] anagramFirst = anagram(str1);
    int[] anagramSecond = anagram(str2);
    for (int i = 0; i < SIZE; i++) {
      if (anagramFirst[i] != anagramSecond[i]) {
        answer = "NO";
        break;
      }
    }
    return answer;
  }

  int[] anagram(String str) {
    int[] arr = new int[SIZE];
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (ch > 'Z') {
        arr[ch - 'a' + SIZE / 2]++;
      } else {
        arr[ch - 'A']++;
      }
    }
    return arr;
  }
}

/**
 * @desc N개의 숫자가 주어지면 각 숫자 m부터 1까지 더한 수가 맞는지 출력하는 프로그램
 * @param N개의 숫자와 그에 해당하는 합
 * @return YES or NO
 */
class SumFromOneToNumber {
  public String[] solution(int N, int[][] arr) {
    String[] answer = new String[N];
    for (int i = 0; i < N; i++) {
      if (arr[i][1] == getSum(arr[i][0])) {
        answer[i] = "YES";
      } else {
        answer[i] = "NO";
      }
    }
    return answer;
  }

  int getSum(int number) {
    int result = 0;
    for (int i = 1; i <= number; i++) {
      result += i;
    }
    return result;
  }
}

/**
 * @desc 세대의 측청치가 M값을 넘으면 경보음이 울린다. N초 동안의 실시간 측정치가 주어지면 최대 연속으로 경보음이 울린 시간을
 *       출력하는 프로그램(DP)
 * @param N초 동안에 실시간 측청치와 M
 * @return YES or NO
 */
class GetMaxContinuous {
  final int MAX = 105;
  int[] memo = new int[MAX];
  int answer = 0;

  public int solution(int N, int M, int[] arr) {
    memo[0] = 0;
    for (int i = 1; i <= N; i++) {
      if (arr[i - 1] > M) {
        memo[i] = memo[i - 1] + 1;
      } else {
        memo[i] = 0;
      }
    }
    for (int i = 0; i <= N; i++) {
      if (answer < memo[i]) {
        answer = memo[i];
      }
    }
    if (answer == 0) {
      answer = -1;
    }
    return answer;
  }
}

/**
 * @desc 뒷사람 모두의 시야를 가리는 사람의 수를 출력하는 프로그램
 * @param N, N명의 앉은 키
 * @return 시야를 가리는 사람의 수
 */
class CountOfBlind {
  final int MAX = 105;
  int[] memo = new int[MAX];
  int answer = 0;

  public int solution(int N, int[] arr) {
    memo[0] = 1; // 0이면 기울기가 음수, 1이면 기울기가 양수
    for (int i = 1; i < N; i++) {
      // 기울기가 양수
      if (memo[i - 1] == 1) {
        memo[i] = 1;
        // 앞사람보다 앉은키가 작다면
        if (arr[i - 1] > arr[i]) {
          answer++;
          memo[i] = 0;
        }
      } else if (arr[i - 1] < arr[i]) {
        memo[i] = 1;
      }
    }
    return answer;
  }
}

/**
 * @desc 두 사람의 가위바위보 결과를 출력하는 프로그램
 * @param N, 두 사람의 N번의 가위바위보 정보
 * @return 가위바위보 결과를 가지는 배열
 */
class GetResultRockPaperScissors {
  public String solution(int N, int[] A, int[] B) {
    String answer = "";
    for (int i = 0; i < N; i++) {
      answer += whoWin(A[i], B[i]);
    }
    return answer;
  }

  String whoWin(int A, int B) {
    String result = "";
    // A가 가위일 때
    if (A == 1) {
      if (B == 1) {
        result = "D ";
      } else if (B == 2) {
        result = "B ";
      } else {
        result = "A ";
      }
    } else if (A == 2) {
      if (B == 1) {
        result = "A ";
      } else if (B == 2) {
        result = "D ";
      } else {
        result = "B ";
      }
    } else {
      if (B == 1) {
        result = "B ";
      } else if (B == 2) {
        result = "A ";
      } else {
        result = "D ";
      }
    }
    return result;
  }
}

/**
 * @desc 두 사람의 카드게임 점수와 승자를 출력하는 프로그램
 * @param N, 두 사람의 10번의 카드게임 정보
 * @return 두 사람의 카드 게임 점수와 승자
 */
class CardGameScoreAndWinner {
  final int SIZE = 10;

  public String solution(int[] A, int[] B) {
    String answer = "";
    int aScore = 0;
    int bScore = 0;
    for (int i = 0; i < SIZE; i++) {
      if (A[i] > B[i]) {
        aScore += 3;
      } else if (A[i] < B[i]) {
        bScore += 3;
      } else {
        aScore++;
        bScore++;
      }
    }
    answer += String.valueOf(aScore) + " " + String.valueOf(bScore) + " ";
    if (aScore > bScore)
      answer += "A";
    else if (aScore < bScore)
      answer += "B";
    else
      answer += "D";
    return answer;
  }
}

/**
 * @desc N번의 온도가 주어졌을 때, 가장 큰 연속된(K) 온도의 합을 출력하는 프로그램
 * @desc 연속합을 출력하는 프로그램
 * @param N, K, N개의 온도
 * @return 두 사람의 카드 게임 점수와 승자
 */
class GetMaxContinuousSum {
  public int solution(int N, int K, int[] arr) {
    int answer = -1000;
    for (int i = 0; i < N - K + 1; i++) {
      int sum = ContinuousSumWithK(arr, K, i);
      if (answer < sum) {
        answer = sum;
      }
    }
    return answer;
  }

  private int ContinuousSumWithK(int[] arr, int k, int i) {
    int result = 0;
    int length = i + k;
    for (; i < length; i++) {
      result += arr[i];
    }
    return result;
  }
}

/**
 * @desc N개의 숫자를 입력받아 연속적으로 증가하는 부분 수열의 최대 길이를 출력하는 프로그램
 * @desc 연속 부분 증가수열을 출력하는 프로그램
 * @param N, N개의 수열
 * @return 연속 부분 증가수열
 */
class Question23 {
  final int MAX = 100001;
  int[] memo = new int[MAX];

  public int solution(int N, int[] arr) {
    int answer = 0;
    memo[0] = 1;
    for (int i = 1; i < N; i++) {
      if (arr[i - 1] <= arr[i]) {
        memo[i] = memo[i - 1] + 1;
      } else {
        memo[i] = 1;
      }
    }
    for (int i = 0; i <= N; i++) {
      if (answer < memo[i]) {
        answer = memo[i];
      }
    }
    return answer;
  }
}

/**
 * @desc N개의 정수로 이루어진 수열에 대해 서로 인접해 있는 두 수의 차가 1에서 N-1까지의 값을 모두 가지면 Jolly
 *       Jumpers라고 한다.
 * @desc 주어진 수열이 Jolly Jumpers인지 판단하는 프로그램
 * @param N, N개의 수열
 * @return YES or NO
 */
class Question24 {
  public String solution(int N, int[] arr) {
    String answer = "YES";
    for (int i = 0; i < N - 1; i++) {
      if (Math.abs(arr[i] - arr[i + 1]) >= N) {
        answer = "NO";
        break;
      }
    }
    return answer;
  }
}

/**
 * @desc 각 학생의 석차를 입력된 순서대로 출력하는 프로그램
 * @param N, N명의 성적
 * @return 학생들의 석차
 */
class Question25 {
  class Rank implements Comparable<Rank> {
    int score;
    int index;

    Rank(int score, int index) {
      this.score = score;
      this.index = index;
    }

    @Override
    public int compareTo(Rank o) {
      int result = o.score - this.score;
      return result;
    }
  }

  public int[] solution(int N, int[] scores) {
    Rank[] scoreArr = new Rank[N];
    int[] answer = new int[N];
    int i = 0;
    int rank = 1;
    int same = 1;
    for (i = 0; i < N; i++) {
      scoreArr[i] = new Rank(scores[i], i);
    }
    Arrays.sort(scoreArr);
    answer[scoreArr[0].index] = rank;
    for (i = 1; i < N; i++) {
      if (scoreArr[i - 1].score == scoreArr[i].score) {
        answer[scoreArr[i].index] = rank;
        same++;
      } else {
        rank += same;
        answer[scoreArr[i].index] = rank;
        same = 1;
      }
    }
    return answer;
  }
}

/**
 * @desc 선수들의 평소 실력을 현재 달리고 있는 순서대로 입력 받아 각 선수의 최선의 등수를 계산하는 프로그램
 * @desc 선수의 평소실력이 같다면 앞에 달리는 선수를 앞지를 수 없다.
 * @param N, N명의 평소 실력
 * @return 최선의 등수
 */
class Question26 {
  public int[] solution(int N, int[] players) {
    int[] answer = new int[N];
    for (int i = 0; i < N; i++) {
      answer[i] = i + 1;
    }
    for (int i = 1; i < N; i++) {
      for (int j = 0; j < i; j++) {
        if (players[i] > players[j]) {
          answer[i]--;
        }
      }
    }
    return answer;
  }
}

/**
 * @desc 팩토리얼의 결과를 소인수분해하는 프로그램
 * @param N
 * @return N!을 소인수분해한 결과
 */
class Question27 {
  final int MAX = 1001;
  boolean[] prime = new boolean[MAX];
  int[] primeCount;

  public String solution(int N) {
    primeCount = new int[N + 1];
    Prime();
    String answer = String.valueOf(N) + "! = ";
    for (int i = N; i >= 2; i--) {
      if (isPrime(i)) { // 소수라면
        primeCount[i]++;
      } else {
        soinsu(i);
      }
    }
    for (int i = 2; i <= N; i++) {
      if (isPrime(i))
        answer += String.valueOf(primeCount[i]) + " ";
    }
    return answer;
  }

  void Prime() {
    for (int i = 2; i < Math.sqrt(MAX); i++) {
      if (!prime[i]) {
        for (int j = i + i; j < MAX; j += i) {
          prime[j] = true;
        }
      }
    }
  }

  void soinsu(int num) {
    int i = 2;
    while (num != 1) {
      if (!isPrime(i)) { // 소수가 아니라면 i++
        i++;
        continue;
      }
      // 나누어 떨어진다면
      if (num % i == 0) {
        primeCount[i]++;
        num /= i;
      } else {
        i++;
      }
    }
  }

  boolean isPrime(int x) {
    return prime[x] ? false : true;
  }
}

/**
 * @desc N! 값에서 일의자리부터 연속적으로 '0'이 몇 개 있는지 구하는 프로그램
 * @param 정수 N
 * @return 최대 연속된 '0'의 개수
 */
class Question28 {
  final int MAX = 1001;
  boolean[] prime = new boolean[MAX];
  int[] primeCount;

  public int solution(int N) {
    primeCount = new int[N + 1];
    Prime();
    int answer;
    for (int i = N; i >= 2; i--) {
      if (isPrime(i)) { // 소수라면
        primeCount[i]++;
      } else {
        soinsu(i);
      }
    }
    answer = primeCount[2] > primeCount[5] ? primeCount[5] : primeCount[2];
    return answer;
  }

  void Prime() {
    for (int i = 2; i < Math.sqrt(MAX); i++) {
      if (!prime[i]) {
        for (int j = i + i; j < MAX; j += i) {
          prime[j] = true;
        }
      }
    }
  }

  void soinsu(int num) {
    int i = 2;
    while (num != 1) {
      if (!isPrime(i)) { // 소수가 아니라면 i++
        i++;
        continue;
      }
      // 나누어 떨어진다면
      if (num % i == 0) {
        primeCount[i]++;
        num /= i;
      } else {
        i++;
      }
    }
  }

  boolean isPrime(int x) {
    return prime[x] ? false : true;
  }
}

/**
 * @desc 1부터 N까지 자연수를 적을 때 3의 개수가 몇 개 있는지 구하는 프로그램(small)
 * @param 정수 N
 * @return 3의 개수
 */
class Question29 {
  public int solution(int N) {
    String str = "";
    for (int i = 1; i <= N; i++) {
      str += String.valueOf(i);
    }
    int length = str.length();
    str = str.replaceAll("3", "");
    return length - str.length();
  }
}

/**
 * @desc 1부터 N까지 자연수를 적을 때 3의 개수가 몇 개 있는지 구하는 프로그램(large)
 * @param 정수 N
 * @return 3의 개수
 */
class Question30 {
  public int solution(int N) {
    int left = 77, right, cur, k = 1, res = 0;
    while (left != 0) {
      left = N / (k * 10);
      right = N % k;
      cur = (N / k) % 10;
      if (3 < cur) {
        res = res + ((left + 1) * k);
      } else if (3 == cur) {
        res = res + ((left * k) + (right + 1));
      } else
        res = res + (left * k);
      k = k * 10;
    }
    return res;
  }
}

/**
 * @desc 탄화수소의 질량을 구하는 프로그램
 * @desc 식의 형태는 CaHb a나 b가 1이면 숫자가 식에 입력되지 않는다.
 * @param 문자열 (탄화수소)
 * @return 탄화수소 질량
 */
class Question31 {
  final int C = 12;
  final int H = 1;

  public int solution(String str) {
    int answer = 0;
    String[] strArr = str.replace("C", "0").replaceAll("H", ",").split(",");
    answer += C * Integer.parseInt(strArr[0]) + H * Integer.parseInt(strArr[1]);
    if (Integer.parseInt(strArr[0]) == 0) {
      answer += C;
    }
    if (Integer.parseInt(strArr[1]) == 0) {
      answer += H;
    }
    return answer;
  }
}

/**
 * @desc 연속된 자연수의 합이 N이 되는 수식을 구하는 프로그램
 * @param 정수 N(7<=N<=1000)
 * @return N이 되는 수식
 */
class NumberThatBecomesN {
  public void solution(int N) {
    int become = N % 2 == 0 ? N : N + 1;
    int hap = 0;
    String str = "";
    for (int i = become / 2; i >= 0; i--) {
      for (int j = i; j >= 0; j--) {
        str += String.valueOf(j) + " + ";
        hap += j;
        if (hap == N) {
          str = str.substring(0, str.length() - 2);
          str += "= " + String.valueOf(N);
          System.out.println(str);
          break;
        }
      }
      hap = 0;
      str = "";
    }
  }
}

/**
 * @desc 1번부터 K번째 되는 대상은 제외된다. 마지막 남은 한 사람의 번호를 구하는 프로그램
 * @param 정수 N, K
 * @return 마지막으로 남은 사람의 번호
 */
class Question45 {
  public int solution(int N, int K) {
    int answer = 0;
    LinkedList<Integer> linkedList = new LinkedList<>();
    for (int i = 1; i <= N; i++) {
      linkedList.add(i);
    }
    int index = 0;
    int cnt = 0;
    while (linkedList.size() != 1) {
      if (cnt == K - 1) {
        linkedList.remove(index);
        cnt = 0;
      } else {
        cnt++;
        index++;
      }
      if (index >= linkedList.size()) {
        index = 0;
      }
    }
    return linkedList.get(0);
  }
}

/**
 * @desc 상하좌우 모두 자신보다 낮은 높이를 가지면 봉우리가 된다. 봉우리의 개수를 구하는 프로그램
 * @param 정수 N, 길이가 N인 2차원 배열
 * @return 봉우리의 개수
 */
class Question47 {
  int[] dx = { 0, 0, -1, 1 };
  int[] dy = { 1, -1, 0, 0 };

  public int solution(int N) throws IOException {
    int answer = 0;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[][] arr = new int[N + 2][N + 2];
    for (int i = 0; i <= N; i++) {
      arr[i][0] = 0;
      arr[0][i] = 0;
      arr[N + 1][i] = 0;
      arr[i][N + 1] = 0;
    }
    for (int i = 1; i <= N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= N; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        if (IsPeaks(arr, i, j)) {
          answer++;
        }
      }
    }
    return answer;
  }

  boolean IsPeaks(int[][] arr, int x, int y) {
    boolean answer = true;
    int peak = arr[x][y];
    for (int i = 0; i < 4; i++) {
      int nextX = x + dx[i];
      int nextY = y + dy[i];
      if (peak <= arr[nextX][nextY]) {
        answer = false;
        break;
      }
    }
    return answer;
  }
}

/**
 * @desc 평균과 가까운 수 출력하는 프로그램
 * @param 길이가 9인 2차원 배열
 * @return 평균값과 가까운 수 출력
 */
class Question48 {
  public int solution() throws IOException {
    final int N = 9;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[][] arr = new int[N][N];
    long[] average = new long[N];
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      double sum = 0.0;
      for (int j = 0; j < N; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
        sum += arr[i][j];
      }
      Arrays.sort(arr[i]);
      average[i] = Math.round((double) sum / N);
    }
    for (int i = 0; i < N; i++) {
      long difference = Math.abs(average[i] - arr[i][0]);
      int index = 0;
      for (int j = 1; j < N; j++) {
        if (difference >= Math.abs(average[i] - arr[i][j])) {
          difference = Math.abs(average[i] - arr[i][j]);
          index = j;
        }
      }
      System.out.println(average[i] + " " + arr[i][index]);
    }
    return 0;
  }
}

/**
 * @desc 정면에서 본 블록의 모습과 오른쪽 측면에서 본 블록을 통해 블록의 최대 개수를 구하는 프로그램
 * @param 정수 N, 정면에서 본 블록의 개수, 오른쪽 측면에서 본 블록의 개수
 * @return 블록의 최대값
 */
class Question49 {
  public int solution(int N) throws IOException {
    final int FRONT = 2;
    int answer = 0;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[][] arr = new int[FRONT][N];
    for (int i = 0; i < FRONT; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    for (int i = 0; i < N; i++) {
      int height = arr[0][i];
      for (int j = 0; j < N; j++) {
        if (height > arr[1][j]) {
          answer += arr[1][j];
        } else {
          answer += height;
        }
      }
    }
    return answer;
  }
}

/**
 * @desc 가장 많은 오렌지가 열리는 영지를 구하는 프로그램
 * @param 정수 N, 오렌지 나무 영지, 가질 수 있는 영지의 가로 세로 값
 * @return 가장 많이 열리는 오렌지의 개수
 */
class Question50 {
  public int solution(int N, int M, int H, int W) throws IOException {
    int answer = Integer.MIN_VALUE;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[][] arr = new int[N][M];
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    for (int i = 0; i < N - H; i++) {
      for (int j = 0; j < M - W; j++) {
        int sum = SumOfTerriTory(arr, i, j, i + H, j + W);
        if (answer < sum) {
          answer = sum;
        }
      }
    }
    return answer;
  }

  int SumOfTerriTory(int arr[][], int startI, int startJ, int H, int W) {
    int sum = 0;
    for (int i = startI; i < H; i++) {
      for (int j = startJ; j < W; j++) {
        sum += arr[i][j];
      }
    }
    return sum;
  }
}

/**
 * @desc 소인수 2, 3, 5로만 이루어진 수를 Ugly Number라고 한다. N번째 Ugly Number를 구하는 프로그램
 * @param 정수 N
 * @return N번째 Ugly Number
 */
class Question53 {
  public int solution(int N) {
    final int MAX = 1500;
    final int TWO = 2;
    final int THREE = 3;
    final int FIVE = 5;
    int[] arr = new int[MAX + 1];
    int p1, p2, p3;
    arr[1] = p1 = p2 = p3 = 1;
    for (int i = TWO; i <= N; i++) {
      int p1UglyNumber = arr[p1] * TWO;
      int p2UglyNumber = arr[p2] * THREE;
      int p3UglyNumber = arr[p3] * FIVE;
      int minUglyNumber = Math.min(Math.min(p1UglyNumber, p2UglyNumber), p3UglyNumber);
      if (minUglyNumber == p1UglyNumber) {
        p1++;
        arr[i] = p1UglyNumber;
      }
      if (minUglyNumber == p2UglyNumber) {
        p2++;
        arr[i] = p2UglyNumber;
      }
      if (minUglyNumber == p3UglyNumber) {
        p3++;
        arr[i] = p3UglyNumber;
      }
    }
    return arr[N];
  }
}

/**
 * @desc 진법으로 바뀐 값을 구하는 프로그램
 * @param 정수 N, 진법 Base
 * @return Base진법 N의 값
 */
class Question54 {
  public String solution(int N, int Base) {
    String answer = "";
    Stack<String> st = new Stack<>();
    while (N != 0) {
      String element = String.valueOf(N % Base);
      if (Base == 16) {
        switch (element) {
          case "10":
            element = "A";
            break;
          case "11":
            element = "B";
            break;
          case "12":
            element = "C";
            break;
          case "13":
            element = "D";
            break;
          case "14":
            element = "E";
            break;
          case "15":
            element = "F";
            break;
          default:
            break;
        }
      }
      st.push(element);
      N /= Base;
    }
    while (!st.isEmpty()) {
      answer += st.pop();
    }
    return answer;
  }
}

/**
 * @desc 재귀함수 구현하는 프로그램
 * @param 정수 N
 * @return 1~N까지 출력
 */
class Question56 {
  public void solution(int N) {
    Recursion(N, 1);
  }

  void Recursion(int n, int i) {
    System.out.print(i + " ");
    if (i == n)
      return;
    Recursion(n, i + 1);
  }
}

/**
 * @desc 재귀함수로 이진수 구현하는 프로그램
 * @param 정수 N
 * @return 10진수 N을 2진수로 출력
 */
class Question57 {
  StringBuilder sb = new StringBuilder();

  public String solution(int N) {
    Recursion(N);
    return sb.reverse().toString();
  }

  void Recursion(int n) {
    if (n == 0)
      return;
    sb.append(n % 2);
    Recursion(n / 2);
  }
}

/**
 * @desc 인접행렬을 구하는 프로그램
 * @param 정수 N, 거리 비용
 * @return 인접행렬
 */
class Question63 {
  public void solution(int N, int M) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer stringTokenizer;
    int[][] matrix = new int[N + 1][N + 1];
    for (int i = 1; i <= M; i++) {
      stringTokenizer = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(stringTokenizer.nextToken());
      int b = Integer.parseInt(stringTokenizer.nextToken());
      int distance = Integer.parseInt(stringTokenizer.nextToken());
      matrix[a][b] = distance;
    }
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++)
        System.out.print(matrix[i][j] + " ");
      System.out.println();

    }
  }
}