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