package com.stack_que_002;

public class Main {
    public static void main(String[] args)   {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        int answer;

        Solution sol = new Solution();
        answer = sol.solution(priorities, location);
        System.out.println(answer);
    }
}
