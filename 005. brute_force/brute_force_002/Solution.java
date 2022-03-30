import java.util.*;

class Solution {
    private static int cnt = 0;
    private static String[] map;
    private static String[] result;
    private static boolean[] visit;
    private static HashSet<Integer> list;

    public int solution(String numbers) {
        int answer = 0;

        // 숫자갯수만큼 boolean 배열 선언
        visit = new boolean[numbers.length()];
        // map은 numbers 숫자갯수만큼 구성할 수 있는 글자 배열
        map = new String[numbers.length()];
        // numbers를 글자단위로 string.split 수행
        // map 배열에 한 글자씩 넣는다
        map = numbers.split("");
        list = new HashSet();

        // 문자들을 하나하나 순회해가며 재귀 시작
        for (int i=1; i<=numbers.length(); i++) {
            result = new String[i];
            cycle(0, i, numbers.length());
        }

        return list.size();
    }

    // 재귀함수
    public void cycle(int start, int end, int length) {
        // 재귀를 끝까지 수행하며 가능한 수열 조합을 다 생성한지 체크
        // 이후 소수 검색으로 전환
        if (start == end) {
            findPrime();
        }
        // 아직 가능한 수열 조합이 존재한다면 (start != end)
        else {
            for (int i=0; i<length; i++) {
                if (!visit[i]) {
                    // 방문 기록을 남김 (숫자의 자리수 별 조합을 위함)
                    visit[i] = true;
                    result[start] = map[i];
                    cycle(start+1, end, length);
                    visit[i] = false;
                }
            }

        }

    }

    public void findPrime() {
        // 숫자로 변환
        String str = "";
        for(int i=0; i<result.length; i++)
            str += result[i];
        int num = Integer.parseInt(str);
        
        // 예외 처리
        if(num == 1 || num == 0)
            return;

        // 소수 인지 검사
        boolean flag = false;
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num % i == 0)
                flag = true;
        }

        if(!flag)
            list.add(num);
    }
}

// 참조 : https://hidelookit.tistory.com/67