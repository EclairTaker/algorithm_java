package com.array_003;

import java.util.Arrays;

public class Solution {
    public int solution(int[] citations) {
        int answer = 0;

        // 해당 Array를 오름차순 정렬 후 조건 충족하는 가장 최소값을 구하면 된다.
        // 어차피 올라갈 수록 인용된 논문의 수는 줄어들 것이기 때문
        Arrays.sort(citations);

        // citations.length = 전체 논문의 양
        for (int i =0; i < citations.length; i++)   {
            // citations.length를 쓰는 이유 : 기준을 만족한 논문의 수는 절대 전체 논문의 양을 넘을 수 없기 때문
            // h_idx : 기준 통과 논문의 갯수
            int h_idx = citations.length - i;
            // 기준 통과 논문의 수가 
            // citations[i] >> 논문 인용 횟수의 가능한 경우의 수, 이를 오름차순으로 정렬
            // why? 인용 가능한 논문 인용 횟수는 경우의 수가 커지면 커질수록 반대로 그 조건을 충족하는 논문의 수는 줄어든다.
            // h_idx >> h_idx 기준을 충족할 수 있는 논문의 경우의 수, 이를 내림차순으로 정렬
            // why? 인용 된 논문의 수가 작아질수록, 반대로 논문의 인용 횟수가 증가한다는 뜻
            // citations[i] (= 논문 인용 횟수의 case) 와 h_idx (=인용 된 논문 수)는 서로 반비례 관계가 된다.
            // 따라서 2개를 비교하다 h_index 점수 기준에 충족하는 최소값을 찾으면 바로 종료하면 끝 (그 이후는 어차피 점차 괴리가 심해져서 의미없음)
            if (citations[i] >= h_idx)  {
                answer = h_idx;
                break;
            }
        }
        return answer;
    }
}