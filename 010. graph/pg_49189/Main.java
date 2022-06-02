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
        for (int i = 1; i <= n; i++)    {
            Collections.sort(alGraph.get(i));
        }

        System.out.println(alGraph);
        // 방문기록을 True, False로 기록
        boolean[] bVisited = new boolean[n + 1];
        // 1번 노드에서 가장 먼 거리를 체크해야하기 때문에 무조건 통과
        bVisited[1] = true;
        Queue<Integer> BFS = new LinkedList<>();
        BFS.offer(1);
        bVisited[1]=true;
        int iGraph_size, iNode;

        // 1을 통과한 후 2~n까지의 경로 도출
        // BFS의 내용물이 바닥나기 전까지 반복 수행
        while (!BFS.isEmpty()) {
            iGraph_size = BFS.size();
            // Grpah 상에서 현재노드를 idx값으로 가지는 객체를 가져옴
            // 해당 객체 [][]를 return하여 alNode에 저장
            for (int i = 0; i < iGraph_size; i++)   {
                iNode = BFS.poll();
                for (int j = 0; j < alGraph.get(iNode).size(); j++)  {
                    if(bVisited[alGraph.get(iNode).get(j)] == false)    {
                        bVisited[alGraph.get(iNode).get(j)] = true;
                        BFS.offer(alGraph.get(iNode).get(j));
                    }
                }
            }
            answer = iGraph_size;
        }
        System.out.println(answer);
        return answer;
    }
}

// 참조 : https://born2bedeveloper.tistory.com/43
// 참조 : https://arinnh.tistory.com/40