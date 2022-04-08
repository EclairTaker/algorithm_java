import java.util.HashSet;

public class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        HashSet<Integer> resSet = new HashSet<>();
        HashSet<Integer> loSet = new HashSet<>();

        // 여분이 있는 인원을 기록
        for(int i: reserve) {
            resSet.add(i);
        }

        // 잃어버린 인원들을 기록
        // 잃어버린 인원과 여분이 있는 인원 간 중복이 존재할 경우 해당 번호 제거
        for(int i: lost) {
            if(resSet.contains(i)) {
                resSet.remove(i);
            }
            else {
                loSet.add(i);
            }
        }

        // 여분의 옷을 가지고 있지 않은 사람들에게 나눠주는 과정
        for(int i: resSet) {
            if(loSet.contains(i-1)) {
                loSet.remove(i - 1);
            }
            else if(loSet.contains(i+1)) {
                loSet.remove(i + 1);
            }
        }   

        answer = n - loSet.size();

        return answer;
    }
}
class Solution {
    
}

// 참조 : https://velog.io/@lifeisbeautiful/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%ED%95%B4%EC%8B%9C-%EC%9C%84%EC%9E%A5-%EC%9E%90%EB%B0%94-JAVA-wsoimxq4