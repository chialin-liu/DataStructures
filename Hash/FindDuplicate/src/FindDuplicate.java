import java.util.HashMap;
import java.util.Map;

public class FindDuplicate {
    public int findstring(String s){
        char []tmp=s.toCharArray();
        Map<Character,Integer> set = new HashMap<>();
        int countA=0;
        int max=0;
        int remain=0;
        int index=0;
        for(int i=0;i<s.length();i++){
            if(set.containsKey(tmp[i])){
                if(countA>max){
                    max=countA;
                }
                index=set.get(tmp[i]);
                remain=i-index-1;
                if(countA>remain){
                    countA=remain+1;
                }
                else{
                    countA++;
                }
                set.put(tmp[i],i);
            }
            else{
                countA++;
                set.put(tmp[i],i);
            }

        }
        if(countA>max){
            return countA;
        }
        else{
            return max;
        }
    }
    public static void main(String[] args){
        //String s= "abcabcbb";
        //String s= "pwwkew";
        String s= "abbac";
        FindDuplicate f = new FindDuplicate();
        int num=f.findstring(s);
        System.out.println(num);
    }
}
