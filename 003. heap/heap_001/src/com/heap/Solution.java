package com.heap;

import java.util.PriorityQueue;

public class Solution {
    public int solution(int[] scoville, int K)  {
        int answer = 0;
        int min_001;
        int min_002;
        // 우선순위의 정보가 유지되는 Priority Queue 선언
        // "PriorityQueue<자료형> 변수명"으로 선언
        PriorityQueue<Integer> food_list = new PriorityQueue<>();

        // scoville의 음식들을 대상으로 반복문 수행
        for (Integer food : scoville)   {
            // PriorityQueue에 add수행 시 자동으로 이진트리 기반 add 수행
            food_list.add(food);
        }

        // "food_list.peek() < K" == 더 이상 K보다 낮은 지수가 없어서 섞기를 중단하기 전까지는...
        while(food_list.peek() < K) {
            // 음식이 1개밖에 없어서 애초에 섞기 불가능 & 즉, 이 음식이 마지막
            if (food_list.size() < 2) {
                return -1;
            }
            // poll을 연속 2번 수행하여 가장 낮은 & 그 다음으로 낮은 지수의 음식들 선별
            min_001 = food_list.poll();
            min_002 = food_list.poll();
            // PriorityQueue에 직접 해당 결과값 add, 우선순위에 따라 정렬 수행 됨.
            food_list.add(min_001 + min_002 * 2);
            // 섞기가 정상적으로 수행되었기에 answer 증가
            answer += 1;
        }

        return answer;
    }
}