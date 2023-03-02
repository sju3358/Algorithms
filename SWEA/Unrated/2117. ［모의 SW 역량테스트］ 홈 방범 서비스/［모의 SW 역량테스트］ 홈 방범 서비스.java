import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N,M;

    static int[][] map;

    static int answer = -1;

    static int[][] dir = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
    static class Node{
        int i;
        int j;
        int length;
        public Node(int i, int j, int length){
            this.i = i;
            this.j = j;
            this.length = length;
        }
    }

    static int[] operationCost = new int[22];
    public static  boolean isInBoundary(int i, int j){
        return 0 <= i && i < N && 0 <= j && j < N;
    }

    public static void getAnswer(int startI, int startJ, int pivotLength){

        boolean[][] visited = new boolean[N][N];

        Queue<Node> nextNode = new LinkedList<>();
        nextNode.add(new Node(startI,startJ,1));
        visited[startI][startJ] = true;

        int cntOfHome = map[startI][startJ];

        while(nextNode.isEmpty() != true){

            Node curNode = nextNode.poll();

            for(int i = 0; i < 4; i++){
                int nextI = curNode.i + dir[i][0];
                int nextJ = curNode.j + dir[i][1];

                if(isInBoundary(nextI, nextJ) == false)
                    continue;
                if(visited[nextI][nextJ] == true)
                    continue;
                if(curNode.length + 1 > pivotLength)
                    continue;

                cntOfHome += map[nextI][nextJ];
                visited[nextI][nextJ] = true;
                nextNode.add(new Node(nextI,nextJ,curNode.length + 1));
            }
        }

        if(M*cntOfHome >= operationCost[pivotLength]){
            if(answer < cntOfHome)
                answer = cntOfHome;
        }
    }

    public static void main(String args[]) throws IOException {
        int T = Integer.parseInt(br.readLine());

        operationCost[0] = 1;
        int cnt = 0;
        for(int i = 1; i < operationCost.length; i++) {
            operationCost[i] = operationCost[i-1] + cnt;
            cnt = cnt + 4;
        }

        for(int t = 1; t <= T; t++){

            answer = -1;

            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new int[N][N];

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine()," ");
                for(int j = 0; j < N; j++)
                    map[i][j] = Integer.parseInt(st.nextToken());
            }

            for(int startI = 0; startI < N; startI++){
                for(int startJ = 0; startJ < N; startJ++)
                    for(int pivotLength = 1; pivotLength <= N+1; pivotLength++)
                        getAnswer(startI,startJ,pivotLength);
            }

            System.out.println("#" + t + " " + answer);
        }
    }
}
