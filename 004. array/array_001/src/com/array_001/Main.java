package com.array_001;

public class Main {
    public static void main(String[] args)  {
        Solution sol = new Solution();
        // 1차원 배열 선언과 동시에 초기화
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        // 2차원 배열 선언과 동시에 초기화
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int answer[] = {};

        answer = sol.solution(array, commands);
        System.out.println(answer);
    }
}
