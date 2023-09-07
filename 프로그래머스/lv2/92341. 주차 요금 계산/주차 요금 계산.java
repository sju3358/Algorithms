import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Solution {

    private class Car{

        public int inTime;
        public int parkingTime;

        public Car(){
            inTime = -1;
            parkingTime = 0;
        }
    }

    private Car[] carDB;
    private Set<Integer> carHistory;

    private int baseFeeTime;
    private int baseFee;
    private int unitFeeTime;
    private int unitFee;

    private void init(){
        carDB = new Car[10000];
        for(int i = 0; i < 10000; i++){
            carDB[i] = new Car();
        }
        carHistory = new TreeSet<>();
    }

    private int toMinute(String time){
        StringTokenizer st = new StringTokenizer(time, ":");
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());
        return 60*hour + minute;
    }


    private int calculateFee(int parkingTime){
        if(parkingTime <= baseFeeTime){
           return baseFee;
        } else{

            int time = parkingTime - baseFeeTime;
            double unitTime = (double)time / unitFeeTime;

            return (int)(baseFee + Math.ceil(unitTime)*unitFee);
        }
    }

    public int[] solution(int[] fees, String[] records) {


        init();

        baseFeeTime = fees[0];
        baseFee = fees[1];
        unitFeeTime = fees[2];
        unitFee=fees[3];

        for(int i = 0; i < records.length; i++){
            StringTokenizer st = new StringTokenizer(records[i]);

            String time = st.nextToken();
            int carNum = Integer.parseInt(st.nextToken());
            String code = st.nextToken();

            carHistory.add(carNum);

            if(code.equals("IN")){
                carDB[carNum].inTime = toMinute(time);
            } else if(code.equals("OUT")){
                carDB[carNum].parkingTime += (toMinute(time) - carDB[carNum].inTime);
                carDB[carNum].inTime = -1;
            }

        }

        int[] answer = new int[carHistory.size()];
        int sizeOfAnswer = 0;


        for(int carNum : carHistory){

            if(carDB[carNum].inTime != -1){
                carDB[carNum].parkingTime += 1439 - carDB[carNum].inTime;
            }


            answer[sizeOfAnswer++] = calculateFee( carDB[carNum].parkingTime);
        }

        return answer;
    }

    public static void main(String args[]){
        new Solution().solution(new int[]{120, 0, 60, 591}, new String[]{"16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN"});
    }
}