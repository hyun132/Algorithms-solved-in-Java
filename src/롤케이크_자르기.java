import java.util.HashMap;
import java.util.HashSet;

class Solution {
   public static int solution(int[] topping) {
        HashMap<Integer,Integer> a = new HashMap();
        HashSet<Integer> b = new HashSet<>();

        for(int num : topping){
            if(!a.containsKey(num)){
                a.put(num,0);
            }
            a.put(num,a.get(num)+1);
        }

        int i=0;
        int answer = 0;
        while (b.size()<=a.size() && i<topping.length){
            //a
            if(a.get(topping[i]) == 1){
                a.remove(topping[i]);
            }else a.put(topping[i],a.get(topping[i])-1);
            b.add(topping[i]);
            i++;
            if(a.size() == b.size()) answer++;
        }
        return answer;
    }
}
