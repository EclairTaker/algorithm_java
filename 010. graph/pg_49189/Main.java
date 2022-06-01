import java.util.*;

public class Main {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        // 그래프 구현을 위해 ArrayList를 활용
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        // 가장 먼 거리의 노드를 확인하기 위해 거리를 저장해야함
        int[] distance = new int[n + 1];

        for (int i = 0; i < n+1; i++)   {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edge.length; i++)   {
            graph.get(edge[i][0]).add(edge[i][1]);
        }

        return answer;
    }
}