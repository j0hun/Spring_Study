import java.util.*;
public class Main
{
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}"));

    }
    static class Solution {
        public int[] solution(String s) {
            Map<String,Integer> map = new HashMap<>();
            char[] charr = s.toCharArray();
            String str = "";
            for(char ch : charr){
                if (ch >= '0' && ch <= '9'){
                    if(s.equals("")){
                        str = String.valueOf(ch);
                    }
                    else{
                        str += String.valueOf(ch);
                    }
                }
                else{
                    if (!str.equals("")){
                        map.put(str,map.getOrDefault(str,0) + 1);
                        str = "";
                    }
                }
            }
            List<String> keyList = new ArrayList<>(map.keySet());
            keyList.sort((o1,o2) -> map.get(o2) - map.get(o1));
            int[] result = new int[keyList.size()];
            for(int i=0;i<keyList.size();i++){
                result[i] = Integer.valueOf(keyList.get(i));
            }
            return result;
        }
    }
}
