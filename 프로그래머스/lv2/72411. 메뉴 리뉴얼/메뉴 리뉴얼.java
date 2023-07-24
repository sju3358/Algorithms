import java.util.*;

class Solution {

    private static boolean[][] orderInfos;
    private static ArrayList<String> menuList = new ArrayList<>();
    private static List<Character> orderList = new ArrayList<>();


    private boolean[] check = new boolean[26];
    private char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};


    private int maxCount = 0;
    private Set<String> tempMenuList;


    public boolean check(int[] combination, boolean[] orderInfo){
        for(int i = 0; i < combination.length; i++){
            if(orderInfo[orderList.get(combination[i]) - 'A'] == false)
                return false;
        }
        return true;
    }

    public void makeCombination(int curLength, int[] combination){
        if(curLength == combination.length){
            int count = 0;

            for(int i = 0; i < orderInfos.length; i++){
                if(check(combination, orderInfos[i]) == true)
                    count++;
            }

            if(count < 2)
                return;

            String menu = "";
            for(int i = 0; i < combination.length; i++)
                menu = menu + orderList.get(combination[i]);


            if(count > maxCount){
                maxCount = count;
                tempMenuList.clear();
                tempMenuList.add(menu);
            } else if(count == maxCount){
                tempMenuList.add(menu);
            }

        } else {
            int curIndex;
            if(curLength != 0)
                curIndex = combination[curLength-1]+1;
            else
                curIndex = 0;

            for(int i = curIndex; i < orderList.size(); i++){
                combination[curLength] = i;
                makeCombination(curLength+1, combination);
            }
        }
    }

    public String[] solution(String[] orders, int[] course) {

        orderInfos = new boolean[orders.length][26];

        for(int i = 0; i < orders.length; i++){
            String order = orders[i];
            for(int j = 0; j < order.length(); j++) {
                int index = order.charAt(j) - 'A';
                orderInfos[i][index] = true;
                check[index] = true;
            }
        }

        for(int i = 0; i <check.length; i++)
            if(check[i] == true)
                orderList.add(alphabet[i]);


        for(int i = 0; i < course.length; i++){

            int orderCount = 0;
            for(int j = 0; j < orderInfos.length; j++)
                if ( orderInfos[j].length >= course[i])
                    orderCount++;

            if(orderCount < 2)
                continue;

            maxCount = 0;
            int N = course[i];
            int[] combination = new int[N];
            tempMenuList = new HashSet<>();
            makeCombination(0,combination);

            for(String menu : tempMenuList)
                menuList.add(menu);
        }

        String[] answer = new String[menuList.size()];
        menuList.toArray(answer);
        Arrays.sort(answer);
        return answer;
    }

    public static void main(String args[]){
        System.out.println(Arrays.toString(new Solution().solution(
                new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"},
                new int[]{2,3,5}
        )));
    }
}