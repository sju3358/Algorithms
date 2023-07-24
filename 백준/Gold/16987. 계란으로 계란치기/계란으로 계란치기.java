import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br;
    private static StringTokenizer st;

    private static class Egg{
        public int state;
        public int weight;

        public Egg(int state, int weight) {
            this.state = state;
            this.weight = weight;
        }
    }

    private static int answer = -1;


    public static void solution(int curEggIndex, Egg[] eggList){

        if(curEggIndex == eggList.length){

            int brokenEggs = 0;
            for(int i = 0; i <eggList.length; i++)
                if(eggList[i].state <= 0)
                    brokenEggs += 1;
            answer = Math.max(answer,brokenEggs);

        } else{

            if(eggList[curEggIndex].state <= 0)
                solution(curEggIndex+1, eggList);
            else {

                boolean isBroken = false;

                for (int i = 0; i < eggList.length; i++) {

                    if (i == curEggIndex)
                        continue;

                    if (eggList[i].state <= 0)
                        continue;

                    eggList[i].state -= eggList[curEggIndex].weight;
                    eggList[curEggIndex].state -= eggList[i].weight;
                    isBroken = true;
                    solution(curEggIndex + 1, eggList);
                    eggList[i].state += eggList[curEggIndex].weight;
                    eggList[curEggIndex].state += eggList[i].weight;
                }

                if(isBroken == false)
                    solution(curEggIndex+1,eggList);
            }
        }
    }

    public static void main(String args[]) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());

        Egg[] eggList = new Egg[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int state = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            eggList[i] = new Egg(state, weight);
        }
        solution(0, eggList);
        System.out.println(answer);
    }

}