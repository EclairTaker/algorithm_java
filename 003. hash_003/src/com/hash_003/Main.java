package com.hash_003;

public class Main {
    public static void main(String[] args)  {
        Solution sol = new Solution();
        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        int answer = sol.solution(clothes);
        System.out.println(answer);
    }
}
