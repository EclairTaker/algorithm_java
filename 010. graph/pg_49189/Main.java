import java.util.*;

public class Main {
    // 다익스트라 알고리즘 적용하여 새로 풀이 수행
    // 최대 경우의 수 노드 20,000 * 간선 50,000 ...?
    static final int INF = 1000000;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        // class Node 사용해서 ArrayList 선언
        // Class Node의 구조 (index, cost)
        ArrayList<Node>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edge)    {
            // Graph를 작성
            // Node간 연결선에 weight, distance는 존재하지 않기 때문에 전부 1로 통일 (거리는 동일하기 때문)
            graph[e[0] - 1].add(new Node(e[1] - 1, 1));
            graph[e[1] - 1].add(new Node(e[0] - 1, 1));
        }

        // 최대거리 확인을 위한 distance
        int[] distance = new int[n];
        Arrays.fill(distance, INF);
        // 시작지점이기 때문에 0으로 Start
        distance[0] = 0;
        PriorityQueue<Node> queue = new PriorityQueue();
        queue.add(new Node(0, 0));

        while (!queue.isEmpty())    {
            // 현재 방문 노드 정보를 확인
            Node curNode = queue.poll();

            // 해당 노드의 번호를 통해 조회하여 해당 
            for (int i = 0; i < graph[curNode.index].size(); i++)   {
                Node next = graph[curNode.index].get(i);
            }
        }

        return answer;
    }

    // 사용하기 위한 class Node 선언
    class Node implements Comparable<Node>  {
        int index;
        int cost;

        public Node(int index, int cost)    {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o)    {
            return Integer.compare(this.cost, o.cost);
        }
    }
}

// I'm fkin tire

// 참조 : https://born2bedeveloper.tistory.com/43
// 참조 : https://arinnh.tistory.com/40