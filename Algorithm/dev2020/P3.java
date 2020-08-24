import java.util.*;
import java.io.*;

class Solution {
    class Number implements Comparable<Number> {
        int index;
        int number;
        int needSwap = 0;
        Number(int index, int number) {
            this.index = index;
            this.number = number;
        }
        Number(int index, int number, int needSwap){
            this.index = index;
            this.number = number;
            this.needSwap = needSwap;
        }

        @Override
        public int compareTo(Number o) {
            int r = o.needSwap - this.needSwap;
            if(r==0){
                r = o.number - this.number;
            }
            return r;
        }
    }

    public int solution(int[] numbers, int K) {
        int answer = 0; // Swap 연산 횟수
        int numbersSize = numbers.length; // numbers 배열의 길이
        Number[] copyNumbers = new Number[numbersSize]; // numbers의 원소와 index를 가지는 Number 배열
        for (int i = 0; i < numbersSize; i++) {
            copyNumbers[i] = new Number(i, numbers[i]);
        }
        Arrays.sort(copyNumbers); // number를 내림차순으로 정렬해준다.
        int i = 0;
        while (true) {
            int swapidx=0;
            boolean flag = isAnswer(numbers, K); // isAnswer : 모든 원소가 주위 원소들과 K 이하 차이나는지
            if (flag) break;
            if(i>=numbersSize)break; // i가 numbersSize보다 커지면 break
            int index = copyNumbers[i].index; // 가장 큰 수부터 차례대로 처리해준다.
            int val = numbers[index];
            int[] LR = leftRight(new Number(index, val), numbers);
            int needSwap = needSwapCount(new Number(index, val), numbers, K);
            if (needSwap == 0) { // 양쪽모두 바꿀 필요가 없다면 그대로 진행해준다.
                i++;
                continue;
            }
            ArrayList<Number> arrayList = new ArrayList<Number>(); // val 주위에 올 수 있는 수들을 구한다.
            for (int j = i + 1; j < numbersSize; j++) {
                if (val - K <= copyNumbers[j].number) {
                    int ns = needSwapCount(copyNumbers[j], numbers,K); // needSwap을 추가시켜줌으로써 needSwap이 제일 큰 값이 Swap 연산의 우선 대상이 된다.
                    arrayList.add(new Number(copyNumbers[j].index,copyNumbers[j].number, ns));
                } else {
                    break;
                }
            }
            int arrayListSize = arrayList.size();
            if (arrayListSize < needSwap) { // needSwap보다 arrayList의 원소개수. 즉, 주위에 올 수가 적다면 만들 수 없으므로 -1을 리턴한다.
                answer = -1;
                break;
            }
            Number [] canSwap = new Number[arrayListSize];
            for(int idx = 0; idx < arrayListSize;idx++){
                canSwap[idx] = arrayList.get(idx);
            }
            Arrays.sort(canSwap);
            if (arrayListSize == 1) {
                if (index != 0 && index != numbersSize) {
                    // 양쪽에 수의 needSwap을 고려하여 계산
                    if (needSwapCount(new Number(0,numbers[0]),numbers,K) < needSwapCount(new Number(numbersSize-1,numbers[numbersSize-1]),numbers,K)) {
                        int num = numbers[numbersSize - 1];
                        numbers[numbersSize - 1] = val;
                        numbers[index] = num;
                        for (int j = 0; j < numbersSize; j++) {
                            if (copyNumbers[j].number == num) {
                                copyNumbers[j].index = index;
                                break;
                            }
                            if (copyNumbers[j].number == val) {
                                copyNumbers[j].index = numbersSize - 1;
                                break;
                            }
                        }
                    } else {
                        int num = numbers[0];
                        numbers[0] = val;
                        numbers[index] = num;
                        for (int j = 0; j < numbersSize; j++) {
                            if (copyNumbers[j].number == num) {
                                copyNumbers[j].index = index;
                                break;
                            }
                            if (copyNumbers[j].number == val) {
                                copyNumbers[j].index = 0;
                                break;
                            }
                        }
                    }
                    answer++;
                }
            }
            else if (LR[0] != 0 && LR[0] + K < val) {
                Number swapNum = canSwap[swapidx++];
                numbers[index - 1] = swapNum.number;
                numbers[swapNum.index] = LR[0];
                for (int j = 0; j < numbersSize; j++) {
                    if (copyNumbers[j].number == swapNum.number) {
                        copyNumbers[j].index = index - 1;
                        break;
                    }
                    if (copyNumbers[j].number == LR[0]) {
                        copyNumbers[j].index = swapNum.index;
                        break;
                    }
                }
                answer++;
            } else if (LR[1] != 0 && LR[1] + K < val) {
                Number swapNum = canSwap[swapidx++];
                numbers[index + 1] = swapNum.number;
                numbers[swapNum.index] = LR[1];
                for (int j = 0; j < numbersSize; j++) {
                    if (copyNumbers[j].number == swapNum.number) {
                        copyNumbers[j].index = index + 1;
                        break;
                    }
                    if (copyNumbers[j].number == LR[1]) {
                        copyNumbers[j].index = swapNum.index;
                        break;
                    }
                }
                answer++;
            }
            i++;
        }
        return answer;
    }

    private boolean isAnswer(int[] numbers, int K) {
        int size = numbers.length;
        boolean answer = true;
        for (int i = 0; i < size - 1; i++) {
            if (Math.abs(numbers[i] - numbers[i + 1]) <= K) continue;
            answer = false;
            break;
        }
        return answer;
    }

    private void printNumber(Number[] trueNum) {
        int arrSize = trueNum.length;
        for (int i = 0; i < arrSize; i++) {
            System.out.print(trueNum[i].number + "(" + trueNum[i].index + "," +trueNum[i].needSwap + ") ");
        }
        System.out.println();
    }

    private int needSwapCount(Number num, int[] numbers, int k) {
        int needSwap = 0;
        int val;
        if (num.index == 0) {
            val = numbers[1];
            if (Math.abs(val - num.number) > k)
                needSwap++;
        } else if (num.index == numbers.length - 1) {
            val = numbers[numbers.length - 2];
            if (Math.abs(val - num.number) > k)
                needSwap++;
        } else {
            int [] LF = leftRight(num,numbers);
            if (Math.abs(LF[0] - num.number) > k)
                needSwap++;
            if(Math.abs(LF[1] - num.number) > k)
                needSwap++;
        }
        return needSwap;
    }

    private int[] leftRight(Number num, int[] numbers) {
        int[] answer = new int[2];
        if (num.index == 0) {
            answer[1] = numbers[1];
        } else if (num.index == numbers.length - 1) {
            answer[0] = numbers[numbers.length - 1];
        } else {
            answer[0] = numbers[num.index - 1];
            answer[1] = numbers[num.index + 1];
        }
        return answer;
    }
}


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Solution s = new Solution();
        int[] numbers = {3,7,2,8,6,4,5,1};
        int k = 3;
        String[] move = {"go", "go", "right", "go", "right", "go", "left", "go"};
        System.out.println(s.solution(numbers, k));
    }

}