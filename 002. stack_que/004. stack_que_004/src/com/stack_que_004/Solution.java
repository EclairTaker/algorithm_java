package com.stack_que_004;

import java.util.*;

public class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack();

        // 총 가격을 순회하면서 하락 할 경우 pop 오를 경우 push를 하며 결과적으로 그 증감 여부를 check하는 구조
        for (int i = 0; i < prices.length; i++) {
            // Stack이 전부 빌 때 까지 진행하며 prices를 다 돌았을 경우에도 종료한다.
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                // 최종적으로 Stack에 쌓아올린 i 값에서 초기 값 stack.peek()를 뺌을 통해 몇초동안 유지되었는가 판별
                answer[stack.peek()] = i - stack.peek();
                // 답이 출력되었다면 pop을 통해 stack에서 제거
                stack.pop();
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) { // 값을 구하지 못한 index == 끝까지 가격이 떨어지지 않은 주식
            answer[stack.peek()] = prices.length - stack.peek() - 1;
            stack.pop();
        }

        return answer;
    }

}

// 참조 : https://girawhale.tistory.com/7