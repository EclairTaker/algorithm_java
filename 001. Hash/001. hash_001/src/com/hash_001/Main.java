package com.hash_001;

public class Main {
    public static void main(String[] args)  {
        Solution sol = new Solution();
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        String answer = sol.solution(participant, completion);
        System.out.println(answer);
    }
}
