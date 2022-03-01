package com.heap;

public class Main {
    public static void main(String[] args)   {
        Solution sol = new Solution();

        int[] scovile = {12, 9, 3, 10, 2, 1};
        int K = 7;
        int answer;

        answer = sol.solution(scovile, K);
        System.out.println(answer);
    }
}
