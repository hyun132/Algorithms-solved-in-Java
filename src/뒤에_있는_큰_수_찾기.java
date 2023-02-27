import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        Arrays.fill(answer,-1);

        PriorityQueue<Integer> arr = new PriorityQueue<>(Comparator.comparing(it-> numbers[it]));

        for(int i=0;i<numbers.length;i++){
            while (arr.size()>0 && numbers[arr.peek()] < numbers[i]){
                answer[arr.poll()] = numbers[i];
            }
            arr.offer(i);
        }

        return answer;
    }
}
