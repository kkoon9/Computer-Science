/**
 * 문제 이름 : 입국심사
 * 작성자 : kkoon9
 * 날짜 : 2020.01.22
 * 링크 : https://programmers.co.kr/learn/courses/30/lessons/43238
 * n : 입국심사를 기다리는 사람 수 (매개변수)
 * times : 각 심사관이 한 명을 심사하는데 걸리는 시간이 담긴 배열 (매개변수)
 * 모든 사람이 심사를 받는데 걸리는 시간의 최솟값을 return한다.
 * 입국심사를 기다리는 사람은 1 ~ 1억명이하이다.
 * 각 심사관이 한 명을 심사하는데 걸리는 시간은 1분 ~ 1억분이하이다.
 * 심사관은 1명 이상 100,000 이하이다.
 * ********    해결 방법      **************
 * 이분탐색 알고리즘을 사용하였다.
 * low와 high, mid를 가진다.
 * (1). low의 초기값 : times[0]
 * (2). high의 초기값 : times[size-1] * n
 * (3). mid : (low + high) / 2
 * (4). low가 high보다 커질때까지 반복해준다.
 * times를 모두 순회하면서 sum을 구해준다.
 * (5). sum += mid / times[i]
 * (6). sum이 n보다 크다면 high가 mid
 * (7). sum이 n보다 작다면 low가 mid
 * */

import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long low, high, mid, sum;
        int t_size = times.length;
        Arrays.sort(times);

        low = times[0];
        high = times[t_size - 1] * (long) n;

        while (low + 1 < high) {
            mid = (low + high) / 2;
            sum = 0;
            for (int i = 0; i < t_size; i++)
                sum += mid / (long) times[i];
            if (sum >= n)
                high = mid;
            else
                low = mid;
        }
        answer = high;
        return answer;
    }
}