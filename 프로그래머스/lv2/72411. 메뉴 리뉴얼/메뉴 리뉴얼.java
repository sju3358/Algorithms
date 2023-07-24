import java.util.*;

class Solution {

    private static boolean[][] orderInfos;
    private static ArrayList<String> menuList = new ArrayList<>();
    private int maxCount = 0;
    private Set<String> tempMenuList;

    private char[] alpahbet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

    public boolean check(int[] combination, boolean[] orderInfo){
        for(int i = 0; i < combination.length; i++){
            if(orderInfo[combination[i]] == false)
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
                menu = menu + alpahbet[combination[i]];


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

            for(int i = curIndex; i < 26; i++){
                combination[curLength] = i;
                makeCombination(curLength+1, combination);
            }
        }
    }

    public String[] solution(String[] orders, int[] course) {

        orderInfos = new boolean[orders.length][26];

        for(int i = 0; i < orders.length; i++){
            String order = orders[i];
            for(int j = 0; j < order.length(); j++)
                orderInfos[i][order.charAt(j) - 'A'] = true;
        }

        for(int i = 0; i < course.length; i++){
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