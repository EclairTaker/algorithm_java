package com.array_002;

public class Main {
    public static void main(String[] args)  {
        Solution sol = new Solution();
        // 1차원 배열 선언과 동시에 초기화
        int[] numbers = {3, 30, 34, 5, 9};
        String answer;

        answer = sol.solution(numbers);
        System.out.println(answer);
    }
}
