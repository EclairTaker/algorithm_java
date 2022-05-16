class Solution {
    int answer;
    public int solution(int[] numbers, int target)  {
        answer = 0;
        dfs(0, 0, numbers, target);
        return answer;
    }    
    void dfs(int cycle_cnt, int sum, int[] numbers, int target) {
        // 순회공연을 진행한 결과 배열의 숫자를 다 돌았을 경우
        // 재귀를 탈출한다.
        if (cycle_cnt == numbers.length)    {
            // 총합의 값이 원했던 target값과 일치할 경우
            // 값 count를 증가시킨다.
            if (sum == target)
                answer++;
            return;
        }
        // dfs 증가, 증감 연산은 + or -로 이루어질 수 있다.
        // 따라서, dfs 연산을 2번 수행한다.
        dfs(cycle_cnt + 1, sum - numbers[cycle_cnt], numbers, target);
        dfs(cycle_cnt + 1, sum + numbers[cycle_cnt], numbers, target);
    }    
}

// 문제 : https://programmers.co.kr/learn/courses/30/lessons/43165?language=java
