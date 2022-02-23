package com.stack_que_003;

public class Main {
    public static void main(String[] args)  {
        Solution sol = new Solution();
        int answer = 0;
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};
        answer = sol.solution(bridge_length, weight, truck_weights);
        System.out.println(answer);
    }
}
