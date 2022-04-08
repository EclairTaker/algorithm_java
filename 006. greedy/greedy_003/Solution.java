import java.util.*;

public class Solution {
        public String solution(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();
        
        // 한 글자씩 순회공연을 진행
        for (int i=0; i<number.length(); i++) {
            char c = number.charAt(i); 
            // 가장 높은 숫자보다 크다면 Stack에서 pop 수행
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop(); 
            }
            stack.push(c);
        }
        for (int i=0; i<result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }
}

// 참조 : https://bangu4.tistory.com/221