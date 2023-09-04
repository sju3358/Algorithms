import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Solution {

    private class Message{
        String code;
        String uuid;

        public Message(String code, String uuid) {
            this.code = code;
            this.uuid = uuid;
        }

        public String getUuid() {
            return uuid;
        }

        public String toString(String nickname){

            if(this.code.equals("Enter") == true){
                return nickname+"님이 들어왔습니다.";
            } else {
                return nickname+"님이 나갔습니다.";
            }


        }
    }

    private Map<String, String> userNicknames = new HashMap<>();

    public String[] solution(String[] records) {
        ArrayList<Message> messages = new ArrayList<>();



        for(String record : records){
            StringTokenizer st = new StringTokenizer(record);

            String code = "";
            String uuid = "";
            String nickname = "";

            code = st.nextToken();

            if(code.equals("Leave") == true){
                uuid= st.nextToken();
            } else {
                uuid = st.nextToken();
                nickname = st.nextToken();
            }


            if(code.equals("Enter") || code.equals("Leave"))
                messages.add(new Message(code,uuid));

            if(code.equals("Enter") || code.equals("Change"))
                userNicknames.put(uuid,nickname);

        }

        String[] result = new String[messages.size()];
        for(int i = 0; i < result.length; i++){
            Message message = messages.get(i);
            result[i] = message.toString(userNicknames.get(message.getUuid()));
        }
        return result;
    }




    public static void main(String args[]){
        String[] result = new Solution().solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"});
        System.out.println(Arrays.toString(result));
    }
}