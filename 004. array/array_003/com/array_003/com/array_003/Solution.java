package com.array_003;

import java.util.Arrays;

public class Solution {
    public int solution(int[] citations) {
        int answer = 0;

        // 해당 Array를 오름차순 정렬 후 조건 충족하는 가장 최소값을 구하면 된다.
        // 어차피 올라갈 수록 인용된 논문의 수는 줄어들 것이기 때문
        // 문제의 정리 >> h번 이상 인용된 논문이 h편 이상일 경우에 h 최대값을 구하라
        // 인용 수를 정렬 >> 뒤로 갈 수록 인용 횟수가 논문 편수보다 커지게 된다.
        Arrays.sort(citations);

        // citations.length = 전체 논문의 개수
        for (int i =0; i < citations.length; i++)   {
            // citations.length를 쓰는 이유 : 기준을 만족한 논문의 수는 절대 전체 논문의 양을 넘을 수 없기 때문
            // 정렬 된 citations는 인용횟수가 가장 적을 때부터 보여줌
            // i 일 때 성립할 수 있는 기준치 달성한 논문의 수 최대값
            // 기준점으로 활용할 수 있는 인용 논문 편수는 citations.length 내에서 밖에 나올 수 없음.
            int h_idx = citations.length - i;
            // 기준 달성 논문 편수 : h_idx, 인용된 논문 편수 : citations[i]
            // n편(citations[i]) 이상 인용된 논문의 갯수가 n편(h_idx)이상일 경우 그 최소값
            if (citations[i] >= h_idx)  {
                answer = h_idx;
                break;
            }
        }
        return answer;
    }
}