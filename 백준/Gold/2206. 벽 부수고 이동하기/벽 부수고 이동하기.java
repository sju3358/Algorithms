import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br;
    private static StringTokenizer st;


    private static int N,M;
    private static int[][] map;

    static class Node{
        int i;
        int j;
        int length;
        boolean broken;

        public Node(int i, int j, int length, boolean broken){
            this.i = i;
            this.j = j;
            this.length = length;
            this.broken = broken;
        }
    }

    private static boolean isInBoundary(int i, int j){
        return 0 <= i && i < N && 0 <= j && j < M;
    }


    private static int getAnswer(){

        boolean[][][] visited = new boolean[N][M][2];
        Queue<Node> nextNode = new LinkedList<>();
        int minLength = Integer.MAX_VALUE;
        boolean isArrived = false;
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        nextNode.add(new Node(0,0,1,false));
        visited[0][0][0] = true;

        while(nextNode.isEmpty() != true){

            Node curNode = nextNode.poll();

            if(curNode.i == N-1 && curNode.j == M-1){
                isArrived = true;
                minLength = Math.min(minLength, curNode.length);
            }
            else {
                for (int i = 0; i < 4; i++) {
                    int nextI = curNode.i + dir[i][0];
                    int nextJ = curNode.j + dir[i][1];
                    int nextLength = curNode.length + 1;
                    boolean nextBroken = curNode.broken;

                    if (isInBoundary(nextI, nextJ) == false)
                        continue;
                    if(nextLength > minLength)
                        continue;;

                        /*
                            1. 벽을 깨본적이 있고, 현재위치가 벽이 아닐때.
                            2. 벽을 깨본적이 없고,
                                2-1 현재위치가 벽일때
                                2-2 현재위치가 벽이 아닐때.
                         */
                    if(nextBroken == true){

                        if(map[nextI][nextJ] == 0){

                            if(visited[nextI][nextJ][1] == true)
                                continue;

                            nextNode.add(new Node(nextI,nextJ,nextLength,true));
                            visited[nextI][nextJ][1] = true;
                        }

                    }
                    else{

                        if(map[nextI][nextJ] == 0){

                            if(visited[nextI][nextJ][0] == true)
                                continue;

                            nextNode.add(new Node(nextI,nextJ,nextLength,false));
                            visited[nextI][nextJ][0] = true;
                        }

                        if(map[nextI][nextJ] == 1){
                            if(visited[nextI][nextJ][1] == true)
                                continue;

                            nextNode.add(new Node(nextI,nextJ,nextLength,true));
                            visited[nextI][nextJ][1] = true;
                        }
                    }

                }
            }
        }
        if(isArrived == true){
            return minLength;
        }
        else
            return -1;
    }

    public static void main(String args[]) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        System.out.println(getAnswer());
    }

}
