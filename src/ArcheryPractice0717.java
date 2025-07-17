import java.util.Arrays;

class Solution {
    int[] myScores = new int[11];
    int[] info;
    int maxDiff = 0;
    int[] answer = {};
    int n = 0;
    public int[] solution(int n, int[] info) {
        this.info = info;
        this.n = n;
 
        dfs(0,0);

        if(myScores.length == 0 || maxDiff <= 0) return new int[]{-1};
        return answer;
    }
    
    void dfs(int no,int start){
        if(no>=n){
            int apeach = 0;
            int lion = 0;
            for(int i=0; i<=10;i++){
                if(info[i]>=myScores[i] && info[i]>0) apeach += 10-i;
                else if(info[i]<myScores[i]) lion += 10 - i;
            }
            
            if(lion - apeach > maxDiff){
                maxDiff = lion-apeach;
                answer = Arrays.copyOf(myScores,11);
            }
            return;
        }
        
        for(int i=10-start;i>=0;i--){
            myScores[i] +=1;
            if(start<=10) dfs(no+1,10-i);
            myScores[i] -=1;
        }
    }
}
