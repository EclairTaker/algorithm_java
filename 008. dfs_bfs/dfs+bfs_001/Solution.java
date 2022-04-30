import java.io.*;
import java.util.*;

public class Main {
    static int[][] iGraphConnect; //간선 연결상태
    static boolean[] IsCheck; //확인 여부
    static int iNode; //정점개수
    static int iConnection; //간선개수
    static int iStartNode; //시작정점
  
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        iNode = sc.nextInt();
        iConnection = sc.nextInt();
        iStartNode = sc.nextInt();
  
        //연산 직관성을 위해 idx number 그대로 활용. 1001까지 선언
        iGraphConnect = new int[1001][1001];
        //초기값 False
        IsCheck = new boolean[1001];
  
        //간선 연결상태 저장, First -> Second
        for(int i = 0; i < iConnection; i++) {
            int iNodeFirst = sc.nextInt();
            int iNodeSecond = sc.nextInt();
    
            iGraphConnect[iNodeFirst][iNodeSecond] = iGraphConnect[iNodeSecond][iNodeFirst] = 1;
        }
  
        // DFS 메서드 활용
        dfs(iStartNode);
  
        // DFS 확인 후 확인 내용 초기화
        IsCheck = new boolean[1001];
        System.out.println();
  
        // BFS 메서드 활용
        bfs();
    }
  
    // 시작노드를 변수로 받아 확인
    // 출력 후 다음 노드를 검색 -> 시작 노드를 변경하여 재호출

    // DFS 구현
    public static void dfs(int i) {
        IsCheck[i] = true;
        System.out.print(i + " ");
    
        for(int j = 1; j <= iNode; j++) {
            if(iGraphConnect[i][j] == 1 && IsCheck[j] == false) {
            dfs(j);
            }
        }
    }
  
    // BFS 구현
    public static void bfs() {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(iStartNode); //시작점도 Queue에 넣어야 함
        IsCheck[iStartNode] = true;
        System.out.print(iStartNode + " ");
    
        //Queue가 빌 때까지 반복. 방문 정점은 확인, 출력 후 Queue에 넣어 순서대로 확인
        while(!queue.isEmpty()) {
            int temp = queue.poll();
      
            for(int j = 1; j <= iNode; j++) {
                if(iGraphConnect[temp][j] == 1 && IsCheck[j] == false) {
                    queue.offer(j);
                    IsCheck[j] = true;
                    System.out.print(j + " ");
                }
            }
        }
    }
}

// 참고 : https://blog.naver.com/lm040466/221787478911