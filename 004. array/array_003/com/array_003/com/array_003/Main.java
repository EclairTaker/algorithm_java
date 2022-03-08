package com.array_003;

public class Main {
    public static void main(String[] args)  {
        Solution sol = new Solution();
        // 1차원 배열 선언과 동시에 초기화
        int[] citations = {3, 0, 6, 1, 5};
        int answer;

        answer = sol.solution(citations);
        System.out.println(answer);
    }
}
