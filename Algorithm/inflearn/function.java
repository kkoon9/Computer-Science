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