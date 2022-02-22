package com.stack_que_001;

public class Main {
    public static void main(String[] args) {
        // Solution 메서드 호출을 위한 선언
        Solution sol = new Solution();
        // java 배열 서언 및 내용 초기화
        // 값 없이 선언할 경우 int[] array_name = new int[*배열길이];로 진행
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        int[] answer;

        answer = sol.solution(progresses, speeds);
        System.out.println(answer);
    }
}
