import java.util.*;

public class Main {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        // 그래프 구현을 위해 ArrayList를 활용
        ArrayList<ArrayList<Integer>> alGraph = new ArrayList<>();
        // 가장 먼 거리의 노드를 확인하기 위해 거리를 저장해야함
        int[] iDistance = new int[n + 1];

        for (int i = 0; i < n+1; i++)   {
            alGraph.add(new ArrayList<>());
        }
        for (int i = 0; i < edge.length; i++)   {
            // graph가 양방향
            // 특정 경로 발견 시 해당 경로를 양방향으로 graph에 업데이트
            alGraph.get(edge[i][0]).add(edge[i][1]);
            alGraph.get(edge[i][1]).add(edge[i][1]);
        }
        // 방문기록을 True, False로 기록
        boolean[] bVisited = new boolean[n + 1];
        // 1번 노드에서 가장 먼 거리를 체크해야하기 때문에 무조건 통과
        bVisited[1] = true;
        Queue<Integer> BFS = new LinkedList<>();
        BFS.add(1);

        // 1을 통과한 후 2~n까지의 경로 도출
        while (BFS.size() != 0) {
            // BFS 맨 위의 요소 추출
            int llCurNode = BFS.poll();
            ArrayList<Integer> alNode = alGraph.get(llCurNode);
            for (int i = 0; i < alNode.size(); i++) {
                if (bVisited[alNode.get(i)] == false)   {

                }
            }
        }

        return answer;
    }
}