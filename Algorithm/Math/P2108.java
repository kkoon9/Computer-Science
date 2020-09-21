
/**
 * @접근방법 문제에 나와있는대로 산술평균, 중앙값, 최빈값 범위를 구해주면 된다.
 * @포인트 산술평균(round), 최빈값(class로 정의)
 * @포인트 산술평균을 구할 때 float이 아닌 double로 해야한다. 4000*500000이 Int 범위를 초과하므로
 */
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    P2108();
  }

  static int N, M;
  static final int SIZE = 4000;

  static void P2108() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(br.readLine());
    int[] numbers = new int[N];
    double sum = 0.0f;
    int median;
    long arithmeticMean;
    int range;
    int frequency;
    Frequency[] frequencys = new Frequency[SIZE * 2 + 2];
    for (int i = 0; i < SIZE * 2 + 2; i++) {
      int number = i;
      if (number > SIZE) {
        number -= SIZE;
        number = -number;
      }
      frequencys[i] = new Frequency(number, 0);
    }
    for (int i = 0; i < N; i++) {
      numbers[i] = Integer.parseInt(br.readLine());
      sum += (float) numbers[i];
      if (numbers[i] < 0)
        frequencys[Math.abs(numbers[i]) + SIZE].frequency++;
      else
        frequencys[numbers[i]].frequency++;
    }
    Arrays.sort(numbers);
    Arrays.sort(frequencys);
    frequency = frequencys[0].number;
    if (N > 1 && frequencys[0].frequency == frequencys[1].frequency) {
      frequency = frequencys[1].number;
    }
    arithmeticMean = Math.round(sum / (float) N);
    median = numbers[N / 2];
    range = numbers[N - 1] - numbers[0];

    System.out.println(arithmeticMean);
    System.out.println(median);
    System.out.println(frequency);
    System.out.println(range);
  }

  private static class Frequency implements Comparable<Frequency> {
    int number;
    int frequency;

    Frequency(int number, int frequency) {
      this.number = number;
      this.frequency = frequency;
    }

    @Override
    public int compareTo(Frequency o) {
      int result = o.frequency - this.frequency;
      if (result == 0) {
        result = this.number - o.number;
      }
      return result;
    }
  }
}